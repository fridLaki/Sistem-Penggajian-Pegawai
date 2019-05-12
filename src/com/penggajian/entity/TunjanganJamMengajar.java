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
public class TunjanganJamMengajar implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @TableColumn(number = 1, name = "ID", size = 5)
    private Integer id;
    @TableColumn(number = 2, name = "Status Kepegawaian", size = 30)
    private String statusKepegawaian;
    @TableColumn(number = 3, name = "Unit Kerja", size = 5)
    private String unitKerja;
    @TableColumn(number = 4, name = "Jumlah Rombongan Belajar", size = 20)
    private String jumlahRombonganBelajar;
    @TableColumn(number = 5, name = "Jumlah Tunjangan", size = 5, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlahTunjangan;

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

    public String getUnitKerja() {
        return unitKerja;
    }

    public void setUnitKerja(String unitKerja) {
        this.unitKerja = unitKerja;
    }

    public String getJumlahRombonganBelajar() {
        return jumlahRombonganBelajar;
    }

    public void setJumlahRombonganBelajar(String jumlahRombonganBelajar) {
        this.jumlahRombonganBelajar = jumlahRombonganBelajar;
    }

    public BigDecimal getJumlahTunjangan() {
        return jumlahTunjangan;
    }

    public void setJumlahTunjangan(BigDecimal jumlahTunjangan) {
        this.jumlahTunjangan = jumlahTunjangan;
    }
    
}
