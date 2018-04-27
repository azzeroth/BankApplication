package hu.petrik.bankapplication13t;

import hu.petrik.bankapplication13t.Tranzakcio;
import hu.petrik.bankapplication13t.Szamla;
import hu.petrik.bankapplication13t.Bank;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
    
    public BankTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void kezdetbenMindenUres() {
        Bank b = new Bank("111");
        int szdb = b.getSzamlaCount();
        int trdb = b.getTranzakcioCount();
        
        assertEquals("Szamlak szama nem nulla", 0, szdb);
        assertEquals("Tranzakciok szama nem nulla", 0, trdb);
    }
    
    @Test
    public void utalasUtanOsszegekStimmelnek() {
        Bank b = new Bank("111");
        Szamla forras = new Szamla("11111111-22222222-33333333", 100000);
        b.ujSzamla(forras);
        Szamla cel = new Szamla("11111111-11111111-33333333", 5000);
        b.ujSzamla(cel);
        
        b.utal("11111111-22222222-33333333", "11111111-11111111-33333333", 10000);
        
        assertEquals("Forras szamla osszege nem stimmel", 90000, forras.getOsszeg());
        assertEquals("Cel szamla osszege nem stimmel", 15000, cel.getOsszeg());
        
        assertEquals("Nem jott letre tranzakcio", 1, b.getTranzakcioCount());
        
        List<Tranzakcio> tranz = b.getTranzakciok();
        assertEquals("Tranzakcio forras nem stimmel", forras, tranz.get(0).getForras());
        assertEquals("Tranzakcio cel nem stimmel", cel, tranz.get(0).getCel());
        assertEquals("Tranzakcio osszeg nem stimmel", 10000, tranz.get(0).getOsszeg());
        
    }
        
    @Test
    public void megfeleloSzamlaszamFormatumok(){
        Bank b = new Bank("111");
        String input= "11111111-2222222-33333333";
        assertEquals("Számlaszám formátuma érvénytelen!", false, Pattern.matches("^[0-9]{8}-[0-9]{8}-[0-9]{8}$", input));        
        Szamla tesztSzamla = new Szamla(input, 100000);
        b.ujSzamla(tesztSzamla);
    }
    

}
