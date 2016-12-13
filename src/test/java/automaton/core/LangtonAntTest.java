package automaton.core;

import automaton.core.coords.Coords2D;
import automaton.core.state.AntState;
import automaton.core.state.BinaryState;
import automaton.core.state.LangtonCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 10/12/2016.
 */
public class LangtonAntTest {
    @Test
    public void nextCellState() {

        LangtonAnt langtonAnt = new LangtonAnt(null,null,null,30,30);

        Coords2D cellCoords = new Coords2D(21, 16);

        Coords2D cellCoords1 = new Coords2D(20, 15);
        Coords2D cellCoords2 = new Coords2D(21, 15);
        Coords2D cellCoords3 = new Coords2D(22, 15);
        Coords2D cellCoords4 = new Coords2D(20, 16);
        Coords2D cellCoords5 = new Coords2D(22, 16);
        Coords2D cellCoords6 = new Coords2D(20, 17);
        Coords2D cellCoords7 = new Coords2D(21, 17);
        Coords2D cellCoords8 = new Coords2D(22, 17);

        Cell cell = new Cell(cellCoords, new LangtonCell(BinaryState.ALIVE, AntState.NONE));

        Set<Cell> set = new HashSet<>();
        set.add(new Cell(cellCoords1, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords2, new LangtonCell(BinaryState.DEAD, AntState.NORTH)));
        set.add(new Cell(cellCoords3, new LangtonCell(BinaryState.ALIVE, AntState.NONE)));
        set.add(new Cell(cellCoords4, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords5, new LangtonCell(BinaryState.DEAD, AntState.NORTH)));
        set.add(new Cell(cellCoords6, new LangtonCell(BinaryState.DEAD, AntState.EAST)));
        set.add(new Cell(cellCoords7, new LangtonCell(BinaryState.ALIVE, AntState.NONE)));
        set.add(new Cell(cellCoords8, new LangtonCell(BinaryState.DEAD, AntState.NONE)));

        Assert.assertEquals("Langton should come here",
                new LangtonCell(BinaryState.ALIVE, AntState.WEST),
                langtonAnt.nextCellState(cell, set));

    }

    @Test
    public void nextCellStateAntWrapping() {


        LangtonAnt langtonAnt = new LangtonAnt(null,null,null,5,5);

        Coords2D cellCoords = new Coords2D(2, 4);

        Coords2D cellCoords1 = new Coords2D(1, 0);
        Coords2D cellCoords2 = new Coords2D(2, 0);
        Coords2D cellCoords3 = new Coords2D(3, 0);
        Coords2D cellCoords4 = new Coords2D(1, 3);
        Coords2D cellCoords5 = new Coords2D(2, 3);
        Coords2D cellCoords6 = new Coords2D(3, 3);
        Coords2D cellCoords7 = new Coords2D(1, 4);
        Coords2D cellCoords8 = new Coords2D(3, 4);

        Cell cell = new Cell(cellCoords, new LangtonCell(BinaryState.DEAD, AntState.NONE));

        Set<Cell> set = new HashSet<>();
        set.add(new Cell(cellCoords1, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords2, new LangtonCell(BinaryState.DEAD, AntState.EAST)));
        set.add(new Cell(cellCoords3, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords4, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords5, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords6, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords7, new LangtonCell(BinaryState.DEAD, AntState.NONE)));
        set.add(new Cell(cellCoords8, new LangtonCell(BinaryState.DEAD, AntState.NONE)));

        Assert.assertEquals("Langton cross the limit of the board",
                new LangtonCell(BinaryState.DEAD, AntState.NORTH),
                langtonAnt.nextCellState(cell, set));

    }

}