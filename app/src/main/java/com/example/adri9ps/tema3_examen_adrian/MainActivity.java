package com.example.adri9ps.tema3_examen_adrian;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editDia;
    private EditText editMes;
    private Button btnEnviar;
    private TextView txtDia;
    private TextView txtMes;
    private Button btnMostrar;
    private Button btnEliminar;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDia = (EditText) findViewById(R.id.edit_dia);
        editMes = (EditText) findViewById(R.id.edit_mes);
        btnEnviar = (Button) findViewById(R.id.btn_enviar);
        txtDia = (TextView) findViewById(R.id.id_dia);
        txtMes = (TextView) findViewById(R.id.id_mes);
        btnMostrar = (Button) findViewById(R.id.btn_mostrar);
        btnEliminar = (Button) findViewById(R.id.btn_elminar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveProfile();

            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getProfile();

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clearProfile();

            }
        });


    }

    public void saveProfile() {
        //Guardar preferencias

        sharedPref = getSharedPreferences("Preferencias del adolescente", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        //Cargamos valores de la vista
        String dia = editDia.getText().toString();
        String mes = editMes.getText().toString();
        int valor = Integer.parseInt(dia);


        //Guardamos valores
        editor.putInt("Dia",valor);
        editor.putString("Mes",mes);
        editor.commit();

        //Notificamos la usuario de que se han guardado los datos del perfil correctamente.
        Toast.makeText(getApplicationContext(),"Se han guardado las preferencias",Toast.LENGTH_SHORT).show();
    }

    private void getProfile() {
        sharedPref = getSharedPreferences("Preferencias del adolescente", Context.MODE_PRIVATE);

        Integer intDia = sharedPref.getInt("Dia",0);
        txtDia.setText("Dia: "+intDia);

        String nombreMes = sharedPref.getString("Mes","");
        txtMes.setText("Mes: "+nombreMes);

        //Notificamos la usuario de que se han cargado los datos del perfil correctamente.
        Toast.makeText(getApplicationContext(),"Se han cargado las preferencias",Toast.LENGTH_SHORT).show();

    }

    public void clearProfile(){
        sharedPref = getSharedPreferences("Preferencias del adolescente", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.clear().commit();
        //Notificamos la usuario de que se han eliminado los datos del perfil correctamente.
        Toast.makeText(getApplicationContext(),"Se han eliminado las preferencias",Toast.LENGTH_SHORT).show();


    }







}

