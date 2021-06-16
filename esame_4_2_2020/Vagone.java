import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Overview:
 * Le istanze di questa classe rappresentano un vagone il quale è un sottotipo della classe rotabile.
 * Esso è definito, oltre che dal nome e dal peso, da un insieme di dotazioni.
 * Gli oggetti di questa classe sono mutabili.
 * Normalmente un vagone si presenta nella forma:
 * Locomotore: modello, peso,  {dotazioni.get(0), dotazioni.get(1),...,dotazione.get(k),...dotazioni.get(n)|i =0,...,n } con n numero di elementi nell'insieme
 * Nel caso in cui una dotazione non presente nel vagone venga aggiunta in posizione k+1 allora il vagone diventa della forma:
 * Locomotore: modello, peso,  {dotazioni.get(0), dotazioni.get(1),...,dotazione.get(k),dotazione.get(k+1),..,dotazioni.get(n) |i =0,...,n } con n numero di elementi nell'insieme
 * Nel caso in cui una dotazione presente nel vagone venga rimossa in posizione k allora il vagone diventa della forma:
 * Locomotore: modello, peso,  {dotazioni.get(0), dotazioni.get(1),...dotazione.get(k-1),...,dotazioni.get(n) |i =0,...,n } con n numero di elementi nell'insieme
 */

public class Vagone extends Rotabile implements Iterable<Dotazione>{

    /**La struttura dati contenente le dotazioni */
    private List<Dotazione> dotazioni;

    /**
     * Funzione d'astrazione: AF(dotazioni) = AF_rotabile + {dotazioni.get(0), dotazioni.get(1),...,dotazioni.get(n)|i =0,...,n} con n numero di elementi nell'insieme
     *                                      = AF_rotabile nel caso in cui l'insieme delle dotazioni sia vuoto
     * 
     * Invariante di rappresentazione: IR_rotabile
     *                                 dotazioni non può essere null
     *                                 dotazioni non può avere elementi null
     *                                 gli elementi di dotazioni sono tutti unici
     */


    /**
     * Post condizioni: inizializza this affinchè rappresenti un vagone
     *                  Ipotizzo siano rispettate le postcondizioni e precondizioni della superclasse
     *                  solleva un'eccezione nel caso in cui l'insieme delle dotazioni preso in input sia null
                        solleva un'eccezione nel caso in cui un elemento dell'insieme delle dotazioni preso in input sia null
                        solleva un'eccezione nel caso in cui due elementi dell'insieme delle dotazioni preso in input siano uguali
     */
    public Vagone(String modello, int peso) {
        super(modello, peso);
        Objects.nonNull(dotazioni);
        this.dotazioni = new ArrayList<>();
    }

    /**
     * Post condizioni: restituisce true se nell'insieme delle dotazioni abbiamo una dotazione non univoca
     */
    public boolean checkDuplicates(){
        for(Dotazione d : dotazioni){
            if(dotazioni.indexOf(d) != dotazioni.lastIndexOf(d)) return false;
        }
        return false;
    }

    /**
     * Post condizioni: restituisce true se la dotazione presa in input appartenga all'insieme delle dotazioni
     *                  solleva un'eccezione nel caso in cui la dotazione in input sia null
     */
    public boolean contains(Dotazione d){
        Objects.nonNull(d);
        return dotazioni.contains(d);
    }

    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni: aggiunge a this una dotazione nel caso in cui essa non sia già presente,
     *                  altrimenti ne aggiorna la quantità
     *                  solleva un'eccezione nel caso in cui la dotazione presa in input sia null
     *                  solleva un'eccezione nel caso in cui la dotazione presa in input sia un duplicato e 
     *                  ne riaggiorna il valore a quello originale
     */

    public void insertDotazione(Dotazione d){
        Objects.nonNull(d);
        if(contains(d)){
            int indexof = dotazioni.indexOf(d);
            Dotazione oldDotazione = dotazioni.get(indexof);
            dotazioni.set(indexof, new Dotazione(d.getNome(),oldDotazione.getQuantità() + d.getQuantità()));
            if(checkDuplicates()){
                dotazioni.set(indexof, oldDotazione);
                throw new IllegalArgumentException();
            }
            return;
        }

        dotazioni.add(d);
    }

    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni: rimuove a this una dotazione nel caso in cui essa sia già presente,
     *                  altrimenti ne solleva un'eccezione
     *                  solleva un'eccezione nel caso in cui la dotazione presa in input sia null
     *                  
     */

    public void removeDotazione(Dotazione d){
        Objects.nonNull(d);
        if(!contains(d)) throw new IllegalArgumentException();
        dotazioni.remove(d);
    }

    public int size(){
        return dotazioni.size();
    }

    public Dotazione getDotazione(int index){
        if(index < 0) throw new IllegalArgumentException();
        Dotazione d = new Dotazione(dotazioni.get(index).getNome(),dotazioni.get(index).getQuantità());
        return d;
    }

    public int getQuantitàOf(Dotazione d){
        Objects.nonNull(d);
        if(!contains(d)) throw new IllegalArgumentException();

        int num = 0;
        for(Dotazione dot : dotazioni){
            if(dot.equals(d)) num += dot.getQuantità();
        }
        return num;
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
        if(!(obj instanceof Vagone)) return false;
        Vagone v = (Vagone) obj;
        
        return v.dotazioni.containsAll(dotazioni); 
    }

    @Override
    public int hashCode() {
        int result = 31*super.hashCode();
        result += dotazioni.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String s = "Vagone: " + super.toString();
        s += ", dotazioni: [";
        Collections.sort(dotazioni);
        for(int i = 0; i < dotazioni.size()-1;i++){
            s += dotazioni.get(i).toString() + ", ";
        }
        s += dotazioni.get(dotazioni.size()-1).toString();
        s += "]";
        return s;
    }

    @Override
    public Iterator<Dotazione> iterator() {
        return dotazioni.iterator();
    }
    
}
