/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.service;

import com.penggajian.entity.DetailPerincianHonor;
import com.penggajian.entity.MasterPegawai;
import com.penggajian.entity.PokokHonor;
import com.penggajian.entity.TabelGapokCapegPegawai;
import com.penggajian.entity.TabelTunjanganJabatan;
import com.penggajian.entity.TransaksiPenggajianPegawai;
import com.penggajian.entity.TunjanganFungsional;
import com.penggajian.entity.TunjanganJamMengajar;
import com.penggajian.entity.TunjanganKeluarga;
import com.penggajian.entity.TunjanganKhusus;
import com.penggajian.entity.TunjanganPangan;
import com.penggajian.entity.TunjanganStaffKurikulumEkstrakurikuluer;
import com.penggajian.entity.TunjanganYayasan;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author MY-IT-STAF
 */
public interface MasterService {
    
    public void save(MasterPegawai pegawai);
    public void update(MasterPegawai pegawai);
    public void delete(MasterPegawai pegawai);
    public List<MasterPegawai> getAllMasterPegawai();
    public List<MasterPegawai> getMasterPegawaiBy(String m);
    public MasterPegawai findByID(String id);
    
    public void save(TabelGapokCapegPegawai gcp);
    public void update(TabelGapokCapegPegawai gcp);
    public void delete(TabelGapokCapegPegawai gcp);
    public List<TabelGapokCapegPegawai> getAllGapokCapegPegawai();
    public List<TabelGapokCapegPegawai> getGapokCapegPegawaiBy(String m);
    
    public void save(PokokHonor ph);
    public void update(PokokHonor ph);
    public void delete(PokokHonor ph);
    public List<PokokHonor> getAllPokokHonor();
    public List<PokokHonor> getPokokHonorBy(String m);
    
    public void save(TransaksiPenggajianPegawai tpp);
    public void update(TransaksiPenggajianPegawai tpp);
    public void delete(TransaksiPenggajianPegawai tpp);
    public List<TransaksiPenggajianPegawai> getAllTransaksiPenggajianPegawai();
    public List<TransaksiPenggajianPegawai> getTransaksiPenggajianPegawaiBy(String m);
    
    public void save(TunjanganFungsional tf);
    public void update(TunjanganFungsional tf);
    public void delete(TunjanganFungsional tf);
    public List<TunjanganFungsional> getAllTunjanganFungsional();
    public List<TunjanganFungsional> getTunjanganFungsionalBy(String m);
    
    public void save(TabelTunjanganJabatan tf);
    public void update(TabelTunjanganJabatan tf);
    public void delete(TabelTunjanganJabatan tf);
    public List<TabelTunjanganJabatan> getAllTunjanganJabatan();
    public List<TabelTunjanganJabatan> getTunjanganJabatanBy(String m);
    
    public void save(TunjanganJamMengajar tjm);
    public void update(TunjanganJamMengajar tjm);
    public void delete(TunjanganJamMengajar tjm);
    public List<TunjanganJamMengajar> getAllTunjanganJamMengajar();
    public List<TunjanganJamMengajar> getTunjanganJamMengajarBy(String m);
    
    public void save(TunjanganKeluarga tk);
    public void update(TunjanganKeluarga tk);
    public void delete(TunjanganKeluarga tk);
    public List<TunjanganKeluarga> getAllTunjanganKeluarga();
    public List<TunjanganKeluarga> getTunjanganKeluargaBy(String m);
    
    public void save(TunjanganKhusus tk);
    public void update(TunjanganKhusus tk);
    public void delete(TunjanganKhusus tk);
    public List<TunjanganKhusus> getAllTunjanganKhusus();
    public List<TunjanganKhusus> getTunjanganKhususBy(String m);
    
    public void save(TunjanganPangan tp);
    public void update(TunjanganPangan tp);
    public void delete(TunjanganPangan tp);
    public List<TunjanganPangan> getAllTunjanganPangan();
    public List<TunjanganPangan> getTunjanganPanganBy(String m);
    
    public void save(TunjanganStaffKurikulumEkstrakurikuluer ts);
    public void update(TunjanganStaffKurikulumEkstrakurikuluer ts);
    public void delete(TunjanganStaffKurikulumEkstrakurikuluer ts);
    public List<TunjanganStaffKurikulumEkstrakurikuluer> getAllTunjanganStaffKurikulumKasi();
    public List<TunjanganStaffKurikulumEkstrakurikuluer> getTunjanganStaffKurikulumKasiKelasBy(String m);
    
    public void save(DetailPerincianHonor dph);
    public void update(DetailPerincianHonor dph);
    public void delete(DetailPerincianHonor dph);
    public List<DetailPerincianHonor> getAllDetailPerincianHonor();
    public List<DetailPerincianHonor> getTAlDetailPerincianHonorBy(String by);
    
    public void save(TunjanganYayasan ty);
    public void update(TunjanganYayasan ty);
    public void delete(TunjanganYayasan ty);
    public List<TunjanganYayasan> getAllTunjanganYayasan();
    public List<TunjanganYayasan> getTunjanganYayasan(String by);
    
    public JasperPrint getLaporanPenggajianPegawaiBulanan(Date date);
    public JasperPrint getLaporanRincianHonorBulanan(Date date);
}
