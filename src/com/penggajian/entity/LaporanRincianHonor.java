/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penggajian.entity;

import java.math.BigDecimal;

/**
 *
 * @author MY-IT-STAF
 */
public class LaporanRincianHonor {
    private String nama;
    private String kepeg;
    private BigDecimal pokokHonor;
    private BigDecimal tunjanganKaBid;
    private BigDecimal tunjanganStaf;
    private BigDecimal tunjanganSatpam;
    private BigDecimal tunjanganPegKebersihan;
    private BigDecimal tunjanganTransport;
    private BigDecimal jumlahHonor;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKepeg() {
        return kepeg;
    }

    public void setKepeg(String kepeg) {
        this.kepeg = kepeg;
    }

    public BigDecimal getPokokHonor() {
        return pokokHonor;
    }

    public void setPokokHonor(BigDecimal pokokHonor) {
        this.pokokHonor = pokokHonor;
    }

    public BigDecimal getTunjanganKaBid() {
        return tunjanganKaBid;
    }

    public void setTunjanganKaBid(BigDecimal tunjanganKaBid) {
        this.tunjanganKaBid = tunjanganKaBid;
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

    public BigDecimal getTunjanganPegKebersihan() {
        return tunjanganPegKebersihan;
    }

    public void setTunjanganPegKebersihan(BigDecimal tunjanganPegKebersihan) {
        this.tunjanganPegKebersihan = tunjanganPegKebersihan;
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
    
}
