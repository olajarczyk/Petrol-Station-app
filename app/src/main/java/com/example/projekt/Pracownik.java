package com.example.projekt;

public class Pracownik {
    private String IDPracownik;
    private String Imie;
    private String Nazwisko;
    //private String Data_urodzenia;
    private String PESEL;
    private String Haslo;
    private String Wlasciciel;

    public Pracownik(String idPracownik, String imie, String nazwisko, String pesel, String haslo,String wlasciciel) {
        IDPracownik = idPracownik;
        Imie = imie;
        Nazwisko = nazwisko;
        //Data_urodzenia = data_urodzenia;
        PESEL = pesel;
        Haslo=haslo;
        Wlasciciel=wlasciciel;
    }

    public String getIDPracownik() {
        return IDPracownik;
    }

    public void setIDPracownik(String IDPracownik) {
        this.IDPracownik = IDPracownik;
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

   /* public String getData_urodzenia() {
        return Data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }
*/
    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String haslo) {
        this.Haslo = haslo;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getWlasciciel() {
        return Wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.Wlasciciel = wlasciciel;
    }

    public static String database_table2 = "Pracownik";

    public static final String KEY_PRACOWNIKID = "IDPracownik";
    public static final String KEY_IMIE = "Imie";
    public static final String KEY_NAZWISKO = "Nazwisko";
   // public static final String KEY_DATAURODZENIA = "Data_Urodzenia";
    public static final String KEY_PESEL = "PESEL";
    public static final String KEY_HASLO = "Haslo";
    public static final String KEY_WLASCICIEL = "Wlasciciel";

}
