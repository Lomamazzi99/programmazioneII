/**
 * Un rotabile.
 * 
 * Questa classe astratta ha il compito di implementare un rotabile come
 * superclasse di un Locomotore o di un Vagone ma anche di altre sottoclassi
 * se necessario.  
 */
public abstract class Rotabile{
    /**
     * Le variabili d'istanza sono dichiarate protected final perché in questo
     * modo possono essere accessibili alle sottoclassi senza però poter essere modifcate.
     */
    protected final String modello;
    protected final int peso;

    /**
     * Il costruttore è sempre valido tranne nel caso in cui il @param modello sia null, nel qual
     * caso viene sollevata un'eccezione, o nel caso in cui il peso sia negativo, sollevando un'eccezione
     * L'invarianza viene anche qui mantenuta poiché vi è un unico costruttore.
     */
    public Rotabile(final String modello, final int peso){
        if(modello == null) throw new NullPointerException("modello non null");
        this.modello = modello;
        if(peso <= 0) throw new IllegalArgumentException("peso non <=");
        this.peso = peso;
    }

    public abstract boolean repOk();
    public abstract String toString();

}