/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Class.User;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
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
    private static final String jdbcURL = "jdbc:mysql://127.0.0.1:3306/PartyManagement";
    private static final String username = "root";
    private static final String password = "Duong20012004";
    public Admin() {
        initComponents();
        cardQuanLi.setVisible(false);
        cardPhanQuyen.setVisible(true);
        cardCreateOrg.setVisible(false);
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
        lblPhanQuyen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDangXuat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblQuanLiTK = new javax.swing.JLabel();
        lblQuanLiTC = new javax.swing.JLabel();
        BackgroundMenu = new javax.swing.JLabel();
        jplTitle = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jplMain = new javax.swing.JPanel();
        cardPhanQuyen = new javax.swing.JPanel();
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
        jButton5 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        cardQuanLi = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        TextFieldQLID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableQL = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextFieldQLorgID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldCr2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldQLName = new javax.swing.JTextField();
        jPasswordFieldCr1 = new javax.swing.JPasswordField();
        showPassword = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxQLRole = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cardCreateOrg = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        TextFieldQLID1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableQL1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTextFieldQLorgID1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldCr3 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQLName1 = new javax.swing.JTextField();
        jPasswordFieldCr4 = new javax.swing.JPasswordField();
        showPassword1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxQLRole1 = new javax.swing.JComboBox<>();
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

        lblPhanQuyen.setBackground(new java.awt.Color(255, 255, 255));
        lblPhanQuyen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPhanQuyen.setForeground(new java.awt.Color(255, 255, 255));
        lblPhanQuyen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhanQuyen.setText("Phân Quyền");
        lblPhanQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhanQuyenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPhanQuyenMouseEntered(evt);
            }
        });
        jplSlideMenu.add(lblPhanQuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 30));
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

        lblQuanLiTK.setBackground(new java.awt.Color(255, 255, 255));
        lblQuanLiTK.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQuanLiTK.setForeground(new java.awt.Color(255, 255, 255));
        lblQuanLiTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuanLiTK.setText("Quản Lí Tài Khoản");
        lblQuanLiTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLiTKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuanLiTKMouseEntered(evt);
            }
        });
        jplSlideMenu.add(lblQuanLiTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 190, 40));

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

        cardPhanQuyen.setBackground(new java.awt.Color(255, 255, 255));
        cardPhanQuyen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("Phân Quyền Tài Khoản");
        cardPhanQuyen.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 42));

        jTextFieldPQID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPQIDActionPerformed(evt);
            }
        });
        cardPhanQuyen.add(jTextFieldPQID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 130, -1));

        jLabel18.setText("ID:");
        cardPhanQuyen.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 90, -1));

        jLabel31.setText("Mật Khẩu:");
        cardPhanQuyen.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 70, -1));

        jTextFieldPQMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPQMKActionPerformed(evt);
            }
        });
        cardPhanQuyen.add(jTextFieldPQMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 130, -1));

        jLabel32.setText("ID Tổ Chức:");
        cardPhanQuyen.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 80, -1));

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

        cardPhanQuyen.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 274, 940, 300));

        jButton12.setBackground(new java.awt.Color(0, 204, 51));
        jButton12.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Lưu");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        cardPhanQuyen.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 100, 30));

        jTextFieldPQorgID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPQorgIDActionPerformed(evt);
            }
        });
        cardPhanQuyen.add(jTextFieldPQorgID, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 130, -1));

        jLabel2.setText("Phân Quyền:");
        cardPhanQuyen.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 80, -1));

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
        cardPhanQuyen.add(jTextFieldPQSearchID, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 160, -1));

        jComboBoxPQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đảng Viên", "Tổ Chức" }));
        jComboBoxPQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPQActionPerformed(evt);
            }
        });
        cardPhanQuyen.add(jComboBoxPQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 130, -1));

        jButton14.setBackground(new java.awt.Color(255, 255, 102));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 102, 102));
        jButton14.setText("Tìm Kiếm");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        cardPhanQuyen.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, -1, -1));

        jButton5.setBackground(new java.awt.Color(204, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Chỉnh Sửa");
        cardPhanQuyen.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 100, 30));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardPhanQuyen.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardPhanQuyen, "card2");

        cardQuanLi.setBackground(new java.awt.Color(255, 255, 255));
        cardQuanLi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Tạo Tài Khoản");
        cardQuanLi.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 120, 42));

        TextFieldQLID.setText("ID");
        TextFieldQLID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldQLIDActionPerformed(evt);
            }
        });
        cardQuanLi.add(TextFieldQLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, -1));

        jLabel17.setText("ID:");
        cardQuanLi.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 90, -1));

        jLabel29.setText("Mật Khẩu:");
        cardQuanLi.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 70, 20));

        jLabel30.setText("ID Tổ Chức");
        cardQuanLi.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 80, -1));

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

        cardQuanLi.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 324, 940, 250));

        jButton6.setBackground(new java.awt.Color(0, 204, 51));
        jButton6.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Lưu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        cardQuanLi.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 100, 30));

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Huỷ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        cardQuanLi.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 100, 30));

        jTextFieldQLorgID.setText("ID Tổ Chức");
        jTextFieldQLorgID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQLorgIDActionPerformed(evt);
            }
        });
        cardQuanLi.add(jTextFieldQLorgID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, -1));

        jLabel3.setText("Xác nhận mật khẩu:");
        cardQuanLi.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 110, -1));

        jPasswordFieldCr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldCr2ActionPerformed(evt);
            }
        });
        cardQuanLi.add(jPasswordFieldCr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 130, -1));

        jLabel4.setText("Họ và tên:");
        cardQuanLi.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        jTextFieldQLName.setText("Họ Và Tên");
        cardQuanLi.add(jTextFieldQLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 130, -1));
        cardQuanLi.add(jPasswordFieldCr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 130, -1));

        showPassword.setText("Ẩn/Hiện Mật Khẩu");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });
        cardQuanLi.add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, -1, -1));

        jLabel1.setText("Phân Quyền");
        cardQuanLi.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 80, -1));

        jComboBoxQLRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đảng Viên", "Tổ Chức" }));
        jComboBoxQLRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxQLRoleActionPerformed(evt);
            }
        });
        cardQuanLi.add(jComboBoxQLRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 130, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardQuanLi.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardQuanLi, "card2");

        cardCreateOrg.setBackground(new java.awt.Color(255, 255, 255));
        cardCreateOrg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Tạo Tài Khoản");
        cardCreateOrg.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 120, 42));

        TextFieldQLID1.setText("ID");
        TextFieldQLID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldQLID1ActionPerformed(evt);
            }
        });
        cardCreateOrg.add(TextFieldQLID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, -1));

        jLabel20.setText("ID:");
        cardCreateOrg.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 90, -1));

        jLabel33.setText("Mật Khẩu:");
        cardCreateOrg.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 70, 20));

        jLabel35.setText("ID Tổ Chức");
        cardCreateOrg.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 80, -1));

        jTableQL1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableQL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableQL1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableQL1);

        cardCreateOrg.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 324, 940, 250));

        jButton8.setBackground(new java.awt.Color(0, 204, 51));
        jButton8.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Lưu");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        cardCreateOrg.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 30));

        jButton9.setBackground(new java.awt.Color(255, 0, 0));
        jButton9.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Huỷ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        cardCreateOrg.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 100, 30));

        jTextFieldQLorgID1.setText("ID Tổ Chức");
        jTextFieldQLorgID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQLorgID1ActionPerformed(evt);
            }
        });
        cardCreateOrg.add(jTextFieldQLorgID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, -1));

        jLabel5.setText("Xác nhận mật khẩu:");
        cardCreateOrg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 110, -1));

        jPasswordFieldCr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldCr3ActionPerformed(evt);
            }
        });
        cardCreateOrg.add(jPasswordFieldCr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 130, -1));

        jLabel6.setText("Họ và tên:");
        cardCreateOrg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        jTextFieldQLName1.setText("Họ Và Tên");
        cardCreateOrg.add(jTextFieldQLName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 130, -1));
        cardCreateOrg.add(jPasswordFieldCr4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 130, -1));

        showPassword1.setText("Ẩn/Hiện Mật Khẩu");
        showPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword1ActionPerformed(evt);
            }
        });
        cardCreateOrg.add(showPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, -1, -1));

        jLabel7.setText("Phân Quyền");
        cardCreateOrg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 80, -1));

        jComboBoxQLRole1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đảng Viên", "Tổ Chức" }));
        jComboBoxQLRole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxQLRole1ActionPerformed(evt);
            }
        });
        cardCreateOrg.add(jComboBoxQLRole1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 130, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardCreateOrg.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardCreateOrg, "card2");

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
        } 

        // Nếu không có kết quả, trả về false
    }
    private void updateUserToTable(User userLatest){
        
        
        java.sql.Connection connection = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "UPDATE User SET partOrgId = ? , password = ? , role = ? WHERE partyMemberId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1, userLatest.getPartOrgId());
            pstmt.setString(2, userLatest.getPassword());
            pstmt.setBoolean(3, userLatest.getRole());
            pstmt.setString(4, userLatest.getPartyMemberId());
            pstmt.executeUpdate();
            // Nếu có kết quả trả về, tức là người dùng hợp l

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    private void insertUser(User userLatest){
       
        
        java.sql.Connection connection = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "INSERT INTO User (partyMemberId, partOrgId, password, role) VALUE (?, ?, ?, ? )";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userLatest.getPartyMemberId());
            pstmt.setString(2, userLatest.getPartOrgId());
            pstmt.setString(3, userLatest.getPassword());
            pstmt.setBoolean(4, userLatest.getRole());
            
            pstmt.executeUpdate();
            // Nếu có kết quả trả về, tức là người dùng hợp l

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    private void searchUser(String ID){
        
        
        java.sql.Connection connection = null;
        ResultSet result = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT *from User WHERE partyMemberId = ? ";
            PreparedStatement pstmt = connection.prepareStatement(sql);
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
            JOptionPane.showMessageDialog(rootPane, "Không Tìm Thấy");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        jplSlideMenu.setSize(0, y);
//        x = 0;
    }//GEN-LAST:event_formWindowOpened

    private void lblPhanQuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhanQuyenMouseClicked
        cardQuanLi.setVisible(false);
        cardPhanQuyen.setVisible(true);
        cardCreateOrg.setVisible(false);
        loadUserToTablePQ();
        
    }//GEN-LAST:event_lblPhanQuyenMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        User insertUser = new User();
        insertUser.setPartyMemberId(TextFieldQLID.getText());
        insertUser.setPartOrgId(jTextFieldQLorgID.getText());
        if(jComboBoxQLRole.getSelectedItem().equals("Đảng Viên"))
            insertUser.setRole(false);
        else insertUser.setRole(false);
        if(Arrays.equals(jPasswordFieldCr1.getPassword(), jPasswordFieldCr2.getPassword())){
            char[] password = jPasswordFieldCr2.getPassword();
            String passwordStr = new String(password);
            insertUser.setPassword(passwordStr);
            insertUser(insertUser);
            
            loadMemberNoUserToTable();
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Xác nhận lại mật khẩu");
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextFieldQLorgIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQLorgIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQLorgIDActionPerformed

    private void lblQuanLiTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLiTKMouseClicked
        // TODO add your handling code here:
        cardQuanLi.setVisible(true);
        cardPhanQuyen.setVisible(false);
        cardCreateOrg.setVisible(false);
        loadMemberNoUserToTable();
    }//GEN-LAST:event_lblQuanLiTKMouseClicked

    private void lblPhanQuyenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhanQuyenMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPhanQuyenMouseEntered

    private void lblQuanLiTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLiTKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuanLiTKMouseEntered

    private void TextFieldQLIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldQLIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldQLIDActionPerformed

    private void jTextFieldPQIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPQIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPQIDActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
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
            JOptionPane.showMessageDialog(rootPane, "Nhap ID can tim");
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

    private void TextFieldQLID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldQLID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldQLID1ActionPerformed

    private void jTableQL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableQL1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableQL1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextFieldQLorgID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQLorgID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQLorgID1ActionPerformed

    private void jPasswordFieldCr3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldCr3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldCr3ActionPerformed

    private void showPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showPassword1ActionPerformed

    private void jComboBoxQLRole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxQLRole1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxQLRole1ActionPerformed

    private void lblQuanLiTCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLiTCMouseClicked
        // TODO add your handling code here:
        cardQuanLi.setVisible(false);
        cardPhanQuyen.setVisible(false);
        cardCreateOrg.setVisible(true);
    }//GEN-LAST:event_lblQuanLiTCMouseClicked

    private void lblQuanLiTCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLiTCMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuanLiTCMouseEntered

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
    private javax.swing.JTextField TextFieldQLID1;
    private javax.swing.JPanel cardCreateOrg;
    private javax.swing.JPanel cardPhanQuyen;
    private javax.swing.JPanel cardQuanLi;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBoxPQ;
    private javax.swing.JComboBox<String> jComboBoxQLRole;
    private javax.swing.JComboBox<String> jComboBoxQLRole1;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldCr1;
    private javax.swing.JPasswordField jPasswordFieldCr2;
    private javax.swing.JPasswordField jPasswordFieldCr3;
    private javax.swing.JPasswordField jPasswordFieldCr4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableQL;
    private javax.swing.JTable jTableQL1;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField jTextFieldPQID;
    private javax.swing.JTextField jTextFieldPQMK;
    private javax.swing.JTextField jTextFieldPQSearchID;
    private javax.swing.JTextField jTextFieldPQorgID;
    private javax.swing.JTextField jTextFieldQLName;
    private javax.swing.JTextField jTextFieldQLName1;
    private javax.swing.JTextField jTextFieldQLorgID;
    private javax.swing.JTextField jTextFieldQLorgID1;
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplSlideMenu;
    private javax.swing.JPanel jplTitle;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblPhanQuyen;
    private javax.swing.JLabel lblQuanLiTC;
    private javax.swing.JLabel lblQuanLiTK;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JCheckBox showPassword1;
    // End of variables declaration//GEN-END:variables
}
