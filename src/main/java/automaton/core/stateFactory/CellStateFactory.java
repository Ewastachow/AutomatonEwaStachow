package automaton.core.stateFactory;

import automaton.core.coords.CellCoordinates;
import automaton.core.state.CellState;

/**
 * Created by EwaStachów on 16/11/2016.
 * @author EwaStachów
 * @version 1.0
 */
public interface CellStateFactory {
    CellState initialState(CellCoordinates cellCoords);
}
