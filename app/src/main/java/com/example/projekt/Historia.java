package com.example.projekt;

public class Historia {
    private String IDHistoria;
    private String IDKlienta;
    private String Data;
    private String Stanowisko;
    private String Wydatek;

    public Historia(String idHistoria, String idKlienta, String data, String stanowisko, String wydatek) {
        IDHistoria = idHistoria;
        IDKlienta = idKlienta;
        Data = data;
        Stanowisko = stanowisko;
        Wydatek = wydatek;
    }

    public String getIDHistoria() {
        return IDHistoria;
    }

    public void setIDHistoria(String IDHistoria) {
        this.IDHistoria = IDHistoria;
    }

    public String getIDKlienta() {
        return IDKlienta;
    }

    public void setIDKlienta(String IDKlienta) {
        this.IDKlienta = IDKlienta;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getStanowisko() {
        return Stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        Stanowisko = stanowisko;
    }

    public String getWydatek() {
        return Wydatek;
    }

    public void setWydatek(String wydatek) {
        Wydatek = wydatek;
    }

    public static String database_table5 = "Historia";

    public static final String KEY_HISTORIAID = "IDHistoria";
    public static final String KEY_KLIENTID = "IDKlienta";
    public static final String KEY_WYDATEK = "Wydatek";
    public static final String KEY_STANOWISKO = "Stanowisko";
    public static final String KEY_DATA = "Data";
}
