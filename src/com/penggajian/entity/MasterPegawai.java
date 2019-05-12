/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "masterpegawai")//, uniqueConstraints = {@UniqueConstraint(columnNames = {"nama"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MasterPegawai.findAll", query = "SELECT m FROM MasterPegawai m"),
    @NamedQuery(name = "MasterPegawai.findById", query = "SELECT m FROM MasterPegawai m WHERE m.id = :id"),
    @NamedQuery(name = "MasterPegawai.findByNama", query = "SELECT m FROM MasterPegawai m WHERE m.nama = :nama"),
    @NamedQuery(name = "MasterPegawai.findByNip", query = "SELECT m FROM MasterPegawai m WHERE m.nip = :nip"),
    @NamedQuery(name = "MasterPegawai.findByPendidikan", query = "SELECT m FROM MasterPegawai m WHERE m.pendidikan = :pendidikan"),
    @NamedQuery(name = "MasterPegawai.findByStatusSipil", query = "SELECT m FROM MasterPegawai m WHERE m.statusSipil = :statusSipil"),
    @NamedQuery(name = "MasterPegawai.findByStatusKepegawaian", query = "SELECT m FROM MasterPegawai m WHERE m.statusKepegawaian = :statusKepegawaian"),
    @NamedQuery(name = "MasterPegawai.findBySubstatusKepegawaian", query = "SELECT m FROM MasterPegawai m WHERE m.substatusKepegawaian = :substatusKepegawaian"),
    @NamedQuery(name = "MasterPegawai.findByJabatan", query = "SELECT m FROM MasterPegawai m WHERE m.jabatan = :jabatan"),
    //@NamedQuery(name = "MasterPegawai.findByTingkat", query = "SELECT m FROM MasterPegawai m WHERE m.tingkat = :tingkat"),
    @NamedQuery(name = "MasterPegawai.findByGolongan", query = "SELECT m FROM MasterPegawai m WHERE m.golongan = :golongan"),
    @NamedQuery(name = "MasterPegawai.findBySubGolongan", query = "SELECT m FROM MasterPegawai m WHERE m.subGolongan = :subGolongan"),
    //@NamedQuery(name = "MasterPegawai.findByMasaKerja", query = "SELECT m FROM MasterPegawai m WHERE m.masaKerja = :masaKerja"),
    //@NamedQuery(name = "MasterPegawai.findByJenisPenghasilan", query = "SELECT m FROM MasterPegawai m WHERE m.jenisPenghasilan = :jenisPenghasilan")
})
public class MasterPegawai implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //@Basic(optional = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @TableColumn(number = 1, name = "ID", size = 5)
    private Integer id;
    
    @Column(name = "nama")
    @TableColumn(number = 2, name = "Nama", size = 20)
    private String nama;
    
    @Column(name = "nip", unique = true)
    @TableColumn(number = 3, name = "NIP")
    private String nip;
    
    @Column(name = "pendidikan")
    @TableColumn(number = 4, name = "Pendidikan")
    private String pendidikan;
    
    @Column(name = "status_sipil")
    @TableColumn(number = 5, name = "Status Sipil", size = 15)
    private String statusSipil;
    
    @Column(name = "status_kepegawaian")
    @TableColumn(number = 6, name = "Status Kepegawaian", size = 25)
    private String statusKepegawaian;
    
    @Column(name = "sub_status_Kepegawaian")
    @TableColumn(number = 7, name = "Sub Status Kepegawaian", size = 20)
    private String substatusKepegawaian;
    
    @Column(name = "jabatan")
    @TableColumn(number = 8, name = "Jabatan", size = 15)
    private String jabatan;
    
    @Column(name = "tingkat")
    @TableColumn(number = 9, name = "Unit Kerja", size = 25)
    private String unitKerja;
    
    @Column(name = "golongan")
    @TableColumn(number = 10, name = "Golongan", size = 15)
    private String golongan;
    
    @Column(name = "sub_golongan")
    @TableColumn(number = 11, name = "Sub Golongan", size = 15)
    private String subGolongan;
    
    @Column(name = "masa_kerja_golongan")
    @TableColumn(number = 12, name = "MKG (Tahun)", size = 5)
    private String masaKerjaGolongan;
    
    /*@Column(name = "jenis_penghasilan")
    @TableColumn(number = 13, name = "Jenis Penghasilan")
    private String jenisPenghasilan;*/
    
    
    /*@TableColumn(number = 0, name = "NO.")
    private String no;*/

    public MasterPegawai() {
    }

    public MasterPegawai(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getStatusSipil() {
        return statusSipil;
    }

    public void setStatusSipil(String statusSipil) {
        this.statusSipil = statusSipil;
    }

    public String getStatusKepegawaian() {
        return statusKepegawaian;
    }

    public void setStatusKepegawaian(String statusKepegawaian) {
        this.statusKepegawaian = statusKepegawaian;
    }

    public String getSubstatusKepegawaian() {
        return substatusKepegawaian;
    }

    public void setSubstatusKepegawaian(String substatusKepegawaian) {
        this.substatusKepegawaian = substatusKepegawaian;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUnitKerja() {
        return unitKerja;
    }

    public void setUnitKerja(String tingkat) {
        this.unitKerja = tingkat;
    }

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

    public void setMasaKerjaGolongan(String masaKerja) {
        this.masaKerjaGolongan = masaKerja;
    }

    /*public String getJenisPenghasilan() {
        return jenisPenghasilan;
    }

    public void setJenisPenghasilan(String jenisPenghasilan) {
        this.jenisPenghasilan = jenisPenghasilan;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterPegawai)) {
            return false;
        }
        MasterPegawai other = (MasterPegawai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.penggajian.model.master.MasterPegawai[ id=" + id + " ]";
    }
    
    public Object getObject(int index){
        switch(index){
            case 0: return getNama();
            case 1: return getNip();
            case 2: return getPendidikan();
            case 3: return getStatusSipil();
            case 4: return getStatusKepegawaian();
            case 5: return getSubstatusKepegawaian();
            case 6: return getJabatan();
            case 7: return getUnitKerja();
            case 8: return getGolongan();
            case 9: return getSubGolongan();
            case 10: return getMasaKerjaGolongan();
            //case 11: return getJenisPenghasilan();
            default:return null;
        }
    }
}
