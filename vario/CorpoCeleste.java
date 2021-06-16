/*
Un corpo celeste è descritto dal suo nome e dalla sua posizione, intesa come punto tridimensionale; 
ciascun corpo celeste ha un'energia pari al prodotto di quella cinetica e potenziale, esprimibile come 
long. Due tipologie di corpi celesti sono pianeti e stelle fisse.
La posizione delle stelle fisse non cambia mai; quella dei pianeti cambia in funzione della loro velocità,
anch'essa modellabile come punto tridimensionale. L'energia cinetica di un pianeta è data dalla norma 
della sua posizione, mentre quella potenziale dalla norma della sua velocità; viceversa, quella delle 
stelle fisse è sempre nulla.
Un pianeta può interagire con altri corpi celesti, come nel seguente esempio.
*/

/**
 * Un corpo celeste.
 * 
 * Questa classe astratta viene utilizzata per implementare i metodi astratti che definiscono un corpo 
 * celeste (come il suo nome, la sua posizione etc) e i metodi concreti che sono tipici di qualsiasi 
 * corpo celeste(energia cinetica e potenziale etc).
 * Utilizzo una classe astratta per rappresentare la gerarchia tra corpo celeste, pianeti e stelle fisse,
 * poichè potrebbero essere implementate altre figure oltre a queste e l'implementazione attraverso
 * interfaccia risulterebbe quindi inefficiente, in quanto si applica meglio a classi che non sono legate
 * tra di loro per quanto concerne l'astrazione.
 */

public abstract class CorpoCeleste{


    //Utilizzo delle istanze protected come variabili d'istanza. 
    //In questo modo esse sono utilizzabili solamente dalle sue sottoclassi e modificate solo attraverso metodi
    //contenuti in quest'ultime.

    protected Punto posizione;
    protected final String nome;
    protected Punto velocità;

    /**
     * Un corpo celeste è definito da:
     * @param s un nome, che non può essere modificiato e non può essere nullo (altrimenti viene sollevata un'eccezione)
     * @param p delle coordinate all'interno dello spazio che non possono essere nulle (altrimenti viene sollevata un'eccezione)
     * ma che possono variare nel corso del tempo
     * 
     * Inoltre ogni corpo celeste ha inizialmente velocità pari a zero che può variare nel corso del tempo.
     */

    protected CorpoCeleste(final String s, Punto p){
        if(p == null)throw new IllegalArgumentException("la posizone di un corpo celeste non può essere nulla");
        posizione = p;
        if(s == null) throw new IllegalArgumentException("il nome di un corpo celeste non può essere nullo");
        nome = s;
        Punto zero = new Punto(0,0,0);
        velocità = zero;
    }
    //resituisce il nome del corpo celeste
    public abstract String nome();

    //resituisce la velocità del corpo celeste
    public abstract Punto getSpeed();

    //aggiorna la posizone di un corpo celeste data la sua velocità attuale
    public abstract void aggiornaPosizione();

    //aggiorna la velocità di un corpo celeste in corrispondenza
    //alle sue coordinate e a quelle di un corpo p a lui vicino
    public abstract void aggiornaVelocità(CorpoCeleste p);
    //resituisce la posizione del corpo celeste
    public abstract Punto posizione();

     //resituisce l'energia cinetica secondo la formula
     //"L'energia cinetica di un pianeta è data dalla norma della sua posizione"
    public long Ecinetica(Punto p){
        return p.norma();
    }

     //resituisce l'energia potenziale secondo la formula
     //"L'energia potenziale di un pianeta è data dalla norma della sua velocità"
    public long Epotenziale(Punto velocità){
        return velocità.norma();
    }

    //resituisce l'energia totale data dal prodotto tra l'energia potenziale e cinetica
    //entrambe le energia devono essere positive poichè date dalla norma della posizione e della velocità.
    //Nel caso in cui una di esse non sia positiva viene sollevata un'eccezione.
    public long Energia(long c, long p) throws IllegalArgumentException{
        try{
        if(c >= 0){
            try{
            if(p >= 0);
            }catch(Exception e){
                throw new IllegalArgumentException("l'energia potenziale deve essere >= 0");
            }
        }
    }catch(Exception e){
        throw new IllegalArgumentException("l'energia cientica deve essere >= 0");
    }
    return (c*p);
}

    public String toString(){
        return String.format("nome: %s, coordinate: %d %d %d", nome, posizione.x,posizione.y,posizione.z);
    }
}
