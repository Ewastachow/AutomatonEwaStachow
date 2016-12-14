package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;

import java.util.Set;

/**
 * Created by EwaStachów on 16/11/2016.
 * @author EwaStachów
 * @version 1.0
 * Interfejs dla klas generujących sąsiedztwo komórek
 * @see MoorNeighborhood
 * @see VonNeumanNeighborhood
 * @see OneDimNeighborhood
 */
public interface CellNeighborhood {
    /**
     * @param cell komórka której sąsiadów będziemy wyznaczać
     * @return Po zaimplementowaniu ma zwracać sąsiadów komórki podanej jako parametr
     */
    Set<CellCoordinates> cellNeighbors(CellCoordinates cell);
}
