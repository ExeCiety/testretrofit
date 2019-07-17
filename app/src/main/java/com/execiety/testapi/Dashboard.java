package com.execiety.testapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.execiety.testapi.Adapter.Pinjaman.PinjamanAdapter;
import com.execiety.testapi.Model.Login.DataLogin;
import com.execiety.testapi.Model.Login.Login;
import com.execiety.testapi.Model.Pinjaman.DataPinjaman;
import com.execiety.testapi.Model.Pinjaman.Pinjaman;
import com.execiety.testapi.Rest.ApiClient;
import com.execiety.testapi.Rest.ApiInterface;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity implements OnClickListener {

    SharedPrefManager sharedPrefManager;

    ApiInterface mApiInterface;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TextView tv_id_anggota, tv_no_anggota, tv_nama_anggota, tv_nik_anggota;
    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sharedPrefManager = new SharedPrefManager(this);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_pinjaman);

        btn_logout = findViewById(R.id.btn_logout);

        tv_id_anggota = findViewById(R.id.tv_id_anggota);
        tv_no_anggota = findViewById(R.id.tv_no_anggota);
        tv_nama_anggota = findViewById(R.id.tv_nama_anggota);
        tv_nik_anggota = findViewById(R.id.tv_nik_anggota);

        int id_anggota = sharedPrefManager.getSPIdAnggota();
        String no_anggota = sharedPrefManager.getSPNoAnggota();
        String nama_anggota = sharedPrefManager.getSPNamaAnggota();
        String nik_anggota = sharedPrefManager.getSPNIKAnggota();

        tv_id_anggota.setText("Id Anggota : " + id_anggota);
        tv_no_anggota.setText("No Anggota : " + no_anggota);
        tv_nama_anggota.setText("Nama Anggota : " + nama_anggota);
        tv_nik_anggota.setText("NIK Anggota : " + nik_anggota);

        btn_logout.setOnClickListener(this);

        get_pinjaman(id_anggota);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    public void onClick(View v) {
        //Jika Button Logout di Click
        if (v == btn_logout) {
            //Maka Ubah semua nilai session ke default atau kosong
            sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID_ANGGOTA, 0);
            sharedPrefManager.saveSPString(SharedPrefManager.SP_NO_ANGGOTA, "");
            sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA_ANGGOTA, "");
            sharedPrefManager.saveSPString(SharedPrefManager.SP_NIK_ANGGOTA, "");
            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);

            //Lalu Intent ke Menu Login
            startActivity(new Intent(Dashboard.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    //Fungsi buat Ngambil data PinjamanAdapter
    public void get_pinjaman(int id_anggota) {

        //Buat RequestBody dari username, password yg di input user
        RequestBody Rid_anggota = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(id_anggota));

        //inisialisasi kalo kita bakal make api dengan metode yg mana
        Call<Pinjaman> pinjamanCall = mApiInterface.Get_Pinjaman(Rid_anggota);
        //Mencoba untuk menghungi api
        pinjamanCall.enqueue(new Callback<Pinjaman>() {
            @Override
            public void onResponse(Call<Pinjaman> call, Response<Pinjaman>
                    response) {
                if (response.isSuccessful()) {
                    List<DataPinjaman> PinjamanList = response.body().getData();
                    mAdapter = new PinjamanAdapter(PinjamanList);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    Toast.makeText(getApplicationContext(), "Koneksi Error! ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pinjaman> call, Throwable t) {
                Log.e("Error ", t.toString());
            }
        });

    }
}
