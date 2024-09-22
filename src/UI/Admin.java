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
public class Admin extends javax.swing.JFrame {
    public Admin() {
        initComponents();
        cardAdmin.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jplSlideMenu = new javax.swing.JPanel();
        lblThem = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDangXuat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BackgroundMenu = new javax.swing.JLabel();
        jplTitle = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jplMain = new javax.swing.JPanel();
        cardAdmin = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        TextFieldHoTen = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        TextFieldTênTổChức = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();

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

        lblThem.setBackground(new java.awt.Color(255, 255, 255));
        lblThem.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblThem.setForeground(new java.awt.Color(255, 255, 255));
        lblThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem.setText("Quản Lí Tài Khoản");
        lblThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemMouseClicked(evt);
            }
        });
        jplSlideMenu.add(lblThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));
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
        jLabel21.setText("Bui Ngoc Duc");
        jplSlideMenu.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N
        jplSlideMenu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));
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

        cardAdmin.setBackground(new java.awt.Color(255, 255, 255));
        cardAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Quản Lí Tài Khoản");
        cardAdmin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 42));

        TextFieldHoTen.setText("bui ngoc duc");
        cardAdmin.add(TextFieldHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 130, -1));

        jLabel17.setText("ID:");
        cardAdmin.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 90, -1));

        jLabel29.setText("Mật Khẩu:");
        cardAdmin.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 70, -1));

        jTextField3.setText("22010065");
        cardAdmin.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 130, -1));

        jLabel30.setText("Tên Tổ Chức:");
        cardAdmin.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 80, -1));

        TextFieldTênTổChức.setText("DƯƠNGDZ");
        cardAdmin.add(TextFieldTênTổChức, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 137, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mật Khẩu", "Tên Tổ Chức", "Ngày Thành Lập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable5);

        cardAdmin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 324, 940, 250));

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        cardAdmin.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sửa");
        cardAdmin.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 60, -1));

        jButton4.setBackground(new java.awt.Color(255, 51, 0));
        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Xoá");
        cardAdmin.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 60, -1));

        jButton5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton5.setText("Chỉnh sửa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        cardAdmin.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 30));

        jButton6.setBackground(new java.awt.Color(0, 204, 51));
        jButton6.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Lưu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        cardAdmin.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 100, -1));

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Huỷ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        cardAdmin.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 100, -1));

        jLabel18.setText("Ngày Thành Lập:");
        cardAdmin.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 90, 20));

        jTextField2.setText("20/01/2004");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        cardAdmin.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 130, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardAdmin.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 580));

        jplMain.add(cardAdmin, "card2");

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

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked

        cardAdmin.setVisible(false);
    }//GEN-LAST:event_lblThemMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
    private javax.swing.JTextField TextFieldHoTen;
    private javax.swing.JTextField TextFieldTênTổChức;
    private javax.swing.JPanel cardAdmin;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplSlideMenu;
    private javax.swing.JPanel jplTitle;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblThem;
    // End of variables declaration//GEN-END:variables
}
