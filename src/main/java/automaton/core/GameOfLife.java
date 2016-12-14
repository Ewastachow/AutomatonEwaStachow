package automaton.core;

import automaton.core.coords.CellCoordinates;
import automaton.core.neighborhood.CellNeighborhood;
import automaton.core.state.BinaryState;
import automaton.core.state.CellState;
import automaton.core.state.QuadState;
import automaton.core.stateFactory.CellStateFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by EwaStachów on 10/11/2016.
 * @author EwaStachów
 * @version 1.0
 */
public class GameOfLife extends Automaton2Dim {
    private int rule1;
    private int rule2;
    private int rule3;

    private boolean quadLife;

    public GameOfLife() {
        super();
        this.rule1 = 2;
        this.rule2 = 3;
        this.rule3 = 3;
        quadLife = false;
    }

    public GameOfLife(Map<CellCoordinates, CellState> cells,
                      CellNeighborhood neighborhoodStrategy,
                      CellStateFactory stateFactory,
                      int width, int height,
                      int rule1, int rule2, int rule3,
                      boolean quadLife) {
        super(cells, neighborhoodStrategy, stateFactory, width, height);
        this.rule1 = rule1;
        this.rule2 = rule2;
        this.rule3 = rule3;
        this.quadLife = quadLife;
    }

    @Override
    protected Automaton newInstance(CellStateFactory cellSF, CellNeighborhood cellN) {
        return new GameOfLife(super.getCells(), cellN, cellSF, super.getWidth(), super.getHeight(), rule1, rule2, rule3, quadLife);
    }

    @Override
    protected CellState nextCellState(Cell currentState, Set<Cell> neighborsState) {
        if (!quadLife) {
            int neighborsAlive = 0;
            for (Cell i : neighborsState) {
                if (i.state.equals(BinaryState.ALIVE)) {
                    neighborsAlive++;
                }
            }
            if (currentState.state.equals(BinaryState.ALIVE)) {
                if ((neighborsAlive != rule1) && (neighborsAlive != rule2)) {
                    return BinaryState.DEAD;
                }
            } else {
                if (neighborsAlive == rule3) {
                    return BinaryState.ALIVE;
                }
            }
            return currentState.state;
        } else {
            int neighborsRed = 0;
            int neighborsYellow = 0;
            int neighborsBlue = 0;
            int neighborsGreen = 0;
            for (Cell i : neighborsState) {
                if (i.state.equals(QuadState.RED)) {
                    neighborsRed++;
                } else if (i.state.equals(QuadState.YELLOW)) {
                    neighborsYellow++;
                } else if (i.state.equals(QuadState.BLUE)) {
                    neighborsBlue++;
                } else if (i.state.equals(QuadState.GREEN)) {
                    neighborsGreen++;
                }
            }
            CellState mostColor;
            if ((neighborsRed > neighborsYellow) &&
                    (neighborsRed > neighborsBlue) &&
                    (neighborsRed > neighborsGreen)) {
                mostColor = QuadState.RED;
            } else if ((neighborsBlue > neighborsYellow) &&
                    (neighborsBlue > neighborsRed) &&
                    (neighborsBlue > neighborsGreen)) {
                mostColor = QuadState.BLUE;
            } else if ((neighborsYellow > neighborsRed) &&
                    (neighborsYellow > neighborsBlue) &&
                    (neighborsYellow > neighborsGreen)) {
                mostColor = QuadState.YELLOW;
            } else if ((neighborsGreen > neighborsYellow) &&
                    (neighborsGreen > neighborsRed) &&
                    (neighborsGreen > neighborsBlue)) {
                mostColor = QuadState.GREEN;
            } else if (currentState.state == QuadState.DEAD) mostColor = QuadState.GREEN;
            else mostColor = currentState.state;
            int neighborsAlive = 0;
            for (Cell i : neighborsState) {
                if (!i.state.equals(QuadState.DEAD)) {
                    neighborsAlive++;
                }
            }
            if (!currentState.state.equals(QuadState.DEAD)) {
                if ((neighborsAlive != rule1) && (neighborsAlive != rule2)) {
                    return QuadState.DEAD;
                }
            } else {
                if (neighborsAlive == rule3) {
                    return mostColor;
                }
            }
            if (currentState.state == QuadState.DEAD)
                return QuadState.DEAD;
            else return mostColor;
        }
    }
}
