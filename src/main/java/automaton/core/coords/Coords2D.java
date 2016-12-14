package automaton.core.coords;

/**
 * Created by EwaStachów on 16/11/2016.
 * @author EwaStachów
 * @version 1.0
 * Klasa przechowująca położenie komórki na dwuwymiarowej planszy
 * @see CellCoordinates
 */
public class Coords2D implements CellCoordinates, Comparable<Coords2D> {
    private int x;
    private int y;

    /**
     * Konstruktor
     * @param x współrzędna wskazująca na to na jakiej szerokości planszy się znajduje
     * @param y wskazująca na to na jakiej wysokości planszy się znajduje
     */
    public Coords2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * GetterX
     * @return int na jakiej szerokości planszy znajduje się komórka
     */
    public int getX() {
        return x;
    }

    /**
     * GetterY
     * @return int na jakiej wysokości planszy znajduje się komórka
     */
    public int getY() {
        return y;
    }

    /**
     * toString
     * @return String opisujący położenie komórki
     */
    @Override
    public String toString() {
        return "Coords2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Equals
     * @param o Obiekt dla którego sprawdzamy równość
     * @return boolean true if are equals, false if aren't
     */
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
