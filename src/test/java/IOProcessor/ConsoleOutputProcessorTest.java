package IOProcessor;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleOutputProcessorTest {
    private ConsoleOutputProcessor consoleOutputProcessor = new ConsoleOutputProcessor();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void showErrorMessage(){
        consoleOutputProcessor.showErrorMessage();
        assertEquals("I have no idea what you are talking about.", outContent.toString().trim());
    }

    @Test
    public void showCreditValueOfMetal() {
        consoleOutputProcessor.showCreditValueOfMetal("glob prok", "Gold", 57800);
        assertEquals("glob prok Gold is 57800 Credits", outContent.toString().trim());
    }

    @Test
    public void showIntergalacticToArabicConversion() {
        consoleOutputProcessor.showIntergalacticToArabicConversion("pish tegj glob glob", 42);
        assertEquals("pish tegj glob glob is 42", outContent.toString().trim());
    }
}
