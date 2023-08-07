package com.example.moremovieslesson12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewMovies extends AppCompatActivity {
    ArrayList<String> movies;
    ListView lv;
    Button btnpg13,back;
    ArrayList<movie> al;
    CustomAdapter adapter;
//    TextView created;

    @Override
    protected void onResume() {
        super.onResume();

//        created = findViewById(R.id.tvCreated);
//
//        Calendar calender = Calendar.getInstance();
//        created.setText("Last Updated: " + calender.get(Calendar.DATE) + "/" + calender.get(Calendar.MONTH) + "/" + calender.get(Calendar.YEAR) + " at "
//        + calender.get(Calendar.HOUR) + ":" + calender.get(Calendar.MINUTE));


        al = new ArrayList<movie>();
        adapter = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(adapter);
        Intent i = getIntent();
        DBHelper db = new DBHelper(ViewMovies.this);
        al.clear();
        al.addAll(db.getMovies());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);

        lv = findViewById(R.id.lvDisplay);
        btnpg13 = findViewById(R.id.btnpg13);
        back = findViewById(R.id.btnback);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                movie data = al.get(position);
                Intent i = new Intent(ViewMovies.this,
                        EditMovies.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnpg13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ViewMovies.this);
                al.clear();
                String filterText = "PG13";
                al.addAll(dbh.getAllMovies(filterText));
                adapter.notifyDataSetChanged();

            }

        });



    }
}
