/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_demo;

import code_test.Database_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author top1z
 */
public class form extends javax.swing.JFrame {

    /**
     * Creates new form form
     */
    Connection cn;
    Statement stm;
    PreparedStatement ppd;
    int index;
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel<String> modelcb = new DefaultComboBoxModel<>();
    
    public form() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            cn = Database_Connect.Database("QLSV1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        model = (DefaultTableModel) tblsinhvien.getModel();
        model.setRowCount(0);
        loadtable();
        modelcb = (DefaultComboBoxModel) combokhoa.getModel();
        loadtocombo();
    }
    
    private void mess(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
    
    private void loadtable() {
        try {
            String sql = " select SINHVIEN.Masv, Hoten,"
                    + " DienThoai, email from SINHVIEN";
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4)});
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void changed() {
        try {
            model.setRowCount(0);
            String sql = " select SINHVIEN.Masv, Hoten, DienThoai, email from SINHVIEN"
                    + " join KHOANGANH on KHOANGANH.MaKN = SINHVIEN.MaKN where KHOANGANH.MaKN = ?";
//            stm = cn.createStatement();
            ppd = cn.prepareStatement(sql);
            ppd.setString(1, combokhoa.getSelectedItem() + "");
            ResultSet rs = ppd.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1),
                    rs.getString(2), rs.getString(3), rs.getString(4)});
            }
            if (model.getRowCount() > 0) {
                index = 0;
                showtt();
            } else {
                clear();
            }
            ppd.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void clear() {
        txtmasv.setText("");
        txthoten.setText("");
        txtsdt.setText("");
        txtemail.setText("");
    }
    
    private void showtt() {
        txtmasv.setText(model.getValueAt(index, 0).toString());
        txthoten.setText(model.getValueAt(index, 1).toString());
        txtsdt.setText(model.getValueAt(index, 2).toString());
        txtemail.setText(model.getValueAt(index, 3).toString());
    }
    
    private void loadtocombo() {
        try {
            String sql = " select * from KhoaNganh";
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                modelcb.addElement(rs.getString(1));
                txtkhoangah.setText(rs.getString(2));
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from witin the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combokhoa = new javax.swing.JComboBox<>();
        txtkhoangah = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsinhvien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtmasv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("ma kn");

        combokhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combokhoaItemStateChanged(evt);
            }
        });
        combokhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokhoaActionPerformed(evt);
            }
        });

        txtkhoangah.setText("jLabel2");

        tblsinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "masv", "hoten", "sodt", "email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsinhvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsinhvien);

        jLabel2.setText("ma sv");

        jLabel3.setText("ho t??n");

        jLabel4.setText("s??? dt");

        jLabel5.setText("email");

        jButton1.setText("new ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(combokhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtkhoangah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmasv)
                            .addComponent(txthoten)
                            .addComponent(txtsdt)
                            .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combokhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkhoangah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

    private void combokhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combokhoaActionPerformed

    private void combokhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combokhoaItemStateChanged
        // TODO add your handling code here:
        changed();
    }//GEN-LAST:event_combokhoaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblsinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsinhvienMouseClicked
        // TODO add your handling code here:
        try {
            index = tblsinhvien.getSelectedRow();
            showtt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblsinhvienMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
//            model.setRowCount(0);
            String sql = " delete from SINHVIEN where  Masv = ?";
//            stm = cn.createStatement();
            ppd = cn.prepareStatement(sql);
            ppd.setString(1, txtmasv.getText());
            
            ppd.executeUpdate();
            changed();
            clear();
            ppd.close();
//            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (txtmasv.getText().equals("")) {
            mess("m?? kh??ng ????? tr???ng");
            return;
        }
        if (txtemail.getText().equals("")) {
            mess("m?? kh??ng ????? tr???ng");
            return;
        }
        if (txtsdt.getText().equals("")) {
            mess("m?? kh??ng ????? tr???ng");
            return;
        } else {
            try {
//            model.setRowCount(0);
                String sql = "  insert SINHVIEN (Masv, Hoten, MaKN,DienThoai,"
                        + "email) values (?,?,?,?,?)";
//            stm = cn.createStatement();
                ppd = cn.prepareStatement(sql);
                ppd.setString(1, txtmasv.getText());
                ppd.setString(2, txthoten.getText());
                ppd.setString(3, combokhoa.getSelectedItem() + "");
                ppd.setString(4, txtsdt.getText());
                ppd.setString(5, txtemail.getText());
                ppd.executeUpdate();
                changed();
                mess("ok");
                clear();
                ppd.close();
//            rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combokhoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblsinhvien;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JLabel txtkhoangah;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
