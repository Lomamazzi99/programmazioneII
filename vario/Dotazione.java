/**
 * Una dotazione.
 * 
 * Questa classe concreta e immutabile ha come obbittivo di 
 * rappresentare una dotazione come un oggetto definito da una nome e una quantità.
 */
public class Dotazione implements Comparable<Dotazione>{

    /**
     * poiché le due istanze sono immutabili (final) è lecito che esse siano pubbliche
     */
    public final String nome;
    public final int quantità;

    /**
     * questo costruttore prende in input i parametri:
     * @param nome
     * @param quantità 
     * controllando se: 
     * il primo sia diverso da null, in caso contrario solleva un'eccezione.
     * il secondo sia maggiore o uguale a 0, in caso contrario solleva un'eccezione.
     * L'invarianza viene mantenuta poiché è l'unico costruttore.
     */
    public Dotazione(final String nome, final int quantità){
        if(nome == null) throw new IllegalArgumentException("il nome non può essere null");
        this.nome = nome;
        if(quantità < 0) throw new IllegalArgumentException("la quantità non può essere minore di 0");
        this.quantità = quantità;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Dotazione)) return false;
        Dotazione d = (Dotazione) obj;
        return this.nome.equals(d.nome);
    }

    @Override
    public int hashCode(){
        return this.nome.hashCode();
        //return System.identityHashCode(this.nome);
    }

    @Override
    public String toString(){
        return String.format("%s = %d", this.nome, this.quantità);
    }

    @Override
    public int compareTo(Dotazione arg0) {
        if(arg0.nome == null) throw new NullPointerException("secondo argomento non può essere null");
        int len = this.nome.length();
        if(this.nome.length() < arg0.nome.length()) len = arg0.nome.length();

        for(int i = 0; i < len;i++){
            if(this.nome.charAt(i) < arg0.nome.charAt(i)) return -1;
            else if (this.nome.charAt(i) > arg0.nome.charAt(i)) return 1;
        }

        return 0;
    }
}