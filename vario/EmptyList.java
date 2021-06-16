import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmptyList extends IntList{

    public EmptyList(){};
    @Override
    public Object First() throws NullPointerException{
        throw new NullPointerException("first");
    }

    @Override
    @SuppressWarnings("all")
    public Iterator els(){
        return new EmptyGen();
    }

    @SuppressWarnings("all")
    static private class EmptyGen implements Iterator{
        EmptyGen(){};
        public boolean hasNext(){
            return false;
        }
        @Override
        public Object next() throws NoSuchElementException{
            throw new NoSuchElementException("emptygen");
        }

    }
    
    @Override
    public IntList addEL(Object x){
        return new FullList(x);
    }
    @Override
    public  int size(){return 0;}
    @Override
    public  boolean repOk(){return true;}

    @Override
    public IntList rest() throws NullPointerException {
        throw new NullPointerException("rest");
    }

}
