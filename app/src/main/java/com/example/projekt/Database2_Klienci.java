package com.example.projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.support.annotation.Nullable;

public class Database2_Klienci extends SQLiteOpenHelper {
    public static final String database_name = "Klienci7";
    private Context c;

    public Database2_Klienci( Context context) {
        super(context, database_name, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
        this.c = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       String CREATE_TABLE_KARTA_LOJALNOSCIOWA = "CREATE TABLE " + Karta_lojalnosciowa.database_table1 + "("
                + Karta_lojalnosciowa.KEY_KARTAID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Karta_lojalnosciowa.KEY_PUNKTY + " INTEGER, "
                + Karta_lojalnosciowa.KEY_KLIENTID + " INTEGER, "
                + " FOREIGN KEY (" + Karta_lojalnosciowa.KEY_KLIENTID + ") REFERENCES " + Klient_zarejestrowany.database_table2 + " (" + Klient_zarejestrowany.KEY_KLIENTID + "))";

        String CREATE_TABLE_KLIENT_ZAREJESTROWANY = "CREATE TABLE " + Klient_zarejestrowany.database_table2 + "("
                + Klient_zarejestrowany.KEY_KLIENTID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Klient_zarejestrowany.KEY_NAZWISKO + " TEXT, "
                + Klient_zarejestrowany.KEY_IMIE + " TEXT, "
                + Klient_zarejestrowany.KEY_EMAIL + " TEXT, "
                + Klient_zarejestrowany.KEY_HASLO + " TEXT )";

        String CREATE_TABLE_KLI_FIR = "CREATE TABLE " + Kli_Fir.database_table3 + "("
                + Kli_Fir.KEY_KLI_FIR + " INTEGER PRIMARY KEY, "
                + Kli_Fir.KEY_FIRMAID + " INTEGER, "
                + Kli_Fir.KEY_KLIENTID + " INTEGER, "
                + " FOREIGN KEY (" + Kli_Fir.KEY_KLIENTID + ") REFERENCES " + Klient_zarejestrowany.database_table2 + " (" + Klient_zarejestrowany.KEY_KLIENTID + "),"
                + " FOREIGN KEY (" + Kli_Fir.KEY_FIRMAID + ") REFERENCES " + Firma.database_table6 + " (" + Firma.KEY_FIRMAID + " ))";

        String CREATE_TABLE_MYJNIA = "CREATE TABLE " + Myjnia.database_table4 + "("
                + Myjnia.KEY_STANOWISKOMYJNIID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Myjnia.KEY_DATA + " TEXT, "
                + Myjnia.KEY_GODZINA + " TEXT, "
                + Myjnia.KEY_ILE + " TEXT, "
                + Myjnia.KEY_KLIENTID + " INTEGER, "
                + " FOREIGN KEY (" + Myjnia.KEY_KLIENTID + ") REFERENCES " + Klient_zarejestrowany.database_table2 + " (" + Klient_zarejestrowany.KEY_KLIENTID + "))";

        String CREATE_TABLE_HISTORIA = "CREATE TABLE " + Historia.database_table5 + "("
                + Historia.KEY_HISTORIAID + " INTEGER PRIMARY KEY, "
                + Historia.KEY_KLIENTID + " INTEGER, "
                + Historia.KEY_WYDATEK + " INTEGER, "
                + Historia.KEY_STANOWISKO + " INTEGER, "
                + Historia.KEY_DATA + " INTEGER, "
                + " FOREIGN KEY (" + Historia.KEY_KLIENTID + ") REFERENCES " + Klient_zarejestrowany.database_table2 + " (" + Klient_zarejestrowany.KEY_KLIENTID + "))";

        String CREATE_TABLE_FIRMA = "CREATE TABLE " + Firma.database_table6 + "("
                + Firma.KEY_FIRMAID + " INTEGER PRIMARY KEY, "
                + Firma.KEY_NIP + " INTEGER, "
                + Firma.KEY_NAZWA + " INTEGER, "
                + Firma.KEY_ADRES + " INTEGER) ";


        db.execSQL(CREATE_TABLE_KLIENT_ZAREJESTROWANY);
        db.execSQL(CREATE_TABLE_FIRMA);
        db.execSQL(CREATE_TABLE_KARTA_LOJALNOSCIOWA);
       // db.execSQL(CREATE_TABLE_KLI_FIR);
        db.execSQL(CREATE_TABLE_MYJNIA);
        db.execSQL(CREATE_TABLE_HISTORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + Karta_lojalnosciowa.database_table1);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + Klient_zarejestrowany.database_table2);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + Kli_Fir.database_table3);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + Myjnia.database_table4 );
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + Historia.database_table5);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + Firma.database_table6);
        onCreate(db);
    }

    //metody wstawiajace dane do np. TextEdit po przypisaniu ich
    public boolean wstaw_karta_lojalnosciowa(int klient, int punkty) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("IDKlienta", klient);
        cv.put("Punkty", punkty);
        if (db.insert(Karta_lojalnosciowa.database_table1, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean wstaw_klient_zarejestrowany(String imie, String nazwisko,String email, String haslo) {
        boolean isRecordExist = false;
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Imie", imie);
        cv.put("Nazwisko", nazwisko);
        cv.put("Email", email);
        cv.put("Haslo",haslo);

        String Query = "Select * from " + Klient_zarejestrowany.database_table2 + " where email = '" + email+"'" ;
        SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            db.insert(Klient_zarejestrowany.database_table2, null, cv);
            return true;
        }
        else
            cursor.close();
        return false;
    }


    public boolean wstaw_kli_fir(int idfirmy, int idklienta) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("IDFirmy", idfirmy);
        cv.put("IDKlienta", idklienta);
        if (db.insert(Kli_Fir.database_table3, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean wstaw_myjnia(int idklienta, String data, String godzina, String ile) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("IDKlienta", idklienta);
        cv.put("Data", data);
        cv.put("Godzina",godzina);
        cv.put("JakDlugo",ile);

        if (db.insert(Myjnia.database_table4, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean wstaw_historia(int idklienta, int data, int stanowisko, int wydatek) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("IDKlienta", idklienta);
        cv.put("Data", data);
        cv.put("Stanowisko", stanowisko);
        cv.put("Wydatek", wydatek);

        if (db.insert(Historia.database_table5, null, cv) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean wstaw_firma(int nip, String nazwa, String adres) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NIP", nip);
        cv.put("Nazwa", nazwa);
        cv.put("Adres", adres);

        if (db.insert(Firma.database_table6, null, cv) == -1) {
            return false;
        } else {
            return true;
        }


    }


    //metody wyświetlajace dane
    public SQLiteCursor pobierz_karta_lojalnosciowa(){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Karta_lojalnosciowa.database_table1, null);
        return kursor;
    }
    public SQLiteCursor pobierz_klient_zarejestrowany(){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Klient_zarejestrowany.database_table2, null);
        return kursor;
    }
    public SQLiteCursor pobierz_kli_fir(){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Kli_Fir.database_table3, null);
        return kursor;
    }
    public SQLiteCursor pobierz_myjnia(){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Myjnia.database_table4, null);
        return kursor;
    }
    public SQLiteCursor pobierz_historia(){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Historia.database_table5, null);
        return kursor;
    }
    public SQLiteCursor pobierz_firma(){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Firma.database_table6, null);
        return kursor;
    }

    //metody edytujace dane

    public boolean aktualizuj_karta_lojalnosciowa(String id, int klient, int punkty) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("IDKlienta", klient);
        cv.put("Punkty", punkty);
        db.update(Karta_lojalnosciowa.database_table1, cv, "ID = ?", new String[]{id});
        return true;
    }
    public boolean aktualizuj_klient_zarejestrowany(String id, int imie, int nazwisko) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("Imie", imie);
        cv.put("Nazwisko", nazwisko);
        db.update(Klient_zarejestrowany.database_table2, cv, "ID = ?", new String[]{id});
        return true;
    }

    public boolean aktualizuj_kli_fir(String id, int idfirmy, int idklienta) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("IDFirmy", idfirmy);
        cv.put("IDKlienta", idklienta);
        db.update(Kli_Fir.database_table3, cv, "ID = ?", new String[]{id});
        return true;
    }
    public boolean aktualizuj_myjnia(String id, int idklienta, int data) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("IDKlienta", idklienta);
        cv.put("Data", data);
        db.update(Myjnia.database_table4, cv, "ID = ?", new String[]{id});
        return true;
    }
    public boolean aktualizuj_historia(String id, int idklienta, int data, int stanowisko, int wydatek) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("IDKlienta", idklienta);
        cv.put("Data", data);
        cv.put("Stanowisko", stanowisko);
        cv.put("Wydatek", wydatek);
        db.update(Historia.database_table5, cv, "ID = ?", new String[]{id});
        return true;
    }
    public boolean aktualizuj_firma(String id, int nip, String nazwa, String adres) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("NIP", nip);
        cv.put("Nazwa", nazwa);
        cv.put("Adres", adres);
        db.update(Firma.database_table6, cv, "ID = ?", new String[]{id});
        return true;
    }

    //metody do usuwania

    public boolean usun_karta_lojalnosciowa(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(Karta_lojalnosciowa.database_table1, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean usun_klient_zarejestrowany(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(Klient_zarejestrowany.database_table2, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean usun_kli_fir(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(Kli_Fir.database_table3, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean usun_myjnia(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(Myjnia.database_table4, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean usun_historia(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(Historia.database_table5, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }public boolean usun_firma(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete(Firma.database_table6, "ID = ?", new String[]{id}) > 0) {
            return true;
        }
        else{
            return false;
        }
    }


    public SQLiteCursor sprawdzLogin (String email, String haslo){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Klient_zarejestrowany.database_table2 + " where email = '" + email+"' and haslo = '"+haslo+"'", null);
        return kursor;
    }


    public SQLiteCursor myjniaKlient(String id){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Myjnia.database_table4 + " where idklienta = '" + id+"'", null);
        return kursor;
    }

    public SQLiteCursor tankowanieKlient(String id){
        SQLiteDatabase db = this.getReadableDatabase();//pobiera baze danych
        SQLiteCursor kursor =(SQLiteCursor) db.rawQuery("SELECT * FROM " + Karta_lojalnosciowa.database_table1 + " where idklienta = '" + id+"'", null);
        return kursor;
    }

}

