package com.example.projet_location;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private DBManager dbManager;
    //private EditText voitureIdEditText,  voitureMatriculeEditText, voitureMarqueEditText,voituremodeleEditText,voitureAnneeEditText,voitureDispoEditText;
   // private ListView voitureListListView;
   // private ArrayAdapter<String> listAdapter;
   // private ArrayList<String> voitureList;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agence);
        btn = findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent secondActivity = new Intent(MainActivity.this,MainActivity2.class);
                //secondActivity.putExtra("second",txt1.getText().toString());
               // startActivity(secondActivity);


            }
        });
    }
    }

