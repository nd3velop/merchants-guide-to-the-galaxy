package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
