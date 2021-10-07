package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToIntergalacticConverterTest {
    private RomanToIntergalacticConverter romanToIntergalacticConverter;
    private IntergalacticDigits intergalacticDigits;

    @Before
    public void setUp() {
        intergalacticDigits = new IntergalacticDigits();
        intergalacticDigits.put('I', "glob");
        intergalacticDigits.put('V', "prok");
        intergalacticDigits.put('X', "pish");
        intergalacticDigits.put('L', "tegj");

        romanToIntergalacticConverter = new RomanToIntergalacticConverter(intergalacticDigits);
    }

    @Test
    public void convertII(){
        assertEquals("glob glob", romanToIntergalacticConverter.convert("ii"));
    }

    @Test
    public void convertXLII(){
        assertEquals("pish tegj glob glob", romanToIntergalacticConverter.convert("xlii"));
    }

    @Test
    public void isXLIIisTrue(){
        assertTrue(romanToIntergalacticConverter.isValid("xlii"));
    }

    @Test
    public void isValidMMMMFalse(){
        assertFalse(romanToIntergalacticConverter.isValid("mmmm"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLLLLThrowsException(){
        romanToIntergalacticConverter.convert("llll");
    }
}
