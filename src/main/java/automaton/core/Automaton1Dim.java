package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords1D;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.CellState;
import automaton.core.stateFactory.CellStateFactory;

import java.util.Map;

/**
 * Created by EwaStachów on 03/12/2016.
 * @author EwaStachów
 * @version 1.0
 */
public abstract class Automaton1Dim extends Automaton {

    private int size;

    public int getSize() {
        return size;
    }

    public Automaton1Dim(Map<CellCoordinates, CellState> cells, CellNeighborhood neighborhoodStrategy, CellStateFactory stateFactory, int size) {
        super(cells, neighborhoodStrategy, stateFactory);
        this.size = size;
    }

    public Automaton1Dim(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Automaton1Dim{" +
                "size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Automaton1Dim that = (Automaton1Dim) o;

        return size == that.size;
    }

    @Override
    public int hashCode() {
        return size;
    }

    @Override
    protected boolean hasNextCoordinates(CellCoordinates cellC) {
        return !(((Coords1D) cellC).getX() >= size);
    }

    @Override
    protected CellCoordinates initialCoordinates(CellCoordinates cellC) {
        return new Coords1D(-1);
    }

    @Override
    protected CellCoordinates nextCoordinates(CellCoordinates cellC) {
        return new Coords1D(((Coords1D) cellC).getX() + 1);
    }
}
