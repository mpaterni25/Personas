package com.example.android.personas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by android on 04/04/2017.
 */

public class Datos {

    private  ArrayList<Persona> personas = new ArrayList();

    public static ArrayList<Persona> traerPersonas (Context contexto) {

        // Declaro las variables

        SQLiteDatabase db;
        String sql, foto, nombre, apellido, pasatiempo;
        int edad;
        ArrayList<Persona> personas = new ArrayList();
        //abrir la base de datos de lectura
        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto,"DBPersonas", null,2);
        db =aux.getReadableDatabase();

        // Cursor
        sql= "Select foto, nombre, apellido, edad, pasatiempo from Personas";
        Cursor c = db.rawQuery(sql,null);
        // Recorrido del cursor;

        if(c.moveToFirst()){
            do {
                foto = c.getString(0);
                nombre = c.getString(1);
                apellido = c.getString(2);
                edad = Integer.parseInt(c.getString(3));
                pasatiempo = c.getString(4);

                Persona p = new Persona(foto, nombre, apellido, edad, pasatiempo);
                personas.add(p);
            }while(c.moveToNext());
            }
        //cerrar conex
        db.close();
        return personas;
        }

    }

