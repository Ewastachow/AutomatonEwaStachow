package automaton.core.neighborhood;

import automaton.core.coords.CellCoordinates;

import java.util.Set;

/**
 * Created by EwaStachów on 16/11/2016.
 */
public interface CellNeighborhood {
    Set<CellCoordinates> cellNeighbors(CellCoordinates cell);
}
