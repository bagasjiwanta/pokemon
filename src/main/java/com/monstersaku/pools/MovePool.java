package com.monstersaku.pools;

import java.util.ArrayList;
import java.util.List;

import com.monstersaku.moves.Move;

public class MovePool {
    private List<Move> moves;

    public MovePool () {
        moves = new ArrayList<Move>();
    }

    public void add (Move move) {
        moves.add(move);
    }

    public Move getMoveByIndex (int index) {
        return moves.get(index);
    }

    public int getNumberOfMoves () {
        return this.moves.size();
    }
}
