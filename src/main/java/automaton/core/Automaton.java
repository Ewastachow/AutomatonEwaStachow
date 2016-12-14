package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.CellState;
import automaton.core.stateFactory.CellStateFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by EwaStachów on 16/11/2016.
 */
public abstract class Automaton {
    private Map<CellCoordinates, CellState> cells = new TreeMap<>();
    private CellNeighborhood neighborhoodStrategy;
    private CellStateFactory stateFactory;

    public Automaton() {
    }

    public Automaton(Map<CellCoordinates, CellState> cells, CellNeighborhood neighborhoodStrategy, CellStateFactory stateFactory) {
        this.cells = cells;
        this.neighborhoodStrategy = neighborhoodStrategy;
        this.stateFactory = stateFactory;

    }

    public CellState getStateOfCoords(CellCoordinates cc) {
        return cells.get(cc);
    }

    public void setNewCellState(CellCoordinates cc, CellState cs) {
        cells.put(cc, cs);
    }

    public Map<CellCoordinates, CellState> getCells() {
        return cells;
    }

    public void setCells(Map<CellCoordinates, CellState> cells) {
        this.cells = cells;
    }

    public CellStateFactory getStateFactory() {
        return stateFactory;
    }

    public void setStateFactory(CellStateFactory stateFactory) {
        this.stateFactory = stateFactory;
    }

    @Override
    public String toString() {
        return "Automaton{" +
                "cells=" + cells +
                ", neighborhoodStrategy=" + neighborhoodStrategy +
                ", stateFactory=" + stateFactory +
                '}';
    }

    public class CellIterator {
        private CellCoordinates currentState;

        public void setCurrentState(CellCoordinates currentState) {
            this.currentState = currentState;
        }

        public boolean hasNext() {
            return hasNextCoordinates(currentState);
        }

        public Cell next() {
            return new Cell(nextCoordinates(currentState), cells.get(nextCoordinates(currentState)));
        }

        public void setState(CellState cellS) {
            cells.put(currentState, cellS);
        }
    }

    public Automaton nextstate() {
        Automaton letGetStartedAgain = newInstance(stateFactory, neighborhoodStrategy);
        Map<CellCoordinates, CellState> newCells = new TreeMap<>();
        for (Map.Entry<CellCoordinates, CellState> i : cells.entrySet()) {
            Cell cell = new Cell(i.getKey(), i.getValue());
            newCells.put(cell.coords, this.nextCellState(cell,
                    this.mapCoordinates(neighborhoodStrategy.cellNeighbors(i.getKey()))));
        }
        letGetStartedAgain.setCells(newCells);
        return letGetStartedAgain;
    }

    public void insertStructure(Map<? extends CellCoordinates, ? extends CellState> strcture) {
        cells.putAll(strcture);
    }

    public CellIterator cellIterator() {
        return new CellIterator();
    }

    protected abstract Automaton newInstance(CellStateFactory cellSF, CellNeighborhood cellN);

    protected abstract boolean hasNextCoordinates(CellCoordinates cellC);

    protected abstract CellCoordinates initialCoordinates(CellCoordinates cellC);

    protected abstract CellCoordinates nextCoordinates(CellCoordinates cellC);

    protected abstract CellState nextCellState(Cell currentState, Set<Cell> neighborsStates);

    private Set<Cell> mapCoordinates(Set<CellCoordinates> cellsCSet) {
        Set<Cell> newSetCell = new HashSet<Cell>();
        for (CellCoordinates i : cellsCSet) {
            newSetCell.add(new Cell(i, cells.get(i)));
        }
        return newSetCell;
    }
}
