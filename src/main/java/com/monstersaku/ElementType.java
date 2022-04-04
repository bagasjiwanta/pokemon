package com.monstersaku;
import java.util.ArrayList;
import java.util.List;

public enum ElementType {
    NORMAL,
    FIRE,
    WATER,
    GRASS;

    public static List<ElementType> getValues () {
        List<ElementType> list = new ArrayList<ElementType>();
        list.add(ElementType.NORMAL);
        list.add(ElementType.FIRE);
        list.add(ElementType.WATER);
        list.add(ElementType.GRASS);
        return list;
    }
}
