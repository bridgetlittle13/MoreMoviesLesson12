package com.example.moremovieslesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btninsert, btnSL;
    EditText title, genre, year;
    Spinner rating;
    String spnRate;

    ArrayList<movie> al;
    ArrayAdapter<movie> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninsert = findViewById(R.id.btnInsert);
        btnSL = findViewById(R.id.btnSL);
        title = findViewById(R.id.title);
        genre = findViewById(R.id.genre);
        year = findViewById(R.id.year);
        rating = findViewById(R.id.Spnrating);

        al = new ArrayList<movie>();
        aa = new ArrayAdapter<movie>(this,
                android.R.layout.simple_list_item_1, al);

        rating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here
                switch (position){
                    case 0:
                        spnRate = "G";
                        break;
                    case 1:
                        spnRate = "PG";
                        break;
                    case 2:
                        spnRate = "PG13";
                        break;
                    case 3:
                        spnRate = "NC16";
                        break;
                    case 4:
                        spnRate = "M18";
                        break;
                    case 5:
                        spnRate = "R21";
                        break;

                }
                Toast.makeText(MainActivity.this, "Selected: " + spnRate, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case where nothing is selected (optional)
            }
        });

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(MainActivity.this);

                String stTitle = String.valueOf(title.getText());
                String stGenre = String.valueOf(genre.getText());
                int iYear = Integer.valueOf(String.valueOf(year.getText()));
                db.insertMovie(stTitle, stGenre, iYear, spnRate);
                Toast.makeText(MainActivity.this, "Movie successfully added", Toast.LENGTH_SHORT).show();
            }

        });


        btnSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewMovies.class);
                startActivity(intent);
            }
        });


    }

}