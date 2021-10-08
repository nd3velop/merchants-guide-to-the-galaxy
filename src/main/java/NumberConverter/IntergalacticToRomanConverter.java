package NumberConverter;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class IntergalacticToRomanConverter implements INumberConverter<String, String>{
    private IntergalacticDigits intergalacticDigits;
    public IntergalacticToRomanConverter(IntergalacticDigits intergalacticDigits) {
        this.intergalacticDigits = intergalacticDigits;
    }

    /**
     * Replaces all intergalactic digits with roman digits
     * @param value  intergalactic number
     * @return roman number
     */
    @Override
    public String convert(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException(value + " is not a valid intergalactic number!");

        return Arrays.stream(transformValue(value).split( " " ))
                .map(s -> intergalacticDigits.getRoman(s).toString())
                .reduce("", (s, c) -> s + c);
    }

    /**
     * Checks if all intergalactic digits in the passed String have an roman digit assigned
     * @param value intergalactic number
     * @return true if value can be converted to an roman number
     */
    @Override
    public boolean isValid(String value) {
        return !Arrays.stream(transformValue(value).split( " " ))
                .filter(s -> !intergalacticDigits.hasIntergalactic(s))
                .anyMatch(b -> true);
    }

    /**
     * Deletes additional whitespaces and converts value to lower case
     * @param value   intergalactic number
     * @return value in lower case without additional whitespaces
     */
    private String transformValue(String value) {
        return value.trim().replaceAll("\\s{2,}", " ").toLowerCase();
    }
}
