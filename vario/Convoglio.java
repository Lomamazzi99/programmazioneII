import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Un convoglio.
 * 
 * Questa classe immutabile ha il compito di costruire un convoglio come un insieme di rotabili.
 * Un convoglio possiede un nome, una testa e una coda (nel caso in cui essa sia diversa dalla testa).
 * Un convoglio risulta valido nel caso in cui la potenza totale di questo sia maggiore o uguale
 * rispetto al peso complessivo dei suoi rotabili.
 */
public class Convoglio{
    public final String nome,testa,coda;
    public final ArrayList<Rotabile> convoy = new ArrayList<>();
    private final ArrayList<String> modelliConvoy = new ArrayList<>();


    public Convoglio(String s){
        if(s == null) throw new NullPointerException("il nome non può essere null");        
        this.nome = s.split(" ")[0];
        this.testa = s.split(" ")[1];
        if(s.split(" ")[1] != s.split(" ")[s.split(" ").length-1]) this.coda = s.split(" ")[s.split(" ").length-1];
        else this.coda = this.testa;
    }

    public final void addModello(String s){
        if(s == null) throw new NullPointerException("la stringa non può essere null");
        for(int i = 0; i < s.split(" ").length;i++){
            this.modelliConvoy.add(s.split(" ")[i]);
        }
    }

    public final void addRotabile(String s){
        if(s.split(" ")[0].equals("L")){
            Locomotore l = new Locomotore(s.split(" ")[1], Integer.parseInt(s.split(" ")[2]));
            l.setPotenza(s.split(" ")[3]);
            this.convoy.add(l);
        }else if (s.split(" ")[0].equals("V")) {
            Vagone v = new Vagone(s.split(" ")[1], Integer.parseInt(s.split(" ")[2]));
            v.getDotazioni(s);
            this.convoy.add(v);
        }
        this.repOk();
    }

    /**
     * Questo metodo ha il compito di sommare le Dotazioni presenti all'interno del convoglio
     * Nel caso in cui non vi siano presenti vagoni all'interno del convoglio
     * verrà restituito un insieme vuoto; in caso contrario l'insieme restituito
     * sarà formato da dotazioni,contenute una sola volta, la cui quantità è data
     * dalla somma delle quantità di tali dotazioni all'interno dell'intero convoglio.
     */
    private final HashMap<String,Integer> sommaDotazioni(){

        Iterator<Rotabile> t = this.convoy.iterator();
        HashMap<String,Integer> m = new HashMap<>();
        int count = 0;

        while(t.hasNext()){
            if(t.next() instanceof Vagone){
                Vagone v = (Vagone) this.convoy.get(count);

                for(int i = 0; i < v.insieme.size();i++){
                    if(!m.containsKey(v.insieme.get(i).nome))
                        m.put(v.insieme.get(i).nome,v.insieme.get(i).quantità);
                    else{
                        int quantità = m.get(v.insieme.get(i).nome);
                        m.replace(v.insieme.get(i).nome, quantità+v.insieme.get(i).quantità);
                    }
                }
            }
            count++;
        }
        return m;
    }

    /**
     * Questo metodo calcola la potenza totale del convoglio 
     */
    private long potenzaConvoglio(){
        long potenza = 0;
      
        if(!(this.convoy.get(0) instanceof Locomotore)) return 0;
        else{
            Locomotore l = (Locomotore) this.convoy.get(0);
            potenza += l.getPotenza();
            if(!(this.convoy.get(this.convoy.size()-1) instanceof Locomotore)) return potenza;
            else{
                Locomotore t = (Locomotore) this.convoy.get(this.convoy.size()-1);
                potenza += t.getPotenza();
            }
        }
        return potenza;
    }

    /**
     * Questo metodo calcola il peso totale del convoglio 
     */
    private long pesoConvoglio(){
        long weight = 0;
        Iterator<Rotabile> t = this.convoy.iterator();
        while(t.hasNext()){
            weight += t.next().peso;
        }
        return weight;
    }

    /**
     * Un convoglio rispetta la sua rappresentazione se ogni rotabile in posizione i
     * è tale che esso non sia ripetuto all'interno del convoglio e che il proprio nome
     * combaci con quello definito inizialmente.
     */
    public boolean repOk(){
        for(int i = 0; i < this.modelliConvoy.size();i++){
            if(!this.modelliConvoy.get(i).equals(this.convoy.get(i).modello)) return false;
        }
        return true;
    }
    
    /**
     * Questo metodo ha il compito di definire se un convoglio saia "valido" o meno.
     * Un convoglio si dice valido quando il suo peso non supera la potenza totale.
     */
    public final boolean Validità(){
        if(pesoConvoglio() > potenzaConvoglio()) return false;
        return true;
    }

    public String toString(){
        if(Validità()) return String.format("%s %d %d %s valido",
        this.nome,pesoConvoglio(),this.potenzaConvoglio(),sommaDotazioni());

        return String.format("%s %d %d %s non valido",
        this.nome,pesoConvoglio(),this.potenzaConvoglio(),sommaDotazioni());
    }
}