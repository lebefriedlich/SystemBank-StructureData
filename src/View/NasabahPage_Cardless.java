/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TransactionController;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.TransactionModel;

/**
 *
 * @author HP
 */
public class NasabahPage_Cardless extends javax.swing.JFrame {

    TransactionModel TM = new TransactionModel();
    TransactionController TC = new TransactionController();
    private String notif;
    NumberFormat formatRp = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

    /**
     * Creates new form NasabahPage_Cardless
     */
    public NasabahPage_Cardless() {
        if ("Active".equals(TM.getStatusLogin())) {
            initComponents();
            display();
        } else {
            dispose();
            LoginPage LP = new LoginPage();
            LP.setVisible(true);
        }
    }

    public void display() {
        pan_cashWithdrawal.setVisible(false);
        pan_cashDeposit.setVisible(false);
        lab_noRek.setText(TM.getNoRek());
        lab_saldo.setText(formatRp.format(TM.getSaldo()));
        lab_noRek1.setText(TM.getNoRek());
        lab_saldo1.setText(formatRp.format(TM.getSaldo()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan_cashWithdrawal = new javax.swing.JPanel();
        lab_noRek = new javax.swing.JLabel();
        lab_saldo = new javax.swing.JLabel();
        cb_nom = new javax.swing.JComboBox<>();
        bt_cashWithdrawal = new javax.swing.JButton();
        lab_bgCashWithdrawal = new javax.swing.JLabel();
        pan_cashDeposit = new javax.swing.JPanel();
        lab_noRek1 = new javax.swing.JLabel();
        lab_saldo1 = new javax.swing.JLabel();
        cb_nom1 = new javax.swing.JComboBox<>();
        bt_cashDeposit = new javax.swing.JButton();
        lab_bgCashDeposit = new javax.swing.JLabel();
        lbl_cashWithdrawal = new javax.swing.JLabel();
        lbl_cashDeposit = new javax.swing.JLabel();
        lbl_back = new javax.swing.JLabel();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_cashWithdrawal.setOpaque(false);
        pan_cashWithdrawal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_noRek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_noRek.setForeground(new java.awt.Color(255, 255, 255));
        lab_noRek.setText("###############");
        pan_cashWithdrawal.add(lab_noRek, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 43, -1, -1));

        lab_saldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_saldo.setForeground(new java.awt.Color(255, 255, 255));
        lab_saldo.setText("###############");
        pan_cashWithdrawal.add(lab_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 65, -1, -1));

        cb_nom.setForeground(new java.awt.Color(255, 255, 255));
        cb_nom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "50.000,00", "100.000,00", "150.000,00", "200.000,00", "250.000,00", "500.000,00", "1.000.000,00", "1.500.000,00", "2.000.000,00", "2.500.000,00" }));
        pan_cashWithdrawal.add(cb_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 87, -1, -1));

        bt_cashWithdrawal.setBackground(new java.awt.Color(72, 70, 109));
        bt_cashWithdrawal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        bt_cashWithdrawal.setForeground(new java.awt.Color(171, 237, 216));
        bt_cashWithdrawal.setText("CASH WITHDRAWAL");
        bt_cashWithdrawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cashWithdrawalActionPerformed(evt);
            }
        });
        pan_cashWithdrawal.add(bt_cashWithdrawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 130, 150, 27));

        lab_bgCashWithdrawal.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\SystemBank-StructureData\\images\\background\\Cash Withdrawal.png")); // NOI18N
        pan_cashWithdrawal.add(lab_bgCashWithdrawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pan_cashWithdrawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 290, 354, 176));

        pan_cashDeposit.setOpaque(false);
        pan_cashDeposit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_noRek1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_noRek1.setForeground(new java.awt.Color(255, 255, 255));
        lab_noRek1.setText("###############");
        pan_cashDeposit.add(lab_noRek1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 43, -1, -1));

        lab_saldo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lab_saldo1.setForeground(new java.awt.Color(255, 255, 255));
        lab_saldo1.setText("###############");
        pan_cashDeposit.add(lab_saldo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 65, -1, -1));

        cb_nom1.setForeground(new java.awt.Color(255, 255, 255));
        cb_nom1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "50.000,00", "100.000,00", "150.000,00", "200.000,00", "250.000,00", "500.000,00", "1.000.000,00", "1.500.000,00", "2.000.000,00", "2.500.000,00" }));
        pan_cashDeposit.add(cb_nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 87, -1, -1));

        bt_cashDeposit.setBackground(new java.awt.Color(72, 70, 109));
        bt_cashDeposit.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        bt_cashDeposit.setForeground(new java.awt.Color(171, 237, 216));
        bt_cashDeposit.setText("CASH DEPOSIT");
        bt_cashDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cashDepositActionPerformed(evt);
            }
        });
        pan_cashDeposit.add(bt_cashDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 120, 27));

        lab_bgCashDeposit.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\SystemBank-StructureData\\images\\background\\Cash Deposit.png")); // NOI18N
        pan_cashDeposit.add(lab_bgCashDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pan_cashDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 290, 354, 176));

        lbl_cashWithdrawal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cashWithdrawalMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_cashWithdrawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 192, 90, 90));

        lbl_cashDeposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cashDepositMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_cashDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 85, 93));

        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 24, 25, 25));

        lbl_background.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\SystemBank-StructureData\\images\\background\\Nasabah Page - Cardless.png")); // NOI18N
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cashWithdrawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cashWithdrawalActionPerformed
        if (cb_nom.getSelectedItem().toString().equals("-")) {
            JOptionPane.showMessageDialog(null, "Maaf, Nominal belum diisi !");
            cb_nom.requestFocus();
        } else {
            try {
                String nominal = cb_nom.getSelectedItem().toString().replace(".", "").replace(",00", "");
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        dispose();
                        NasabahPage_kodePenarikan KP = new NasabahPage_kodePenarikan(nominal, "tartun");
                        KP.setVisible(true);
                    }
                });
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nasabah gagal tarik tunai", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_cashWithdrawalActionPerformed

    private void lbl_cashWithdrawalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cashWithdrawalMouseClicked
        pan_cashWithdrawal.setVisible(true);
        pan_cashDeposit.setVisible(false);
    }//GEN-LAST:event_lbl_cashWithdrawalMouseClicked

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        dispose();
        NasabahPage_LandingPage LP = new NasabahPage_LandingPage();
        LP.setVisible(true);
    }//GEN-LAST:event_lbl_backMouseClicked

    private void bt_cashDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cashDepositActionPerformed
        if (cb_nom1.getSelectedItem().toString().equals("-")) {
            JOptionPane.showMessageDialog(null, "Maaf, Nominal belum diisi !");
            cb_nom1.requestFocus();
        } else {
            try {
                String nominal = cb_nom1.getSelectedItem().toString().replace(".", "").replace(",00", "");
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        dispose();
                        NasabahPage_kodePenarikan KP = new NasabahPage_kodePenarikan(nominal, "settun");
                        KP.setVisible(true);
                    }
                });
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nasabah gagal setor tunai", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_cashDepositActionPerformed

    private void lbl_cashDepositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cashDepositMouseClicked
        pan_cashWithdrawal.setVisible(false);
        pan_cashDeposit.setVisible(true);
    }//GEN-LAST:event_lbl_cashDepositMouseClicked

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
            java.util.logging.Logger.getLogger(NasabahPage_Cardless.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NasabahPage_Cardless.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NasabahPage_Cardless.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NasabahPage_Cardless.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NasabahPage_Cardless().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cashDeposit;
    private javax.swing.JButton bt_cashWithdrawal;
    private javax.swing.JComboBox<String> cb_nom;
    private javax.swing.JComboBox<String> cb_nom1;
    private javax.swing.JLabel lab_bgCashDeposit;
    private javax.swing.JLabel lab_bgCashWithdrawal;
    private javax.swing.JLabel lab_noRek;
    private javax.swing.JLabel lab_noRek1;
    private javax.swing.JLabel lab_saldo;
    private javax.swing.JLabel lab_saldo1;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_cashDeposit;
    private javax.swing.JLabel lbl_cashWithdrawal;
    private javax.swing.JPanel pan_cashDeposit;
    private javax.swing.JPanel pan_cashWithdrawal;
    // End of variables declaration//GEN-END:variables
}
