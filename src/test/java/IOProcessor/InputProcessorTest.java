package IOProcessor;

import NumberConverter.IntergalacticDigits;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InputProcessorTest {
    private IntergalacticDigits intergalacticDigits;
    private InputProcessor inputProcessor;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUp() {
        intergalacticDigits = new IntergalacticDigits();
        IOutputProcessor consoleOutputProcessor = new ConsoleOutputProcessor();
        inputProcessor = new InputProcessor(consoleOutputProcessor);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        inputProcessor.processLine("glob is I");
        inputProcessor.processLine("pork is V");
        inputProcessor.processLine("pish is X");
        inputProcessor.processLine("tegj is L");
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void processHowMuchIsGlobGlob() {
        inputProcessor.processLine("how much is glob glob ?");
        assertEquals("glob glob is 2", outContent.toString().trim());
    }

    @Test
    public void processHowMuchIsPishTegjGlobGlobIs42() {
        inputProcessor.processLine("how much is pish tegj glob glob ?");
        assertEquals("pish tegj glob glob is 42", outContent.toString().trim());
    }

    @Test
    public void processHowManyCreditsIsGlobProkSilverIs68() {
        inputProcessor.processLine("glob glob Silver is 34 Credits");
        inputProcessor.processLine("how many Credits is glob pork Silver ?");
        assertEquals("glob pork Silver is 68 Credits", outContent.toString().trim());
    }

    @Test
    public void processHowManyCreditsIsGlobProkGoldIs57800() {
        inputProcessor.processLine("glob pork Gold is 57800 Credits");
        inputProcessor.processLine("how many Credits is glob pork Gold ?");
        assertEquals("glob pork Gold is 57800 Credits", outContent.toString().trim());
    }
}

