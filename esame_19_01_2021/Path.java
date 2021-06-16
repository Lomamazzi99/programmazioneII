import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Path {
    private List<String> path;

    public Path(String path){
        Objects.nonNull(path);
        String[] as = path.split(":");
        this.path = new ArrayList<>();

        for(String s : as){
            if(!this.path.contains(s)) this.path.add(s);
        }
    }

    public List<String> getPath() {
        return path;
    }

    private boolean contains(Entry e){
        for(String s : path){
            if(s.equals(e.getNome())) return true;
        }
        return false;
    }

    public boolean isIn(Entry e){
        Objects.nonNull(e);
        return contains(e);
    }

    public String getFirst(){
        if((path.isEmpty())) throw new IllegalArgumentException();
        return path.get(0);
    }

    public String getLast(){
        if((isEmpty())) throw new IllegalArgumentException();
        return path.get(path.size()-1);
    }

    public boolean isEmpty(){
        return path.get(0).compareTo("") == 0;
    }

    @Override
    public String toString() {
        String s = "";
        for(String node : path){
            s += node + ":";
        }
        
        return s;
    }
}
