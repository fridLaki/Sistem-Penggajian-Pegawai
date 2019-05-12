/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.view;

import com.penggajian.view.*;
import com.penggajian.entity.DetailPerincianHonor;
import com.penggajian.entity.TransaksiPenggajianPegawai;
import com.penggajian.main.DialogView;
import com.penggajian.main.MainView;
import com.penggajian.main.SpringManager;
import com.penggajian.service.MasterService;
import static com.penggajian.view.TambahTransaksiPenggajianDialog.setBidang;
import static com.penggajian.view.TambahTransaksiPenggajianDialog.setKebersihan;
import static com.penggajian.view.TambahTransaksiPenggajianDialog.setSatpam;
import static com.penggajian.view.TambahTransaksiPenggajianDialog.setStaf;
import com.stripbandunk.jglasspane.component.MessageComponent;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Window;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.jdbc.Work;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Windows
 */
public class DaftarTransaksiPenggajianPerUnitKerjaView extends DialogView {

    /**
     * Creates new form DaftarDataPegawaiView
     */
    
    private JDynamicTable dynamicTable;
    private DynamicTableModel<TransaksiPenggajianPegawai> dynamicTableModel;
    private MessageComponent messageComponent;
    
    public DaftarTransaksiPenggajianPerUnitKerjaView(MainView mainView) {
        super(mainView);
        
        initComponents();
        dynamicTableModel = new DynamicTableModel<>(TransaksiPenggajianPegawai.class);
        dynamicTable = new JDynamicTable(dynamicTableModel);
        jScrollPane1.setViewportView(dynamicTable);
    }
    
    private void refreshTable(){
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        dynamicTableModel.clear();
        for (TransaksiPenggajianPegawai tp : masterService.getAllTransaksiPenggajianPegawai()) {
            dynamicTableModel.add(tp);
        }
    }

    public JDateChooser getTanggalGaji() {
        return tanggalGaji;
    }

    //@Override
    //public void display(Window formApp, Object parameter) {
        //autoResizeColumn(tblMasterPegawai);
        //isiTableDaftarKartuPembayaran();
    //}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMasterPegawai = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSetupHonor = new javax.swing.JButton();
        tanggalGaji = new com.toedter.calendar.JDateChooser();
        btnPreview = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setTitle("Daftar Transaksi Penggajian Pegawai");

        tblMasterPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblMasterPegawai.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMasterPegawai.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblMasterPegawai);

        btnHapus.setText("Hapus Transaksi");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnTambah.setText("Tambah Transaksi");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        jLabel1.setText("Tanggal Penggajian");

        btnSetupHonor.setText("Setup Tunjangan");
        btnSetupHonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        tanggalGaji.setToolTipText("");
        tanggalGaji.setDate(new Date());
        tanggalGaji.setDateFormatString("dd MMMM yyyy");

        btnPreview.setText("Preview");
        btnPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnSimpan.setText("Simpan Transaksi");
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
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSetupHonor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPreview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 470, Short.MAX_VALUE)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKembali))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tanggalGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHapus, btnKembali, btnPreview, btnSimpan, btnTambah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tanggalGaji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnTambah)
                    .addComponent(btnKembali)
                    .addComponent(btnSetupHonor)
                    .addComponent(btnPreview)
                    .addComponent(btnSimpan))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction
        // TODO add your handling code here:
        Object source = evt.getSource();
        if (source == btnTambah) {
            TambahTransaksiPenggajianDialog detailPenjualan = new TambahTransaksiPenggajianDialog(getMainView());
            TransaksiPenggajianPegawai tpp = detailPenjualan.search(this);
            /*if (tpp != null) {
                for (int i = 0; i < dynamicTableModel.getRowCount(); i++) {
                    TransaksiPenggajianPegawai item = dynamicTableModel.get(i);
                    if (item.getMp().getId().equals(tpp.getMp().getId())) {
                        dynamicTableModel.remove(i);
                        break;
                    }
                }

                dynamicTableModel.add(tpp);
            }*/
            //refreshTable();
            setBidang(BigDecimal.ZERO);
            setStaf(BigDecimal.ZERO);
            setSatpam(BigDecimal.ZERO);
            setKebersihan(BigDecimal.ZERO);
        /*} else if(source == btnUbah){
            if (dynamicTable.getSelectedRow() == -1) {
                showWarning("Silahkan pilih salah satu");
            } else {
                TransaksiPenggajianPegawai tp = dynamicTableModel.get(
                        dynamicTable.convertRowIndexToModel(
                        dynamicTable.getSelectedRow()));
                UbahTransaksiPenggajianDialog ubah = new UbahTransaksiPenggajianDialog(getMainView());
                ubah.display(this, tp);
                refreshTable();
            }*/
        } else if(source == btnHapus){
            if (dynamicTable.getSelectedRow() == -1) {
                showWarning("Silahkan pilih salah satu");
            } else {
                TransaksiPenggajianPegawai tp = dynamicTableModel.get(
                        dynamicTable.convertRowIndexToModel(
                        dynamicTable.getSelectedRow()));
                
                MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
                
                try {
                    masterService.delete(tp);
                    refreshTable();
                    showWarning("Sukses menghapus");
                } catch (DataAccessException ex) {
                    showError(ex.getRootCause().getMessage());
                }
            }  /*
            if (dynamicTable.getSelectedRow() == -1) {
                messageComponent.showWarning("Pilih salah satu");
            } else {
                dynamicTableModel.remove(dynamicTable.convertRowIndexToModel(dynamicTable.getSelectedRow()));
            }*/
        } else if (source == btnKembali){
            dispose();
        } else if (source == btnPreview) {
            Date date;
            date = tanggalGaji.getDate();
            SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
            Session session = sessionFactory.openSession();
            session.doWork(new Work() {

                @Override
                public void execute(Connection connection) throws SQLException {
                    try {
                        //InputStream inputStream = DaftarTransaksiPenggajianPerUnitKerjaView.class.getResourceAsStream("D:/DATAKU/SEMESTER III/PEMROGRAMAN JAVA/SistemPenggajianPegawaiMardiYuana - Copy/src/main/java/com/penggajian/report/LaporanPenggajian.jasper");
                        String inputStream = "src/main/java/com/penggajian/report/LaporanPenggajian.jasper";

                        Map<String, Object> map = new HashMap<>();
                        map.put("bln", date);
                        map.put(JRParameter.REPORT_CONNECTION, connection);
                        map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));

                        JasperPrint print = JasperFillManager.fillReport(inputStream, map);
                        //JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("D:/DATAKU/SEMESTER III/PEMROGRAMAN JAVA/SistemPenggajianPegawaiMardiYuana - Copy/src/LaporanPenggajian.jasper"), map);
                        //JasperViewer.viewReport(jp, false);
                        
                        //JasperViewer viewer = new JasperViewer(print, false);
                        //viewer.setFitPageZoomRatio();
                        //viewer.setVisible(true);
                        //viewer.setAlwaysOnTop(true);
                        //JasperViewer.setDefaultLookAndFeelDecorated(true);
                        CetakLaporanView view = new CetakLaporanView(getMainView(), print);
                        view.display(DaftarTransaksiPenggajianPerUnitKerjaView.this, null);
                    } catch (JRException ex) {
                        Logger.getLogger(DaftarTransaksiPenggajianPerUnitKerjaView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            session.close();
        } else if (source == btnSetupHonor){
            SetupTunjanganPegawaiDialog stp = new SetupTunjanganPegawaiDialog(MainView.getInstance());
            stp.display(this, null);
        } else if (source == btnSimpan) {
            TransaksiPenggajianPegawai tpp = new TransaksiPenggajianPegawai();
            
            for (int i = 0; i < dynamicTableModel.getRowCount(); i++) {
                //DetailPerincianHonor detailPerincianHonor = dynamicTableModel.get(i);
                //tpp.tambahDaftarPenjualan(detailPerincianHonor);
            }
        }
    }//GEN-LAST:event_buttonAction


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPreview;
    private javax.swing.JButton btnSetupHonor;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser tanggalGaji;
    private javax.swing.JTable tblMasterPegawai;
    // End of variables declaration//GEN-END:variables

    @Override
    public void display(Window formApp, Object parameter) {
        btnSetupHonor.setVisible(false);
        //btnHapus.setVisible(false);
        btnSimpan.setVisible(false);
        btnPreview.setVisible(false);
        setLocationRelativeTo(this);
        refreshTable();
        setVisible(true);
    }
}
