package NumberConverter;

public class NumberConversionFacade {
    private ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
    private RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
    private IntergalacticDigits intergalacticDigits = new IntergalacticDigits();
    private IntergalacticToRomanConverter intergalacticToRomanConverter = new IntergalacticToRomanConverter(intergalacticDigits);

    public void putIntergalacticDigit(Character romanValue, String intergalacticValue){
        intergalacticDigits.put(romanValue, intergalacticValue);
    }

    public int convertIntergalacticToArabic(String intergalactic){
        String roman = intergalacticToRomanConverter.convert(intergalactic);
        return romanToArabicConverter.convert(roman);
    }
}
