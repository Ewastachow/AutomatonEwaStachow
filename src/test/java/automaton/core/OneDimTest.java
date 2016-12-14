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
    public void nextCellState30() throws Exception {

        OneDim od = new OneDim(20, 30);

        CellCoordinates coords1d = new Coords1D(10);
        CellCoordinates coords1dLeft = new Coords1D(9);
        CellCoordinates coords1dRight = new Coords1D(11);

        Cell deadCell = new Cell(coords1d, BinaryState.DEAD);

        Set<Cell> situation4 = new HashSet<>();
        situation4.add(new Cell(coords1dLeft, BinaryState.ALIVE));
        situation4.add(new Cell(coords1dRight, BinaryState.DEAD));

        Assert.assertEquals("DeadCell in fourth situation, should be Alive rule 30",
                BinaryState.ALIVE, od.nextCellState(deadCell, situation4));

    }

    @Test
    public void nextCellState60() throws Exception {

        OneDim od = new OneDim(20, 60);

        CellCoordinates coords1d = new Coords1D(0);
        CellCoordinates coords1dRight = new Coords1D(1);

        Cell deadCell = new Cell(coords1d, BinaryState.DEAD);

        Set<Cell> situation7 = new HashSet<>();
        situation7.add(new Cell(coords1dRight, BinaryState.ALIVE));

        Assert.assertEquals("DeadCell in seventh situation, should be Dead rule 60",
                BinaryState.DEAD, od.nextCellState(deadCell, situation7));

    }

    @Test
    public void nextCellState45() throws Exception {

        OneDim od = new OneDim(20, 45);

        CellCoordinates coords1d = new Coords1D(16);
        CellCoordinates coords1dLeft = new Coords1D(15);
        CellCoordinates coords1dRight = new Coords1D(17);

        Cell deadCell = new Cell(coords1d, BinaryState.DEAD);

        Set<Cell> situation8 = new HashSet<>();
        situation8.add(new Cell(coords1dLeft, BinaryState.DEAD));
        situation8.add(new Cell(coords1dRight, BinaryState.DEAD));

        Assert.assertEquals("DeadCell in eighth situation, should be Alive rule45",
                BinaryState.ALIVE, od.nextCellState(deadCell, situation8));

    }

    @Test
    public void nextCellState45Situation2() throws Exception {

        OneDim od = new OneDim(20, 45);

        CellCoordinates coords1d = new Coords1D(4);
        CellCoordinates coords1dRight = new Coords1D(5);
        CellCoordinates coords1dLeft = new Coords1D(3);

        Cell aliveCell = new Cell(coords1d, BinaryState.ALIVE);

        Set<Cell> situation2 = new HashSet<>();
        situation2.add(new Cell(coords1dLeft, BinaryState.ALIVE));
        situation2.add(new Cell(coords1dRight, BinaryState.DEAD));

        Assert.assertEquals("AliveCell in second situation, should be Dead rule 45",
                BinaryState.DEAD, od.nextCellState(aliveCell, situation2));

    }

    @Test
    public void nextCellState45Situation6() throws Exception {

        OneDim od = new OneDim(20, 45);

        CellCoordinates coords1d = new Coords1D(4);
        CellCoordinates coords1dRight = new Coords1D(5);
        CellCoordinates coords1dLeft = new Coords1D(3);

        Cell aliveCell = new Cell(coords1d, BinaryState.ALIVE);

        Set<Cell> situation6 = new HashSet<>();
        situation6.add(new Cell(coords1dLeft, BinaryState.DEAD));
        situation6.add(new Cell(coords1dRight, BinaryState.DEAD));

        Assert.assertEquals("AliveCell in sixth situation, should be Alive rule 45",
                BinaryState.ALIVE, od.nextCellState(aliveCell, situation6));

    }

}