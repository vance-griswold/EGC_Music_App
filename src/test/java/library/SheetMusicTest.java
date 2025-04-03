package library;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.Test;

import com.model.Chord;
import com.model.Measure;
import com.model.SheetMusic;
/**
 * @author Zachary DeYoung
 */
public class SheetMusicTest {
    @Test
    public void testArrayConstructor() {
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Chord chord1 = new Chord("C5h");
        Chord chord2 = new Chord("D5h");
        chords.add(chord1);
        chords.add(chord2);
        ArrayList<Chord> chords2 = new ArrayList<Chord>();
        chords2.add(chord2);
        chords2.add(chord1);
        ArrayList<Measure> measures = new ArrayList<Measure>();
        Measure measure1 = new Measure(chords);
        Measure measure2= new Measure(chords2);
        measures.add(measure1);
        measures.add(measure2);
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", measures);
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", "C5h, D5h|D5h, C5h");
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testArrayConstructorChord() {
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Chord chord1 = new Chord("Cmaj5h");
        Chord chord2 = new Chord("Dmaj5h");
        chords.add(chord1);
        chords.add(chord2);
        ArrayList<Chord> chords2 = new ArrayList<Chord>();
        chords2.add(chord2);
        chords2.add(chord1);
        ArrayList<Measure> measures = new ArrayList<Measure>();
        Measure measure1 = new Measure(chords);
        Measure measure2= new Measure(chords2);
        measures.add(measure1);
        measures.add(measure2);
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", measures);
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", "Cmaj5h, Dmaj5h|Dmaj5h, Cmaj5h");
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testArrayConstructorRest() {
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Chord chord1 = new Chord("C5h");
        Chord chord2 = new Chord("Rh");
        chords.add(chord1);
        chords.add(chord2);
        ArrayList<Chord> chords2 = new ArrayList<Chord>();
        chords2.add(chord2);
        chords2.add(chord1);
        ArrayList<Measure> measures = new ArrayList<Measure>();
        Measure measure1 = new Measure(chords);
        Measure measure2= new Measure(chords2);
        measures.add(measure1);
        measures.add(measure2);
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", measures);
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", "C5h, Rh|Rh, C5h");
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testArrayConstructorEmpty() {
        ArrayList<Measure> measures = new ArrayList<Measure>();
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", measures);
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", "");
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testStringConstructor() {
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", "C5h, D5h|D5h, C5h");
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Chord chord1 = new Chord("C5h");
        Chord chord2 = new Chord("D5h");
        chords.add(chord1);
        chords.add(chord2);
        ArrayList<Chord> chords2 = new ArrayList<Chord>();
        chords2.add(chord2);
        chords2.add(chord1);
        ArrayList<Measure> measures = new ArrayList<Measure>();
        Measure measure1 = new Measure(chords);
        Measure measure2= new Measure(chords2);
        measures.add(measure1);
        measures.add(measure2);
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", measures);
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testStringConstructorChord() {
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", "Cmaj5h, Dmaj5h|Dmaj5h, Cmaj5h");
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Chord chord1 = new Chord("Cmaj5h");
        Chord chord2 = new Chord("Dmaj5h");
        chords.add(chord1);
        chords.add(chord2);
        ArrayList<Chord> chords2 = new ArrayList<Chord>();
        chords2.add(chord2);
        chords2.add(chord1);
        ArrayList<Measure> measures = new ArrayList<Measure>();
        Measure measure1 = new Measure(chords);
        Measure measure2= new Measure(chords2);
        measures.add(measure1);
        measures.add(measure2);
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", measures);
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testStringConstructorRest() {
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", "C5h, Rh|Rh, C5h");
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Chord chord1 = new Chord("C5h");
        Chord chord2 = new Chord("Rh");
        chords.add(chord1);
        chords.add(chord2);
        ArrayList<Chord> chords2 = new ArrayList<Chord>();
        chords2.add(chord2);
        chords2.add(chord1);
        ArrayList<Measure> measures = new ArrayList<Measure>();
        Measure measure1 = new Measure(chords);
        Measure measure2= new Measure(chords2);
        measures.add(measure1);
        measures.add(measure2);
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", measures);
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testStringConstructorEmpty() {
        SheetMusic sheetMusic = new SheetMusic("Masterpiece", "");
        ArrayList<Measure> measures = new ArrayList<Measure>();
        SheetMusic sheetMusic2 = new SheetMusic("Masterpiece", measures);
        assertEquals(sheetMusic,sheetMusic2);
    }

    @Test
    public void testAddMeasure(){
        InputStream sysInBackup = System.in;
        String testInput = "y\nn\nc\n5\nq\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        SheetMusic sheetMusic = new SheetMusic("Test", "");
        sheetMusic.addMeasure();
        SheetMusic sheetMusic2 = new SheetMusic("Test", "C5q");
        assertEquals(sheetMusic,sheetMusic2);
        System.setIn(sysInBackup);
    }

    @Test
    public void testAddMeasureTwoNotes(){
        InputStream sysInBackup = System.in;
        String testInput = "y\nn\nc\n5\nq\ny\nn\nc\n5\nq\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        SheetMusic sheetMusic = new SheetMusic("Test", "");
        sheetMusic.addMeasure();
        SheetMusic sheetMusic2 = new SheetMusic("Test", "C5q C5q");
        assertEquals(sheetMusic,sheetMusic2);
        System.setIn(sysInBackup);
    }

    @Test
    public void testAddMeasureNo(){
        InputStream sysInBackup = System.in;
        String testInput = "n\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        SheetMusic sheetMusic = new SheetMusic("Test", "");
        sheetMusic.addMeasure();
        SheetMusic sheetMusic2 = new SheetMusic("Test", "");
        assertEquals(sheetMusic,sheetMusic2);
        System.setIn(sysInBackup);
    }

    @Test
    public void testAddMeasureError(){
        InputStream sysInBackup = System.in;
        String testInput = "q\ny\nn\nc\n5\nq\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        SheetMusic sheetMusic = new SheetMusic("Test", "");
        sheetMusic.addMeasure();
        SheetMusic sheetMusic2 = new SheetMusic("Test", "C5q");
        assertEquals(sheetMusic,sheetMusic2);
        System.setIn(sysInBackup);
    }

    @Test
    public void testAddMeasureErrorNo(){
        InputStream sysInBackup = System.in;
        String testInput = "q\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        SheetMusic sheetMusic = new SheetMusic("Test", "");
        sheetMusic.addMeasure();
        SheetMusic sheetMusic2 = new SheetMusic("Test", "");
        assertEquals(sheetMusic,sheetMusic2);
        System.setIn(sysInBackup);
    }

    @Test
    public void testGetSong() {
        SheetMusic sheetMusic = new SheetMusic("Test", "C5h, D5h|D5h, C5h");
        String songTested = sheetMusic.getSong();
        String song = "C5h, D5h|D5h, C5h";
        assertEquals(song,songTested);
    }

    @Test
    public void testGetSongEmpty() {
        SheetMusic sheetMusic = new SheetMusic("Test", "");
        String songTested = sheetMusic.getSong();
        String song = "";
        assertEquals(song,songTested);
    }

    @Test
    public void testGetSongChord() {
        SheetMusic sheetMusic = new SheetMusic("Test", "Cmaj5h, Dmaj5h|Dmaj5h, Cmaj5h");
        String songTested = sheetMusic.getSong();
        String song = "Cmaj5h, Dmaj5h|Dmaj5h, Cmaj5h";
        assertEquals(song,songTested);
    }

    @Test
    public void testGetSongRest() {
        SheetMusic sheetMusic = new SheetMusic("Test", "C5h, Rh|Rh, C5h");
        String songTested = sheetMusic.getSong();
        String song = "C5h, DR|Rh, C5h";
        assertEquals(song,songTested);
    }

    @Test
    public void testGetSongAll() {
        SheetMusic sheetMusic = new SheetMusic("Test", "C5h, Dmaj5h|Rh, Cmaj5h");
        String songTested = sheetMusic.getSong();
        String song = "C5h, Dmaj5h|Rh, Cmaj5h";
        assertEquals(song,songTested);
    }
}
