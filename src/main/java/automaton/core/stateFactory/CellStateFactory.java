package automaton.core.stateFactory;

import automaton.core.coords.CellCoordinates;
import automaton.core.state.CellState;

/**
 * Created by EwaStachów on 16/11/2016.
 */
public interface CellStateFactory {
    CellState initialState(CellCoordinates cellCoords);
}
