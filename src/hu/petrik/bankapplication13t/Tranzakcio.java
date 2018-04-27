package hu.petrik.bankapplication13t;

class Tranzakcio {
    private Szamla forras;
    private Szamla cel;
    private long osszeg;

    public Tranzakcio(Szamla forras, Szamla cel, long osszeg) {
        if (forras == cel || osszeg <= 0) {
            throw new IllegalArgumentException("Hibas tranzakcio");
        }
        this.forras = forras;
        this.cel = cel;
        this.osszeg = osszeg;
    }

    public Szamla getForras() {
        return forras;
    }

    public Szamla getCel() {
        return cel;
    }

    public long getOsszeg() {
        return osszeg;
    }
    
    
}
