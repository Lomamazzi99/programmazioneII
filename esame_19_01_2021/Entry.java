import java.util.Objects;

public class Entry implements Comparable<Object>{
    private String nome;

    public Entry(String nome){
        Objects.nonNull(nome);
        if(nome.compareTo("") == 0) throw new IllegalArgumentException();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void changeNome(String nome){
        Objects.nonNull(nome);
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Entry)) return false;
        Entry e = (Entry) obj;
        return e.nome.equals(nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public String toString() {
        return nome.toString();
    }

    @Override
    public int compareTo(Object arg0) {
        if(!(arg0 instanceof Entry)) throw new ClassCastException();
        Entry e = (Entry) arg0;
        for(int i = 0; i < Math.min(e.nome.length(), nome.length());i++){
            if(e.nome.charAt(i) < nome.charAt(i)) return 1;
            if(e.nome.charAt(i) > nome.charAt(i)) return -1;
        }
        return 0;
    }
}
