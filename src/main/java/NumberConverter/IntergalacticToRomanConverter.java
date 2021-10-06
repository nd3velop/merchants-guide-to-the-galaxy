package NumberConverter;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntergalacticToRomanConverter implements INumberConverter<String, String>{
    private IntergalacticDigits intergalacticDigits;
    public IntergalacticToRomanConverter(IntergalacticDigits intergalacticDigits) {
        this.intergalacticDigits = intergalacticDigits;
    }
    @Override
    public String convert(String value) {
        return Arrays.stream(value.split( " " ))
                .map(s -> intergalacticDigits.getRoman(s).toString())
                .reduce("", (s, c) -> s + c);
    }

    @Override
    public boolean isValid(String value) {
        // ToDo implement Method
        return false;
    }

}
