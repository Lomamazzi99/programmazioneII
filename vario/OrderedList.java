
//import java.util.ArrayList;
import java.util.Iterator;
//import java.util.NoSuchElementException;

public class OrderedList<T extends Comparable<T>> implements Comparable<T>{
    /**
     * Overview:
     * an ordered list is a mutable ordered list of **Comparable** objects.
     * A typical list is a sequence of [x1,...,xn] where xi<xj if i < j
     * The odering of elements is done by using their CompareTo method
     */
     private boolean empty;
     private OrderedList<T> left,right;
     private Comparable val;
    
     //costruttori
     public OrderedList(){
         //EFFECTS: initializes this to be an empty OrderedList
         empty = true;
     }


     //metodi

     public void addEl(Comparable el) throws NullPointerException, IllegalArgumentException, ClassCastException{
        //EFFECTS: if el is already in this throw IllegalArgumentException;
        // if val is NULL throw NullPointerException;
        //if el cannot be compared to another elements of this class throw ClassCastException;
        //else add el to this;

        if (el == null){
            throw new NullPointerException("addEl-null");
        }
        if(empty){
            left = new OrderedList();
            right = new OrderedList();
            empty = false;
            val = el;
            return;
        }

        
        int n = el.compareTo(val);
        if (n == 0){
            throw new IllegalArgumentException("addEl- el==val");
        }else if (n < 0){
            left.addEl(el);
        }else{
            right.addEl(el);
        }
    }

    public void remEl(Comparable el){
        OrderedList t = new OrderedList();
        boolean flag = this.isIn(el);
        if (flag){
            Iterator g = this.iterator();
            Object next = g.next();
            while(g.hasNext()){
                if(el.compareTo(next) == 0){
                    if(!this.right.empty){
                        this.val = this.right.val;
                    }else if (this.right.empty && !this.left.empty){
                        this.val = this.left.val;
                    }else{
                        this.val = null;
                    }
                    return;
                }else if (el.compareTo(next) > 0){
                    t = this.right;
                    next = t.right.val;
                }else{
                    t = this.right;
                    next = t.left.val;
                }
            }
        }else{
            System.out.println("non c'è :)");
            return;
        }
    }


    public boolean isIn(Comparable<T> el){
        if (empty){
            return false;
        }
        if (val.compareTo(el) < 0){
            return this.right.isIn(el);
        }else if (val.compareTo(el) > 0){
            return this.left.isIn(el);
        }
        return true;
    }

    public Iterator iterator(){
        return new gen(this);
        
    }

    private static class gen implements Iterator{
        //public Comparable el;
        //public gen lchild;
        public OrderedList list;

        gen(OrderedList l){
            list = l;
           // el = element;
            
        }
        public boolean hasNext() {
            if (list.left == null && list.right == null){
                System.out.println("list.left == null && list.right == null");
                return false;
            }
            return true;
        }
        //DA RIVEDERE!!
        public Object next() {
            if(list.left == null){
                
                return list.right.val;
            }else if (list.right == null){
                
                return list.left.val;
            }
            return list.val;
        }

    }

    @Override
    public int compareTo(T arg0) {
        return 0;
    }

    public String toString(){
        OrderedList t = new OrderedList();
        t = this;
        String s = "";
            if (!t.left.empty){
                t.left.toString();
            }
            s += String.valueOf(this.val) + ", ";
            System.out.print(s);
            if  (!t.right.empty){
                t.right.toString();
            }
        return s;
    }

    public boolean repOk(){
        if (this.empty){
            return true;
        }
        if(this.left.val.compareTo(this.val) < 0 && this.right.val.compareTo(this.val) > 0){
            return true;
        }
        return false;
    }
     public static void main(String[] args) {
        OrderedList list = new OrderedList();
        list.addEl(3);
        list.addEl(5);
        list.addEl(2);
        list.addEl(1);
        list.addEl(7);
        list.addEl(4);
        //list.remEl(6);
        list.toString();
        //System.out.println(list.toString());
    }

}