/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.view;

import com.penggajian.entity.DetailPerincianHonor;
import com.penggajian.entity.MasterPegawai;
import com.penggajian.entity.PokokHonor;
import com.penggajian.entity.TabelGapokCapegPegawai;
import com.penggajian.entity.TabelTunjanganJabatan;
import com.penggajian.entity.TransaksiPenggajianPegawai;
import com.penggajian.entity.TunjanganFungsional;
import com.penggajian.entity.TunjanganKeluarga;
import com.penggajian.entity.TunjanganPangan;
import com.penggajian.entity.TunjanganYayasan;
import com.penggajian.main.DialogView;
import com.penggajian.main.MainView;
import com.penggajian.main.SpringManager;
import com.penggajian.service.MasterService;
import com.penggajian.util.TextComponentUtils;
import com.stripbandunk.jglasspane.component.MessageComponent;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Window;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Windows
 */
public class TambahTransaksiPenggajianDialog extends DialogView {

    /**
     * Creates new form TambahTransaksiPenggajianDialog
     * @param mainView
     */
    //private DaftarTransaksiPenggajianPerUnitKerjaView1 view;
    private TransaksiPenggajianPegawai tpp;
    private DetailPerincianHonor dph;
    private MasterPegawai mpg;
    private static BigDecimal jumlahTunjangan = BigDecimal.ZERO, tunjanganKel = BigDecimal.ZERO, 
            tunjanganPangan, gapok, tunjanganFungsional, tunjanganJabatan, 
            penghasilanBruto, penguranganSiswa, penguranganJabatan, PTKP, PKP, pokokHonor;
    private static BigDecimal bidang, staf, satpam, kebersihan;
    
    private JDynamicTable dynamicTable;
    private DynamicTableModel<DetailPerincianHonor> dynamicTableModel;
    private MessageComponent messageComponent;
    
    public TambahTransaksiPenggajianDialog(MainView mainView) {
        super(mainView);
        initComponents();
        dynamicTableModel = new DynamicTableModel<>(DetailPerincianHonor.class);
        dynamicTable = new JDynamicTable(dynamicTableModel);
        jScrollPane2.setViewportView(dynamicTable);
    }

    public static BigDecimal getBidang() {
        return bidang;
    }

    public static void setBidang(BigDecimal bidang) {
        TambahTransaksiPenggajianDialog.bidang = bidang;
    }

    public static BigDecimal getStaf() {
        return staf;
    }

    public static void setStaf(BigDecimal staf) {
        TambahTransaksiPenggajianDialog.staf = staf;
    }

    public static BigDecimal getSatpam() {
        return satpam;
    }

    public static void setSatpam(BigDecimal satpam) {
        TambahTransaksiPenggajianDialog.satpam = satpam;
    }

    public static BigDecimal getKebersihan() {
        return kebersihan;
    }

    public static void setKebersihan(BigDecimal kebersihan) {
        TambahTransaksiPenggajianDialog.kebersihan = kebersihan;
    }
    
    private void refreshTable(){
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        dynamicTableModel.clear();
        for (DetailPerincianHonor dph : masterService.getAllDetailPerincianHonor()) {
            dynamicTableModel.add(dph);
        }
    }
    
    public TransaksiPenggajianPegawai search(Window formApp) {
        display(formApp, null);
        return tpp;
    }
    public DetailPerincianHonor searchDPH(Window formApp) {
        display(formApp, null);
        return dph;
    }
    
    private BigDecimal hitungPokokHonor(String statusKepeg, String subStatusKepeg, String pendidikan){           
        BigDecimal pHonor = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (PokokHonor ph : masterService.getAllPokokHonor()) {
            /*if (statusKepeg.equals(ph.getStatusKepegawaian()) && !subStatusKepeg.equals(ph.getSubStatusKepegawaian()) && pendidikan.equals(ph.getPendidikan())) {
                pHonor = ph.getJumlah();
                System.out.println(":1 "+pHonor);
                //btnSetupRincianHonor.setEnabled(false);
            } else*/ if (statusKepeg.equals(ph.getStatusKepegawaian()) && subStatusKepeg.equals(ph.getSubStatusKepegawaian()) && pendidikan.equals(ph.getPendidikan())) {
                pHonor = ph.getJumlah();
                System.out.println(":2 "+pHonor);
                //btnSetupRincianHonor.setEnabled(false);
            } else {
                btnSetupRincianHonor.setEnabled(true);
            }
        }
        //System.out.println("Tess PH: "+pokokHonor);
        return pHonor;
    }

    private BigDecimal hitungGajiPokok(String statusKep, String gol, String subGol, String masaKerjaGolongan){           
        BigDecimal gapokPeg = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TabelGapokCapegPegawai tbl : masterService.getAllGapokCapegPegawai()) {
            String statusCP = tbl.getStatusKepegawaian().substring(0, 18);
            String statusPT = tbl.getStatusKepegawaian().substring(19);
            //System.out.println("--- "+tbl.getMasaKerjaGolongan().substring(4).trim());
            //System.out.println("+++ "+tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim());
            if ( statusKep.equals(statusPT) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim())) {
                gapokPeg = tbl.getJumlah();
                //System.out.println(statusKep+" == Pegawai Tetap : "+statusPT+" = "+gapok);
                //System.out.println("1- "+tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim());
            } else if ( statusKep.equals(statusPT) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(2).replace("-", "").trim())) {
                gapokPeg = tbl.getJumlah();
                //System.out.println(statusKep+" == Pegawai Tetap : "+statusPT+" = "+gapok);
                //System.out.println("2- "+tbl.getMasaKerjaGolongan().substring(4).trim());
            } else if(statusKep.equals(statusCP) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim())) {
                gapokPeg = tbl.getJumlah();
                //System.out.println(statusKep +" == Calon Pegawai : "+statusCP+" = "+gapok);
                //System.out.println("-3 "+tbl.getMasaKerjaGolongan().substring(0, 2).replace("-", "").trim());
            } else if(statusKep.equals(statusCP) && gol.equals(tbl.getGolongan()) 
                    && subGol.equals(tbl.getSubGolongan()) 
                    && masaKerjaGolongan.equals(tbl.getMasaKerjaGolongan().substring(2).replace("-", "").trim())) {
                gapokPeg = tbl.getJumlah();
                //System.out.println(statusKep +" == Calon Pegawai : "+statusCP+" = "+gapok);
                //System.out.println("-4 "+tbl.getMasaKerjaGolongan().substring(4).trim());
            } else if(statusKep.equals("Honor Lepas (HL)") || statusKep.equals("Honor Masa Percobaan (HMP)") 
                    || statusKep.equals("Honor Sementara (HS)")){
                gapokPeg = BigDecimal.ZERO;
            }
        }
        return gapokPeg;
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
            }/* else if (!golPegawa.equals(tf.getGolongan()) || !jabatanPegawai.equals(tf.getJabatan())) {
                tunjangan = BigDecimal.ZERO;
            }*/
            
        }
        return tunjangan;
    }
    
    private BigDecimal hitungTunjanganJabatan(String jabatanPegawai, String golPegawa, String jumlahRombel){           
        BigDecimal tunjangan = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TabelTunjanganJabatan tj : masterService.getAllTunjanganJabatan()) {
            if (jabatanPegawai.equals(tj.getJabatan()) && golPegawa.equals(tj.getGolongan()) && jumlahRombel.equals(tj.getJumlahRombengan())) {
                tunjangan = tj.getJumlahTunjangan();
                System.out.println("= "+tunjangan);
            }else if (jabatanPegawai.equals(tj.getJabatan()) && golPegawa.equals(tj.getGolongan()) && jumlahRombel.equals(tj.getJumlahRombengan())) {
                tunjangan = tj.getJumlahTunjangan();
                System.out.println("= "+tunjangan);
            }
        }
        //System.out.println("Tess  "+tunjangan);
        return tunjangan;
    }
    
    private BigDecimal hitungTunjanganFungsionalYayasan(String statusKep, String jabatanPegawai, String golPegawa, String jenisTunjangan){           
        BigDecimal tunjangan = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TunjanganYayasan tf : masterService.getAllTunjanganYayasan()) {
            if (statusKep.equals("Honor Lepas (HL)") || statusKep.equals("Honor Masa Percobaan (HMP)") 
                    || statusKep.equals("Honor Sementara (HS)")) {
                tunjangan = BigDecimal.ZERO;
            } else if (jabatanPegawai.equals(tf.getJabatan()) && golPegawa.equals(tf.getGolongan()) && jenisTunjangan.equals(tf.getJenisTunjangan())) {
                tunjangan = tf.getBesarTunjangan();
            }/* else if (!golPegawa.equals(tf.getGolongan()) || !jabatanPegawai.equals(tf.getJabatan())) {
                tunjangan = BigDecimal.ZERO;
            }*/
            
        }
        return tunjangan;
    }
    
    private BigDecimal hitungTunjanganJabatanYayasan(String jabatanPegawai, String golPegawa, String jenisTunjangan){           
        BigDecimal tunjangan = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TunjanganYayasan ty : masterService.getAllTunjanganYayasan()) {
            if (jabatanPegawai.equals(ty.getJabatan()) && golPegawa.equals(ty.getGolongan()) && jenisTunjangan.equals(ty.getJenisTunjangan())) {
                tunjangan = ty.getBesarTunjangan();
                System.out.println("= "+tunjangan);
            }else if (jabatanPegawai.equals(ty.getJabatan()) && golPegawa.equals(ty.getGolongan()) && jenisTunjangan.equals(ty.getJenisTunjangan())) {
                tunjangan = ty.getBesarTunjangan();
                System.out.println("= "+tunjangan);
            }
        }
        //System.out.println("Tess  "+tunjangan);
        return tunjangan;
    }
    
    private BigDecimal hitungRincianHonorYayasan(String jabatanPegawai, String golPegawa, String jenisTunjangan){           
        BigDecimal tunjangan = BigDecimal.ZERO;
        
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        for (TunjanganYayasan ty : masterService.getAllTunjanganYayasan()) {
            if (jabatanPegawai.equals(ty.getJabatan()) && golPegawa.equals(ty.getGolongan()) && jenisTunjangan.equals(ty.getJenisTunjangan())) {
                tunjangan = ty.getBesarTunjangan();
                //System.out.println("= "+tunjangan);
            }
        }
        //System.out.println("Tess  "+tunjangan);
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
        txtNama = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        txtStatusSipil = new javax.swing.JTextField();
        txtStatusKepegawaian = new javax.swing.JTextField();
        txtGolongan = new javax.swing.JTextField();
        txtMKG = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tanggalGaji = new com.toedter.calendar.JDateChooser();
        btnTambah = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtGajiPokok = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTunjanganKeluarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTunjanganJabatan = new javax.swing.JTextField();
        txtTunjanganFungsional = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTunjanganPangan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtJumlahHonor = new javax.swing.JTextField();
        btnSetupRincianHonor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Transaksi");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("TAMBAH TRANSAKSI");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pegawai"));

        jLabel10.setText("NIP");

        jLabel11.setText("Nama");

        jLabel12.setText("Status Sipil");

        jLabel13.setText("Status Kepegawaian");

        jLabel14.setText("Golongan");

        txtNama.setEditable(false);

        jLabel18.setText("Masa Kerja Gol.");

        btnCari.setText("...");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        txtStatusSipil.setEditable(false);

        txtStatusKepegawaian.setEditable(false);

        txtGolongan.setEditable(false);

        txtMKG.setEditable(false);

        jLabel2.setText("Tahun");

        jLabel9.setText("Tanggal Penggajian");

        tanggalGaji.setToolTipText("");
        tanggalGaji.setDate(new Date());
        tanggalGaji.setDateFormatString("dd MMMM yyyy");

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
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatusSipil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtStatusKepegawaian, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtGolongan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMKG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggalGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtMKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTambah.setText("Tambahkan Transaksi");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Transaksi"));

        jLabel15.setText("Gaji Pokok");

        txtGajiPokok.setEditable(false);
        txtGajiPokok.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGajiPokok.setText("0");

        jLabel3.setText("Tunjangan Keluarga");

        txtTunjanganKeluarga.setEditable(false);
        txtTunjanganKeluarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganKeluarga.setText("0");

        jLabel5.setText("Tunjangan Jabatan");

        txtTunjanganJabatan.setEditable(false);
        txtTunjanganJabatan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganJabatan.setText("0");

        txtTunjanganFungsional.setEditable(false);
        txtTunjanganFungsional.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganFungsional.setText("0");

        jLabel6.setText("Tunjangan Fungsional");

        jLabel7.setText("Tunjangan Pangan");

        txtTunjanganPangan.setEditable(false);
        txtTunjanganPangan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTunjanganPangan.setText("0");

        jLabel16.setText("Honor");

        txtJumlahHonor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtJumlahHonor.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtJumlahHonor)
                    .addComponent(txtGajiPokok)
                    .addComponent(txtTunjanganPangan)
                    .addComponent(txtTunjanganFungsional)
                    .addComponent(txtTunjanganJabatan)
                    .addComponent(txtTunjanganKeluarga, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTunjanganKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTunjanganJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTunjanganFungsional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTunjanganPangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlahHonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSetupRincianHonor.setText("Setup Rincian Honor");
        btnSetupRincianHonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(149, 149, 149))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSetupRincianHonor)
                                .addGap(65, 65, 65)
                                .addComponent(btnTambah)
                                .addGap(10, 10, 10)
                                .addComponent(btnBatal)
                                .addContainerGap())))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBatal, btnSetupRincianHonor, btnTambah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnSetupRincianHonor)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction
        // TODO add your handling code here:
        Object source = evt.getSource();
        //BigDecimal gapok, tunjanganFungsional, tunjanganJabatan;
        //BigDecimal tunjanganKel = BigDecimal.ZERO, tunjanganPangan;
        if (source == btnTambah) {
            if (btnSetupRincianHonor.isEnabled()==true) {
                showWarning("Setup Honor Dulu");
                btnSetupRincianHonor.requestFocus();
            } else if ("".equals(txtNIP.getText())) {
                showWarning("NIP masih kosong");
            } else {
                jumlahTunjangan = (tunjanganKel.add(tunjanganFungsional).add(tunjanganPangan)
                        .add(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())))
                        .add(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim()))));

                if (mpg.getStatusKepegawaian().equals("Pegawai Tetap (PT)")) {
                        penguranganSiswa = gapok.add(tunjanganKel).multiply(BigDecimal.valueOf(0.1));
                        System.out.println("Siswa : "+penguranganSiswa);
                } else if(mpg.getStatusKepegawaian().equals("Calon Pegawai (CP)")){
                    penguranganSiswa = gapok.add(tunjanganKel).multiply(BigDecimal.valueOf(0.03));
                    System.out.println("Siswa : "+penguranganSiswa);
                } else {
                    penguranganSiswa = BigDecimal.ZERO;
                }

                if (mpg.getStatusSipil().equals("Tidak Kawin (TK)")) {
                    PTKP = BigDecimal.valueOf(3000000);
                } else if (mpg.getStatusSipil().equals("Kawin (K/0)")) {
                    PTKP = BigDecimal.valueOf(3250000);
                } else if (mpg.getStatusSipil().equals("Kawin 1 Anak (K/1)")) {
                    PTKP = BigDecimal.valueOf(3500000);
                } else if (mpg.getStatusSipil().equals("Kawin 2 Anak (K/2)")) {
                    PTKP = BigDecimal.valueOf(3750000);
                } else if (mpg.getStatusSipil().equals("Kawin 3 Anak (K/3)")) {
                    PTKP = BigDecimal.valueOf(4000000);
                } else {
                    PTKP = BigDecimal.ZERO;
                }

                if (penghasilanBruto.subtract(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganSiswa).replace(".", "").trim()))
                    .add(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganJabatan).replace(".", "").trim())))).compareTo(PTKP) > 0) {
                    PKP = (penghasilanBruto.subtract(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganSiswa).replace(".", "").trim()))
                    .add(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganJabatan).replace(".", "").trim()))))).subtract(PTKP);
                } else {
                    PKP = BigDecimal.ZERO;
                }

                tpp = new TransaksiPenggajianPegawai();
                tpp.setMp(mpg);
//                tpp.setNamaPeg(mpg.getNama());
                tpp.setGapok(BigDecimal.valueOf(Long.valueOf(txtGajiPokok.getText().replace(".", "").trim())));
                tpp.setTunjanganKeluarga(BigDecimal.valueOf(Long.valueOf(txtTunjanganKeluarga.getText().replace(".", "").trim())));
                tpp.setTunjanganJabatan(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())));
                tpp.setTunjanganFungsional(BigDecimal.valueOf(Long.valueOf(txtTunjanganFungsional.getText().replace(".", "").trim())));
                tpp.setTunjanganPangan(BigDecimal.valueOf(Long.valueOf(txtTunjanganPangan.getText().replace(".", "").trim())));
                tpp.setTunjanganHonor(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim())));
                tpp.setJumlahTunjangan(jumlahTunjangan);
                tpp.setPenghasilanBruto(jumlahTunjangan.add(gapok));
                System.out.println("Brotoo"+jumlahTunjangan.add(gapok));

                if (jumlahTunjangan.add(gapok).compareTo(BigDecimal.valueOf(6000000)) < 0) {
                    System.out.println("jumlah "+jumlahTunjangan);
                    penguranganJabatan = (jumlahTunjangan.add(gapok)).multiply(BigDecimal.valueOf(0.05));
                    System.out.println("Jabatan : "+penguranganJabatan);
                } else {
                    penguranganJabatan = BigDecimal.valueOf(500000);
                }

                tpp.setPenguranganSiswa(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganSiswa).replace(".", "").trim())));
                tpp.setPenguranganJabatan(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganJabatan).replace(".", "").trim())));
                tpp.setJumlahPengurangan(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganSiswa).replace(".", "").trim()))
                        .add(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganJabatan).replace(".", "").trim()))));
                tpp.setPenghasilanNeto((jumlahTunjangan.add(gapok)).subtract(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganSiswa).replace(".", "").trim()))
                        .add(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganJabatan).replace(".", "").trim())))));
                tpp.setPTKP(PTKP);
                tpp.setPKP(PKP);
                tpp.setPPhPsl21(PKP.multiply(BigDecimal.valueOf(0.05)));
                tpp.setJumlahPotongan(penguranganSiswa.add(PKP.multiply(BigDecimal.valueOf(0.05))));
                tpp.setTerima((jumlahTunjangan.add(gapok)).subtract(penguranganSiswa.add(PKP.multiply(BigDecimal.valueOf(0.05)))));
                tpp.setBulan(tanggalGaji.getDate());
                dispose();
                //System.out.println("PKP : "+PKP);

                MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);

                try {
                    //validator.validate(mp);
                    for (int i = 0; i < dynamicTableModel.getRowCount(); i++) {
                        DetailPerincianHonor detailPenjualan = dynamicTableModel.get(i);
                        tpp.tambahDaftarTransaksiPenggajian(detailPenjualan);
                    }
                    masterService.save(tpp);
                    dispose();
                } catch (DataAccessException e) {
                    showError(e.getRootCause().getMessage());
                //} catch (ValidatorException ex) {
                    //showWarning(ex.getMessage());
                }
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
                txtMKG.setText(mpg.getMasaKerjaGolongan());
                
                pokokHonor = hitungPokokHonor(mpg.getStatusKepegawaian(), mpg.getSubstatusKepegawaian(), mpg.getPendidikan());
                txtJumlahHonor.setText(TextComponentUtils.formatNumber(String.valueOf(pokokHonor)));
                
                gapok = hitungGajiPokok(mpg.getStatusKepegawaian(), mpg.getGolongan(), mpg.getSubGolongan(), mpg.getMasaKerjaGolongan());
                txtGajiPokok.setText(TextComponentUtils.formatNumber(String.valueOf(gapok)));
                
                if (gapok==BigDecimal.ZERO) {
                    txtTunjanganKeluarga.setText("0");
                    txtGajiPokok.setText("0");
                } else {
                    tunjanganKel = hitungTunjanganKeluarga(mpg.getStatusKepegawaian(), mpg.getStatusSipil(),gapok);
                    txtTunjanganKeluarga.setText(TextComponentUtils.formatNumber(String.valueOf(tunjanganKel)));
                }
                
                tunjanganPangan = hitungTunjanganPangan(mpg.getStatusKepegawaian(), mpg.getStatusSipil());
                txtTunjanganPangan.setText(TextComponentUtils.formatNumber(tunjanganPangan));
                
                tunjanganFungsional = hitungTunjanganFungsionalYayasan(mpg.getStatusKepegawaian(), mpg.getJabatan(), mpg.getGolongan(), "Fungsional");
                txtTunjanganFungsional.setText(TextComponentUtils.formatNumber(String.valueOf(tunjanganFungsional)));
                
                jumlahTunjangan = (tunjanganKel.add(tunjanganFungsional).add(tunjanganPangan)
                        .add(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())))
                        .add(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim()))));
                System.out.println(tunjanganKel);
                System.out.println(tunjanganFungsional);
                System.out.println(tunjanganPangan);
                System.out.println(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())));
                System.out.println(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim())));
                
                penghasilanBruto = jumlahTunjangan.add(gapok);
                System.out.println("Bruto : "+penghasilanBruto);
                
                if (mpg.getStatusKepegawaian().equals("Pegawai Tetap (PT)")) {
                    penguranganSiswa = gapok.add(tunjanganKel).multiply(BigDecimal.valueOf(0.1));
                    System.out.println("Siswa : "+penguranganSiswa);
                } else if(mpg.getStatusKepegawaian().equals("Calon Pegawai (CP)")){
                    penguranganSiswa = gapok.add(tunjanganKel).multiply(BigDecimal.valueOf(0.03));
                    System.out.println("Siswa : "+penguranganSiswa);
                } else {
                    penguranganSiswa = BigDecimal.ZERO;
                }
                
                if (penghasilanBruto.compareTo(BigDecimal.valueOf(6000000)) <= 0) {
                    penguranganJabatan = penghasilanBruto.multiply(BigDecimal.valueOf(0.05));
                    System.out.println("Jabatan : "+penguranganJabatan);
                } else {
                    penguranganJabatan = BigDecimal.valueOf(500000);
                }
                
                if (mpg.getStatusSipil().equals("Tidak Kawin (TK)")) {
                    PTKP = BigDecimal.valueOf(3000000);
                } else if (mpg.getStatusSipil().equals("Kawin (K/0)")) {
                    PTKP = BigDecimal.valueOf(3250000);
                } else if (mpg.getStatusSipil().equals("Kawin 1 Anak (K/1)")) {
                    PTKP = BigDecimal.valueOf(3500000);
                } else if (mpg.getStatusSipil().equals("Kawin 2 Anak (K/2)")) {
                    PTKP = BigDecimal.valueOf(3750000);
                } else if (mpg.getStatusSipil().equals("Kawin 3 Anak (K/3)")) {
                    PTKP = BigDecimal.valueOf(4000000);
                } else {
                    PTKP = BigDecimal.ZERO;
                }
                
                if (penghasilanBruto.subtract(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganSiswa).replace(".", "").trim()))
                    .add(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganJabatan).replace(".", "").trim())))).compareTo(PTKP) > 0) {
                    PKP = (penghasilanBruto.subtract(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganSiswa).replace(".", "").trim()))
                    .add(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(penguranganJabatan).replace(".", "").trim()))))).subtract(PTKP);
                } else {
                    PKP = BigDecimal.ZERO;
                }
                
                if (mpg.getJabatan().equals("Kepala Bidang")) {
                    setBidang(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(hitungRincianHonorYayasan(mpg.getJabatan(), mpg.getGolongan(), "Khusus")).replace(".", "").trim())));
                    System.out.println("Bidang : "+getBidang());
                }
                if (mpg.getJabatan().equals("Staf")){
                    setStaf(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(hitungRincianHonorYayasan(mpg.getJabatan(), mpg.getGolongan(), "Khusus")).replace(".", "").trim())));
                    System.out.println("Staf : "+getStaf());
                }
                if (mpg.getJabatan().equals("Satpam")) {
                    setSatpam(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(hitungRincianHonorYayasan(mpg.getJabatan(), mpg.getGolongan(), "Khusus")).replace(".", "").trim())));
                    System.out.println("Satpam : "+getSatpam());
                }
                if (mpg.getJabatan().equals("Pegawai Kebersihan")) {
                    setKebersihan(BigDecimal.valueOf(Long.valueOf(TextComponentUtils.formatNumber(hitungRincianHonorYayasan(mpg.getJabatan(), mpg.getGolongan(), "Khusus")).replace(".", "").trim())));
                    System.out.println("Kebersihan : "+getKebersihan());
                }
            
                //tunjanganJabatan = hitungTunjanganJabatanYayasan(mpg.getJabatan(), mpg.getGolongan(),"Jabatan");
                /*jumlahTunjangan = tunjanganKel.add(tunjanganFungsional).add(tunjanganPangan)
                        .add(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())))
                        .add(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim())));
                //System.out.println(jumlahTunjangan);   
             penghasilanBruto = tunjanganKel.add(tunjanganFungsional).add(tunjanganPangan).add(gapok)
                        .add(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())))
                        .add(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim())));
                System.out.println(penghasilanBruto);*/
                
            }/*
        } else if (source == cmbJumlahRombel) {
            if (mpg != null) {
                if (mpg.getJabatan().equals("Kepala TK")) {
                    tunjanganJabatan = hitungTunjanganJabatan(mpg.getJabatan(), mpg.getGolongan(), cmbJumlahRombel.getSelectedItem().toString().trim());
                    txtTunjanganJabatan.setText(TextComponentUtils.formatNumber(String.valueOf(tunjanganJabatan)));
                    System.out.println("Tes Kepala TK : "+mpg.getJabatan());
                } else {
                    tunjanganJabatan = hitungTunjanganJabatan(mpg.getJabatan().substring(0, 6).trim() +" "+ mpg.getUnitKerja().trim(), mpg.getGolongan(), cmbJumlahRombel.getSelectedItem().toString().trim());
                    txtTunjanganJabatan.setText(String.valueOf(TextComponentUtils.formatNumber(String.valueOf(tunjanganJabatan))));
                    System.out.println("Tes : "+mpg.getJabatan().substring(0, 6).trim() +" "+ mpg.getUnitKerja().trim()+" "+tunjanganJabatan);
                }
             jumlahTunjangan = tunjanganKel.add(tunjanganFungsional).add(tunjanganPangan)
                        .add(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())))
                        .add(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim())));
                //System.out.println(jumlahTunjangan);   
             penghasilanBruto = tunjanganKel.add(tunjanganFungsional).add(tunjanganPangan).add(gapok)
                        .add(BigDecimal.valueOf(Long.valueOf(txtTunjanganJabatan.getText().replace(".", "").trim())))
                        .add(BigDecimal.valueOf(Long.valueOf(txtJumlahHonor.getText().replace(".", "").trim())));
                System.out.println(penghasilanBruto);
            }*/
        } else if(source == btnBatal) {
            dispose();
        } else if (source == btnSetupRincianHonor){
            SetupTunjanganPegawaiDialog detailPenjualan = new SetupTunjanganPegawaiDialog(MainView.getInstance());
            //detailPenjualan.display(this, mpg);
            //mpg = stp.searchDPH(this);
            //TambahTransaksiPenggajianDialog detailPenjualan = new TambahTransaksiPenggajianDialog(getMainView());
            DetailPerincianHonor dph = detailPenjualan.searchDPH(this);
            if (dph != null) {
                for (int i = 0; i < dynamicTableModel.getRowCount(); i++) {
                    DetailPerincianHonor item = dynamicTableModel.get(i);
                    if (item.getTpp().getId().equals(dph.getTpp().getId())) {
                        dynamicTableModel.remove(i);
                        break;
                    }
                }

                dynamicTableModel.add(dph);
                txtJumlahHonor.setText(TextComponentUtils.formatNumber(String.valueOf(dph.getJumlahHonor())));
                btnSetupRincianHonor.setEnabled(false);
            }
        }
        
    }//GEN-LAST:event_buttonAction

    public static BigDecimal getPokokHonor() {
        return pokokHonor;
    }

    public static void setPokokHonor(BigDecimal pokokHonor) {
        TambahTransaksiPenggajianDialog.pokokHonor = pokokHonor;
    }

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
    private javax.swing.JButton btnSetupRincianHonor;
    private javax.swing.JButton btnTambah;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser tanggalGaji;
    private javax.swing.JTextField txtGajiPokok;
    private javax.swing.JTextField txtGolongan;
    private javax.swing.JTextField txtJumlahHonor;
    private javax.swing.JTextField txtMKG;
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
        //view = new DaftarTransaksiPenggajianPerUnitKerjaView1(null);
        //tblMasterPegawai.setVisible(false);

        btnSetupRincianHonor.setEnabled(false);
        TextComponentUtils.setCurrency(txtJumlahHonor);
        TextComponentUtils.setNumericTextOnly(txtNIP);
        setLocationRelativeTo(formApp);
                //refreshTable();
        setVisible(true);
    }
}
