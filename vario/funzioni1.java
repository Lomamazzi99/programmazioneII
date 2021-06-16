public class funzioni1{
    public static void main(String[] args) {
        int n = 29;
        System.out.println(isPrime(n));
    }

    private static int isPrime(int n) {
        for (int i = 2; i < n/2; i++){
            if (n % i == 0){
                return 0;
            }
        }
        return 1;
    }
}