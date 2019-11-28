package com.example.minggu12;

import com.example.minggu12.Model.Dosen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface DataDosenService {
    @GET("/api/progmob/dosen/{nim_progmob}")
    Call<List<Dosen>> getDosenALL
            (@Path("nim_progmob") String nimProgmob);
}



