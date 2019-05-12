/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.view;

import com.penggajian.entity.MasterPegawai;
import com.penggajian.entity.TabelGapokCapegPegawai;
import com.penggajian.entity.TransaksiPenggajianPegawai;
import com.penggajian.entity.TunjanganFungsional;
import com.penggajian.entity.TunjanganKeluarga;
import com.penggajian.entity.TunjanganPangan;
import com.penggajian.main.DialogView;
import com.penggajian.main.MainView;
import com.penggajian.main.SpringManager;
import com.penggajian.service.MasterService;
import com.penggajian.util.TextComponentUtils;
import java.awt.Window;
import java.math.BigDecimal;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Windows
 */
public class UbahTransaksiPenggajianDialog extends DialogView {

    /**
     * Creates new form TambahTransaksiPenggajianDialog
     * @param mainView
     */
    private TransaksiPenggajianPegawai tpp;
    private MasterPegawai mpg;
    private BigDecimal jumlahTunjangan = BigDecimal.ZERO;
    
    public UbahTransaksiPenggajianDialog(MainView mainView) {
        super(mainView);
        initComponents();
    }

    private BigDecimal hitungGajiPokok(String statusKep, String gol, String subGol, String masaKerjaGolongan){           
        BigDecimal gapok = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TabelGapokCapegPegawai tbl : masterService.getAllGapokCapegPegawai()) {
            String statusCP = tbl.getStatusKepegawaian().substring(0, 18);
            String statusPT = tbl.getStatusKepegawaian().substring(19);
            //System.out.println("--- "+tbl.getMasaKerjaGolongan().substring(4).trim());
            //System.out.println("+++ "+tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim());
            if ( statusKep.equals(statusPT) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim())) {
                gapok = tbl.getJumlah();
                //System.out.println(statusKep+" == Pegawai Tetap : "+statusPT+" = "+gapok);
                System.out.println("1- "+tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim());
            } else if ( statusKep.equals(statusPT) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(4).trim())) {
                gapok = tbl.getJumlah();
                //System.out.println(statusKep+" == Pegawai Tetap : "+statusPT+" = "+gapok);
                System.out.println("2- "+tbl.getMasaKerjaGolongan().substring(4).trim());
            } else if(statusKep.equals(statusCP) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim())) {
                gapok = tbl.getJumlah();
                //System.out.println(statusKep +" == Calon Pegawai : "+statusCP+" = "+gapok);
                System.out.println("-3 "+tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim());
            } else if(statusKep.equals(statusCP) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(4).trim())) {
                gapok = tbl.getJumlah();
                //System.out.println(statusKep +" == Calon Pegawai : "+statusCP+" = "+gapok);
                System.out.println("-4 "+tbl.getMasaKerjaGolongan().substring(4).trim());
            } else if(statusKep.equals("Honor Lepas (HL)") || statusKep.equals("Honor Masa Percobaan (HMP)") 
                    || statusKep.equals("Honor Sementara (HS)")){
                gapok = BigDecimal.ZERO;
            }
        }
        return gapok;
    }
    
    private BigDecimal hitungTunjanganKeluarga(String statusKep, String statusSipil, BigDecimal gapok){           
        BigDecimal tunjangan = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TunjanganKeluarga tk : masterService.getAllTunjanganKeluarga()) {
            if (statusKep.equals("Honor Lepas (HL)") || statusKep.equals("Honor Masa Percobaan (HMP)") 
                    || statusKep.equals("Honor Sementara (HS)") || statusSipil.equals("Tidak Kawin (TK)")) {
                tunjangan = BigDecimal.ZERO;
            } else if (statusSipil.equals("Kawin (K/0)")) {
                tunjangan = (gapok.multiply(BigDecimal.valueOf(tk.getIstri()))).divide(BigDecimal.valueOf(100));
            } else if (statusSipil.equals("Kawin 1 Anak (K/1)")) {
                tunjangan = (gapok.multiply(BigDecimal.valueOf(tk.getIstri()).add(BigDecimal.valueOf(tk.getAnak())))).divide(BigDecimal.valueOf(100));
            } else if (statusSipil.equals("Kawin 2 Anak (K/2)")) {
                tunjangan = (gapok.multiply(BigDecimal.valueOf(tk.getIstri()).add(BigDecimal.valueOf(tk.getAnak()).add(BigDecimal.valueOf(tk.getAnak()))))).divide(BigDecimal.valueOf(100));
            } else if (statusSipil.equals("Kawin 3 Anak (K/3)")) {
                tunjangan = (gapok.multiply(BigDecimal.valueOf(tk.getIstri()).add(BigDecimal.valueOf(tk.getAnak()).add(BigDecimal.valueOf(tk.getAnak()).add(BigDecimal.valueOf(tk.getAnak())))))).divide(BigDecimal.valueOf(100));
            }
        }
        return tunjangan;
    }
    
    private BigDecimal hitungTunjanganPangan(String statusKep, String statusSipil){           
        BigDecimal tunjangan = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TunjanganPangan tp : masterService.getAllTunjanganPangan()) {
            if (statusKep.equals("Honor Lepas (HL)") || statusKep.equals("Honor Masa Percobaan (HMP)") 
                    || statusKep.equals("Honor Sementara (HS)")) {
                tunjangan = BigDecimal.ZERO;
            } else if (statusSipil.equals("Tidak Kawin (TK)")) {
                tunjangan = (BigDecimal.valueOf(tp.getJumlahTunjangan())).multiply(BigDecimal.ONE);
            } else if (statusSipil.equals("Kawin (K/0)")) {
                tunjangan = (BigDecimal.valueOf(tp.getJumlahTunjangan())).multiply(BigDecimal.valueOf(2));
            } else if (statusSipil.equals("Kawin 1 Anak (K/1)")) {
                tunjangan = (BigDecimal.valueOf(tp.getJumlahTunjangan())).multiply(BigDecimal.valueOf(3));
            } else if (statusSipil.equals("Kawin 2 Anak (K/2)")) {
                tunjangan = (BigDecimal.valueOf(tp.getJumlahTunjangan())).multiply(BigDecimal.valueOf(4));
            } else if (statusSipil.equals("Kawin 3 Anak (K/3)")) {
                tunjangan = (BigDecimal.valueOf(tp.getJumlahTunjangan())).multiply(BigDecimal.valueOf(5));
            }
        }
        return tunjangan;
    }
    
    private BigDecimal hitungTunjanganFungsional(String statusKep, String jabatanPegawai, String golPegawa){           
        BigDecimal tunjangan = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TunjanganFungsional tf : masterService.getAllTunjanganFungsional()) {
            if (statusKep.equals("Honor Lepas (HL)") || statusKep.equals("Honor Masa Percobaan (HMP)") 
                    || statusKep.equals("Honor Sementara (HS)")) {
                tunjangan = BigDecimal.ZERO;
            } else if (jabatanPegawai.equals(tf.getJabatan()) && golPegawa.equals(tf.getGolongan())) {
                tunjangan = tf.getJumlahTunjangan();
            } else if (!golPegawa.equals(tf.getGolongan())) {
                tunjangan = BigDecimal.ZERO;
            }
            
        }
        return tunjangan;
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
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtGajiPokok = new javax.swing.JTextField();
        txtNIP = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        txtStatusSipil = new javax.swing.JTextField();
        txtStatusKepegawaian = new javax.swing.JTextField();
        txtGolongan = new javax.swing.JTextField();
        txtMasaKerja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtJumlahHonor = new javax.swing.JTextField();
        txtTunjanganKeluarga = new javax.swing.JTextField();
        txtTunjanganJabatan = new javax.swing.JTextField();
        txtTunjanganFungsional = new javax.swing.JTextField();
        txtTunjanganPangan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaksi Penggajian");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UBAH TRANSAKSI PENGGAJIAN PEGAWAI");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("NIP");

        jLabel11.setText("Nama");

        jLabel12.setText("Status Sipil");

        jLabel13.setText("Status Kepegawaian");

        jLabel14.setText("Golongan");

        jLabel15.setText("Gaji Pokok");

        jLabel16.setText("Honor");

        txtNama.setEditable(false);

        jLabel18.setText("Masa Kerja Gol.");

        txtGajiPokok.setEditable(false);
        txtGajiPokok.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGajiPokok.setText("0");

        txtNIP.setEnabled(false);

        btnCari.setText("...");
        btnCari.setEnabled(false);
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        txtStatusSipil.setEditable(false);

        txtStatusKepegawaian.setEditable(false);

        txtGolongan.setEditable(false);

        txtMasaKerja.setEditable(false);

        jLabel2.setText("Tahun");

        txtJumlahHonor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtJumlahHonor.setText("0");

        txtTunjanganKeluarga.setEditable(false);
        txtTunjanganKeluarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganKeluarga.setText("0");

        txtTunjanganJabatan.setEditable(false);
        txtTunjanganJabatan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganJabatan.setText("0");

        txtTunjanganFungsional.setEditable(false);
        txtTunjanganFungsional.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganFungsional.setText("0");

        txtTunjanganPangan.setEditable(false);
        txtTunjanganPangan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganPangan.setText("0");

        jLabel3.setText("Tunjangan Keluarga");

        jLabel5.setText("Tunjangan Jabatan");

        jLabel6.setText("Tunjangan Fungsional");

        jLabel7.setText("Tunjangan Pangan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatusSipil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtGolongan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMasaKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtStatusKepegawaian, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtJumlahHonor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtGajiPokok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTunjanganPangan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(txtTunjanganFungsional, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTunjanganJabatan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTunjanganKeluarga, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtStatusSipil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtStatusKepegawaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(txtGolongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMasaKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTunjanganKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTunjanganJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTunjanganFungsional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTunjanganPangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtJumlahHonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction
        // TODO add your handling code here:
        Object source = evt.getSource();
        BigDecimal gapok, tunjanganFungsional;
        BigDecimal tunjanganKel = null, tunjanganPangan;
        if (source == btnSimpan) {
            tpp.setMp(tpp.getMp());
//            tpp.setNamaPeg(tpp.getNamaPeg());
            tpp.setGapok(BigDecimal.valueOf(Long.valueOf(txtGajiPokok.getText().replace(".", "").trim())));
            tpp.setTunjanganKeluarga(BigDecimal.valueOf(Long.valueOf(txtTunjanganKeluarga.getText().replace(".", "").trim())));
            tpp.setTunjanganJabatan(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())));
            tpp.setTunjanganFungsional(BigDecimal.valueOf(Long.valueOf(txtTunjanganFungsional.getText().replace(".", "").trim())));
            tpp.setTunjanganPangan(BigDecimal.valueOf(Long.valueOf(txtTunjanganPangan.getText().replace(".", "").trim())));
            tpp.setTunjanganHonor(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim())));
            tpp.setJumlahTunjangan(jumlahTunjangan);
            System.out.println(jumlahTunjangan);
            
            MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
            
            try {
                //validator.validate(mp);
                masterService.update(tpp);
                dispose();
            } catch (DataAccessException e) {
                showError(e.getRootCause().getMessage());
            //} catch (ValidatorException ex) {
                //showWarning(ex.getMessage());
            }
            
        } else if(source == btnCari) {
        
            CariPegawaiView cariPegawai = new CariPegawaiView(getMainView());
            mpg = cariPegawai.search(this);
            if (mpg != null) {
                txtNIP.setText(mpg.getNip());
                txtNama.setText(mpg.getNama());
                txtStatusSipil.setText(mpg.getStatusSipil());
                txtStatusKepegawaian.setText(mpg.getStatusKepegawaian());
                txtGolongan.setText(mpg.getGolongan() +""+mpg.getSubGolongan());
                txtMasaKerja.setText(mpg.getMasaKerjaGolongan());
                
                gapok = hitungGajiPokok(mpg.getStatusKepegawaian(), mpg.getGolongan(), mpg.getSubGolongan(), mpg.getMasaKerjaGolongan());
                txtGajiPokok.setText(TextComponentUtils.formatNumber(String.valueOf(gapok)));
                
                if (gapok==BigDecimal.ZERO) {
                    txtTunjanganKeluarga.setText("0");
                    txtGajiPokok.setText("0");
                } else {
                    tunjanganKel = hitungTunjanganKeluarga(mpg.getStatusKepegawaian(), mpg.getStatusSipil(),gapok);
                    txtTunjanganKeluarga.setText(TextComponentUtils.formatNumber(tunjanganKel));
                }
                
                tunjanganPangan = hitungTunjanganPangan(mpg.getStatusKepegawaian(), mpg.getStatusSipil());
                txtTunjanganPangan.setText(TextComponentUtils.formatNumber(tunjanganPangan));
                
                tunjanganFungsional = hitungTunjanganFungsional(mpg.getStatusKepegawaian(), mpg.getJabatan(), mpg.getGolongan());
                txtTunjanganFungsional.setText(TextComponentUtils.formatNumber(String.valueOf(tunjanganFungsional)));
                
                jumlahTunjangan = tunjanganKel.add(tunjanganFungsional).add(tunjanganPangan)
                        .add(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().trim())))
                        .add(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().trim())));
                //System.out.println(jumlahTunjangan);
            }
        } else if(source == btnBatal) {
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
            java.util.logging.Logger.getLogger(TambahTransaksiPenggajianDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiPenggajianDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiPenggajianDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiPenggajianDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TambahTransaksiPenggajianDialog dialog = new TambahTransaksiPenggajianDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtGajiPokok;
    private javax.swing.JTextField txtGolongan;
    private javax.swing.JTextField txtJumlahHonor;
    private javax.swing.JTextField txtMasaKerja;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStatusKepegawaian;
    private javax.swing.JTextField txtStatusSipil;
    private javax.swing.JTextField txtTunjanganFungsional;
    private javax.swing.JTextField txtTunjanganJabatan;
    private javax.swing.JTextField txtTunjanganKeluarga;
    private javax.swing.JTextField txtTunjanganPangan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void display(Window formApp, Object parameter) {
        tpp = (TransaksiPenggajianPegawai) parameter;

        txtNIP.setText(tpp.getMp().getNip());
        txtNama.setText(tpp.getMp().getNama());
        txtStatusSipil.setText(tpp.getMp().getStatusSipil());
        txtStatusKepegawaian.setText(tpp.getMp().getStatusKepegawaian());
        txtGolongan.setText(tpp.getMp().getGolongan()+""+tpp.getMp().getSubGolongan());
        txtMasaKerja.setText(tpp.getMp().getMasaKerjaGolongan());
        txtGajiPokok.setText(TextComponentUtils.formatNumber(String.valueOf(tpp.getGapok())));
        txtTunjanganKeluarga.setText(TextComponentUtils.formatNumber(String.valueOf(tpp.getTunjanganKeluarga())));
        txtTunjanganJabatan.setText(TextComponentUtils.formatNumber(String.valueOf(tpp.getTunjanganJabatan())));
        txtTunjanganFungsional.setText(TextComponentUtils.formatNumber(String.valueOf(tpp.getTunjanganFungsional())));
        txtTunjanganPangan.setText(TextComponentUtils.formatNumber(String.valueOf(tpp.getTunjanganPangan())));
        txtJumlahHonor.setText(TextComponentUtils.formatNumber(String.valueOf(tpp.getTunjanganHonor())));
        
        TextComponentUtils.setCurrency(txtJumlahHonor);
        
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}
