package com.mymacz.smartgarden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
