package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    QDH obj=new QDH();
    ArrayList<String> arreng;

    ListView listvieweng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listvieweng =(ListView) findViewById(R.id.Surah_list);


        arreng=new ArrayList<String>();


        arreng=(ArrayList<String>) obj.GetSurahNames();


       ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arreng);
        listvieweng.setAdapter(arrayAdapter);
        listvieweng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("you selected " , arreng.get(i));
                Intent intent = new Intent(MainActivity.this,Surah.class);



                String temp=String.valueOf(i);
                intent.putExtra("index",temp);
                Log.i("index",temp);
                startActivity(intent);
            }
        });


    }
}