package NumberConverter;

import java.util.TreeMap;

public class ArabicToRomanConverter implements INumberConverter<Integer, String> {
    private final TreeMap<Integer, String> romanDigits = new TreeMap<>();
    private final int MAX_VALUE = 3999;
    private final int MIN_VALUE = 1;

    public ArabicToRomanConverter() {
        this.romanDigits.put(1000, "m");
        this.romanDigits.put(900, "cm");
        this.romanDigits.put(500, "d");
        this.romanDigits.put(400, "xl");
        this.romanDigits.put(100, "c");
        this.romanDigits.put(90, "xc");
        this.romanDigits.put(50, "l");
        this.romanDigits.put(40, "xl");
        this.romanDigits.put(10, "x");
        this.romanDigits.put(9, "ix");
        this.romanDigits.put(5, "v");
        this.romanDigits.put(4, "iv");
        this.romanDigits.put(1, "i");
    }

    @Override
    public String convert(Integer value) {
        if (!isValid(value))
            throw new IllegalArgumentException(value + " can not be converted to a Roman number!");

        int number = romanDigits.floorKey(value);
        if (number == value)
            return romanDigits.get(number);

        return romanDigits.get(number) + convert(value - number);
    }

    @Override
    public boolean isValid(Integer value) {
        return value <= MAX_VALUE && value >= MIN_VALUE;
    }
}
