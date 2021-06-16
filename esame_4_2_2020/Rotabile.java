import java.util.Objects;

/**
 * Overview:
 * Le istanze di questa classe rappresentano un rotabile il quale è definito da un modello e un peso.
 * Gli oggetti di questa classe sono immutabili.
 */
public class Rotabile {
    /**Il modello del  rotabile*/
    private final String modello;
    /**Il peso del  rotabile*/
    private final int peso;

    /**
     * Post condizioni: inizializza this affinchè rappresenti un modello
     *                  solleva un'eccezione nel caso in cui il modello preso in input sia null
                        solleva un'eccezione nel caso in cui il peso preso in input sia negativo
     */
    public Rotabile(final String modello,final int peso){
        Objects.nonNull(modello);
        if(peso <= 0) throw new IllegalArgumentException();
        this.modello = modello;
        this.peso = peso;
    }

    /**
     * Post condizioni: restituisce il modello del Rotabile
     */
    public String getModello() {
        return modello;
    }

    /**
     * Post condizioni: restituisce il modello del Rotabile
     */
    public int getPeso() {
        return peso;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Rotabile)) return false;
        Rotabile r = (Rotabile) obj;
        return r.modello.equals(modello) && r.peso == peso;
    }

    @Override
    public int hashCode() {
        int result = 31* modello.hashCode();
        result += Integer.hashCode(peso);
        return result;
    }

    @Override
    public String toString() {
        String s = String.format("modello = %s, peso = %d", modello,peso);
        return s;
    }
}
