package com.monstersaku;
import java.util.ArrayList;

public enum ElementType {
    NORMAL ("NORMAL"),
    FIRE ("FIRE"),
    WATER ("WATER"),
    GRASS ("GRASS");

    private String name;

    ElementType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ArrayList<ElementType> getValues () {
        ArrayList<ElementType> list = new ArrayList<ElementType>();
        list.add(ElementType.NORMAL);
        list.add(ElementType.FIRE);
        list.add(ElementType.WATER);
        list.add(ElementType.GRASS);
        return list;
    }
}
