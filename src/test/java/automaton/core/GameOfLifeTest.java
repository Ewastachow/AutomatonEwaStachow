package automaton.core;

import automaton.core.coords.Coords2D;
import automaton.core.state.BinaryState;
import automaton.core.state.QuadState;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 18/11/2016.
 */
public class GameOfLifeTest {

    @Test
    public void nextCellStateTestGameOfLife() {

        GameOfLife gol = new GameOfLife(null, null, null,
                20, 20, 2, 3, 3, false);
        Coords2D tmpCoords = new Coords2D(20, 30);

        Cell aliveCell = new Cell(tmpCoords, BinaryState.ALIVE);
        Cell deadCell = new Cell(tmpCoords, BinaryState.DEAD);

        Set<Cell> neighbors1Cell = new HashSet<>();
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));

        Set<Cell> neighbors2Cell = new HashSet<>();
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.DEAD));
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.DEAD));
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.DEAD));
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.DEAD));
        neighbors2Cell.add(new Cell(tmpCoords, BinaryState.DEAD));

        Assert.assertEquals("Alive Cell & 8/8 Alive neighbors should be dead",
                BinaryState.DEAD, gol.nextCellState(aliveCell, neighbors1Cell));
        Assert.assertEquals("Dead Cell & 3/8 Alive neighbors should be alive",
                BinaryState.ALIVE, gol.nextCellState(deadCell, neighbors2Cell));
        Assert.assertEquals("Alive Cell & 2/8 Alive neighbors should be alive",
                BinaryState.ALIVE, gol.nextCellState(aliveCell, neighbors2Cell));


    }

    @Test
    public void nextCellStateTestQuadLife() {

        GameOfLife gol = new GameOfLife(
                null, null, null,
                20, 20, 2, 3, 3, true);
        Coords2D tmpCoords = new Coords2D(20, 30);

        Cell blueCell = new Cell(tmpCoords, QuadState.BLUE);

        Set<Cell> neighbors1Cell = new HashSet<>();
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.DEAD));
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.RED));
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.DEAD));
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.GREEN));
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.GREEN));
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.RED));
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.DEAD));
        neighbors1Cell.add(new Cell(tmpCoords, QuadState.GREEN));

        Assert.assertEquals("Blue Cell, 2 Red & 3 Green neighbors ",
                QuadState.DEAD, gol.nextCellState(blueCell, neighbors1Cell));
    }

    @Test
    public void nextCellStateTest2() {

        GameOfLife gol = new GameOfLife(null, null, null,
                20, 20, 4, 3, 3, false);
        Coords2D tmpCoords = new Coords2D(20, 30);

        Cell aliveCell = new Cell(tmpCoords, BinaryState.ALIVE);

        Set<Cell> neighbors1Cell = new HashSet<>();
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.DEAD));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.DEAD));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.ALIVE));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.DEAD));
        neighbors1Cell.add(new Cell(tmpCoords, BinaryState.DEAD));

        Assert.assertEquals("Alive Cell & 4/8 Alive neighbors should be Alive in 43/3",
                BinaryState.ALIVE, gol.nextCellState(aliveCell, neighbors1Cell));

    }
}