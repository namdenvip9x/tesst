/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_test;

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
public class code_one extends javax.swing.JFrame {

    /**
     * Creates new form code_one
     */
    Connection cn;
    Statement stm;
    int index;
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel<String> modelcb = new DefaultComboBoxModel<>();
    PreparedStatement ppd;

    public code_one() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            cn = Database_Connect.Database("QLSV");

        } catch (Exception e) {
            e.printStackTrace();
        }
        model = (DefaultTableModel) tblsinhvien.getModel();
        model.setRowCount(0);
        filltotable();
        if (model.getRowCount() > 0) {
            showdtt();
            index = 0;
        }
        modelcb = (DefaultComboBoxModel<String>) combobox.getModel();
        loadcombo();
    }

    private void mess(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    private void filltotable() {
        try {
            model.setRowCount(0);
            String sql = "select Masv, Hoten, gioitinh,Khoanganh from STUDENT "
                    + "join Class on STUDENT.IDClass = Class.IDClass";
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)});
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadcombo() {
        try {
            String sql = "select IDClass from Class";
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                modelcb.addElement(rs.getString(1));
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        txtmasv.setText("");
        txthoten.setText("");

        txtkhoangngah.setText("");

        rdonam.setSelected(true);
//        index = -1;

    }

    private void showdtt() {
        try {
            txtmasv.setText(model.getValueAt(index, 0).toString());
            txthoten.setText(model.getValueAt(index, 1).toString());
            String gt = (model.getValueAt(index, 2).toString());
            if (gt.equals("Nam")) {
                rdonam.setSelected(true);
            } else {

                rdonu.setSelected(true);

            }
            txtkhoangngah.setText(model.getValueAt(index, 3).toString());
        } catch (Exception e) {
//            mess("kh??ng c?? dl");
//            e.printStackTrace();
        }
    }

    private void fk_pk() {
        try {
//            model.setRowCount(0);
            String sql = "select Masv from STUDENT ";
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                if (txtmasv.getText().equalsIgnoreCase(rs.getString("Masv"))) {
                    mess("tr??ng kh??a");
                    return;
                }
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsinhvien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmasv = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rdonam = new javax.swing.JCheckBox();
        rdonu = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtkhoangngah = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("class");

        combobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxItemStateChanged(evt);
            }
        });

        tblsinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "masv", "hoten", "gioi tinh", "khoang nganh"
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

        jLabel2.setText("masv");

        jLabel3.setText("ho ten");

        jButton1.setText("new");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("delelte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("gioi tinh");

        buttonGroup1.add(rdonam);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setText("N???");

        jLabel5.setText("khoang nganh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdonam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdonu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmasv)
                                    .addComponent(txthoten)
                                    .addComponent(txtkhoangngah, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(rdonam)
                        .addComponent(rdonu)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel5)
                    .addComponent(txtkhoangngah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int chon = JOptionPane.showConfirmDialog(this, "x??a?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                String sql = "delete from STUDENT where Masv =?";
//                stm = cn.createStatement();
                ppd = cn.prepareStatement(sql);
                ppd.setString(1, txtmasv.getText());
                ppd.executeUpdate();

                mess("???? x??a");
                filltotable();
                ppd.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (chon == -1) {
            mess("kh??ng c?? d??ng x??a");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here
        try {
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

    private void tblsinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsinhvienMouseClicked
        // TODO add your handling code here:
        try {
            index = tblsinhvien.getSelectedRow();
            showdtt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblsinhvienMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (txtmasv.getText().equals("")) {
            mess("m?? sv kh??ng ????? tr???ng");
            return;
        } else if (txthoten.getText().equals("")) {
            mess("hoten sv kh??ng ????? tr???ng");
            return;
        } else if (txtkhoangngah.getText().equals("")) {
            mess("kho???ng ng??nh sv kh??ng ????? tr???ng");
            return;
        } else {
            try {
                fk_pk();

                String sql = "insert into STUDENT(Masv,Hoten,IDClass,gioitinh,Khoanganh) values (?,?,?,?,?)";
                ppd = cn.prepareStatement(sql);
                ppd.setString(1, txtmasv.getText());
                ppd.setString(2, txthoten.getText());
                ppd.setString(3, combobox.getSelectedItem() + "");
                String gt = rdonam.isSelected() ? "nam" : "n???";
                ppd.setString(4, gt);
                ppd.setString(5, txtkhoangngah.getText());
                ppd.executeUpdate();

                mess("???? th??m v??o");
                filltotable();
                ppd.close();

            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (txtmasv.getText().equals("")) {
            mess("m?? sv kh??ng ????? tr???ng");
            return;
        }
        if (txthoten.getText().equals("")) {
            mess("hoten sv kh??ng ????? tr???ng");
            return;
        }
        if (txtkhoangngah.getText().equals("")) {
            mess("kho???ng ng??nh sv kh??ng ????? tr???ng");
            return;
        } else {
            try {

                String sql = "update STUDENT set hoten =? , "
                        + "gioitinh=? ,Khoanganh=? where Masv= ? ";
                ppd = cn.prepareStatement(sql);
                ppd.setString(4, txtmasv.getText());
                ppd.setString(1, txthoten.getText());
//                ppd.setString(3, combobox.getSelectedItem()+"");
                String gt = rdonam.isSelected() ? "Nam" : "N???";
                ppd.setString(2, gt);
                ppd.setString(3, txtkhoangngah.getText());
                ppd.executeUpdate();

                mess("???? c???p nh???p v??o");
//                filltotable();
                changed();
                ppd.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private  void changed(){
         try {
            model.setRowCount(0);
            String sql = "select Masv, Hoten, gioitinh,Khoanganh from STUDENT "
                    + " where IDClass =?";
            ppd = cn.prepareStatement(sql);
            ppd.setString(1, combobox.getSelectedItem() + "");
            ResultSet rs = ppd.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)});
            }
            if (model.getRowCount() > 0) {
                showdtt();
                index = 0;
            } else {
                clear();

            }
            ppd.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    private void comboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxItemStateChanged
        // TODO add your handling code here:
        try {
            model.setRowCount(0);
            String sql = "select Masv, Hoten, gioitinh,Khoanganh from STUDENT "
                    + " where IDClass =?";
            ppd = cn.prepareStatement(sql);
            ppd.setString(1, combobox.getSelectedItem() + "");
            ResultSet rs = ppd.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)});
            }
            if (model.getRowCount() > 0) {
                showdtt();
                index = 0;
            } else {
                clear();

            }
            ppd.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_comboboxItemStateChanged

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
            java.util.logging.Logger.getLogger(code_one.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(code_one.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(code_one.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(code_one.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new code_one().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox rdonam;
    private javax.swing.JCheckBox rdonu;
    private javax.swing.JTable tblsinhvien;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtkhoangngah;
    private javax.swing.JTextField txtmasv;
    // End of variables declaration//GEN-END:variables
}
