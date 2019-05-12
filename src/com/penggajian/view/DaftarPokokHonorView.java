/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.view;

import com.penggajian.main.DialogView;
import com.penggajian.main.MainView;
import com.penggajian.entity.PokokHonor;
import com.penggajian.main.SpringManager;
import com.penggajian.service.MasterService;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Window;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Windows
 */
public class DaftarPokokHonorView extends DialogView {

    /**
     * Creates new form DaftarDataPegawaiView
     */
    
    private JDynamicTable dynamicTable;
    private DynamicTableModel<PokokHonor> dynamicTableModel;
    
    public DaftarPokokHonorView(MainView mainView) {
        super(mainView);
        
        initComponents();
        dynamicTableModel = new DynamicTableModel<>(PokokHonor.class);
        dynamicTable = new JDynamicTable(dynamicTableModel);
        jScrollPane1.setViewportView(dynamicTable);
    }
    
    private void refreshTable(){
        MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
        dynamicTableModel.clear();
        for (PokokHonor ph : masterService.getAllPokokHonor()) {
            dynamicTableModel.add(ph);
        }
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
        btnUbah = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setTitle("Daftar Pokok Honor");

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

        btnHapus.setText("Hapus Pegawai");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnUbah.setText("Ubah Pegawai");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction(evt);
            }
        });

        btnTambah.setText("Tambah Pegawai");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 390, Short.MAX_VALUE)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addGap(10, 10, 10)
                        .addComponent(btnKembali)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHapus, btnKembali, btnTambah, btnUbah});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah)
                    .addComponent(btnTambah)
                    .addComponent(btnKembali))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction
        // TODO add your handling code here:
        Object source = evt.getSource();
        if (source == btnTambah) {
            TambahPokokHonorDialog td = new TambahPokokHonorDialog(getMainView());
            td.display(this, null);
            refreshTable();
        } else if(source == btnUbah){
            if (dynamicTable.getSelectedRow() == -1) {
                showWarning("Silahkan pilih salah satu");
            } else {
                PokokHonor ph = dynamicTableModel.get(
                        dynamicTable.convertRowIndexToModel(
                        dynamicTable.getSelectedRow()));
                UbahPokokHonorDialog ubah = new UbahPokokHonorDialog(getMainView());
                ubah.display(this, ph);
                refreshTable();
            }
        } else if(source == btnHapus){
            if (dynamicTable.getSelectedRow() == -1) {
                showWarning("Silahkan pilih salah satu");
            } else {
                PokokHonor ph = dynamicTableModel.get(
                        dynamicTable.convertRowIndexToModel(
                        dynamicTable.getSelectedRow()));
                
                MasterService masterService = SpringManager.getInstance().getBean(MasterService.class);
                
                try {
                    masterService.delete(ph);
                    refreshTable();
                } catch (DataAccessException ex) {
                    showError(ex.getRootCause().getMessage());
                }
            }  
        } else if (source == btnKembali){
            dispose();
        }
    }//GEN-LAST:event_buttonAction


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMasterPegawai;
    // End of variables declaration//GEN-END:variables

    @Override
    public void display(Window formApp, Object parameter) {
        refreshTable();
        setLocationRelativeTo(this);
        setVisible(true);
    }
}