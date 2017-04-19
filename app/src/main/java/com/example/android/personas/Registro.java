package com.example.android.personas;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    private EditText nomb, apell, edad;
    private CheckBox leer,futbol,videoJuegos;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        res= this.getResources();
        nomb = (EditText)findViewById(R.id.txtNombre);
        apell = (EditText)findViewById(R.id.txtApellido);
        edad = (EditText)findViewById(R.id.txtEdad);

        leer = (CheckBox) findViewById(R.id.chkLeer);
        futbol = (CheckBox) findViewById(R.id.chkFutbol);
        videoJuegos = (CheckBox) findViewById(R.id.chkVideoJuegos);



    }

     public void registrar (View v){

         String nombre,apellido,aux= "";
         int ed;
         nombre=nomb.getText().toString().trim();
         apellido = apell.getText().toString().trim();
         ed=Integer.parseInt(edad.getText().toString().trim());
         if(leer.isChecked())aux = res.getString(R.string.leer);
         if (futbol.isChecked())aux = aux+ ", "+res.getString(R.string.futbol);
         if (videoJuegos.isChecked())aux = aux+ ", "+res.getString(R.string.video_juegos);
         Persona p= new Persona(nombre,apellido,ed,aux);
         p.guardar();

         new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje)).show();
         Limpiar();

     }

    public void borrar (View v){
        Limpiar();
    }


    public void Limpiar(){
        nomb.setText("");
        apell.setText("");
        edad.setText("");
        leer.setChecked(true);
        futbol.setChecked(false);
        videoJuegos.setChecked(false);
        nomb.requestFocus();

    }

}
