package com.mymacz.smartgarden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnOn,btnOff;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOn = (Button) findViewById(R.id.btnOn);
        btnOff = (Button) findViewById(R.id.btnOff);
        tvStatus = (TextView) findViewById(R.id.status);

        getMicrogearStatusWithTopic();

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMicrogearApi("ON");
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMicrogearApi("OFF");
            }
        });
    }

    private void getMicrogearStatusWithTopic() {
        Call<List<TopicDao>> call = HttpManager.getInstance().getTopicAPI().GetGearStatus();
        call.enqueue(new Callback<List<TopicDao>>() {
            @Override
            public void onResponse(Call<List<TopicDao>> call, Response<List<TopicDao>> response) {
                if (response.isSuccessful()) {
                    Log.d("response", response.body().get(0).getPayload());
                    tvStatus.setText("Status: " + response.body().get(0).getPayload());
                } else {
                    Log.d("Error", "error fetch data" + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<TopicDao>> call, Throwable t) {
                Log.d("Error", "error fetch data" + t.toString());
            }
        });
    }

    private void CallMicrogearApi(String status) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),status);
        Call<MicrogearDao> call = HttpManager.getInstance().getMicApi().SendToGearController(requestBody);
        call.enqueue(new Callback<MicrogearDao>() {
            @Override
            public void onResponse(Call<MicrogearDao> call, Response<MicrogearDao> response) {
                if (response.isSuccessful()){
                    // if success
                    Toast.makeText(MainActivity.this, "PUT Successful", Toast.LENGTH_SHORT).show();
                } else {
                    // if fail
                    Toast.makeText(MainActivity.this, "FUCK", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MicrogearDao> call, Throwable t) {

            }
        });
    }
}
