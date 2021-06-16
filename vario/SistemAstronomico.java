import java.util.ArrayList;
import java.util.Scanner;

public class SistemAstronomico {
    public static void main(String[] args) {
        ArrayList<CorpoCeleste> as = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        //int count = scan.nextInt();

        while(scan.hasNext()){
            String s = scan.nextLine();
            String[] insieme = s.split(" ");
            String nome = insieme[0];
            Punto p = new Punto(Integer.parseInt(insieme[1]), Integer.parseInt(insieme[2]),Integer.parseInt(insieme[3]));
            Pianeta pp = new Pianeta(nome, p);
            as.add(pp);
        }

        for(int i = 0; i < as.size();i++){
            System.out.print(as.get(i).nome + " ");
            System.out.println(as.get(i).posizione.toString());
        }
        
        scan.close();
    }
}