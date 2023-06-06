package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Surah extends AppCompatActivity {

    QDH obj=new QDH();
    QuranArabicText quran=new QuranArabicText();
    TextView txt;
    EditText edtxt,sttxt;
    TextView surah;
    Button filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        Intent intent=getIntent();
        txt=(TextView)findViewById(R.id.name);
        surah=(TextView)findViewById(R.id.surahdisplay);
        edtxt=(EditText) findViewById(R.id.rangeend);
        sttxt=(EditText) findViewById(R.id.rangestart);

        filter=(Button)findViewById(R.id.search);
        int index=Integer.parseInt(intent.getStringExtra("index"));
        String name=(String)obj.urduSurahNames[index];
        txt.setText(name);
        int start=obj.SSP[index];
        int end=start+obj.surahAyatCount[index];
        edtxt.setText(String.valueOf(obj.surahAyatCount[index]));
//        String s=String.valueOf(start);
//        String e=String.valueOf(end);
//        Log.i("Start : ",s);
//        Log.i("End : ",e);

        surah.setText(quran.QuranArabicText[0]+"\n");
       printquran(start,end);
       filter.setOnClickListener(new View.OnClickListener() {
           int ind=index;
           @Override

           public void onClick(View view) {
               rangeprint(start,ind);
           }
       });
       // surah.setMovementMethod(new ScrollingMovementMethod());
    }
    private void printquran(int start,int end)
    {
        for (int i=start;i<end;i++)
        {
            surah.append("  "+quran.QuranArabicText[i]);
        }

    }
    @SuppressLint("SetTextI18n")
    private void rangeprint(int start,int index)
    {
        int s=Integer.parseInt( sttxt.getText().toString())-1;
        int e=Integer.parseInt( edtxt.getText().toString());
        if(e==0)
        {
            e=obj.surahAyatCount[index];
        }
        Log.i("ragnestart ",String.valueOf(start));
        Log.i("ragnestart ",String.valueOf(e));
        int temp=start+s;
        surah.setText("");
        for (int i=0;i<e;i++)
        {
            surah.append("  "+quran.QuranArabicText[temp]);
            temp++;
        }
    }
}