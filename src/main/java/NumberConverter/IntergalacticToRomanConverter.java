package NumberConverter;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class IntergalacticToRomanConverter implements INumberConverter<String, String>{
    private IntergalacticDigits intergalacticDigits;
    public IntergalacticToRomanConverter(IntergalacticDigits intergalacticDigits) {
        this.intergalacticDigits = intergalacticDigits;
    }
    @Override
    public String convert(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException(value + "is not a valid intergalactic number!");

        return Arrays.stream(transformValue(value).split( " " ))
                .map(s -> intergalacticDigits.getRoman(s).toString())
                .reduce("", (s, c) -> s + c);
    }

    @Override
    public boolean isValid(String value) {
        return !Arrays.stream(transformValue(value).split( " " ))
                .filter(s -> !intergalacticDigits.hasIntergalactic(s))
                .anyMatch(b -> true);
    }

    private String transformValue(String value) {
        return value.trim().replaceAll("\\s{2,}", " ").toLowerCase();
    }
}
