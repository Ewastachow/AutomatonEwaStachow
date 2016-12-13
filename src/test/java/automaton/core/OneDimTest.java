package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords1D;
import automaton.core.state.BinaryState;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 12/12/2016.
 */
public class OneDimTest {
    @Test
    public void nextCellState() throws Exception {

        OneDim od = new OneDim(20, 30);

        CellCoordinates coords1d = new Coords1D(10);
        CellCoordinates coords1dLeft = new Coords1D(9);
        CellCoordinates coords1dRight = new Coords1D(11);

        Cell deadCell = new Cell(coords1d, BinaryState.DEAD);

        Set<Cell> situation4 = new HashSet<>();
        situation4.add(new Cell(coords1dLeft, BinaryState.ALIVE));
        situation4.add(new Cell(coords1dRight, BinaryState.DEAD));

        Assert.assertEquals("DeadCell in fourth situation, should be Alive",
                BinaryState.ALIVE, od.nextCellState(deadCell, situation4));

    }

}