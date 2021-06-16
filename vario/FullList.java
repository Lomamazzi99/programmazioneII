import java.util.Iterator;
import java.util.NoSuchElementException;

public class FullList extends IntList {
    private int sz;
    private Object val;
    private IntList next;

    public FullList(Object x){
        sz = 1;
        val = x;
        next = new EmptyList();
    }
    @Override
    public Object First(){
        return val;
    }

    @Override
    public IntList rest() {
       return next;
    }

    @Override
    public IntList addEL(Object x) {
        FullList n = new FullList(x);
        n.next = this;
        n.sz = this.sz + 1;
        return n;
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean repOk() {
        return true;
    }
    

    @Override
    @SuppressWarnings("all")
    public Iterator els() {
      return new FullGen(next, sz);
    }
    
    private static class FullGen implements Iterator<FullList>{
        private int count;
        @SuppressWarnings("all")
        private FullGen child;
        private IntList me;

        FullGen (IntList i,int n){
            count = n;
            if (count > 0){
                me = i;
                child = new FullGen(me, n);
            }
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public FullList next()throws NoSuchElementException {
            if (count == 0){
                throw new NoSuchElementException("next == 0");
            }
           count--;
           return (FullList) me.First();
        }
        
    }
}