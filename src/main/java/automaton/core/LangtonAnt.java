package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.coords.Coords2D;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.AntState;
import automaton.core.state.BinaryState;
import automaton.core.state.CellState;
import automaton.core.state.LangtonCell;
import automaton.core.stateFactory.CellStateFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by EwaStachów on 03/12/2016.
 * @author EwaStachów
 * @version 1.0
 */
public class LangtonAnt extends Automaton2Dim {

    public LangtonAnt(Map<CellCoordinates, CellState> cells,
                      CellNeighborhood neighborhoodStrategy, CellStateFactory factory, int w, int h) {
        super(cells, neighborhoodStrategy, factory, w, h);
    }


    @Override
    protected Automaton newInstance(CellStateFactory cellSF, CellNeighborhood cellN) {
        return new LangtonAnt(super.getCells(), cellN, cellSF, getWidth(), getHeight());
    }

    @Override
    protected CellState nextCellState(Cell currentState, Set<Cell> neighborsStates) {
        LangtonCell currentLangtonCell = (LangtonCell) currentState.state;
        LangtonCell nextState = new LangtonCell(currentLangtonCell.cellState, currentLangtonCell.antState);
        if (currentLangtonCell.antState != AntState.NONE) {
            nextState.antState = AntState.NONE;
            if (currentLangtonCell.cellState == BinaryState.ALIVE)
                nextState.cellState = BinaryState.DEAD;
            else nextState.cellState = BinaryState.ALIVE;
        }
        for (Cell i : neighborsStates) {
            int state = isAntComeOnMe(i, currentState.coords);
            if (state != 0) {
                if (state == 1) {
                    nextState.antState = AntState.NORTH;
                } else if (state == 2) {
                    nextState.antState = AntState.SOUTH;
                } else if (state == 3) {
                    nextState.antState = AntState.EAST;
                } else {
                    nextState.antState = AntState.WEST;
                }
            }
        }
        return nextState;
    }

    private int isAntComeOnMe(Cell otherCell, CellCoordinates me) {
        LangtonCell otherLangtonCell = (LangtonCell) otherCell.state;
        if (otherLangtonCell.antState == AntState.NONE) return 0;
        Coords2D north, south, east, west;
        Coords2D otherCoords = (Coords2D) otherCell.coords;
        north = new Coords2D(((Coords2D) me).getX(), ((Coords2D) me).getY() - 1);
        if(north.getY()<0) north = new Coords2D(north.getX(),north.getY()+super.getHeight());
        south = new Coords2D(((Coords2D) me).getX(), ((Coords2D) me).getY() + 1);
        if(south.getY()>=super.getHeight()) south = new Coords2D(south.getX(),south.getY()-super.getHeight());
        east = new Coords2D(((Coords2D) me).getX() + 1, ((Coords2D) me).getY());
        if(east.getX()>=super.getWidth()) east = new Coords2D(east.getX()-super.getWidth(),east.getY());
        west = new Coords2D(((Coords2D) me).getX() - 1, ((Coords2D) me).getY());
        if(west.getX()<0) west = new Coords2D(west.getX()+super.getWidth(),west.getY());
        if (otherCoords.equals(north))
            if (((otherLangtonCell.antState == AntState.EAST)
                    && (otherLangtonCell.cellState == BinaryState.ALIVE))
                    || ((otherLangtonCell.antState == AntState.WEST)
                    && (otherLangtonCell.cellState == BinaryState.DEAD))) return 2;
        if (otherCoords.equals(south))
            if (((otherLangtonCell.antState == AntState.EAST)
                    && (otherLangtonCell.cellState == BinaryState.DEAD))
                    || ((otherLangtonCell.antState == AntState.WEST)
                    && (otherLangtonCell.cellState == BinaryState.ALIVE))) return 1;
        if (otherCoords.equals(east))
            if (((otherLangtonCell.antState == AntState.SOUTH)
                    && (otherLangtonCell.cellState == BinaryState.ALIVE))
                    || ((otherLangtonCell.antState == AntState.NORTH)
                    && (otherLangtonCell.cellState == BinaryState.DEAD))) return 4;
        if (otherCoords.equals(west))
            if (((otherLangtonCell.antState == AntState.NORTH)
                    && (otherLangtonCell.cellState == BinaryState.ALIVE))
                    || ((otherLangtonCell.antState == AntState.SOUTH)
                    && (otherLangtonCell.cellState == BinaryState.DEAD))) return 3;
        return 0;
    }
}