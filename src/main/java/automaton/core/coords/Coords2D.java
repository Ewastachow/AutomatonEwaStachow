package automaton.core.coords;

/**
 * Created by EwaStachów on 16/11/2016.
 */
public class Coords2D implements CellCoordinates, Comparable<Coords2D> {
    private int x;
    private int y;

    public Coords2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coords2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coords2D coords2D = (Coords2D) o;

        if (x != coords2D.x) return false;
        return y == coords2D.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int compareTo(Coords2D c) {
        if (this.x == c.x && this.y == c.y)
            return 0;
        else if (this.x > c.x)
            return 1;
        else if (this.x == c.x && this.y > c.y)
            return 1;
        else
            return -1;
    }
}
