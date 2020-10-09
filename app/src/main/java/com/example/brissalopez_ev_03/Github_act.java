package com.example.brissalopez_ev_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Github_act extends AppCompatActivity {

    private Spinner spin;
    private TextView muestraDatos;
    private String libro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spin = (Spinner)findViewById(R.id.sp);
        muestraDatos = (TextView)findViewById(R.id.tv);


        ArrayList<String> listadoLibros = (ArrayList<String>)getIntent().getSerializableExtra("listadoLibros");

        ArrayAdapter<String> adaptaSpinner = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listadoLibros);
        spin.setAdapter(adaptaSpinner);
    }


    // Intenté hacer que se mostrara el texto en el textview sin usar un button, sino directamente al cambiar de opción en el spinner, pero no lo logré.
    public void muestraTexto(View v){
/*
        if(spin.getSelectedItem().toString().equals("Farenheit")){
            muestraDatos.setText("El valor de "+ spin.getSelectedItem().toString() + " es $5000");
        }
        if(spin.getSelectedItem().toString().equals("Revival")){
            muestraDatos.setText("El valor de: " + spin.getSelectedItem().toString() + " es $12000");
        }
        if(spin.getSelectedItem().toString().equals("El Alquimista")){
            muestraDatos.setText("El valor de: " + spin.getSelectedItem().toString() + " es $45000");
        } */

        libro = spin.getSelectedItem().toString();
        switch (libro){
            case "Farenheit":
                muestraDatos.setText("El valor de "+ libro + " es $7000");
                break;
            case "Revival":
                muestraDatos.setText("El valor de: " + libro + " es $22000");
                break;
            case "El Alquimista":
                muestraDatos.setText("El valor de: " + libro+ " es $45000");
                break;
            case "El Poder":
                muestraDatos.setText("El valor de " + libro + " es $88000");
                break;
            case "Despertar":
                muestraDatos.setText("El valor de " + libro + " es $156000");
                break;
            default:
                muestraDatos.setText("Hay un error al seleccionar un libro. Intente de nuevo.");

        }


    }
}