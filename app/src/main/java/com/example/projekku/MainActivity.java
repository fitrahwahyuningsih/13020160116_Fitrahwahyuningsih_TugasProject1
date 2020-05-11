package com.example.projekku;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText LA,T;
    Button Hitung;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LA = (EditText)findViewById(R.id.txt_alas);
        T = (EditText)findViewById(R.id.txt_tinggi);
        Hitung = (Button) findViewById(R.id.button);
        Hasil = (TextView) findViewById(R.id.txt_hasil);

        Hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LA.length()==0 && T.length()==0){
                    Toast.makeText(getApplication(),"Alas Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(T.length()==0){
                    Toast.makeText(getApplication(),"Tinggi Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(LA.length()==0){
                    Toast.makeText(getApplication(),"Luas Alas Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else{
                    String isialas = LA.getText().toString();
                    String isitinggi = T.getText().toString();

                    double LA = Double.parseDouble(isialas);
                    double T = Double.parseDouble(isitinggi);
                    double vl = VolumeLimas(LA,T);

                    String output = String.valueOf(vl);
                    Hasil.setText(output.toString());
                }
            }
        });
    }
    public double VolumeLimas(double LA, double T){
        return (LA*LA)*T/3;
    }
}
