import java.util.Scanner;

public class prova {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Convoglio c = new Convoglio(s);
        System.out.println(s.split(" ").length);
        c.addModello(s);
        for(int i = 0; i < s.split(" ").length-1;i++){
            c.addRotabile(scan.nextLine());
        }

        
        System.out.println(c.toString());
        scan.close();
    }

}

