package com.pahlawancoding.jadwalsholat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.pahlawancoding.jadwalsholat.R;
import com.pahlawancoding.jadwalsholat.adapter.CityListAdapter;
import com.pahlawancoding.jadwalsholat.listener.OnClickCityListener;
import com.pahlawancoding.jadwalsholat.model.ResponseCityModel;
import com.pahlawancoding.jadwalsholat.retrofit.JadwalSholatService;
import com.pahlawancoding.jadwalsholat.retrofit.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class JadwalActivity extends AppCompatActivity implements OnClickCityListener {

    private CityListAdapter cityListAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        recyclerView = (RecyclerView) findViewById(R.id.list_city);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        JadwalSholatService mApiInterface = RetrofitUtils.getClient().create(JadwalSholatService.class);

        Call<ResponseCityModel> cityListCall = mApiInterface.getListCity();
        cityListCall.enqueue(new Callback<ResponseCityModel>() {
            @Override
            public void onResponse(Call<ResponseCityModel> call, Response<ResponseCityModel> response) {

                // specify an adapter (see also next example)
                cityListAdapter = new CityListAdapter(response.body().getKota());
                recyclerView.setAdapter(cityListAdapter);
                cityListAdapter.setCityClickListener(JadwalActivity.this);
            }

            @Override
            public void onFailure(Call<ResponseCityModel> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


    @Override
    public void onCityClicked(String id, String name) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("city_id",id); /* melempar data ke Detail Activity */
        intent.putExtra("city_name", name);
        startActivity(intent);
    }
}
