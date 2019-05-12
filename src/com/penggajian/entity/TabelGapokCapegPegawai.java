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

/**
 *
 * @author MY-IT-STAF
 */
@Entity
public class TabelGapokCapegPegawai implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @TableColumn(number = 1, name = "ID", size = 5)
    private Integer id;
    @TableColumn(number = 2, name = "Status Kepegawaian", size = 30)
    private String statusKepegawaian;
    /*@TableColumn(number = 3, name = "Jabatan")
    private String jabatan;*/
    @TableColumn(number = 2, name = "Golongan", size = 10)
    private String golongan;
    @TableColumn(number = 3, name = "Sub Golongan", size = 15)
    private String subGolongan;
    @TableColumn(number = 4, name = "Masa Kerja Golongan", size = 20)
    private String masaKerjaGolongan;
    @TableColumn(number = 5, name = "Jumlah", size = 30, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlah;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusKepegawaian() {
        return statusKepegawaian;
    }

    public void setStatusKepegawaian(String statusKepegawaian) {
        this.statusKepegawaian = statusKepegawaian;
    }

    /*public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }*/

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getSubGolongan() {
        return subGolongan;
    }

    public void setSubGolongan(String subGolongan) {
        this.subGolongan = subGolongan;
    }

    public String getMasaKerjaGolongan() {
        return masaKerjaGolongan;
    }

    public void setMasaKerjaGolongan(String masaKerjaGuru) {
        this.masaKerjaGolongan = masaKerjaGuru;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }
    
}
