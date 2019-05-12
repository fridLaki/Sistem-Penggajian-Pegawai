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
public class TunjanganKeluarga implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @TableColumn(number = 1, name = "ID", size=5)
    private Integer id;
    @TableColumn(number = 2, name = "Istri (10%)", renderer=BigDecimalTableCellRenderer.class)
    private long istri;
    @TableColumn(number = 3, name = "Anak (2%/Jiwa)", renderer=BigDecimalTableCellRenderer.class)
    private long anak;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getIstri() {
        return istri;
    }

    public void setIstri(long istri) {
        this.istri = istri;
    }

    public long getAnak() {
        return anak;
    }

    public void setAnak(long anak) {
        this.anak = anak;
    }
}
