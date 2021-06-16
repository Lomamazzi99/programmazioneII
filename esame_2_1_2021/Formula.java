import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Ovewrview:
 * Le istanze di questa classe rappresentano una formula di una cella;
 * Gli oggetti di questa classe sono mutabili;
 * Ogni formula è formata da un'operazione a da un insieme di riferimenti a delle Celle;
 */

public class Formula implements Contenuto {

    /**La struttura dati che definisce l'operazione della formula */
    private final Operazione op;
    /**La struttura dati contenenti i riferimenti alle Celle */
    private List<Cella> riferimenti;

    /**
     * Funzione d'astrazione: AF(op,riferimenti) =  {riferimenti.get(0) op riferimenti.get(1) op .... op riferimenti.get(n) = getContenuto()} con n dimensione della lista dei riferimenti
     *                                              {riferimenti.get(0) op riferimenti.get(1)} se nella lista dei riferimenti vi sono solo due elementi
     * 
     * Invariante di rappresentazione:  l'operazione non può essere null
     *                                  lista di riferimenti presa non può essere null
     *                                  un riferimento ad una cella non può essere null
     *                                  la dimensione dell'insieme di riferimetni  non può essere minore di 2
     *                                  un riferimento deve essere unico nella lista di riferimenti 
     */

    /**
     * Post condizioni: inizializza this affinchè rappresenti una Formula
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui l'operazione presa in input sia null
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui la lista di riferimenti presa in input sia null
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui un riferimento ad una cella sia null
     *                  solleva un'eccezione di tipo IllegalArgumentException nel caso in cui la dimensione dell'insieme di riferimetni sia minore di 2
     *                  solleva un'eccezione di tipo IllegalArgumentException nel caso in cui la un riferimento non sia unico nella lista di riferimenti 
     */
    public Formula(Operazione op,List<Cella> riferimenti){
        Objects.nonNull(op);
        
        this.op = op;

        Objects.nonNull(riferimenti);
        if(riferimenti.size() < 2) throw new IllegalArgumentException();
        if(checkDuplicate(riferimenti)) throw new IllegalArgumentException();

        for(Cella c : riferimenti){
            Objects.nonNull(c);
        }
        this.riferimenti = new ArrayList<>(riferimenti);

    }

    /**
     * Post condizioni: calcola il valore dato dall'operazione della formula tra i suoi riferimenti 
     */
    private int calcValore(){
        return op.perform(toListOfInt());
    }

    /**
     * Post condizioni: restituisce true nel caso in cui vi sia un duplicato di un riferimento nella lista dei riferimenti,altrimenti restituisce false
     */
    private boolean checkDuplicate(List<Cella> riferimenti){
        for(Cella c : riferimenti){
            if(riferimenti.indexOf(c) != riferimenti.lastIndexOf(c)) return true;
        }
        return false;
    }

    /**
     * Post condizioni: trasforma la lista dei riferimenti in un array di int e lo restituisce
     */
    private int[] toListOfInt(){
        int[] ai = new int[riferimenti.size()];
        for(int i = 0; i < ai.length;i++){
            ai[i] = riferimenti.get(i).getContenuto();
        }
        return ai;
    }

    @Override
    public int getContenuto() {
        return calcValore();
    }

    @Override
    public String toString() {
        String s = "{";
        for(int i = 0; i < riferimenti.size()-1;i++){
            Cella c = riferimenti.get(i);
            s += "Cella: " + c.toString() + " valore: " + c.getContenuto();
            s += " " + op + " " ;
        }
        s += "Cella: " + riferimenti.get(riferimenti.size()-1).toString() + " valore: " + riferimenti.get(riferimenti.size()-1).getContenuto();
        s += " = " + getContenuto() + "}";
        return s;
    }
    
}
