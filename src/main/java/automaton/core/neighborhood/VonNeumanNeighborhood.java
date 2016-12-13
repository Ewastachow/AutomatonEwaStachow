package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords2D;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yevvy on 03/12/2016.
 */
public class VonNeumanNeighborhood implements CellNeighborhood {

    private boolean wrapping;
    private int radious;
    private int height;
    private int width;

    public VonNeumanNeighborhood() {
        this.wrapping = false;
        this.radious = 1;
        this.height = 20;
        this.width = 20;
    }

    public VonNeumanNeighborhood(boolean wrapping, int radious, int width, int height) {
        this.wrapping = wrapping;
        this.radious = radious;
        this.height = height;
        this.width = width;
    }

    @Override
    public Set<CellCoordinates> cellNeighbors(CellCoordinates cell) {

        Set<CellCoordinates> cellNeighbors = new HashSet<>();

        for (int i = -radious; i <= radious; i++) {
            if (i != 0) {
                if ((((Coords2D) cell).getX() + i) >= 0) {
                    if ((((Coords2D) cell).getX() + i) < width) {
                        cellNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i), (((Coords2D) cell).getY())));
                    } else if (wrapping) {
                        cellNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i - width), (((Coords2D) cell).getY())));
                    }
                } else if (wrapping) {
                    cellNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i + width), (((Coords2D) cell).getY())));
                }
                if ((((Coords2D) cell).getY() + i) >= 0) {
                    if ((((Coords2D) cell).getY() + i) < height) {
                        cellNeighbors.add(new Coords2D(((Coords2D) cell).getX(), (((Coords2D) cell).getY() + i)));
                    } else if (wrapping) {
                        cellNeighbors.add(new Coords2D(((Coords2D) cell).getX(), (((Coords2D) cell).getY() + i - height)));
                    }
                } else if (wrapping) {
                    cellNeighbors.add(new Coords2D(((Coords2D) cell).getX(), (((Coords2D) cell).getY() + i + height)));
                }
            }
        }

        return cellNeighbors;
    }
}
