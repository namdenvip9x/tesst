/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_java3;

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
public class demo extends javax.swing.JFrame {

    /**
     * Creates new form demo
     */
    Connection cn;
    Statement stm;
    int index;
    PreparedStatement pred;
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel<String> modelcb = new DefaultComboBoxModel<>();

    public demo() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            cn = Database_Connect.Database("QLSV");
        } catch (Exception e) {
            e.printStackTrace();
        }
        model = (DefaultTableModel) tblsinhvien.getModel();
        model.setRowCount(0);
        loadtable();
        modelcb = (DefaultComboBoxModel<String>) combosv.getModel();
        loadcombo();
        index = 0;

    }

    private void mess(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    private void loadtable() {
        try {
            String sql = "select Masv, Hoten, Khoanganh, gioitinh ,Ngaysinh from STUDENT";
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5)});
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadcombo() {
        try {
            String sql = "select IDCLASS from CLASS";
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

        txtngaysinh.setText("");

        rdonam.setSelected(true);
        index = -1;
    }

    private void xoa() {
        try {

            String sql = "delete from STUDENT where Masv =?";
//            stm = cn.createStatement();
            pred = cn.prepareStatement(sql);

            pred.setString(1, txtmasv.getText());
            pred.executeUpdate();
            mess("đã xóa");
            model.setRowCount(0);
            loadtable();
            clear();
            pred.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean check() {
        if (txtmasv.getText().equals("")) {
            mess("mã không để trống");
            return false;
        } else if (txthoten.getText().equals("")) {
            mess("tên không để trống");
            return true;

        } else if (txtngaysinh.getText().equals("")) {
            mess("tên không để trống");
            return true;
        } else {
            try {

                String gt = rdonam.isSelected() ? "Nam" : "Nữ";
                String sql = "insert STUDENT values(?,?,?,?,?,?,?,?,?)";
//            stm = cn.createStatement();
                pred = cn.prepareStatement(sql);

                pred.setString(1, txtmasv.getText());
                pred.setString(2, txthoten.getText());
                pred.setString(4, txtngaysinh.getText());
                pred.setString(5, gt);
                pred.setString(3, combosv.getSelectedItem() + "");
                pred.setString(6, "");
                pred.setString(7, "");
                pred.setString(8, "");
                pred.setString(9, "");

                int row = pred.executeUpdate();
                if (row > 0) {
                    clear();
                    mess("đã thêm vào");
                    model.setRowCount(0);
                    

                    loadtable();
                } else {
                    clear();
                }
                pred.close();

            } catch (Exception e) {
//            e.printStackTrace();
             
            }
        }
        return false;
    }

    void fk_for() {
        try {
            String sql = "select Masv from STUDENT";
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                if (txtmasv.getText().equalsIgnoreCase(rs.getString(1))) {
                    mess("trungf khóa");
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
        combosv = new javax.swing.JComboBox<>();
        txtkhoanganh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtmasv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsinhvien = new javax.swing.JTable();
        btnsua = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        combosv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combosvItemStateChanged(evt);
            }
        });

        jLabel1.setText("masv");

        jLabel2.setText("hoten");

        tblsinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Masv", "hoten", "khoanganh", "ngaysinh", "gioitinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btnsua.setText("sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jButton2.setText("new");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnthem.setText("thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel3.setText("ngaysinh");

        jLabel4.setText("gioitinh");

        buttonGroup1.add(rdonam);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdonam)
                                .addGap(8, 8, 8)
                                .addComponent(rdonu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtngaysinh))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(btnsua)
                                .addGap(48, 48, 48)
                                .addComponent(jButton2)
                                .addGap(44, 44, 44)
                                .addComponent(jButton3)
                                .addGap(33, 33, 33)
                                .addComponent(btnthem))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(combosv, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(txtkhoanganh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combosv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkhoanganh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rdonam)
                    .addComponent(rdonu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsua)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnthem))
                .addContainerGap(19, Short.MAX_VALUE))
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

    private void combosvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combosvItemStateChanged
        // TODO add your handling code here:
        try {
            String sql = "select  Khoanganh from STUDENT join\n"
                    + "Class on STUDENT.IDClass = Class.IDClass where STUDENT.IDClass=  ?";
//            stm = cn.createStatement();
            pred = cn.prepareStatement(sql);
            pred.setString(1, combosv.getSelectedItem() + "");
            ResultSet rs = pred.executeQuery();
            while (rs.next()) {
                txtkhoanganh.setText(rs.getString("Khoanganh"));
            }
            pred.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_combosvItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblsinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsinhvienMouseClicked
        // TODO add your handling code here:
        try {
            index = tblsinhvien.getSelectedRow();
            txtmasv.setText(model.getValueAt(index, 0).toString());
            txthoten.setText(model.getValueAt(index, 1).toString());

            txtngaysinh.setText(model.getValueAt(index, 4).toString());

            String gt = model.getValueAt(index, 3).toString();
            if (gt.equals("Nam")) {
                rdonam.setSelected(true);
            } else {
                rdonu.setSelected(true);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblsinhvienMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void add() {
        try {
            model.setRowCount(0);
            String gt = rdonam.isSelected() ? "Nam" : "Nữ";
            String sql = "update STUDENT set HoTen =? , ngaysinh = ?,gioitinh =? where Masv =?";
//            stm = cn.createStatement();
            pred = cn.prepareStatement(sql);

            pred.setString(4, txtmasv.getText());
            pred.setString(1, txthoten.getText());
            pred.setString(2, txtngaysinh.getText());
            pred.setString(3, gt);

            pred.executeUpdate();
            mess("đã sửa");
            clear();
            loadtable();

            pred.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        
        fk_for();
        add();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        fk_for();

        check();

    }//GEN-LAST:event_btnthemActionPerformed

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
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combosv;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tblsinhvien;
    private javax.swing.JTextField txthoten;
    private javax.swing.JLabel txtkhoanganh;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txtngaysinh;
    // End of variables declaration//GEN-END:variables
}
