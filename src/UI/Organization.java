/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Class.Discipline;
import Class.User;

import Class.PartyMember;
import Class.User;
import Database.DisciplineList;
import Database.ListDisciplinePartyMember;
import Database.AddDiscipline;
import Database.ListPartyMember;
import Database.PartyMemberAdd;
import Database.PartyMemberDelete;
import Database.PartyMemberEdit;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Database.SearchPM;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author buingocduc
 */
public class Organization extends javax.swing.JFrame {
    //list DangVien
    List<PartyMember> listDV = ListPartyMember.getAllPartyMembers();
    List<Discipline> listKL = DisciplineList.getAllDisciplines();
    private static int pos = 0;
    private static int posKL = 0;
    private static int stt = 0;
    private static int checkSaveDV = 0;
    private static String name;
    /* set onoff cho card DangVien */
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
    
    /*set onoff ky luat*/
    
    public void OnOffKyLuat(boolean a, boolean b)
    {
        this.ButtonKyLuat.show(a);
        
        this.ButtonBHKL.show(b);
        this.ButtonCancelKL.show(b);
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
        this.EditorPaneQTCT.setText(pm.getDetail());
        OnOffDangVien(true, false, false);
    }
    
    //set view card Ky Luat
    
    public void viewKL()
    {
        Discipline dp = listKL.get(posKL);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(dp.getDisciplineDate());
        
        this.TextFieldIDQD.setText(dp.getId());
        this.TextFieldIDdvKL.setText(dp.getPartyMemberId());
        this.TextFieldNQDKL.setText(dp.getDecisionMaker());
        this.EditorPaneNDKL.setText(dp.getDescription());
        this.TextFieldngayQDKL.setText(date);
        this.TextFieldorgIdKL.setText(dp.getOrgId());
        
        OnOffKyLuat(true, false);
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
            tableDV.addRow(new Object[]{stt, DV.getId(), DV.getOrgId(),DV.getFullName(), DV.getPosition(), DV.getJoinDate()});
        }
    }
    
    //set viewTable cho card ky luat
    public void viewTableKL()
    {
        DefaultTableModel tableKL = (DefaultTableModel) this.TableKL.getModel();
        tableKL.setNumRows(0);
        for(Discipline DP : listKL)
        {
            
            for(PartyMember pm: listDV)
            {
                if(DP.getPartyMemberId().equals(pm.getId()))
                {
                    name = pm.getFullName();
                    break;
                }
            }
            tableKL.addRow(new Object[]{DP.getId(), DP.getPartyMemberId(), name, DP.getDisciplineDate(), DP.getDecisionMaker(), DP.getDescription()});
        }
    }
    
    /**
     * Creates new form Organization
     */
    public Organization() {
        initComponents();
        cardViewDetail.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(true);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(false);
        cardDangVien.setVisible(false);
        ViewDangVien();
        viewTableDv();
        
        viewKL();
        viewTableKL();
    }
    public Organization(User user) {
        initComponents();
        
        cardViewDetail.setVisible(false);
        cardSinhHoat.setVisible(false);
        cardYeuCau.setVisible(false);
        cardDangBo.setVisible(true);
        cardThanhTich.setVisible(false);
        cardKyLuat.setVisible(false);
        cardDangVien.setVisible(false);
        
        ViewDangVien();
        viewTableDv();
        
        viewKL();
        viewTableKL();
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
        jTextField32 = new javax.swing.JTextField();
        jButton32 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTable16 = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable17 = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
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
        EditorPaneQTCT = new javax.swing.JEditorPane();
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
        TableKL = new javax.swing.JTable();
        TextFieldSearchKL = new javax.swing.JTextField();
        ButtonSearchKL = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextFieldIDQD = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TextFieldIDdvKL = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TextFieldorgIdKL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TextFieldngayQDKL = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        EditorPaneNDKL = new javax.swing.JEditorPane();
        jLabel13 = new javax.swing.JLabel();
        ButtonKyLuat = new javax.swing.JButton();
        ButtonCancelKL = new javax.swing.JButton();
        ButtonBHKL = new javax.swing.JButton();
        TextFieldNQDKL = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cardSinhHoat = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField16 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jEditorPane5 = new javax.swing.JEditorPane();
        jTextField21 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        cardViewDetail = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField22 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        TextFieldHoTen1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
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
        jPanel5.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 353, 161, -1));

        jLabel47.setText("Mã Đảng viên:");
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 388, 88, -1));
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

        jTextField32.setText("Tìm kiếm ");
        jTextField32.setPreferredSize(new java.awt.Dimension(72, 30));
        cardDangBo.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 40, 140, -1));

        jButton32.setBackground(new java.awt.Color(0, 204, 255));
        jButton32.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Tìm");
        jButton32.setBorder(null);
        jButton32.setPreferredSize(new java.awt.Dimension(22, 30));
        cardDangBo.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 61, -1));

        jTable16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Tổ Chức", "Tên Tổ Chức", "Ngày Quyết Định", "Người Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane18.setViewportView(jTable16);

        cardDangBo.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 886, 140));

        jLabel75.setText("Tên Đơn Vị:");
        cardDangBo.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        jTextField33.setText("Đảng bộ xã Nhân quyền");
        cardDangBo.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 170, -1));

        jLabel76.setText("Mã Tổ Chức:");
        cardDangBo.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jTextField34.setText("TC001");
        cardDangBo.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 170, -1));

        jLabel77.setText("Ngày Thành Lập:");
        cardDangBo.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jTextField35.setText("21/09/2024");
        cardDangBo.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 170, -1));

        jLabel78.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel78.setText("Những thành tích của tổ chức:");
        cardDangBo.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 31));

        jTable17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Quyết Định", "Mã Tổ Chức", "Tên Tổ Chức", "Ngày Quyết Định", "Người Quyết Định", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane19.setViewportView(jTable17);

        cardDangBo.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 886, 140));

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardDangBo.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

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

        jScrollPane6.setViewportView(EditorPaneQTCT);

        cardDangVien.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 480, 160));

        TableDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Đảng viên", "Mã tổ chức", "Họ Tên", "Chức vụ", "Ngày vào Đảng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        TableKL.setModel(new javax.swing.table.DefaultTableModel(
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
        TableKL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableKLMouseClicked(evt);
            }
        });
        TableKL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableKLKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableKLKeyReleased(evt);
            }
        });
        jScrollPane15.setViewportView(TableKL);

        jPanel4.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 115, 886, 168));

        TextFieldSearchKL.setPreferredSize(new java.awt.Dimension(67, 30));
        jPanel4.add(TextFieldSearchKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 37, 128, -1));

        ButtonSearchKL.setBackground(new java.awt.Color(0, 204, 255));
        ButtonSearchKL.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ButtonSearchKL.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSearchKL.setText("Tìm");
        ButtonSearchKL.setBorder(null);
        ButtonSearchKL.setPreferredSize(new java.awt.Dimension(22, 30));
        ButtonSearchKL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchKLActionPerformed(evt);
            }
        });
        jPanel4.add(ButtonSearchKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 37, 61, -1));

        jLabel57.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel57.setText("Kỷ Luật Đảng Viên Đã Vi Phạm:");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 295, -1, 31));

        jLabel9.setText("Mã quyết định:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 332, -1, -1));
        jPanel4.add(TextFieldIDQD, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 355, 160, -1));

        jLabel12.setText("Mã Đảng viên:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 88, -1));

        TextFieldIDdvKL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldIDdvKLActionPerformed(evt);
            }
        });
        jPanel4.add(TextFieldIDdvKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 160, -1));

        jLabel6.setText("Mã tổ chức:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 332, 70, -1));

        TextFieldorgIdKL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldorgIdKLActionPerformed(evt);
            }
        });
        jPanel4.add(TextFieldorgIdKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 355, 160, -1));

        jLabel7.setText("Ngày quyết định:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 100, -1));

        TextFieldngayQDKL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldngayQDKLActionPerformed(evt);
            }
        });
        jPanel4.add(TextFieldngayQDKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 160, -1));
        TextFieldngayQDKL.getAccessibleContext().setAccessibleDescription("");

        jScrollPane3.setViewportView(EditorPaneNDKL);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 355, 370, 180));

        jLabel13.setText("Nội Dung:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        ButtonKyLuat.setBackground(new java.awt.Color(0, 153, 0));
        ButtonKyLuat.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        ButtonKyLuat.setForeground(new java.awt.Color(255, 255, 255));
        ButtonKyLuat.setText("Kỷ Luật");
        ButtonKyLuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonKyLuatActionPerformed(evt);
            }
        });
        jPanel4.add(ButtonKyLuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 368, 124, -1));

        ButtonCancelKL.setBackground(new java.awt.Color(204, 0, 0));
        ButtonCancelKL.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        ButtonCancelKL.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCancelKL.setText("Huỷ");
        ButtonCancelKL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelKLActionPerformed(evt);
            }
        });
        jPanel4.add(ButtonCancelKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 430, 124, -1));

        ButtonBHKL.setBackground(new java.awt.Color(0, 153, 0));
        ButtonBHKL.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        ButtonBHKL.setForeground(new java.awt.Color(255, 255, 255));
        ButtonBHKL.setText("Ban Hành");
        ButtonBHKL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBHKLActionPerformed(evt);
            }
        });
        jPanel4.add(ButtonBHKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 400, 124, -1));
        jPanel4.add(TextFieldNQDKL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 161, -1));

        jLabel14.setText("Người quyết định:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));

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
        cardSinhHoat.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Số Lượng", "Mã Buổi Sinh Hoạt", "Tên Buổi Sinh Hoạt", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        cardSinhHoat.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 365, 920, 200));

        jTextField16.setText("Tìm kiếm ");
        jTextField16.setPreferredSize(new java.awt.Dimension(67, 30));
        cardSinhHoat.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 128, -1));

        jButton18.setBackground(new java.awt.Color(0, 204, 255));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Tìm");
        jButton18.setBorder(null);
        jButton18.setPreferredSize(new java.awt.Dimension(72, 30));
        cardSinhHoat.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 61, -1));

        jLabel15.setText("Tên Buổi Sinh Hoạt:");
        cardSinhHoat.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 61, -1, -1));
        cardSinhHoat.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 84, 268, -1));

        jLabel16.setText("ID Buổi Sinh Hoạt:");
        cardSinhHoat.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 61, -1, -1));
        cardSinhHoat.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 84, 106, -1));

        jLabel18.setText("Ngày bắt đầu:");
        cardSinhHoat.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 119, 106, -1));
        cardSinhHoat.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 142, 106, -1));

        jLabel23.setText("Ngày kết thúc:");
        cardSinhHoat.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 119, 106, -1));
        cardSinhHoat.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 142, 106, -1));

        jLabel42.setText("Mô tả:");
        cardSinhHoat.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 177, -1, -1));

        jScrollPane10.setViewportView(jEditorPane5);

        cardSinhHoat.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 200, 484, 124));
        cardSinhHoat.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 142, 106, -1));

        jLabel43.setText("Trạng thái:");
        cardSinhHoat.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 119, -1, -1));

        jButton19.setBackground(new java.awt.Color(51, 204, 0));
        jButton19.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Lưu");
        cardSinhHoat.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 184, -1, -1));

        jButton20.setBackground(new java.awt.Color(255, 51, 0));
        jButton20.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Huỷ");
        cardSinhHoat.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 220, -1, -1));

        jButton21.setBackground(new java.awt.Color(255, 153, 0));
        jButton21.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Chỉnh Sửa");
        cardSinhHoat.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 110, -1));

        jButton22.setBackground(new java.awt.Color(51, 204, 0));
        jButton22.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Thêm");
        cardSinhHoat.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 110, -1));

        jButton23.setBackground(new java.awt.Color(255, 0, 51));
        jButton23.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Xoá");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        cardSinhHoat.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 110, -1));

        jButton24.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton24.setText("Xem chi tiết");
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton24MouseClicked(evt);
            }
        });
        cardSinhHoat.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgr.jpg"))); // NOI18N
        cardSinhHoat.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 950, 580));

        jplMain.add(cardSinhHoat, "card3");

        cardViewDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 51, 51));
        jLabel44.setText("Danh Sách Đảng Viên Tham Gia");
        cardViewDetail.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 290, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Buổi Sinh Hoạt", "Tên Buổi Sinh Hoạt", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable2);

        cardViewDetail.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 90, 920, 258));

        jTextField22.setText("Tìm kiếm ");
        jTextField22.setPreferredSize(new java.awt.Dimension(67, 30));
        cardViewDetail.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 49, 128, -1));

        jButton25.setBackground(new java.awt.Color(0, 204, 255));
        jButton25.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Tìm");
        jButton25.setBorder(null);
        jButton25.setPreferredSize(new java.awt.Dimension(22, 30));
        cardViewDetail.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 49, 61, -1));

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
        cardViewDetail.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        TextFieldHoTen1.setText("bui ngoc duc");
        cardViewDetail.add(TextFieldHoTen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 167, -1));

        jLabel37.setText("Mã Đảng viên:");
        cardViewDetail.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        jTextField28.setText("22010065");
        cardViewDetail.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 126, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Hoàn Thành", "Chưa Hoàn Thành", "Đã Đăng Ký" }));
        cardViewDetail.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 167, -1));

        jLabel27.setText("Trạng thái");
        cardViewDetail.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        jButton28.setBackground(new java.awt.Color(51, 204, 0));
        jButton28.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Lưu");
        cardViewDetail.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, -1, -1));

        jButton29.setBackground(new java.awt.Color(255, 51, 0));
        jButton29.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Huỷ");
        cardViewDetail.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, -1, -1));

        jButton30.setText("Đánh Giá");
        cardViewDetail.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, -1, -1));

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
        if(checkSaveDV == 1){
            String fullName = this.TextFieldHoTen.getText();
            String id = this.TextFieldID.getText();
            String birthDate = this.TextFieldNgaySinh.getText();
            String orgId = this.TextFieldOrgID.getText();
            String joinDate = this.TextFieldNgayVao.getText();
            String position = this.TextFieldPosition.getText();
            String email = this.TextFieldEmail.getText();
            String phoneNumber = this.TextFieldPhoneNumber.getText();
            String address = this.TextFieldAddress.getText();
            String detail = this.EditorPaneQTCT.getText();
            PartyMemberAdd add = new PartyMemberAdd();
            
            add.addPartyMember(null, id, fullName, birthDate, joinDate, address, email, phoneNumber, position, orgId, detail);
        
            listDV = ListPartyMember.getAllPartyMembers();
            ViewDangVien();
            viewTableDv();
        }
        else if(checkSaveDV == -1){
            String fullName = this.TextFieldHoTen.getText();
            String id = this.TextFieldID.getText();
            String birthDate = this.TextFieldNgaySinh.getText();
            String orgId = this.TextFieldOrgID.getText();
            String joinDate = this.TextFieldNgayVao.getText();
            String position = this.TextFieldPosition.getText();
            String email = this.TextFieldEmail.getText();
            String phoneNumber = this.TextFieldPhoneNumber.getText();
            String address = this.TextFieldAddress.getText();
            String detail = this.EditorPaneQTCT.getText();
            
            PartyMemberEdit update = new PartyMemberEdit();
            
            update.updatePartyMember(id, fullName, birthDate, joinDate, address, email, phoneNumber, position, orgId, detail);
            
            listDV = ListPartyMember.getAllPartyMembers();
            ViewDangVien();
            viewTableDv();
        }
        
        
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

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBackMouseClicked
        // TODO add your handling code here:
        cardSinhHoat.setVisible(true);
        cardViewDetail.setVisible(false);
    }//GEN-LAST:event_buttonBackMouseClicked

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        // TODO add your handling code here:
        cardSinhHoat.setVisible(false);
        cardViewDetail.setVisible(true);
    }//GEN-LAST:event_jButton24MouseClicked

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
        this.EditorPaneQTCT.setText("");
        checkSaveDV = 1;
        
        OnOffDangVien(false, false, true);
    }//GEN-LAST:event_btnAddDVActionPerformed

    private void btnEditDV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDV2ActionPerformed
        // TODO add your handling code here:
        checkSaveDV = -1;
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

    private void TextFieldIDdvKLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldIDdvKLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldIDdvKLActionPerformed

    private void ButtonKyLuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonKyLuatActionPerformed
        // TODO add your handling code here:
        OnOffKyLuat(false, true);
        this.TextFieldIDQD.setText("");
        this.TextFieldIDdvKL.setText("");
        this.TextFieldNQDKL.setText("");
        this.EditorPaneNDKL.setText("");
        this.TextFieldngayQDKL.setText("");
        this.TextFieldorgIdKL.setText("");
    }//GEN-LAST:event_ButtonKyLuatActionPerformed

    private void ButtonCancelKLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelKLActionPerformed
        // TODO add your handling code here:
        viewKL();
    }//GEN-LAST:event_ButtonCancelKLActionPerformed

    private void ButtonBHKLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBHKLActionPerformed
        // TODO add your handling code here:
        String idqd = this.TextFieldIDQD.getText();
        String madv = this.TextFieldIDdvKL.getText();
        String ngqd  = this.TextFieldNQDKL.getText();
        String ndkl = this.EditorPaneNDKL.getText();
        String ngayQDKL = this.TextFieldngayQDKL.getText();
        String orgIdQD = this.TextFieldorgIdKL.getText();
        
        AddDiscipline add = new AddDiscipline();
        
        add.addDiscipline(idqd, madv, orgIdQD, ngqd, ngayQDKL, ndkl);
        listKL = DisciplineList.getAllDisciplines();
        
        viewKL();
        viewTableKL();
        
    }//GEN-LAST:event_ButtonBHKLActionPerformed

    private void TextFieldorgIdKLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldorgIdKLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldorgIdKLActionPerformed

    private void TextFieldngayQDKLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldngayQDKLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldngayQDKLActionPerformed

    private void TableKLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKLKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TableKLKeyPressed

    private void TableKLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKLKeyReleased
        // TODO add your handling code here:
        posKL = this.TableKL.getSelectedRow();
        viewKL();
    }//GEN-LAST:event_TableKLKeyReleased

    private void TableKLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKLMouseClicked
        // TODO add your handling code here:
        posKL = this.TableKL.getSelectedRow();
        viewKL();
    }//GEN-LAST:event_TableKLMouseClicked

    private void ButtonSearchKLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchKLActionPerformed
        // TODO add your handling code here:
        String search = this.TextFieldSearchKL.getText();
        posKL = 0;
        int checksearch = 0;
        for(Discipline dp : listKL)
        {
            if(dp.getId().equals(search))
            {
                checksearch = 1;
                break;
            }
            posKL++;
        }
        
        if(checksearch == 1)
        {
            JOptionPane.showMessageDialog(null, "Thành công!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Không tìm thấy!");
            posKL = 0;
        }
        
        viewKL();
        
    }//GEN-LAST:event_ButtonSearchKLActionPerformed

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
    private javax.swing.JButton ButtonBHKL;
    private javax.swing.JButton ButtonCancelKL;
    private javax.swing.JButton ButtonKyLuat;
    private javax.swing.JButton ButtonSearchDV;
    private javax.swing.JButton ButtonSearchKL;
    private javax.swing.JEditorPane EditorPaneNDKL;
    private javax.swing.JEditorPane EditorPaneQTCT;
    private javax.swing.JTable TableDV;
    private javax.swing.JTable TableKL;
    private javax.swing.JTextField TextFieldAddress;
    private javax.swing.JTextField TextFieldEmail;
    private javax.swing.JTextField TextFieldHoTen;
    private javax.swing.JTextField TextFieldHoTen1;
    private javax.swing.JTextField TextFieldID;
    private javax.swing.JTextField TextFieldIDQD;
    private javax.swing.JTextField TextFieldIDdvKL;
    private javax.swing.JTextField TextFieldNQDKL;
    private javax.swing.JTextField TextFieldNgaySinh;
    private javax.swing.JTextField TextFieldNgayVao;
    private javax.swing.JTextField TextFieldOrgID;
    private javax.swing.JTextField TextFieldPhoneNumber;
    private javax.swing.JTextField TextFieldPosition;
    private javax.swing.JTextField TextFieldSearchDV;
    private javax.swing.JTextField TextFieldSearchIN;
    private javax.swing.JTextField TextFieldSearchKL;
    private javax.swing.JTextField TextFieldSearchOUT;
    private javax.swing.JTextField TextFieldngayQDKL;
    private javax.swing.JTextField TextFieldorgIdKL;
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
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JEditorPane jEditorPane4;
    private javax.swing.JEditorPane jEditorPane5;
    private javax.swing.JEditorPane jEditorPane6;
    private javax.swing.JEditorPane jEditorPane7;
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
    private javax.swing.JLabel jLabel43;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable16;
    private javax.swing.JTable jTable17;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
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
