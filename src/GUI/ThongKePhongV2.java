/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.BLLPhong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import model.printPhong;
import object.Phong;

/**
 *
 * @author Tran Huy Hoang
 */
public class ThongKePhongV2 extends javax.swing.JFrame {

    /**
     * Creates new form ThongKePhongV2
     */
    JPanel pnLast;

    public ThongKePhongV2() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        thongKeTheoLoaiPhong();
        thongKeTheoTinhTrang();
        hienThiDanhSachPhong();
    }

    private void thongKeTheoLoaiPhong() {
        HashMap<String, Integer> ds = BLLPhong.thongKeTheoLoaiPhong();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Loại Phòng");
        dtm.addColumn("Số Lượng");
        for (Map.Entry<String, Integer> m : ds.entrySet()) {
            Vector<String> v = new Vector<>();
            v.add(m.getKey());
            v.add(m.getValue() + "");
            dtm.addRow(v);
        }
        tblTheoLoaiPhong.setModel(dtm);
    }

    private void hienThiDanhSachPhong() {
        ArrayList<Phong> dsPhong = BLLPhong.layToanBoDanhSachPhong();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã phòng");
        dtm.addColumn("Tên phòng");
        dtm.addColumn("Loại phòng");
        dtm.addColumn("Tình trạng");
        for (Phong p : dsPhong) {
            Vector<String> v = new Vector<>();
            v.add(p.getMaPhong());
            v.add(p.getTenPhong());
            String maLoaiPhong = p.getMaLoaiPhong();
            v.add(layTenLoaiPhong(maLoaiPhong));
            String maTinhTrang=p.getMaTinhTrang();
            v.add(layTenTinhTrang(maTinhTrang));
            dtm.addRow(v);
        }
        jTable1.setModel(dtm);
    }

    private String layTenLoaiPhong(String maLoaiPhong) {
        String ten = "";
        if (maLoaiPhong.equalsIgnoreCase("LoaiPhong1")) {
            ten = "Phòng Vip";
        } else if (maLoaiPhong.equalsIgnoreCase("LoaiPhong2")) {
            ten = "Phòng Đơn";
        } else if (maLoaiPhong.equalsIgnoreCase("LoaiPhong3")) {
            ten = "Phòng Đôi";
        }
        return ten;
    }

    private String layTenTinhTrang(String maTinhTrang) {
        String tinhTrang = "";
        if (maTinhTrang.equalsIgnoreCase("TinhTrang01")) {
            tinhTrang = "Sẵn Sàng";
        } else if (maTinhTrang.equalsIgnoreCase("TinhTrang02")) {
            tinhTrang = "Đang Có Khách";
        } else if (maTinhTrang.equalsIgnoreCase("TinhTrang03")) {
            tinhTrang = "Đang Dọn Dẹp";
        } else if (maTinhTrang.equalsIgnoreCase("TinhTrang04")) {
            tinhTrang = "Đang Sửa Chữa";
        } else if (maTinhTrang.equalsIgnoreCase("TinhTrang05")) {
            tinhTrang = "Đang Dọn Dẹp";
        }
        return tinhTrang;
    }

    private void thongKeTheoTinhTrang() {
        HashMap<String, Integer> ds = BLLPhong.thongKeTheoTinhTrang();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Tình Trạng");
        dtm.addColumn("Số Lượng");
        for (Map.Entry<String, Integer> m : ds.entrySet()) {
            Vector<String> v = new Vector<>();
            v.add(m.getKey());
            v.add(m.getValue() + "");
            dtm.addRow(v);
        }
        tblTheoTinhTrangPhong.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTheoLoaiPhong = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTheoTinhTrangPhong = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 450));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Thống Kê Phòng");

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setText("Xuất ra file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 153));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setLayout(new java.awt.BorderLayout());

        tblTheoLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Loại Phòng", "Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(tblTheoLoaiPhong);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Loại Phòng", jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        tblTheoTinhTrangPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tình Trạng Phòng", "Số Lượng"
            }
        ));
        jScrollPane3.setViewportView(tblTheoTinhTrangPhong);

        jPanel4.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Tình Trạng Phòng", jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Danh Sách Phòng", jPanel5);

        jPanel2.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        pnLast = (JPanel) jTabbedPane1.getSelectedComponent();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (pnLast == jPanel3) {
            printPhong.inThongKePhongTheoLoaiPhong();
        } else if (pnLast == jPanel4) {
            printPhong.inThongKePhongTheoTinhTrang();
        } else if (pnLast == jPanel5) {
            printPhong.inDanhSachPhong();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKePhongV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKePhongV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKePhongV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKePhongV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKePhongV2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblTheoLoaiPhong;
    private javax.swing.JTable tblTheoTinhTrangPhong;
    // End of variables declaration//GEN-END:variables
}