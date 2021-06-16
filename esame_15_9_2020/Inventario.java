import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Overview:
 * Le istanze di questa classe rappresentano un inventario.
 * Gli oggetti di questa classe sono mutabili.
 */
public class Inventario {
    /**L'unità dati che contiene i giocattoli */
    private List<Giocattolo> inventario;
    /**La quantità di ciascun giocattolo */
    private List<Integer> quantità;
    
    /**
     * Funzione d'astrazione: AF(inventario, quantità): Quantità AF_giocattolo
     * 
     * Invariante di astrazione: inventario non può essere null
     *                           quantità non può essere null
     *                           ogni elemento nell'inventario è unico
     *                           inventario non ha elementi null
     */

    /**
     * Post condizioni: inzializza this affinchè rappresenti un Inventario
     */
    public Inventario(){
        this.inventario = new ArrayList<>();
        this.quantità = new ArrayList<>();
    }

    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni: aggiunge un giocattolo all'inventario se questo non è presente, altrimenti aumento di 1 la sua quanittà
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il giocattolo sia null
     */
    public void addGiocattolo(Giocattolo g){
        Objects.nonNull(g);
        if(contains(g)){
            //System.out.println("presente");
            int indexOf = inventario.indexOf(g);
            quantità.set(indexOf, quantità.get(indexOf)+1);
        }else{
            //System.out.println("assente");
            inventario.add(g);
            quantità.add(1);
        }

    }

    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni: rimuove un giocattolo all'inventario se la sua quantità è 1, altrimenti diminuisce di 1 la sua quanittà
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il giocattolo sia null
     *                  solleva un'eccezione di tipo IllegalArgumentException nel caso in cui il giocattolo cercato non sia nell'inventario
     *                  
     */
    public void removeGiocattolo(Giocattolo g){
        Objects.nonNull(g);
        if(!contains(g)) throw new IllegalArgumentException();
        
        quantità.set(inventario.indexOf(g), quantità.get(inventario.indexOf(g))-1);
        if(quantità.get(inventario.indexOf(g)) == 0){
            quantità.remove(inventario.indexOf(g));
            inventario.remove(g);
           
        } 
    }

    /**
     * Post condizioni: resituisce true se il giocattolo è contenuto nell'inventario, false altrimenti
     */
    public boolean contains(Giocattolo giocattolo){
        for(Giocattolo g : inventario){
            if(g.equals(giocattolo)) return true;
        }
        return false;
    }

    /**
     * Post condizioni: restituisce true se l'inventario è vuoto, false altrimenti
     */
    public boolean isEmpty(){
        return inventario.isEmpty();
    }

    /**
     * Post condizioni: restituisce la quantità di un giocattolo se è presente,altrimenti restituisce 0
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il giocattolo sia null
     */
    public int getQuantità(Giocattolo g){
        Objects.nonNull(g);
        if(!(contains(g))) return 0;
        return quantità.get(inventario.indexOf(g));
    }

    /**Restituisce la dimensione dell'inventario */
    public int size(){
        return inventario.size();
    }

    /**restituice un giocattolo data la sua posizione nell'inventario */
    public Giocattolo getGiocattolo(int index){
        return inventario.get(index);
    }


    @Override
    public String toString() {
        String s = "{";
        
        for(int i = 0; i<size()-1;i++){
            s += quantità.get(i) + " ";
            
            s += inventario.get(i).toString();
            s += ", ";
        }
        s += quantità.get(size()-1) + " ";
        s += inventario.get(size()-1).toString();
        s+="}";
        return s;
    }

    public Iterator<Giocattolo> interator(){
        return inventario.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Inventario)) return false;
        Inventario inv = (Inventario) obj;
        for(int i = 0; i<inventario.size()-1;i++){
            if(!inv.inventario.contains(inventario.get(i))) return false;
            Giocattolo f = inv.inventario.get(i);
            Giocattolo g = inventario.get(i);
            int indexOfInv = inv.inventario.indexOf(f);
            int indexOfThis = inv.inventario.indexOf(g);

            if(inv.quantità.get(indexOfInv) != inv.quantità.get(indexOfThis)) return false;
        }
        return true;
    }
}
