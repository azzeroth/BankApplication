package hu.petrik.bankapplication13t;

import hu.petrik.bankapplication13t.Szamla;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hali
 */
public class SzamlaTest {
    
    public SzamlaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kezdetiErtek() {
        Szamla sz = new Szamla("12345678-12345678-00000000", 10000);
        assertEquals("A kezdeti osszeg nincs a szamlan", 10000, sz.getOsszeg());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ervenytelenKezdetiErtek() {
        Szamla sz = new Szamla("12345678-12345678-00000000", 0);
    }
}
