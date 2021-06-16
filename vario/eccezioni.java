public class eccezioni{
    public static int search1 (int a[],int x){
        int i;
        for (i = 0; i < a.length;i++){
            if (a[i] == x){
                return i;
            }
        }
        return 0;
    }

    public static int search (int a[],int x) throws IndexOutOfBoundsException{
        try {
          int  t = a[0]; 
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("array vuoto!");
        }

        int i = 0;
        while ( i >= 0){
            if ( a[i] == x){
                return i;
            }
            i++;
        }
     return 0;   
    }

    public static void main(String args[]){
        int array1[] = {};
        int x = 4;
        int t = search(array1,x);
        System.out.println(t);
    }
}