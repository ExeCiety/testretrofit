package com.execiety.testapi.Model.Pinjaman;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPinjaman {
    @SerializedName("Idpinjaman")
    @Expose
    private Integer idpinjaman;
    @SerializedName("Nama_anggota")
    @Expose
    private String namaAnggota;
    @SerializedName("No_anggota")
    @Expose
    private String noAnggota;
    @SerializedName("NIK_anggota")
    @Expose
    private String nIKAnggota;
    @SerializedName("No_pinjaman")
    @Expose
    private String noPinjaman;
    @SerializedName("Jenis_pinjaman")
    @Expose
    private String jenisPinjaman;
    @SerializedName("Total_Tagihan")
    @Expose
    private Integer totalTagihan;
    @SerializedName("Total_Terbayar")
    @Expose
    private Integer totalTerbayar;
    @SerializedName("Total_Sisa")
    @Expose
    private Integer totalSisa;
    @SerializedName("Jatuh_tempo")
    @Expose
    private Object jatuhTempo;

    public Integer getIdpinjaman() {
        return idpinjaman;
    }

    public void setIdpinjaman(Integer idpinjaman) {
        this.idpinjaman = idpinjaman;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getNoAnggota() {
        return noAnggota;
    }

    public void setNoAnggota(String noAnggota) {
        this.noAnggota = noAnggota;
    }

    public String getNIKAnggota() {
        return nIKAnggota;
    }

    public void setNIKAnggota(String nIKAnggota) {
        this.nIKAnggota = nIKAnggota;
    }

    public String getNoPinjaman() {
        return noPinjaman;
    }

    public void setNoPinjaman(String noPinjaman) {
        this.noPinjaman = noPinjaman;
    }

    public String getJenisPinjaman() {
        return jenisPinjaman;
    }

    public void setJenisPinjaman(String jenisPinjaman) {
        this.jenisPinjaman = jenisPinjaman;
    }

    public Integer getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(Integer totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public Integer getTotalTerbayar() {
        return totalTerbayar;
    }

    public void setTotalTerbayar(Integer totalTerbayar) {
        this.totalTerbayar = totalTerbayar;
    }

    public Integer getTotalSisa() {
        return totalSisa;
    }

    public void setTotalSisa(Integer totalSisa) {
        this.totalSisa = totalSisa;
    }

    public Object getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Object jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }
}
