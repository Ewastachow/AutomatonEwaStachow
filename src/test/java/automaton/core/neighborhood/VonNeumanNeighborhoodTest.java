package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords2D;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 03/12/2016.
 */
public class VonNeumanNeighborhoodTest {

    @Test
    public void cellNeighborsTest() {

        VonNeumanNeighborhood vnn = new VonNeumanNeighborhood();

        CellCoordinates cellCoordinatesInside = new Coords2D(10, 10);

        Set<CellCoordinates> cellNeighborsCoordinatesInside = new HashSet<>();
        cellNeighborsCoordinatesInside.add(new Coords2D(9, 10));
        cellNeighborsCoordinatesInside.add(new Coords2D(10, 9));
        cellNeighborsCoordinatesInside.add(new Coords2D(10, 11));
        cellNeighborsCoordinatesInside.add(new Coords2D(11, 10));

        Assert.assertEquals("VonNeumanNeighborhood cell inside, radious = 1",
                cellNeighborsCoordinatesInside,
                vnn.cellNeighbors(cellCoordinatesInside));
    }

    @Test
    public void cellNeighborsWrappingTest() {

        VonNeumanNeighborhood vnn = new VonNeumanNeighborhood(true,2,10,5);

        CellCoordinates cellCoordinatesInside = new Coords2D(1, 3);

        Set<CellCoordinates> cellNeighborsCoordinatesInside = new HashSet<>();
        cellNeighborsCoordinatesInside.add(new Coords2D(1, 0));
        cellNeighborsCoordinatesInside.add(new Coords2D(1, 1));
        cellNeighborsCoordinatesInside.add(new Coords2D(1, 2));
        cellNeighborsCoordinatesInside.add(new Coords2D(1, 4));
        cellNeighborsCoordinatesInside.add(new Coords2D(9, 3));
        cellNeighborsCoordinatesInside.add(new Coords2D(0, 3));
        cellNeighborsCoordinatesInside.add(new Coords2D(2, 3));
        cellNeighborsCoordinatesInside.add(new Coords2D(3, 3));

        Assert.assertEquals("VonNeumanNeighborhood cell [1,3] in 10x5, radious = 2, wrapping",
                cellNeighborsCoordinatesInside,
                vnn.cellNeighbors(cellCoordinatesInside));
    }
}