/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.entity;

import com.penggajian.render.BigDecimalTableCellRenderer;
import com.penggajian.render.FormatCurencyRenderer;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author MY-IT-STAF
 */
@Entity
public class TabelTunjanganJabatan implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @TableColumn(number = 1, name = "ID")
    private Integer id;
    @TableColumn(number = 2, name = "Jabatan")
    private String jabatan;
    @TableColumn(number = 3, name = "Golongan")
    private String golongan;
    @TableColumn(number = 4, name = "Jumlah Rombengan")
    private String jumlahRombengan;
    @TableColumn(number = 5, name = "Jumlah Tunjangan", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlahTunjangan;
    /*@ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private MasterPegawai mp;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getJumlahRombengan() {
        return jumlahRombengan;
    }

    public void setJumlahRombengan(String jumlahRombengan) {
        this.jumlahRombengan = jumlahRombengan;
    }

    public BigDecimal getJumlahTunjangan() {
        return jumlahTunjangan;
    }

    public void setJumlahTunjangan(BigDecimal jumlahTunjangan) {
        this.jumlahTunjangan = jumlahTunjangan;
    }

    /*public MasterPegawai getMp() {
        return mp;
    }

    public void setMp(MasterPegawai mp) {
        this.mp = mp;
    }*/
    
}
