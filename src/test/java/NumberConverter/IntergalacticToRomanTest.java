package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
