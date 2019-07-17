package com.execiety.testapi;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_MAHASISWA_APP = "AplikasiKoperasi";

    public static final String SP_ID_ANGGOTA = "id_anggota";
    public static final String SP_NO_ANGGOTA = "no_anggota";
    public static final String SP_NAMA_ANGGOTA = "nama_anggota";
    public static final String SP_NIK_ANGGOTA = "nik_anggota";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_MAHASISWA_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public int getSPIdAnggota(){
        return sp.getInt(SP_ID_ANGGOTA, 0);
    }

    public String getSPNoAnggota(){
        return sp.getString(SP_NO_ANGGOTA, "");
    }

    public String getSPNamaAnggota(){
        return sp.getString(SP_NAMA_ANGGOTA, "");
    }

    public String getSPNIKAnggota(){
        return sp.getString(SP_NIK_ANGGOTA, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
