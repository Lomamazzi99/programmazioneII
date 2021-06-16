import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "";
        for(int i = 0; i < args.length;i++){
            s += args[i] + " ";
        }
        Interprete Interprete = new Interprete(s);
        
        
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            Interprete.insertRotabili(line);
        }
        System.out.println(Interprete.toString());
        Convoglio c = Interprete.createConvoglio();
        System.out.println(Interprete.toString());
        System.out.println(c.toString());
        
        scan.close();
       
    }
    
    
}
