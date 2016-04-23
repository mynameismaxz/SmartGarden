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

    Button btnWater1,btnWater2,btnWater3,btnFeeder;
    TextView tvStatusWater1,tvStatusWater2,tvStatusWater3,tvStatusFeeder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
        getMicrogearStatusWithTopic(tvStatusWater1,"nodemcu_1");

        btnWater1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMicrogearApi("ON","nodemcu_1");
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

    private void getMicrogearStatusWithTopic(final TextView tv, String nodestatus) {
        if (nodestatus.equals("nodemcu_1")){
            Call<List<TopicDao>> call = HttpManager.getInstance().getTopicNodeMCU1().getTopicNodeMCU1();
            call.enqueue(new Callback<List<TopicDao>>() {
                @Override
                public void onResponse(Call<List<TopicDao>> call, Response<List<TopicDao>> response) {
                    if (response.isSuccessful()){
                        tv.setText(response.body().get(0).getPayload());
                    } else {
                        Log.d("error",response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<TopicDao>> call, Throwable t) {

                }
            });
        }
//        Call<List<TopicDao>> call = HttpManager.getInstance().getTopicAPI().GetGearStatus();
//        call.enqueue(new Callback<List<TopicDao>>() {
//            @Override
//            public void onResponse(Call<List<TopicDao>> call, Response<List<TopicDao>> response) {
//                if (response.isSuccessful()) {
//                    Log.d("response", response.body().get(0).getPayload());
//                    tv.setText("Status: " + response.body().get(0).getPayload());
//                } else {
//                    Log.d("Error", "error fetch data" + response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<TopicDao>> call, Throwable t) {
//                Log.d("Error", "error fetch data" + t.toString());
//            }
//        });
    }

    private void CallMicrogearApi(String status,String gear) {
        RequestBody reqBody = RequestBody.create(MediaType.parse("text/plain"),status);
        if (gear.equals("nodemcu_1")){
            Call<MicrogearDao> call = HttpManager.getInstance().getMicApi().SendToGear2Controller(reqBody);
            call.enqueue(new Callback<MicrogearDao>() {
                @Override
                public void onResponse(Call<MicrogearDao> call, Response<MicrogearDao> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Water1 Success", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MicrogearDao> call, Throwable t) {

                }
            });
        }

        if (gear == String.valueOf("nodemcu_2")){
            // TODO : Later for mcu 2
        }

//        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),status);
//        Call<MicrogearDao> call = HttpManager.getInstance().getMicApi().SendToGearController(requestBody);
//        call.enqueue(new Callback<MicrogearDao>() {
//            @Override
//            public void onResponse(Call<MicrogearDao> call, Response<MicrogearDao> response) {
//                if (response.isSuccessful()){
//                    // if success
//                    Toast.makeText(MainActivity.this, "PUT Successful", Toast.LENGTH_SHORT).show();
//                } else {
//                    // if fail
//                    Toast.makeText(MainActivity.this, "FUCK", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MicrogearDao> call, Throwable t) {
//
//            }
//        });
    }
}
