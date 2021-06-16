

public class funzioni{
    public static void main(String[] args) {
        int[] a = {1,10};
        System.out.println(sum(a));
        }
    
    public static int sum(int a[]) throws IndexOutOfBoundsException{
    int sum = 0;
        try {
           int m = a[0];
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("array vuoto!");
        }

        for (int i = 0; i < a.length;i++){
            sum += a[i];
        }
        return sum;
    }
}