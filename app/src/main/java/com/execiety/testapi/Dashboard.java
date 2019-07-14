package com.execiety.testapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private TextView tv_id_anggota, tv_no_anggota, tv_nama_anggota, tv_nik_anggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tv_id_anggota = findViewById(R.id.tv_id_anggota);
        tv_no_anggota = findViewById(R.id.tv_no_anggota);
        tv_nama_anggota = findViewById(R.id.tv_nama_anggota);
        tv_nik_anggota = findViewById(R.id.tv_nik_anggota);

        String id_anggota = getIntent().getExtras().getString("id_anggota");
        String no_anggota = getIntent().getExtras().getString("no_anggota");
        String nama_anggota = getIntent().getExtras().getString("nama_anggota");
        String nik_anggota = getIntent().getExtras().getString("nik_anggota");

        tv_id_anggota.setText("Id Anggota : " + id_anggota);
        tv_no_anggota.setText("No Anggota : " + no_anggota);
        tv_nama_anggota.setText("Nama Anggota : " + nama_anggota);
        tv_nik_anggota.setText("NIK Anggota : " + nik_anggota);

    }
}
