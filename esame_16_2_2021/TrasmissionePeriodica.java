import java.util.ArrayList;
import java.util.List;

/**
 * la trasmissione periodica, che si ripete all'interno dello stesso giorno in
 * un assegnato numero di fasce betaorarie, tutte della medesima durata e che
 * iniziano a una distanza data da un assegnato numero di betaminuti;
 */

/** PERIODICA 13:30 40 2 1120 Ricette del giorno */
/**l'ora di inizio e la durata della prima fascia oraria, nonché il numero di ripetizioni e 
 * la distanza in minuti tra l'inizio di due fasce consecutive, per le trasmissioni periodiche. */

/**
 * Overview: Le istanze di questa classe rappresentano una trasmissione
 * periodica, che si ripete all'interno dello stesso giorno in un assegnato
 * numero di fasce betaorarie, tutte della medesima durata e che iniziano a una
 * distanza data da un assegnato numero di betaminuti;
 * Un'istanza periodica è un sottotipo della classe Trasmissione semplice.
 * Gli ogetti di questa classe sono immutabili.
 */

public class TrasmissionePeriodica extends TrasmissioneSemplice {

    /**Il numero delle ripetizioni della trasmissione */
    private final int numRep;
    /**I betaminuti tra una ripetzione e l'altra */
    private final int betaminutiRep;


    /**
     * Funzione d'astrazione: AF_trasmsissione, numRep, betaminutiRep (con numero di elementi delle fasce)
     * Invariante di rappresentazione: IR_trasmissione
     *                                 numRep non può essere negativo
     *                                 betaminutiRep non può essere negativo
     */

    /**
    * Post condizioni: inizializza this affinchè rappresenti una
    * TrasmissionePeriodica.
    * Ipotizzo che le pre e post condizioni del supertipo siano valide
    * Solleva un'eccezione nel caso in cui il numero di ripetizioni sia negativo
    * Solleva un'eccezione nel caso in cui i betaminuti siano negativi
    */
    public TrasmissionePeriodica(String titolo, List<FasciaBetaoraria> fasce, int numRep, int betaminutiRep) {
        super(titolo, fasce);
        if (numRep <= 0)
            throw new IllegalArgumentException("Il numero delle ripetizioni deve essere positivo");
        if (betaminutiRep <= 0)
            throw new IllegalArgumentException("I betaminuti devono essere positivi");
        this.numRep = numRep;
        this.betaminutiRep = betaminutiRep;
    }

    /**
     * Post condizioni: restituisce il titolo della trasmissione
     */
    @Override
    public String getTitolo() {
        return this.titolo;
    }

    /**
     * @return the betaminutiRep
     */
    public int getBetaminutiRep() {
        return betaminutiRep;
    }

    /**
     * @return the numRep
     */
    public int getNumRep() {
        return numRep;
    }

    @Override
    public List<FasciaBetaoraria> getFasce() {
        return super.getFasce();
    }

    /**
     * Due Trasmissioni periodiche sono uguali se hanno lo stesso titolo, 
     * la stessa fascia oraria,lo stesso numero di ripetizioni e la stessa distanza di assegnamento
     */
    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if (!(obj instanceof TrasmissionePeriodica))
            return false;
        TrasmissionePeriodica tp = (TrasmissionePeriodica) obj;
        return tp.numRep == numRep && tp.betaminutiRep == betaminutiRep;
    }

    @Override
    public int hashCode() {
        int result = 31 * super.hashCode();
        result += Integer.hashCode(numRep) +  Integer.hashCode(betaminutiRep);
        return result;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += ", " + numRep +", " +betaminutiRep;
        return s;
    }

    public static void main(String[] args) {
        List<FasciaBetaoraria> lfb = new ArrayList<>();
        lfb.add(new FasciaBetaoraria(new Betaorario(13,30),40));
        Trasmissione ts = new TrasmissionePeriodica("Ricette del giorno",lfb,2,1120);
        System.out.println(ts.toString());

        //13:30 40 2 1120 Ricette del giorno
    }
    

}
