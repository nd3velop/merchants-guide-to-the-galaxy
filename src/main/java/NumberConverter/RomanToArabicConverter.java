package NumberConverter;

import java.util.HashMap;

public class RomanToArabicConverter implements INumberConverter<String, Integer>{
    private final HashMap<Character, Integer> romanDigits = new HashMap<Character, Integer>();

    public RomanToArabicConverter() {
        this.romanDigits.put('I', 1);
        this.romanDigits.put('V', 5);
        this.romanDigits.put('X', 10);
        this.romanDigits.put('L', 50);
        this.romanDigits.put('C', 100);
        this.romanDigits.put('D', 500);
        this.romanDigits.put('M', 1000);
    }

    @Override
    public Integer convert(String value) {
        String romanNumber = value.toUpperCase();
        String romanReversed = new StringBuilder(romanNumber.toUpperCase()).reverse().toString();
        Integer result = 0;
        int lastValue = 0;

        for (char digit: romanReversed.toCharArray()) {
            if (romanDigits.get(digit) >= lastValue)
                result += romanDigits.get(digit);
            else
                result -= romanDigits.get(digit);
            lastValue = romanDigits.get(digit);
        }

        return result;
    }

}
