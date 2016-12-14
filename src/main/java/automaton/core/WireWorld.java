package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.CellState;
import automaton.core.state.WireElectronState;
import automaton.core.stateFactory.CellStateFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by EwaStachów on 03/12/2016.
 * @author EwaStachów
 * @version 1.0
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
        return new WireWorld(super.getCells(), cellN, cellSF);
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
