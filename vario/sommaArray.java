
public class sommaArray{

    public static int sum(int a[]) throws ArrayIndexOutOfBoundsException{
        int sum = 0;
        try {
            int m = a[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            //throw new ArrayIndexOutOfBoundsException("array vuoto");
            System.out.println("array vuoto");
        }
        for (int i = 0; i < a.length;i++){
            sum += a[i];
        }
        return sum;
    }
    public static void main(String args[]){
       int a[] = {};
       System.out.println(sum(a));
    }
}