package IOProcessor;

import NumberConverter.IntergalacticDigits;

import java.util.Locale;

public class InputProcessor {
    private IntergalacticDigits intergalacticDigits;
    private final String ASK_HOW_MUCH = "how much is ";

    public InputProcessor(IntergalacticDigits intergalacticDigits){
        this.intergalacticDigits = intergalacticDigits;
    }

    public void processLine(String line) {
        if (line.matches("^([A-Z,a-z])\\w+ is [A-Z,a-z]$")) {
            addIntergalacticDigit(line);
        }
    }

    private void addIntergalacticDigit(String line) {
        intergalacticDigits.put(line.charAt(line.length() - 1), line.split(" ", 2)[0]);
    }
}
