package com.example.brissalopez_ev_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Intent i;
    private ProgressBar pb;
    private Button btn;

    ArrayList<String> libros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb= (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);




        pb.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                new Task().execute();
            }
        });

        libros = new ArrayList<String>();
        anadeLibros();

    }


    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute(){

            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected java.lang.String doInBackground(java.lang.String... strings) {

            for (int i = 1; i<= 10; i++){

                try {
                    Thread.sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            Intent i= new Intent(getBaseContext(), Home_act.class);
            startActivity(i);
        }
    }

    public void anadeLibros(){

        libros.add("Farenheit");
        libros.add("Revival");
        libros.add("El Alquimista");
    }

    public void toGithub(View v){

        i = new Intent(this, Github_act.class);
        i.putExtra("listadoLibros", libros);
        startActivity(i);
    }
}