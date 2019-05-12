/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.service.master;

import com.penggajian.dao.master.DetailPerincianHonorDao;
import com.penggajian.dao.master.MasterPegawaiDao;
import com.penggajian.dao.master.PokokHonorDao;
import com.penggajian.dao.master.TabelGapokCapegPegawaiDao;
import com.penggajian.dao.master.TabelTunjanganJabatanDao;
import com.penggajian.dao.master.TransaksiPenggajianPegawaiDao;
import com.penggajian.dao.master.TunjanganFungsionalDao;
import com.penggajian.dao.master.TunjanganJamMengajarDao;
import com.penggajian.dao.master.TunjanganKeluargaDao;
import com.penggajian.dao.master.TunjanganKhususDao;
import com.penggajian.dao.master.TunjanganPanganDao;
import com.penggajian.dao.master.TunjanganStaffKurikulumKasiDao;
import com.penggajian.dao.master.TunjanganYayasanDao;
import com.penggajian.entity.DetailPerincianHonor;
import com.penggajian.entity.LaporanGajiBulanan;
import com.penggajian.entity.LaporanRincianHonor;
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
import com.penggajian.service.MasterService;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MY-IT-STAF
 */
@Service("masterService")
@Transactional(readOnly = true)
@Repository
public class MasterServiceImplementasi implements MasterService{
    
    //private static final Logger log = Logger.getLogger(MasterServiceImplementasi.class);
    @Autowired private SessionFactory sessionFactory;

    @Autowired private MasterPegawaiDao masterPegawaiDao;
    @Autowired private TabelGapokCapegPegawaiDao tabelGapokCapegPegawaiDao;
    @Autowired private PokokHonorDao pokokHonorDao;
    @Autowired private TransaksiPenggajianPegawaiDao transaksiPenggajianPegawaiDao;
    @Autowired private TunjanganFungsionalDao tunjanganFungsionalDao;
    @Autowired private TabelTunjanganJabatanDao tabelTunjanganJabatanDao;
    @Autowired private TunjanganJamMengajarDao tunjanganJamMengajarDao;
    @Autowired private TunjanganKeluargaDao tunjanganKeluargaDao;
    @Autowired private TunjanganKhususDao tunjanganKhususDao;
    @Autowired private TunjanganPanganDao tunjanganPanganDao;
    @Autowired private TunjanganStaffKurikulumKasiDao tunjanganStaffKurikulumKasiDao;
    @Autowired private DetailPerincianHonorDao detailPerincianHonorDao;
    @Autowired private TunjanganYayasanDao tunjanganYayasanDao;

    @Transactional
    @Override
    public void save(MasterPegawai p) {
       masterPegawaiDao.save(p);
    }

    @Transactional
    @Override
    public void update(MasterPegawai pegawai) {
        masterPegawaiDao.update(pegawai);
    }

    @Transactional
    @Override
    public void delete(MasterPegawai pegawai) {
        masterPegawaiDao.delete(pegawai);
    }

    @Override
    public List<MasterPegawai> getAllMasterPegawai() {
        return masterPegawaiDao.getAll();
    }

    @Override
    public List<MasterPegawai> getMasterPegawaiBy(String m) {
        return null;
    }
    
    @Override
    public MasterPegawai findByID(String id) {
        return masterPegawaiDao.findByID(id);
    }

    @Transactional
    @Override
    public void save(TabelGapokCapegPegawai gcp) {
        tabelGapokCapegPegawaiDao.save(gcp);
    }

    @Transactional
    @Override
    public void update(TabelGapokCapegPegawai gcp) {
        tabelGapokCapegPegawaiDao.save(gcp);
    }

    @Transactional
    @Override
    public void delete(TabelGapokCapegPegawai gcp) {
        tabelGapokCapegPegawaiDao.delete(gcp);
    }

    @Override
    public List<TabelGapokCapegPegawai> getAllGapokCapegPegawai() {
        return tabelGapokCapegPegawaiDao.getAll();
    }

    @Override
    public List<TabelGapokCapegPegawai> getGapokCapegPegawaiBy(String m) {
        return null;
    }

    @Transactional
    @Override
    public void save(PokokHonor ph) {
        pokokHonorDao.save(ph);
    }

    @Transactional
    @Override
    public void update(PokokHonor ph) {
        pokokHonorDao.update(ph);
    }

    @Transactional
    @Override
    public void delete(PokokHonor ph) {
        pokokHonorDao.delete(ph);
    }

    @Override
    public List<PokokHonor> getAllPokokHonor() {
        return pokokHonorDao.getAll();
    }

    @Override
    public List<PokokHonor> getPokokHonorBy(String m) {
        return null;
    }

    @Transactional
    @Override
    public void save(TransaksiPenggajianPegawai tpp) {
        transaksiPenggajianPegawaiDao.save(tpp);
    }

    @Transactional
    @Override
    public void update(TransaksiPenggajianPegawai tpp) {
        transaksiPenggajianPegawaiDao.update(tpp);
    }

    @Transactional
    @Override
    public void delete(TransaksiPenggajianPegawai tpp) {
        transaksiPenggajianPegawaiDao.delete(tpp);
    }

    @Override
    public List<TransaksiPenggajianPegawai> getAllTransaksiPenggajianPegawai() {
        return transaksiPenggajianPegawaiDao.getAll();
    }

    @Override
    public List<TransaksiPenggajianPegawai> getTransaksiPenggajianPegawaiBy(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void save(TunjanganFungsional tf) {
        tunjanganFungsionalDao.save(tf);
    }

    @Transactional
    @Override
    public void update(TunjanganFungsional tf) {
        tunjanganFungsionalDao.update(tf);
    }

    @Transactional
    @Override
    public void delete(TunjanganFungsional tf) {
        tunjanganFungsionalDao.delete(tf);
    }

    @Override
    public List<TunjanganFungsional> getAllTunjanganFungsional(){
        return tunjanganFungsionalDao.getAll();
    }
    
    @Override
    public List<TunjanganFungsional> getTunjanganFungsionalBy(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void save(TabelTunjanganJabatan tf) {
        tabelTunjanganJabatanDao.save(tf);
    }

    @Transactional
    @Override
    public void update(TabelTunjanganJabatan tf) {
        tabelTunjanganJabatanDao.update(tf);
    }

    @Transactional
    @Override
    public void delete(TabelTunjanganJabatan tf) {
        tabelTunjanganJabatanDao.delete(tf);
    }

    @Override
    public List<TabelTunjanganJabatan> getAllTunjanganJabatan() {
        return tabelTunjanganJabatanDao.getAll();
    }

    @Override
    public List<TabelTunjanganJabatan> getTunjanganJabatanBy(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void save(TunjanganJamMengajar tjm) {
        tunjanganJamMengajarDao.save(tjm);
    }

    @Transactional
    @Override
    public void update(TunjanganJamMengajar tjm) {
        tunjanganJamMengajarDao.update(tjm);
    }

    @Transactional
    @Override
    public void delete(TunjanganJamMengajar tjm) {
        tunjanganJamMengajarDao.delete(tjm);
    }

    @Override
    public List<TunjanganJamMengajar> getAllTunjanganJamMengajar() {
        return tunjanganJamMengajarDao.getAll();
    }

    @Override
    public List<TunjanganJamMengajar> getTunjanganJamMengajarBy(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void save(TunjanganKeluarga tk) {
        tunjanganKeluargaDao.save(tk);
    }

    @Transactional
    @Override
    public void update(TunjanganKeluarga tk) {
        tunjanganKeluargaDao.update(tk);
    }

    @Transactional
    @Override
    public void delete(TunjanganKeluarga tk) {
        tunjanganKeluargaDao.delete(tk);
    }

    @Override
    public List<TunjanganKeluarga> getAllTunjanganKeluarga() {
        return tunjanganKeluargaDao.getAll();
    }

    @Override
    public List<TunjanganKeluarga> getTunjanganKeluargaBy(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void save(TunjanganKhusus tk) {
        tunjanganKhususDao.save(tk);
    }

    @Transactional
    @Override
    public void update(TunjanganKhusus tk) {
        tunjanganKhususDao.update(tk);
    }

    @Transactional
    @Override
    public void delete(TunjanganKhusus tk) {
        tunjanganKhususDao.delete(tk);
    }

    @Override
    public List<TunjanganKhusus> getAllTunjanganKhusus() {
        return tunjanganKhususDao.getAll();
    }

    @Override
    public List<TunjanganKhusus> getTunjanganKhususBy(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    @Override
    public void save(TunjanganPangan tp) {
        tunjanganPanganDao.save(tp);
    }

    @Transactional
    @Override
    public void update(TunjanganPangan tp) {
        tunjanganPanganDao.update(tp);
    }

    @Transactional
    @Override
    public void delete(TunjanganPangan tp) {
        tunjanganPanganDao.delete(tp);
    }

    @Override
    public List<TunjanganPangan> getAllTunjanganPangan() {
        return tunjanganPanganDao.getAll();
    }

    @Override
    public List<TunjanganPangan> getTunjanganPanganBy(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
    @Override
    public void save(TunjanganStaffKurikulumEkstrakurikuluer ts) {
        tunjanganStaffKurikulumKasiDao.save(ts);
    }

    @Transactional
    @Override
    public void update(TunjanganStaffKurikulumEkstrakurikuluer ts) {
        tunjanganStaffKurikulumKasiDao.update(ts);
    }

    @Transactional
    @Override
    public void delete(TunjanganStaffKurikulumEkstrakurikuluer ts) {
        tunjanganStaffKurikulumKasiDao.delete(ts);
    }

    @Override
    public List<TunjanganStaffKurikulumEkstrakurikuluer> getAllTunjanganStaffKurikulumKasi() {
        return tunjanganStaffKurikulumKasiDao.getAll();
    }

    @Override
    public List<TunjanganStaffKurikulumEkstrakurikuluer> getTunjanganStaffKurikulumKasiKelasBy(String m) {
        return tunjanganStaffKurikulumKasiDao.getAll();
    }
    
    @Transactional
    @Override
    public void save(DetailPerincianHonor ts) {
        detailPerincianHonorDao.save(ts);
    }

    @Transactional
    @Override
    public void update(DetailPerincianHonor ts) {
        detailPerincianHonorDao.update(ts);
    }

    @Transactional
    @Override
    public void delete(DetailPerincianHonor ts) {
        detailPerincianHonorDao.delete(ts);
    }

    @Override
    public List<DetailPerincianHonor> getAllDetailPerincianHonor() {
        return detailPerincianHonorDao.getAll();
    }

    @Override
    public List<DetailPerincianHonor> getTAlDetailPerincianHonorBy(String m) {
        return detailPerincianHonorDao.getAll();
    }
    
    @Transactional
    @Override
    public void save(TunjanganYayasan ts) {
        tunjanganYayasanDao.save(ts);
    }

    @Transactional
    @Override
    public void update(TunjanganYayasan ts) {
        tunjanganYayasanDao.update(ts);
    }

    @Transactional
    @Override
    public void delete(TunjanganYayasan ts) {
        tunjanganYayasanDao.delete(ts);
    }

    @Override
    public List<TunjanganYayasan> getAllTunjanganYayasan() {
        return tunjanganYayasanDao.getAll();
    }

    @Override
    public List<TunjanganYayasan> getTunjanganYayasan(String m) {
        return tunjanganYayasanDao.getAll();
    }
    
    
    @Override
    public JasperPrint getLaporanPenggajianPegawaiBulanan(Date date){
        //InputStream is = null;
        //JasperDesign jasdes ;
        try {
            List<LaporanGajiBulanan> list = 
                    sessionFactory.getCurrentSession()
                            .createQuery("select s.mp.nama as nama, "+
                                    "s.mp.statusSipil as sipil,\n"+
                                    "s.mp.statusKepegawaian as kepeg,\n"+
                                    "s.mp.golongan as gol,\n"+
                                    "s.mp.subGolongan as subGol,\n"+
                                     "s.gapok as gapok,\n" +
                            " s.tunjanganKeluarga AS tunjanganKeluarga,\n" +  
                            " s.tunjanganJabatan AS tunjanganJabatan,\n" +  
                            " s.tunjanganFungsional AS tunjanganFungsional,\n" +  
                            " s.tunjanganPangan AS tunjanganPangan,\n" +        
                            " s.tunjanganHonor AS tunjanganHonor,\n" +
                            " s.jumlahTunjangan AS jumlahTunjangan,\n" +   
                            " s.penghasilanBruto AS penghasilanBruto,\n" +  
                            " s.penguranganSiswa AS penguranganSiswa,\n" +  
                            " s.penguranganJabatan AS penguranganJabatan,\n" +  
                            " s.jumlahPengurangan AS jumlahPengurangan,\n" + 
                            " s.penghasilanNeto AS penghasilanNeto,\n" +  
                            " s.PTKP AS PTKP,\n" +  
                            " s.PKP AS PKP,\n" +  
                            " s.PPhPsl21 AS PPhPsl21,\n" + 
                            " s.jumlahPotongan AS jumlahPotongan,\n" +  
                            " s.terima AS terima FROM TransaksiPenggajianPegawai s \n" +
//" masterpegawai masterpegawai INNER JOIN transaksipenggajianpegawai transaksipenggajianpegawai ON masterpegawai.id = transaksipenggajianpegawai.id\n" +
"where day(s.bulan) = day(:date)\n")
                            .setParameter("date", date)
                            .setResultTransformer(Transformers.aliasToBean(LaporanGajiBulanan.class))
                    .list();
            //String is = "/report/LapGajiBulanan.jasper";
            //String is = "src/main/java/com/penggajian/report/LapGajiBulanan.jasper";
            //InputStream is = this.getClass().getClass().getResourceAsStream("/report/LapGajiBulanan.jasper");
            Map<String,Object> parameters = new HashMap<>();
                parameters.put("date", date);     
                parameters.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
        //return JasperFillManager.fillReport(is, parameters, new JRBeanCollectionDataSource(list));*/
            //String reportSource = "report/LapGajiBulanan.jrxml";
            //It will look for this file on your location so you need to copy your file on /report/ this location
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File("./report/LapGajiBulanan.jasper"));
           //File reportSource = new File("/report/LapGajiBulanan.jrxml");
           //jasdes = JRXmlLoader.load(reportSource);
                //is = getClass().getResourceAsStream(jasdes);
            //is = ClassLoader.getSystemResourceAsStream("LapGajiBulanan.jrxml");
                //JasperReport jasperReport = (JasperReport)JasperCompileManager.compileReport(jasdes);
                //JasperReport jasperReport = (JasperReport)JRLoader.loadObject(is);
                //JasperViewer.viewReport(JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(list)), false);
                return JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(list));
        } catch (JRException e) {
            //log("error generate DailySalesReport", e);
            //System.out.println("EROR : "+e);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
        return null;        
    }
       
    /*@Override
    public JasperPrint getLaporanRincianHonorBulanan(Date date){
        //InputStream is = null;
        //JasperDesign jasdes ;
        try {
            List<LaporanRincianHonor> list = 
            sessionFactory.getCurrentSession()
                    .createQuery("select s.mp.nama as nama,\n" +
                            //"select s.mp.nama as nama,\n" +
                            "s.mp.statusKepegawaian as kepeg,\n"+
                            "s.pokokHonor as pokokHonor,\n"+
                            "s.tunjanganKepalaBidang as tunjanganKaBid,\n"+
                            "s.tunjanganStaf as tunjanganStaf,\n"+
                            "s.tunjanganSatpam as tunjanganSatpam,\n"+
                            "s.tunjanganPegawaiKebersihan as tunjanganPegKebersihan,\n"+
                            "s.tunjanganTransport as tunjanganTransport,\n"+
                            "s.jumlahHonor as jumlahHonor FROM DetailPerincianHonor s" + 
                            "where day(s.tpp.bulan) = day(:date)\n")
                    .setParameter("date", date)
                    .setResultTransformer(Transformers.aliasToBean(LaporanRincianHonor.class))
                    .list();
            //String is = "/report/LapGajiBulanan.jasper";
            //String is = "src/main/java/com/penggajian/report/LapGajiBulanan.jasper";
            //InputStream is = this.getClass().getClass().getResourceAsStream("/report/LapGajiBulanan.jasper");
            Map<String,Object> parameters = new HashMap<>(); 
            parameters.put("date", date);   
                parameters.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
        //return JasperFillManager.fillReport(is, parameters, new JRBeanCollectionDataSource(list));*/
            //String reportSource = "report/LapGajiBulanan.jrxml";
            //It will look for this file on your location so you need to copy your file on /report/ this location
                //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File("./report/LapRincianHonor1.jasper"));
           //File reportSource = new File("/report/LapGajiBulanan.jrxml");
           //jasdes = JRXmlLoader.load(reportSource);
                //is = getClass().getResourceAsStream(jasdes);
            //is = ClassLoader.getSystemResourceAsStream("LapGajiBulanan.jrxml");
                //JasperReport jasperReport = (JasperReport)JasperCompileManager.compileReport(jasdes);
                //JasperReport jasperReport = (JasperReport)JRLoader.loadObject(is);
                //JasperViewer.viewReport(JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(list)), false);
                /*return JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(list));
        } catch (JRException e) {
            //log("error generate DailySalesReport", e);
            //System.out.println("EROR : "+e);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
        return null;        
    }*/
    
    @Override
    public JasperPrint getLaporanRincianHonorBulanan(Date date){
        //InputStream is = null;
        //JasperDesign jasdes ;
        try {
            List<LaporanRincianHonor> list = 
                    sessionFactory.getCurrentSession()
                            .createQuery("select s.tpp.mp.nama as nama, "+
                                    "s.tpp.mp.statusSipil as kepeg,\n"+
                                    "s.pokokHonor as pokokHonor,\n"+
                                    "s.tunjanganKepalaBidang as tunjanganKaBid,\n"+
                                    "s.tunjanganStaf as tunjanganStaf,\n"+
                                    "s.tunjanganSatpam as tunjanganSatpam,\n"+
                                    "s.tunjanganPegawaiKebersihan as tunjanganPegKebersihan,\n"+
                                    "s.tunjanganTransport as tunjanganTransport,\n"+
                                    "s.jumlahHonor as jumlahHonor FROM DetailPerincianHonor s \n" +
"where day(s.tpp.bulan) = day(:date)\n")
                            .setParameter("date", date)
                            .setResultTransformer(Transformers.aliasToBean(LaporanRincianHonor.class))
                            .list();
            //String is = "/report/LapGajiBulanan.jasper";
            //String is = "src/main/java/com/penggajian/report/LapGajiBulanan.jasper";
            //InputStream is = this.getClass().getClass().getResourceAsStream("/report/LapGajiBulanan.jasper");
            Map<String,Object> parameters = new HashMap<>();
                parameters.put("date", date);     
                parameters.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));
        //return JasperFillManager.fillReport(is, parameters, new JRBeanCollectionDataSource(list));*/
            //String reportSource = "report/LapGajiBulanan.jrxml";
            //It will look for this file on your location so you need to copy your file on /report/ this location
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File("./report/LapRincianHonor.jasper"));
           //File reportSource = new File("/report/LapGajiBulanan.jrxml");
           //jasdes = JRXmlLoader.load(reportSource);
                //is = getClass().getResourceAsStream(jasdes);
            //is = ClassLoader.getSystemResourceAsStream("LapGajiBulanan.jrxml");
                //JasperReport jasperReport = (JasperReport)JasperCompileManager.compileReport(jasdes);
                //JasperReport jasperReport = (JasperReport)JRLoader.loadObject(is);
                //JasperViewer.viewReport(JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(list)), false);
                return JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(list));
        } catch (JRException e) {
            //log("error generate DailySalesReport", e);
            //System.out.println("EROR : "+e);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }
        return null;        
    }
    
}
