package automaton.core.stateFactory;

import automaton.core.coords.CellCoordinates;
import automaton.core.state.CellState;

/**
 * Created by EwaStachów on 03/12/2016.
 */
public class UniformStateFactory implements CellStateFactory {

    private CellState state;

    public UniformStateFactory(CellState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniformStateFactory that = (UniformStateFactory) o;

        return state != null ? state.equals(that.state) : that.state == null;
    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UniformStateFactory{" +
                "state=" + state +
                '}';
    }

    @Override
    public CellState initialState(CellCoordinates cellCoords) {
        return state;
    }
}
