package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToArabicTest {
    private RomanToArabicConverter romanToArabicConverter;

    @Before
    public void setUp() {
        romanToArabicConverter = new RomanToArabicConverter();
    }
    @Test
    public void convertII(){
        assertEquals(romanToArabicConverter.convert("II").intValue(), 2);
    }

    @Test
    public void convertXX(){
        assertEquals(romanToArabicConverter.convert("XX").intValue(), 20);
    }

    @Test
    public void convertMCMXLIV(){
        assertEquals(romanToArabicConverter.convert("MCMXLIV").intValue(), 1944);
    }

    @Test
    public void convertDCCCXLVII(){
        assertEquals(romanToArabicConverter.convert("DCCCXLVII").intValue(), 847);
    }

    @Test
    public void isValidMMMMisFalse() {
        assertFalse(romanToArabicConverter.isValid("MMMM"));
    }
    @Test
    public void isValidDCCCXLVIIisTrue() {
        assertTrue(romanToArabicConverter.isValid("DCCCXLVII"));
    }

    @Test
    public void isValidMCMXLIIVisFalse() {
        assertFalse(romanToArabicConverter.isValid("MCMXLIIV"));
    }

    @Test
    public void isValidEmptyStringisFalse() {
        assertFalse(romanToArabicConverter.isValid(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNonValidNumber() {
        romanToArabicConverter.convert("IM");
    }
}
