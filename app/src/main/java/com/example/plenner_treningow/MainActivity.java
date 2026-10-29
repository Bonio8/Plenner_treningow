package com.example.plenner_treningow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView LSerii;
    private Button ButtonClickPlus;
    private Button ButtonClickMinus;
    private Button ButtonClickReset;
    private TextView NazwaCw;
    private TextView LacznaLSerii;
    private ImageView ZdjCwicen;
    private Button ButtonClickLosuj;
    private Button NastempneCwiczenie;
    private int counter = 0;
    private int lacznaLS = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LSerii = findViewById(R.id.liczbaSerii);
        ButtonClickPlus = findViewById(R.id.zwieksz);
        ButtonClickMinus = findViewById(R.id.zmniejsz);
        ButtonClickReset = findViewById(R.id.reset);
        NazwaCw = findViewById(R.id.NazwaCwicenia);
        LacznaLSerii = findViewById(R.id.LacznaLiczbaSerii);
        ZdjCwicen = findViewById(R.id.cwiczeniaZdj);
        ButtonClickLosuj = findViewById(R.id.losCwiczenie);
        NastempneCwiczenie = findViewById(R.id.nastCwicz);

        ButtonClickPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                LSerii.setText("" + counter);
            }
        });

        ButtonClickMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter > 0){
                counter--;
                    LSerii.setText("" + counter);}
                else{
                    counter = 0;
                }
            }
        });

        ButtonClickReset.setOnClickListener(v -> {
            counter = 0;
            lacznaLS = 0;
            NazwaCw.setText("Losuj ćwiczenie");
            LacznaLSerii.setText("Łączna liczba serii: 0");
            ZdjCwicen.setImageResource(R.drawable.cwiczenie0);
            LSerii.setText(String.valueOf(counter));
        });

        ButtonClickLosuj.setOnClickListener(v -> {
            Random random = new Random();
            int wylosowanaLiczba = random.nextInt(6);
            int zdjecia[] = {
                    R.drawable.cwiczenie1,
                    R.drawable.cwiczenie2,
                    R.drawable.cwiczenie3,
                    R.drawable.cwiczenie4,
                    R.drawable.cwiczenie5,
                    R.drawable.cwiczenie6
            };
            String nazwaCwicenia[] ={
                    "Przysiad",
                    "Pompki",
                    "Plank",
                    "Wykroki",
                    "Burpees",
                    "Podciąganie"
            };
            ZdjCwicen.setImageResource(zdjecia[wylosowanaLiczba]);
            NazwaCw.setText(nazwaCwicenia[wylosowanaLiczba]);
            counter = 0;
            LSerii.setText(String.valueOf(counter));
        });

        NastempneCwiczenie.setOnClickListener(v -> {
            lacznaLS += counter;
            LacznaLSerii.setText("Łączna liczba serii: " + lacznaLS);
            Random random = new Random();
            int wylosowanaLiczba = random.nextInt(6);
            int zdjecia[] = {
                    R.drawable.cwiczenie1,
                    R.drawable.cwiczenie2,
                    R.drawable.cwiczenie3,
                    R.drawable.cwiczenie4,
                    R.drawable.cwiczenie5,
                    R.drawable.cwiczenie6
            };
            String nazwaCwicenia[] ={
                    "Przysiad",
                    "Pompki",
                    "Plank",
                    "Wykroki",
                    "Burpees",
                    "Podciąganie"
            };
            ZdjCwicen.setImageResource(zdjecia[wylosowanaLiczba]);
            NazwaCw.setText(nazwaCwicenia[wylosowanaLiczba]);

            counter = 0;
            LSerii.setText(String.valueOf(counter));
        });
    }
}