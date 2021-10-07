package NumberConverter;

import java.util.HashMap;
import java.util.Locale;

public class RomanToArabicConverter implements INumberConverter<String, Integer>{
    private final HashMap<Character, Integer> romanDigits = new HashMap<>();

    public RomanToArabicConverter() {
        this.romanDigits.put('i', 1);
        this.romanDigits.put('v', 5);
        this.romanDigits.put('x', 10);
        this.romanDigits.put('l', 50);
        this.romanDigits.put('c', 100);
        this.romanDigits.put('d', 500);
        this.romanDigits.put('m', 1000);
    }

    @Override
    public Integer convert(String value) {
        String romanNumber = value.toLowerCase();

        if (!isValid(romanNumber))
            throw new IllegalArgumentException(value + "is not a valid Roman number!");

        String romanReversed = new StringBuilder(romanNumber).reverse().toString();
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

    @Override
    public boolean isValid(String value) {
        return value.toLowerCase().matches("^m{0,3}(cm|cd|d?c{0,3})(xc|xl|l?x{0,3})(ix|iv|v?i{0,3})$") && !value.equals("");
    }

}
