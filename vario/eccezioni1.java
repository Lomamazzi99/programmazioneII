import java.util.EmptyStackException;

public class eccezioni1{
    public static int min(int a[]) throws NullPointerException, EmptyException {
        int m;
        try {
            m = a[0];
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Array.min");
        }
        for (int i = 1; i < a.length; i++){
            if ( a[i] < m) {
                m = a[i];
            return m;
            }
            
        }
    }
    public static void main(String args []) {
        int a[] = {7,4,1,8,5,2};
        int t;
        t = min(a);
        System.out.println(t);
    }
}