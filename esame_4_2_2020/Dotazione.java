import java.util.Objects;

/**
 * Overview:
 * Le istanze di questa classe rappresentano una Dotazione la quale è definita da un nome e un peso;
 * Gli oggetti di questa classe sono immutabili
 */
public class Dotazione implements Comparable<Dotazione>{
    /**Il nome della dotazione */
    private final String nome;
    /**la quantità della Dotazione */
    private final int quantità;


    /**
     * Funzione d'astrazione: AF(nome,quantità) = nome = quantità
     * 
     * Invariante di rappresentazione: nome non può essere null
     *                                 quantità non può essere negativo
     */


     /**
      * Post condizioni: inizializza this affinchè rappresenti una dotazione
                         solleva un'eccezione nel caso in cui il nome preso in input sia null
                         solleva un'eccezione nel caso in cui la quantità presa in input sia negativa
      */
    public Dotazione(final String nome,final int quantità){
        Objects.nonNull(nome);
        if(quantità <= 0) throw new IllegalArgumentException();
        this.nome = nome;
        this.quantità = quantità;
    }

    /**
     * Post condizioni: restituisce il nome della dotazione
     */
    public String getNome() {
        return nome;
    }

    /**
     * Post condizioni: restituisce la pequantitàso della dotazione
     */
    public int getQuantità() {
        return quantità;
    }

    /**
     * Post condizioni: restituisce true se due dotazioni sono uguali, ovvero hanno lo stesso nome
     *                  false altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Dotazione)) return false;
        Dotazione d = (Dotazione) obj;
        return d.nome.equals(nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public String toString() {
        String s = String.format("%s = %d", nome,quantità);
        return s;
    }

    @Override
    public int compareTo(Dotazione arg0) {
        for(int i = 0; i < Math.min(nome.length(), arg0.nome.length());i++){
            if(nome.charAt(i) < arg0.nome.charAt(i)) return -1;
            if(nome.charAt(i) > arg0.nome.charAt(i)) return 1;
        }
        return 0;
    }
}