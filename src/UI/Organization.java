/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;


import Class.SignBranchActivity;
import Class.BranchActivity;
import Class.PartyMember;
import Class.User;
import Database.AdminDatabase;
import Database.BranchActivityAdd;
import Database.BranchActivityDelete;
import Database.BranchActivityEdit;
import Database.ListPartyMember;
import Database.List_BranchActivity_Org;
import Database.List_SignBranchActivity_Org;
import Database.PartyMemberAdd;
import Database.PartyMemberDelete;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Database.SearchPM;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author buingocduc
 */
public class Organization extends javax.swing.JFrame {
    public User user;
    
    private static final String jdbcURL = AdminDatabase.DATABASE_URL;
    private static final String username = AdminDatabase.DATABASE_USERNAME;
    private static final String password = AdminDatabase.DATABASE_PASSWORD;
    
    //list DangVien
    List<PartyMember> listDV = ListPartyMember.getAllPartyMembers();
    List<BranchActivity> listBA = new ArrayList<>();
    List<SignBranchActivity> listSBA = new ArrayList<>();
    
    private static int pos = 0;
    private static int stt = 0;
    
    private int checkPointSaveBranchActivity = 0;
    
    private static int posSBA = 0;
    
    private static int checkSaveDV = 0;
    
    private static int posBA = 0;
    /* set onoff cho card DangVien */
    public String IDorg;
    public Organization() {
        initComponents();
    }
    public Organization(User user) {
        initComponents();
        
        this.user = user;
        
        cardViewDetail.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(true);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(false);
        cardDangVien.setVisible(false);

        String idOrg = List_BranchActivity_Org.getPartOrgIdByMemberId(user.getPartyMemberId());

        IDorg = idOrg;
        
        loadThanhTichToTable(IDorg);
        loadViPhamToTable(IDorg);
        
        loadBranchActivityToTable(IDorg);
        viewDB(IDorg);
        
    }
    
    public void OnOffDangVien(boolean a, boolean b, boolean c)
    {
        this.btnEditDv.show(a);
        /*-----*/
        this.btnCancelDV.show(c);
        this.btnSaveDV.show(c);
        this.btnDeleteDV.show(b);
        this.btnEditDV2.show(b);
        this.btnAddDV.show(b);
    }
    
    public void OnOff_BranchActivity(boolean a, boolean b, boolean c, boolean d)
    {
        this.jButton_AddBA_Org.show(a);
        this.jButton_DeleteBA.show(b);
        this.jButton_EditBA.show(c);
        
        this.jButton_SaveBA.show(d);
        this.jButton_CancelBA.show(d);
    }
    
    //set view cho card DangVien
    public void ViewDangVien()
    { 
        PartyMember pm = listDV.get(pos);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Định dạng: Năm-Tháng-Ngày
        String birthDateFormat = dateFormat.format(pm.getBirthDate());
        String joinDateFormat = dateFormat.format(pm.getJoinDate());
        this.TextFieldHoTen.setText(pm.getFullName());
        this.TextFieldID.setText(pm.getId());
        this.TextFieldNgaySinh.setText(birthDateFormat);
        this.TextFieldPosition.setText(pm.getPosition());
        this.TextFieldNgayVao.setText(joinDateFormat);
        this.TextFieldPhoneNumber.setText(pm.getPhoneNumber());
        this.TextFieldEmail.setText(pm.getEmail());
        this.TextFieldAddress.setText(pm.getAddress());
        this.TextFieldOrgID.setText(pm.getOrgId());
        
        OnOffDangVien(true, false, false);
    }
    
// set viewTable cho crad DangVien
    public void viewTableDv()
    {
        DefaultTableModel tableDV = (DefaultTableModel) this.TableDV.getModel();
        tableDV.setNumRows(0);
        stt = 0;
        for(PartyMember DV: listDV)
        {
            stt ++;
            tableDV.addRow(new Object[]{stt, DV.getId(), DV.getFullName(), DV.getPosition(), DV.getJoinDate()});
        }
    }
    
//    public void ViewTableBranchActivityORG(){       
//        DefaultTableModel model = (DefaultTableModel) this.jTable_BranchActivity_Org.getModel();
//        model.setNumRows(0);
//        for (BranchActivity ba : listBA) {
//            model.addRow(new Object[]{ba.getId(), ba.getActivityName(), ba.getStartDate(), ba.getEndDate(), ba.getDescription()});
//        }
//
//    }
    
    public void ViewBranchActivityOrg(){
        BranchActivity ba = listBA.get(posBA);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Định dạng: Năm-Tháng-Ngày
        String starDate = dateFormat.format(ba.getStartDate());
        String endDate = dateFormat.format(ba.getEndDate());
        
        this.jTextField_StartDate_Org.setText(starDate);
        this.jTextField_EndDate_Org.setText(endDate);
        this.jTextField_IDBA_Org.setText(ba.getId());
        this.jTextField_NameBA_Org.setText(ba.getActivityName());
        this.jEditorPane_DetailBA_Org.setText(ba.getDescription());
        
        OnOff_BranchActivity(true, true, true, false);
    }
    
    public void ViewDetail(){
        SignBranchActivity ba = listSBA.get(posSBA);
        String name = ListPartyMember.getMemberNameById(ba.getIdMember());
        
        this.TextFieldHoTen_VD.setText(name);
        this.jTextField_IDmemberVD.setText(ba.getIdMember());
        this.jComboBox_VD.setSelectedItem(ba.getStatus());
    }
    
    public void ViewTableDetail(){
        DefaultTableModel model = (DefaultTableModel) this.jTable_ViewDetail.getModel();
        model.setNumRows(0);
        for (SignBranchActivity ba : listSBA) {
            String name = ListPartyMember.getMemberNameById(ba.getIdMember());
            model.addRow(new Object[]{ba.getIdBA(), ba.getIdMember(), name, ba.getStatus()});
        }
        
    }
    
    //--------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jplSlideMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblThanhTich = new javax.swing.JLabel();
        lblSinhHoat = new javax.swing.JLabel();
        lblKyLuat = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDangXuat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDangBo = new javax.swing.JLabel();
        lblDangVien = new javax.swing.JLabel();
        lblYeuCau = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BackgroundMenu = new javax.swing.JLabel();
        jplTitle = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jplMain = new javax.swing.JPanel();
        cardYeuCau = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        TextFieldSearchIN = new javax.swing.JTextField();
        jButton33 = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jEditorPane6 = new javax.swing.JEditorPane();
        jLabel68 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        TextFieldSearchOUT = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jEditorPane4 = new javax.swing.JEditorPane();
        jLabel61 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        cardDangBo = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTableDBVP = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        jTextFieldDBNAME = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jTextFieldIDDB = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jTextFieldDBDATE = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTableDBTT = new javax.swing.JTable();
        jBacground = new javax.swing.JLabel();
        cardThanhTich = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jTextField14 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jEditorPane7 = new javax.swing.JEditorPane();
        jLabel49 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        cardDangVien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextFieldSearchDV = new javax.swing.JTextField();
        ButtonSearchDV = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TextFieldHoTen = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        TextFieldID = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        TextFieldNgaySinh = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TextFieldNgayVao = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TextFieldAddress = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        TextFieldEmail = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        TextFieldPhoneNumber = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        TextFieldOrgID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TextFieldPosition = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDV = new javax.swing.JTable();
        btnAddDV = new javax.swing.JButton();
        btnEditDV2 = new javax.swing.JButton();
        btnDeleteDV = new javax.swing.JButton();
        btnEditDv = new javax.swing.JButton();
        btnSaveDV = new javax.swing.JButton();
        btnCancelDV = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        cardKyLuat = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jTextField15 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane3 = new javax.swing.JEditorPane();
        jLabel13 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cardSinhHoat = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_BranchActivity_Org = new javax.swing.JTable();
        jTextField_SearchBA_org = new javax.swing.JTextField();
        jButton_SearchBA_org = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField_NameBA_Org = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField_IDBA_Org = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField_StartDate_Org = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField_EndDate_Org = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jEditorPane_DetailBA_Org = new javax.swing.JEditorPane();
        jButton_SaveBA = new javax.swing.JButton();
        jButton_CancelBA = new javax.swing.JButton();
        jButton_EditBA = new javax.swing.JButton();
        jButton_AddBA_Org = new javax.swing.JButton();
        jButton_DeleteBA = new javax.swing.JButton();
        jButton_ViewDetail = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        cardViewDetail = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_ViewDetail = new javax.swing.JTable();
        buttonBack = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        TextFieldHoTen_VD = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField_IDmemberVD = new javax.swing.JTextField();
        jComboBox_VD = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jButton_SaveVD = new javax.swing.JButton();
        jButton_CancelVD = new javax.swing.JButton();
        jButton_DanhGiaVD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplSlideMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jplSlideMenu.setPreferredSize(new java.awt.Dimension(190, 590));
        jplSlideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 204, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-user.png"))); // NOI18N
        jplSlideMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cong Nghe Thong Tin 01");
        jplSlideMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 30));

        lblThanhTich.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblThanhTich.setForeground(new java.awt.Color(255, 255, 255));
        lblThanhTich.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThanhTich.setText("Thành Tích");
        lblThanhTich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThanhTichMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblThanhTich, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, 30));

        lblSinhHoat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblSinhHoat.setForeground(new java.awt.Color(255, 255, 255));
        lblSinhHoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSinhHoat.setText("Sinh Hoạt");
        lblSinhHoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSinhHoatMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblSinhHoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 30));

        lblKyLuat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblKyLuat.setForeground(new java.awt.Color(255, 255, 255));
        lblKyLuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKyLuat.setText("Kỷ Luật");
        lblKyLuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKyLuatMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblKyLuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 200, 30));
        jplSlideMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 489, 210, -1));

        lblDangXuat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 0, 0));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("Đăng Xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 200, 30));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Giới Thiệu");
        jplSlideMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 200, 30));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Trợ Giúp");
        jplSlideMenu.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 200, 30));

        lblDangBo.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangBo.setForeground(new java.awt.Color(255, 255, 255));
        lblDangBo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangBo.setText("Đảng Bộ");
        lblDangBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangBoMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblDangBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 30));

        lblDangVien.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangVien.setForeground(new java.awt.Color(255, 255, 255));
        lblDangVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangVien.setText("Đảng Viên");
        lblDangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangVienMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblDangVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 30));

        lblYeuCau.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblYeuCau.setForeground(new java.awt.Color(255, 255, 255));
        lblYeuCau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYeuCau.setText("Yêu Cầu");
        lblYeuCau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYeuCauMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblYeuCau, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 30));
        jplSlideMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 10));

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
                .addGap(134, 134, 134)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jplTitleLayout.setVerticalGroup(
            jplTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplTitleLayout.createSequentialGroup()
                .addGroup(jplTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jplTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 950, 70));

        jplMain.setBackground(new java.awt.Color(255, 255, 255));
        jplMain.setLayout(new java.awt.CardLayout());

        cardYeuCau.setBackground(new java.awt.Color(255, 255, 255));
        cardYeuCau.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 51, 51));
        jLabel63.setText("Đảng Viên Có Nguyện Vọng Xin Vào Đơn Vị:");
        jPanel2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 40));

        jLabel64.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel64.setText("Danh Sách Đảng Viên Đã Gửi Yêu Cầu:");
        jPanel2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 31));

        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Họ và Tên", "Ngày Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(jTable15);

        jPanel2.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 113, 802, 168));

        TextFieldSearchIN.setMaximumSize(new java.awt.Dimension(64, 25));
        TextFieldSearchIN.setMinimumSize(new java.awt.Dimension(64, 25));
        TextFieldSearchIN.setName(""); // NOI18N
        TextFieldSearchIN.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel2.add(TextFieldSearchIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 128, -1));

        jButton33.setBackground(new java.awt.Color(0, 204, 255));
        jButton33.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("Tìm");
        jButton33.setBorder(null);
        jButton33.setPreferredSize(new java.awt.Dimension(22, 30));
        jPanel2.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 61, -1));

        jLabel65.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel65.setText("Chi Tiết Đảng Viên Đã Gửi Yêu Cầu:");
        jPanel2.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 31));

        jLabel66.setText("Mã quyết định:");
        jPanel2.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 330, -1, -1));

        jTextField27.setMaximumSize(new java.awt.Dimension(64, 25));
        jTextField27.setMinimumSize(new java.awt.Dimension(64, 25));
        jTextField27.setPreferredSize(new java.awt.Dimension(82, 25));
        jPanel2.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 353, 161, -1));

        jTextField30.setMaximumSize(new java.awt.Dimension(64, 25));
        jTextField30.setMinimumSize(new java.awt.Dimension(64, 25));
        jTextField30.setPreferredSize(new java.awt.Dimension(81, 25));
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 471, 161, -1));

        jLabel67.setText("Mã Đảng viên:");
        jPanel2.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 388, 88, -1));

        jTextField29.setMaximumSize(new java.awt.Dimension(64, 25));
        jTextField29.setMinimumSize(new java.awt.Dimension(64, 25));
        jTextField29.setPreferredSize(new java.awt.Dimension(82, 25));
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 411, 161, -1));

        jScrollPane8.setViewportView(jEditorPane6);

        jPanel2.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 353, 522, 157));

        jLabel68.setText("Nội Dung:");
        jPanel2.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 330, -1, -1));

        jButton34.setBackground(new java.awt.Color(0, 153, 0));
        jButton34.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Phê Duyệt");
        jPanel2.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 366, -1, -1));

        jButton35.setBackground(new java.awt.Color(204, 0, 0));
        jButton35.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Từ Chối");
        jButton35.setPreferredSize(new java.awt.Dimension(103, 26));
        jPanel2.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, -1, -1));

        jLabel70.setText("Tên Đảng viên:");
        jLabel70.setPreferredSize(new java.awt.Dimension(76, 16));
        jPanel2.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 450, 80, -1));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        jPanel2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 550));

        jTabbedPane3.addTab("Yêu cầu vào Đảng bộ", jPanel2);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 51, 51));
        jLabel58.setText("Đảng Viên Có Nguyện Vọng Rời Đơn Vị:");
        jPanel5.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 40));

        jLabel59.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel59.setText("Danh Sách Đảng Viên Đã Gửi Yêu Cầu:");
        jPanel5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 31));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Họ và Tên", "Ngày Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(jTable12);

        jPanel5.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 113, 802, 168));

        TextFieldSearchOUT.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel5.add(TextFieldSearchOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 128, -1));

        jButton26.setBackground(new java.awt.Color(0, 204, 255));
        jButton26.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Tìm");
        jButton26.setBorder(null);
        jButton26.setPreferredSize(new java.awt.Dimension(22, 30));
        jPanel5.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 61, -1));

        jLabel60.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel60.setText("Chi Tiết Đảng Viên Đã Gửi Yêu Cầu:");
        jPanel5.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 31));

        jLabel19.setText("Mã quyết định:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 330, -1, -1));

        jTextField24.setText("TT2024LDCB");
        jPanel5.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 353, 161, -1));

        jLabel47.setText("Mã Đảng viên:");
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 388, 88, -1));

        jTextField25.setText("TT2024LDCB");
        jPanel5.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 411, 161, -1));

        jScrollPane4.setViewportView(jEditorPane4);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 353, 522, 157));

        jLabel61.setText("Nội Dung:");
        jPanel5.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 330, -1, -1));

        jButton27.setBackground(new java.awt.Color(0, 153, 0));
        jButton27.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Phê Duyệt");
        jPanel5.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 366, -1, -1));

        jButton31.setBackground(new java.awt.Color(204, 0, 0));
        jButton31.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Từ Chối");
        jPanel5.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 100, -1));

        jLabel71.setText("Tên Đảng viên:");
        jPanel5.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        jTextField31.setText("bui ngoc duc");
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 160, -1));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        jPanel5.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 550));

        jTabbedPane3.addTab("Yêu cầu ra khỏi Đảng bộ", jPanel5);

        cardYeuCau.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardYeuCau, "card4");

        cardDangBo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel72.setText("Những sai phạm của tổ chức:");
        cardDangBo.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 31));

        jLabel73.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 51, 51));
        jLabel73.setText("Thông Tin Tổ Chức Đảng");
        cardDangBo.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 40));

        jTableDBVP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Quyết Định", "Mã Tổ Chức", "Tên Tổ Chức", "Ngày Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane18.setViewportView(jTableDBVP);

        cardDangBo.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 886, 140));

        jLabel75.setText("Tên Đơn Vị:");
        cardDangBo.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        jTextFieldDBNAME.setText("Đảng bộ xã Nhân quyền");
        jTextFieldDBNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDBNAMEActionPerformed(evt);
            }
        });
        cardDangBo.add(jTextFieldDBNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 170, -1));

        jLabel76.setText("Mã Tổ Chức:");
        cardDangBo.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jTextFieldIDDB.setText("TC001");
        cardDangBo.add(jTextFieldIDDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 170, -1));

        jLabel77.setText("Ngày Thành Lập:");
        cardDangBo.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jTextFieldDBDATE.setText("21/09/2024");
        cardDangBo.add(jTextFieldDBDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 170, -1));

        jLabel78.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel78.setText("Những thành tích của tổ chức:");
        cardDangBo.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 31));

        jTableDBTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Quyết Định", "Mã Tổ Chức", "Tên Tổ Chức", "Ngày Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDBTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDBTTMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(jTableDBTT);

        cardDangBo.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 886, 140));

        jBacground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardDangBo.add(jBacground, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

        jplMain.add(cardDangBo, "card5");

        cardThanhTich.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 51, 51));
        jLabel54.setText("Khen Thưởng Đảng Viên");
        cardThanhTich.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, 40));

        jLabel79.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel79.setText("Danh Sách Đảng Viên Đã Có Thành Tích Tốt:");
        cardThanhTich.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 64, -1, 31));

        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Họ và Tên", "Ngày Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(jTable14);

        cardThanhTich.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 113, 802, 168));

        jTextField14.setText("Tìm kiếm ");
        jTextField14.setPreferredSize(new java.awt.Dimension(67, 30));
        cardThanhTich.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 128, -1));

        jButton13.setBackground(new java.awt.Color(0, 204, 255));
        jButton13.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Tìm");
        jButton13.setBorder(null);
        jButton13.setPreferredSize(new java.awt.Dimension(22, 30));
        cardThanhTich.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 61, -1));

        jLabel80.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel80.setText("Khen Thưởng Đảng Viên Đã Có Thành Tích Tốt:");
        cardThanhTich.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 293, -1, 31));

        jLabel20.setText("Mã quyết định:");
        cardThanhTich.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 330, -1, -1));

        jTextField36.setText("TT2024LDCB");
        cardThanhTich.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 353, 161, -1));

        jLabel38.setText("Mã Đảng viên:");
        cardThanhTich.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 388, 88, -1));

        jTextField37.setText("TT2024LDCB");
        cardThanhTich.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 411, 161, -1));

        jScrollPane9.setViewportView(jEditorPane7);

        cardThanhTich.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 353, 522, 157));

        jLabel49.setText("Nội Dung:");
        cardThanhTich.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 330, -1, -1));

        jButton36.setBackground(new java.awt.Color(0, 153, 0));
        jButton36.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton36.setForeground(new java.awt.Color(255, 255, 255));
        jButton36.setText("Khen Thưởng");
        cardThanhTich.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 366, -1, -1));

        jButton37.setBackground(new java.awt.Color(204, 0, 0));
        jButton37.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("Huỷ");
        cardThanhTich.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 428, 124, -1));

        jButton38.setBackground(new java.awt.Color(0, 153, 0));
        jButton38.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton38.setForeground(new java.awt.Color(255, 255, 255));
        jButton38.setText("Ban Hành");
        cardThanhTich.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 398, 124, -1));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardThanhTich.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

        jplMain.add(cardThanhTich, "card6");

        cardDangVien.setBackground(new java.awt.Color(255, 255, 255));
        cardDangVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Danh Sách Đảng Viên Trong Nội Bộ: ");
        cardDangVien.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 42));

        TextFieldSearchDV.setMaximumSize(new java.awt.Dimension(64, 25));
        TextFieldSearchDV.setMinimumSize(new java.awt.Dimension(64, 25));
        TextFieldSearchDV.setPreferredSize(new java.awt.Dimension(64, 30));
        TextFieldSearchDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldSearchDVActionPerformed(evt);
            }
        });
        cardDangVien.add(TextFieldSearchDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 150, -1));

        ButtonSearchDV.setBackground(new java.awt.Color(0, 204, 255));
        ButtonSearchDV.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ButtonSearchDV.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSearchDV.setText("Tìm");
        ButtonSearchDV.setBorder(null);
        ButtonSearchDV.setPreferredSize(new java.awt.Dimension(22, 30));
        ButtonSearchDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchDVActionPerformed(evt);
            }
        });
        cardDangVien.add(ButtonSearchDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 60, -1));
        cardDangVien.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));
        cardDangVien.add(TextFieldHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 167, -1));

        jLabel17.setText("Họ và Tên:");
        cardDangVien.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel29.setText("Mã Đảng viên:");
        cardDangVien.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        TextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldIDActionPerformed(evt);
            }
        });
        cardDangVien.add(TextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 126, -1));

        jLabel30.setText("Ngày Sinh:");
        cardDangVien.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        cardDangVien.add(TextFieldNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 170, -1));

        jLabel31.setText("Ngày Vào Đảng:");
        cardDangVien.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 100, -1));
        cardDangVien.add(TextFieldNgayVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 130, -1));

        jLabel32.setText("Địa chỉ:");
        cardDangVien.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));
        cardDangVien.add(TextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 313, -1));

        jLabel33.setText("Email:");
        cardDangVien.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        TextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldEmailActionPerformed(evt);
            }
        });
        cardDangVien.add(TextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 170, -1));

        jLabel34.setText("Số điện thoại:");
        cardDangVien.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        TextFieldPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPhoneNumberActionPerformed(evt);
            }
        });
        cardDangVien.add(TextFieldPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 128, -1));

        jLabel35.setText("Chức Vụ:");
        cardDangVien.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        TextFieldOrgID.setMaximumSize(new java.awt.Dimension(64, 22));
        TextFieldOrgID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldOrgIDActionPerformed(evt);
            }
        });
        cardDangVien.add(TextFieldOrgID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 170, -1));

        jLabel5.setText("Mã tổ chức");
        cardDangVien.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 120, -1));
        cardDangVien.add(TextFieldPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 128, -1));

        jLabel36.setText("Quy trình công tác:");
        cardDangVien.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 140, -1));

        jScrollPane6.setViewportView(jEditorPane1);

        cardDangVien.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 480, 160));

        TableDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã DV", "Họ Tên", "Chức vụ", "Ngày vào Đảng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDVMouseClicked(evt);
            }
        });
        TableDV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableDVKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TableDV);
        if (TableDV.getColumnModel().getColumnCount() > 0) {
            TableDV.getColumnModel().getColumn(0).setMinWidth(30);
            TableDV.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableDV.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        cardDangVien.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 424, 938, 150));

        btnAddDV.setBackground(new java.awt.Color(255, 204, 0));
        btnAddDV.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnAddDV.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDV.setText("Thêm");
        btnAddDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDVActionPerformed(evt);
            }
        });
        cardDangVien.add(btnAddDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 70, -1));

        btnEditDV2.setBackground(new java.awt.Color(255, 204, 0));
        btnEditDV2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnEditDV2.setForeground(new java.awt.Color(255, 255, 255));
        btnEditDV2.setText("Sửa");
        btnEditDV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDV2ActionPerformed(evt);
            }
        });
        cardDangVien.add(btnEditDV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 70, -1));

        btnDeleteDV.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteDV.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnDeleteDV.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteDV.setText("Xoá");
        btnDeleteDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDVActionPerformed(evt);
            }
        });
        cardDangVien.add(btnDeleteDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 70, -1));

        btnEditDv.setBackground(new java.awt.Color(0, 204, 51));
        btnEditDv.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnEditDv.setText("Chỉnh sửa");
        btnEditDv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDvActionPerformed(evt);
            }
        });
        cardDangVien.add(btnEditDv, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, 30));

        btnSaveDV.setBackground(new java.awt.Color(0, 204, 51));
        btnSaveDV.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnSaveDV.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveDV.setText("Lưu");
        btnSaveDV.setPreferredSize(new java.awt.Dimension(72, 25));
        btnSaveDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDVActionPerformed(evt);
            }
        });
        cardDangVien.add(btnSaveDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 80, -1));

        btnCancelDV.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelDV.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnCancelDV.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelDV.setText("Huỷ");
        btnCancelDV.setPreferredSize(new java.awt.Dimension(72, 25));
        btnCancelDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDVActionPerformed(evt);
            }
        });
        cardDangVien.add(btnCancelDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 80, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardDangVien.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

        jplMain.add(cardDangVien, "card7");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 51, 51));
        jLabel55.setText("Kỷ Luật Đảng Viên");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 40));

        jLabel56.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel56.setText("Danh Sách Đảng Viên Đã Vi Phạm Kỷ Luật:");
        jPanel4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 66, -1, 31));

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Đảng Viên", "Họ và Tên", "Ngày Quyết Định", "Người Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(jTable13);

        jPanel4.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 115, 886, 168));

        jTextField15.setText("Tìm kiếm ");
        jTextField15.setPreferredSize(new java.awt.Dimension(67, 30));
        jPanel4.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 37, 128, -1));

        jButton14.setBackground(new java.awt.Color(0, 204, 255));
        jButton14.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Tìm");
        jButton14.setBorder(null);
        jButton14.setPreferredSize(new java.awt.Dimension(22, 30));
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 37, 61, -1));

        jLabel57.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel57.setText("Kỷ Luật Đảng Viên Đã Vi Phạm:");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 295, -1, 31));

        jLabel9.setText("Mã quyết định:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 332, -1, -1));

        jTextField5.setText("TT2024LDCB");
        jPanel4.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 355, 161, -1));

        jLabel12.setText("Mã Đảng viên:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 390, 88, -1));

        jTextField10.setText("TT2024LDCB");
        jPanel4.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 413, 161, -1));

        jScrollPane3.setViewportView(jEditorPane3);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 355, 467, 157));

        jLabel13.setText("Nội Dung:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 332, -1, -1));

        jButton15.setBackground(new java.awt.Color(0, 153, 0));
        jButton15.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Kỷ Luật");
        jPanel4.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 368, 124, -1));

        jButton16.setBackground(new java.awt.Color(204, 0, 0));
        jButton16.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Huỷ");
        jPanel4.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 430, 124, -1));

        jButton17.setBackground(new java.awt.Color(0, 153, 0));
        jButton17.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Ban Hành");
        jPanel4.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 400, 124, -1));

        jTextField11.setText("Chủ tịch Hội Đông");
        jPanel4.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 474, 161, -1));

        jLabel14.setText("Người quyết định:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 454, -1, -1));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

        javax.swing.GroupLayout cardKyLuatLayout = new javax.swing.GroupLayout(cardKyLuat);
        cardKyLuat.setLayout(cardKyLuatLayout);
        cardKyLuatLayout.setHorizontalGroup(
            cardKyLuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardKyLuatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cardKyLuatLayout.setVerticalGroup(
            cardKyLuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardKyLuatLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jplMain.add(cardKyLuat, "card8");

        cardSinhHoat.setBackground(new java.awt.Color(255, 255, 255));
        cardSinhHoat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 51, 51));
        jLabel41.setText("Sinh Hoạt Chi Bộ");
        cardSinhHoat.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 30));

        jTable_BranchActivity_Org.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Buổi Sinh Hoạt", "Tên Buổi Sinh Hoạt", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_BranchActivity_Org.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_BranchActivity_OrgMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_BranchActivity_Org);

        cardSinhHoat.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 385, 920, 180));

        jTextField_SearchBA_org.setText("Tìm kiếm ");
        jTextField_SearchBA_org.setPreferredSize(new java.awt.Dimension(67, 30));
        cardSinhHoat.add(jTextField_SearchBA_org, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 130, -1));

        jButton_SearchBA_org.setBackground(new java.awt.Color(0, 204, 255));
        jButton_SearchBA_org.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_SearchBA_org.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SearchBA_org.setText("Tìm");
        jButton_SearchBA_org.setBorder(null);
        jButton_SearchBA_org.setPreferredSize(new java.awt.Dimension(72, 30));
        jButton_SearchBA_org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchBA_orgActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_SearchBA_org, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 61, -1));

        jLabel15.setText("Tên Buổi Sinh Hoạt:");
        cardSinhHoat.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));
        cardSinhHoat.add(jTextField_NameBA_Org, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 200, -1));

        jLabel16.setText("ID Buổi Sinh Hoạt:");
        cardSinhHoat.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));
        cardSinhHoat.add(jTextField_IDBA_Org, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 200, -1));

        jLabel18.setText("Ngày bắt đầu:");
        cardSinhHoat.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 106, -1));
        cardSinhHoat.add(jTextField_StartDate_Org, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 106, -1));

        jLabel23.setText("Ngày kết thúc:");
        cardSinhHoat.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 106, -1));
        cardSinhHoat.add(jTextField_EndDate_Org, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 106, -1));

        jLabel42.setText("Mô tả:");
        cardSinhHoat.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jScrollPane10.setViewportView(jEditorPane_DetailBA_Org);

        cardSinhHoat.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 380, 80));

        jButton_SaveBA.setBackground(new java.awt.Color(51, 153, 0));
        jButton_SaveBA.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_SaveBA.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SaveBA.setText("Lưu");
        jButton_SaveBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveBAActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_SaveBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        jButton_CancelBA.setBackground(new java.awt.Color(255, 51, 0));
        jButton_CancelBA.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_CancelBA.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CancelBA.setText("Huỷ");
        jButton_CancelBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelBAActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_CancelBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        jButton_EditBA.setBackground(new java.awt.Color(255, 153, 0));
        jButton_EditBA.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_EditBA.setForeground(new java.awt.Color(255, 255, 255));
        jButton_EditBA.setText("Sửa");
        jButton_EditBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditBAActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_EditBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 70, -1));

        jButton_AddBA_Org.setBackground(new java.awt.Color(51, 153, 0));
        jButton_AddBA_Org.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_AddBA_Org.setForeground(new java.awt.Color(255, 255, 255));
        jButton_AddBA_Org.setText("Thêm");
        jButton_AddBA_Org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddBA_OrgActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_AddBA_Org, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 70, -1));

        jButton_DeleteBA.setBackground(new java.awt.Color(255, 0, 51));
        jButton_DeleteBA.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_DeleteBA.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DeleteBA.setText("Xoá");
        jButton_DeleteBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteBAActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_DeleteBA, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 70, -1));

        jButton_ViewDetail.setBackground(new java.awt.Color(0, 153, 204));
        jButton_ViewDetail.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_ViewDetail.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ViewDetail.setText("Xem chi tiết");
        jButton_ViewDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ViewDetailMouseClicked(evt);
            }
        });
        jButton_ViewDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ViewDetailActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton_ViewDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardSinhHoat.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

        jplMain.add(cardSinhHoat, "card3");

        cardViewDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 51, 51));
        jLabel44.setText("Danh Sách Đảng Viên Tham Gia");
        cardViewDetail.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 290, 30));

        jTable_ViewDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Buổi Sinh Hoạt", "Mã Đảng viên", "Họ và Tên", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ViewDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ViewDetailMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable_ViewDetail);

        cardViewDetail.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 90, 920, 180));

        buttonBack.setBackground(new java.awt.Color(102, 204, 0));
        buttonBack.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        buttonBack.setForeground(new java.awt.Color(255, 255, 255));
        buttonBack.setText("Trở về");
        buttonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBackMouseClicked(evt);
            }
        });
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        cardViewDetail.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 530, 100, -1));

        jLabel22.setText("Họ và Tên:");
        cardViewDetail.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));
        cardViewDetail.add(TextFieldHoTen_VD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 167, -1));

        jLabel37.setText("Mã Đảng viên:");
        cardViewDetail.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));
        cardViewDetail.add(jTextField_IDmemberVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 126, -1));

        jComboBox_VD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Hoàn Thành", "Chưa Hoàn Thành", "Đã Đăng Ký" }));
        cardViewDetail.add(jComboBox_VD, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 167, -1));

        jLabel27.setText("Trạng thái");
        cardViewDetail.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        jButton_SaveVD.setBackground(new java.awt.Color(51, 204, 0));
        jButton_SaveVD.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_SaveVD.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SaveVD.setText("Lưu");
        cardViewDetail.add(jButton_SaveVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));

        jButton_CancelVD.setBackground(new java.awt.Color(255, 51, 0));
        jButton_CancelVD.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton_CancelVD.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CancelVD.setText("Huỷ");
        cardViewDetail.add(jButton_CancelVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        jButton_DanhGiaVD.setBackground(new java.awt.Color(0, 153, 204));
        jButton_DanhGiaVD.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jButton_DanhGiaVD.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DanhGiaVD.setText("Đánh Giá");
        cardViewDetail.add(jButton_DanhGiaVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Đánh Giá Đảng Viên:");
        cardViewDetail.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 220, -1));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardViewDetail.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

        jplMain.add(cardViewDetail, "card3");

        jPanel1.add(jplMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 950, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblThanhTichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThanhTichMouseClicked
        // TODO add your handling code here:
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(false);
        cardThanhTich.setVisible(true);
        cardKyLuat.setVisible(false);
        cardViewDetail.setVisible(false);
        cardDangVien.setVisible(false);
    }//GEN-LAST:event_lblThanhTichMouseClicked

    private void lblSinhHoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSinhHoatMouseClicked
        cardDangVien.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(false);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(false);
        cardSinhHoat.setVisible(true);
        cardViewDetail.setVisible(false);
        
        ViewBranchActivityOrg();
        ViewTableBranchActivityORG();
    }//GEN-LAST:event_lblSinhHoatMouseClicked

    private void lblKyLuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKyLuatMouseClicked
        // TODO add your handling code here:
        cardViewDetail.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(false);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(true);
        cardDangVien.setVisible(false);
    }//GEN-LAST:event_lblKyLuatMouseClicked

    private void lblDangBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangBoMouseClicked
        // TODO add your handling code here:
        cardViewDetail.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(true);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(false);
        cardDangVien.setVisible(false);
    }//GEN-LAST:event_lblDangBoMouseClicked

    private void lblDangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangVienMouseClicked
        // TODO add your handling code here:
        cardViewDetail.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(false);
        cardDangVien.setVisible(true);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(false);
    }//GEN-LAST:event_lblDangVienMouseClicked

    private void TextFieldSearchDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldSearchDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldSearchDVActionPerformed

    private void btnEditDvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDvActionPerformed
        // TODO add your handling code here:
        OnOffDangVien(false, true,false);
    }//GEN-LAST:event_btnEditDvActionPerformed

    private void btnSaveDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDVActionPerformed
        // TODO add your handling code here:
        
        String fullName = this.TextFieldHoTen.getText();
        String id = this.TextFieldID.getText();
        String birthDate = this.TextFieldNgaySinh.getText();
        String orgId = this.TextFieldOrgID.getText();
        String joinDate = this.TextFieldNgayVao.getText();
        String position = this.TextFieldPosition.getText();
        String email = this.TextFieldEmail.getText();
        String phoneNumber = this.TextFieldPhoneNumber.getText();
        String address = this.TextFieldAddress.getText();
        
        PartyMemberAdd add = new PartyMemberAdd();
        add.addPartyMember(null, id, fullName, birthDate, joinDate, address, email, phoneNumber, position, orgId);
        
        listDV = ListPartyMember.getAllPartyMembers();
        ViewDangVien();
        viewTableDv();
        
    }//GEN-LAST:event_btnSaveDVActionPerformed

    private void btnCancelDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDVActionPerformed
        // TODO add your handling code here:
        ViewDangVien();
    }//GEN-LAST:event_btnCancelDVActionPerformed

    private void lblYeuCauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblYeuCauMouseClicked
        // TODO add your handling code here:
        cardViewDetail.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(true);
        cardDangBo.setVisible(false);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(false);
    }//GEN-LAST:event_lblYeuCauMouseClicked

    private void jButton_DeleteBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteBAActionPerformed
        // TODO add your handling code here:
        String idBA = this.jTextField_IDBA_Org.getText();
        
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá buổi sinh hoạt này không?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            BranchActivityDelete delete = new BranchActivityDelete();
            delete.deleteBranchActivity(idBA);
            
            //listBA = List_BranchActivity_Org.getBranchActivities();
            
            ViewBranchActivityOrg();
            ViewTableBranchActivityORG();
        } else {
            // If the user clicks "No", simply return
            JOptionPane.showMessageDialog(null, "Huỷ bỏ huỷ đăng ký.");
        }
        
    }//GEN-LAST:event_jButton_DeleteBAActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBackMouseClicked
        // TODO add your handling code here:
        cardSinhHoat.setVisible(true);
        cardViewDetail.setVisible(false);
    }//GEN-LAST:event_buttonBackMouseClicked

    private void jButton_ViewDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ViewDetailMouseClicked
        // TODO add your handling code here:
        cardSinhHoat.setVisible(false);
        cardViewDetail.setVisible(true);
        
        String idBA = this.jTextField_IDBA_Org.getText();
        listSBA = List_SignBranchActivity_Org.getSignBranchActivity(idBA);
    }//GEN-LAST:event_jButton_ViewDetailMouseClicked

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void TextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldEmailActionPerformed

    private void TextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldIDActionPerformed

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void TextFieldPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPhoneNumberActionPerformed

    private void TextFieldOrgIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldOrgIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldOrgIDActionPerformed

    private void btnAddDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDVActionPerformed
        // TODO add your handling code here:
        this.TextFieldID.setText("");
        this.TextFieldNgaySinh.setText("");
        this.TextFieldHoTen.setText("");
        this.TextFieldOrgID.setText("");
        this.TextFieldNgayVao.setText("");
        this.TextFieldPosition.setText("");
        this.TextFieldEmail.setText("");
        this.TextFieldPhoneNumber.setText("");
        this.TextFieldAddress.setText("");
        
        checkSaveDV = 1;
        
        OnOffDangVien(false, false, true);
    }//GEN-LAST:event_btnAddDVActionPerformed

    private void btnEditDV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDV2ActionPerformed
        // TODO add your handling code here:
        OnOffDangVien(false, false, true);
    }//GEN-LAST:event_btnEditDV2ActionPerformed

    private void btnDeleteDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDVActionPerformed
        // TODO add your handling code here:
        String id = this.TextFieldID.getText();
        PartyMemberDelete dao = new PartyMemberDelete();
        dao.deletePartyMember(id);
        listDV = ListPartyMember.getAllPartyMembers();
        
        pos = 0;
        ViewDangVien();
        viewTableDv();
    }//GEN-LAST:event_btnDeleteDVActionPerformed

    private void TableDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDVMouseClicked
        // TODO add your handling code here:
        pos = this.TableDV.getSelectedRow();
        ViewDangVien();
    }//GEN-LAST:event_TableDVMouseClicked

    private void TableDVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableDVKeyReleased
        // TODO add your handling code here:
        pos = this.TableDV.getSelectedRow();
        ViewDangVien();
    }//GEN-LAST:event_TableDVKeyReleased

    private void ButtonSearchDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchDVActionPerformed
        // TODO add your handling code here:
        String searchInput = this.TextFieldSearchDV.getText();
        if(SearchPM.checkIdInDatabase(searchInput))
        {
            JOptionPane.showMessageDialog(null, "Thành công!");
            int count = 0;
            for(PartyMember lpm: listDV)
            {
                if(lpm.getId().equals(searchInput))
                {
                    break;
                }
                count ++;
            }
            pos = count;
        }
        else{
            JOptionPane.showMessageDialog(null, "Không tìm thấy Đảng Viên!");
        }
        ViewDangVien();
    }//GEN-LAST:event_ButtonSearchDVActionPerformed

    private void jTable_BranchActivity_OrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BranchActivity_OrgMouseClicked
        // TODO add your handling code here:
        posBA = this.jTable_BranchActivity_Org.getSelectedRow();
        ViewBranchActivityOrg();
    }//GEN-LAST:event_jTable_BranchActivity_OrgMouseClicked
    
    public void OnOff_BranchActivity_Feature(boolean a, boolean b, boolean c, boolean d)
    {
        this.jButton_AddBA_Org.show(a);
        this.jButton_DeleteBA.show(b);
        this.jButton_EditBA.show(c);
        
        this.jButton_SaveBA.show(d);
        this.jButton_CancelBA.show(d);
    }
    private void jButton_AddBA_OrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddBA_OrgActionPerformed
        // TODO add your handling code here:
        this.jTextField_StartDate_Org.setText("");
        this.jTextField_EndDate_Org.setText("");
        this.jTextField_IDBA_Org.setText("");
        this.jTextField_NameBA_Org.setText("");
        this.jEditorPane_DetailBA_Org.setText("");
        
        checkPointSaveBranchActivity = 1; 
        
        OnOff_BranchActivity_Feature(false, false, false, true);
    }//GEN-LAST:event_jButton_AddBA_OrgActionPerformed

    private void jButton_EditBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditBAActionPerformed
        // TODO add your handling code here:
        checkPointSaveBranchActivity = 2;
        OnOff_BranchActivity_Feature(false, false, false, true);
    }//GEN-LAST:event_jButton_EditBAActionPerformed
    
    
    private void jButton_SaveBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveBAActionPerformed
        // TODO add your handling code here:
        String idBA = this.jTextField_IDBA_Org.getText();
        String nameBA = this.jTextField_NameBA_Org.getText();
        String startDate = this.jTextField_StartDate_Org.getText();
        String endDate = this.jTextField_EndDate_Org.getText();
        String detail = this.jEditorPane_DetailBA_Org.getText();
        String orgId = IDorg;
        
        if(checkPointSaveBranchActivity == 1){
            BranchActivityAdd add = new BranchActivityAdd();
            add.addBranchActivity(idBA, nameBA, startDate, endDate, detail, orgId);
           // listBA = List_BranchActivity_Org.getBranchActivities();
            
            checkPointSaveBranchActivity = 0;
            
            JOptionPane.showMessageDialog(null, "Đã thêm thành công!");
            
            ViewBranchActivityOrg();
            ViewTableBranchActivityORG();
        }else if (checkPointSaveBranchActivity == 2){
            BranchActivityEdit edit = new BranchActivityEdit();
            edit.updateBranchActivity(idBA, nameBA, startDate, endDate, detail, orgId);
          //  listBA = List_BranchActivity_Org.getBranchActivities();
            
            checkPointSaveBranchActivity = 0;
            JOptionPane.showMessageDialog(null, "Đã sửa thành công!");
            ViewBranchActivityOrg();
            ViewTableBranchActivityORG();
        }
         
        
    }//GEN-LAST:event_jButton_SaveBAActionPerformed

    private void jButton_CancelBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelBAActionPerformed
        // TODO add your handling code here:
        ViewBranchActivityOrg();
        ViewTableBranchActivityORG();
    }//GEN-LAST:event_jButton_CancelBAActionPerformed
    
    public BranchActivity findActivityById(String id) {
        for (BranchActivity activity : listBA) {
            if (activity.getId().equals(id)) {
                return activity;  // Trả về đối tượng nếu tìm thấy
            }
        }
        return null;  // Trả về null nếu không tìm thấy
    }
    private void jButton_SearchBA_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchBA_orgActionPerformed
        // TODO add your handling code here:
        String id = this.jTextField_SearchBA_org.getText();
        
        BranchActivity activity = findActivityById(id);
        if (activity != null) {
            
            this.jTextField_NameBA_Org.setText(activity.getActivityName());
            this.jTextField_IDBA_Org.setText(activity.getId());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String birthDateString = formatter.format(activity.getStartDate());
            String joinDateString = formatter.format(activity.getEndDate());

            this.jTextField_StartDate_Org.setText(birthDateString);
            this.jTextField_EndDate_Org.setText(joinDateString);
            
            this.jEditorPane_DetailBA_Org.setText(activity.getDescription());
            
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy buổi sinh hoạt với ID này.");
            System.out.println("Không tìm thấy buổi sinh hoạt với ID này.");
        }
        
    }//GEN-LAST:event_jButton_SearchBA_orgActionPerformed
    private void loadBranchActivityToTable(String x){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // Câu truy vấn SQL với tham số
            String sql = "SELECT id, activityName, startDate, endDate, description FROM BranchActivity WHERE orgId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, x);
            result = pstmt.executeQuery();
            
            DefaultTableModel modelUser = (DefaultTableModel) this.jTable_BranchActivity_Org.getModel();
            modelUser.setNumRows(0);
            while(result.next()){
                String id = result.getString("id");
                String orgId = result.getString("activityName");
                Date dateStart = result.getDate("startDate");
                Date dateEnd = result.getDate("endDate");
                String detail = result.getString("description");
                modelUser.addRow(new Object[]{id, orgId, dateStart, dateEnd, detail});
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private void loadThanhTichToTable(String x){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // Câu truy vấn SQL với tham số
            String sql = "SELECT id, orgId, orgName, datedc, detail FROM thanhtichOrg WHERE orgId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, x);
            result = pstmt.executeQuery();
            int index = 0;
            
            DefaultTableModel modelUser = (DefaultTableModel) this.jTableDBTT.getModel();
            modelUser.setNumRows(0);
            while(result.next()){
                String id = result.getString("id");
                String orgId = result.getString("orgId");
                String orgName = result.getString("orgName");
                Date date = result.getDate("datedc");
                String detail = result.getString("detail");
                index++;
                modelUser.addRow(new Object[]{index, id, orgId, orgName, date, detail});
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    
    private void loadViPhamToTable(String x){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // Câu truy vấn SQL với tham số
            String sql = "SELECT id, orgId, orgName, datedc, detail FROM saiphamOrg WHERE orgId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, x);
            result = pstmt.executeQuery();
            int index = 0;
            DefaultTableModel modelUser = (DefaultTableModel) this.jTableDBVP.getModel();
            modelUser.setNumRows(0);
            while(result.next()){
                String id = result.getString("id");
                String orgId = result.getString("orgId");
                String orgName = result.getString("orgName");
                Date date = result.getDate("datedc");
                String detail = result.getString("detail");
                index++;
                modelUser.addRow(new Object[]{index, id, orgId , orgName, date, detail});
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    
    private void viewDB(String x){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // Câu truy vấn SQL với tham số
            String sql = "SELECT id, orgName, creationDate FROM PartyOrganization WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, x);
            result = pstmt.executeQuery();
            if(result.next()){
                jTextFieldDBNAME.setText(result.getString("orgName"));
                jTextFieldIDDB.setText(result.getString("id"));
                jTextFieldDBDATE.setText(result.getString("creationDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private void jTableDBTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDBTTMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTableDBTTMouseClicked

    private void jTextFieldDBNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDBNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDBNAMEActionPerformed

    private void jButton_ViewDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ViewDetailActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton_ViewDetailActionPerformed

    private void jTable_ViewDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ViewDetailMouseClicked
        // TODO add your handling code here:
        posSBA = this.jTable_ViewDetail.getSelectedRow();
        ViewDetail();
    }//GEN-LAST:event_jTable_ViewDetailMouseClicked

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
            java.util.logging.Logger.getLogger(Organization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Organization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Organization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Organization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Organization().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMenu;
    private javax.swing.JButton ButtonSearchDV;
    private javax.swing.JTable TableDV;
    private javax.swing.JTextField TextFieldAddress;
    private javax.swing.JTextField TextFieldEmail;
    private javax.swing.JTextField TextFieldHoTen;
    private javax.swing.JTextField TextFieldHoTen_VD;
    private javax.swing.JTextField TextFieldID;
    private javax.swing.JTextField TextFieldNgaySinh;
    private javax.swing.JTextField TextFieldNgayVao;
    private javax.swing.JTextField TextFieldOrgID;
    private javax.swing.JTextField TextFieldPhoneNumber;
    private javax.swing.JTextField TextFieldPosition;
    private javax.swing.JTextField TextFieldSearchDV;
    private javax.swing.JTextField TextFieldSearchIN;
    private javax.swing.JTextField TextFieldSearchOUT;
    private javax.swing.JButton btnAddDV;
    private javax.swing.JButton btnCancelDV;
    private javax.swing.JButton btnDeleteDV;
    private javax.swing.JButton btnEditDV2;
    private javax.swing.JButton btnEditDv;
    private javax.swing.JButton btnSaveDV;
    private javax.swing.JButton buttonBack;
    private javax.swing.JPanel cardDangBo;
    private javax.swing.JPanel cardDangVien;
    private javax.swing.JPanel cardKyLuat;
    private javax.swing.JPanel cardSinhHoat;
    private javax.swing.JPanel cardThanhTich;
    private javax.swing.JPanel cardViewDetail;
    private javax.swing.JPanel cardYeuCau;
    private javax.swing.JLabel jBacground;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton_AddBA_Org;
    private javax.swing.JButton jButton_CancelBA;
    private javax.swing.JButton jButton_CancelVD;
    private javax.swing.JButton jButton_DanhGiaVD;
    private javax.swing.JButton jButton_DeleteBA;
    private javax.swing.JButton jButton_EditBA;
    private javax.swing.JButton jButton_SaveBA;
    private javax.swing.JButton jButton_SaveVD;
    private javax.swing.JButton jButton_SearchBA_org;
    private javax.swing.JButton jButton_ViewDetail;
    private javax.swing.JComboBox<String> jComboBox_VD;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane3;
    private javax.swing.JEditorPane jEditorPane4;
    private javax.swing.JEditorPane jEditorPane6;
    private javax.swing.JEditorPane jEditorPane7;
    private javax.swing.JEditorPane jEditorPane_DetailBA_Org;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTableDBTT;
    private javax.swing.JTable jTableDBVP;
    private javax.swing.JTable jTable_BranchActivity_Org;
    private javax.swing.JTable jTable_ViewDetail;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldDBDATE;
    private javax.swing.JTextField jTextFieldDBNAME;
    private javax.swing.JTextField jTextFieldIDDB;
    private javax.swing.JTextField jTextField_EndDate_Org;
    private javax.swing.JTextField jTextField_IDBA_Org;
    private javax.swing.JTextField jTextField_IDmemberVD;
    private javax.swing.JTextField jTextField_NameBA_Org;
    private javax.swing.JTextField jTextField_SearchBA_org;
    private javax.swing.JTextField jTextField_StartDate_Org;
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplSlideMenu;
    private javax.swing.JPanel jplTitle;
    private javax.swing.JLabel lblDangBo;
    private javax.swing.JLabel lblDangVien;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblKyLuat;
    private javax.swing.JLabel lblSinhHoat;
    private javax.swing.JLabel lblThanhTich;
    private javax.swing.JLabel lblYeuCau;
    // End of variables declaration//GEN-END:variables
}
