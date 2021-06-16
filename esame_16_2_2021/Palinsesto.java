import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Infine, un palinsesto giornaliero è un insieme di trasmissioni costruito in
 * modo tale che le trasmissioni che lo compongono non si intersechino tra loro.
 */

 /**
  * Overview: le istanze di questa classe rappresentano un palinsesto giornaliero
  * è un insieme di trasmissioni costruito in modo tale che le trasmissioni che
  * lo compongono non si intersechino tra loro.
  * Gli oggetti di questa classe sono mutabili.
  */

 public class Palinsesto {
    /**La struttura dati che contiene le trasmissioni */
     private List<Trasmissione> palinsesto;

     /**
      * Funzione di astrazione: AF(palinsesto) =
      * {palinsesto.get(0),palinsesto.get(1,...,palinsesto.get(n)) | 0 <= i < n} con n numero di elementi nel palinsesto
      * {} se il palinsesto è vuoto
      */

     /**
     * Post condizioni: inizializza this affinchè rappresenti un palinsesto vuoto
     */
     public Palinsesto() {
         palinsesto = new ArrayList<Trasmissione>();
     }
     
     /**
      * Effetti collaterali: potrebbe modificare this
      * Post condizioni: aggiunge la trasmissione al palinsesto se non è già presente al suo interno.
      *                  solleva un'eccezione nel caso in cui la trasmissione passata in input sia null
      *                  solleva un'eccezione nel caso in cui la trasmissione passata in input sia già presente al palinsesto
      *                  solleva un'eccezione nel caso in cui la trasmissione passata in input crei una sovrapposizione nel palinsesto
      */
     public void insertTrasmissione(Trasmissione t) {
         Objects.nonNull(t);
         if (isEmpty()) {
             palinsesto.add(t);
             return;
         }
         if (palinsesto.contains(t)) {
             throw new AlreadyInPalinsestoException();
         } else {
             if (intersection(t))
                 throw new SovrapposizioneException("La Trasmissione crea una sovrapposizione");
             palinsesto.add(t);
         }

     }
     
     /**
      * Pre condizioni: la trasmissione t in input non deve essere null
      * Post condizioni: restituisce true se, presa una trasmissione in input, essa crea una sovrapposizione con un'altra trasmissione del palinsesto
      */
     private boolean intersection(Trasmissione t) {
         for (Trasmissione trasmissione : palinsesto) {
             for (int i = 0; i < trasmissione.fasce.size(); i++) {
                 FasciaBetaoraria fasciaTrasmissione = trasmissione.fasce.get(i);
                 FasciaBetaoraria fasciaT = t.fasce.get(i);
                 if (fasciaTrasmissione.intersection(fasciaT)) {
                     return true;
                 }
             }
         }
         return false;
     }

     
     /**
      * Post condizioni: restituisce true se il palinsesto è vuoto,false altrimenti
      */
     public boolean isEmpty() {
         return palinsesto.isEmpty();
     }

     public int size() {
         if (isEmpty())
             return 0;
         return palinsesto.size();
     }

     /**Due palinsesti sono uguali se tutte le loro trasmissioni sono uguali */
     @Override
     public boolean equals(Object obj) {
         if (!(obj instanceof Palinsesto))
             return false;
         Palinsesto p = (Palinsesto) obj;
         return p.palinsesto.equals(palinsesto);
     }
     
     @Override
     public int hashCode() {
         return palinsesto.hashCode();
     }

         @Override
     public String toString() {
         String s = "{";
         if (isEmpty())
             return "{}";
         for (int i = 0; i < size() - 1; i++) {
             s += palinsesto.get(i).toString();
             s += ", ";
         }
         s += palinsesto.get(size() - 1);
         s += ", ";
             return s + "}";
     }

     public static void main(String[] args) {
         Palinsesto p = new Palinsesto();
         
         List<FasciaBetaoraria> lfb = new ArrayList<>();
         lfb.add(new FasciaBetaoraria(new Betaorario(13,78),40));
         List<FasciaBetaoraria> lfb2 = new ArrayList<>();
         lfb2.add(new FasciaBetaoraria(new Betaorario(14,8),440));
         Trasmissione ts = new TrasmissionePeriodica("Ricette del giorno",lfb,2,1120);
         Trasmissione ts2 = new TrasmissionePeriodica("The sims 4",lfb2,2,45);
         p.insertTrasmissione(ts);
         p.insertTrasmissione(ts2);
         System.out.println(p.toString());
     }
}
