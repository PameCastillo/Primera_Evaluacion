package com.example.a21_pc11.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListaEstudiante extends AppCompatActivity {

    ListView listaEstudiante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiante);

        listaEstudiante = findViewById(R.id.lstMostrar);

        if (MainActivity.adaptadorEstudiante != null){
            listaEstudiante.setAdapter(MainActivity.adaptadorEstudiante);
            MainActivity.adaptadorEstudiante.notifyDataSetChanged();
        }
    }
}
