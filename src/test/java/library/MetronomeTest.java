import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.model.Metronome;

public class MetronomeTest {

    private Metronome metronome;

    @Before
    public void setUp() {
        // Create a new Metronome object before each test
        metronome = new Metronome();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(60, metronome.getSpeed()); // Default speed should be 60 bpm
        assertEquals(4, metronome.getTempo()); // Default tempo should be 4 beats per measure
        assertFalse(metronome.isEnabled()); // Default state should be false (disabled)
    }

    @Test
    public void testSetSpeed() {
        metronome.setSpeed(120); // Set speed to 120 bpm
        assertEquals(120, metronome.getSpeed()); // Speed should now be 120 bpm
    }

    @Test
    public void testSetSpeedNegative() {
        metronome.setSpeed(-1); // Set an invalid speed (negative)
        assertEquals(60, metronome.getSpeed()); // Speed should remain at default 60 bpm
    }

    @Test
    public void testSetTempo() {
        metronome.setTempo(3); // Set tempo to 3 beats per measure
        assertEquals(3, metronome.getTempo()); // Tempo should now be 3 beats per measure
    }

    @Test
    public void testSetTempoNegative() {
        metronome.setTempo(-1); // Set an invalid tempo (negative)
        assertEquals(4, metronome.getTempo()); // Tempo should remain at default 4 beats per measure
    }

    @Test
    public void testToggleMetronome() {
        metronome.toggle(); // Toggle the metronome (enable it)
        assertTrue(metronome.isEnabled()); // The metronome should be enabled (true)
    }

    @Test
    public void testToggleMetronomeTwice() {
        metronome.toggle(); // First toggle (enable it)
        metronome.toggle(); // Second toggle (disable it)
        assertFalse(metronome.isEnabled()); // The metronome should be disabled (false)
    }
}
