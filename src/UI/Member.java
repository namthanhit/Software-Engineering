/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Class.BranchActivity;
import Class.PartyMember;
import Class.Reward;
import Class.User;
import Database.ListBranchActivity;
import Database.ListPartyMember;
import Database.ListRewardPartyMember;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Class.Discipline;
import Class.EvalRequest;
import Class.SignBranchActivity;
import Class.TransferOut;
import Database.Insert_OutGroup;
import Database.Insert_TransferOut_InDatabase;
import Database.ListDisciplinePartyMember;
import Database.ListEvalRequest;
import Database.List_Sign_Member;
import Database.List_TransferOut_By_PartymemberID;
import java.util.Date;
/**
 *
 * @author User
 */
public class Member extends javax.swing.JFrame {
    public User user;
    
    List<PartyMember> listPartyMember = new ArrayList<>();
    List<SignBranchActivity> listSignBranchActivity = new ArrayList<>();
    List<Reward> listReward =  new ArrayList<>();
    List<Discipline> listDiscipline = new ArrayList<>();
    List<TransferOut> listTransferOut = new ArrayList<>();
    List<EvalRequest> listEvalRequest = new ArrayList<>();
    
    private static int posTransferOut = 0;
    private static int posBranchActy = 0;
    
    public Member(){
        initComponents();
    }
    
    public Member(User user) {
        initComponents();
        
        this.user = user;
        
        cardTrangChu.setVisible(true);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(false);
        
        this.jLabelNameAcc.setText(ListPartyMember.getMemberNameById(user.getPartyMemberId()));
        
        listPartyMember = ListPartyMember.getAllPartyMembers();
        
        String orgID = ListBranchActivity.getPartOrgIdByMemberId(user.getPartyMemberId());
        
        listSignBranchActivity = List_Sign_Member.getBranchActivitiesByIdMember(user.getPartyMemberId());
        
        listReward = ListRewardPartyMember.getBranchActivitiesByOrgId(user.getPartyMemberId());
        
        listDiscipline = ListDisciplinePartyMember.getDisciplineByOrgId(user.getPartyMemberId());
        
        listTransferOut = List_TransferOut_By_PartymemberID.getTransferOutByPartymemberID(user.getPartyMemberId());
        
        listEvalRequest = ListEvalRequest.getEvalRequestsByMemberId(user.getPartyMemberId());
        
        // block textfield
        jTextFieldNameActivity.setEditable(false);
        jTextFieldEndDateActivity.setEditable(false);
        jTextFieldStartDateActivity.setEditable(false);
        jTextFieldIDActivity.setEditable(false);
        jTextFieldStatusActivity.setEditable(false);
        jEditorPaneDescpitActivity.setEditable(false);
    }
    
    
    public void view() {
        // Tìm kiếm trong danh sách các PartyMember dựa trên user.getId()
        PartyMember currentMember = null;
        
        for (PartyMember member : listPartyMember) {
            if (member.getId().equals(user.getPartyMemberId())) { // So sánh ID của User và PartyMember
                currentMember = member;
                break;
            }
        }
        
        if (currentMember != null) {
            // Gán các giá trị của currentMember vào các JTextField tương ứng
            this.jTextFieldFullName.setText(currentMember.getFullName());
            this.jTextFieldIdMember.setText(currentMember.getId());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String birthDateString = formatter.format(currentMember.getBirthDate());
            String joinDateString = formatter.format(currentMember.getJoinDate());

            this.jTextFieldBirthDay.setText(birthDateString);
            this.jTextFieldDateJoin.setText(joinDateString);
            this.jTextFieldEmail.setText(currentMember.getEmail());
            this.jTextFieldPositon.setText(currentMember.getPosition());
            this.jTextFieldPhoneNumber.setText(currentMember.getPhoneNumber());
            this.jTextFieldAddress.setText(currentMember.getAddress());
            
            // Gán avatar nếu có (giả sử avatar là kiểu Icon hoặc ImageIcon)
            this.jLabelAvatar.setIcon(currentMember.getAvatar());
            this.jEditorPane_DetailMember.setText(currentMember.getDetail());
        } else {
            // Nếu không tìm thấy thành viên trong listPartyMember
            JOptionPane.showMessageDialog(null, "Không tìm thấy thành viên với ID: " + user.getPartyMemberId());
        }
    }
    
    
    public void ViewBranchActivity() {
        if (!listSignBranchActivity.isEmpty()) {
            SignBranchActivity currentActivity = listSignBranchActivity.get(posBranchActy);
            
            String sd = List_Sign_Member.getDateStartByIdBA(currentActivity.getIdBA());
            String ed = List_Sign_Member.getDateEndByIdBA(currentActivity.getIdBA());
            String name = List_Sign_Member.getNameAByIdBA(currentActivity.getIdBA());
            String detail = List_Sign_Member.getDetailByIdBA(currentActivity.getIdBA());
            
            this.jTextFieldNameActivity.setText(name);
            this.jTextFieldIDActivity.setText(currentActivity.getId());

//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String birthDateString = formatter.format(currentActivity.getStartDate());
//            String joinDateString = formatter.format(currentActivity.getEndDate());

            this.jTextFieldStartDateActivity.setText(sd);
            this.jTextFieldEndDateActivity.setText(ed);
            this.jTextFieldStatusActivity.setText(currentActivity.getStatus());
            this.jEditorPaneDescpitActivity.setText(detail);
            
        } else {
            // Xử lý khi không có hoạt động nào
            JOptionPane.showMessageDialog(null, "Không có hoạt động nào cho tổ chức này.");
        }
    }
    public void ViewTableBranchActivity() {
        DefaultTableModel model = (DefaultTableModel) this.jTableBranchActivity.getModel();
        model.setNumRows(0);
        for (SignBranchActivity ba : listSignBranchActivity) {
            String sd = List_Sign_Member.getDateStartByIdBA(ba.getIdBA());
            String ed = List_Sign_Member.getDateEndByIdBA(ba.getIdBA());
            String name = List_Sign_Member.getNameAByIdBA(ba.getIdBA());
            model.addRow(new Object[]{ba.getIdBA(), name, sd, ed, ba.getStatus()});
        }
    }
    
    public void ViewTableReward(){
        DefaultTableModel model = (DefaultTableModel) this.jTableKhenThuong.getModel();
        model.setNumRows(0);
        for (Reward lr : listReward) {
            model.addRow(new Object[]{lr.getId(),lr.getPartyMemberId() ,lr.getRewardDate() , lr.getDecisionMaker(), lr.getDescription()});
        }
    }
    
    public void ViewTableDiscipline(){
        DefaultTableModel model = (DefaultTableModel) this.jTableKyLuat.getModel();
        model.setNumRows(0);
        for (Discipline ld : listDiscipline) {
            model.addRow(new Object[]{ld.getId(),ld.getPartyMemberId() ,ld.getDisciplineDate() , ld.getDecisionMaker(), ld.getDescription()});
        }
    }
    
    
    public void ViewTransferOut(){
        TransferOut to = listTransferOut.get(posTransferOut);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Định dạng: Năm-Tháng-Ngày
        String dateTransferOut = dateFormat.format(to.getTransferDate());
        this.textFieldDateTransfer.setText(dateTransferOut);
        this.textFieldIdOrgTransfer.setText(to.getOrgId());
        this.editorPaneReasonTranfer.setText(to.getReason());
        //this.textFieldStatusTransferOut.setText(to.getStatus());
        
        OnOffTransferOut(true, false, false);
    }
    public void ViewTableTransferOut(){
        DefaultTableModel model = (DefaultTableModel) this.jTableTransferOut.getModel();
        model.setNumRows(0);
        for (TransferOut ld : listTransferOut) {
            model.addRow(new Object[]{ld.getOrgId(), ld.getPartyMemberId(), ld.getTransferDate(), ld.getReason(), ld.getStatus()});
        }
    }
    
    
    public void ViewTableER(){
        DefaultTableModel model = (DefaultTableModel) this.jTableOut.getModel();
        model.setNumRows(0);
        for (EvalRequest ld : listEvalRequest) {
            model.addRow(new Object[]{ld.getOrgId(), ld.getDate(), ld.getReason(), ld.getStatus()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jplSlideMenu = new javax.swing.JPanel();
        lblThanhTich = new javax.swing.JLabel();
        lblTrangChu = new javax.swing.JLabel();
        lblSinhHoat = new javax.swing.JLabel();
        lblYeuCau = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDangXuat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDangVien = new javax.swing.JLabel();
        jLabelNameAcc = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BackgroundMenu = new javax.swing.JLabel();
        jplTitle = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jplMain = new javax.swing.JPanel();
        cardTrangChu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cardSinhHoat = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableBranchActivity = new javax.swing.JTable();
        jTextField_SearchBA = new javax.swing.JTextField();
        jButton_SearchBA = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNameActivity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldIDActivity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldStartDateActivity = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldEndDateActivity = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jEditorPaneDescpitActivity = new javax.swing.JEditorPane();
        jTextFieldStatusActivity = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jButton_Cancel_BranchActivity = new javax.swing.JButton();
        jButton_SignIn_BranchActivity = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        cardYeuCau = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        textFieldIdOrgTransfer = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        textFieldDateTransfer = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        editorPaneReasonTranfer = new javax.swing.JEditorPane();
        jLabel51 = new javax.swing.JLabel();
        buttonCreateNewTransferOut = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableTransferOut = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonCancelTranferOut = new javax.swing.JButton();
        buttonSentTransferOut = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        textDateOut = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        textIdOut = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        editorPaneOut = new javax.swing.JEditorPane();
        buttonYCChuyen2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableOut = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        buttonYCChuyen3 = new javax.swing.JButton();
        cardDangVien = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelAvatar = new javax.swing.JLabel();
        jTextFieldFullName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldIdMember = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldBirthDay = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldDateJoin = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextFieldPhoneNumber = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldPositon = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane_DetailMember = new javax.swing.JEditorPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cardThanhTich = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableKyLuat = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableKhenThuong = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplSlideMenu.setBackground(new java.awt.Color(255, 204, 0));
        jplSlideMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jplSlideMenu.setPreferredSize(new java.awt.Dimension(190, 590));
        jplSlideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThanhTich.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblThanhTich.setForeground(new java.awt.Color(255, 255, 255));
        lblThanhTich.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThanhTich.setText("Thành Tích");
        lblThanhTich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThanhTichMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblThanhTich, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, 30));

        lblTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        lblTrangChu.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangChu.setText("Trang Chủ");
        lblTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrangChuMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));

        lblSinhHoat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblSinhHoat.setForeground(new java.awt.Color(255, 255, 255));
        lblSinhHoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSinhHoat.setText("Sinh Hoạt");
        lblSinhHoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSinhHoatMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblSinhHoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 30));

        lblYeuCau.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblYeuCau.setForeground(new java.awt.Color(255, 255, 255));
        lblYeuCau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYeuCau.setText("Yêu Cầu");
        lblYeuCau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYeuCauMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblYeuCau, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, 30));
        jplSlideMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 452, 210, 10));

        lblDangXuat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 51, 0));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("Đăng Xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 200, 30));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Giới Thiệu");
        jplSlideMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 200, 30));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Trợ Giúp");
        jplSlideMenu.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 200, 30));

        lblDangVien.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangVien.setForeground(new java.awt.Color(255, 255, 255));
        lblDangVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangVien.setText("Đảng Viên");
        lblDangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangVienMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblDangVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 200, 30));

        jLabelNameAcc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelNameAcc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNameAcc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameAcc.setText("Bui Ngoc Duc");
        jplSlideMenu.add(jLabelNameAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-user.png"))); // NOI18N
        jplSlideMenu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));
        jplSlideMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 20));

        BackgroundMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackgroundMenu.jpeg"))); // NOI18N
        jplSlideMenu.add(BackgroundMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 650));

        jPanel1.add(jplSlideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 650));

        jplTitle.setBackground(new java.awt.Color(255, 0, 0));

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 1, 70)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("☭");

        jLabel39.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 0));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("ĐẢNG CỘNG SẢN VIỆT NAM QUANG VINH");

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 1, 70)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("☭");

        javax.swing.GroupLayout jplTitleLayout = new javax.swing.GroupLayout(jplTitle);
        jplTitle.setLayout(jplTitleLayout);
        jplTitleLayout.setHorizontalGroup(
            jplTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplTitleLayout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jLabel39)
                .addGap(126, 126, 126)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jplTitleLayout.setVerticalGroup(
            jplTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplTitleLayout.createSequentialGroup()
                .addGroup(jplTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplTitleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jplTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 950, 70));

        jplMain.setBackground(new java.awt.Color(255, 255, 255));
        jplMain.setLayout(new java.awt.CardLayout());

        cardTrangChu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/images (1).jpeg"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel14.setText("Nâng cao chất lượng công tác Đảng từ Sổ tay đảng viên điện tử");

        jLabel15.setText("Sáng 8/5, Phó Bí thư Thường trực Tỉnh ủy, Trưởng đoàn ĐBQH tỉnh, Trưởng Ban Chỉ ");
        jLabel15.setToolTipText("");

        jLabel26.setText("đạo phần mềm “Sổ tay đảng viên điện tử” Đảng bộ tỉnh Đặng Ngọc Huy và Trưởng\n");

        jLabel27.setText("ban Tổ chức Tỉnh ủy Lữ Ngọc Bình chủ trì Hội nghị...\n");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/news2 (1).jpg"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel19.setText("Hà Nội thừa nhận có tình trạng đầu cơ, thổi giá gây nhiễu loạn đấu giá đất");

        jLabel20.setText("Sau quá trình triển khai đấu giá đất ở hai huyện Thanh Oai và Hoài Đức, Sở Tài nguyên");
        jLabel20.setToolTipText("");

        jLabel45.setText("và Môi trường Hà Nội thừa nhận nhiều bất cập, trong đó có tình trạng đầu cơ,");

        jLabel48.setText("thổi giá làm nhiễu loạn thị trường...");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel16);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/news3 (1).jpg"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel21.setText("Thủ tướng kêu gọi doanh nghiệp");

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel22.setText("cùng xây các công trình tầm cỡ");

        jLabel57.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel57.setText("của đất nước.");

        jLabel58.setText("Thủ tướng kêu gọi doanh nghiệp cùng");

        jLabel59.setText("xây các công trình tầm cỡ của đất...");

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/new04 (1).jpg"))); // NOI18N

        jLabel61.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel61.setText("Bộ TN&MT đề xuất xây dựng bảng");

        jLabel62.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel62.setText("giá đất đến từng thửa đất");

        jLabel63.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel63.setText("Bộ Tài nguyên và Môi trường đang");

        jLabel64.setText("dự thảo Thông tư quy định chi tiết ");

        jLabel65.setText("về xây dựng, điều chỉnh, sửa đổi, bổ sung...");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 38, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel17);

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 51, 51));
        jLabel28.setText("Trang Chủ:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel4.setText("Xin Thôi Công tác:");

        javax.swing.GroupLayout cardTrangChuLayout = new javax.swing.GroupLayout(cardTrangChu);
        cardTrangChu.setLayout(cardTrangChuLayout);
        cardTrangChuLayout.setHorizontalGroup(
            cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardTrangChuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        cardTrangChuLayout.setVerticalGroup(
            cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardTrangChuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardTrangChuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jplMain.add(cardTrangChu, "card2");

        cardSinhHoat.setBackground(new java.awt.Color(255, 255, 255));
        cardSinhHoat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 51, 51));
        jLabel40.setText("Sinh Hoạt Chi Bộ");
        cardSinhHoat.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, 30));

        jTableBranchActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Buổi Sinh Hoạt", "Tên Buổi Sinh Hoạt", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ));
        jTableBranchActivity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBranchActivityMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableBranchActivity);

        cardSinhHoat.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 365, 860, 180));
        cardSinhHoat.add(jTextField_SearchBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 150, -1));

        jButton_SearchBA.setBackground(new java.awt.Color(0, 204, 255));
        jButton_SearchBA.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_SearchBA.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SearchBA.setText("Tìm");
        jButton_SearchBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchBAActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_SearchBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 61, -1));

        jLabel5.setText("Tên Buổi Sinh Hoạt:");
        cardSinhHoat.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 69, -1, -1));

        jTextFieldNameActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActivityActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jTextFieldNameActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 92, 250, -1));

        jLabel8.setText("ID Buổi Sinh Hoạt:");
        cardSinhHoat.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 69, -1, -1));
        cardSinhHoat.add(jTextFieldIDActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 92, 120, -1));

        jLabel9.setText("Ngày bắt đầu:");
        cardSinhHoat.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 127, 106, -1));
        cardSinhHoat.add(jTextFieldStartDateActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 150, 106, -1));

        jLabel23.setText("Ngày kết thúc:");
        cardSinhHoat.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 127, 106, -1));
        cardSinhHoat.add(jTextFieldEndDateActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 150, 106, -1));

        jLabel42.setText("Mô tả:");
        cardSinhHoat.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 186, -1, -1));

        jScrollPane10.setViewportView(jEditorPaneDescpitActivity);

        cardSinhHoat.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 209, 484, 124));
        cardSinhHoat.add(jTextFieldStatusActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 151, 120, -1));

        jLabel43.setText("Trạng thái:");
        cardSinhHoat.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 127, -1, -1));

        jButton_Cancel_BranchActivity.setBackground(new java.awt.Color(255, 51, 0));
        jButton_Cancel_BranchActivity.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_Cancel_BranchActivity.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cancel_BranchActivity.setText("Huỷ");
        jButton_Cancel_BranchActivity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_Cancel_BranchActivityMouseClicked(evt);
            }
        });
        cardSinhHoat.add(jButton_Cancel_BranchActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 124, -1));

        jButton_SignIn_BranchActivity.setBackground(new java.awt.Color(51, 204, 0));
        jButton_SignIn_BranchActivity.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_SignIn_BranchActivity.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SignIn_BranchActivity.setText("Đăng Ký ");
        jButton_SignIn_BranchActivity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SignIn_BranchActivityMouseClicked(evt);
            }
        });
        jButton_SignIn_BranchActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SignIn_BranchActivityActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_SignIn_BranchActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 124, -1));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardSinhHoat.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 590));

        jplMain.add(cardSinhHoat, "card3");

        cardYeuCau.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 0));
        jLabel16.setText("Xin Chuyển Công Tác");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 190, 30));
        jPanel2.add(textFieldIdOrgTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 108, -1));

        jLabel49.setText("Mã Tổ Chức Chuyển Đến:");
        jPanel2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 93, -1, -1));

        jLabel50.setText("Ngày Chuyển:");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 84, -1));
        jPanel2.add(textFieldDateTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 108, -1));

        jScrollPane11.setViewportView(editorPaneReasonTranfer);

        jPanel2.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 597, 130));

        jLabel51.setText("Chi tiết:");
        jPanel2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        buttonCreateNewTransferOut.setBackground(new java.awt.Color(0, 153, 0));
        buttonCreateNewTransferOut.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        buttonCreateNewTransferOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonCreateNewTransferOut.setText("Yêu Cầu Mới");
        buttonCreateNewTransferOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateNewTransferOutActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCreateNewTransferOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));

        jTableTransferOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Đảng Viên", "Mã Tổ Chức", "Ngày Chuyển", "Lý Do", "Trạng Thái"
            }
        ));
        jTableTransferOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTransferOutMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableTransferOut);

        jPanel2.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 770, 100));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Yêu Cầu Đã Gửi:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 120, -1));

        jButtonCancelTranferOut.setBackground(new java.awt.Color(255, 51, 0));
        jButtonCancelTranferOut.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonCancelTranferOut.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelTranferOut.setText("Huỷ Yêu Cầu");
        jButtonCancelTranferOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelTranferOutMouseClicked(evt);
            }
        });
        jPanel2.add(jButtonCancelTranferOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        buttonSentTransferOut.setBackground(new java.awt.Color(0, 153, 0));
        buttonSentTransferOut.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        buttonSentTransferOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonSentTransferOut.setText("Gửi Yêu Cầu");
        buttonSentTransferOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSentTransferOutMouseClicked(evt);
            }
        });
        buttonSentTransferOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSentTransferOutActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSentTransferOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        jPanel2.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 550));

        jTabbedPane1.addTab("Xin chuyển công tác", jPanel2);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 0));
        jLabel18.setText("Xin Rời Khỏi Đảng");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 160, 30));
        jPanel5.add(textDateOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 90, 108, -1));

        jLabel53.setText("Ngày Chuyển:");
        jPanel5.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 93, 84, -1));
        jPanel5.add(textIdOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 90, 108, -1));

        jLabel54.setText("Mã Tổ Chức:");
        jPanel5.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 93, -1, -1));

        jLabel55.setText("Lý Do:");
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jScrollPane12.setViewportView(editorPaneOut);

        jPanel5.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 597, 110));

        buttonYCChuyen2.setBackground(new java.awt.Color(102, 204, 0));
        buttonYCChuyen2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        buttonYCChuyen2.setForeground(new java.awt.Color(255, 255, 255));
        buttonYCChuyen2.setText("Gửi Yêu Cầu");
        buttonYCChuyen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonYCChuyen2MouseClicked(evt);
            }
        });
        buttonYCChuyen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYCChuyen2ActionPerformed(evt);
            }
        });
        jPanel5.add(buttonYCChuyen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 120, -1));

        jButton1.setBackground(new java.awt.Color(255, 51, 0));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Huỷ");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 120, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Yêu Cầu Đã Gửi:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 170, -1));

        jTableOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Tổ Chức", "Ngày Chuyển", "Chi Tiet", "Trạng Thái"
            }
        ));
        jScrollPane9.setViewportView(jTableOut);

        jPanel5.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 770, 70));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        jPanel5.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 550));

        buttonYCChuyen3.setBackground(new java.awt.Color(102, 204, 0));
        buttonYCChuyen3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        buttonYCChuyen3.setForeground(new java.awt.Color(255, 255, 255));
        buttonYCChuyen3.setText("Gửi Yêu Cầu");
        buttonYCChuyen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYCChuyen3ActionPerformed(evt);
            }
        });
        jPanel5.add(buttonYCChuyen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 120, -1));

        jTabbedPane1.addTab("Xin rời khỏi Đảng", jPanel5);

        javax.swing.GroupLayout cardYeuCauLayout = new javax.swing.GroupLayout(cardYeuCau);
        cardYeuCau.setLayout(cardYeuCauLayout);
        cardYeuCauLayout.setHorizontalGroup(
            cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardYeuCauLayout.setVerticalGroup(
            cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardYeuCauLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jplMain.add(cardYeuCau, "card4");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabelAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 40, 50));
        jPanel4.add(jTextFieldFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 167, -1));

        jLabel17.setText("Họ và Tên:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jLabel29.setText("Mã Đảng viên:");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        jTextFieldIdMember.setToolTipText("");
        jPanel4.add(jTextFieldIdMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 140, -1));

        jLabel30.setText("Ngày Sinh:");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 80, -1));
        jPanel4.add(jTextFieldBirthDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 160, -1));

        jLabel31.setText("Ngày Vào Đảng:");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));
        jPanel4.add(jTextFieldDateJoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 137, -1));

        jLabel32.setText("Địa chỉ:");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, -1));
        jPanel4.add(jTextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 170, -1));

        jLabel33.setText("Email:");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, -1));
        jPanel4.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 167, -1));

        jLabel34.setText("Số điện thoại:");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));
        jPanel4.add(jTextFieldPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 128, -1));

        jLabel35.setText("Chức Vụ:");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));
        jPanel4.add(jTextFieldPositon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 128, -1));

        jLabel36.setText("Quy trình công tác:");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 290, -1));

        jScrollPane6.setViewportView(jEditorPane_DetailMember);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 730, 221));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông Tin Đảng Viên");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 290, -1));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        javax.swing.GroupLayout cardDangVienLayout = new javax.swing.GroupLayout(cardDangVien);
        cardDangVien.setLayout(cardDangVienLayout);
        cardDangVienLayout.setHorizontalGroup(
            cardDangVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(cardDangVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardDangVienLayout.setVerticalGroup(
            cardDangVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(cardDangVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jplMain.add(cardDangVien, "card5");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel37.setText("Khen Thưởng Đảng VIên Đã Có Thành Tích Tốt:");
        jPanel19.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 86, -1, 31));

        jTableKyLuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Ngày Quyết Định", "Người Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableKyLuat);

        jPanel19.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 360, 802, 190));

        jLabel38.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel38.setText("Kỷ Luật Đảng VIên Đã Có Những Sai Phạm:");
        jPanel19.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 330, -1, 31));

        jTableKhenThuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Ngày Quyết Định", "Người Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTableKhenThuong);

        jPanel19.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 802, 160));

        jLabel41.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 51, 51));
        jLabel41.setText("Khen Thưởng - Kỷ Luật:");
        jPanel19.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 28, -1, 40));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        jPanel19.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 590));

        javax.swing.GroupLayout cardThanhTichLayout = new javax.swing.GroupLayout(cardThanhTich);
        cardThanhTich.setLayout(cardThanhTichLayout);
        cardThanhTichLayout.setHorizontalGroup(
            cardThanhTichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardThanhTichLayout.setVerticalGroup(
            cardThanhTichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jplMain.add(cardThanhTich, "card6");

        jPanel1.add(jplMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 950, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        jplSlideMenu.setSize(0, y);
//        x = 0;
    }//GEN-LAST:event_formWindowOpened

    private void lblTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrangChuMouseClicked
        cardTrangChu.setVisible(true);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(false);
    }//GEN-LAST:event_lblTrangChuMouseClicked

    private void lblSinhHoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSinhHoatMouseClicked
        cardTrangChu.setVisible(false);
        cardSinhHoat.setVisible(true);
        cardYeuCau.setVisible(false);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(false);
        
        ViewBranchActivity();
        ViewTableBranchActivity();
    }//GEN-LAST:event_lblSinhHoatMouseClicked

    private void lblYeuCauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblYeuCauMouseClicked
        // TODO add your handling code here:
        cardTrangChu.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(true);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(false);
        
        ViewTableTransferOut();
        ViewTransferOut();
        ViewTableER();
    }//GEN-LAST:event_lblYeuCauMouseClicked

    private void lblDangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangVienMouseClicked
        // TODO add your handling code here:
        cardTrangChu.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangVien.setVisible(true);
        cardThanhTich.setVisible(false);
        view();
    }//GEN-LAST:event_lblDangVienMouseClicked

    private void lblThanhTichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThanhTichMouseClicked
        // TODO add your handling code here:
        cardTrangChu.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(true);
        
        ViewTableReward();
        ViewTableDiscipline();
    }//GEN-LAST:event_lblThanhTichMouseClicked

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void jTextFieldNameActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActivityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActivityActionPerformed

    
    
    public void OnOffTransferOut(boolean a, boolean b, boolean c)
    {   
        this.buttonCreateNewTransferOut.show(a);
        this.buttonSentTransferOut.show(b);
        this.jButtonCancelTranferOut.show(c);
    }
    private void buttonCreateNewTransferOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateNewTransferOutActionPerformed
        // TODO add your handling code here:
        OnOffTransferOut(false, true, true);
        
        this.textFieldIdOrgTransfer.setText("");
        this.textFieldDateTransfer.setText("");
        this.editorPaneReasonTranfer.setText("");
        
    }//GEN-LAST:event_buttonCreateNewTransferOutActionPerformed

    private void buttonYCChuyen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYCChuyen2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonYCChuyen2ActionPerformed

    private void buttonSentTransferOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSentTransferOutActionPerformed
        // TODO add your handling code here:
        String idMember = user.getPartyMemberId();
        String idOrg = this.textFieldIdOrgTransfer.getText();
        String status = "Chờ Duyệt";
        String date = this.textFieldDateTransfer.getText();

        // Chuyển đổi từ String sang java.sql.Date
        Date transferDate = java.sql.Date.valueOf(java.time.LocalDate.parse(date, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        String reason = this.editorPaneReasonTranfer.getText();

        //INSERT INTO TransferOut (id, partyMemberId, orgId, status, transferDate, reason)
        Insert_TransferOut_InDatabase addTransferOut = new Insert_TransferOut_InDatabase();
        addTransferOut.addTransferOutRecord(idMember, idOrg, status, date, reason);
        
        listTransferOut = List_TransferOut_By_PartymemberID.getTransferOutByPartymemberID(user.getPartyMemberId());
        JOptionPane.showMessageDialog(null, "Thành công!");
        ViewTransferOut();
        ViewTableTransferOut();
        
    }//GEN-LAST:event_buttonSentTransferOutActionPerformed

    private void jButtonCancelTranferOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelTranferOutMouseClicked
        // TODO add your handling code here:
        ViewTransferOut();
    }//GEN-LAST:event_jButtonCancelTranferOutMouseClicked

    private void jTableTransferOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTransferOutMouseClicked
        // TODO add your handling code here:
        posTransferOut = this.jTableTransferOut.getSelectedRow();
        ViewTransferOut();
    }//GEN-LAST:event_jTableTransferOutMouseClicked

    private void buttonYCChuyen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYCChuyen3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonYCChuyen3ActionPerformed

    private void jTableBranchActivityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBranchActivityMouseClicked
        // TODO add your handling code here:
        posBranchActy = this.jTableBranchActivity.getSelectedRow();
        ViewBranchActivity();
    }//GEN-LAST:event_jTableBranchActivityMouseClicked
    
    private void jButton_SignIn_BranchActivityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SignIn_BranchActivityMouseClicked
        // TODO add your handling code here:
        String idMember = user.getPartyMemberId();
        String orgID = ListBranchActivity.getPartOrgIdByMemberId(user.getPartyMemberId());
        String nameBA = this.jTextFieldNameActivity.getText();
        String idBA = this.jTextFieldIDActivity.getText();
        String startDate = this.jTextFieldStartDateActivity.getText();
        String endDate = this.jTextFieldEndDateActivity.getText();
        String status = this.jTextFieldStatusActivity.getText();
        String detail = this.jEditorPaneDescpitActivity.getText();
        
        
        if ("Chưa Đăng Ký".equals(status)){
            List_Sign_Member editBA = new List_Sign_Member();
            String updateStatus = "Chưa Hoàn Thành";
            editBA.updateSignBranchActivity(idBA, idMember, orgID, updateStatus);
            
            listSignBranchActivity = List_Sign_Member.getBranchActivitiesByIdMember(idBA);
            
            JOptionPane.showMessageDialog(null, "Bạn đã đăng ký sinh hoạt thành công!");
            
            ViewBranchActivity();
            ViewTableBranchActivity();
        }else{
            ViewBranchActivity();
            ViewTableBranchActivity();
            JOptionPane.showMessageDialog(null, "Bạn đã đăng ký sinh hoạt rồi!");
        }
        
    }//GEN-LAST:event_jButton_SignIn_BranchActivityMouseClicked

    private void buttonYCChuyen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonYCChuyen2MouseClicked
        // TODO add your handling code here:
        String date = this.textDateOut.getText();
        String reason = this.editorPaneOut.getText();
        String status = "Chờ Duyệt";
        String idMember = user.getPartyMemberId();
        String orgID = this.textIdOut.getText();
        
        if (!"".equals(date) && !"".equals(reason) && !"".equals(orgID)){
            Insert_OutGroup og = new Insert_OutGroup();
            og.addEvalRequestRecord(idMember, orgID, date, status, reason);

            listEvalRequest = ListEvalRequest.getEvalRequestsByMemberId(user.getPartyMemberId());
            ViewTableER();
            JOptionPane.showMessageDialog(null, "Thành công!");
        }else{
            JOptionPane.showMessageDialog(null, "Bạn cần điền hết các mục!");
        }
        
    }//GEN-LAST:event_buttonYCChuyen2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.textDateOut.setText("");
        this.textIdOut.setText("");
        this.editorPaneOut.setText("");
    }//GEN-LAST:event_jButton1MouseClicked

    private void buttonSentTransferOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSentTransferOutMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonSentTransferOutMouseClicked

    private void jButton_Cancel_BranchActivityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Cancel_BranchActivityMouseClicked
        // Get the necessary values
        String idMember = user.getPartyMemberId();
        String orgID = ListBranchActivity.getPartOrgIdByMemberId(user.getPartyMemberId());
        String nameBA = this.jTextFieldNameActivity.getText();
        String idBA = this.jTextFieldIDActivity.getText();
        String startDate = this.jTextFieldStartDateActivity.getText();
        String endDate = this.jTextFieldEndDateActivity.getText();
        String status = this.jTextFieldStatusActivity.getText();
        String detail = this.jEditorPaneDescpitActivity.getText();

        // Check if the current status is not "Chưa Đăng Ký"
        if (!"Chưa Đăng Ký".equals(status)) {
            // Show a confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(null, 
                "Bạn có chắc chắn muốn huỷ đăng ký sinh hoạt không?", 
                "Xác nhận huỷ", 
                JOptionPane.YES_NO_OPTION);

            // If the user clicks "Yes", proceed with the cancellation
            if (confirm == JOptionPane.YES_OPTION) {
//                ListBranchActivity editBA = new ListBranchActivity();
//                // Update status to "Chưa Đăng Ký"
//                String updateStatus = "Chưa Đăng Ký";
//                editBA.updateBranchActivity(idBA, idMember, nameBA, startDate, endDate, updateStatus, detail, orgID);
                List_Sign_Member editBA = new List_Sign_Member();
                String updateStatus = "Chưa Đăng Ký";
                editBA.updateSignBranchActivity(idBA, idMember, orgID, updateStatus);
                
                listSignBranchActivity = List_Sign_Member.getBranchActivitiesByIdMember(idBA);
                JOptionPane.showMessageDialog(null, "Bạn đã huỷ đăng ký sinh hoạt thành công!");

                ViewBranchActivity();
                ViewTableBranchActivity();
            } else {
                // If the user clicks "No", simply return
                JOptionPane.showMessageDialog(null, "Huỷ bỏ huỷ đăng ký.");
            }
        } else {
            ViewBranchActivity();
            ViewTableBranchActivity();
            JOptionPane.showMessageDialog(null, "Lỗi! Bạn chưa đăng ký!");
        }
    }//GEN-LAST:event_jButton_Cancel_BranchActivityMouseClicked

    private void jButton_SearchBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchBAActionPerformed
        // TODO add your handling code here:
        String id = this.jTextField_SearchBA.getText();
        
        SignBranchActivity activity = findActivityById(id);
        if (activity != null) {
            
            String sd = List_Sign_Member.getDateStartByIdBA(activity.getIdBA());
            String ed = List_Sign_Member.getDateEndByIdBA(activity.getIdBA());
            String name = List_Sign_Member.getNameAByIdBA(activity.getIdBA());
            String detail = List_Sign_Member.getDetailByIdBA(activity.getIdBA());
            
            this.jTextFieldNameActivity.setText(name);
            this.jTextFieldIDActivity.setText(activity.getIdBA());

//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String birthDateString = formatter.format(activity.getStartDate());
//            String joinDateString = formatter.format(activity.getEndDate());

            this.jTextFieldStartDateActivity.setText(sd);
            this.jTextFieldEndDateActivity.setText(ed);
            
            this.jEditorPaneDescpitActivity.setText(detail);
            
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy buổi sinh hoạt với ID này.");
            System.out.println("Không tìm thấy buổi sinh hoạt với ID này.");
        }

    }//GEN-LAST:event_jButton_SearchBAActionPerformed

    private void jButton_SignIn_BranchActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SignIn_BranchActivityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SignIn_BranchActivityActionPerformed
    public SignBranchActivity findActivityById(String id) {
        for (SignBranchActivity activity : listSignBranchActivity) {
            if (activity.getIdBA().equals(id)) {
                return activity;  // Trả về đối tượng nếu tìm thấy
            }
        }
        return null;  // Trả về null nếu không tìm thấy
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMenu;
    private javax.swing.JButton buttonCreateNewTransferOut;
    private javax.swing.JButton buttonSentTransferOut;
    private javax.swing.JButton buttonYCChuyen2;
    private javax.swing.JButton buttonYCChuyen3;
    private javax.swing.JPanel cardDangVien;
    private javax.swing.JPanel cardSinhHoat;
    private javax.swing.JPanel cardThanhTich;
    private javax.swing.JPanel cardTrangChu;
    private javax.swing.JPanel cardYeuCau;
    private javax.swing.JEditorPane editorPaneOut;
    private javax.swing.JEditorPane editorPaneReasonTranfer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelTranferOut;
    private javax.swing.JButton jButton_Cancel_BranchActivity;
    private javax.swing.JButton jButton_SearchBA;
    private javax.swing.JButton jButton_SignIn_BranchActivity;
    private javax.swing.JEditorPane jEditorPaneDescpitActivity;
    private javax.swing.JEditorPane jEditorPane_DetailMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JLabel jLabelNameAcc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableBranchActivity;
    private javax.swing.JTable jTableKhenThuong;
    private javax.swing.JTable jTableKyLuat;
    private javax.swing.JTable jTableOut;
    private javax.swing.JTable jTableTransferOut;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldBirthDay;
    private javax.swing.JTextField jTextFieldDateJoin;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndDateActivity;
    private javax.swing.JTextField jTextFieldFullName;
    private javax.swing.JTextField jTextFieldIDActivity;
    private javax.swing.JTextField jTextFieldIdMember;
    private javax.swing.JTextField jTextFieldNameActivity;
    private javax.swing.JTextField jTextFieldPhoneNumber;
    private javax.swing.JTextField jTextFieldPositon;
    private javax.swing.JTextField jTextFieldStartDateActivity;
    private javax.swing.JTextField jTextFieldStatusActivity;
    private javax.swing.JTextField jTextField_SearchBA;
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplSlideMenu;
    private javax.swing.JPanel jplTitle;
    private javax.swing.JLabel lblDangVien;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblSinhHoat;
    private javax.swing.JLabel lblThanhTich;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lblYeuCau;
    private javax.swing.JTextField textDateOut;
    private javax.swing.JTextField textFieldDateTransfer;
    private javax.swing.JTextField textFieldIdOrgTransfer;
    private javax.swing.JTextField textIdOut;
    // End of variables declaration//GEN-END:variables
}
