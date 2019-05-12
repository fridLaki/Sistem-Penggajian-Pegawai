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
public class TunjanganFungsional implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @TableColumn(number = 1, name = "ID",size = 5)
    private Integer id;
    @TableColumn(number = 2, name = "Jabatan",size = 20)
    private String jabatan;
    @TableColumn(number = 3, name = "Golongan",size = 15)
    private String golongan;
    @TableColumn(number = 4, name = "Jumlah Tunjangan",size = 15, renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlahTunjangan;

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

    public BigDecimal getJumlahTunjangan() {
        return jumlahTunjangan;
    }

    public void setJumlahTunjangan(BigDecimal jumlahTunjangan) {
        this.jumlahTunjangan = jumlahTunjangan;
    }
    
}
