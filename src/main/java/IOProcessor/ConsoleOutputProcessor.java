package IOProcessor;

public class ConsoleOutputProcessor implements IOutputProcessor{
    private final String IS_WITH_WHITESPACES = " is ";
    private final String CREDITS = " Credits";
    private final String ERROR_MESSAGE = "I have no idea what you are talking about.";
    @Override
    public void showIntergalacticToArabicConversion(String intergalactic, int arabic) {
        System.out.println(intergalactic + IS_WITH_WHITESPACES + arabic);
    }

    @Override
    public void showCreditValueOfMetal(String intergalactic, String metal, int credits) {
        System.out.println(intergalactic + " " + metal.substring(0, 1).toUpperCase() + metal.substring(1) +
                IS_WITH_WHITESPACES + credits + CREDITS);
    }

    @Override
    public void showErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }
}
