package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArabicToRomanTest {
    private ArabicToRomanConverter romanToArabicConverter;

    @Before
    public void setUp() {
        romanToArabicConverter = new ArabicToRomanConverter();
    }

    @Test
    public void convertII(){
        assertEquals(romanToArabicConverter.convert(2), "II");
    }

    @Test
    public void convertXX(){
        assertEquals(romanToArabicConverter.convert(20),"XX");
    }

    @Test
    public void convertMCMXLIV(){
        assertEquals(romanToArabicConverter.convert(1944), "MCMXLIV");
    }

    @Test
    public void convertDCCCXLVII(){
        assertEquals(romanToArabicConverter.convert(847), "DCCCXLVII");
    }

    @Test
    public void isValid123isTrue() {
        assertTrue(romanToArabicConverter.isValid(123));
    }

    @Test
    public void isValid4000isFalse() {
        assertFalse(romanToArabicConverter.isValid(4000));
    }

    @Test
    public void isValid3999isTrue() {
        assertTrue(romanToArabicConverter.isValid(3999));
    }

    @Test
    public void isValid0isFalse() {
        assertFalse(romanToArabicConverter.isValid(0));
    }

    @Test
    public void isValid1isTrue() {
        assertTrue(romanToArabicConverter.isValid(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNonValidNumber() {
        romanToArabicConverter.convert(4000);
    }
}
