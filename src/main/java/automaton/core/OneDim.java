package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords1D;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.BinaryState;
import automaton.core.state.CellState;
import automaton.core.stateFactory.CellStateFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by yevvy on 12/12/2016.
 */
public class OneDim extends Automaton1Dim {
    private int rules;
    private char[] rulesBin;

    public OneDim(Map<CellCoordinates, CellState> cells,
                  CellNeighborhood neighborhoodStrategy,
                  CellStateFactory stateFactory,
                  int size, int rules) {
        super(cells, neighborhoodStrategy, stateFactory, size);
        this.rules = rules;
        rulesBin = toBinaryRule();
    }

    public OneDim(int size, int rules) {
        super(size);
        this.rules = rules;
        rulesBin = toBinaryRule();
    }

    @Override
    protected Automaton newInstance(CellStateFactory cellSF, CellNeighborhood cellN) {
        Map<CellCoordinates, CellState> cellsMap = new TreeMap<>();
        Set<CellCoordinates> coordsSet = new TreeSet<>();
        for (int i = 0; i < getSize(); i++) {
            coordsSet.add(new Coords1D(i));
        }
        for (CellCoordinates j : coordsSet) {
            cellsMap.put(j, cellSF.initialState(j));
        }
        return new OneDim(cellsMap, cellN, cellSF, super.getSize(), rules);

    }

    @Override
    protected CellState nextCellState(Cell currentState, Set<Cell> neighborsStates) {
        CellState nextCellState;
        Cell left = currentState;
        Cell right = currentState;
        for (Cell i : neighborsStates) {
            if (((Coords1D) left.coords).getX() > ((Coords1D) i.coords).getX())
                left = i;
            if (((Coords1D) right.coords).getX() < ((Coords1D) i.coords).getX())
                right = i;
        }
        if (currentState.state == BinaryState.ALIVE) {
            if ((left.state == BinaryState.ALIVE) && (right.state == BinaryState.ALIVE)) { // opcja 1
                if (rulesBin[0] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;
            } else if ((left.state == BinaryState.ALIVE) && (right.state == BinaryState.DEAD)) { // opcja 2
                if (rulesBin[1] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;
            } else if ((left.state == BinaryState.DEAD) && (right.state == BinaryState.ALIVE)) { // opcja 5
                if (rulesBin[4] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;
            } else //opcja 6
                if (rulesBin[5] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;
        } else {
            if ((left.state == BinaryState.ALIVE) && (right.state == BinaryState.ALIVE)) { // opcja 3
                if (rulesBin[2] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;

            } else if ((left.state == BinaryState.ALIVE) && (right.state == BinaryState.DEAD)) { // opcja 4
                if (rulesBin[3] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;

            } else if ((left.state == BinaryState.DEAD) && (right.state == BinaryState.ALIVE)) { // opcja 7
                if (rulesBin[6] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;
            } else //opcja 8
                if (rulesBin[7] == '0') nextCellState = BinaryState.DEAD;
                else nextCellState = BinaryState.ALIVE;
        }
        return nextCellState;
    }

    private char[] toBinaryRule() {

        int result = 0;
        int multiplier = 1;
        while (rules > 0) {
            int residue = rules % 2;
            rules = rules / 2;
            result = result + residue * multiplier;
            multiplier = multiplier * 10;
        }

        String binaryString = Integer.toString(result);
        String stringWithOh = "";
        for (int i = 0; i < (8 - binaryString.length()); i++) {
            stringWithOh += "0";
        }
        binaryString = stringWithOh + binaryString;
        char[] fullBinaryCharTable = binaryString.toCharArray();
        return fullBinaryCharTable;
    }
}
