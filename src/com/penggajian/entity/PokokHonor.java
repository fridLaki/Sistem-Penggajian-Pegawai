/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.entity;

import com.penggajian.render.BigDecimalTableCellRenderer;
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
public class PokokHonor implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)  
    @TableColumn(number = 1, name = "ID", size = 10)
    private Integer id;
    
    @TableColumn(number = 2, name = "Status Kepegawaian", size = 25)
    private String statusKepegawaian;
    
    @TableColumn(number = 4, name = "Pendidikan", size = 20)
    private String pendidikan;
    
    @TableColumn(number = 3, name = "Sub Status Kepegawaian", size = 25)
    private String subStatusKepegawaian;
    
    @TableColumn(number = 5, name = "Jumlah", renderer = BigDecimalTableCellRenderer.class)
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

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getSubStatusKepegawaian() {
        return subStatusKepegawaian;
    }

    public void setSubStatusKepegawaian(String jabatan) {
        this.subStatusKepegawaian = jabatan;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }
    
}
