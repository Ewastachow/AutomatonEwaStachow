package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords2D;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.CellState;
import automaton.core.stateFactory.CellStateFactory;

import java.util.Map;

/**
 * Created by EwaStachów on 03/12/2016.
 * @author EwaStachów
 * @version 1.0
 */
public abstract class Automaton2Dim extends Automaton {
    private int width;
    private int height;

    public Automaton2Dim() {
        super();
        width = 20;
        height = 20;
    }

    public Automaton2Dim(Map<CellCoordinates, CellState> cells, CellNeighborhood neighborhoodStrategy, CellStateFactory stateFactory) {
        super(cells, neighborhoodStrategy, stateFactory);
        width = 20;
        height = 20;
    }

    public Automaton2Dim(Map<CellCoordinates, CellState> cells, CellNeighborhood neighborhoodStrategy, CellStateFactory stateFactory, int width, int height) {
        super(cells, neighborhoodStrategy, stateFactory);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    protected boolean hasNextCoordinates(CellCoordinates cellC) {
        int currentSize = ((Coords2D) cellC).getX() * ((Coords2D) cellC).getY();
        if (currentSize >= (width - 1) * (height - 1)) return false;
        else return true;
    }

    @Override
    protected CellCoordinates initialCoordinates(CellCoordinates cellC) {
        return new Coords2D(0, -1);
    }

    @Override
    protected CellCoordinates nextCoordinates(CellCoordinates cellC) {
        if (((Coords2D) cellC).getY() < (height - 1))
            return new Coords2D(((Coords2D) cellC).getX(),
                    ((Coords2D) cellC).getY() + 1);
        else if (((Coords2D) cellC).getY() == (height - 1))
            return new Coords2D(((Coords2D) cellC).getX() + 1, 0);
        else
            return null;
    }
}
