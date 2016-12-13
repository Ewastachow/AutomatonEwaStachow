package automaton.core.state;

/**
 * Created by EwaStachów on 10/12/2016.
 */
public class LangtonCell implements CellState {

    public BinaryState cellState;
    public AntState antState;

    public LangtonCell(BinaryState binaryState, AntState antState) {
        cellState = binaryState;
        this.antState = antState;
    }

    @Override
    public String toString() {
        return "LangtonCell{" +
                "cellState=" + cellState +
                ", antState=" + antState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LangtonCell that = (LangtonCell) o;

        if (cellState != that.cellState) return false;
        return antState == that.antState;
    }

    @Override
    public int hashCode() {
        int result = cellState.hashCode();
        result = 31 * result + antState.hashCode();
        return result;
    }
}
