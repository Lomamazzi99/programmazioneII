import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Shell sh = new Shell();
            sh.getComando(line);
        }
        scan.close();
    }
}
