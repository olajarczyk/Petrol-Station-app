package com.example.projekt;

public class System_dla_Zatrudnionych {
    private String IDSysZatr;
    private String IDPracownik;
    private String Nadgodziny;
    private String Urlop;
    private String Pensja;
    private String Zmiana;

    public System_dla_Zatrudnionych(String idSysZatr, String idPracownik, String nadgodziny, String urlop, String pensja, String zmiana) {
        IDSysZatr = idSysZatr;
        IDPracownik = idPracownik;
        Nadgodziny = nadgodziny;
        Urlop = urlop;
        Pensja = pensja;
        Zmiana = zmiana;
    }

    public String getIDSysZatr() {
        return IDSysZatr;
    }

    public void setIDSysZatr(String IDSysZatr) {
        this.IDSysZatr = IDSysZatr;
    }

    public String getIDPracownik() {
        return IDPracownik;
    }

    public void setIDPracownik(String IDPracownik) {
        this.IDPracownik = IDPracownik;
    }

    public String getNadgodziny() {
        return Nadgodziny;
    }

    public void setNadgodziny(String nadgodziny) {
        Nadgodziny = nadgodziny;
    }

    public String getUrlop() {
        return Urlop;
    }

    public void setUrlop(String urlop) {
        Urlop = urlop;
    }

    public String getPensja() {
        return Pensja;
    }

    public void setPensja(String pensja) {
        Pensja = pensja;
    }

    public String getZmiana() {
        return Zmiana;
    }

    public void setZmiana(String zmiana) {
        Zmiana = zmiana;
    }

    public static String database_table1 = "Systemdlazatrudnionych";

    public static final String KEY_SYSZATRID = "IDSyszatr";
    public static final String KEY_PRACOWNIKID = "IDPRacownik";
    public static final String KEY_NADGODZINY = "Nadgodziny";
    public static final String KEY_PENSJA = "Pensja";
    public static final String KEY_ZMIANA = "Zmiana";
    public static final String KEY_URLOP = "Urlop";
}
