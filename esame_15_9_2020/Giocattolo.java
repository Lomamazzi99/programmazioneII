import java.util.Objects;

/**
 * Overview:
 * 
 * Le istanze di questa classe rappresentano un Giocattolo il quale è formato da un nome e un materiale.
 * Gli oggetti di questa classe sono immutabili
 */
public class Giocattolo implements Comparable<Object>{
    /**Il nome del giocattolo */
    private final String nome;
    /**Il materiale di cui è composto il giocattolo */
    private final String materiale;
    /**Il prezzo di un giocattolo */
    //private final int prezzo;

    /**
     * Funzione d'astrazione: AF(nome,materiale) = Nome: nome, Materiale: materiale
     * 
     * Invarainte di astrazione: nome non può essere null
     *                           materiale non può essere null
     *                           nome non può essere vuoto
     *                           materiale non può essere vuoto
     *                           il prezzo non può essere negativo
     */

    /**
     * Post condizioni: inizializza this affinchè rappresenti un giocattolo
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il nome sia null
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il materiale sia null
     *                  solleva un'eccezione di tipo IllegalArgumentException nel caso in cui il nome sia vuoto
     *                  solleva un'eccezione di tipo IllegalArgumentException nel caso in cui il materiale sia vuoto
     *                  solleva un'eccezione di tipo IllegalArgumentException nel caso il prezzo sia negativo
     */
    //public Giocattolo(String nome, String materiale,int prezzo){
        public Giocattolo(String nome, String materiale){
        Objects.nonNull(nome);
        Objects.nonNull(materiale);
        if(nome.compareTo(" ") == 0 || materiale.compareTo(" ") == 0) throw new IllegalArgumentException();
        //if(prezzo <= 0) throw new IllegalArgumentException();

        this.nome = nome;
        this.materiale = materiale;
        //this.prezzo = prezzo;
    }

    /**
     * Post condizioni: restituisce il nome del giocattolo
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Post condizioni: restituisce il nome del giocattolo
     */
    public String getMateriale() {
        return materiale;
    }

    /**
     * Post condizioni: restituisce il prezzo del giocattolo
     */
    /*public int getPrezzo() {
        return prezzo;
    }*/

    @Override
    public boolean equals(Object obj) {
       if(!(obj instanceof Giocattolo)) return false;
       Giocattolo g = (Giocattolo) obj;
       return g.materiale.compareTo(materiale) == 0 &&
              g.nome.compareTo(nome) == 0;
    }

    @Override
    public int hashCode() {
        int result = 31*materiale.hashCode();
        result += nome.hashCode();
        return result;
    }

    @Override
    public String toString() {
       return String.format("%s %s",nome,materiale);
    }

    @Override
    public int compareTo(Object arg0) {
        if(!(arg0 instanceof Giocattolo)) throw new ClassCastException();
        Giocattolo g = (Giocattolo) arg0;
        for(int i = 0; i < g.nome.length();i++){
            if(g.nome.charAt(i) > nome.charAt(i)) return -1;
            if(g.nome.charAt(i) < nome.charAt(i)) return 1;
        }
        return 0;
    }
}
