package com.example.minggu12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.minggu12.Model.Dosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    DataDosenService dataDosenService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        insertDosen();
    }
    private void insertDosen() {
        DataDosenService service = RetrofitClient.getRetrofitInstance().create(dataDosenService.getClass());
        Call<DefaultResult> call = service.insertDosen("adrian", "007", "jogja", "SUPER", "ad.jpg", "2" );
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                System.out.println(response.body().getStatus());
            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                System.out.println("message: " +t.getMessage());
                Toast.makeText(MainActivity.this, "Something went wrong.. Please try later!", Toast.LENGTH_LONG).show();
            }
        });
    }

//    private void updateDosen() {
//        DataDosenService service = RetrofitClient.getRetrofitInstance().update(dataDosenService.getClass());
//        Call<DefaultResult> call = service.insertDosen("Dendy", "001", "jogja", "SSD", "ad.jpg", "1" );
//        call.enqueue(new Callback<DefaultResult>() {
//            @Override
//            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
//                System.out.println(response.body().getStatus());
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResult> call, Throwable t) {
//                System.out.println("message: " +t.getMessage());
//                Toast.makeText(MainActivity.this, "Something went wrong.. Please try later!", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//    }
    private void getAllDataDosen()
    {
        Call<List<Dosen>> call = dataDosenService.getDosenALL("1");
        call.enqueue(new Callback<List<Dosen>>() {
            @Override
            public void onResponse(Call<List<Dosen>> call, Response<List<Dosen>> response) {

                for (Dosen dosen:response.body())
                {
                    System.out.println("Nama : "+dosen.getNama());
                    System.out.println("NIDN : "+dosen.getNidn());

                }
            }

            @Override
            public void onFailure(Call<List<Dosen>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                "somenthing wrong...",
                Toast.LENGTH_LONG).show();
                System.out.println(t.getMessage());
            }
        });
    }
}
