package com.monstersaku;

import java.util.ArrayList;
import java.util.List;

import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;
import com.monstersaku.moves.DefaultMove;
import com.monstersaku.moves.Move;
import com.monstersaku.moves.NormalMove;
import com.monstersaku.moves.SpecialMove;
import com.monstersaku.moves.StatusMove;
import com.monstersaku.pools.MovePool;
import com.monstersaku.util.CSVReader;

public class Monster {
    private String nama;
    private List<ElementType> elementTypes;
    private Stats baseStats;
    private StatusCondition statusCondition;
    private MovePool movePool;
    private List<Integer> moveIds;
    public static CSVReader reader;

    public Monster (
        String nama,
        List<ElementType> elementTypes,
        Stats baseStats,
        List<Integer> moveIds
    ) {
        this.nama = nama;
        this.elementTypes = elementTypes;
        this.baseStats = baseStats;
        this.statusCondition = StatusCondition.NONE;
        this.moveIds = moveIds;
        this.movePool = new MovePool();
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<ElementType> getElementTypes() {
        return this.elementTypes;
    }

    public void addElementType(ElementType elementType) {
        this.elementTypes.add(elementType);
    }

    public Stats getStats() {
        return this.baseStats;
    }

    public StatusCondition getEffect() {
        return this.statusCondition;
    }

    public void setCondition(StatusCondition effect) {
        this.statusCondition = effect;
    }

    public void alterStats(Stats alterStats) {
        this.baseStats.setAttack(this.baseStats.getAttack() - alterStats.getAttack());
        // bikin lagi dibawah
    }

    public Move getMoveById(int id) {
        return movePool.getMoveByIndex(id - 1);
    }

    public void displayMoves() {
        System.out.println("Pokemon " + this.nama + " memiliki move-move berikut: ");
        for (int x = 0; x < movePool.getNumberOfMoves(); x++) {
            System.out.println((x+1) + ". nama : " + movePool.getMoveByIndex(x).getName() + 
            ", amunisi : " + movePool.getMoveByIndex(x).getAmmunition());
        }
    }

    public static void setReader (CSVReader csvreader) {
        if (Monster.reader == null) {
            Monster.reader = csvreader;
        }
    }

    public void beforeEffect () {
        if (this.statusCondition == StatusCondition.SLEEP) {
            // do this
        } else if (this.statusCondition == StatusCondition.PARALYZE) {
            // do that
        }
    }

    public void afterEffect () {
        if (this.statusCondition == StatusCondition.BURN) {
            // do this
        } else if (this.statusCondition == StatusCondition.POISON){
            // do that
        }
    }

    public void readMoves () {
        if(Monster.reader == null) {
            return;
        }

        reader.setSkipHeader(true);
        try {
            List<String[]> lines = reader.read();

            for (int i : moveIds) {
                String[] line = lines.get(i - 1);
                Move move;
                int id = Integer.parseInt(line[0]);
                MoveType moveType = MoveType.valueOf(line[1]);
                String name = line[2];
                ElementType elementType = ElementType.valueOf(line[3]);
                int accuracy = Integer.parseInt(line[4]);
                int priority = Integer.parseInt(line[5]);
                int ammunition = Integer.parseInt(line[6]);
                String target = line[7];

                if (moveType == MoveType.NORMAL) {
                    int basePower = Integer.parseInt(line[8]);
                    move = new NormalMove(id, moveType, name, elementType, accuracy, priority, ammunition, basePower);
                } else if (moveType == MoveType.DEFAULT) {
                    move = new DefaultMove(id, name);
                } else if (moveType == MoveType.SPECIAL) {
                    int basePower = Integer.parseInt(line[8]);
                    move = new SpecialMove(id, moveType, name, elementType, accuracy, priority, ammunition, basePower);
                } else {
                    StatusCondition statusCondition;
                    if(line[8].equals("-")) {
                        statusCondition = StatusCondition.NONE;
                    } else {
                        statusCondition = StatusCondition.valueOf(line[8]);
                    }
                    List<Double> statsList = new ArrayList<Double>();
                    for (String stat : line[9].split(",")) {
                        try {
                            statsList.add(Double.parseDouble(stat));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    Stats stats;
                    stats = new Stats(statsList);
                    move = new StatusMove(id, moveType, name, elementType, accuracy, priority, ammunition, target, statusCondition, stats);
                }

                this.movePool.add(move);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
