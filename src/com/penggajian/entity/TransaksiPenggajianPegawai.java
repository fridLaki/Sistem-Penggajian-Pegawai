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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author MY-IT-STAF
 */
@Entity
public class TransaksiPenggajianPegawai implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @TableColumn(number = 1, name = "No Transaksi")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "pegawai_id")
    @TableColumn(number = 2, name = "NIP", renderer = PegawaiTableCellRenderer.class)
    private MasterPegawai mp;
    @TableColumn(number = 3, name = "Nama", renderer = PegawaiTableCellRenderer.class, size = 25)
    private String namaPeg; 
    @TableColumn(number = 4, name = "Gaji Pokok", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal gapok = BigDecimal.ZERO;
    @TableColumn(number = 5, name = "Tunjangan Keluarga", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganKeluarga = BigDecimal.ZERO;
    @TableColumn(number = 6, name = "Tunj. Jabatan", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganJabatan = BigDecimal.ZERO;
    @TableColumn(number = 7, name = "Tunj. Fungsional", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganFungsional = BigDecimal.ZERO;
    @TableColumn(number = 8, name = "Tunjangan Pangan", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganPangan = BigDecimal.ZERO;
    @TableColumn(number = 9, name = "Tunjangan Honor", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal tunjanganHonor = BigDecimal.ZERO;
    @TableColumn(number = 10, name = "Jumlah Tunjangan", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlahTunjangan = BigDecimal.ZERO;
    @TableColumn(number = 11, name = "Penghasilan Bruto", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal penghasilanBruto = BigDecimal.ZERO;
    @TableColumn(number = 12, name = "Pengurangan Siswa (10%", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal penguranganSiswa = BigDecimal.ZERO;
    @TableColumn(number = 13, name = "Pengurangan Jabatan (5%)", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal penguranganJabatan = BigDecimal.ZERO;
    @TableColumn(number = 14, name = "Jumlah Pengurangan", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlahPengurangan = BigDecimal.ZERO;
    @TableColumn(number = 15, name = "Penghasilan Neto", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal penghasilanNeto = BigDecimal.ZERO;
    @TableColumn(number = 16, name = "PTKP", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal PTKP = BigDecimal.ZERO;
    @TableColumn(number = 17, name = "PKP", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal PKP = BigDecimal.ZERO;
    @TableColumn(number = 18, name = "PPh Psl. 21", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal PPhPsl21 = BigDecimal.ZERO;
    @TableColumn(number = 19, name = "Jumlah Potongan", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal jumlahPotongan = BigDecimal.ZERO;
    @TableColumn(number = 20, name = "Terima", renderer = BigDecimalTableCellRenderer.class)
    private BigDecimal terima = BigDecimal.ZERO;
    //@TableColumn(number = 20, name = "Terima", renderer = BigDecimalTableCellRenderer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bulan;
    @OneToMany(mappedBy = "tpp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailPerincianHonor> daftarRincianHonor = new ArrayList<>();

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

    public String getNamaPeg() {
        return namaPeg;
    }

    public void setNamaPeg(String namaPeg) {
        this.namaPeg = namaPeg;
    }

    public BigDecimal getGapok() {
        return gapok;
    }

    public void setGapok(BigDecimal gapok) {
        this.gapok = gapok;
    }

    public BigDecimal getTunjanganKeluarga() {
        return tunjanganKeluarga;
    }

    public void setTunjanganKeluarga(BigDecimal tunjanganKeluarga) {
        this.tunjanganKeluarga = tunjanganKeluarga;
    }

    public BigDecimal getTunjanganJabatan() {
        return tunjanganJabatan;
    }

    public void setTunjanganJabatan(BigDecimal tunjanganJabatan) {
        this.tunjanganJabatan = tunjanganJabatan;
    }

    public BigDecimal getTunjanganFungsional() {
        return tunjanganFungsional;
    }

    public void setTunjanganFungsional(BigDecimal tunjanganFungsional) {
        this.tunjanganFungsional = tunjanganFungsional;
    }

    public BigDecimal getTunjanganPangan() {
        return tunjanganPangan;
    }

    public void setTunjanganPangan(BigDecimal tunjanganPangan) {
        this.tunjanganPangan = tunjanganPangan;
    }

    public BigDecimal getTunjanganHonor() {
        return tunjanganHonor;
    }

    public void setTunjanganHonor(BigDecimal tunjanganHonor) {
        this.tunjanganHonor = tunjanganHonor;
    }

    public BigDecimal getJumlahTunjangan() {
        return jumlahTunjangan;
    }

    public void setJumlahTunjangan(BigDecimal jumlahTunjangan) {
        this.jumlahTunjangan = jumlahTunjangan;
    }

    public BigDecimal getPenghasilanBruto() {
        return penghasilanBruto;
    }

    public void setPenghasilanBruto(BigDecimal penghasilanBruto) {
        this.penghasilanBruto = penghasilanBruto;
    }

    public BigDecimal getPenguranganSiswa() {
        return penguranganSiswa;
    }

    public void setPenguranganSiswa(BigDecimal penguranganSiswa) {
        this.penguranganSiswa = penguranganSiswa;
    }

    public BigDecimal getPenguranganJabatan() {
        return penguranganJabatan;
    }

    public void setPenguranganJabatan(BigDecimal penguranganJabatan) {
        this.penguranganJabatan = penguranganJabatan;
    }

    public BigDecimal getJumlahPengurangan() {
        return jumlahPengurangan;
    }

    public void setJumlahPengurangan(BigDecimal jumlahPengurangan) {
        this.jumlahPengurangan = jumlahPengurangan;
    }

    public BigDecimal getPenghasilanNeto() {
        return penghasilanNeto;
    }

    public void setPenghasilanNeto(BigDecimal penghasilanNeto) {
        this.penghasilanNeto = penghasilanNeto;
    }

    public BigDecimal getPTKP() {
        return PTKP;
    }

    public void setPTKP(BigDecimal PTKP) {
        this.PTKP = PTKP;
    }

    public BigDecimal getPKP() {
        return PKP;
    }

    public void setPKP(BigDecimal PKP) {
        this.PKP = PKP;
    }

    public BigDecimal getPPhPsl21() {
        return PPhPsl21;
    }

    public void setPPhPsl21(BigDecimal PPhPsl21) {
        this.PPhPsl21 = PPhPsl21;
    }

    public BigDecimal getJumlahPotongan() {
        return jumlahPotongan;
    }

    public void setJumlahPotongan(BigDecimal jumlahPotongan) {
        this.jumlahPotongan = jumlahPotongan;
    }

    public BigDecimal getTerima() {
        return terima;
    }

    public void setTerima(BigDecimal terima) {
        this.terima = terima;
    }

    public Date getBulan() {
        return bulan;
    }

    public void setBulan(Date bulan) {
        this.bulan = bulan;
    }

    public List<DetailPerincianHonor> getDaftarRincianHonor() {
        return daftarRincianHonor;
    }

    public void setDaftarRincianHonor(List<DetailPerincianHonor> daftarRincianHonor) {
        this.daftarRincianHonor = daftarRincianHonor;
    }
    
    public void tambahDaftarTransaksiPenggajian(DetailPerincianHonor detailPerincianHonor) {
        detailPerincianHonor.setTpp(this);
        daftarRincianHonor.add(detailPerincianHonor);
    }

    public void hapusDaftarPenjualan(DetailPerincianHonor detailPerincianHonor) {
        detailPerincianHonor.setTpp(null);
        daftarRincianHonor.remove(detailPerincianHonor);
    }
}
