import java.util.EmptyStackException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Ovewrview:
 * Le istanze di questa classe rappresentano una PoliticaMoltiplicativa del listino prezzi.
 * Gli oggetti di questa classe sono mutabili
 */
public class PoliticaMoltiplicativa implements ListinoPrezzi{

    /**L'inventario contenente gli oggetti */
    private Inventario inventario;
    private Map<Giocattolo, Integer> prezzoPerGiocattolo;

    /**
     * Post condizioni: inizializza this affinchè rappresenti una PoliticaMoltiplicativa
     *                   solleva un'eccezione di tipo NullPointerException nel caso in cui l'inv. sia null
     *                   solleva un'eccezione di tipo EmptyStackException nel caso in cui l'inventario sia vuoto 
     */
    public PoliticaMoltiplicativa(Inventario inv){
        Objects.nonNull(inv);
        if(inv.isEmpty()) throw new EmptyStackException();
        
        prezzoPerGiocattolo = new TreeMap<>();
        //this.U = U;
        inventario = inv;
    }

    @Override
    public int Acquista(int N,Giocattolo g) {
        if(N <= inventario.getQuantità(g))
            return getPrezzoUnitario(g) * N;
        return getPrezzoUnitario(g) * inventario.getQuantità(g);
    }

    public int getPrezzoUnitario(Giocattolo g) {
        return prezzoPerGiocattolo.get(g);
    }

    public void setPrezzoGiocattolo(Giocattolo g, int U){
        
            prezzoPerGiocattolo.put(g, U);
        }
    }

