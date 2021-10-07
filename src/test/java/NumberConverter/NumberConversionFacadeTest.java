package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberConversionFacadeTest {
    private NumberConversionFacade numberConversionFacade = new NumberConversionFacade();

    @Before
    public void setUp(){
        numberConversionFacade.putIntergalacticDigit('i', "glob");
        numberConversionFacade.putIntergalacticDigit('v', "prok");
        numberConversionFacade.putIntergalacticDigit('x', "pish");
        numberConversionFacade.putIntergalacticDigit('l', "tegj");
    }

    @Test
    public void convertGlobGlob(){
        assertEquals(2, numberConversionFacade.convertIntergalacticToArabic("glob glob"));
    }

    @Test
    public void convertPishTegjGlobGlob(){
        assertEquals(42, numberConversionFacade.convertIntergalacticToArabic("pish tegj glob glob"));
    }

    @Test
    public void convertGlobPorkSilverToCredits() {
        numberConversionFacade.putMetalPrice("glob glob", "Silver", 34.0);
        assertEquals(68, numberConversionFacade
                .convertIntergalacticAndMetalToCredits("glob prok", "Silver"), 0.00001);
    }

}
