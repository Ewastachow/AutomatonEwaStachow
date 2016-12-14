package automaton.core.coords;

/**
 * Created by EwaStachów on 18/11/2016.
 * <p>
 * Klasa przechowująca położenie komórki na jednowymiarowej planszy
 *
 * @author EwaStachów
 * @version 1.0
 * @see CellCoordinates
 */
public class Coords1D implements CellCoordinates, Comparable<Coords1D> {
    private int x;

    /**
     * Gettet
     * @return Zwraca położenie komórki na planszy
     */
    public int getX() {
        return x;
    }

    /**
     * Konstruktor Coords1D
     *
     * @param x określa położenie komórki na planszy jednowymiarowej
     */
    public Coords1D(int x) {
        this.x = x;
    }

    /**
     * Equals
     * @param o Obiekt dla którego sprawdzamy równość
     * @return boolean true if are equals, false if aren't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coords1D coords1D = (Coords1D) o;
        return x == coords1D.x;
    }

    /**
     * HashCode
     * @return  zwraca położenie komórki
     */
    @Override
    public int hashCode() {
        return x;
    }

    /**
     * toString
     * @return String opisujący położenie komórki
     */
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
