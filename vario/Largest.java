import java.util.Iterator;

public class Largest extends IntList {

    private int biggest,sz;
    private Object val;
    public Largest(){
        super();
    }

    @Override
    public Object First() throws NullPointerException {
        if(sz == 0){
            throw new NullPointerException("first");
        }
        return val;
    }

    @Override
    public IntList rest() throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator els() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IntList addEL(Object x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean repOk() {
        // TODO Auto-generated method stub
        return false;
    }
    
    public Object max() throws NullPointerException{
        if (size() == 0) {
            throw new NullPointerException("max");
        }
        return biggest;
    }
}