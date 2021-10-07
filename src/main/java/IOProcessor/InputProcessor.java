package IOProcessor;

import NumberConverter.NumberConversionFacade;

import java.util.Locale;

public class InputProcessor {
    private NumberConversionFacade numberConversionFacade = new NumberConversionFacade();
    private final String ASK_HOW_MUCH = "how much is ";

    public void processLine(String line) {
        if (line.matches("^([A-Z,a-z])\\w+ is [A-Z,a-z]$")) {
            addIntergalacticDigit(line);
        }
    }

    private void addIntergalacticDigit(String line) {
        numberConversionFacade.putIntergalacticDigit(line.charAt(line.length() - 1), line.split(" ", 2)[0]);
    }
}
