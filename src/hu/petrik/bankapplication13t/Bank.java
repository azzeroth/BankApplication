package hu.petrik.bankapplication13t;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank {
    private Set<Szamla> szamlak = new HashSet<>();
    private List<Tranzakcio> tranzakciok = new ArrayList<>();

    public int getSzamlaCount() {
        return szamlak.size();
    }
    
    public int getTranzakcioCount() {
        return tranzakciok.size();
    }
    
    public List<Tranzakcio> getTranzakciok() {
        return new ArrayList<>(tranzakciok);
    }
    
    public void utal(String honnan, String hova, long osszeg) {
        Szamla forras = null;
        for (Szamla sz: szamlak) {
            if (sz.getSzamlaszam().equals(honnan)) {
                forras = sz;
                break;
            }
        }
        if (forras == null) {
            throw new IllegalArgumentException("Forras szamla nem letezik");
        }
        Szamla cel = null;
        for (Szamla sz: szamlak) {
            if (sz.getSzamlaszam().equals(hova)) {
                cel = sz;
                break;
            }
        }
        if (cel == null) {
            throw new IllegalArgumentException("Cel szamla nem letezik");
        }
        
        // Megvan a ket szamla
        forras.setOsszeg(forras.getOsszeg() - osszeg);
        cel.setOsszeg(cel.getOsszeg() + osszeg);
        
        tranzakciok.add(new Tranzakcio(forras, cel, osszeg));
    }

    public void ujSzamla(Szamla szamla) {
        szamlak.add(szamla);
    }
}
