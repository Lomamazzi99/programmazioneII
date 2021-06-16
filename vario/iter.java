import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iter{
    
    //overwiev
    private static List<Integer> els;
    
    //costruttori
    public iter(){
        els = new ArrayList<>();
    }
    
    //Metodi
    public static int getIndex(int x){
        if (els.size() == 0){
            return -1;
        }
        
        Iterator<Integer> g =  els.iterator();
        int index = 0,p = g.next(); //NON VA AVANTI IN AUTOMATICO
        while(g.hasNext()){
            p = g.next(); 
            index++;
            if (p == x){
                return index;
            }
        }
        return -1;
    }


    public void insert(int x){
        if (getIndex(x) < 0){
            els.add(x);
        }
    }
    
    public static void remove(int x){
        int i = getIndex(x);
        if (i < 0){
            return;
        }else{
            int last = els.size() - 1;
            els.set(i, els.get(last));
            els.remove(last);

        }
    }

    public String toString() {
        if (els.size() == 0){
            return "{}";
        }
        Iterator<Integer> iterator = els.iterator();
        int p = iterator.next();
        String s = "{";
        while(iterator.hasNext()){
             s += p + ",";
        
        }
        return s + "}";
    }


    public static void main(String[] args) {
        iter m = new iter();
        m.insert(4);
        m.insert(3);
        m.insert(37);
        System.out.println(getIndex(3));
        remove(3);
        System.out.println(getIndex(3));

    }
}