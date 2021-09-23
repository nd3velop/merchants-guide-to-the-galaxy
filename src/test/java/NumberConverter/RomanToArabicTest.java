package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
