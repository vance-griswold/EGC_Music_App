package com.model;

import java.util.ArrayList;

public class GuitarSheetMusic extends SheetMusic {
    private ArrayList<Tab> tabs;
    private Instrument guitar;

    public GuitarSheetMusic(String name, ArrayList<Measure> measures, Instrument guitar, ArrayList<Tab> tabs) {
        super(name, measures, guitar);
        this.tabs = tabs;
    }

    public void addTab(Tab tab){
        tabs.add(tab);
    }

   

}
