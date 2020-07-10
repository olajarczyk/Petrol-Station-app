package com.example.projekt;

import android.content.Context;

public class Karta_lojalnosciowa {
    private String IDKarta;
    private String Punkty;
    private String IDKlienta;

    public String getIDKarta() {
        return IDKarta;
    }

    public void setIDKarta(String IDKarta) {
        this.IDKarta = IDKarta;
    }

    public String getPunkty() {
        return Punkty;
    }

    public void setPunkty(String punkty) {
        Punkty = punkty;
    }

    public String getIDKlienta() {
        return IDKlienta;
    }

    public void setIDKlienta(String IDKlienta) {
        this.IDKlienta = IDKlienta;
    }

    public static String database_table1 = "Karta_lojalnosciowa";

    public static final String KEY_KARTAID = "IDKarta";
    public static final String KEY_PUNKTY = "Punkty";
    public static final String KEY_KLIENTID = "IDKlienta";

    public Karta_lojalnosciowa(String idkarta, String punkty, String idklienta, Context context) {

        IDKarta = idkarta;
        Punkty = punkty;
        IDKlienta = idklienta;

    }


}
