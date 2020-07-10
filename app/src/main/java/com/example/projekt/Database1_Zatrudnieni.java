package com.example.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Database1_Zatrudnieni extends SQLiteOpenHelper {
    public static final String database_name = "Zatrudnieni1";
    private Context c;

    public Database1_Zatrudnieni(@Nullable Context context) {
        super(context, database_name, null, 1);
        this.c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PRACOWNIK = "CREATE TABLE " + Pracownik.database_table2+ "("
                + Pracownik.KEY_PRACOWNIKID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Pracownik.KEY_IMIE + " TEXT, "
                + Pracownik.KEY_NAZWISKO + " TEXT, "
                + Pracownik.KEY_PESEL + " TEXT, "
                + Pracownik.KEY_HASLO + " TEXT, "
                + Pracownik.KEY_WLASCICIEL + " TEXT) ";

        String CREATE_TABLE_SYS_DLA_ZATR = "CREATE TABLE " + System_dla_Zatrudnionych.database_table1+ "("
                + System_dla_Zatrudnionych.KEY_SYSZATRID + " INTEGER PRIMARY KEY, "
                + System_dla_Zatrudnionych.KEY_PRACOWNIKID + " INTEGER, "
                + System_dla_Zatrudnionych.KEY_NADGODZINY + " INTEGER, "
                + System_dla_Zatrudnionych.KEY_URLOP + " TEXT, "
                + System_dla_Zatrudnionych.KEY_PENSJA + " INTEGER, "
                + System_dla_Zatrudnionych.KEY_ZMIANA + " TEXT, "
                + " FOREIGN KEY ("+ System_dla_Zatrudnionych.KEY_PRACOWNIKID+") REFERENCES " + Pracownik.database_table2 + " (" + Pracownik.KEY_PRACOWNIKID + " ))";

        db.execSQL(CREATE_TABLE_PRACOWNIK);
        db.execSQL(CREATE_TABLE_SYS_DLA_ZATR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + System_dla_Zatrudnionych.database_table1);
        db.execSQL(" DROP TABLE IF EXISTS " + Pracownik.database_table2);
        onCreate(db);
    }
    //metody wstawiajace dane
    public boolean wstaw_dane_systemu(int pracownik, int nadgodziny, String urlop, int pensja, String zmiana) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("IDPracownika", pracownik);
        cv.put("Nadgodziny", nadgodziny);
        cv.put("Urlop", urlop);
        cv.put("Pensja", pensja);
        cv.put("Zmiana", zmiana);
        if (db.insert(System_dla_Zatrudnionych.database_table1, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean wstaw_dane_pracownika(String imie, String nazwisko, String pesel, String haslo, String wlasciciel) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Imie", imie);
        cv.put("Nazwisko", nazwisko);
        //cv.put("Data urodzenia", data_urodzenia);
        cv.put("PESEL", pesel);
        cv.put("Haslo", haslo);
        cv.put("Wlasciciel",wlasciciel);
        if (db.insert(Pracownik.database_table2, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }

    //metody wyświetlajace dane
    public SQLiteCursor pobierz_dane_systemu() {
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor = (SQLiteCursor) db.rawQuery("SELECT * FROM " + System_dla_Zatrudnionych.database_table1, null);
        return kursor;
    }

    public SQLiteCursor pobierz_dane_pracownika() {
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor = (SQLiteCursor) db.rawQuery("SELECT * FROM " + Pracownik.database_table2, null);
        return kursor;
    }

    //metody edytujace dane

    public boolean aktualizuj_dane_systemu(String id, int pracownik, int nadgodziny, String urlop, int pensja, String zmiana) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("IDPracownika", pracownik);
        cv.put("Nadgodziny", nadgodziny);
        cv.put("Urlop", urlop);
        cv.put("Pensja", pensja);
        cv.put("Zmiana", zmiana);
        db.update(System_dla_Zatrudnionych.database_table1, cv, "ID = ?", new String[]{id});
        return true;
    }

    public boolean aktualizuj_dane_pracownika(String id, String imie, String nazwisko,  String pesel, String haslo, String wlasciciel) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id); //id pracownika
        cv.put("Imie", imie);
        cv.put("Nazwisko", nazwisko);
        //cv.put("Data urodzenia", data_urodzenia);
        cv.put("PESEL", pesel);
        cv.put("Haslo",haslo);
        cv.put("Wlasciciel", wlasciciel);
        db.update(Pracownik.database_table2, cv, "ID = ?", new String[]{id});
        return true;
    }

    //metody do usuwania
    public boolean usun_dane_systemu(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(System_dla_Zatrudnionych.database_table1, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean usun_dane_pracownika(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(Pracownik.database_table2, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    public SQLiteCursor sprawdzLoginPracownik (String email, String haslo){

        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Pracownik.database_table2 + " where PESEL = '" + email+ "'and wlasciciel = 'n' and haslo = '"+haslo+"'", null);
        return kursor;
    }

    public SQLiteCursor sprawdzLoginWlasciciel (String email, String haslo){

        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Pracownik.database_table2 + " where PESEL = '" + email+ "'and wlasciciel = 't' and haslo = '"+haslo+"'", null);
        return kursor;
    }
}