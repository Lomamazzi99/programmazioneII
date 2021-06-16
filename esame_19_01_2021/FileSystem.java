import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class FileSystem {
    private Map<Entry, Path> fileSystem;
    private Radice root;

    public FileSystem(){
        fileSystem = new TreeMap<>();
    }

    public void insertRoot(Radice root){
        Objects.nonNull(root);
        if(isEmpty()){
            Path p = new Path(":"+root.getNome());
            fileSystem.put(root, p);
            this.root = root;
            System.out.println(fileSystem.toString());
            
        }else{
            throw new IllegalArgumentException();
        }
    }

    

    public void insert(Entry e){
        Objects.nonNull(e);
        if((fileSystem.containsKey(e))) throw new IllegalArgumentException();

        Path p = root.getPath(e);
        if(e instanceof Directory){
            Directory d = (Directory) e;
            if(d.getDimensione() == 0){
                fileSystem.put(d, p);
            }
        }else if(e instanceof File){
            File f = (File) e;
            fileSystem.put(f, p);
        }
    }

    public boolean isEmpty(){
        return fileSystem.isEmpty();
    }

    public Radice getRoot() {
        return root;
    }


    public Entry getEntry(Path p){
        Objects.nonNull(p);
        return root.getEntry(p);
    }

    public Directory createDirectory(Path p){
        Objects.nonNull(p);
        Directory d = new Directory(p.getLast());
        return d;
    }

    public File createFile(Path p, int dimensione){
        Objects.nonNull(p);
        File f = new File(p.getLast(),dimensione);
        return f;
    }

    public String getAllElementsOf(Path p){
        Objects.nonNull(p);
        Directory d = (Directory) root.getEntry(p);
        return d.showElements();
    }

    public int getDimensione(Path p){
        Objects.nonNull(p);
        int dim = 0;
        System.out.println(p.toString());
        Entry e = root.getEntry(p);
        if(e instanceof File){
            File f = (File) e;
            dim = f.getDimensione();
        }else{
            Directory d = (Directory) e;
            dim = d.getDimensione();
        }
        return dim;
    }
    
    @Override
    public String toString() {
        String s = "";
        for(Map.Entry<Entry, Path> me : fileSystem.entrySet()){
            s+= "k: "+ me.getKey().getNome() + ", v: " + me.getValue();
        }
        return s;
    }

}
