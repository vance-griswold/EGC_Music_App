package library;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.model.Chord;
import com.model.Measure;

public class MeasureTest {

   @Test
   public void testAddChordAtStart() {
       ArrayList<Chord> chords = new ArrayList<>();
       Measure measure = new Measure(chords);
       measure.addChord(0, new Chord("C5q"));
       assertEquals(1, chords.size());
   }

   @Test
   public void testAddChordAtEnd() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       Measure measure = new Measure(chords);
       measure.addChord(1, new Chord("D5q"));
       assertEquals(2, chords.size());
   }

   @Test
   public void testAddChordInMiddle() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       chords.add(new Chord("D5q"));
       Measure measure = new Measure(chords);
       measure.addChord(1, new Chord("E5q"));
       assertEquals(3, chords.size());
   }

   @Test
   public void testAddChordInvalidIndex() {
       ArrayList<Chord> chords = new ArrayList<>();
       Measure measure = new Measure(chords);
       assertThrows(IndexOutOfBoundsException.class, () -> measure.addChord(5, new Chord("C5q")));
   }

   @Test
   public void testAddMultipleChords() {
       ArrayList<Chord> chords = new ArrayList<>();
       Measure measure = new Measure(chords);
       measure.addChord(0, new Chord("C5q"));
       measure.addChord(1, new Chord("D5q"));
       measure.addChord(2, new Chord("E5q"));
       assertEquals(3, chords.size());
   }

   @Test
   public void testRemoveChordFromNonEmptyMeasure() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       Measure measure = new Measure(chords);
       measure.removeChord();
       assertEquals(0, chords.size());
   }

   @Test
   public void testRemoveChordMultipleTimes() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       chords.add(new Chord("D5q"));
       Measure measure = new Measure(chords);
       measure.removeChord();
       measure.removeChord();
       assertEquals(0, chords.size());
   }

   @Test
   public void testRemoveChordFromEmptyMeasure() {
       ArrayList<Chord> chords = new ArrayList<>();
       Measure measure = new Measure(chords);
       assertThrows(IndexOutOfBoundsException.class, measure::removeChord);
   }

   @Test
   public void testRemoveChordUntilOneLeft() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       chords.add(new Chord("D5q"));
       Measure measure = new Measure(chords);
       measure.removeChord();
       assertEquals(1, chords.size());
   }

   @Test
   public void testRemoveChordDoesNotAffectOtherChords() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       chords.add(new Chord("D5q"));
       Measure measure = new Measure(chords);
       measure.removeChord();
       assertEquals("C5q", chords.get(0).getChord());
   }

   @Test
   public void testGetMeasureWithMultipleChords() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       chords.add(new Chord("D5q"));
       Measure measure = new Measure(chords);
       assertEquals("C5q D5q", measure.getMeasure());
   }

   @Test
   public void testGetMeasureWithOneChord() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       Measure measure = new Measure(chords);
       assertEquals("C5q", measure.getMeasure());
   }

   @Test
   public void testGetMeasureWithRest() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("Rq"));
       Measure measure = new Measure(chords);
       assertEquals("Rq", measure.getMeasure());
   }

   @Test
   public void testGetMeasureWithEmptyList() {
       ArrayList<Chord> chords = new ArrayList<>();
       Measure measure = new Measure(chords);
       assertEquals("", measure.getMeasure());
   }

   @Test
   public void testGetMeasureWithDifferentDurations() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       chords.add(new Chord("D5w"));
       Measure measure = new Measure(chords);
       assertEquals("C5q D5w", measure.getMeasure());
   }

   @Test
   public void testGetMeasureArraySize() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       Measure measure = new Measure(chords);
       char[][] measureArray = measure.getMeasureArray();
       assertEquals(16, measureArray.length);
       assertEquals(8, measureArray[0].length);
   }

   @Test
   public void testGetMeasureArrayWithSingleChord() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       Measure measure = new Measure(chords);
       char[][] measureArray = measure.getMeasureArray();
       assertEquals('C', measureArray[0][3]);
   }

   @Test
   public void testGetMeasureArrayWithMultipleChords() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("C5q"));
       chords.add(new Chord("D5q"));
       Measure measure = new Measure(chords);
       char[][] measureArray = measure.getMeasureArray();
       assertEquals('C', measureArray[0][3]);
       assertEquals('D', measureArray[2][2]);
   }

   @Test
   public void testGetMeasureArrayWithEmptyMeasure() {
       ArrayList<Chord> chords = new ArrayList<>();
       Measure measure = new Measure(chords);
       char[][] measureArray = measure.getMeasureArray();
       boolean allEmpty = true;
       for (int i = 0; i < 16; i++) {
           for (int j = 0; j < 8; j++) {
               if (measureArray[i][j] != ' ' && measureArray[i][j] != '-') {
                   allEmpty = false;
                   break;
               }
           }
       }
       assertTrue(allEmpty);
   }

   @Test
   public void testGetMeasureArrayWithRest() {
       ArrayList<Chord> chords = new ArrayList<>();
       chords.add(new Chord("Rq"));
       Measure measure = new Measure(chords);
       char[][] measureArray = measure.getMeasureArray();
       assertEquals('R', measureArray[0][4]);
   }
}
