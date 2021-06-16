
/**
 * Overview:
 * Le istanze di questa classe rappresentano un locomotore il quale è un sottotipo della classe rotabile.
 * Esso è definito, oltre che dal nome e dal peso, da una potenza.
 * Gli oggetti di questa classe sono immutabili.
 */

public class Locomotore extends Rotabile{

    /**La potenza del vagone */
    private final int potenza;

    /**
     * Funzione d'astrazione: AF(potenza) = AF_rotabile + potenza
     * 
     * Invariante di rappresentazione: potenza non può essere negativa
     */

    /**
     * Post condizioni: inizializza this affinchè rappresenti un locomotore
     *                  Ipotizzo che le postcondizioni e le precondizioni del supertipo sia rispettate
     *                  solleva un'eccezione nel caso in cui la potenza presa in input sia negativa
     */

    public Locomotore(String modello, int peso,int potenza) {
        super(modello, peso);
        if(potenza <= 0) throw new IllegalArgumentException();
        this.potenza = potenza;
    }

    public int getPotenza() {
        return potenza;
    }

    @Override
    public String getModello() {
        return super.getModello();
    }

    @Override
    public int getPeso() {
        return super.getPeso();
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if(!(obj instanceof Locomotore)) return false;
        Locomotore l = (Locomotore) obj;

        return l.potenza == potenza;
    }

    @Override
    public int hashCode() {
        int result = 31*super.hashCode();
        result += Integer.hashCode(potenza);
        return result;
    }

    @Override
    public String toString() {
        String s = "Locomotore: " + super.toString();
        s += ", potenza = " +potenza;
        return s;
    }


    
}
