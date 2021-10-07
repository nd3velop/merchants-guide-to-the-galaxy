package NumberConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MetalToCreditsConverterTest {
    private MetalToCreditsConverter metalToCreditsConverter;
    private MetalPrices metalPrices;

    @Before
    public void setUp() {
        metalPrices = new MetalPrices();
        metalPrices.put(16.0, "Silver");
        metalPrices.put(14450.0, "Gold");
        metalPrices.put(195.5, "Iron");
        metalToCreditsConverter = new MetalToCreditsConverter(metalPrices);
    }

    @Test
    public void convertSilverToCredits(){
        assertEquals(new Double(16.0), metalToCreditsConverter.convert("Silver"));
    }

    @Test
    public void convertGoldToCredits(){
        assertEquals(new Double(14450.0), metalToCreditsConverter.convert("Gold"));
    }

    @Test
    public void convertIronToCredits(){
        assertEquals(new Double(195.5), metalToCreditsConverter.convert("Iron"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNotExistingValue(){
        metalToCreditsConverter.convert("NotExistingValue");
    }
}
