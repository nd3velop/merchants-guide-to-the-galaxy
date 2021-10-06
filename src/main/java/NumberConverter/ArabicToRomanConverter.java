package NumberConverter;

import java.util.TreeMap;

public class ArabicToRomanConverter implements INumberConverter<Integer, String> {
    private final TreeMap<Integer, String> romanDigits = new TreeMap<>();
    private final int maxValue = 3999;
    private final int minValue = 1;

    public ArabicToRomanConverter() {
        this.romanDigits.put(1000, "M");
        this.romanDigits.put(900, "CM");
        this.romanDigits.put(500, "D");
        this.romanDigits.put(400, "XL");
        this.romanDigits.put(100, "C");
        this.romanDigits.put(90, "XC");
        this.romanDigits.put(50, "L");
        this.romanDigits.put(40, "XL");
        this.romanDigits.put(10, "X");
        this.romanDigits.put(9, "IX");
        this.romanDigits.put(5, "V");
        this.romanDigits.put(4, "IV");
        this.romanDigits.put(1, "I");
    }

    @Override
    public String convert(Integer value) {
        int number = romanDigits.floorKey(value);
        if (number == value)
            return romanDigits.get(number);

        return romanDigits.get(number) + convert(value - number);
    }

    @Override
    public boolean isValid(Integer value) {
        return value <= maxValue && value >= minValue;

    }
}
