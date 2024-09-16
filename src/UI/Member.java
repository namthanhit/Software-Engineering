/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author User
 */
public class Member extends javax.swing.JFrame {

    public Member() {
        initComponents();
        cardTrangChu.setVisible(true);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jplSlideMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblThanhTich = new javax.swing.JLabel();
        lblTrangChu = new javax.swing.JLabel();
        lblSinhHoat = new javax.swing.JLabel();
        lblYeuCau = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDangXuat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDangVien = new javax.swing.JLabel();
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
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        cardYeuCau = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jEditorPane3 = new javax.swing.JEditorPane();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jEditorPane4 = new javax.swing.JEditorPane();
        jLabel22 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        cardDangVien = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        cardThanhTich = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplSlideMenu.setBackground(new java.awt.Color(248, 248, 175));
        jplSlideMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jplSlideMenu.setPreferredSize(new java.awt.Dimension(190, 590));
        jplSlideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Bui Ngoc Duc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jplSlideMenu.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 150));

        lblThanhTich.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
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
        lblTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangChu.setText("Trang Chủ");
        lblTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrangChuMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));

        lblSinhHoat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblSinhHoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSinhHoat.setText("Sinh Hoạt");
        lblSinhHoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSinhHoatMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblSinhHoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 30));

        lblYeuCau.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
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
        jplSlideMenu.add(lblDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 200, 30));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Giới Thiệu");
        jplSlideMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 200, 30));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Trợ Giúp");
        jplSlideMenu.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 200, 30));

        lblDangVien.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblDangVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangVien.setText("Đảng Viên");
        lblDangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangVienMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblDangVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 200, 30));

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

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Sinh Hoạt Thường Kỳ"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jLabel40.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 51, 51));
        jLabel40.setText("Sinh Hoạt Chi Bộ:");

        javax.swing.GroupLayout cardSinhHoatLayout = new javax.swing.GroupLayout(cardSinhHoat);
        cardSinhHoat.setLayout(cardSinhHoatLayout);
        cardSinhHoatLayout.setHorizontalGroup(
            cardSinhHoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardSinhHoatLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(cardSinhHoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        cardSinhHoatLayout.setVerticalGroup(
            cardSinhHoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardSinhHoatLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jplMain.add(cardSinhHoat, "card3");

        cardYeuCau.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setText("Xin Thôi Công tác:");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel2.setText("Xin Chuyển Công tác:");

        jScrollPane2.setViewportView(jEditorPane2);

        jLabel6.setText("Lý Do:");

        jButton1.setBackground(new java.awt.Color(102, 204, 0));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Gửi Yêu Cầu");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel7.setText("Chuyển đơn vị công tác chính thức:");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel12.setText("Chuyển đơn vị công tác tạm thời:");

        jLabel18.setText("Mã Tổ Chức:");

        jLabel19.setText("Ngày Chuyển:");

        jScrollPane8.setViewportView(jEditorPane3);

        jLabel20.setText("Chi tiết:");

        jButton2.setBackground(new java.awt.Color(102, 204, 0));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Gửi Yêu Cầu");

        jLabel21.setText("Chi tiết:");

        jScrollPane9.setViewportView(jEditorPane4);

        jLabel22.setText("Ngày Chuyển:");

        jButton3.setBackground(new java.awt.Color(102, 204, 0));
        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Gửi Yêu Cầu");

        javax.swing.GroupLayout cardYeuCauLayout = new javax.swing.GroupLayout(cardYeuCau);
        cardYeuCau.setLayout(cardYeuCauLayout);
        cardYeuCauLayout.setHorizontalGroup(
            cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardYeuCauLayout.createSequentialGroup()
                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addGroup(cardYeuCauLayout.createSequentialGroup()
                                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(40, 40, 40)
                                .addComponent(jButton1))))
                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(cardYeuCauLayout.createSequentialGroup()
                                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane8)
                                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                                        .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21)
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(63, 63, 63)
                                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)))))
                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        cardYeuCauLayout.setVerticalGroup(
            cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardYeuCauLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardYeuCauLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(55, 55, 55)))
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardYeuCauLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cardYeuCauLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton3)))))
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardYeuCauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardYeuCauLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardYeuCauLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(56, 56, 56))))
        );

        jplMain.add(cardYeuCau, "card4");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("ảnh");

        jTextField1.setText("bui ngoc duc");

        jLabel17.setText("Họ và Tên:");

        jLabel29.setText("Mã Đảng viên:");

        jTextField2.setText("22010065");

        jLabel30.setText("Ngày Sinh:");

        jTextField3.setText("27/09/2004");

        jLabel31.setText("Ngày Vào Đảng:");

        jTextField4.setText("22/12/2022");

        jLabel32.setText("Địa chỉ:");

        jTextField5.setText("Nhân Quyền Bình Giang Hải Dương");

        jLabel33.setText("Email:");

        jTextField6.setText("22010065@gmail.com");

        jLabel34.setText("Số điện thoại:");

        jTextField7.setText("0349643475");

        jLabel35.setText("Chức Vụ:");

        jTextField8.setText("Đội trưởng");

        jLabel36.setText("Quy trình công tác:");

        jEditorPane1.setContentType("text/html"); // NOI18N
        jEditorPane1.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p style=\"margin-top: 0\">\n      10/1974 - 7/1979:<br>\n      Học viên Đại học An ninh nhân dân.<br><br>\n\n      7/1979 - 12/1988:<br>\n      Cán bộ, Cục Bảo vệ Chính trị I, Bộ Công an.<br><br>\n\n      12/1988 - 5/1990:<br>\n      Phó Trưởng phòng, Cục Bảo vệ Chính trị I, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      5/1990 - 6/1993:<br>\n      Trưởng phòng, Cục Bảo vệ Chính trị I, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      6/1993 - 5/1997:<br>\n      Phó Cục trưởng Cục Bảo vệ Chính trị I, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      5/1997 - 6/2006:<br>\n      Cục trưởng Cục Bảo vệ Chính trị III, Tổng cục An ninh, Bộ Công an.<br><br>\n\n      6/2006 - 12/2009:<br>\n      Phó Tổng cục trưởng Tổng cục An ninh, Bộ Công an.\n    </p>\n  </body>\n</html>\n\n");
        jScrollPane6.setViewportView(jEditorPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(122, 122, 122)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(257, 257, 257)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel32)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel34)
                                .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(jLabel35)
                                .addComponent(jTextField8))))
                    .addComponent(jLabel36)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 168, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

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

        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel37.setText("Khen Thưởng Đảng VIên Đã Có Thành Tích Tốt:");

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

        jLabel38.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel38.setText("Kỷ Luật Đảng VIên Đã Có Những Sai Phạm:");

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

        jLabel41.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 51, 51));
        jLabel41.setText("Khen Thưởng - Kỷ Luật:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jScrollPane7)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel41)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

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
    }//GEN-LAST:event_lblDangVienMouseClicked

    private void lblThanhTichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThanhTichMouseClicked
        // TODO add your handling code here:
        cardTrangChu.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangVien.setVisible(false);
        cardThanhTich.setVisible(true);
    }//GEN-LAST:event_lblThanhTichMouseClicked

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
    private javax.swing.JPanel cardDangVien;
    private javax.swing.JPanel cardSinhHoat;
    private javax.swing.JPanel cardThanhTich;
    private javax.swing.JPanel cardTrangChu;
    private javax.swing.JPanel cardYeuCau;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JEditorPane jEditorPane3;
    private javax.swing.JEditorPane jEditorPane4;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplSlideMenu;
    private javax.swing.JPanel jplTitle;
    private javax.swing.JLabel lblDangVien;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblSinhHoat;
    private javax.swing.JLabel lblThanhTich;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lblYeuCau;
    // End of variables declaration//GEN-END:variables
}
