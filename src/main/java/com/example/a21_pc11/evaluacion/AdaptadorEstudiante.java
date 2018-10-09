package com.example.a21_pc11.evaluacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEstudiante extends ArrayAdapter<Estudiante>{
    public AdaptadorEstudiante(Context context, List<Estudiante> objects){
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Estudiante e = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_estudiante, parent, false);
        }
        TextView lblNumero = convertView.findViewById(R.id.lblNumeroEstudiante);
        lblNumero.setText((position + 1)+ "");

        TextView lblNombre = convertView.findViewById(R.id.lblNombreEstudiante);
        lblNombre.setText(e.nombre);

        TextView lblCodigo = convertView.findViewById(R.id.lblCodigoEstudiante);
        lblCodigo.setText(e.codigo);

        TextView lblMateria = convertView.findViewById(R.id.lblMateriaEstudiante);
        lblMateria.setText(e.materia + " " + e.promedio.toString());

        return convertView;
    }

}

