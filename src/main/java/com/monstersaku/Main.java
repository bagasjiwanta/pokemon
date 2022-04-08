package com.monstersaku;

// import com.monstersaku.enums.ElementType;
// import com.monstersaku.enums.MoveType;
// import com.monstersaku.enums.StatusCondition;
// import com.monstersaku.moves.DefaultMove;
// import com.monstersaku.moves.Move;
// import com.monstersaku.moves.NormalMove;
// import com.monstersaku.moves.SpecialMove;
// import com.monstersaku.moves.StatusMove;
import com.monstersaku.pools.EffectivityPool;
import com.monstersaku.pools.MonsterPool;
import com.monstersaku.util.CSVReader;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static final List<String> CSV_FILE_PATHS = Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv");
    public static void main(String[] args) {
        EffectivityPool effectivityPool = EffectivityPool.getEffectivityPool();
        MonsterPool monsterPool = new MonsterPool(false);
        List<CSVReader> readers = new ArrayList<CSVReader>();

        for (String fileName : CSV_FILE_PATHS) {
            try {
                readers.add(new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";"));
            } catch (Exception e) { }
        }
        MonsterPool.setReader(readers.get(0));
        Monster.setReader(readers.get(1));
        EffectivityPool.setReader(readers.get(2));

        effectivityPool.readEffectivities();
        monsterPool.readSixRandomMonster();
    }
}
