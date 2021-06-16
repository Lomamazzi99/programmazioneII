import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Una trasmissione è data da un titolo e da una o più fasce betaorarie in cui
 * deve essere trasmessa. Sono esempi di tipi di trasmissione:
 */



 /**
  * Overview: Una trasmissione è data da un titolo e da una o più fasce
  * betaorarie in cui deve essere trasmessa.
  * Gli oggetti di questa classe sono mutabili.
  */
 public abstract class Trasmissione {
    /**Il titolo della trasmissione */
    protected final String titolo;
     /**Le fasce orarie della trasmissione */
    protected List<FasciaBetaoraria> fasce;

     /**
      * Funzione d'astrazione: AF(titolo,fasce) =
      * = {fasce.get(0),fasce.get(1),...,fasce.get(n)} titolo (con n numero di elementi nella lista di fasce orarie)
      *
      *Invariante di rappresentazione: il titolo non può essere null
      *                                la lista delle fasce orarie non può essere null
      *                                gli elementi della fascia oraria non possono essere null (nessuno di questi è null)
      *                                gli elementi della fascia oraria sono unici
      */

     /**
      * Post condizioni: le istanze di questa classe rappresentano una trasmissione
      * solleva un'eccezione nel caso in cui il titolo preso in input sia null
      * solleva un'eccezione nel caso in cui le fasce orarie prese in input siano null
      * solleva un'eccezione nel caso in cui una delle fasce orarie prese in input sia null
      */
     public Trasmissione(final String titolo, List<FasciaBetaoraria> fasce) {
         Objects.nonNull(titolo);
         Objects.nonNull(fasce);
         if (fasce.isEmpty())
             throw new IllegalArgumentException();
         for (FasciaBetaoraria fb : fasce) {
             Objects.nonNull(fb);
         }
         if (checkDuplicates(fasce))
             throw new IllegalArgumentException("Non vi possono essere due fasce orarie uguali");

        this.fasce = new ArrayList<>(fasce);
         for (FasciaBetaoraria fb : fasce) {
            if(intersection(fb)) 
                throw new IllegalArgumentException("Non vi possono essere due fasce orarie che si sovrappongono");
        }
         this.titolo = titolo;
     }

     /**
      * Post condizioni: restituisce true se due fasce orarie si sovrappongono all'interno della trasmissione, false altrimetni
      */
     public boolean intersection(FasciaBetaoraria f) {
         for (FasciaBetaoraria fb : this.fasce) {
                 if (!f.equals(fb)) {
                     if (fb.intersection(f))
                         return true;
                 }
         }
         return false;
     }
     
     /**
      * Pre condizioni: la lista delle fasce passata in input non può essere null
      * Post condizioni: restituisce true se vi sono doppioni all'interno della lista passata in input, false altrimenti
      */
     private boolean checkDuplicates(List<FasciaBetaoraria> fasce) {
         for (FasciaBetaoraria fb : fasce) {
             if (fasce.indexOf(fb) != fasce.lastIndexOf(fb))
                 return true;
         }
         return false;
     }
     
     /**
      * @return the titolo
      */
     public abstract String getTitolo();

     /**
      * @return the fasce
      */
     public abstract List<FasciaBetaoraria> getFasce();

     /**
      * Effetti collaterali: potrebbe modificare this
      * Post condizioni: aggiunge una fascia betaoraria nel caso in cui essa non sia già presente o non crei intersezioni
      *                  solleva un'eccezione nel caso in cui sia già contenuta o crei intersezione con un'altra fascia
      */
     public void addFascia(FasciaBetaoraria f) {
         Objects.nonNull(f);
         if (fasce.contains(f))
             throw new IllegalArgumentException("La fascia è già contenuta");
         for (FasciaBetaoraria fascia : fasce) {
             fascia.intersection(f);
         }
         fasce.add(f);
     }
     
     /**
      * Due trasmissioni sono uguali se hanno lo stesso titolo e le stesse fasce orarie
      */
     @Override
     public boolean equals(Object obj) {
         if (!(obj instanceof Trasmissione))
             return false;
         Trasmissione t = (Trasmissione) obj;
         return t.titolo.equals(titolo) && fasce.equals(fasce);
     }

     @Override
     public int hashCode() {
         int result = 31*titolo.hashCode();
         result += fasce.hashCode();
         return result;
     }

     @Override
     public String toString() {
         String s = "";
         for (int i = 0; i < this.fasce.size() - 1; i++) {
             s += fasce.get(i).toString();
             s += ", ";
         }
         s += fasce.get(this.fasce.size() - 1).toString();
         return s;
     }

     public static void main(String[] args) {
         
     }

     
}
