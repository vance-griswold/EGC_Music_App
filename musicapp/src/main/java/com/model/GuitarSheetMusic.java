package com.model;

import java.util.ArrayList;
/**
 * 
 *@author Evil Gnome Clan
 */
public class GuitarSheetMusic extends SheetMusic {
    private ArrayList<Tab> tabs;

    /**
     * 
     * @param name
     * @param measures
     * @param guitar
     * @param tabs
     */
    public GuitarSheetMusic(String name, ArrayList<Measure> measures, Instrument guitar, ArrayList<Tab> tabs) {
        super(name, measures, guitar);
        this.tabs = tabs;
    }

    /**
     * 
     * @param tab
     */
    public void addTab(Tab tab){
        tabs.add(tab);
    }

   

}
