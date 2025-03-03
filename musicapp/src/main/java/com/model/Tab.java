package com.model;
import java.util.ArrayList;
/**
 * 
 * @author Evil Gnome Clan
 */
public class Tab {
   private ArrayList<Note> notes;
   
   /**
    * 
    * @param notes
    */
   public Tab(ArrayList<Note> notes){
      this.notes = notes;
   }

   /**
    * 
    * @param note
    */
    public void addNote(Note note){
        notes.add(note);
    }
}
