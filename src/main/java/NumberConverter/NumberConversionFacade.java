package NumberConverter;

public class NumberConversionFacade {
    private ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
    private RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
    private IntergalacticDigits intergalacticDigits = new IntergalacticDigits();
    private IntergalacticToRomanConverter intergalacticToRomanConverter = new IntergalacticToRomanConverter(intergalacticDigits);
    private MetalPrices metalPrices = new MetalPrices();
    private MetalToCreditsConverter metalToCreditsConverter = new MetalToCreditsConverter(metalPrices);

    /**
     * Adds a new Key Value Pair for conversion between roman and intergalactic numbers
     * @param romanValue            roman digit
     * @param intergalacticValue    intergalactic digit
     */
    public void putIntergalacticDigit(Character romanValue, String intergalacticValue){
        intergalacticDigits.put(romanValue, intergalacticValue);
    }

    /**
     * Converts an intergalactic number in a arabic number
     * @param intergalactic intergalactic number
     * @return corresponding interger value
     */
    public int convertIntergalacticToArabic(String intergalactic){
        String roman = intergalacticToRomanConverter.convert(intergalactic);
        return romanToArabicConverter.convert(roman);
    }

    /**
     * Calculates the price of a single unit for a metal
     * @param intergalactic intergalactic number
     * @param credits price of the multipication of intergalactic number and metal price
     * @return price for one unit of the metal
     */
    private double calculateMetalPrice(String intergalactic, Double credits){
        int metalCount = convertIntergalacticToArabic(intergalactic);
        return credits / metalCount;
    }

    /**
     * Adds an price/metal key value pair
     * @param intergalactic number of metal units in intergalactic format
     * @param metal         name of the metal
     * @param credits       price of the metal * units
     */
    public void putMetalPrice(String intergalactic, String metal, Double credits){
        metalPrices.put(calculateMetalPrice(intergalactic, credits), metal);
    }

    /**
     * Calculates the price of a metal for the for the given amount
     * @param intergalactic number of metal units in intergalactic format
     * @param metal         name of the metal
     * @return price of the metal * units
     */
    public double convertIntergalacticAndMetalToCredits(String intergalactic, String metal) {
        return metalToCreditsConverter.convert(metal) * convertIntergalacticToArabic(intergalactic);
    }
}
