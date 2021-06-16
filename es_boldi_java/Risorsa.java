import java.util.List;
import java.util.Objects;

public class Risorsa implements Comparable<Risorsa> {

    private final String nome;
    private final int prezzo;
    public static List<Risorsa> lista;

    public Risorsa(final String nome,final int prezzo){
        Objects.nonNull(nome);
        if(prezzo < 0) throw new IllegalArgumentException();
        this.nome = nome;
        this.prezzo = prezzo;
        lista.add(this);
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public static Risorsa risorsaCasuale(){
        return lista.get(random(0, lista.size()));
    }

    private static int random(int max, int min) {
        return (int) ((Math.random() * (max-min)) + min);
    }

    @Override
    public String toString() {
        return nome + "(prezzo " + prezzo +"$)";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Risorsa)) return false;
        Risorsa r = (Risorsa) obj;
        return r.prezzo == prezzo && r.nome.compareTo(nome) == 0;
    }

    

    @Override
    public int compareTo(Risorsa arg0) {
        if(arg0.prezzo < prezzo) return 1;
        if(arg0.prezzo > prezzo) return -1;

        return arg0.nome.compareTo(nome);
    }
    
}