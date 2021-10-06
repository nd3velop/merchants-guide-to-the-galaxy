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
            throw new IllegalArgumentException();

        return Arrays.stream(value.replaceAll("  ", " ").toLowerCase().split( " " ))
                .map(s -> intergalacticDigits.getRoman(s).toString())
                .reduce("", (s, c) -> s + c);
    }

    @Override
    public boolean isValid(String value) {
        return !Arrays.stream(value.replaceAll("  ", " ").toLowerCase().split( " " ))
                .filter(s -> !intergalacticDigits.hasIntergalactic(s)).anyMatch(b -> true);
    }

}
