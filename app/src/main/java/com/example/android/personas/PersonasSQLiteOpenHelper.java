package com.example.android.personas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PersonasSQLiteOpenHelper extends SQLiteOpenHelper {

    String sql = "CREATE TABLE Personas(foto text, nombre text, apellido text, edad text, pasatiempo text)";

    public PersonasSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super (context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Personas");
        db.execSQL(sql);
    }
}
