import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interprete {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Civiltà> civiltàs = new ArrayList<>();
/*
        while (scan.hasNextLine()){
            System.out.println("Inserisci il nome di una nuova risorsa, o 'stop' per non inserire altre risorse.");
            String nomeOriginale = scan.nextLine();
            if(nomeOriginale.compareTo("stop") == 0) break;
            System.out.println("Qual è il suo prezzo?");
            int prezzo = Integer.parseInt(nomeOriginale.split(" ")[1]);
            Risorsa r = new Risorsa(nomeOriginale, prezzo);
            Risorsa.lista.add(r);

            System.out.println("Vuoi creare una risorsa derivata da Grano (prezzo 50)? [y/n]");
            String nomeder = scan.nextLine();
            if(nomeder.compareTo("y") == 0){
                System.out.println("Qual è il suo prezzo?");
                int prezzoder = Integer.parseInt(nomeder.split(" ")[1]);
                Risorsa rd = new RisorsaDerivata(nomeder, prezzoder, r);
                Risorsa.lista.add(rd);
            }

        }

        while (true) {
            System.out.println("Inserisci il nome di una nuova civiltà oppure stop:");
            String nomeCiviltà = scan.nextLine();
            if(nomeCiviltà.compareTo("stop") == 0) break;
            Civiltà c = new Civiltà(nomeCiviltà);
            civiltàs.add(c);

            while (true) {
                System.out.println("Inserisci il nome di una nuova città, o 'stop' per non inserire altre città.");
                String nomeCittà = scan.nextLine();
                if(nomeCittà.compareTo("stop") == 0) break;
                System.out.println("Di che tipo dev'essere? [i/e]");
                char tipo = scan.nextLine().toCharArray()[0];
                c.fondaCitta(nomeCittà, tipo);

            }
        }

        Storia s = new Storia((Civiltà[]) civiltàs.toArray());
        int cicli =  scan.nextInt();
        Civiltà ricca = s.Commercia(cicli);
        System.out.println("Civiltà più ricca: " + ricca.getNome() + " con " + ricca.getTesoro());
        scan.close();
        */

        
    }
}
