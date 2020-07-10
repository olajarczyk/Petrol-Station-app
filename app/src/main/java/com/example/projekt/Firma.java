package com.example.projekt;

public class Firma {

    private String IDFirmy;
    private String NIP;
    private String Nazwa;
    private String Adres;


    public Firma(String idFirmy, String nip, String nazwa, String adres) {
        IDFirmy = idFirmy;
        NIP = nip;
        Nazwa = nazwa;
        Adres = adres;
    }


    public String getIDFirmy() {
        return IDFirmy;
    }

    public void setIDFirmy(String IDFirmy) {
        this.IDFirmy = IDFirmy;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public static String database_table6 = "Firma";

    public static final String KEY_FIRMAID = "IDFirmy";
    public static final String KEY_NIP = "NIP";
    public static final String KEY_NAZWA = "Nazwa";
    public static final String KEY_ADRES = "Adres";
}
