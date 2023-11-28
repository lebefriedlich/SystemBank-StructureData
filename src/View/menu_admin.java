package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import Util.StructureData;
import controller.AdminController;
import controller.TransactionController;
import model.AdminModel;
import service.AdminService;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TransactionModel;

/**
 *
 * @author HP
 */
public class menu_admin extends javax.swing.JFrame {

    TransactionModel TM = new TransactionModel();
    TransactionController TC = new TransactionController();
    AdminModel AM = new AdminModel();
    AdminService AS = new AdminService();
    AdminController AC = new AdminController(AS);
    StructureData SD = new StructureData();

    private DefaultTableModel tabMode;
    private String notif, notif1;
    NumberFormat formatRp = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
    ArrayList<String[]> dataNasabah;

    /**
     * Creates new form menu_admin
     */
    public menu_admin() {
        if ("Active".equals(TM.getStatusLogin())) {
            initComponents();
            tampil_datauser();
            tf_noRek.setEditable(false);
            tf_status.setEditable(false);
            tab_data.setEnabled(false);
            tab_aktifitas.setEnabled(false);
            tab_data.setAutoResizeMode(tab_data.AUTO_RESIZE_OFF);
            tab_data.getColumnModel().getColumn(0).setPreferredWidth(100);
            tab_data.getColumnModel().getColumn(1).setPreferredWidth(273);
            tab_data.getColumnModel().getColumn(2).setPreferredWidth(75);
            tab_data.getColumnModel().getColumn(3).setPreferredWidth(95);
            tab_data.getColumnModel().getColumn(4).setPreferredWidth(95);
            tab_data.getColumnModel().getColumn(5).setPreferredWidth(220);
            tab_data.getColumnModel().getColumn(6).setPreferredWidth(135);
            tab_data.getColumnModel().getColumn(7).setPreferredWidth(70);
        } else {
            dispose();
            welcomeScreen ss = new welcomeScreen();
            ss.setVisible(true);
        }
    }

    public void tampil_datauser() {
        tabMode = (DefaultTableModel) tab_data.getModel();
        tab_data.setModel(tabMode);
        tab_data.setRowHeight(35);
        tabMode.setRowCount(0);
        AC.viewAllNasabah();
        dataNasabah = AM.getDataNasabah();
        try {
            for (String[] rowData : dataNasabah) {
                rowData[6] = formatRp.format(Double.parseDouble(rowData[6]));
                tabMode.addRow(rowData);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset() {
        tf_noRek.setText("");
        tf_namaLengkap.setText("");
        tf_username.setText("");
        tf_password.setText("");
        tf_noTelp.setText("");
        tf_email.setText("");
        tf_saldo.setText("");
        tf_nominal.setText("");
        tf_status.setText("");
        tf_rek1.setText("");
        tf_rekTuj.setText("");
        tf_nom.setText("");
        lab_aktifitas.setText("");
        tabMode = new DefaultTableModel();
        tab_aktifitas.setModel(tabMode);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_aktifitas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_pencarian = new javax.swing.JTextField();
        tf_namaLengkap = new javax.swing.JTextField();
        tf_nominal = new javax.swing.JTextField();
        tf_username = new javax.swing.JTextField();
        tf_password = new javax.swing.JTextField();
        tf_noTelp = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        bt_activeOrNon = new javax.swing.JButton();
        bt_tampilAktifitas = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_setTun = new javax.swing.JButton();
        bt_reset = new javax.swing.JButton();
        lab_aktifitas = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_saldo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_data = new javax.swing.JTable();
        bt_register = new javax.swing.JButton();
        bt_tarTun = new javax.swing.JButton();
        tf_noRek = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_nom = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tf_rek1 = new javax.swing.JTextField();
        bt_transfer = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        tf_rekTuj = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cb_sorting = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_status = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel2.setText("Tunai");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 90, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Rekening Tujuan");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        tab_aktifitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tab_aktifitas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 1090, 260));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Status");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nama Lengkap");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("No.Telepon");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        tf_pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_pencarianKeyPressed(evt);
            }
        });
        getContentPane().add(tf_pencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 50, 180, -1));
        getContentPane().add(tf_namaLengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 180, -1));
        getContentPane().add(tf_nominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 180, -1));
        getContentPane().add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 180, -1));
        getContentPane().add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 180, -1));
        getContentPane().add(tf_noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 180, -1));
        getContentPane().add(tf_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 180, -1));

        bt_activeOrNon.setText("Active / Non Active");
        bt_activeOrNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_activeOrNonActionPerformed(evt);
            }
        });
        getContentPane().add(bt_activeOrNon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        bt_tampilAktifitas.setText("Tampil Aktifitas");
        bt_tampilAktifitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tampilAktifitasActionPerformed(evt);
            }
        });
        getContentPane().add(bt_tampilAktifitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 120, -1));

        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        getContentPane().add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        bt_setTun.setText("Setor Tunai");
        bt_setTun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_setTunActionPerformed(evt);
            }
        });
        getContentPane().add(bt_setTun, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 90, -1));

        bt_reset.setText("Reset");
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });
        getContentPane().add(bt_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 80, -1));

        lab_aktifitas.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        getContentPane().add(lab_aktifitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 680, 40));

        jLabel11.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel11.setText("Transfer");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 130, 40));

        jLabel12.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel12.setText("Data Nasabah");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Urutkan Sesuai");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, -1, -1));
        getContentPane().add(tf_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 180, -1));

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tab_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Rekening", "Nama Lengkap", "Username", "Password", "No. Telepon", "Email", "Saldo", "Status"
            }
        ));
        tab_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_data);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 1090, 300));

        bt_register.setText("Daftar");
        bt_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_registerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, -1));

        bt_tarTun.setText("Tarik Tunai");
        bt_tarTun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tarTunActionPerformed(evt);
            }
        });
        getContentPane().add(bt_tarTun, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 90, -1));
        getContentPane().add(tf_noRek, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 180, -1));

        jLabel16.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel16.setText("Tarik dan Setor ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 220, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Nominal");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));
        getContentPane().add(tf_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 160, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Dari Rekening");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));
        getContentPane().add(tf_rek1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, 160, -1));

        bt_transfer.setText("Transfer");
        bt_transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_transferActionPerformed(evt);
            }
        });
        getContentPane().add(bt_transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 90, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Nominal");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, -1));

        tf_rekTuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rekTujActionPerformed(evt);
            }
        });
        getContentPane().add(tf_rekTuj, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 160, -1));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 50, 50));

        jLabel13.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel13.setText("Aktifitas Nasabah ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("No. Rekening");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        cb_sorting.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Nomor Rekening", "Nama" }));
        cb_sorting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sortingActionPerformed(evt);
            }
        });
        getContentPane().add(cb_sorting, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Pencarian");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Saldo");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        getContentPane().add(tf_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 180, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\SystemBank-StructureData\\images\\background\\menuAdmin.png")); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_registerActionPerformed
        notif = TC.register(tf_namaLengkap.getText(), tf_username.getText(), tf_password.getText(), tf_noTelp.getText(), tf_email.getText(), tf_saldo.getText(), "2");
        JOptionPane.showMessageDialog(null, notif, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        tampil_datauser();
        if ("Daftar Berhasil".equals(notif)) {
            reset();
        }
    }//GEN-LAST:event_bt_registerActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        notif = AC.editData(tf_username.getText(), tf_password.getText(), tf_noTelp.getText(), tf_email.getText(), tf_namaLengkap.getText());
        JOptionPane.showMessageDialog(null, notif, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        tampil_datauser();
        if ("Data Berhasil Dirubah".equals(notif)) {
            reset();
        }
    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_activeOrNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_activeOrNonActionPerformed
        int pilihan;
        if (tf_status.getText().equals("Active")) {
            pilihan = JOptionPane.showConfirmDialog(null, "Apakah Data Nasabah Dinon-aktifkan?", "Informasi", JOptionPane.YES_NO_OPTION);
        } else {
            pilihan = JOptionPane.showConfirmDialog(null, "Apakah Data Nasabah Diaktifkan?", "Informasi", JOptionPane.YES_NO_OPTION);
        }
        if (pilihan == JOptionPane.YES_OPTION) {
            if (tf_status.getText().equals("Active")) {
                notif = AC.activeOrNon(tf_username.getText(), "Non Active");
            } else {
                notif = AC.activeOrNon(tf_username.getText(), "Active");
            }
            JOptionPane.showMessageDialog(null, notif, "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampil_datauser();
            reset();
        }
    }//GEN-LAST:event_bt_activeOrNonActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
        reset();
    }//GEN-LAST:event_bt_resetActionPerformed

    private void bt_tampilAktifitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tampilAktifitasActionPerformed
        Object[] baris = {"Waktu", "Jenis Transaksi", "Jumlah Transaksi", "Keterangan"};
        tabMode = new DefaultTableModel(null, baris);
        TC.viewTransactionNasabah(tf_noRek.getText());
        try {
            tabMode.setRowCount(0);
            ArrayList<String[]> dataTransaction = TM.getDataTransaction();
            for (String[] rowData : dataTransaction) {
                rowData[2] = formatRp.format(Double.parseDouble(rowData[2]));
                tabMode.addRow(rowData);
            }
            tab_aktifitas.setModel(tabMode);
            tab_aktifitas.setRowHeight(25);
            lab_aktifitas.setText(tf_namaLengkap.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_bt_tampilAktifitasActionPerformed

    private void tab_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_dataMouseClicked
        try {
            int row = tab_data.rowAtPoint(evt.getPoint());
            String noRek = tab_data.getValueAt(row, 0).toString();
            String namaLengkap = tab_data.getValueAt(row, 1).toString();
            String username = tab_data.getValueAt(row, 2).toString();
            String pass = tab_data.getValueAt(row, 3).toString();
            String noTelp = tab_data.getValueAt(row, 4).toString();
            String email = tab_data.getValueAt(row, 5).toString();
            String saldo = tab_data.getValueAt(row, 6).toString();
            String status = tab_data.getValueAt(row, 7).toString();
            tf_noRek.setText(noRek);
            tf_namaLengkap.setText(namaLengkap);
            tf_username.setText(username);
            tf_password.setText(pass);
            tf_noTelp.setText(noTelp);
            tf_email.setText(email);
            tf_saldo.setText(saldo);
            tf_status.setText(status);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tab_dataMouseClicked

    private void bt_tarTunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tarTunActionPerformed
        String saldo = tf_saldo.getText().replace("Rp", "").replace(".", "").replace(",00", "");
        String nom = tf_nominal.getText().replace("Rp", "").replace(".", "").replace(",00", "");
        if (Integer.parseInt(saldo) > Integer.parseInt(nom)) {
            notif = TC.minusSaldo(tf_noRek.getText(), nom, "Tarik Tunai", "Berhasil");
            JOptionPane.showMessageDialog(null, notif, "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampil_datauser();
            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Saldo Anda Tidak Mencukupi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_tarTunActionPerformed

    private void bt_setTunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_setTunActionPerformed
        String nom = tf_nominal.getText().replace("Rp", "").replace(".", "").replace(",00", "");
        notif = TC.plusSaldo(tf_noRek.getText(), nom, "Setor Tunai", "Berhasil");
        JOptionPane.showMessageDialog(null, notif, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        tampil_datauser();
        reset();
    }//GEN-LAST:event_bt_setTunActionPerformed

    private void bt_transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_transferActionPerformed
        String nom = tf_nom.getText().replace(".", "").replace(",00", "");
        String saldo = null;
        for (String[] rowData : dataNasabah) {
            if (rowData[0].equals(tf_rek1.getText())) {
                saldo = rowData[rowData.length - 2].replace("Rp", "").replace(".", "").replace(",00", "");
                break;
            }
        }
        if (Integer.parseInt(saldo) > Integer.parseInt(nom)) {
            notif = TC.minusSaldo(tf_rek1.getText(), nom, "Transfer Keluar", ("ke " + tf_rekTuj.getText())).replace("Keluar", "");
            notif1 = TC.plusSaldo(tf_rekTuj.getText(), nom, "Transfer Masuk", "dari " + tf_rek1.getText());
            JOptionPane.showMessageDialog(null, notif, "Informasi", JOptionPane.INFORMATION_MESSAGE);
            reset();
            tampil_datauser();
        } else {
            JOptionPane.showMessageDialog(null, "Saldo Nasabah Tidak Mencukupi", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_transferActionPerformed

    private void tf_pencarianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pencarianKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tf_pencarian.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Data pencarian belum diisi !");
                tf_pencarian.requestFocus();
            } else {
                try {
                    String[] data = new String[8];
                    if (isNumeric(tf_pencarian.getText())) {
                        if (Long.parseLong(tf_pencarian.getText()) > 19210204000000L) {
                            data = SD.binarySearchByAccountNumber(dataNasabah, tf_pencarian.getText());
                        } else {
                            JOptionPane.showMessageDialog(null, "Masukkan Nomor Rekening atau Nama", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        data = SD.binarySearchByName(dataNasabah, tf_pencarian.getText());
                    }
                    tabMode = (DefaultTableModel) tab_data.getModel();
                    tab_data.setModel(tabMode);
                    tabMode.setRowCount(0);
                    if (data == null) {
                        JOptionPane.showMessageDialog(null, "Data Nasabah Tidak Ditemukan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        tabMode.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL) {
            tampil_datauser();
        }
    }//GEN-LAST:event_tf_pencarianKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Keluar", JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION) {
            dispose();
            masuk li = new masuk();
            li.setVisible(true);
        }
        TM.setStatusLogin(null);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tf_rekTujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rekTujActionPerformed
        if (tf_rekTuj.getText().trim().equals(tf_rek1.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf Tidak Bisa Transfer ke Rekening Sendiri");
            tf_nom.setEditable(false);
        } else {
            String namaLengkap = null;
            for (String[] rowData : dataNasabah) {
                if (rowData[0].equals(tf_rekTuj.getText())) {
                    namaLengkap = rowData[1];
                    break;
                }
            }
            if (namaLengkap == null) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                tf_nom.setEditable(false);
                tf_rekTuj.requestFocus();
            } else {
                tf_nom.setEditable(true);
                int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda transfer ke atas nama\n" + namaLengkap, "Transfer", JOptionPane.YES_NO_OPTION);
                if (pilihan == JOptionPane.YES_OPTION) {
                    tf_nom.requestFocus();
                } else {
                    tf_rekTuj.setText("");
                }
            }
        }
    }//GEN-LAST:event_tf_rekTujActionPerformed

    private void cb_sortingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sortingActionPerformed
        String selectedOption = (String) cb_sorting.getSelectedItem();
        if ("Default".equals(selectedOption)) {
            tampil_datauser();
        } else if ("Nomor Rekening".equals(selectedOption)) {
            SD.bubbleSortByAccountNumber(dataNasabah);
            tabMode = (DefaultTableModel) tab_data.getModel();
            tab_data.setModel(tabMode);
            tab_data.setRowHeight(35);
            tabMode.setRowCount(0);
            dataNasabah = AM.getDataNasabah();
            for (String[] rowData : dataNasabah) {
                tabMode.addRow(rowData);
            }
        } else if ("Nama".equals(selectedOption)) {
            SD.bubbleSortByName(dataNasabah);
            tabMode = (DefaultTableModel) tab_data.getModel();
            tab_data.setModel(tabMode);
            tab_data.setRowHeight(35);
            tabMode.setRowCount(0);
            dataNasabah = AM.getDataNasabah();
            for (String[] rowData : dataNasabah) {
                tabMode.addRow(rowData);
            }
        }
    }//GEN-LAST:event_cb_sortingActionPerformed

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
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_activeOrNon;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_register;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_setTun;
    private javax.swing.JButton bt_tampilAktifitas;
    private javax.swing.JButton bt_tarTun;
    private javax.swing.JButton bt_transfer;
    private javax.swing.JComboBox<String> cb_sorting;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab_aktifitas;
    private javax.swing.JTable tab_aktifitas;
    private javax.swing.JTable tab_data;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_namaLengkap;
    private javax.swing.JTextField tf_noRek;
    private javax.swing.JTextField tf_noTelp;
    private javax.swing.JTextField tf_nom;
    private javax.swing.JTextField tf_nominal;
    private javax.swing.JTextField tf_password;
    private javax.swing.JTextField tf_pencarian;
    private javax.swing.JTextField tf_rek1;
    private javax.swing.JTextField tf_rekTuj;
    private javax.swing.JTextField tf_saldo;
    private javax.swing.JTextField tf_status;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables

    private boolean isNumeric(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
