/**
 * Overview:
 * Le istanze di questa classe rappresentano una costante.
 * Gli oggetti di questa classe sono immutabili
 */

public class Costante implements Contenuto{

    /**Il valore della costante */
    private final int valore;

    /**
     * Funzione d'astrazione: AF(valore) = valore
     */

    /**
     * Post condizioni: inizializza this affinchè rappresenti una costante
     */
    public Costante(int valore){
        this.valore = valore;
    }

    @Override
    public int getContenuto() {
        return valore;
    }

    @Override
    public String toString() {
        return String.format("%d",valore);
    }
    
}
