package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords2D;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.CellState;
import automaton.core.state.WireElectronState;
import automaton.core.stateFactory.CellStateFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by EwaStachów on 03/12/2016.
 */
public class WireWorld extends Automaton2Dim {

    public WireWorld() {
        super();
    }

    public WireWorld(Map<CellCoordinates, CellState> cells, CellNeighborhood neighborhoodStrategy, CellStateFactory stateFactory) {
        super(cells, neighborhoodStrategy, stateFactory);
    }

    public WireWorld(Map<CellCoordinates, CellState> cells, CellNeighborhood neighborhoodStrategy, CellStateFactory stateFactory, int width, int height) {
        super(cells, neighborhoodStrategy, stateFactory, width, height);
    }

    @Override
    protected Automaton newInstance(CellStateFactory cellSF, CellNeighborhood cellN) {
        Map<CellCoordinates, CellState> cells = new TreeMap<>();
        Set<CellCoordinates> coords = new TreeSet<>();
        for (int i = 1; i <= getWidth(); i++)
            for (int j = 1; j <= getHeight(); j++) {
                CellCoordinates cc = new Coords2D(i, j);
                coords.add(cc);
            }
        for (CellCoordinates key : coords) {
            cells.put(key, cellSF.initialState(key));
        }
        return new WireWorld(cells, cellN, cellSF);
    }

    @Override
    protected CellState nextCellState(Cell currentState, Set<Cell> neighborsStates) {
        if ((currentState.state).equals(WireElectronState.VOID)) return WireElectronState.VOID;
        int cellsStateHead = 0;
        for (Cell i : neighborsStates) {
            if (i.state.equals(WireElectronState.ELECTRON_HEAD))
                cellsStateHead++;
        }
        if ((currentState.state).equals(WireElectronState.ELECTRON_HEAD)) {
            return WireElectronState.ELECTRON_TAIL;
        } else if ((currentState.state).equals(WireElectronState.ELECTRON_TAIL)) {
            return WireElectronState.WIRE;
        } else {
            if ((cellsStateHead == 1) || (cellsStateHead == 2))
                return WireElectronState.ELECTRON_HEAD;
            else
                return WireElectronState.WIRE;
        }
    }
}
