package IOProcessor;

import java.text.DecimalFormat;

public class ConsoleOutputProcessor implements IOutputProcessor{
    private final String IS_WITH_WHITESPACES = " is ";
    private final String CREDITS = " Credits";
    private final String ERROR_MESSAGE = "I have no idea what you are talking about.";

    /**
     * Prints "[intergalactic] is [arabic]" to console
     * @param intergalactic intergalactic number
     * @param arabic arabic number
     */
    @Override
    public void showIntergalacticToArabicConversion(String intergalactic, int arabic) {
        System.out.println(intergalactic + IS_WITH_WHITESPACES + arabic);
    }

    /**
     * Prints "[intergalactic number] [metal] is [credits] Credits" to console
     * @param intergalactic intergalactic number
     * @param metal         name of the metal
     * @param credits       value of intergalactic number * metal price
     */
    @Override
    public void showCreditValueOfMetal(String intergalactic, String metal, double credits) {
        System.out.println(intergalactic + " " + metal.substring(0, 1).toUpperCase() + metal.substring(1) +
                IS_WITH_WHITESPACES + new DecimalFormat("#.#####").format(credits) + CREDITS);
    }

    /**
     * Prints error message to console
     */
    @Override
    public void showErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }
}
