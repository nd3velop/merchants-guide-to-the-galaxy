package Application;

import IOProcessor.ConsoleOutputProcessor;
import IOProcessor.IOutputProcessor;
import IOProcessor.InputProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        IOutputProcessor consoleOutputProcessor = new ConsoleOutputProcessor();
        InputProcessor inputProcessor = new InputProcessor(consoleOutputProcessor);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exitPrg = false;

        inputProcessor.processFile("./Notes.txt");

        System.out.println("Please ask your intergalactic question or close with exit: ");
        while (!exitPrg) {
            String input = reader.readLine();
            exitPrg = input.equalsIgnoreCase("exit");

            if (!exitPrg)
                inputProcessor.processLine(input);
        }

    }
}
