package NumberConverter;

public class NumberConversionFacade {
    private ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
    private RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
    private IntergalacticDigits intergalacticDigits = new IntergalacticDigits();
    private IntergalacticToRomanConverter intergalacticToRomanConverter = new IntergalacticToRomanConverter(intergalacticDigits);
    private MetalPrices metalPrices = new MetalPrices();
    private MetalToCreditsConverter metalToCreditsConverter = new MetalToCreditsConverter(metalPrices);

    public void putIntergalacticDigit(Character romanValue, String intergalacticValue){
        intergalacticDigits.put(romanValue, intergalacticValue);
    }

    public int convertIntergalacticToArabic(String intergalactic){
        String roman = intergalacticToRomanConverter.convert(intergalactic);
        return romanToArabicConverter.convert(roman);
    }

    private double calculateMetalPrice(String intergalactic, Double credits){
        int metalCount = convertIntergalacticToArabic(intergalactic);
        return credits / metalCount;
    }

    public void putMetalPrice(String intergalactic, String metal, Double credits){
        metalPrices.put(calculateMetalPrice(intergalactic, credits), metal);
    }

    public double convertIntergalacticAndMetalToCredits(String intergalactic, String metal) {
        return metalToCreditsConverter.convert(metal) * convertIntergalacticToArabic(intergalactic);
    }
}
