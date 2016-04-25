package com.mymacz.smartgarden;

import android.os.Handler;
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

    Button btnWater1,btnWater2,btnWater3,btnFeeder;
    TextView tvStatusWater1,tvStatusWater2,tvStatusWater3,tvStatusFeeder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initStatusUpdate();
                handler.postDelayed(this, 1000);
            }
        }, 2000);


        btnWater1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMicrogearApi("water1_ON","nodemcu_1");
            }
        });

        btnWater2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMicrogearApi("water2_ON","nodemcu_2");
            }
        });

        btnWater3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMicrogearApi("water3_ON","nodemcu_3");
            }
        });

        btnFeeder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMicrogearApi("feeder_ON","feeder");
            }
        });
    }

    private void initStatusUpdate() {
        GetStatusWater1(tvStatusWater1);
        GetStatusWater2(tvStatusWater2);
        GetStatusWater3(tvStatusWater3);
        GetStatusFeeder(tvStatusFeeder);
    }


    private void GetStatusWater1(final TextView tv) {
        Call<List<TopicDao>> call = HttpManager.getInstance().getTopicAPI().GetSensor1Status();
        call.enqueue(new Callback<List<TopicDao>>() {
            @Override
            public void onResponse(Call<List<TopicDao>> call, Response<List<TopicDao>> response) {
                if (response.isSuccessful()) {
                    tv.setText(response.body().get(0).getPayload());
                } else {
                    Log.d("ERROR", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<TopicDao>> call, Throwable t) {

            }
        });
    }

    private void GetStatusWater2(final TextView tv) {
        Call<List<TopicDao>> call = HttpManager.getInstance().getTopicAPI().GetSensor2Status();
        call.enqueue(new Callback<List<TopicDao>>() {
            @Override
            public void onResponse(Call<List<TopicDao>> call, Response<List<TopicDao>> response) {
                if (response.isSuccessful()) {
                    tv.setText(response.body().get(0).getPayload());
                } else {
                    Log.d("ERROR", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<TopicDao>> call, Throwable t) {

            }
        });
    }

    private void GetStatusWater3(final TextView tv) {
        Call<List<TopicDao>> call = HttpManager.getInstance().getTopicAPI().GetSensor3Status();
        call.enqueue(new Callback<List<TopicDao>>() {
            @Override
            public void onResponse(Call<List<TopicDao>> call, Response<List<TopicDao>> response) {
                if (response.isSuccessful()) {
                    tv.setText(response.body().get(0).getPayload());
                } else {
                    Log.d("ERROR", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<TopicDao>> call, Throwable t) {

            }
        });

    }

    private void GetStatusFeeder(final TextView tv) {
        Call<List<TopicDao>> call = HttpManager.getInstance().getTopicAPI().GetFeederStatus();
        call.enqueue(new Callback<List<TopicDao>>() {
            @Override
            public void onResponse(Call<List<TopicDao>> call, Response<List<TopicDao>> response) {
                if (response.isSuccessful()) {
                    tv.setText(response.body().get(0).getPayload());
                } else {
                    Log.d("ERROR", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<TopicDao>> call, Throwable t) {

            }
        });
    }

    private void initInstances() {
        btnWater1 = (Button) findViewById(R.id.btnWater1);
        btnWater2 = (Button) findViewById(R.id.btnWater2);
        btnWater3 = (Button) findViewById(R.id.btnWater3);
        btnFeeder = (Button) findViewById(R.id.btnFeeder);

        tvStatusWater1 = (TextView) findViewById(R.id.tvStatusWater1);
        tvStatusWater2 = (TextView) findViewById(R.id.tvStatusWater2);
        tvStatusWater3 = (TextView) findViewById(R.id.tvStatusWater3);
        tvStatusFeeder = (TextView) findViewById(R.id.tvStatusFeeder);
    }

    private void CallMicrogearApi(String status,String gear) {

        RequestBody reqBody = RequestBody.create(MediaType.parse("text/plain"),status);
        if (gear.equals("nodemcu_1")){
            Call<MicrogearDao> call = HttpManager.getInstance().getMicApi().SendToGear2Controller(reqBody);
            call.enqueue(new Callback<MicrogearDao>() {
                @Override
                public void onResponse(Call<MicrogearDao> call, Response<MicrogearDao> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Water1 Success ON", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MicrogearDao> call, Throwable t) {

                }
            });
        }

        if (gear.equals("nodemcu_2")){
            Call<MicrogearDao> call = HttpManager.getInstance().getMicApi().SendToGear1Controller(reqBody);
            call.enqueue(new Callback<MicrogearDao>() {
                @Override
                public void onResponse(Call<MicrogearDao> call, Response<MicrogearDao> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Water2 Status ON", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MicrogearDao> call, Throwable t) {

                }
            });
        }

        if (gear.equals("nodemcu_3")){
            Call<MicrogearDao> call = HttpManager.getInstance().getMicApi().SendToGear3Controller(reqBody);
            call.enqueue(new Callback<MicrogearDao>() {
                @Override
                public void onResponse(Call<MicrogearDao> call, Response<MicrogearDao> response) {
                    Toast.makeText(MainActivity.this, "Water3 Status ON", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<MicrogearDao> call, Throwable t) {

                }
            });
        }

        if (gear.equals("feeder")){
            Call<MicrogearDao> call = HttpManager.getInstance().getMicApi().SendToGear1Controller(reqBody);
            call.enqueue(new Callback<MicrogearDao>() {
                @Override
                public void onResponse(Call<MicrogearDao> call, Response<MicrogearDao> response) {
                    Toast.makeText(MainActivity.this, "Feeder ON", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<MicrogearDao> call, Throwable t) {

                }
            });
        }
    }
}
