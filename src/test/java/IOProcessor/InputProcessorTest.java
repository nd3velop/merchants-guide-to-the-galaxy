package IOProcessor;

import NumberConverter.IntergalacticDigits;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputProcessorTest {
    private IntergalacticDigits intergalacticDigits;
    private InputProcessor inputProcessor;

    @Before
    public void setUp() {
        intergalacticDigits = new IntergalacticDigits();
        inputProcessor = new InputProcessor(intergalacticDigits);
    }

    @Test
    public void saveGlobIsIToEmptyDigitMap() {
        inputProcessor.processLine("glob is I");
        assertEquals("glob", intergalacticDigits.getIntergalactic('I'));
    }

    @Test
    public void saveProkIsVToEmptyDigitMap() {
        inputProcessor.processLine("pork is V");
        assertEquals("pork", intergalacticDigits.getIntergalactic('V'));
    }


}

