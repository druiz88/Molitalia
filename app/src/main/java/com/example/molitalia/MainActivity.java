package com.example.molitalia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        final EditText et = findViewById(R.id.editText);
        final TextView tv1 = findViewById(R.id.textView1);
        final TextView tv2 = findViewById(R.id.textView2);

        readMolitaliaData();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = molitaliaSamples.size();
                for(int i=0; i<len; i++) {
                    if (String.valueOf(molitaliaSamples.get(i).getCode()).equals(et.getText().toString())) {
                        tv1.setText(molitaliaSamples.get(i).getText());
                        tv2.setText(String.valueOf(molitaliaSamples.get(i).getPal()));
                    }
                }
            }
        });
    }

    private List<MolitaliaSample> molitaliaSamples = new ArrayList<>();


    private void readMolitaliaData() {
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";

        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                MolitaliaSample sample = new MolitaliaSample();
                sample.setCode(Integer.parseInt(tokens[0]));
                sample.setText(tokens[1]);
                sample.setPal(Integer.parseInt(tokens[2]));
                molitaliaSamples.add(sample);

                Log.d("MyActivity", "Just Created: " + sample);

            }
        } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
