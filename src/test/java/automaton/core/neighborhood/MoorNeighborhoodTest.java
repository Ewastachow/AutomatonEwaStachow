package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords2D;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachow on 22/11/2016.
 */
public class MoorNeighborhoodTest {

    @Test
    public void cellNeighborsTest() {
        MoorNeighborhood mn = new MoorNeighborhood();

        CellCoordinates cellCoordinatesInside = new Coords2D(10, 10);
        CellCoordinates cellCoordinatesLeftDownCorner = new Coords2D(0, 19);

        Set<CellCoordinates> cellNeighborsCoordinatesInside = new HashSet<>();
        cellNeighborsCoordinatesInside.add(new Coords2D(9, 9));
        cellNeighborsCoordinatesInside.add(new Coords2D(9, 10));
        cellNeighborsCoordinatesInside.add(new Coords2D(9, 11));
        cellNeighborsCoordinatesInside.add(new Coords2D(10, 9));
        cellNeighborsCoordinatesInside.add(new Coords2D(10, 11));
        cellNeighborsCoordinatesInside.add(new Coords2D(11, 9));
        cellNeighborsCoordinatesInside.add(new Coords2D(11, 10));
        cellNeighborsCoordinatesInside.add(new Coords2D(11, 11));

        Set<CellCoordinates> cellNeighborsCoordinatesLeftDownCorner = new HashSet<>();
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(0, 18));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(1, 18));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(1, 19));

        Assert.assertEquals("Neighborhoods cell inside",
                cellNeighborsCoordinatesInside,
                mn.cellNeighbors(cellCoordinatesInside));
        Assert.assertEquals("Neighborhoods cell LeftDownCorner",
                cellNeighborsCoordinatesLeftDownCorner,
                mn.cellNeighbors(cellCoordinatesLeftDownCorner));

    }

    @Test
    public void cellNeighborsWrappingTest() {
        MoorNeighborhood mn = new MoorNeighborhood(
                true, 1, 10, 30);

        CellCoordinates cellCoordinatesLeftDownCorner = new Coords2D(0, 29);

        Set<CellCoordinates> cellNeighborsCoordinatesLeftDownCorner = new HashSet<>();
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(0, 0));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(0, 28));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(1, 0));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(1, 28));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(1, 29));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(9, 0));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(9, 28));
        cellNeighborsCoordinatesLeftDownCorner.add(new Coords2D(9, 29));

        Assert.assertEquals("Neighborhoods cell inside",
                cellNeighborsCoordinatesLeftDownCorner,
                mn.cellNeighbors(cellCoordinatesLeftDownCorner));

    }
}