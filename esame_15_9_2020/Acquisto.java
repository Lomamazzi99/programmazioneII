import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Overview:
 * Le istanze di questa classe rappresent un Acquisto effettuato da un compratore.
 * Gli oggetti di questa classe sono mutabili.
 */
public class Acquisto {
    /**Il giocattolo acquistato */
    public final Giocattolo giocattolo;
    /**La quantità acquistata */
    public int quantità;
    /**Il prezzo pagato */
    public int prezzoPagato;
    /**Le bancarelle da cui si vuole comprare il giocattolo */
    private List<Bancarella> bancarelle;
    /**Da chi è stato comprato e quanti */
    private Map<String, Integer> fromWho;

    public Acquisto(Giocattolo giocattolo,int quantità,List<Bancarella> bancarelle){
        Objects.nonNull(giocattolo);
        Objects.nonNull(bancarelle);
        if(quantità <= 0) throw new IllegalArgumentException();

        this.giocattolo = giocattolo;
        this.quantità = quantità;
       
        for(Bancarella b : bancarelle){
            Objects.nonNull(b);
        }

        this.bancarelle = bancarelle;
        fromWho = new TreeMap<>();

    }

    /**
     * Post condizioni: restituisce l'insieme di bancarelle che posseggono il giocattolo.
     *                  Se nessuna bancarella ha il giocattolo solleva un'eccezione di tipo NoGiocattoloInAnyException
     */
    private List<Bancarella> ContainsGiocattolo(){
        List<Bancarella> b = new ArrayList<Bancarella>();
        for(Bancarella bancarella : bancarelle){
            if(bancarella.contains(giocattolo)){
                b.add(bancarella);
            }
        }
        if(b.isEmpty()) throw new NoGiocattoloInAnyException();
        return b;
    }



    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni:Effettua l'acquisto della quantità di giocattoli desiderata e definisce il numero di giocattoli che si è riusciti ad acquistare,il prezzo totale e da chi
     *                 
     */
    public void effettuaAcquisto(){
        List<Bancarella> bancarella = ContainsGiocattolo();
        int daAcquistare = quantità;
        
        int costo = 0;
        for(Bancarella b: bancarella){
            Objects.nonNull(b);

            int q = b.getQuantità(giocattolo);
            
            if(q > daAcquistare){
                
                costo += b.Acquista(giocattolo, daAcquistare);
                fromWho.put(b.getProprietario(), daAcquistare);
                daAcquistare = 0;
                break;
            }else if(q <= daAcquistare && q > 0){
                
                costo += b.Acquista(giocattolo, q);
                fromWho.put(b.getProprietario(), q);
                daAcquistare -= q;
                
            }
            
        }
        prezzoPagato = costo;
    }
    

    @Override
    public String toString() {
        String s = "Acquisto di: " +giocattolo;
        s += ", per un costo di: " +prezzoPagato;
        s += ", numero: " + quantità;
        
        s += ", di cui: \n";
        for(Map.Entry<String, Integer> me : fromWho.entrySet()){
            s += me.getValue() + " da " + me.getKey() + "\n";
        }
        return s;
    }

}
