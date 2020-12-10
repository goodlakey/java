package by.gsu.pms;

import java.util.ArrayList;

public class Channel {
    private ArrayList<Item> items;

    public Channel() {

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Channel(ArrayList<Item> items) {
        this.items = items;
    }
}
