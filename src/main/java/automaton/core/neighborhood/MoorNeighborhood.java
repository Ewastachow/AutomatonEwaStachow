package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords2D;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EwaStachów on 21/11/2016.
 *
 * @author EwaStachów
 * @version 1.0
 *          Klasa generująca sąsiedztwo na podstawie stykania się bokami lub kątami komórek
 */
public class MoorNeighborhood implements CellNeighborhood {

    private boolean wrapping;
    private int radious;
    private int height;
    private int width;

    public MoorNeighborhood() {
        this.wrapping = false;
        this.radious = 1;
        this.height = 20;
        this.width = 20;
    }

    /**
     * Konstruktor parametryczny
     *
     * @param wrapping czy plansza ma być zawijana? true - tak, false - nie
     * @param radious  promień sąsiedztwa
     * @param width    szerokość planszy
     * @param height   wysokość planszy
     */
    public MoorNeighborhood(boolean wrapping, int radious, int width, int height) {
        this.wrapping = wrapping;
        this.radious = radious;
        this.height = height;
        this.width = width;
    }

    /**
     * @param cell komórka której sąsiadów chcemy uzyskać
     * @return Metoda zwracająca seta z coordynatami sąsiadów
     */
    @Override
    public Set<CellCoordinates> cellNeighbors(CellCoordinates cell) {

        Set<CellCoordinates> cellsNeighbors = new HashSet<>();

        for (int i = -radious; i <= radious; i++) {
            for (int j = -radious; j <= radious; j++) {
                if ((i != 0) || (j != 0)) {
                    if ((((Coords2D) cell).getX() + i >= 0) &&
                            (((Coords2D) cell).getX() + i < width) &&
                            (((Coords2D) cell).getY() + j >= 0) &&
                            (((Coords2D) cell).getY() + j < height)) {
                        cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i), (((Coords2D) cell).getY() + j)));
                    } else if (wrapping) {
                        if ((((Coords2D) cell).getX() + i >= 0) &&
                                (((Coords2D) cell).getX() + i < width) &&
                                (((Coords2D) cell).getY() + j < 0)) {
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i), (((Coords2D) cell).getY() + j + height)));
                        } else if ((((Coords2D) cell).getX() + i < 0) &&
                                (((Coords2D) cell).getY() + j >= 0) &&
                                (((Coords2D) cell).getY() + j < height)) {
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i + width), (((Coords2D) cell).getY() + j)));
                        } else if ((((Coords2D) cell).getX() + i >= 0) &&
                                (((Coords2D) cell).getX() + i < width) &&
                                (((Coords2D) cell).getY() + j >= height)) {
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i), (((Coords2D) cell).getY() + j - height)));
                        } else if ((((Coords2D) cell).getX() + i >= width) &&
                                (((Coords2D) cell).getY() + j >= 0) &&
                                (((Coords2D) cell).getY() + j < height)) {
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i - width), (((Coords2D) cell).getY() + j)));
                        } else if ((((Coords2D) cell).getX() + i < 0) &&
                                (((Coords2D) cell).getY() + j < 0)) {
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i + width), (((Coords2D) cell).getY() + j + height)));
                        } else if ((((Coords2D) cell).getX() + i >= width) &&
                                (((Coords2D) cell).getY() + j < 0)) {
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i - width), (((Coords2D) cell).getY() + j + height)));
                        } else if ((((Coords2D) cell).getX() + i >= width) &&
                                (((Coords2D) cell).getY() + j >= height)) {
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i - width), (((Coords2D) cell).getY() + j - height)));
                        } else
                            cellsNeighbors.add(new Coords2D((((Coords2D) cell).getX() + i + width), (((Coords2D) cell).getY() + j - height)));
                    }
                }
            }
        }
        return cellsNeighbors;
    }
}
