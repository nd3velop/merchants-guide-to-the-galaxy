package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntergalacticToRomanTest {
    private IntergalacticToRomanConverter intergalacticToRomanConverter;
    private IntergalacticDigits intergalacticDigits;

    @Before
    public void setUp() {
        intergalacticDigits = new IntergalacticDigits();
        intergalacticDigits.put('I', "glob");
        intergalacticDigits.put('V', "prok");
        intergalacticDigits.put('X', "pish");
        intergalacticDigits.put('L', "tegj");

        intergalacticToRomanConverter = new IntergalacticToRomanConverter(intergalacticDigits);
    }

    @Test
    public void convertGlobGlob(){
        assertEquals(intergalacticToRomanConverter.convert("glob glob"), "II");
    }

    @Test
    public void convertPishTegjGlobGlob(){
        assertEquals(intergalacticToRomanConverter.convert("pish tegj glob glob"), "XLII");
    }

    @Test
    public void isValidPishTegjGlobGlobisTrue(){
        assertTrue(intergalacticToRomanConverter.isValid("Pish tegj  glob glob"));
    }

    @Test
    public void isValidPishTegjGlobGloisFalse(){
        assertFalse(intergalacticToRomanConverter.isValid("pish tegj glob glo"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertGloThrowsException(){
        intergalacticToRomanConverter.convert("Glo");
    }
}
