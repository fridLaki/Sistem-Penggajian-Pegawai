/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.entity;

import com.penggajian.render.BigDecimalTableCellRenderer;
import com.penggajian.render.PegawaiTableCellRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author MY-IT-STAF
 */
@Entity
public class DetailPerincianHonor implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @TableColumn(number = 1, name = "ID", size = 5)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id")
    private MasterPegawai mp;
    private String jumlahJamMengajar;
    private String kelebihanJamMengajar;
    private BigDecimal pokokHonor;
    private BigDecimal jumlahKelebihanJamMengajar;
    
    /*Tunjangan Staf*/
    private String tunjanganKurikuler;
    private BigDecimal jumlahTunjanganKurikuler;
    private String tunjanganKesiswaan;
    private BigDecimal jumlahTunjanganKesiswaan;
    private String tunjanganSaranaPrasarana;
    private BigDecimal jumlahTunjanganSaranaPrasarana;
    private String tunjanganHumas;
    private BigDecimal jumlahTunjanganHumas;
    
    /*Tunjangan Kurikuler*/
    private String tunjanganPembinaOSIS;
    private BigDecimal jumlahTunjanganPembinaOSIS;
    private String tunjanganBP;
    private BigDecimal jumlahTunjanganBP;
    private String tunjanganPraktikum;
    private BigDecimal jumlahTunjanganPraktikum;
    private String tunjanganKomputer;
    private BigDecimal jumlahTunjanganKomputer;
    
    /*Tunjangan EkstraKurikuler*/
    private String tunjanganORUKS;
    private BigDecimal jumlahTunjanganORUKS;
    private String tunjanganSeni;
    private BigDecimal jumlahTunjanganSeni;
    private String tunjanganPram;
    private BigDecimal jumlahTunjanganPram;
    private String tunjanganKopMading;
    private BigDecimal jumlahTunjanganKopMading;
    private String tunjanganPastiKIR;
    private BigDecimal jumlahTunjanganPastiKIR;
    private String tunjanganSSosial;
    private BigDecimal jumlahTunjanganSSosial;
    
    /*Tunjangan Yayasan*/
    @TableColumn(number = 2, name = "Tunjangan Kepala Bidang", size = 19, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganKepalaBidang;
    @TableColumn(number = 3, name = "Tunjangan Staf", size = 13, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganStaf;
    @TableColumn(number = 4, name = "Tunjangan Satpam", size = 15, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganSatpam;
    @TableColumn(number = 5, name = "Tunjangan Peg. Kebersihan", size = 22, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganPegawaiKebersihan;
    @TableColumn(number = 6, name = "Tunjangan Transport", size = 16, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganTransport;
    @TableColumn(number = 7, name = "Jumlah Honor", size = 13, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlahHonor;
    
    @ManyToOne
    @JoinColumn(name = "transaksi_id")
    private TransaksiPenggajianPegawai tpp;
    //@Temporal(javax.persistence.TemporalType.DATE)
    //private Date bulan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MasterPegawai getMp() {
        return mp;
    }

    public void setMp(MasterPegawai mp) {
        this.mp = mp;
    }

    public String getJumlahJamMengajar() {
        return jumlahJamMengajar;
    }

    public void setJumlahJamMengajar(String jumlahJamMengajar) {
        this.jumlahJamMengajar = jumlahJamMengajar;
    }

    public String getKelebihanJamMengajar() {
        return kelebihanJamMengajar;
    }

    public void setKelebihanJamMengajar(String kelebihanJamMengajar) {
        this.kelebihanJamMengajar = kelebihanJamMengajar;
    }

    public BigDecimal getPokokHonor() {
        return pokokHonor;
    }

    public void setPokokHonor(BigDecimal pokokHonor) {
        this.pokokHonor = pokokHonor;
    }

    public BigDecimal getJumlahKelebihanJamMengajar() {
        return jumlahKelebihanJamMengajar;
    }

    public void setJumlahKelebihanJamMengajar(BigDecimal jumlahKelebihanJamMengajar) {
        this.jumlahKelebihanJamMengajar = jumlahKelebihanJamMengajar;
    }

    public String getTunjanganKurikuler() {
        return tunjanganKurikuler;
    }

    public void setTunjanganKurikuler(String tunjanganKurikuler) {
        this.tunjanganKurikuler = tunjanganKurikuler;
    }

    public BigDecimal getJumlahTunjanganKurikuler() {
        return jumlahTunjanganKurikuler;
    }

    public void setJumlahTunjanganKurikuler(BigDecimal jumlahTunjanganKurikuler) {
        this.jumlahTunjanganKurikuler = jumlahTunjanganKurikuler;
    }

    public String getTunjanganKesiswaan() {
        return tunjanganKesiswaan;
    }

    public void setTunjanganKesiswaan(String tunjanganKesiswaan) {
        this.tunjanganKesiswaan = tunjanganKesiswaan;
    }

    public BigDecimal getJumlahTunjanganKesiswaan() {
        return jumlahTunjanganKesiswaan;
    }

    public void setJumlahTunjanganKesiswaan(BigDecimal jumlahTunjanganKesiswaan) {
        this.jumlahTunjanganKesiswaan = jumlahTunjanganKesiswaan;
    }

    public String getTunjanganSaranaPrasarana() {
        return tunjanganSaranaPrasarana;
    }

    public void setTunjanganSaranaPrasarana(String tunjanganSaranaPrasarana) {
        this.tunjanganSaranaPrasarana = tunjanganSaranaPrasarana;
    }

    public BigDecimal getJumlahTunjanganSaranaPrasarana() {
        return jumlahTunjanganSaranaPrasarana;
    }

    public void setJumlahTunjanganSaranaPrasarana(BigDecimal jumlahTunjanganSaranaPrasarana) {
        this.jumlahTunjanganSaranaPrasarana = jumlahTunjanganSaranaPrasarana;
    }

    public String getTunjanganHumas() {
        return tunjanganHumas;
    }

    public void setTunjanganHumas(String tunjanganHumas) {
        this.tunjanganHumas = tunjanganHumas;
    }

    public BigDecimal getJumlahTunjanganHumas() {
        return jumlahTunjanganHumas;
    }

    public void setJumlahTunjanganHumas(BigDecimal jumlahTunjanganHumas) {
        this.jumlahTunjanganHumas = jumlahTunjanganHumas;
    }

    public String getTunjanganPembinaOSIS() {
        return tunjanganPembinaOSIS;
    }

    public void setTunjanganPembinaOSIS(String tunjanganPembinaOSIS) {
        this.tunjanganPembinaOSIS = tunjanganPembinaOSIS;
    }

    public BigDecimal getJumlahTunjanganPembinaOSIS() {
        return jumlahTunjanganPembinaOSIS;
    }

    public void setJumlahTunjanganPembinaOSIS(BigDecimal jumlahTunjanganPembinaOSIS) {
        this.jumlahTunjanganPembinaOSIS = jumlahTunjanganPembinaOSIS;
    }

    public String getTunjanganBP() {
        return tunjanganBP;
    }

    public void setTunjanganBP(String tunjanganBP) {
        this.tunjanganBP = tunjanganBP;
    }

    public BigDecimal getJumlahTunjanganBP() {
        return jumlahTunjanganBP;
    }

    public void setJumlahTunjanganBP(BigDecimal jumlahTunjanganBP) {
        this.jumlahTunjanganBP = jumlahTunjanganBP;
    }

    public String getTunjanganPraktikum() {
        return tunjanganPraktikum;
    }

    public void setTunjanganPraktikum(String tunjanganPraktikum) {
        this.tunjanganPraktikum = tunjanganPraktikum;
    }

    public BigDecimal getJumlahTunjanganPraktikum() {
        return jumlahTunjanganPraktikum;
    }

    public void setJumlahTunjanganPraktikum(BigDecimal jumlahTunjanganPraktikum) {
        this.jumlahTunjanganPraktikum = jumlahTunjanganPraktikum;
    }

    public String getTunjanganKomputer() {
        return tunjanganKomputer;
    }

    public void setTunjanganKomputer(String tunjanganKomputer) {
        this.tunjanganKomputer = tunjanganKomputer;
    }

    public BigDecimal getJumlahTunjanganKomputer() {
        return jumlahTunjanganKomputer;
    }

    public void setJumlahTunjanganKomputer(BigDecimal jumlahTunjanganKomputer) {
        this.jumlahTunjanganKomputer = jumlahTunjanganKomputer;
    }

    public String getTunjanganORUKS() {
        return tunjanganORUKS;
    }

    public void setTunjanganORUKS(String tunjanganORUKS) {
        this.tunjanganORUKS = tunjanganORUKS;
    }

    public BigDecimal getJumlahTunjanganORUKS() {
        return jumlahTunjanganORUKS;
    }

    public void setJumlahTunjanganORUKS(BigDecimal jumlahTunjanganORUKS) {
        this.jumlahTunjanganORUKS = jumlahTunjanganORUKS;
    }

    public String getTunjanganSeni() {
        return tunjanganSeni;
    }

    public void setTunjanganSeni(String tunjanganSeni) {
        this.tunjanganSeni = tunjanganSeni;
    }

    public BigDecimal getJumlahTunjanganSeni() {
        return jumlahTunjanganSeni;
    }

    public void setJumlahTunjanganSeni(BigDecimal jumlahTunjanganSeni) {
        this.jumlahTunjanganSeni = jumlahTunjanganSeni;
    }

    public String getTunjanganPram() {
        return tunjanganPram;
    }

    public void setTunjanganPram(String tunjanganPram) {
        this.tunjanganPram = tunjanganPram;
    }

    public BigDecimal getJumlahTunjanganPram() {
        return jumlahTunjanganPram;
    }

    public void setJumlahTunjanganPram(BigDecimal jumlahTunjanganPram) {
        this.jumlahTunjanganPram = jumlahTunjanganPram;
    }

    public String getTunjanganKopMading() {
        return tunjanganKopMading;
    }

    public void setTunjanganKopMading(String tunjanganKopMading) {
        this.tunjanganKopMading = tunjanganKopMading;
    }

    public BigDecimal getJumlahTunjanganKopMading() {
        return jumlahTunjanganKopMading;
    }

    public void setJumlahTunjanganKopMading(BigDecimal jumlahTunjanganKopMading) {
        this.jumlahTunjanganKopMading = jumlahTunjanganKopMading;
    }

    public String getTunjanganPastiKIR() {
        return tunjanganPastiKIR;
    }

    public void setTunjanganPastiKIR(String tunjanganPastiKIR) {
        this.tunjanganPastiKIR = tunjanganPastiKIR;
    }

    public BigDecimal getJumlahTunjanganPastiKIR() {
        return jumlahTunjanganPastiKIR;
    }

    public void setJumlahTunjanganPastiKIR(BigDecimal jumlahTunjanganPastiKIR) {
        this.jumlahTunjanganPastiKIR = jumlahTunjanganPastiKIR;
    }

    public String getTunjanganSSosial() {
        return tunjanganSSosial;
    }

    public void setTunjanganSSosial(String tunjanganSSosial) {
        this.tunjanganSSosial = tunjanganSSosial;
    }

    public BigDecimal getJumlahTunjanganSSosial() {
        return jumlahTunjanganSSosial;
    }

    public void setJumlahTunjanganSSosial(BigDecimal jumlahTunjanganSSosial) {
        this.jumlahTunjanganSSosial = jumlahTunjanganSSosial;
    }

    public BigDecimal getTunjanganKepalaBidang() {
        return tunjanganKepalaBidang;
    }

    public void setTunjanganKepalaBidang(BigDecimal tunjanganKepalaBidang) {
        this.tunjanganKepalaBidang = tunjanganKepalaBidang;
    }

    public BigDecimal getTunjanganStaf() {
        return tunjanganStaf;
    }

    public void setTunjanganStaf(BigDecimal tunjanganStaf) {
        this.tunjanganStaf = tunjanganStaf;
    }

    public BigDecimal getTunjanganSatpam() {
        return tunjanganSatpam;
    }

    public void setTunjanganSatpam(BigDecimal tunjanganSatpam) {
        this.tunjanganSatpam = tunjanganSatpam;
    }

    public BigDecimal getTunjanganPegawaiKebersihan() {
        return tunjanganPegawaiKebersihan;
    }

    public void setTunjanganPegawaiKebersihan(BigDecimal tunjanganPegawaiKebersihan) {
        this.tunjanganPegawaiKebersihan = tunjanganPegawaiKebersihan;
    }

    public BigDecimal getTunjanganTransport() {
        return tunjanganTransport;
    }

    public void setTunjanganTransport(BigDecimal tunjanganTransport) {
        this.tunjanganTransport = tunjanganTransport;
    }

    public BigDecimal getJumlahHonor() {
        return jumlahHonor;
    }

    public void setJumlahHonor(BigDecimal jumlahHonor) {
        this.jumlahHonor = jumlahHonor;
    }

    public TransaksiPenggajianPegawai getTpp() {
        return tpp;
    }

    public void setTpp(TransaksiPenggajianPegawai tpp) {
        this.tpp = tpp;
    }
    
}
