package com.example.projekt;

public class Myjnia {
    private String IDStanowiskaMyjni;
    private String Data;
    private String Godzina;
    private String Ile;
    private String IDKlienta;

    public Myjnia(String idStanowiskaMyjni, String data, String godzina, String ile, String idKlienta) {
        IDStanowiskaMyjni = idStanowiskaMyjni;
        Data = data;
        Godzina=godzina;
        Ile=ile;
        IDKlienta = idKlienta;
    }

    public String getIDStanowiskaMyjni() {
        return IDStanowiskaMyjni;
    }

    public void setIDStanowiskaMyjni(String IDStanowiskaMyjni) {
        this.IDStanowiskaMyjni = IDStanowiskaMyjni;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getGodzina() {
        return Godzina;
    }

    public void setGodzina(String godzina) {
        Godzina=godzina;
    }

    public String getIle() {
        return Ile;
    }

    public void setIle(String ile) {
        Ile=ile;
    }

    public String getIDKlienta() {
        return IDKlienta;
    }

    public void setIDKlienta(String IDKlienta) {
        this.IDKlienta = IDKlienta;
    }

    public static String database_table4 = "Myjnia";

    public static final String KEY_STANOWISKOMYJNIID = "IDStanowiskaMyjni";
    public static final String KEY_DATA = "Data";
    public static final String KEY_GODZINA = "Godzina";
    public static final String KEY_ILE = "JakDlugo";
    public static final String KEY_KLIENTID = "IDKlienta";
}
