import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Directory extends Entry {

    private List<Entry> riferimenti;
    private int dimensione;

    public Directory(String nome) {
        super(nome);
        
        this.riferimenti = new ArrayList<>();
        this.dimensione = 0;
    }

    public void insert(Entry e){
        Objects.nonNull(e);
        if(contains(e)) throw new IllegalArgumentException();
        riferimenti.add(e);
    }

    public boolean contains(Entry e){
        return riferimenti.contains(e);
    }

    public void updateDimensione(){
        int result = 0;
        for(Entry e : riferimenti){
            Objects.nonNull(e);

            if(e instanceof File){
                File f = (File) e;
                result += f.getDimensione();
            }else if(e instanceof Directory){
                Directory d = (Directory) e;
                result += d.getDimensione();
            }
        }
        dimensione = result;
    }

    public int getDimensione() {
        return dimensione;
    }

    public List<Entry> getRiferimenti() {
        return riferimenti;
    }

    public Iterator<Entry> iterator(){
        return riferimenti.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if(!(obj instanceof Directory)) return false;
        Directory d = (Directory) obj;
        return d.dimensione == dimensione && 
               d.riferimenti.containsAll(riferimenti);
    }

    public String showElements(){
        String s = "";
        for(Entry e : riferimenti){
            s += e.getNome();
        }
        return s;
    }

    @Override
    public int hashCode() {
        int result = 31*super.hashCode();
        result += Integer.hashCode(dimensione);
        result += riferimenti.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +"*";
    }
    
    
}
