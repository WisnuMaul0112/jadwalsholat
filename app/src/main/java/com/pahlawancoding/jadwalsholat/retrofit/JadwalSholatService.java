package com.pahlawancoding.jadwalsholat.retrofit;

import com.pahlawancoding.jadwalsholat.model.ResponseCityModel;
import com.pahlawancoding.jadwalsholat.model.ResponseDetailModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JadwalSholatService {
    @GET("/sholat/format/json/kota")
    Call<ResponseCityModel> getListCity();

    @GET("/sholat/format/json/jadwal/kota/{cityId}/tanggal/{date}")
    Call<ResponseDetailModel> getJadwalSholat(@Path("cityId") String cityId, @Path("date") String date);
}
