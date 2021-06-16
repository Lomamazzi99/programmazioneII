/**
 * Overview:
 * Le istanze di questa classe rappresentano un Betaorario.
 * Esso è espresso in betaore e betaminuti.
 * Le istanze di questa classe sono mutabili.
 */
public class Betaorario implements Comparable<Object> {
    /**Le betaore del betaorario */
    private int betaore;
    /** I betaminuti del betaorario */
    private int betaminuti;

    /**
     * Funzione d'astrazione: AF(betaore, betaminuti) = betaore:betaminuti
     * 
     * Invariante di rappresentazione: betaore non è negativo
     *                                 betaminuti non è negativo
     */

     /**
    * Post condizioni: inizializza this affinchè rappresenti un Betaorario. 
    * Solleva un eccezione del tipo IllegalArgumentException nel caso in cui le betaore
    * siano negative o maggiori di 30. 
    * Solleva un eccezione del tipo IllegalArgumentExceptionnel caso in cui i betaminuti siano negativi o
    * maggiori di 79
    */
    public Betaorario(int betaore,int betaminuti) {
        if (betaore < 0 || betaore > 30)
            throw new IllegalArgumentException("Le betaore devono essre comprese tra 0 e 30");
            if (betaminuti < 0 || betaminuti > 79)
            throw new IllegalArgumentException("I betaminuti devono essere compresi tra 0 e 79");
        this.betaminuti = betaminuti;
        this.betaore = betaore;
    }

    /**
     * @return the betaminuti
     */
    public int getBetaminuti() {
        return betaminuti;
    }

    /**
     * @return the betaore
     */
    public int getBetaore() {
        return betaore;
    }


    /**
     * Due betaorari sono uguali se hanno le stessa betaore e betaminuti
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Betaorario))
            return false;
        Betaorario bo = (Betaorario) obj;
        return bo.betaminuti == betaminuti && bo.betaore == betaore;
    }

    @Override
    public int hashCode() {
        int result = 31 * Integer.hashCode(betaore);
        result += Integer.hashCode(betaore);
        return result;
    }

    @Override
    public int compareTo(Object arg0) {
        if (!(arg0 instanceof Betaorario)) {
            throw new ClassCastException();
        }
        Betaorario bo = (Betaorario) arg0;
        if (bo.betaore > betaore){
            return -1;
        }else if (bo.betaore < betaore){
            return 1;
        } else {
            if (bo.betaminuti > betaminuti) {
                return -1;
            } else if (bo.betaminuti < betaminuti) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d:%d", betaore, betaminuti);
    }


}
