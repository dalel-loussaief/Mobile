package com.example.projet_location;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private DBManager dbManager;
    private EditText   voitureMatriculeEditText, voitureMarqueEditText,voituremodeleEditText,voitureAnneeEditText,voitureDispoEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout);
        dbManager = new DBManager(this);

           voitureMarqueEditText = findViewById(R.id.textView);
        voituremodeleEditText = findViewById(R.id.textView10);
         voitureAnneeEditText = findViewById(R.id.textView12);
          voitureDispoEditText = findViewById(R.id.textView14);
          voitureMatriculeEditText=findViewById(R.id.textView2);

         Button addButton = findViewById(R.id.button);
        // Button voir =findViewById(R.id.button6);




        dbManager.open();
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addVoiture();
              //  Intent SActivity = new Intent(MainActivity2.this,MainActivityListe.class);
                //secondActivity.putExtra("second",txt1.getText().toString());
                //startActivity(SActivity);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
    private void addVoiture() {

        String voitureMarque = voitureMarqueEditText.getText().toString().trim();
        String voitureMatricule = voitureMatriculeEditText.getText().toString().trim();
        String voitureModele = voituremodeleEditText.getText().toString().trim();
        String voitureDispo = voitureDispoEditText.getText().toString().trim();
        String voitureAnnee = voitureAnneeEditText.getText().toString().trim();
        if (!voitureMarque.isEmpty() && !voitureModele.isEmpty()  && !voitureDispo.isEmpty() && !voitureMatricule.isEmpty()  && !voitureAnnee.isEmpty()) {


            Voiture newVoiture = new Voiture(null, voitureMatricule,voitureModele,voitureMarque ,voitureDispo,voitureAnnee);
            long voitureId = dbManager.addVoiture(newVoiture);

            Toast.makeText(this, "car added with ID: " + voitureId, Toast.LENGTH_SHORT).show();
            voitureMarqueEditText.getText().clear();
            voitureMatriculeEditText.getText().clear();
            voituremodeleEditText.getText().clear();
            voitureAnneeEditText.getText().clear();
            voitureDispoEditText.getText().clear();

        } else {
            Toast.makeText(this, "Please enter os donnees", Toast.LENGTH_SHORT).show();
        }
    }
}

