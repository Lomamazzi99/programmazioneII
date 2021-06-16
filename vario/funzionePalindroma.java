public class funzionePalindroma{
    public static void main(String[] args) {
        String s = "mamma";
        palindroma((s));
    }

    public static void palindroma(String s) {
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                System.out.println("non palindroma");
                return;
            }
        }
        System.out.println("palindroma");
    }
}