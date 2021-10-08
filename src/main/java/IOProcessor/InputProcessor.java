package IOProcessor;

import NumberConverter.NumberConversionFacade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class InputProcessor {
    private NumberConversionFacade numberConversionFacade = new NumberConversionFacade();
    private IOutputProcessor outputProcessor;
    private final String ASK_HOW_MUCH = "how much is ";
    private final String ASK_HOW_MANY_CREDITS = "how many credits is ";


    public InputProcessor(IOutputProcessor outputProcessor){
        this.outputProcessor = outputProcessor;
    }

    public void processFile(String path){
        if (new File(path).isFile()){
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                Scanner scanner = new Scanner(fileInputStream);

                while (scanner.hasNextLine()) {
                    processLine(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void processLine(String line) {
        try {
            if (line.matches("^([A-Z,a-z])\\w+ is [A-Z,a-z]$"))
                addIntergalacticDigit(line);
            else if (line.toLowerCase().startsWith(ASK_HOW_MUCH) && line.endsWith("?"))
                processIntergalacticToArabicRequest(line);
            else if (line.toLowerCase().startsWith(ASK_HOW_MANY_CREDITS) && line.endsWith("?"))
                processMetalToCreditsRequest(line);
            else if (line.matches("^(([A-Z,a-z])\\w+ )+is ([0-9])+ Credits$"))
                addMetalPrice(line);
            else
                processInvalidArgument();
        } catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addMetalPrice(String line) {
        String splittedLine[] = line.split(" is ", 2);
        String credits = splittedLine[1].split(" ", 2)[0].trim();
        String intergalacticAndMetal[] = splitIntergalacticAndMetal(splittedLine[0]);

        numberConversionFacade.putMetalPrice(intergalacticAndMetal[0], intergalacticAndMetal[1], Double.parseDouble(credits));
    }

    private void processMetalToCreditsRequest(String line) {
        String intergalacticAndMetal[] = splitIntergalacticAndMetal(line.substring(ASK_HOW_MANY_CREDITS.length(), line.length() - 1).trim());
        double credits = numberConversionFacade.convertIntergalacticAndMetalToCredits(intergalacticAndMetal[0], intergalacticAndMetal[1]);
        outputProcessor.showCreditValueOfMetal(intergalacticAndMetal[0], intergalacticAndMetal[1], credits);
    }

    private void addIntergalacticDigit(String line) {
        numberConversionFacade.putIntergalacticDigit(line.charAt(line.length() - 1), line.split(" ", 2)[0]);
    }

    private void processIntergalacticToArabicRequest(String line){
        String intergalactic = line.substring(ASK_HOW_MUCH.length(), line.length() - 1).trim();
        int arabic = numberConversionFacade.convertIntergalacticToArabic(intergalactic);
        outputProcessor.showIntergalacticToArabicConversion(intergalactic, arabic);
    }

    private void processInvalidArgument() {
        outputProcessor.showErrorMessage();
    }

    private String[] splitIntergalacticAndMetal(String intergalacticAndMetal) {
        String metal = intergalacticAndMetal.substring(intergalacticAndMetal.lastIndexOf(" ") + 1);
        String intergalactic = intergalacticAndMetal.substring(0, intergalacticAndMetal.length() - metal.length()).trim();
        String splitted[] = new String[2];
        splitted[0] = intergalactic;
        splitted[1] = metal;
        return splitted;
    }
}
