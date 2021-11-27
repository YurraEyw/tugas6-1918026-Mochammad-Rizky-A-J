package com.example.tugas_prak6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText panjang =
                (EditText)findViewById(R.id.input_p);
        final EditText lebar =
                (EditText)findViewById(R.id.input_l);
        final TextView hasilLuas =
                (TextView) findViewById(R.id.output_hasil);
        final Button btnhitung =
                (Button) findViewById(R.id.btn_hitung);


        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        findViewById(R.id.btn_hitung).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueueUniqueWork("Notifikasi", ExistingWorkPolicy.REPLACE, request);
                double p,l, hasil;
                p = Double.valueOf(panjang.getText().toString());
                l = Double.valueOf(lebar.getText().toString());

                hasil = p * l;
                String hasil1 = String.valueOf(hasil);
                hasilLuas.setText(hasil1);
            }

        });
    }
}