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

    /**
     * Reads a file and executes processLine for each line
     * @param path path to the file
     */
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

    /**
     * Matches the line to predifined rules. Throws exception if the rule is not yet defined
     * @param line line to be executed
     */
    public void processLine(String line) {
        try {
            // Matches any number of words followed by is and another word
            if (line.matches("^([A-Z,a-z])\\w+ is [A-Z,a-z]$"))
                addIntergalacticDigit(line);
            else if (line.toLowerCase().startsWith(ASK_HOW_MUCH) && line.endsWith("?"))
                processIntergalacticToArabicRequest(line);
            else if (line.toLowerCase().startsWith(ASK_HOW_MANY_CREDITS) && line.endsWith("?"))
                processMetalToCreditsRequest(line);
            //  Matches any number of words followed by is followed by a number followed by Credits
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

    /**
     * Adds a metal price described in the line to MetalPrices
     * @param line string to process
     */
    private void addMetalPrice(String line) {
        String splittedLine[] = line.split(" is ", 2);
        String credits = splittedLine[1].split(" ", 2)[0].trim();
        String intergalacticAndMetal[] = splitIntergalacticAndMetal(splittedLine[0]);

        numberConversionFacade.putMetalPrice(intergalacticAndMetal[0], intergalacticAndMetal[1], Double.parseDouble(credits));
    }

    /**
     * Answers a "how many credits is [intergalactic number] [metal] ?" question
     * @param line string to process
     */
    private void processMetalToCreditsRequest(String line) {
        String intergalacticAndMetal[] = splitIntergalacticAndMetal(line.substring(ASK_HOW_MANY_CREDITS.length(), line.length() - 1).trim());
        double credits = numberConversionFacade.convertIntergalacticAndMetalToCredits(intergalacticAndMetal[0], intergalacticAndMetal[1]);
        outputProcessor.showCreditValueOfMetal(intergalacticAndMetal[0], intergalacticAndMetal[1], credits);
    }

    /**
     * Adds an intergalactic digit/roman digit pait to IntergalacticDigits
     * @param line string to process
     */
    private void addIntergalacticDigit(String line) {
        numberConversionFacade.putIntergalacticDigit(line.charAt(line.length() - 1), line.split(" ", 2)[0]);
    }

    /**
     * Answers a "how much is [intergalactic number] ?" question
     * @param line string to process
     */
    private void processIntergalacticToArabicRequest(String line){
        String intergalactic = line.substring(ASK_HOW_MUCH.length(), line.length() - 1).trim();
        int arabic = numberConversionFacade.convertIntergalacticToArabic(intergalactic);
        outputProcessor.showIntergalacticToArabicConversion(intergalactic, arabic);
    }

    /**
     * Shows error message
     */
    private void processInvalidArgument() {
        outputProcessor.showErrorMessage();
    }

    /**
     * Splits a string in the first n words and the last word.
     * @param intergalacticAndMetal string with intergalactic digits and a metal
     * @return string array with two entries (first = [integalactic number], second =[metal])
     */
    private String[] splitIntergalacticAndMetal(String intergalacticAndMetal) {
        String metal = intergalacticAndMetal.substring(intergalacticAndMetal.lastIndexOf(" ") + 1);
        String intergalactic = intergalacticAndMetal.substring(0, intergalacticAndMetal.length() - metal.length()).trim();
        String splitted[] = new String[2];
        splitted[0] = intergalactic;
        splitted[1] = metal;
        return splitted;
    }
}
