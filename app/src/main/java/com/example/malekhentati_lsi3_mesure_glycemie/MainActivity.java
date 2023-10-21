package com.example.malekhentati_lsi3_mesure_glycemie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculer(View view) {
        // Code à exécuter lors du clic sur le bouton "CONSULTER"
        // Par exemple, vous pouvez récupérer la valeur de l'EditText ici
        EditText editText = findViewById(R.id.etGlycemia);
        String valeurMesuree = editText.getText().toString();

        // Faites ce que vous avez besoin de faire avec la valeur mesurée
    }

}