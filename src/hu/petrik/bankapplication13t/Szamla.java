
package hu.petrik.bankapplication13t;

import java.util.regex.Pattern;

public class Szamla {
    private static String SZAMLASZAM_MINTA = "^[0-9]{8}-[0-9]{8}-[0-9]{8}$";
    private String szamlaszam;
    private long osszeg;

    public Szamla(String szamlaszam, long osszeg) {
        if (osszeg < 1) {
            throw new IllegalArgumentException("Osszeg pozitiv kell, hogy legyen");
        }
        if (!Pattern.matches(SZAMLASZAM_MINTA, szamlaszam)) {
            throw new IllegalArgumentException("Szamlaszam formatuma nem jo");
        }
        
        this.szamlaszam = szamlaszam;
        this.osszeg = osszeg;
    }

    public long getOsszeg() {
        return osszeg;
    }

    public String getSzamlaszam() {
        return szamlaszam;
    }

    void setOsszeg(long osszeg) {
        this.osszeg = osszeg;
    }
}
