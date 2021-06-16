import java.util.ArrayList;
import java.util.List;

/** la trasmissione semplice, a cui corrisponde una sola fascia betaoraria; */

/**
 * overview: 
 * Le istanze di questa classe rappresentano una trasmissione semplice, la quale è una sottoclasse di Trasmissione.
 * Gli oggetti di questa classe sono immutabili.
 */
public class TrasmissioneSemplice extends Trasmissione {

    /**L'unità dati che rappresenta l'unica fascia della Trasmissione */
    private final FasciaBetaoraria unicaFascia;

    /**
     * Funzione d'astrazione: unicaFascia titolo
     * Invariante di rappresentazione: IR_trasmissione
     *                                 unicaFascia non null
     */

    /**
     * Post condizioni: inizializza this affinchè rappresenti una trasmissione semplice
     *                  Ipotizzo che le pre e post condizioni del supertipo siano valide
     *                  
     */
    public TrasmissioneSemplice(String titolo, List<FasciaBetaoraria> fasce) {
        super(titolo, fasce);
        FasciaBetaoraria fb = fasce.get(0);
        unicaFascia = new FasciaBetaoraria(fb.getBetaorarioInizio(),fb.getDurata());
    }


    /**
     * Post condizioni: restituisce il titolo della trasmissione
     */
    @Override
    public String getTitolo() {
        return titolo;
    }

    /**
     * @return the unicaFascia
     */
    public List<FasciaBetaoraria> getFasce() {
        List<FasciaBetaoraria> f = new ArrayList<>();
        f.add(unicaFascia);
        return f;
    }



    /**
     * Due trasmissioni semplici sono uguali se hanno lo stesso titolo e la stessa fascia oraria
     */
    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if (!(obj instanceof TrasmissioneSemplice))
            return false;
        TrasmissioneSemplice ts = (TrasmissioneSemplice) obj;
        return ts.unicaFascia.equals(unicaFascia) && ts.titolo == titolo;
    }

    @Override
    public int hashCode() {
        int result = 31 * super.hashCode();
        result += unicaFascia.hashCode();
        return result;
    }


    @Override
    public String toString() {
        String s = "";
        s += unicaFascia.toString() + " " + titolo;
        return s;
    }

}
