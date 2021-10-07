package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberConversionFacadeTest {
    private NumberConversionFacade numberConversionFacade = new NumberConversionFacade();

    @Test
    public void convertGlobGlob(){
        numberConversionFacade.putIntergalacticDigit('i', "glob");
        assertEquals(2, numberConversionFacade.convertIntergalacticToArabic("glob glob"));
    }

    @Test
    public void convertPishTegjGlobGlob(){
        numberConversionFacade.putIntergalacticDigit('i', "glob");
        numberConversionFacade.putIntergalacticDigit('X', "pish");
        numberConversionFacade.putIntergalacticDigit('L', "tegj");
        assertEquals(42, numberConversionFacade.convertIntergalacticToArabic("pish tegj glob glob"));
    }
}
