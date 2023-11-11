package com.example.malekhentati_lsi3_mesure_glycemie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private EditText etValeur; //l’EditText qui comporte la valeur mesurée.
    private TextView tvage , tvResultat;
    private SeekBar sbAge;
    private RadioButton rbtOui;
    private RadioButton rbtNon;
    private Button btnConsulter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("information", "onProgressChanged: "+i);
                tvage.setText("Votre Age :" +i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }


    private void init()
    {
        etValeur = findViewById(R.id.etGlycemia);
        sbAge = (SeekBar)findViewById(R.id.sbAge);
        rbtOui = (RadioButton) findViewById(R.id.rbtOui);
        rbtNon = (RadioButton)findViewById(R.id.rbtNon);
        btnConsulter  = (Button)findViewById(R.id.btnConsulter);
        tvage = (TextView)findViewById(R.id.tvage);
        tvResultat = (TextView) findViewById(R.id.tvResultat);
    }

            private void calculer(View v)
            {
                int age ;
                float valeur;
                boolean verifAge = false , verifValeur = false ;
                if(sbAge.getProgress()!=0)
                    verifAge= true ;
                else
                    Toast.makeText(MainActivity.this,"Veuillez verifier votre age",Toast.LENGTH_SHORT).show();
                if(!etValeur.getText().toString().isEmpty())
                    verifValeur=true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez verifier votre valeur mesure", Toast.LENGTH_LONG).show();
                if(verifAge && verifValeur)
                {   String contenuTexte = etValeur.getText().toString();
                    double niveauGlycemie = Double.parseDouble(contenuTexte);
                    int contenuAge = sbAge.getProgress();
                    boolean estAJean = rbtOui.isChecked();
                    String message;

                    if (estAJean) {
                        if (contenuAge >= 13) {
                            if (niveauGlycemie < 5.0)
                                message = "Le niveau de glycémie est bas avant le repas ";
                            else if (niveauGlycemie >= 5.0 && niveauGlycemie <= 7.2)
                                message = "Le niveau de glycémie est nomal avant le repas ";
                            else
                                message = "Le niveau de glycémie est élevé avant le repas";
                        } else if (contenuAge >= 6 && contenuAge <= 12)
                            if (niveauGlycemie < 5.0)
                                message = "Le niveau de glycémie est bas avant le repas";
                            else if (niveauGlycemie >= 5.0 && niveauGlycemie <= 10.0)
                                message = "Le niveau de glycémie est normal avant le repas";
                            else
                                message = "Le niveau de glycémie est élevé avant le repas";
                        else if (niveauGlycemie < 5.5)
                            message = "Le niveau de glycémie est bas avant le repas";
                        else if (niveauGlycemie >= 5.0 && niveauGlycemie <= 10.0)
                            message = "Le niveau de glycémie est normal avant le repas";
                        else
                            message = "Le niveau de glycémie est élevé avant le repas";
                    }
                    else
                    if(niveauGlycemie<10.5)
                        message="Le niveau de glycémie est normal apres le repas";
                    else
                        message="Le niveau de glycémie est élevé apres le repas";
                    tvResultat.setText(message);
                }
            }
        }



