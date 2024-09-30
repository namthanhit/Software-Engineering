/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Class.PartyOrganization;
import Class.User;
import Database.AdminDatabase;
//import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author User
 */
public class Admin extends javax.swing.JFrame {
    private int selectIdx;
    private static final String jdbcURL = AdminDatabase.DATABASE_URL;
    private static final String username = AdminDatabase.DATABASE_USERNAME;
    private static final String password = AdminDatabase.DATABASE_PASSWORD;
    public Admin() {
        initComponents();
        cardTaoTK.setVisible(false);
        cardQLTK.setVisible(true);
        cardQLOrg.setVisible(false);
        loadUserToTablePQ();
        jTextFieldPQID.setEditable(false);
        jTextFieldPQMK.setEditable(false);
        jTextFieldPQorgID.setEditable(false);
        TextFieldQLID.setEditable(false);
        jTextFieldQLName.setEditable(false);
        jTextFieldQLorgID.setEditable(false);
        UIManager.put("Panel.background", Color.WHITE); // Màu nền
        UIManager.put("OptionPane.messageForeground", Color.RED);
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jplSlideMenu = new javax.swing.JPanel();
        lblQLTK = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDangXuat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTaoTK = new javax.swing.JLabel();
        lblQuanLiTC = new javax.swing.JLabel();
        BackgroundMenu = new javax.swing.JLabel();
        jplTitle = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jplMain = new javax.swing.JPanel();
        cardQLTK = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldPQID = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldPQMK = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jTextFieldPQorgID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPQSearchID = new javax.swing.JTextField();
        jComboBoxPQ = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jButtonQLTKXoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cardTaoTK = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        TextFieldQLID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableQL = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jTextFieldQLorgID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldCr2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldQLName = new javax.swing.JTextField();
        jPasswordFieldCr1 = new javax.swing.JPasswordField();
        showPassword = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxQLRole = new javax.swing.JComboBox<>();
        jLabelWarning2 = new javax.swing.JLabel();
        jLabelWarning1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cardQLOrg = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        TextFieldQLOrgId = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableQLOrg = new javax.swing.JTable();
        jButtonQLOrgThem = new javax.swing.JButton();
        jButtonQLOrgXoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQLOrgName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonQLOrgSua = new javax.swing.JButton();
        jTextFieldIDSearch = new javax.swing.JTextField();
        jButtonQLOrgTim = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextFieldDate = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();

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

        lblQLTK.setBackground(new java.awt.Color(255, 255, 255));
        lblQLTK.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQLTK.setForeground(new java.awt.Color(255, 255, 255));
        lblQLTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQLTK.setText("Quản Lí Tài Khoản");
        lblQLTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLTKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQLTKMouseEntered(evt);
            }
        });
        jplSlideMenu.add(lblQLTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 30));
        jplSlideMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 452, 210, 10));

        lblDangXuat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 51, 0));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("Đăng Xuất");
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

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Quản trị viên");
        jplSlideMenu.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N
        jplSlideMenu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));
        jplSlideMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 20));

        lblTaoTK.setBackground(new java.awt.Color(255, 255, 255));
        lblTaoTK.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTaoTK.setForeground(new java.awt.Color(255, 255, 255));
        lblTaoTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTaoTK.setText("Tạo Tài Khoản");
        lblTaoTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaoTKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTaoTKMouseEntered(evt);
            }
        });
        jplSlideMenu.add(lblTaoTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 190, 40));

        lblQuanLiTC.setBackground(new java.awt.Color(255, 255, 255));
        lblQuanLiTC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQuanLiTC.setForeground(new java.awt.Color(255, 255, 255));
        lblQuanLiTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuanLiTC.setText("Quản Lí Tổ Chức");
        lblQuanLiTC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLiTCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuanLiTCMouseEntered(evt);
            }
        });
        jplSlideMenu.add(lblQuanLiTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 190, 40));

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

        cardQLTK.setBackground(new java.awt.Color(255, 255, 255));
        cardQLTK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("Quản Lí Tài Khoản");
        cardQLTK.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, 42));

        jTextFieldPQID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPQIDActionPerformed(evt);
            }
        });
        cardQLTK.add(jTextFieldPQID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, -1));

        jLabel18.setText("ID:");
        cardQLTK.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 90, -1));

        jLabel31.setText("Mật Khẩu:");
        cardQLTK.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 70, -1));

        jTextFieldPQMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPQMKActionPerformed(evt);
            }
        });
        cardQLTK.add(jTextFieldPQMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, -1));

        jLabel32.setText("ID Tổ Chức:");
        cardQLTK.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 80, -1));

        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mật Khẩu", "Tên Tổ Chức", "Phân Quyền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableUser);

        cardQLTK.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 324, 940, 250));

        jButton12.setBackground(new java.awt.Color(0, 204, 51));
        jButton12.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Phân Quyền");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        cardQLTK.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 100, 30));

        jTextFieldPQorgID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPQorgIDActionPerformed(evt);
            }
        });
        cardQLTK.add(jTextFieldPQorgID, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 130, -1));

        jLabel2.setText("Phân Quyền:");
        cardQLTK.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 80, -1));

        jTextFieldPQSearchID.setText("Nhập ID");
        jTextFieldPQSearchID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldPQSearchIDMouseClicked(evt);
            }
        });
        jTextFieldPQSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPQSearchIDActionPerformed(evt);
            }
        });
        cardQLTK.add(jTextFieldPQSearchID, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 160, -1));

        jComboBoxPQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đảng Viên", "Tổ Chức" }));
        jComboBoxPQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPQActionPerformed(evt);
            }
        });
        cardQLTK.add(jComboBoxPQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 130, -1));

        jButton14.setBackground(new java.awt.Color(255, 255, 102));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton14.setText("Tìm Kiếm");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        cardQLTK.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, -1, -1));

        jButtonQLTKXoa.setBackground(new java.awt.Color(255, 0, 51));
        jButtonQLTKXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonQLTKXoa.setForeground(new java.awt.Color(255, 255, 255));
        jButtonQLTKXoa.setText("Xóa");
        jButtonQLTKXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQLTKXoaActionPerformed(evt);
            }
        });
        cardQLTK.add(jButtonQLTKXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 100, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cardQLTK.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 160, 20));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardQLTK.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardQLTK, "card2");

        cardTaoTK.setBackground(new java.awt.Color(255, 255, 255));
        cardTaoTK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Tạo Tài Khoản");
        cardTaoTK.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 120, 42));

        TextFieldQLID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldQLIDActionPerformed(evt);
            }
        });
        cardTaoTK.add(TextFieldQLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, -1));

        jLabel17.setText("ID:");
        cardTaoTK.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 90, -1));

        jLabel29.setText("Mật Khẩu:");
        cardTaoTK.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 70, 20));

        jLabel30.setText("ID Tổ Chức");
        cardTaoTK.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 80, -1));

        jTableQL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Họ Tên", "ID Tổ Chức"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableQL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableQLMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableQL);

        cardTaoTK.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 324, 940, 250));

        jButton6.setBackground(new java.awt.Color(0, 204, 51));
        jButton6.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Lưu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        cardTaoTK.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 100, 30));

        jTextFieldQLorgID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQLorgIDActionPerformed(evt);
            }
        });
        cardTaoTK.add(jTextFieldQLorgID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, -1));

        jLabel3.setText("Xác nhận mật khẩu:");
        cardTaoTK.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 110, -1));

        jPasswordFieldCr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldCr2ActionPerformed(evt);
            }
        });
        cardTaoTK.add(jPasswordFieldCr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 130, -1));

        jLabel4.setText("Họ và tên:");
        cardTaoTK.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));
        cardTaoTK.add(jTextFieldQLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 130, -1));
        cardTaoTK.add(jPasswordFieldCr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 130, -1));

        showPassword.setText("Ẩn/Hiện Mật Khẩu");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });
        cardTaoTK.add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, -1, -1));

        jLabel1.setText("Phân Quyền");
        cardTaoTK.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 80, -1));

        jComboBoxQLRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đảng Viên", "Tổ Chức" }));
        jComboBoxQLRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxQLRoleActionPerformed(evt);
            }
        });
        cardTaoTK.add(jComboBoxQLRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 130, -1));

        jLabelWarning2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelWarning2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabelWarning2.setForeground(new java.awt.Color(255, 51, 51));
        jLabelWarning2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelWarning2.setToolTipText("");
        cardTaoTK.add(jLabelWarning2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 130, 20));

        jLabelWarning1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelWarning1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabelWarning1.setForeground(new java.awt.Color(255, 51, 51));
        jLabelWarning1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cardTaoTK.add(jLabelWarning1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 170, 20));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardTaoTK.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardTaoTK, "card2");

        cardQLOrg.setBackground(new java.awt.Color(255, 255, 255));
        cardQLOrg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Quản Lí Tổ Chức");
        cardQLOrg.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 130, 42));

        TextFieldQLOrgId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldQLOrgIdActionPerformed(evt);
            }
        });
        cardQLOrg.add(TextFieldQLOrgId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, -1));

        jLabel20.setText("ID:");
        cardQLOrg.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 90, -1));

        jTableQLOrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Tên Tổ Chức", "Ngày Thành Lập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableQLOrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableQLOrgMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableQLOrg);

        cardQLOrg.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 324, 940, 250));

        jButtonQLOrgThem.setBackground(new java.awt.Color(0, 204, 51));
        jButtonQLOrgThem.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButtonQLOrgThem.setForeground(new java.awt.Color(255, 255, 255));
        jButtonQLOrgThem.setText("Thêm");
        jButtonQLOrgThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQLOrgThemActionPerformed(evt);
            }
        });
        cardQLOrg.add(jButtonQLOrgThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 100, 30));

        jButtonQLOrgXoa.setBackground(new java.awt.Color(255, 0, 0));
        jButtonQLOrgXoa.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButtonQLOrgXoa.setForeground(new java.awt.Color(255, 255, 255));
        jButtonQLOrgXoa.setText("Xóa");
        jButtonQLOrgXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQLOrgXoaActionPerformed(evt);
            }
        });
        cardQLOrg.add(jButtonQLOrgXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 100, 30));

        jLabel6.setText("Tên Tổ Chức");
        cardQLOrg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 70, -1));

        jTextFieldQLOrgName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQLOrgNameActionPerformed(evt);
            }
        });
        cardQLOrg.add(jTextFieldQLOrgName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 130, -1));

        jLabel7.setText("Ngày Thành Lập: ");
        cardQLOrg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 100, -1));

        jButtonQLOrgSua.setText("Sửa");
        jButtonQLOrgSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQLOrgSuaActionPerformed(evt);
            }
        });
        cardQLOrg.add(jButtonQLOrgSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 100, 30));

        jTextFieldIDSearch.setText("Nhập ID:");
        jTextFieldIDSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldIDSearchMouseClicked(evt);
            }
        });
        cardQLOrg.add(jTextFieldIDSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 130, -1));

        jButtonQLOrgTim.setBackground(new java.awt.Color(255, 255, 51));
        jButtonQLOrgTim.setText("Tìm Kiếm");
        jButtonQLOrgTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQLOrgTimActionPerformed(evt);
            }
        });
        cardQLOrg.add(jButtonQLOrgTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cardQLOrg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 140, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Định dạng yyyy-MM-dd VD:2020-01-29");
        cardQLOrg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 220, 20));
        cardQLOrg.add(jFormattedTextFieldDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 130, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardQLOrg.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardQLOrg, "card2");

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

    private void loadUserToTablePQ(){
        java.sql.Connection connection = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT partyMemberId, password, partOrgId, role from User";
            
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            DefaultTableModel modelUser = (DefaultTableModel) this.jTableUser.getModel();
            modelUser.setNumRows(0);
            int index = 0;
            while(resultSet.next()){
                String partyMemberId = resultSet.getString("partyMemberId");
                String Password = resultSet.getString("password");
                String orgId = resultSet.getString("partOrgId");
                boolean role = resultSet.getBoolean("role");
                index++;
                if(role)
                    modelUser.addRow(new Object[]{index, partyMemberId, Password,orgId, "Tổ Chức"});
                else 
                    modelUser.addRow(new Object[]{index, partyMemberId, Password,orgId, "Đảng Viên"});
                            
            }
            

            // Nếu có kết quả trả về, tức là người dùng hợp l

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

        // Nếu không có kết quả, trả về false
    }
    private void loadMemberNoUserToTable(){
        
        
        java.sql.Connection connection = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT PartyMember.id, PartyMember.fullName, PartyMember.orgId from PartyMember "
                    + "LEFT JOIN User on PartyMember.id = User.partyMemberId WHERE User.partyMemberId IS NULL";
            
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            DefaultTableModel modelUserQL = (DefaultTableModel) this.jTableQL.getModel();
            modelUserQL.setNumRows(0);
            int index = 0;
            while(resultSet.next()){
                String partyMemberId = resultSet.getString("id");
                String orgId = resultSet.getString("orgId");
                String fullName = resultSet.getString("fullName");
                index++;
                modelUserQL.addRow(new Object[]{index, partyMemberId, fullName,orgId});
                            
            }
            

            // Nếu có kết quả trả về, tức là người dùng hợp l

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
    private void updateUserToTable(User userLatest){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "UPDATE User SET partOrgId = ? , password = ? , role = ? WHERE partyMemberId = ?";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1, userLatest.getPartOrgId());
            pstmt.setString(2, userLatest.getPassword());
            pstmt.setBoolean(3, userLatest.getRole());
            pstmt.setString(4, userLatest.getPartyMemberId());
            pstmt.executeUpdate();
            // Nếu có kết quả trả về, tức là người dùng hợp l

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close(); // Đóng PreparedStatement
                }
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private void insertUser(User userLatest){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "INSERT INTO User (partyMemberId, partOrgId, password, role) VALUE (?, ?, ?, ? )";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userLatest.getPartyMemberId());
            pstmt.setString(2, userLatest.getPartOrgId());
            pstmt.setString(3, userLatest.getPassword());
            pstmt.setBoolean(4, userLatest.getRole());
            
            pstmt.executeUpdate();
            // Nếu có kết quả trả về, tức là người dùng hợp l

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) {
                    pstmt.close(); // Đóng PreparedStatement
                }
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private void searchUser(String ID){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT *from User WHERE partyMemberId = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, ID);
            result = pstmt.executeQuery();
            DefaultTableModel modelUser = (DefaultTableModel) this.jTableUser.getModel();
            modelUser.setNumRows(0);
            int index = 0;
            if(result.next()){
                String partyMemberId = result.getString("partyMemberId");
                String Password = result.getString("password");
                String orgId = result.getString("partOrgId");
                boolean role = result.getBoolean("role");
                index++;
                if(role)
                    modelUser.addRow(new Object[]{index, partyMemberId, Password,orgId, "Tổ Chức"});
                else 
                    modelUser.addRow(new Object[]{index, partyMemberId, Password,orgId, "Đảng Viên"});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close(); // Đóng PreparedStatement
                }
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private void deleteUser(User user){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "DELETE from User WHERE partyMemberId = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getPartyMemberId());
            
            pstmt.executeUpdate();
            // Nếu có kết quả trả về, tức là người dùng hợp l

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
            try {
            if (pstmt != null) {
                pstmt.close(); // Đóng PreparedStatement
            }
            if (connection != null) {
                connection.close(); // Đóng Connection
            }
        } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
            e.printStackTrace();
        }
        }
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        jplSlideMenu.setSize(0, y);
//        x = 0;
    }//GEN-LAST:event_formWindowOpened

    private void lblQLTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLTKMouseClicked
        cardTaoTK.setVisible(false);
        cardQLTK.setVisible(true);
        cardQLOrg.setVisible(false);
        loadUserToTablePQ();
        
    }//GEN-LAST:event_lblQLTKMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        User insertUser = new User();
        insertUser.setPartyMemberId(TextFieldQLID.getText());
        insertUser.setPartOrgId(jTextFieldQLorgID.getText());
        if(jComboBoxQLRole.getSelectedItem().equals("Đảng Viên"))
            insertUser.setRole(false);
        else insertUser.setRole(false);
        boolean check = true;
        if(TextFieldQLID.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Chọn ID cần tạo ");
        }
        else{
            if(jPasswordFieldCr1.getPassword().length == 0){
                jLabelWarning1.setText("Nhập mật khẩu !");
            }
            else if(jPasswordFieldCr1.getPassword().length < 6){
                jLabelWarning1.setText("Mật khẩu phải có ít nhất 6 kí tự!");
            }
            else if(jPasswordFieldCr2.getPassword().length == 0 || !Arrays.equals(jPasswordFieldCr1.getPassword(), jPasswordFieldCr2.getPassword())){
                jLabelWarning1.setText("");
                jLabelWarning2.setText("Xác nhận lại mật khẩu !");
            }
            else {
                char[] password = jPasswordFieldCr2.getPassword();
                String passwordStr = new String(password);
                insertUser.setPassword(passwordStr);
                insertUser(insertUser);
                loadMemberNoUserToTable();
                TextFieldQLID.setText("");
                jTextFieldQLName.setText("");
                jTextFieldQLorgID.setText("");
                jPasswordFieldCr1.setText("");
                jPasswordFieldCr2.setText("");
                JOptionPane.showMessageDialog(rootPane, "DONE!");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
private void searchOrg(String ID){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT *from PartyOrganization WHERE id = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, ID);
            result = pstmt.executeQuery();
            DefaultTableModel modelUser = (DefaultTableModel) this.jTableQLOrg.getModel();
            modelUser.setNumRows(0);
            int index = 0;
            if(result.next()){
                String id = result.getString("id");
                String name = result.getString("orgName");
                Date date = result.getDate("creationDate");
                index++;
                modelUser.addRow(new Object[]{index, id, name, date});
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Không Tìm Thấy");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close(); // Đóng PreparedStatement
                }
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private void loadOrg(){
        java.sql.Connection connection = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT * from PartyOrganization";
            
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            DefaultTableModel modelUser = (DefaultTableModel) this.jTableQLOrg.getModel();
            modelUser.setNumRows(0);
            int index = 0;
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("orgName");
                Date date = resultSet.getDate("creationDate");
                index++;
                modelUser.addRow(new Object[]{index, id, name, date});       
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
    private void insertOrg(String id, String name, String date ){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "INSERT INTO PartyOrganization (id, orgName, creationDate) VALUE (?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setDate(3, java.sql.Date.valueOf(date));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) {
                    pstmt.close(); // Đóng PreparedStatement
                }
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private boolean checkValidOrg(String ID, String name, String date){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // Câu truy vấn SQL với tham số
            String sql = "SELECT * FROM PartyOrganization WHERE id = ? AND orgName = ? AND creationDate = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, ID);
            pstmt.setString(2, name);
            pstmt.setDate(3, java.sql.Date.valueOf(date));
            result = pstmt.executeQuery();
            if(result.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) {
                    pstmt.close(); // Đóng PreparedStatement
                }
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    private void deleteOrg(String id, String name, String date){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "DELETE from PartyOrganization WHERE id = ? AND orgName = ? AND creationDate = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);   
            pstmt.setString(2, name);  
            pstmt.setDate(3, java.sql.Date.valueOf(date));  
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally{
            try {
            if (pstmt != null) {
                pstmt.close(); // Đóng PreparedStatement
            }
            if (connection != null) {
                connection.close(); // Đóng Connection
            }
        } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
            e.printStackTrace();
        }
        }
    }
    private void updateOrg(String ID, String name, String date){
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // Câu truy vấn SQL với tham số
            String sql = "UPDATE PartyOrganization SET orgName = ? , creationDate = ? WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1, name);
            pstmt.setDate(2, java.sql.Date.valueOf(date));
            pstmt.setString(3, ID);
            pstmt.executeUpdate();
            // Nếu có kết quả trả về, tức là người dùng hợp l

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close(); // Đóng PreparedStatement
                }
                if (connection != null) {
                    connection.close(); // Đóng Connection
                }
            } catch (SQLException e) {
            // Xử lý lỗi khi đóng tài nguyên
                e.printStackTrace();
            }
        }
    }
    private void jTextFieldQLorgIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQLorgIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQLorgIDActionPerformed

    private void lblTaoTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaoTKMouseClicked
        // TODO add your handling code here:
        cardTaoTK.setVisible(true);
        cardQLTK.setVisible(false);
        cardQLOrg.setVisible(false);
        loadMemberNoUserToTable();
    }//GEN-LAST:event_lblTaoTKMouseClicked

    private void lblQLTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLTKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQLTKMouseEntered

    private void lblTaoTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaoTKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTaoTKMouseEntered

    private void TextFieldQLIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldQLIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldQLIDActionPerformed

    private void jTextFieldPQIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPQIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPQIDActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(jTextFieldPQID.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "CHỌN TÀI KHOẢN CẦN PHÂN QUYỀN");
        }
        else{
             User user = new User();
            user.setPartyMemberId(jTextFieldPQID.getText());
            user.setPartOrgId(jTextFieldPQorgID.getText());
            user.setPassword(jTextFieldPQMK.getText());
            if(jComboBoxPQ.getSelectedItem().equals("Đảng Viên"))
                user.setRole(false);
            else user.setRole(true);
            updateUserToTable(user);
            loadUserToTablePQ();
            JOptionPane.showMessageDialog(rootPane, "CẬP NHẬT THÀNH CÔNG");
            jTextFieldPQID.setText("");
            jTextFieldPQorgID.setText("");
            jTextFieldPQMK.setText("");
        }
       
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextFieldPQorgIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPQorgIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPQorgIDActionPerformed

    private void jTextFieldPQSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPQSearchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPQSearchIDActionPerformed

    private void jComboBoxPQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPQActionPerformed

    private void jPasswordFieldCr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldCr2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldCr2ActionPerformed

    private void jTableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserMouseClicked
        // TODO add your handling code here:
        User x = new User();
        selectIdx= jTableUser.getSelectedRow();
        jTextFieldPQID.setText((String) jTableUser.getValueAt(selectIdx, 1));
        jTextFieldPQMK.setText((String) jTableUser.getValueAt(selectIdx, 2));
        jTextFieldPQorgID.setText((String) jTableUser.getValueAt(selectIdx, 3));
        jComboBoxPQ.setSelectedItem(jTableUser.getValueAt(selectIdx, 4));
    }//GEN-LAST:event_jTableUserMouseClicked

    private void jTextFieldPQMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPQMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPQMKActionPerformed

    private void jTextFieldPQSearchIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPQSearchIDMouseClicked
        jTextFieldPQSearchID.setText("");
    }//GEN-LAST:event_jTextFieldPQSearchIDMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String ID = jTextFieldPQSearchID.getText();
        if(ID.equals("Nhập ID") || ID.equals("")){
            jLabel8.setText("Nhập ID cần tìm!");
        }
        else 
            searchUser(ID);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTableQLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableQLMouseClicked
        // TODO add your handling code here:
        User x = new User();
        selectIdx= jTableQL.getSelectedRow();
        TextFieldQLID.setText((String) jTableQL.getValueAt(selectIdx, 1));
        jTextFieldQLName.setText((String) jTableQL.getValueAt(selectIdx, 2));
        jTextFieldQLorgID.setText((String) jTableQL.getValueAt(selectIdx, 3));
    }//GEN-LAST:event_jTableQLMouseClicked

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        // TODO add your handling code here:
        if (showPassword.isSelected()) {
                    // Hiển thị mật khẩu
                    jPasswordFieldCr1.setEchoChar((char) 0);
                    jPasswordFieldCr2.setEchoChar((char) 0);
                } else {
                    // Ẩn mật khẩu
                    jPasswordFieldCr1.setEchoChar('*');
                    jPasswordFieldCr2.setEchoChar('*');
                }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void jComboBoxQLRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxQLRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxQLRoleActionPerformed

    private void TextFieldQLOrgIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldQLOrgIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldQLOrgIdActionPerformed

    private void jTableQLOrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableQLOrgMouseClicked
        // TODO add your handling code here:
        
        selectIdx= jTableQLOrg.getSelectedRow();
        TextFieldQLOrgId.setText((String) jTableQLOrg.getValueAt(selectIdx, 1));
        jTextFieldQLOrgName.setText((String) jTableQLOrg.getValueAt(selectIdx, 2));
        //jFormattedTextFieldDate.setText((Date)jTableQLOrg.getValueAt(selectIdx, 3));
        Date dateValue = (Date) jTableQLOrg.getValueAt(selectIdx, 3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(dateValue);
        jFormattedTextFieldDate.setText(formattedDate);
 
    }//GEN-LAST:event_jTableQLOrgMouseClicked
    private boolean checkDate(String dateString){
         String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // Thiết lập không cho phép các giá trị không hợp lệ
        try {
            // Phân tích chuỗi thành java.util.Date
            Date utilDate = sdf.parse(dateString);
            return true; // Nếu phân tích thành công, trả về true
        } catch (ParseException e) {
            return false; // Nếu gặp lỗi, trả về false
        }
    }
    private void jButtonQLOrgThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQLOrgThemActionPerformed
        // TODO add your handling code here:
        PartyOrganization x = new PartyOrganization();
        if(TextFieldQLOrgId.getText().equals("")||jTextFieldQLOrgName.getText().equals("")||jFormattedTextFieldDate.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin");
        }
        else if(checkDate(jFormattedTextFieldDate.getText()) == false){
            JOptionPane.showMessageDialog(this, "Nhập đúng định dạng ngày");
        }
        else if(checkDate(jFormattedTextFieldDate.getText()) == true){
            if(checkValidOrg(TextFieldQLOrgId.getText(), jTextFieldQLOrgName.getText(), jFormattedTextFieldDate.getText())){
                JOptionPane.showMessageDialog(this, "Id đã tồn tại!");
            }
            else{
                x.setId(TextFieldQLOrgId.getText());
                x.setOrgName(jTextFieldQLOrgName.getText());
                insertOrg(x.getId(), x.getOrgName(), jFormattedTextFieldDate.getText());
            }
        }
        loadOrg();
    }//GEN-LAST:event_jButtonQLOrgThemActionPerformed

    private void jButtonQLOrgXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQLOrgXoaActionPerformed
        // TODO add your handling code here:
        if(TextFieldQLOrgId.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "CHỌN TỔ CHỨC CẦN XÓA!");
        }
        else{
            if(checkValidOrg(TextFieldQLOrgId.getText(), jTextFieldQLOrgName.getText(), jFormattedTextFieldDate.getText()) == false){
                JOptionPane.showMessageDialog(rootPane, "TỔ CHỨC KHÔNG TỒN TẠI!");
            }
            else{
                deleteOrg(TextFieldQLOrgId.getText(), jTextFieldQLOrgName.getText(), jFormattedTextFieldDate.getText());
                loadUserToTablePQ();
                JOptionPane.showMessageDialog(rootPane, "DONE!");
                TextFieldQLOrgId.setText("");
                jTextFieldQLOrgName.setText("");
                jFormattedTextFieldDate.setText("");
            }
            
        }
        loadOrg();
    }//GEN-LAST:event_jButtonQLOrgXoaActionPerformed

    private void lblQuanLiTCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLiTCMouseClicked
        // TODO add your handling code here:
        cardTaoTK.setVisible(false);
        cardQLTK.setVisible(false);
        cardQLOrg.setVisible(true);
        loadOrg();
    }//GEN-LAST:event_lblQuanLiTCMouseClicked

    private void lblQuanLiTCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLiTCMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuanLiTCMouseEntered

    private void jButtonQLTKXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQLTKXoaActionPerformed
        // TODO add your handling code here:
        if(jTextFieldPQID.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "CHỌN TÀI KHOẢN CẦN XÓA!");
        }
        else{
            User user = new User();
            user.setPartyMemberId(jTextFieldPQID.getText());
            user.setPartOrgId(jTextFieldPQorgID.getText());
            user.setPassword(jTextFieldPQMK.getText());
            if(jComboBoxPQ.getSelectedItem().equals("Đảng Viên"))
                user.setRole(false);
            else user.setRole(true);
            deleteUser(user);
            loadUserToTablePQ();
            JOptionPane.showMessageDialog(rootPane, "DONE!");
            jTextFieldPQID.setText("");
            jTextFieldPQorgID.setText("");
            jTextFieldPQMK.setText("");
        }
    }//GEN-LAST:event_jButtonQLTKXoaActionPerformed

    private void jTextFieldQLOrgNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQLOrgNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQLOrgNameActionPerformed

    private void jTextFieldIDSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldIDSearchMouseClicked
        // TODO add your handling code here:
        jTextFieldIDSearch.setText("");
    }//GEN-LAST:event_jTextFieldIDSearchMouseClicked

    private void jButtonQLOrgTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQLOrgTimActionPerformed
        // TODO add your handling code here:
        String idSearch = jTextFieldIDSearch.getText();
        if(idSearch.equals("") || idSearch.equals("Nhập ID:")){
            jLabel5.setText("Nhập ID cần tìm kiếm");
        }
        else{
            searchOrg(idSearch);
            jLabel5.setText("");
        }
        
    }//GEN-LAST:event_jButtonQLOrgTimActionPerformed

    private void jButtonQLOrgSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQLOrgSuaActionPerformed
        // TODO add your handling code her
        if(TextFieldQLOrgId.getText().equals("")|| jTextFieldQLOrgName.getText().equals("")|| jFormattedTextFieldDate.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "CHỌN DÒNG CẦN SỬA!");
        }
        else{
             updateOrg(TextFieldQLOrgId.getText(), jTextFieldQLOrgName.getText(), jFormattedTextFieldDate.getText());
             loadOrg();
        }
    }//GEN-LAST:event_jButtonQLOrgSuaActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMenu;
    private javax.swing.JTextField TextFieldQLID;
    private javax.swing.JTextField TextFieldQLOrgId;
    private javax.swing.JPanel cardQLOrg;
    private javax.swing.JPanel cardQLTK;
    private javax.swing.JPanel cardTaoTK;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonQLOrgSua;
    private javax.swing.JButton jButtonQLOrgThem;
    private javax.swing.JButton jButtonQLOrgTim;
    private javax.swing.JButton jButtonQLOrgXoa;
    private javax.swing.JButton jButtonQLTKXoa;
    private javax.swing.JComboBox<String> jComboBoxPQ;
    private javax.swing.JComboBox<String> jComboBoxQLRole;
    private javax.swing.JTextField jFormattedTextFieldDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelWarning1;
    private javax.swing.JLabel jLabelWarning2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldCr1;
    private javax.swing.JPasswordField jPasswordFieldCr2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableQL;
    private javax.swing.JTable jTableQLOrg;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField jTextFieldIDSearch;
    private javax.swing.JTextField jTextFieldPQID;
    private javax.swing.JTextField jTextFieldPQMK;
    private javax.swing.JTextField jTextFieldPQSearchID;
    private javax.swing.JTextField jTextFieldPQorgID;
    private javax.swing.JTextField jTextFieldQLName;
    private javax.swing.JTextField jTextFieldQLOrgName;
    private javax.swing.JTextField jTextFieldQLorgID;
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplSlideMenu;
    private javax.swing.JPanel jplTitle;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblQLTK;
    private javax.swing.JLabel lblQuanLiTC;
    private javax.swing.JLabel lblTaoTK;
    private javax.swing.JCheckBox showPassword;
    // End of variables declaration//GEN-END:variables
}
