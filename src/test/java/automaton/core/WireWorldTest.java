package automaton.core;

import automaton.core.coords.Coords2D;
import automaton.core.state.WireElectronState;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 10/12/2016.
 */
public class WireWorldTest {
    @Test
    public void nextCellState() throws Exception {

        WireWorld wireWorld = new WireWorld();
        Coords2D tmpCoords = new Coords2D(20, 30);

        Cell voidCell = new Cell(tmpCoords, WireElectronState.VOID);
        Cell wireCell = new Cell(tmpCoords, WireElectronState.WIRE);
        Cell headCell = new Cell(tmpCoords, WireElectronState.ELECTRON_HEAD);
        Cell tailCell = new Cell(tmpCoords, WireElectronState.ELECTRON_TAIL);

        Set<Cell> neighbors1Cell = new HashSet<Cell>();
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));
        neighbors1Cell.add(new Cell(tmpCoords, WireElectronState.WIRE));

        Assert.assertEquals("Void cell should always stay void",
                true, wireWorld.nextCellState(voidCell,
                        neighbors1Cell).equals(WireElectronState.VOID));


    }
}