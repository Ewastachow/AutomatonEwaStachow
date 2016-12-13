package automaton.core.coords;

/**
 * Created by EwaStachów on 18/11/2016.
 */
public class Coords1D implements CellCoordinates, Comparable<Coords1D> {
    private int x;

    public int getX() {
        return x;
    }

    public Coords1D(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coords1D coords1D = (Coords1D) o;
        return x == coords1D.x;
    }

    @Override
    public int hashCode() {
        return x;
    }

    @Override
    public String toString() {
        return "Coords1D{" +
                "x=" + x +
                '}';
    }

    @Override
    public int compareTo(Coords1D c) {
        if (this.x == c.x)
            return 0;
        else if (this.x > c.x)
            return 1;
        else
            return -1;
    }
}
