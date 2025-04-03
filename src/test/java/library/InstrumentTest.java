package library;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.model.Instrument;

/**
 * Test class for the Instrument class.
 * 
 * @author Kayleigh Faus
 */
public class InstrumentTest {

    @Test
    public void testGetType() {
        Instrument instrument = new Instrument("Guitar", true, null);
        assertEquals("Guitar", instrument.getType());
        instrument = new Instrument("Piano", false, null);
        assertEquals("Piano", instrument.getType());
        instrument = new Instrument("Violin", true, null);
        assertEquals("Violin", instrument.getType());
        instrument = new Instrument("Drums", false, null);
        assertEquals("Drums", instrument.getType());
        instrument = new Instrument("Flute", true, null);
        assertEquals("Flute", instrument.getType());
    }

    @Test
    public void testSetType() {
        Instrument instrument = new Instrument("Guitar", true, null);
        instrument.setType("Piano");
        assertEquals("Piano", instrument.getType());
        instrument.setType("Violin");
        assertEquals("Violin", instrument.getType());
        instrument.setType("Drums");
        assertEquals("Drums", instrument.getType());
        instrument.setType("Flute");
        assertEquals("Flute", instrument.getType());
        instrument.setType("Saxophone");
        assertEquals("Saxophone", instrument.getType());
    }

    @Test
    public void testHasSheetMusic() {
        Instrument instrument = new Instrument("Guitar", true, null);
        assertTrue(instrument.isHasSheetMusic());
        instrument = new Instrument("Piano", false, null);
        assertFalse(instrument.isHasSheetMusic());
        instrument = new Instrument("Violin", true, null);
        assertTrue(instrument.isHasSheetMusic());
        instrument = new Instrument("Drums", false, null);
        assertFalse(instrument.isHasSheetMusic());
        instrument = new Instrument("Flute", true, null);
        assertTrue(instrument.isHasSheetMusic());
    }

    @Test
    public void testSetHasSheetMusic() {
        Instrument instrument = new Instrument("Guitar", true, null);
        instrument.setHasSheetMusic(false);
        assertFalse(instrument.isHasSheetMusic());
        instrument.setHasSheetMusic(true);
        assertTrue(instrument.isHasSheetMusic());
        instrument.setHasSheetMusic(false);
        assertFalse(instrument.isHasSheetMusic());
        instrument.setHasSheetMusic(true);
        assertTrue(instrument.isHasSheetMusic());
        instrument.setHasSheetMusic(false);
        assertFalse(instrument.isHasSheetMusic());
    }

    @Test
    public void testGetVirtualInstrument() {
        Instrument virtual = new Instrument("Piano", false, null);
        Instrument instrument = new Instrument("Guitar", true, virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Violin", true, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Drums", false, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Flute", true, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Saxophone", false, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
    }

    @Test
    public void testSetVirtualInstrument() {
        Instrument instrument = new Instrument("Guitar", true, null);
        Instrument virtual = new Instrument("Piano", false, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Violin", true, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Drums", false, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Flute", true, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
        virtual = new Instrument("Saxophone", false, null);
        instrument.setVirtualInstrument(virtual);
        assertEquals(virtual, instrument.getVirtualInstrument());
    }

    @Test
    public void testPlayNote() {
        Instrument instrument = new Instrument("Guitar", true, null);
        instrument.playNote("C");
        instrument.playNote("D");
        instrument.playNote("E");
        instrument.playNote("F");
        instrument.playNote("G");
    }

    @Test
    public void testCheckNote() {
        Instrument instrument = new Instrument("Guitar", true, null);
        assertFalse(instrument.checkNote("C"));
        assertFalse(instrument.checkNote("D"));
        assertFalse(instrument.checkNote("E"));
        assertFalse(instrument.checkNote("F"));
        assertFalse(instrument.checkNote("G"));
    }

    @Test
    public void testDisplaySheetMusic() {
        Instrument instrument = new Instrument("Guitar", true, null);
        instrument.displaySheetMusic();
        instrument = new Instrument("Piano", false, null);
        instrument.displaySheetMusic();
        instrument = new Instrument("Violin", true, null);
        instrument.displaySheetMusic();
        instrument = new Instrument("Drums", false, null);
        instrument.displaySheetMusic();
        instrument = new Instrument("Flute", true, null);
        instrument.displaySheetMusic();
    }
}
