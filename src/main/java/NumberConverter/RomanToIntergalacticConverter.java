package NumberConverter;

public class RomanToIntergalacticConverter implements INumberConverter<String, String> {
    private IntergalacticDigits intergalacticDigits;
    private RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();

    public RomanToIntergalacticConverter(IntergalacticDigits intergalacticDigits){
        this.intergalacticDigits = intergalacticDigits;
    }

    @Override
    /*
     * Converts a roman value to a intergalactic value
     *
     * @param value a roman number
     * @return intergalactic value of roman number
     */
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
    /*
     * Checks if the passed String is a valid roman value and all roman digits have an intergalactic digit assigned
     *
     * @param   value   roman number
     * @return true if value is a valid roman number that can be converted to an intergalactic number
     */
    public boolean isValid(String value) {
        return !value.toLowerCase().chars()
                .filter(c -> !intergalacticDigits.hasRoman(((char) c)))
                .anyMatch(b -> true) &&
                romanToArabicConverter.isValid(value.toLowerCase());
    }
}
