package com.monstersaku.pools;

import java.util.ArrayList;
import java.util.List;

import com.monstersaku.Monster;

public class MonsterPool {
    private List<Monster> monsterList;
    private Boolean hasOwner;

    public MonsterPool (Boolean hasOwner) {
        this.monsterList = new ArrayList<Monster>();
        this.hasOwner = hasOwner;
    }

    public void add (Monster monster) {
        if (this.hasOwner && this.monsterList.size() >= 6) {
            return;
        }
        this.monsterList.add(monster);
    }

    public Boolean getHasOwner () {
        return this.hasOwner;
    }
}
