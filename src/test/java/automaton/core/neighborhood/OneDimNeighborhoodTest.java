package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords1D;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 12/12/2016.
 */
public class OneDimNeighborhoodTest {
    @Test
    public void cellNeighborsRightWithoutWrapping() throws Exception {

        OneDimNeighborhood odn = new OneDimNeighborhood(
                false, 1, 30);

        CellCoordinates cellCoordinatesRight = new Coords1D(29);

        Set<CellCoordinates> cellNeighborsCoordinatesRight = new HashSet<>();
        cellNeighborsCoordinatesRight.add(new Coords1D(28));

        Assert.assertEquals("Neighborhoods cell right",
                cellNeighborsCoordinatesRight,
                odn.cellNeighbors(cellCoordinatesRight));

    }

    @Test
    public void cellNeighborsRightWithWrappingRadious2() throws Exception {

        OneDimNeighborhood odn = new OneDimNeighborhood(
                true, 2, 30);

        CellCoordinates cellCoordinatesLeft = new Coords1D(0);

        Set<CellCoordinates> cellNeighborsCoordinatesLeft = new HashSet<>();
        cellNeighborsCoordinatesLeft.add(new Coords1D(1));
        cellNeighborsCoordinatesLeft.add(new Coords1D(2));
        cellNeighborsCoordinatesLeft.add(new Coords1D(28));
        cellNeighborsCoordinatesLeft.add(new Coords1D(29));

        Assert.assertEquals("Neighborhoods cell left with wrapping radious=2",
                cellNeighborsCoordinatesLeft,
                odn.cellNeighbors(cellCoordinatesLeft));

    }

}