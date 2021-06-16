import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Overview:
 * 
 * Le istanze di questa classe rappresentano un Rettangolo, 
 * il quale è formato da un insieme dei punti ma sempre da almeno un punto.
 * Le istanze di questa classe sono immutabili.
 */

public class Rettangolo {
    /**La struttura dati che contiene le coordinate dei punti del rettangolo */
    private final List<Coordinata> punti;
    private static Coordinata lowerLeft;
    private static Coordinata upperRight;

    /**
     * Funzione d'astrazione: AF(punti) = [ci , cj] con ci, cj i vertici
     * rispettivamente in basso a sinistra e in alto a destra = [ci] nel caso in cui
     * il rettangolo sia formato da un solo punto
     * 
     * Invariante di rappresentazione: l'insieme dei punti non può essere null
     * nessun elemento all'interno dell'insieme dei punti può essere null
     */

    /**
     * Post condizioni: inizializza this affinchè rappresenti un rettangolo solleva
     * un'eccezione del tipo NullPointerException nel caso in cui l'insieme delle
     * coordiante in input sia null solleva un'eccezione del tipo
     * NullPointerException nel caso in una delle coordiante dell'insieme in input
     * sia null solleva un'eccezione del tipo IllegalArgumentException nel caso in
     * cui l'insieme delle coordinate sia vuoto
     * 
     * Correttezza: AF(c) = [ci] Preservazione IR: nel caso in cui l'insieme delle
     * coordinate prese in input sia null allora viene sollevata un'eccezione e
     * quindi l'oggetto non viene istanziato nel caso in cui una delle coordinate
     * dell'insieme prese in input sia null allora viene sollevata un'eccezione e
     * quindi l'oggetto non viene istanziato nel caso in cui l'insieme delle
     * coordinate sia vuoto allora viene sollevata un'eccezione e quindi l'oggetto
     * non viene istanziato
     * 
     */
    public Rettangolo(ArrayList<Coordinata> c) {
        Objects.nonNull(c);
        if (c.isEmpty())
            throw new IllegalArgumentException("L'insieme delle coordinate prese in input non può essere vuoto");
        for (Coordinata x : c) {
            Objects.nonNull(x);
        }
        this.punti = c;
        Rettangolo.lowerLeft = getLowerLeft();
        Rettangolo.upperRight = getUpperRight();

    }

    /**
     * Post condizioni: restituisce la coordinata più in basso a sinistra tra tutte
     * quelle presenti nell'insieme di punti
     */
    private Coordinata getLowerLeft() {
        int x = 0, y = 0;
        for (Coordinata c : punti) {
            if (c.getX() <= x)
                x = c.getX();
            if (c.getY() <= y)
                y = c.getY();
        }
        return new Coordinata(x, y);
    }

    /**
     * Post condizioni: restituisce la coordinata più in basso a sinistra tra tutte
     * quelle presenti nell'insieme di punti
     */
    private Coordinata getUpperRight() {
        int x = 0, y = 0;
        for (Coordinata c : punti) {
            if (c.getX() >= x)
                x = c.getX();
            if (c.getY() >= y)
                y = c.getY();
        }
        return new Coordinata(x, y);
    }

    /**
     * Post condizioni: 
     */
    public static int boundingBox() {
        int base = upperRight.getX() - lowerLeft.getX();
        int altezza = upperRight.getY() - lowerLeft.getY();
        return base*altezza;
    }
    
    @Override
    public String toString() {
        String s = String.format("[%s, %s]", lowerLeft.toString(),upperRight.toString() );
        return s;
    }
}
