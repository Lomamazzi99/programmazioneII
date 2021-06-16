public class Test {
    public static void main(String[] args) {
        IntSet is = new IntSet();
        for(int i = 0 ; i < 10;i++){
            is.insert(i);
        }
        System.out.println(is.toString());

        for(int i = 11 ; i > 7;i--){
            is.remove(i);
        }
        System.out.println(is.toString());
    }
}
