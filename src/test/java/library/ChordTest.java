package library;
import com.model.Chord;
import com.model.Scale;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
/**
 * @author Zachary DeYoung
 */
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
    public void testConstructorWithParametersRest() {
        Chord chord = new Chord("q", true, Scale.REST, 5, false, false);
        assertEquals("Rq", chord.getChord());
    }

    @Test
    public void testConstructorWithParametersNegativeOctave() {
        Chord chord = new Chord("q", false , Scale.C, -5, false, false);
        assertEquals("C0q", chord.getScale());
    }

    @Test
    public void testConstructorWithParametersEmptyDuration() {
        Chord chord = new Chord("", false , Scale.C, 5, false, false);
        assertEquals("C5q", chord.getChord());
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

    @Test //TO TEST
    public void testChordInput() {
        InputStream sysInBackup = System.in;
        String testInput = "n\nc\n5\nq\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        Chord chord = new Chord();
        chord = chord.chordInput();
        assertEquals("C5q", chord.getChord());
        System.setIn(sysInBackup);

    }

    @Test //TO TEST
    public void testChordInputRest() {
        InputStream sysInBackup = System.in;
        String testInput = "r\nq\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        Chord chord = new Chord();
        chord = chord.chordInput();
        assertEquals("Rq", chord.getChord());
        System.setIn(sysInBackup);

    }

    @Test //TO TEST
    public void testChordInputChord() {
        InputStream sysInBackup = System.in;
        String testInput = "c\nmajor\nc\n5\nq\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        Chord chord = new Chord();
        chord = chord.chordInput();
        assertEquals("C5majq", chord.getChord());
        System.setIn(sysInBackup);

    }

    @Test
    public void testGetScale() {
        Chord chord = new Chord("C5q");
        assertEquals(Scale.C.toString(), chord.getScale());
    }

    @Test
    public void testGetScaleRest() {
        Chord chord = new Chord("Rq");
        assertEquals(Scale.REST.toString(), chord.getScale());
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