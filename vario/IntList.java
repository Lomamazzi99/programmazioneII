import java.util.Iterator;

/*
define and implement a subtype of IntList that provides methods to return
the smallest and largest elements of the list.Be sure to define the 
rep invariant and abstract function, and to implemtn repOk
*/

/**
 * Una IntList è una lista immutabile di interi.
 * E' rappresentata come una sequenza [x1,...,xk]
 */
public abstract class IntList{


	//metodi astratti
    public abstract Object First() throws NullPointerException;
    public abstract IntList rest() throws NullPointerException;
    @SuppressWarnings("all")
    public abstract Iterator els();
    public abstract IntList addEL(Object x);
    public abstract int size();
    public abstract boolean repOk();

    //metodi non astratti
   /* public String toString(){
        String s = "[]";
            for(int i = 0; i < size();i++){
                s += 
                s += ",";   
        }
        return s;
    }*/
}

