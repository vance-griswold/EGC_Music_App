package library;
import com.model.Chord;
import com.model.Scale;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class ChordTest {

    @Test
    public void testDefaultConstructor() {
        Chord chord = new Chord();
        assertEquals("Rq",chord.getChord());
    }

    @Test
    public void testConstructorWithParameters() {
        Chord chord = new Chord("q", false , Scale.C, 5, false, false);
        assertEquals("C5q", chord.getChord());
    }

    @Test
    public void testConstructorWithParametersChord() {
        Chord chord = new Chord("q", false , Scale.C, 5, true, false);  
        assertEquals("C5majq", chord.getChord());
    }

    @Test
    public void testStringConstructor() {
        Chord chord = new Chord("C5q");
        Chord chord2 = new Chord("q", false , Scale.C, 5, false, false);
        assertEquals(chord, chord2);
    }

    @Test
    public void testStringConstructorEmpty(){
        Chord chord = new Chord("");
        assertEquals(chord.getChord(), "");
    }

    @Test
    public void testGetChordNote() {
        Chord chord = new Chord("C5q");
        assertEquals("C5q", chord.getChord());
    }

    @Test
    public void testGetChordOctave() {
        Chord chord = new Chord("C7q");
        assertEquals("C7q", chord.getChord());
    }

    @Test
    public void testGetChordDuration() {
        Chord chord = new Chord("C5w");
        assertEquals("C5w", chord.getChord());
    }

    @Test
    public void testGetChord() {
        Chord chord = new Chord("C5majq");
        assertEquals("C5majq", chord.getChord());
    }

    @Test
    public void testGetChordRest() {
        Chord chord = new Chord("Rq");
        assertEquals("Rq", chord.getChord());
    }

}
