package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords1D;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 12/12/2016.
 */
public class OneDimNeighborhood implements CellNeighborhood {

    private boolean wrapping;
    private int radious;
    private int size;

    public OneDimNeighborhood(boolean wrapping, int radious, int size) {
        this.wrapping = wrapping;
        this.radious = radious;
        this.size = size;
    }

    @Override
    public Set<CellCoordinates> cellNeighbors(CellCoordinates cell) {

        Set<CellCoordinates> cellsNeighbors = new HashSet<>();

        if (!wrapping) {
            for (int i = -radious; i < (radious + 1); i++) {
                if ((i != 0) &&
                        (((Coords1D) cell).getX() + i >= 0) &&
                        (((Coords1D) cell).getX() + i < size)) {
                    cellsNeighbors.add(new Coords1D((((Coords1D) cell).getX() + i)));
                }
            }
        } else {
            for (int i = -radious; i < (radious + 1); i++) {
                if (i != 0) {
                    if ((((Coords1D) cell).getX() + i >= 0) && (((Coords1D) cell).getX() + i < size))
                        cellsNeighbors.add(new Coords1D((((Coords1D) cell).getX() + i)));
                    else if (((Coords1D) cell).getX() + i < 0)
                        cellsNeighbors.add(new Coords1D((((Coords1D) cell).getX() + size + i)));
                    else cellsNeighbors.add(new Coords1D((((Coords1D) cell).getX() - size + i)));
                }
            }

        }
        return cellsNeighbors;
    }
}
