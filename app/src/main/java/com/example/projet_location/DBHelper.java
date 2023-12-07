package com.example.projet_location;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //Static Variables Declaration
    public static final String DATABASE_NAME = "Locationdb";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_VOITURE = "voiture";
    public static final String KEY_ID = "id";
    public static final String KEY_MATRICULE = "matricule";
    public static final String KEY_MARQUE = "marque";
    public static final String KEY_MODELE = "modele";
    public static final String KEY_DISPO = "dispo";

    //Constructeur
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // DB Creation
        String CREATE_TABLE_VOITURE = "CREATE TABLE " + TABLE_VOITURE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_MATRICULE + " TEXT,"
                + KEY_MARQUE + " TEXT," // Added comma here
                + KEY_MODELE + " TEXT," // Added comma here
                + KEY_DISPO + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_VOITURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VOITURE);
        onCreate(db);
    }
}
