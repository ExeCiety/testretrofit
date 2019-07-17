package com.execiety.testapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Model
import com.execiety.testapi.Model.Login.DataLogin;
import com.execiety.testapi.Model.Login.Login;

//Rest
import com.execiety.testapi.Rest.ApiClient;
import com.execiety.testapi.Rest.ApiInterface;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    SharedPrefManager sharedPrefManager;

    ApiInterface mApiInterface;

    private EditText et_username, et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefManager = new SharedPrefManager(this);
        check_login();

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == btn_login) {
            String username, password;

            username = et_username.getText().toString();
            password = et_password.getText().toString();

            if (!(username.equals("") || password.equals(""))) {
                check_user(username, password);
            } else {
                Toast.makeText(getApplicationContext(), "Username Atau Password Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void check_login() {
        if (sharedPrefManager.getSPSudahLogin() == true){
            startActivity(new Intent(MainActivity.this, Dashboard.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    public void check_user(String username, String password) {

        //Buat RequestBody dari username, password yg di input user
        RequestBody Rusername = RequestBody.create(MediaType.parse("text/plain"), username);
        RequestBody Rpassword = RequestBody.create(MediaType.parse("text/plain"), password);

        //inisialisasi kalo kita bakal make api dengan metode yg mana
        Call<Login> loginCall = mApiInterface.Login_User(Rusername, Rpassword);
        //Mencoba untuk menghungi api
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login>
                    response) {
                if (response.isSuccessful()) {
                    int status;
                    boolean error;
                    String message;
                    String[] data_login = new String[4];

                    //Ngambil data dari api
                    List<DataLogin> DataLogin = response.body().getData();
                    status = response.body().getStatus();
                    error = response.body().getError();
                    message = response.body().getMessage();

                    data_login[0] = DataLogin.get(0).getId().toString();
                    data_login[1] = DataLogin.get(0).getNoAnggota();
                    data_login[2] = DataLogin.get(0).getNamaAnggota();
                    data_login[3] = DataLogin.get(0).getNikAnggota();

                    if (status == 200 && error == false) {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                        Intent dashboard = new Intent(MainActivity.this, Dashboard.class);

                        sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID_ANGGOTA, Integer.parseInt(data_login[0]));
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_NO_ANGGOTA, data_login[1]);
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA_ANGGOTA, data_login[2]);
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_NIK_ANGGOTA, data_login[3]);
                        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);

                        startActivity(dashboard);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Koneksi Error!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.e("Error ", t.toString());
            }
        });

    }
}
