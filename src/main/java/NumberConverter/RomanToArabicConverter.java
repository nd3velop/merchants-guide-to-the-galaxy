package NumberConverter;

import java.util.HashMap;

public class RomanToArabicConverter implements INumberConverter<String, Integer>{
    private final HashMap<Character, Integer> romanDigits = new HashMap<>();

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

        if (!isValid(romanNumber))
            throw new IllegalArgumentException();

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
        return value.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$") && !value.equals("");
    }

}
