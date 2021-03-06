/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.view;

import com.penggajian.main.DialogView;
import com.penggajian.main.MainView;
import com.penggajian.entity.MasterPegawai;
import com.penggajian.main.SpringManager;
import com.penggajian.service.MasterService;
import com.penggajian.util.TextComponentUtils;
import com.penggajian.validator.ValidatorException;
import com.penggajian.validator.implement.MasterPegawaiValidator;
import java.awt.Window;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Windows
 */
public class UbahPegawaiDialog extends DialogView {

    /**
     * Creates new form TambahPegawaiDialog
     * @param view
     */
    
    private MasterPegawai mp;

    public UbahPegawaiDialog(MainView mainView){
        super(mainView);
        initComponents();
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
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        cmbPendidikan = new javax.swing.JComboBox();
        cmbStatusSipil = new javax.swing.JComboBox();
        cmbStatusKepegawaian = new javax.swing.JComboBox();
        cmbJabatan = new javax.swing.JComboBox();
        cmbTingkat = new javax.swing.JComboBox();
        cmbGolongan = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        cmbSubGolongan = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cmbMasaKerja = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbSubStatusKepegawaian = new javax.swing.JComboBox();
        txtNama = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ubah Data Pegawai");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UBAH DATA PEGAWAI");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Nama Pegawai");

        jLabel18.setText("NIP");

        jLabel19.setText("Pendidikan");

        jLabel20.setText("Status Sipil");

        jLabel21.setText("Status Kepegawaian");

        jLabel22.setText("Jabatan");

        jLabel23.setText("Unit Kerja");

        jLabel24.setText("Golongan");

        cmbPendidikan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "D1/SMA/Sederajad", "D2", "D3", "S1", "S1 + Akta", "S2" }));

        cmbStatusSipil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "Tidak Kawin (TK)", "Kawin (K/0)", "Kawin 1 Anak (K/1)", "Kawin 2 Anak (K/2)", "Kawin 3 Anak (K/3)", "Duda (D)", "Duda 1 Anak (D/1)", "Duda 2 Anak (D/2)", "Duda 3 Anak (D/3)", "Janda (J)", "Janda 1 Anak (J/1)", "Janda 2 Anak (J/2)", "Janda 3 Anak (J/3)" }));

        cmbStatusKepegawaian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "Honor Lepas (HL)", "Honor Masa Percobaan (HMP)", "Honor Sementara (HS)", "Calon Pegawai (CP)", "Pegawai Tetap (PT)" }));

        cmbJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "Kepala TK", "Kepala Sekolah", "Guru", "Tata Usaha", "Petugas Perpustakaan", "Satpam", "Pegawai Kebersihan", "Staf", "Kepala Bidang" }));

        cmbTingkat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "Yayasan Mardi Yuana", "Yayasan Perwakilan", "TK", "SD", "SMP", "SMA", "SMK" }));

        cmbGolongan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "-", "I", "II", "III", "IV" }));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Sub Golongan");

        cmbSubGolongan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "-", "a", "b", "c", "d", "e" }));

        jLabel28.setText("Masa Kerja Golongan");

        cmbMasaKerja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33" }));

        jLabel29.setText("Tahun");

        jLabel2.setText("Sub Status");

        cmbSubStatusKepegawaian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Salah Satu --", "Guru Kelas", "Guru Mata Pelajaran", "Tata Usaha", "Tenaga Perpustakaan", "Satpam", "Pegawai Kebersihan", "Staf", "Kepala Bidang" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbPendidikan, javax.swing.GroupLayout.Alignment.LEADING, 0, 163, Short.MAX_VALUE)
                                .addComponent(cmbStatusSipil, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMasaKerja, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbGolongan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbStatusKepegawaian, 0, 1, Short.MAX_VALUE)
                            .addComponent(cmbJabatan, javax.swing.GroupLayout.Alignment.TRAILING, 0, 163, Short.MAX_VALUE)
                            .addComponent(cmbTingkat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSubGolongan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSubStatusKepegawaian, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cmbPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cmbStatusSipil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbStatusKepegawaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSubStatusKepegawaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cmbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cmbTingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cmbGolongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(cmbSubGolongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cmbMasaKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBatal, btnSimpan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction
        // TODO add your handling code here:
        Object source = evt.getSource();
        if (source == btnBatal) {
            dispose();
        } else if(source == btnSimpan){
            mp.setNama(txtNama.getText());
            mp.setNip(txtNIP.getText());
            mp.setPendidikan(cmbPendidikan.getSelectedItem().toString());
            mp.setStatusSipil(cmbStatusSipil.getSelectedItem().toString());
            mp.setStatusKepegawaian(cmbStatusKepegawaian.getSelectedItem().toString());
            mp.setSubstatusKepegawaian(cmbSubStatusKepegawaian.getSelectedItem().toString());
            mp.setJabatan(cmbJabatan.getSelectedItem().toString());
            mp.setUnitKerja(cmbTingkat.getSelectedItem().toString());
            mp.setGolongan(cmbGolongan.getSelectedItem().toString());
            mp.setSubGolongan(cmbSubGolongan.getSelectedItem().toString());
            mp.setMasaKerjaGolongan(cmbMasaKerja.getSelectedItem().toString());
            //mp.setJenisPenghasilan("");
            
            MasterPegawaiValidator validator = SpringManager.getInstance().getBean(MasterPegawaiValidator.class);
            MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
            
            try {
                validator.validate(mp);
                masterService.update(mp);
                dispose();
            } catch (DataAccessException e) {
                showError(e.getRootCause().getMessage());
            } catch (ValidatorException ex) {
                showWarning(ex.getMessage());
            }
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
            java.util.logging.Logger.getLogger(GajiPokokDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GajiPokokDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GajiPokokDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GajiPokokDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GajiPokokDialog dialog = new GajiPokokDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbGolongan;
    private javax.swing.JComboBox cmbJabatan;
    private javax.swing.JComboBox cmbMasaKerja;
    private javax.swing.JComboBox cmbPendidikan;
    private javax.swing.JComboBox cmbStatusKepegawaian;
    private javax.swing.JComboBox cmbStatusSipil;
    private javax.swing.JComboBox cmbSubGolongan;
    private javax.swing.JComboBox cmbSubStatusKepegawaian;
    private javax.swing.JComboBox cmbTingkat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables

    //@Override
    @Override
    public void display(Window formApp, Object parameter) {
        //TextComponentUtils.setNumericTextOnly(txtNIP);
        mp = (MasterPegawai) parameter;
        
        txtNama.setText(mp.getNama());
        txtNIP.setText(mp.getNip());
        cmbPendidikan.setSelectedItem(mp.getPendidikan());
        cmbStatusSipil.setSelectedItem(mp.getStatusSipil());
        cmbStatusKepegawaian.setSelectedItem(mp.getStatusKepegawaian());
        cmbSubStatusKepegawaian.setSelectedItem(mp.getSubstatusKepegawaian());
        cmbJabatan.setSelectedItem(mp.getJabatan());
        cmbTingkat.setSelectedItem(mp.getUnitKerja());
        cmbGolongan.setSelectedItem(mp.getGolongan());
        cmbSubGolongan.setSelectedItem(mp.getSubGolongan());
        cmbMasaKerja.setSelectedItem(mp.getMasaKerjaGolongan());
        
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}
