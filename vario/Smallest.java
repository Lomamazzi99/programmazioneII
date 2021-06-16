import java.util.Iterator;
import java.util.Vector;

public class Smallest extends IntList{
    public static int sz;
    private int val,smallest;
    private IntList next;


    public Smallest(){
        super();
    }
    @Override
    public Object First() throws NullPointerException {
        if (sz == 0) {
            throw new NullPointerException("FIRST");
        }
        return val;
    }

    public IntList rest() throws NullPointerException {
        if (sz == 0) {
            throw new NullPointerException("rest");
        }
        return next;
    }
    @SuppressWarnings("all")
    public Iterator els() {
        return new Ismallest();
    }

    static private class Ismallest implements Iterator {
        Ismallest() {
        }

        public boolean hasNext() {
            if (sz == 0) {
                return false;
            }else{
                return true;
            }
        }

        @Override
        public Object next() {
            // TODO Auto-generated method stub
            return null;
        }
    }

    @Override
    public  IntList addEL(int x){
        IntList i;
        
    }
    @Override
    public  int size(){
        
    }
    public  boolean repOk(){
        return false;
    }

    @Override
    public IntList addEL(Object x) {
        // TODO Auto-generated method stub
        return null;
    }

    private Object min() throws NullPointerException{
        if(size() == 0){
            throw new NullPointerException("min");
        }
        return smallest;
    }
}