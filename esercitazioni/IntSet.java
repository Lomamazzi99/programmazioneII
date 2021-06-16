import java.util.ArrayList;
import java.util.List;
/**
 * TerzaEs
 * Insieme di interi: progettare e implementare una gerarchia di oggetti
 * utile a rappresentare insiemi di interi dove il termine insieme è inteso in senso matematico
 * 
 * Creiamo una classe concreta IntSet che deve avere un costruttore privo di parametri 
 * che consentirà di creare un insieme vuoto
 * 
 * Una volta che un oggetto esiste deve avere dei metodi per aggiungere e rimuovere elementi 
 * dall'insieme
 * 
 * La classe deve avere inoltre:
 * Metodo con prototipo "int choose()" che deve restituire un intero scelto arbitrariamente tra
 * gli elementi di un'istanza e sollevare un'eccezione del tipo EmptyException se l'insieme è vuoto
 * 
 * Metodo con prototipo "int intSize()" deve restituire la cardialità dell'insieme
 * 
 * Metodo con prototipo "contains(int x)" deve restituire true se l'elemento x è nell'insieme, false altrimenti
 * 
 * Metodo "toString()"
 */

/**
 * OVERVIEW : Le istanze di questa classe rappresentano insiemi (non limitati) di
 *             interi. Gli oggetti di questo tipo SONO mutabili (da specificare sempre se lo sono o no)
 */

//automaticamente la classe che dichiariamo estende Object
public class IntSet {

    //CAMPI
    /**
     * Struttura dati contenente gli elementi dell'insieme
     */
    private List<Integer> elements;


    /**
     * Se avessimo degli oggetti da modificare allora dovremmo scriverlo negli effetti collaterali
     * Post condizioni: Inizializza un nuovo insieme di interi vuoto
     */
    public IntSet() {
        elements = new ArrayList<>();
    }

    /**
     * Effetti collaterali: potrebbe modificare this: this_post = this + {x} 
     * Post condizioni: aggiunge n all'insieme 
     */
    public void insert(int n){
        //preferiamo sempre this all'elements se abbiamo già il metodo
        if(!this.contains(n)) elements.add(n);
        assert repOk();
    }

    /**
     * Effetti collaterali: potrebbe modificare this: this_post = this - {x} 
     * Post condizioni: rimuovere n dall'insieme se presente
     */
    public void remove(int n){
        /*
        Le API dicono che per ArrayList:
        remove​(int index)Removes the element at the specified position in this list.
        remove​(Object o)Removes the first occurrence of the specified element from this list, 
        if it is present.(quindi non c'è bisogno di controllarlo)
        Meglio usare valueOf piuttosto che un casting
        Quando facciamo remove rimuoviamo un riferimento 
        elements.remove(Integer.valueOf(n)); 
        */

        int index = elements.indexOf(n);
        if(index != -1){
            int lastIndex = elements.size()-1;
            elements.set(index, elements.get(lastIndex));
            elements.remove(lastIndex);
        }
        assert repOk();
    }


    /**
     * Post condizione: deve restituire un intero scelto arbitrariamente tra 
     * gli elementi di un'istanza e sollevare un'eccezione del tipo EmptyException  
     * se l'insieme è vuoto (devo creare l'eccezione)
     */

    public int choose(){
        //scegliamo il primo elemento
        if(size() == 0) throw new EmptyException("Impossibile estrarre elemento. Insieme vuoto");
        return elements.get(elements.size()-1);
    }

    /**
     * Post condizioni: restituisce la cardialità dell'insieme this
     */

     public int size(){
        return elements.size();
    }


     /**
      * Post condizioni: deve restituire true se l'elemento n è nell'insieme, false altrimenti
      */
     public boolean contains(int n){
        return elements.contains(n);
    }

    /**
     * Funzione di astrazione: AF(elements) = 
     *                         = {elements[i] | 0 <= i <= elements.length}
     *                         = {} se elements.length == 0
     * 
     * Invariante di rappresentazione: elements non deve essere null
     *                                 elements[i] != elements[j] per ogni i,j all'interno di elements
     */

    /**
     * Post condizioni: restituisce una rappresentazione testuale di this ad esempio {1, 2, 3}
     */
    @Override
    public String toString(){
        assert repOk();
        String s = "IntSet: {";
        if(size() > 0){
            for(int i = 0; i < size()-1;i++){
                s += elements.get(i) +", ";
            }
        }
        s += elements.get(size()-1);
        return s + "}";
    }

    private boolean repOk(){
        if(elements == null) return false;
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < elements.size(); j++) {
                if (i != j && elements.get(i) == elements.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        
    }
}
