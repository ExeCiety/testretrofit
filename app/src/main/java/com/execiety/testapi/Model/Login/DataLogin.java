package com.execiety.testapi.Model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
    Ini Model Buat Data Login
    Karena Data Login User array object jadi harus ke list in dulu di Login.java
*/

public class DataLogin {

    //Deklarasi Data Di api login array data

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("no_anggota")
    @Expose
    private String noAnggota;

    @SerializedName("Nama_anggota")
    @Expose
    private String namaAnggota;

    @SerializedName("Nik_anggota")
    @Expose
    private String nikAnggota;

    //Ngambil Data Di array data id di api login
    public Integer getId() {
        return id;
    }

    //Set Data Di array data id di api login
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoAnggota() {
        return noAnggota;
    }

    public void setNoAnggota(String noAnggota) {
        this.noAnggota = noAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getNikAnggota() {
        return nikAnggota;
    }

    public void setNikAnggota(String nikAnggota) {
        this.nikAnggota = nikAnggota;
    }
}
