package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords1D;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 21/11/2016.
 *
 * @author EwaStachów
 * @version 1.0
 *          Klasa generująca sąsiedztwo na podstawie stykania się bokami komórek
 */
public class OneDimNeighborhood implements CellNeighborhood {

    private boolean wrapping;
    private int radious;
    private int size;

    /**
     * Konstruktor parametryczny
     *
     * @param wrapping czy plansza ma być zawijana? true - tak, false - nie
     * @param radious  promień sąsiedztwa
     * @param size     szerokość planszy
     */
    public OneDimNeighborhood(boolean wrapping, int radious, int size) {
        this.wrapping = wrapping;
        this.radious = radious;
        this.size = size;
    }

    /**
     * @param cell komórka której sąsiadów będziemy wyznaczać
     * @return Po zaimplementowaniu ma zwracać sąsiadów komórki podanej jako parametr
     */
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
