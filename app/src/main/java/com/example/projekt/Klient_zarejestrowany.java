package com.example.projekt;

import java.util.Date;

public class Klient_zarejestrowany {

    private String IDKlienta;
    private String Imie;
    private String Nazwisko;
    private Date DataUrodzenia;
    private String Email;
    private String Haslo;

    public Klient_zarejestrowany(String idKlienta, String imie, String nazwisko, Date data, String email, String haslo) {
        IDKlienta = idKlienta;
        Imie = imie;
        Nazwisko = nazwisko;
        DataUrodzenia=data;
        Email=email;
        Haslo=haslo;
    }

    public String getIDKlienta() {
        return IDKlienta;
    }

    public void setIDKlienta(String IDKlienta) {
        this.IDKlienta = IDKlienta;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

   // public Date getDate() {
   //     return DataUrodzenia;
  //  }

   // public void setDate(Date data) { DataUrodzenia=data; }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email=email;
    }

    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String haslo){ Haslo=haslo; }

    public static String database_table2 = "Klient_zarejestrowany";

    public static final String KEY_KLIENTID = "IDKlienta";
    public static final String KEY_IMIE = "Imie";
    public static final String KEY_NAZWISKO = "Nazwisko";
   // public static final String KEY_DATAURODZENIA = "Data Urodzenia";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_HASLO = "Haslo";
}
