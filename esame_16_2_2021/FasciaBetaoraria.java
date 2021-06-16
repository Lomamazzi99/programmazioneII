import java.util.Objects;
import java.util.Scanner;

/**
 * Una fascia betaoraria è data da un betaorario di inizio e da una durata in
 * betaminuti che ne determina il betaorario di fine, si osservi che inizio e
 * durata devono essere tali per cui la fine della fascia cada nello stesso
 * giorno in cui è iniziata. Può essere molto utile che una fascia betaoraria
 * sia in grado di stabilire se si interseca (ossia ha almeno un betaminuto in
 * comune) con un'altra fascia, o meno.
 */


 /**
  * Overview:
  * Le istanze di questa classe rappresentano una fascia betaoraria data da un betaorario di inizio e una durata in betaminuti.
  * Gli oggetti di questa classe sono immutabili
  */
 public class FasciaBetaoraria {
    /**La struttura che definisce il betaorario di inizio */
    private final Betaorario betaorarioInizio;
     /**La durata della fascia betaoraria */
    private final int durata;

    /**
     * Funzione d'astrazione: AF(betaorarioInizio,durata) = AF_betaorario, durata
     * Invariante di rappresentazione: betaorarioInizio non può essere null
     *                                 durata non può essere negativa
     */

     /**
    * Post condizioni: inzializza this affinchè rappresenti una FasciaBetaoraria.
    * Solleva un eccezione del tipo IllegalArgumentException nel caso in cui la
    * durata sia negativa. 
    * Solleva un eccezione del tipo NullPointerExeption nel caso in cui il betaorario sia null. 
    * Solleva un eccezione del tipo OutSideFasciaException nel caso in cui la durata indicata vada oltre la giornata
    */
    public FasciaBetaoraria(Betaorario betaorarioInizio, int durata) {
        Objects.nonNull(betaorarioInizio);
        if (durata < 0)
            throw new IllegalArgumentException("La durata non può essere negativa");
        this.betaorarioInizio = betaorarioInizio;
        if (!checkFascia())
            throw new OutSideFasciaException("La fascia betaoraria supera la giornata attuale");
        this.durata = durata;
    }
     
    /**
     * Post condizioni: restituisce true se la betafascia indicata non va oltre la giornata attuale,false altrimenti
     */
    private boolean checkFascia() {
        int betaminuti = this.betaorarioInizio.getBetaminuti();
        int betaore = this.betaorarioInizio.getBetaore();
        for (int i = 0; i < durata; i++) {
            betaminuti += 1;
            if (betaminuti > 79) {
                betaminuti = 0;
                betaore += 1;
            }
        }
        if (betaore >= 31)  // mancava =
            return false;
        return true;
    }

    /**
     * Post condizioni: restituisce un nuovo Betaorario dato da quello iniziale sommatogli la durata della fascia
     */
    public Betaorario endAt() {
        int betaminuti = betaorarioInizio.getBetaminuti();
        int betaore = betaorarioInizio.getBetaore();
        
        for (int i = 0; i < durata; i++) {
            betaminuti += 1;
            if (betaminuti > 79) {
                betaminuti = 0;
                betaore += 1;
            }
        }
        Betaorario bo = new Betaorario(betaore, betaminuti);
        return bo;
    }

    /**
     * @return the durata
     */
    public int getDurata() {
        return durata;
    }

    /**
     * @return the betaorarioInizio
     */
    public Betaorario getBetaorarioInizio() {
        return betaorarioInizio;
    }
    

    /**
     * Può essere molto utile che una fascia betaoraria sia in grado di stabilire se
     * si interseca (ossia ha almeno un betaminuto in comune) con un'altra fascia, o
     * meno.
     */


     /**
    * Post condizioni: restituisce true se esiste una intersezione tra due fascie orarie, false altrimenti
    *                   solleva un'eccezione nel caso in cui la fascia oraria passata in input sia null
    */
    public boolean intersection(FasciaBetaoraria fb) {
        Objects.nonNull(fb);
        Betaorario bo = endAt();
        Betaorario bo2 = fb.endAt();
        
        //nel caso in cui fb1 inizi prima di fb2
        if (betaorarioInizio.compareTo(fb.betaorarioInizio) == -1) {
            //nel caso in cui bo1 finisca dopo fb2
            if (bo.compareTo(bo2) == 1) {
                return true;
            }
            //nel caso in cui bo1 finisca prima di fb2 ma comunque dopo di inzio fb2
            if (bo.compareTo(bo2) == -1 && bo.compareTo(fb.betaorarioInizio) >= 0) {
                return true;
            }
            // nel caso in cui fb1 inizi dopo di fb2
        } else if (betaorarioInizio.compareTo(fb.betaorarioInizio) == 1) {
            if (bo2.compareTo(bo) == 1) {
                return true;
            }
            if (bo2.compareTo(bo) == -1 && bo2.compareTo(betaorarioInizio) >= 0) {
                return true;
            }
            //se iniziano allo stesso momento c'è una sovrapposizione
        } else if (fb.betaorarioInizio.compareTo(fb.betaorarioInizio) == 0)
            return true;
         return false;
     }

     /**
     * Due FasciaBetaoraria sono uguali se hanno stesso betaorarioInizio e stessa durata.
     */
     @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FasciaBetaoraria))
            return false;
        FasciaBetaoraria fbo = (FasciaBetaoraria) obj;
        return fbo.durata == durata && fbo.betaorarioInizio.equals(betaorarioInizio);
    }
     
     @Override
     public int hashCode() {
         int result = 31 * betaorarioInizio.hashCode();
         result += Integer.hashCode(durata);
         return result;
     }

     @Override
     public String toString() {
         String s = betaorarioInizio.toString();
         return s + " "+ durata;
     }

     

}	
