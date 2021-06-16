/**
 * Overview:
 * Le istanze di questa classe rappresentano una Coordianta all'interno di un piano cartesiano
 * bidimensionale.
 * Gli oggetti di questa classe sono Immutabili.
 */

public class Coordinata {
    /**L'ascissa della coordinata */
    private final int x;
    /**L'ordinata della coordinata */
    private final int y;

    /**
     * Funzione d'astrazione: AF(x,y) = <x,y>
     * 
     * Invariante di rappresentazione: 
     */

     /**
      * Post condizioni: inizializza this affinchè affinchè rappresenti una coordinata
      * Correttezza: AF(x,y) = <x, y>
      * Preservazione IR:
      */
    public Coordinata(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Post condizioni: restituisce l'ascissa della coordinata
     */
    public int getX() {
        int x = this.x;
        return x;
    }
    /**
     * Post condizioni: restituisce l'ordinata della coordinata
     */
    public int getY() {
        int y = this.y;
        return y;
    }

    @Override
    public String toString() {
        String s = String.format("<%d, %d>",x,y);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Coordinata)) return false;
        Coordinata c = (Coordinata) obj;
        return c.x == x && c.y == y; 
    }

}
