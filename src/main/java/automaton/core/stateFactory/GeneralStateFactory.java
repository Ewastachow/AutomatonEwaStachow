package automaton.core.stateFactory;

import automaton.core.coords.CellCoordinates;
import automaton.core.state.CellState;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by EwaStachów on 03/12/2016.
 * @author EwaStachów
 * @version 1.0
 */
public class GeneralStateFactory implements CellStateFactory {

    private Map<CellCoordinates, CellState> states = new TreeMap<>();

    public GeneralStateFactory(Map<CellCoordinates, CellState> state) {
        for (Map.Entry<CellCoordinates, CellState> entry : state.entrySet()) {
            states.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "GeneralStateFactory{" +
                "states=" + states +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralStateFactory that = (GeneralStateFactory) o;

        return states != null ? states.equals(that.states) : that.states == null;
    }

    @Override
    public int hashCode() {
        return states != null ? states.hashCode() : 0;
    }

    @Override
    public CellState initialState(CellCoordinates cellCoords) {
        return states.get(cellCoords);
    }
}
