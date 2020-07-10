package com.example.projekt;

public class Kli_Fir {
    private String IDKli_FIr;
    private String IDFirmy;
    private String IDKlienta;

    public Kli_Fir(String idKli_fIr, String idFirmy, String idKlienta) {
        IDKli_FIr = idKli_fIr;
        IDFirmy = idFirmy;
        IDKlienta = idKlienta;
    }

    public String getIDKli_FIr() {
        return IDKli_FIr;
    }

    public void setIDKli_FIr(String IDKli_FIr) {
        this.IDKli_FIr = IDKli_FIr;
    }

    public String getIDFirmy() {
        return IDFirmy;
    }

    public void setIDFirmy(String IDFirmy) {
        this.IDFirmy = IDFirmy;
    }

    public String getIDKlienta() {
        return IDKlienta;
    }

    public void setIDKlienta(String IDKlienta) {
        this.IDKlienta = IDKlienta;
    }

    public static String database_table3 = "Kli-Fir";

    public static final String KEY_KLI_FIR = "IDKli-Fir";
    public static final String KEY_KLIENTID = "IDKlienta";
    public static final String KEY_FIRMAID = "IDFirmy";
}
