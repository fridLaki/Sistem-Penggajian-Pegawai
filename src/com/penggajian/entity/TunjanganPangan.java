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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author MY-IT-STAF
 */
@Entity
public class TunjanganPangan implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Jumlah tunjangan Rp. 25.000 /jiwa
     */
    @TableColumn(number = 0, name = "JumlahTunjangan (25/Jiwa)", renderer=BigDecimalTableCellRenderer.class)
    private long jumlahTunjangan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getJumlahTunjangan() {
        return jumlahTunjangan;
    }

    public void setJumlahTunjangan(long jumlahTunjangan) {
        this.jumlahTunjangan = jumlahTunjangan;
    }
    
}
