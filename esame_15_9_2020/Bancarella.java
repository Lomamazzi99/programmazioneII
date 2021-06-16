import java.util.Objects;

/**
 * Overview:
 * Le istanze di questa classe rappresentano una bancarella la quale possiede un proprietario, un listino prezzi e un iventario.
 * Gli oggetti di questa classe sono mutabili
 */
public class Bancarella {

    /**il nome del proprietario */
    private final String proprietario;
    /**Il listino prezzi della bancarella */
    private static ListinoPrezzi listino;
    /**La struttura dati dell'inventario della bancarella */
    private Inventario inventario;

    /**
     * Funzione d'astrazione: AF(proprietario,listino,inventario) = 
     *                        = Bancarella di proprietario
     *                          num. getQuantità(i) di getGiocattolo(i), prezzo getPrezzo(i) con i = 0,..., n con n dimensione dell'inventario
     * 
     */

     /**
      * Post condizioni: inzializza this affinchè rappresenti una bancarella
                         solleva un'eccezione di tipo NullPointerException nel caso in cui l'inv. sia null
                         solleva un'eccezione di tipo NullPointerException nel caso in cui il prop. sia null
                         solleva un'eccezione di tipo NullPointerException nel caso in cui il listino prezzi sia null
                         solleva un'eccezione di tipo NullPointerException nel caso in il nome del proprietario sia vuoto
      */
    public Bancarella(String proprietario, Inventario inventario,ListinoPrezzi lp){
        Objects.nonNull(proprietario);

        if(proprietario.compareTo(" ") == 0) throw new IllegalArgumentException();
        this.proprietario = proprietario;


        Objects.nonNull(inventario);
        this.inventario = inventario;

        Objects.nonNull(lp);
        listino = lp;
    }

    /**
     * Post condizioni: restituisce la quantità di un dato giocattolo
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il giocattolo sia null
     * 
     */
    public int getQuantità(Giocattolo g){
        Objects.nonNull(g);
        return inventario.getQuantità(g);
    }

    /**
     * Post condizioni: stampa a video il costo per singolo giocattolo e il costo totale nel caso in cui si volessero comprare tutti
     */
    public int getSingoloPrezzo(Giocattolo g){
        return listino.getPrezzoUnitario(g);
    }

    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni: dato un giocattolo e la sua quantità da acquistare effettua l'acquisto e restituisce il prezzo pagato
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il giocattolo sia null
     *                  solleva un'eccezione di tipo IllegalArgumentException nel caso in cui la quantità sia negativa sia null
     *                  
     */
    public int Acquista(Giocattolo g,int N){
        Objects.nonNull(g);
        if(N <= 0) throw new IllegalArgumentException();
        int costo = listino.Acquista(N, g); 
        for(int i = 0; i < N;i++)
            if(inventario.getQuantità(g) > 0)
                inventario.removeGiocattolo(g);       
        return costo;
    }

    public boolean contains(Giocattolo g){
        return inventario.contains(g);
    }

    public String getProprietario() {
        return proprietario;
    }
    
    @Override
    public String toString() {
        String s = "Bancarella di: " + proprietario;
        for(int i = 0; i < inventario.size()-1;i++){
            Giocattolo g = inventario.getGiocattolo(i);
            s += "\n num. " + inventario.getQuantità(g) + " " + g;
            s += ", prezzo: " + listino.getPrezzoUnitario(g);
            
        }
        s += "\n num. " + inventario.getQuantità(inventario.getGiocattolo(inventario.size()-1)) + " " + inventario.getGiocattolo(inventario.size()-1);
        s += ", prezzo: " + listino.getPrezzoUnitario(inventario.getGiocattolo(inventario.size()-1));

        return s;
    }

}
