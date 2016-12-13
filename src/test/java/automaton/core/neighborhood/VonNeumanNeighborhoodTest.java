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
}