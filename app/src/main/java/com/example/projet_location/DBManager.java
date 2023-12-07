package com.example.projet_location;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }


    public long addVoiture(Voiture voiture) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_MATRICULE, voiture.getMatricule());
        values.put(DBHelper.KEY_MARQUE, voiture.getMarque());
        values.put(DBHelper.KEY_MODELE, voiture.getModele());
        values.put(DBHelper.KEY_DISPO, voiture.getDispo());


        return database.insert(DBHelper.TABLE_VOITURE, null, values);
    }
    public int updateVoiture(Voiture voiture) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_MATRICULE, voiture.getMatricule());
        values.put(DBHelper.KEY_MARQUE, voiture.getMarque());
        values.put(DBHelper.KEY_MODELE, voiture.getModele());
        values.put(DBHelper.KEY_DISPO, voiture.getDispo());

        return database.update(
                DBHelper.TABLE_VOITURE,
                values,
                DBHelper.KEY_ID + " = ?",
                new String[]{String.valueOf(voiture.getId())}
        );
    }

    public void deleteVoiture(long voitureId) {
        database.delete(DBHelper.TABLE_VOITURE, DBHelper.KEY_ID
                + "=" + voitureId, null);
    }


    public List<String> getAllVoituresAsStringList() {
        List<String> voitureList = new ArrayList<>();

        String[] columns = {DBHelper.KEY_ID, DBHelper.KEY_MATRICULE, DBHelper.KEY_MARQUE,DBHelper.KEY_MODELE,DBHelper.KEY_DISPO};
        Cursor cursor = database.query(DBHelper.TABLE_VOITURE, columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int voitureId = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.KEY_ID));
                String voitureMatricule = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_MATRICULE));
                String voitureMarque = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_MARQUE));
                String voitureMODELE = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_MODELE));
                String voitureDISPO= cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_DISPO));
                voitureList.add(voitureId + "- " + voitureMatricule + " : " + voitureMarque+ voitureMODELE +":"+ voitureDISPO +":");
            } while (cursor.moveToNext());
        }

        cursor.close();
        return voitureList;
    }

}