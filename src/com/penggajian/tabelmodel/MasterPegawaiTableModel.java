/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.tabelmodel;

import com.penggajian.entity.MasterPegawai;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MY-IT-STAF
 */
public class MasterPegawaiTableModel extends AbstractTableModel {

    private final String[] header = {"ID","Nama","NIP","Pendidikan","Status Sipil","Status Kepegawaian","Sub Status Kepegawaian",
    "Jabatan","Tingkat","Golongan","Sub Golongan","Masa Kerja","Jenis Penghasilan"};
    private List<MasterPegawai> masterPegawai;

    public MasterPegawaiTableModel() {
    }

    public MasterPegawaiTableModel(List<MasterPegawai> masterPegawai) {
        this.masterPegawai = masterPegawai;
    }

    public void setMasterPegawai(List<MasterPegawai> masterPegawai) {
        this.masterPegawai = masterPegawai;
        fireTableDataChanged();
    }

    public int getRowCount() {
        return masterPegawai.size();
    }

    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int col) {
       return header[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        MasterPegawai p = masterPegawai.get(row);
        switch(col){
            case 0 : return p.getId();
            case 1 : return p.getNama();
            case 2 : return p.getNip();
            case 3 : return p.getPendidikan();
            case 4 : return p.getStatusSipil();
            case 5 : return p.getStatusKepegawaian();
            case 6 : return p.getSubstatusKepegawaian();
            case 7 : return p.getJabatan();
            case 8 : return p.getUnitKerja();
            case 9 : return p.getGolongan();
            case 10 : return p.getSubGolongan();
            case 11 : return p.getMasaKerjaGolongan();
            //case 12 : return p.getJenisPenghasilan();
            default : return "";
        }
    }
}