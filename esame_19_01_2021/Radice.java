import java.util.Objects;

public class Radice extends Directory {

    private Directory d;

    public Radice(String nome) {
        super(nome);
        d = new Directory(nome);
    }

    public Path getPath(Entry e){
        Objects.nonNull(e);
        if(!(d.contains(e))) throw new IllegalArgumentException();

        String s = ":"+d.getNome();

        for(Entry entry : getRiferimenti()){
            s += ":" + entry.getNome();
        }
        return new Path(s);
    }

    public Entry getEntry(Path p){
        System.out.println("path");
        Objects.nonNull(p);
        Entry e = new Entry(p.getLast());
        return e;
    }

    
}
