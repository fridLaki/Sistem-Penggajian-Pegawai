/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.view;

import com.penggajian.entity.TunjanganStaffKurikulumEkstrakurikuluer;
import com.penggajian.main.DialogView;
import com.penggajian.main.MainView;
import com.penggajian.main.SpringManager;
import com.penggajian.service.MasterService;
import com.penggajian.util.TextComponentUtils;
import com.penggajian.validator.ValidatorException;
import com.penggajian.validator.implement.TunjanganStaffKurikulumEkstrakurikuluerValidator;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Window;
import java.math.BigDecimal;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Windows
 */
public class DaftarTunjanganStaffKurikulumEkstraKurikuluerDialog extends DialogView {

    /**
     * Creates new form DaftarTunjanganStaffKurikulumEkstraKurikuluerDialog
     */
    private TunjanganStaffKurikulumEkstrakurikuluer ts;
    private JDynamicTable dynamicTable;
    private DynamicTableModel<TunjanganStaffKurikulumEkstrakurikuluer> dynamicTableModel;
    
    public DaftarTunjanganStaffKurikulumEkstraKurikuluerDialog(MainView mainView) {
        super(mainView);
        initComponents();
        
        dynamicTableModel = new DynamicTableModel<>(TunjanganStaffKurikulumEkstrakurikuluer.class);
        dynamicTable = new JDynamicTable(dynamicTableModel);
        jScrollPane1.setViewportView(dynamicTable);
        addListSelectionListener();
    }
    
    private void refreshTable(){
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        dynamicTableModel.clear();
        for (TunjanganStaffKurikulumEkstrakurikuluer tf : masterService.getAllTunjanganStaffKurikulumKasi()) {
            dynamicTableModel.add(tf);
        }
        txtJumlahJam.setText("");
        cmbUnitKerja.setSelectedIndex(0);
        cmbJenisTunjangan.setSelectedIndex(0);
        txtJumlahTunjangan.setText("");
        btnSimpan.setText("Simpan");
    }
    
    private void addListSelectionListener(){
        dynamicTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (dynamicTable.getSelectedRow() != -1) {
                    btnSimpan.setText("Ubah");
                    ts = dynamicTableModel.get(
                            dynamicTable.convertRowIndexToModel(
                            dynamicTable.getSelectedRow()));
                    try {
                        cmbJenisTunjangan.setSelectedItem(ts.getJenisTunjangan());
                        cmbUnitKerja.setSelectedItem(ts.getUnitKerja());
                        txtJumlahJam.setText(ts.getJumlahJam());
                        txtJumlahTunjangan.setText(TextComponentUtils.formatNumber(String.valueOf(ts.getJumlahTunjangan())));
                    } catch (Exception ex) {
                    }
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtJumlahJam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabelDaftarTunjanganSTAFFKASIKURIKULUM = new javax.swing.JTable();
        cmbUnitKerja = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbJenisTunjangan = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtJumlahTunjangan = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabel Daftar Tunjangan Jam Mengajar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TABEL DAFTAR TUNJANGAN STAFF/KURIKULUM/EKSTRAKURIKULUER");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Jumlah Tunjangan");

        txtJumlahJam.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tblTabelDaftarTunjanganSTAFFKASIKURIKULUM.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTabelDaftarTunjanganSTAFFKASIKURIKULUM);

        cmbUnitKerja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "-", "Yayasan Mardi Yuana", "Yayasan Perwakilan", "TK", "SD", "SMP", "SMA", "SMK" }));

        jLabel2.setText("Unit Kerja");

        jLabel3.setText("Jenis Tunjangan");

        cmbJenisTunjangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "Tunjangan Staf Kasi Kurikulum", "Tunjangan Staf Kasi Kesiswaan", "Tunjangan Staf Kasi Humas", "Tunjangan Staf Kasi Sarana/Prasarana", "Tunjangan Staf Wali Kelas", "Tunjangan Kurikuler Pembina OSIS", "Tunjangan Kurikuler BP", "Tunjangan Kurikulum Praktikum", "Tunjangan Kurikulum Komputer", "Tunjangan Ekstra OR", "Tunjangan Ekstra Seni", "Tunjangan Ekstra Pra/PMR", "Tunjangan UKS", "Tunjangan Pasti" }));

        jLabel4.setText("Jam  *");

        txtJumlahTunjangan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtJumlahTunjangan.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbJenisTunjangan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbUnitKerja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtJumlahJam, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtJumlahTunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 185, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbJenisTunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUnitKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtJumlahJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtJumlahTunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnHapus)
                    .addComponent(btnSimpan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction
       // TODO add your handling code here:
        Object source = evt.getSource();
        if(source == btnSimpan){
            if (btnSimpan.getText().matches("Simpan")) {
                ts = new TunjanganStaffKurikulumEkstrakurikuluer();
                ts.setJenisTunjangan(cmbJenisTunjangan.getSelectedItem().toString().trim());
                ts.setUnitKerja(cmbUnitKerja.getSelectedItem().toString().trim());
                ts.setJumlahJam(txtJumlahJam.getText().trim());
                ts.setJumlahTunjangan(BigDecimal.valueOf(Long.valueOf(txtJumlahTunjangan.getText().replace(".", "").trim())));
                
                TunjanganStaffKurikulumEkstrakurikuluerValidator validator = SpringManager.getInstance().getBean(TunjanganStaffKurikulumEkstrakurikuluerValidator.class);
                MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
                
                try {
                    validator.validate(ts);
                    masterService.save(ts);
                    showWarning("Simpan sukses");
                    refreshTable();
                } catch (DataAccessException ex) {
                    showError(ex.getRootCause().getMessage());
                } catch (ValidatorException e) {
                    showWarning(e.getMessage());
                }
            } else if(btnSimpan.getText().matches("Ubah")) {
                ts.setJenisTunjangan(cmbJenisTunjangan.getSelectedItem().toString().trim());
                ts.setUnitKerja(cmbUnitKerja.getSelectedItem().toString().trim());
                ts.setJumlahJam(txtJumlahJam.getText().trim());
                ts.setJumlahTunjangan(BigDecimal.valueOf(Long.valueOf(txtJumlahTunjangan.getText().replace(".", "").trim())));
                

                TunjanganStaffKurikulumEkstrakurikuluerValidator validator = SpringManager.getInstance().getBean(TunjanganStaffKurikulumEkstrakurikuluerValidator.class);
                MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);

                try {
                    validator.validate(ts);
                    masterService.update(ts);
                    showWarning("Ubah sukses");
                    refreshTable();
                } catch (DataAccessException ex) {
                    showError(ex.getRootCause().getMessage());
                } catch (ValidatorException e) {
                    showWarning(e.getMessage());
                }
            }
        } else if(source == btnHapus){
            if (dynamicTable.getSelectedRow() == -1) {
                showWarning("Silahkan pilih salah satu");
            } else {
                TunjanganStaffKurikulumEkstrakurikuluer ts = dynamicTableModel.get(
                        dynamicTable.convertRowIndexToModel(
                        dynamicTable.getSelectedRow()));
                
                MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
                
                try {
                    masterService.delete(ts);
                    refreshTable();
                } catch (DataAccessException ex) {
                    showError(ex.getRootCause().getMessage());
                }
            }  
        } else if (source == btnBatal){
            dispose();
        }
    }//GEN-LAST:event_buttonAction

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabelDaftarTunjanganJabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelDaftarTunjanganJabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelDaftarTunjanganJabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelDaftarTunjanganJabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TabelDaftarTunjanganJabatanDialog dialog = new TabelDaftarTunjanganJabatanDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbJenisTunjangan;
    private javax.swing.JComboBox cmbUnitKerja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTabelDaftarTunjanganSTAFFKASIKURIKULUM;
    private javax.swing.JTextField txtJumlahJam;
    private javax.swing.JTextField txtJumlahTunjangan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void display(Window formApp, Object parameter) {       
        refreshTable();
        TextComponentUtils.setCurrency(txtJumlahTunjangan);
        TextComponentUtils.setNumericTextOnly(txtJumlahJam);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
