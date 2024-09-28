/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Class.BranchActivity;
import Class.PartyMember;
import Class.User;
import Database.ListBranchActivity;
import Database.ListPartyMember;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class Member extends javax.swing.JFrame {
    public User user;
    
    List<PartyMember> listPartyMember = new ArrayList<>();
    List<BranchActivity> listBranchActivity = new ArrayList<>();
    

    private static int posBranchActivity = 0;
    private static int state = 0;
    
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
        
        listPartyMember = ListPartyMember.getAllPartyMembers();
        
        String orgID = ListBranchActivity.getPartOrgIdByMemberId(user.getPartyMemberId());
        System.out.println("Không tìm thấy tổ chức cho member ID: " + orgID);
        
        listBranchActivity = ListBranchActivity.getBranchActivitiesByOrgId(orgID);
       
        
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
        } else {
            // Nếu không tìm thấy thành viên trong listPartyMember
            JOptionPane.showMessageDialog(null, "Không tìm thấy thành viên với ID: " + user.getPartyMemberId());
        }
    }
    
    public void ViewBranchActivity() {
        if (!listBranchActivity.isEmpty()) {
            BranchActivity currentActivity = listBranchActivity.get(0);

            this.jTextFieldNameActivity.setText(currentActivity.getActivityName());
            this.jTextFieldIDActivity.setText(currentActivity.getId());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String birthDateString = formatter.format(currentActivity.getStartDate());
            String joinDateString = formatter.format(currentActivity.getEndDate());

            this.jTextFieldStartDateActivity.setText(birthDateString);
            this.jTextFieldEndDateActivity.setText(joinDateString);

            this.jTextFieldStatusActivity.setText(currentActivity.getStatus());
            this.jEditorPaneDescpitActivity.setText(currentActivity.getDescription());
        } else {
            // Xử lý khi không có hoạt động nào
            JOptionPane.showMessageDialog(null, "Không có hoạt động nào cho tổ chức này.");
        }
    }

    
    public void ViewTableBranchActivity() {
        DefaultTableModel model = (DefaultTableModel) this.jTableBranchActivity.getModel();
        model.setNumRows(0);
        for (BranchActivity ba : listBranchActivity) {
            model.addRow(new Object[]{ba.getId(), ba.getActivityName() , ba.getStartDate(), ba.getEndDate(), ba.getStatus()});
        }
        
        jTableBranchActivity.revalidate();
        jTableBranchActivity.repaint();
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
        jLabel21 = new javax.swing.JLabel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        cardSinhHoat = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableBranchActivity = new javax.swing.JTable();
        jTextField12 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
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
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        cardYeuCau = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        editorPaneYCLiDoNghi = new javax.swing.JEditorPane();
        jLabel6 = new javax.swing.JLabel();
        buttonYCNghi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textFieldYCMaChuyen = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textFieldYCNgayChuyen = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        editorPaneYCLiDoChuyen = new javax.swing.JEditorPane();
        jLabel20 = new javax.swing.JLabel();
        buttonYCChuyen = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
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
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cardThanhTich = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
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

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Bui Ngoc Duc");
        jplSlideMenu.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, -1));

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

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/images (1).jpeg"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel14.setText("Nâng cao chất lượng công tác Đảng từ Sổ tay đảng viên điện tử");

        jLabel15.setText("Sáng 8/5, Phó Bí thư Thường trực Tỉnh ủy, Trưởng đoàn ĐBQH tỉnh, Trưởng Ban Chỉ ");

        jLabel26.setText("đạo phần mềm “Sổ tay đảng viên điện tử” Đảng bộ tỉnh Đặng Ngọc Huy và Trưởng\n");

        jLabel27.setText("ban Tổ chức Tỉnh ủy Lữ Ngọc Bình chủ trì Hội nghị...\n");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addContainerGap(500, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel16);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
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

        javax.swing.GroupLayout cardTrangChuLayout = new javax.swing.GroupLayout(cardTrangChu);
        cardTrangChu.setLayout(cardTrangChuLayout);
        cardTrangChuLayout.setHorizontalGroup(
            cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardTrangChuLayout.setVerticalGroup(
            cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardTrangChuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        jScrollPane5.setViewportView(jTableBranchActivity);

        cardSinhHoat.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 365, 938, 209));

        jTextField12.setText("Tìm kiếm ");
        cardSinhHoat.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 27, 128, -1));

        jButton4.setBackground(new java.awt.Color(0, 204, 255));
        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Tìm");
        cardSinhHoat.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 27, 61, -1));

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
        cardSinhHoat.add(jTextFieldIDActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 92, 106, -1));

        jLabel9.setText("Ngày bắt đầu:");
        cardSinhHoat.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 127, 106, -1));
        cardSinhHoat.add(jTextFieldStartDateActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 150, 106, -1));

        jLabel23.setText("Ngày kết thúc:");
        cardSinhHoat.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 127, 106, -1));
        cardSinhHoat.add(jTextFieldEndDateActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 150, 106, -1));

        jLabel42.setText("Mô tả:");
        cardSinhHoat.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 186, -1, -1));

        jEditorPaneDescpitActivity.setContentType("text/html"); // NOI18N
        jEditorPaneDescpitActivity.setText("\n\n");
        jScrollPane10.setViewportView(jEditorPaneDescpitActivity);

        cardSinhHoat.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 209, 484, 124));
        cardSinhHoat.add(jTextFieldStatusActivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 151, 106, -1));

        jLabel43.setText("Trạng thái:");
        cardSinhHoat.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 127, -1, -1));

        jButton5.setBackground(new java.awt.Color(51, 204, 0));
        jButton5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Đăng Ký ");
        cardSinhHoat.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 150, 124, -1));

        jButton6.setBackground(new java.awt.Color(255, 51, 0));
        jButton6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Huỷ");
        cardSinhHoat.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 186, 124, -1));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardSinhHoat.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 590));

        jplMain.add(cardSinhHoat, "card3");

        cardYeuCau.setBackground(new java.awt.Color(255, 255, 255));
        cardYeuCau.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setText("Xin Thôi Công tác:");
        cardYeuCau.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 325, 200, 30));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel2.setText("Xin Chuyển Công tác:");
        cardYeuCau.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 19, 200, 30));

        jScrollPane2.setViewportView(editorPaneYCLiDoNghi);

        cardYeuCau.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 396, 596, 162));

        jLabel6.setText("Lý Do:");
        cardYeuCau.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 373, -1, -1));

        buttonYCNghi.setBackground(new java.awt.Color(102, 204, 0));
        buttonYCNghi.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        buttonYCNghi.setForeground(new java.awt.Color(255, 255, 255));
        buttonYCNghi.setText("Gửi Yêu Cầu");
        cardYeuCau.add(buttonYCNghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 455, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel7.setText("Chuyển đơn vị công tác chính thức:");
        cardYeuCau.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 55, -1, -1));
        cardYeuCau.add(textFieldYCMaChuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 90, 108, -1));

        jLabel18.setText("Mã Tổ Chức:");
        cardYeuCau.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 93, -1, -1));

        jLabel19.setText("Ngày Chuyển:");
        cardYeuCau.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 93, 84, -1));
        cardYeuCau.add(textFieldYCNgayChuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 90, 108, -1));

        jScrollPane8.setViewportView(editorPaneYCLiDoChuyen);

        cardYeuCau.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 148, 597, 159));

        jLabel20.setText("Chi tiết:");
        cardYeuCau.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 125, -1, -1));

        buttonYCChuyen.setBackground(new java.awt.Color(102, 204, 0));
        buttonYCChuyen.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        buttonYCChuyen.setForeground(new java.awt.Color(255, 255, 255));
        buttonYCChuyen.setText("Gửi Yêu Cầu");
        buttonYCChuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYCChuyenActionPerformed(evt);
            }
        });
        cardYeuCau.add(buttonYCChuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 168, -1, -1));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardYeuCau.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 550));

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

        jEditorPane1.setContentType("text/html"); // NOI18N
        jEditorPane1.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p style=\"margin-top: 0\">\n      10/1974 - 7/1979:<br>\n      Học viên Đại học An ninh nhân dân.<br><br>\n\n      7/1979 - 12/1988:<br>\n      Cán bộ, Cục Bảo vệ Chính trị I, Bộ Công an.<br><br>\n\n      12/1988 - 5/1990:<br>\n      Phó Trưởng phòng, Cục Bảo vệ Chính trị I, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      5/1990 - 6/1993:<br>\n      Trưởng phòng, Cục Bảo vệ Chính trị I, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      6/1993 - 5/1997:<br>\n      Phó Cục trưởng Cục Bảo vệ Chính trị I, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      5/1997 - 6/2006:<br>\n      Cục trưởng Cục Bảo vệ Chính trị III, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      6/2006 - 12/2009:<br>\n      Phó Tổng cục trưởng Tổng cục An ninh, Bộ Công an.\n    </p>\n  </body>\n</html>\n\n");
        jScrollPane6.setViewportView(jEditorPane1);

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Ngày Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jPanel19.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 379, 802, 171));

        jLabel38.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel38.setText("Kỷ Luật Đảng VIên Đã Có Những Sai Phạm:");
        jPanel19.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 330, -1, 31));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Ngày Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable4);

        jPanel19.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 135, 802, 168));

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
    }//GEN-LAST:event_lblThanhTichMouseClicked

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void buttonYCChuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYCChuyenActionPerformed
        String ycMaToChuc, ycNgayChuyen, ycLiDoChuyen,ycLiDoNghi;
        textFieldYCMaChuyen.getText();
        textFieldYCNgayChuyen.getText();
        editorPaneYCLiDoChuyen.getText();
        
        
    }//GEN-LAST:event_buttonYCChuyenActionPerformed

    private void jTextFieldNameActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActivityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActivityActionPerformed

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
    private javax.swing.JButton buttonYCChuyen;
    private javax.swing.JButton buttonYCNghi;
    private javax.swing.JPanel cardDangVien;
    private javax.swing.JPanel cardSinhHoat;
    private javax.swing.JPanel cardThanhTich;
    private javax.swing.JPanel cardTrangChu;
    private javax.swing.JPanel cardYeuCau;
    private javax.swing.JEditorPane editorPaneYCLiDoChuyen;
    private javax.swing.JEditorPane editorPaneYCLiDoNghi;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPaneDescpitActivity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAvatar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTableBranchActivity;
    private javax.swing.JTextField jTextField12;
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
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplSlideMenu;
    private javax.swing.JPanel jplTitle;
    private javax.swing.JLabel lblDangVien;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblSinhHoat;
    private javax.swing.JLabel lblThanhTich;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lblYeuCau;
    private javax.swing.JTextField textFieldYCMaChuyen;
    private javax.swing.JTextField textFieldYCNgayChuyen;
    // End of variables declaration//GEN-END:variables
}
