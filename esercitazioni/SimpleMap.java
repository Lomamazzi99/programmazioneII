import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Esercitazione 5 -> da fare classe test e dimostrazioni
 * Implementare una gerarchia di oggetti utili a rappresentare una semplica mappa da stringhe
 * a interi.Ossia una struttura dati che permetta di associare a ciascuna stringa k (chiave)
 * un numero intero v (valore).
 * 
 * Operazioni di put() e remove() di elementi dalla mappa, tenendo conto che le mappe
 * non possono contenere chiavi duplicate e che ciascuna chiave può essere associata
 * al più ad un valore. Inoltre se l'associazione k -> v è presente nella mappa, dev'essere
 * possibile ottenere (get) il valore v a partire da k.
 * Infine il meotodo repOk(), toString(), equals(),hashCode().
 * 
 * La classe di test deve verificare il comportamento della classe specificata.
 * Legge da un flusso di ingresso una sequenza non limitata di comandi con il seguente
 * formato:
 * + str int che aggiunge alla mappa l'associazione str -> int oppure
 * - str che rimuove dalla mappa l'associazione avente per chiave la stringa str e se tale chiave
 * è presente   stampa nel flusso d'uscita il valore che le corrispondeva
 * 
 * Al temrine della lettura deve emttere quindi nel flusso d'uscita standard. il numero di elementi 
 * contenuti nella mappa.
 * 
 * Dimostrare correttezza, invariante di rapp e invariante di astrazione
 * 
 */


 /**
  * OVERVIEW : le istanze di questa classe rappresentano mappe che associano ad una stringa (chiave) un intero (valore).
               Gli oggetti di questa classe sono mutabili.
               Una mappa da stringhe a interi tipica è: {K1 : V1, K2 : V2,... ,Kh : Vh} dove h è la dimensione della mappa.
               {K1,K2,...,Kh} sono chiavi uniche, quindi Ki != Kj se i != j
               Ad ogni chiave è associato un unico valore.

               A seguito di un'operazione di inserimento dell'associazione k -> v, la nuova mappa sarà
               {K1 : V1, K2 : V2,... ,Kh : Vh, K : V} se k != Ki per i = 1,...,h
               {K1 : V1, K2 : V2,...,Kj : v, ,Kh : Vh} se esiste un j tale èer cui Kj = k
  */

public class SimpleMap {
    //ATTRIBUTI
    private List<String> chiavi;
    private List<Integer> valori;
    

    //COSTRUTTORI
    /**
     * Funzione di astrazione: AF(chiavi, valori) = 
     *                         = {k_i : v_i | 1 <= i < n, k_i = chiavi[i], v_i = valori[i]}, con n numero di associazioni nella mappa
     *                         = {} se n è pari a 0
     * 
     * Invariante di rappresentazione: chiavi e valori not null
     *                                 chiavi e valori non contengono valori null
     *                                 chiavi.size() == valori.size()
     *                                 chiavi non contiene valori duplicati
     * 
     * Invariante di astrazione: Le chiavi all'interno di SimpleMap sono uniche
     *                           A ogni chiave è associato un solo valore
     *                           Il numero di elementi k->v in ciascuna SimpleMap è maggiore o uguale a 0
     */

    /**
     * Post condizioni: Inizializza this affinchè rappresenti la mappa vuota.           
     */
    public SimpleMap(){
        chiavi = new LinkedList<>();
        valori = new LinkedList<>();
        repOk();
    }
    //METODI


    /**
     * Effetti collaterali: potrebbe aggiornare this
     * Post condizioni: aggiorna la mappa e aggiunge l'associazione k -> v se k non è altrimenti,
     *                  altrimenti aggiorna il valore associato a k.
     *                  Solleva un'eccezione di tipo NullPointerException se k == null.
     */
    public void put(String k, int v){
        Objects.nonNull(k);
        if(!chiavi.contains(k)){
            chiavi.add(k);
            int index = chiavi.indexOf(k);
            if(valori.get(index) != null) valori.set(index, v);
            else valori.add(index, v);
        }
    }

     /**
     * Effetti collaterali: aggiorna this
     * Post condizioni: rimuove l'associazione k -> v se k è presente
     */
    public void remove(String k){
        if(chiavi.contains(k)){
            int index = chiavi.indexOf(k);
            chiavi.remove(k);
            valori.remove(index);
        }
    }

    /**
     * Post condizoni: restituisce il valore v associato a k se k è presente nella mappa,
     *                 altrimenti solleva un'eccezione di tipo NoSuchElementException.
     */
    public int get(String k){
        if(!chiavi.contains(k)) throw new NoSuchElementException("la chiave k non è presente nella mappa");
        return valori.get(chiavi.indexOf(k));
    }

    /**
     * Post condizioni: restituisca true nel caso in cui k sia presente nella mappa,
     *                  altrimenti false.
     */
    public boolean containsKey(String k){
        return chiavi.contains(k);
    }

    /**
     * Post condizioni: restituisce il numero di associazioni presenti nella mappa
     */
    public int size(){
        return chiavi.size();
    }

    /**
     * Post condizioni: restituisce true se il primo indice in cui si trova un elemento k è diverso 
     *                  dal suo ultimo indice (l'elemento è quindi ripetuto nella mappa),
     *                  false altrimenti
     * 
     */
    public boolean hasDuplicate(){
        for(int i = 0; i < size();i++){
            if(chiavi.indexOf(chiavi.get(i)) != chiavi.lastIndexOf(chiavi.get(i))){
                return true;
            }
        }
        return false;
    }

    // {K1 : V1, K2 : V2,... ,Kh : Vh, K : V}
    @Override
    public String toString(){
        String s = "{";
        for(int i = 0; i < size()-1;i++){
            s += String.format( String.format("%d : %d , ",chiavi.get(i),valori.get(i)));
        }
        s += String.format( String.format("%d : %d , ",chiavi.get(size()-1),valori.get(size()-1)));
        return s += "}";
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof SimpleMap)) return false;
        SimpleMap sm = (SimpleMap) o;
        return  sm.chiavi == this.chiavi
                && sm.valori == this.valori;


    }

    @Override
    public int hashCode(){
        int result = chiavi.hashCode();
        result = 31*result + valori.hashCode();
        return result;
    }

    /**
     * Invariante di rappresentazione: chiavi e valori not null
     *                                 chiavi e valori non contengono valori null
     *                                 chiavi.size() == valori.size()
     *                                 chiavi non contiene valori duplicati
     */
    private boolean repOk(){
        return  chiavi != null
                && valori != null
                && chiavi.size() == valori.size()
                && !chiavi.contains(null)
                && !valori.contains(null)
                && !hasDuplicate();
    }

}
