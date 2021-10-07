package NumberConverter;

public class RomanToIntergalacticConverter implements INumberConverter<String, String> {
    private IntergalacticDigits intergalacticDigits;
    private RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();

    public RomanToIntergalacticConverter(IntergalacticDigits intergalacticDigits){
        this.intergalacticDigits = intergalacticDigits;
    }

    @Override
    public String convert(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException(value + " has no corresponding intergalactic value!");

        String result = "";
        for (char digit: value.toLowerCase().toCharArray()) {
            result += " " + intergalacticDigits.getIntergalactic(digit);
        }
        return result.trim();
    }

    @Override
    public boolean isValid(String value) {
        return !value.toLowerCase().chars()
                .filter(c -> !intergalacticDigits.hasRoman(((char) c)))
                .anyMatch(b -> true) &&
                romanToArabicConverter.isValid(value.toLowerCase());
    }
}
