package library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.model.MistakeIndicator;
import com.model.Chord;

/**
 * @author Veronica Fisher
 */
public class MistakeIndicatorTest {
    
    private MistakeIndicator mistakeIndicator;
    private Chord correctChord;
    private Chord incorrectChord;

    @Before
    public void setUpTest()
    {
        mistakeIndicator = new MistakeIndicator();
        correctChord = new Chord();
        incorrectChord = new Chord();
    }

    @Test
    public void testInitialMistakes()
    {
        assertEquals(0, mistakeIndicator.getCurrentMistakes());
        assertEquals(0, mistakeIndicator.getTotalMistakes());
    }

    @Test
    public void testTrackMistakeIncorrectChord()
    {
        mistakeIndicator.trackMistake(incorrectChord, correctChord);
        assertEquals(1, mistakeIndicator.getCurrentMistakes());
        assertEquals(1, mistakeIndicator.getTotalMistakes());
    }

    @Test
    public void testTrackMistakeCorrectChord()
    {
        mistakeIndicator.trackMistake(correctChord, correctChord);
        assertEquals(0, mistakeIndicator.getCurrentMistakes());
        assertEquals(0, mistakeIndicator.getTotalMistakes());
    }

    @Test
    public void testTrackMultipleMistakes()
    {
        mistakeIndicator.trackMistake(incorrectChord, correctChord);
        mistakeIndicator.trackMistake(incorrectChord, correctChord);
        mistakeIndicator.trackMistake(incorrectChord, correctChord);

        assertEquals(3, mistakeIndicator.getCurrentMistakes());
        assertEquals(3, mistakeIndicator.getTotalMistakes());
    }

    @Test
    public void testResetMistakes()
    {
        mistakeIndicator.trackMistake(incorrectChord, correctChord);
        mistakeIndicator.trackMistake(incorrectChord, correctChord);
        mistakeIndicator.resetMistakes();
        assertEquals(0, mistakeIndicator.getCurrentMistakes()); //resets current mistakes
        assertEquals(2, mistakeIndicator.getTotalMistakes()); //total mistakes is now 2
    }

    @Test
    public void testResetMistakesWithNoMistakes()
    {
        mistakeIndicator.resetMistakes();
        assertEquals(0, mistakeIndicator.getCurrentMistakes());
        assertEquals(0, mistakeIndicator.getTotalMistakes());
    }

    @Test
    public void testResetAndTrackTotalMistakes()
    {
        mistakeIndicator.trackMistake(incorrectChord, correctChord);
        mistakeIndicator.resetMistakes();
        mistakeIndicator.trackMistake(incorrectChord, correctChord);
        assertEquals(1, mistakeIndicator.getCurrentMistakes());
        assertEquals(2, mistakeIndicator.getTotalMistakes());
    }

    @Test
    public void testAddMistake()
    {
        mistakeIndicator.addMistake();
        assertEquals(1, mistakeIndicator.getCurrentMistakes());
        assertEquals(1, mistakeIndicator.getTotalMistakes());
    }

    @Test
    public void testAddMultipleMistakes()
    {
        mistakeIndicator.addMistake();
        mistakeIndicator.addMistake();
        mistakeIndicator.addMistake();

        assertEquals(3, mistakeIndicator.getCurrentMistakes());
        assertEquals(3, mistakeIndicator.getTotalMistakes());
    }
}
