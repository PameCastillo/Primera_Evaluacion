package com.example.a21_pc11.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public  static int contador;
    Button nuevoEstudiante, listaEstudiante;
    ArrayList<Estudiante> lstEstudiante;
    public static AdaptadorEstudiante adaptadorEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nuevoEstudiante = findViewById(R.id.btnNuevo);
        listaEstudiante = findViewById(R.id.btnLista);
        lstEstudiante = new ArrayList<>();
        adaptadorEstudiante = new AdaptadorEstudiante(this, lstEstudiante);


       // listaEstudiante.setText("Lista Estudiante : " + adaptadorEstudiante.getCount());
        listaEstudiante.setText("Lista Estudiante " + contador);

        nuevoEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, NuevoEstudiante.class);
                startActivity(intento);
            }
        });

        listaEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, ListaEstudiante.class);
                startActivity(intento);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaEstudiante.setText("Lista Estudiante " + contador);
    }
}
