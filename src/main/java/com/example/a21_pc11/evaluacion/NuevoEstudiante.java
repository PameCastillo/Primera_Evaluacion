package com.example.a21_pc11.evaluacion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class NuevoEstudiante extends AppCompatActivity {

    EditText nombre, codigo, materia, primero, segundo, tercero, promedio;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_estudiante);

        nombre = findViewById(R.id.lblNombtre);
        codigo = findViewById(R.id.lblCodigo);
        materia = findViewById(R.id.lblMateria);
        primero = findViewById(R.id.lblPrimero);
        segundo = findViewById(R.id.lblSegundo);
        tercero = findViewById(R.id.lblTercero);


        guardar = findViewById(R.id.btnGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nombre.getText().toString().isEmpty() || codigo.getText().toString().isEmpty() || materia.getText().toString().isEmpty() ||
                        primero.getText().toString().isEmpty() || segundo.getText().toString().isEmpty() || tercero.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Hay campos vacíos", Toast.LENGTH_LONG).show();
                } else {
                    guardar();
                }
            }
        });
    }

    public void guardar(){
        String nom = nombre.getText().toString();
        String cod = codigo.getText().toString();
        String mat = materia.getText().toString();
        Double p1 = Double.parseDouble(primero.getText().toString());
        Double p2 = Double.parseDouble(segundo.getText().toString());
        Double p3 = Double.parseDouble(tercero.getText().toString());
        Double prom = ((p1*0.3)+(p2*0.3)+(p3*0.4));

        MainActivity.contador++;

        MainActivity prin = new MainActivity();

        Estudiante e = new Estudiante(nom, cod, mat, p1, p2, p3, prom);
        if (MainActivity.adaptadorEstudiante != null){
            prin.adaptadorEstudiante.add(e);
            finish();
        }
    }
}
