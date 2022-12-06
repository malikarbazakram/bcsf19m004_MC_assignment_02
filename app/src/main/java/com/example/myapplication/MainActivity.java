package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSearch;
    EditText surah, ayat;
    TextView display;

    QDH qdh;
    QuranArabicText quranArabicText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qdh = new QDH();
        quranArabicText = new QuranArabicText();

        display = findViewById(R.id.disp);
        btnSearch = findViewById(R.id.btnSearch);
        surah = findViewById(R.id.txtSurah);
        ayat = findViewById(R.id.txtAyat);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("=============================================================");
                display.setText(
                        quranArabicText.QuranArabicText[
                                (qdh.SSP[Integer.parseInt(surah.getText().toString()) - 1]
                                        + Integer.parseInt(ayat.getText().toString())) - 1
                                ]
                );
            }
        });

    }
}