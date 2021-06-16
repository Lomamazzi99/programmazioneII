import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * OVERVIEW: le istanze di questa classe rappresentano interpreti in grado di interpretare i comandi dell'utente e riportarli al foglio di calcolo in un modo a lui comprensibile.
 * <p>Gli oggetti di questo tipo sono immutabili.
 */
public class Interprete {
    //Il foglio di calcolo a cui questo interprete comunica le istruzioni.
    FoglioCalcolo f;

    /**
     * Istanzia this a un nuovo interprete.
     */
    public Interprete(){
        f=new FoglioCalcolo();
    }

    /**
     * Crea e restituisce una nuova cella a partire dalla stringa passata come input.
     * @param s La stringa contenete colonna, riga e contenuto della cella da creare.
     * @throws IllegalArgumentException Se la stringa non e' formattata correttamente.
     */
    private Cella newCell(String s){
        String[] args=s.split(" ");
        char column=args[1].charAt(0);
        int row=args[1].charAt(1);

        if(!args[2].equals("=")){
            Contenuto cont=new Costante(Integer.parseInt(args[2]));
            return new Cella(row, column, cont);
        }

        Operazione op=null;

        switch(args[3]){
            case "SUM":
                op=Operazione.SUM;
                break;
            case "SUB":
                op=Operazione.SUB;
                break;
            case "MUL":
                op=Operazione.PROD;
                break;
            case "MAX":
                op=Operazione.MAX;
                break;
            default:
                throw new IllegalArgumentException();
        }
        
        String cells=args[4];
        List<Cella> c=new ArrayList<>();
        c.add(f.getCella(cells.charAt(0), cells.charAt(1)-'0'));

        if(cells.charAt(2)==';'){
            String[] argsForumula=cells.substring(3, cells.length()).split(";");
            for(String str:argsForumula)
                c.add(f.getCella(str.charAt(0), str.charAt(1)-'0'));
        }else if(cells.charAt(2)==':'){
            Cella stop=f.getCella(cells.charAt(3), cells.charAt(4)-'0');
            if(!possibleRange(c.get(0), stop))
                throw new IllegalArgumentException();
            if(c.get(0).getColumn()==stop.getColumn()){
                for(int i=c.get(0).getRow()+1;i<stop.getRow();i++)
                    c.add(f.getCella(c.get(0).getColumn(), i));
            }else{
                for(char i= (char) (c.get(0).getColumn() + 1); i < stop.getColumn(); i++)
                    c.add(f.getCella(i, c.get(0).getRow()));
            }
            c.add(stop);
        }
        Contenuto cont=new Formula(op,c);
        return new Cella(row,column,cont);
    }

    /**
     * Valuta se e' possibile avere un range di cella tra le due celle passate come parametro.
     * @param c1 La cella di partenza del range.
     * @param c2 La cella di arrivo del range.
     * @return True se e' possibile creare un range da c1 a c2, false altrimenti.
     */
    private static boolean possibleRange(Cella c1,Cella c2){
        if(c1.getColumn()==c2.getColumn())
            return true;
        if(c1.getRow()==c2.getRow()) 
            return true;
        return false;
    }

    /**
     * Avvia la lettura da standard input dei comandi dell'utilizzatore del foglio di calcolo.
     */
    public void start(){
        Scanner s=new Scanner(System.in);

        while(s.hasNextLine()){
            String line=s.nextLine();
            
            switch(line.charAt(0)){
                case '!':
                    try{
                        f.insertCella(newCell(line));
                    }catch(RuntimeException e){
                        System.out.println("undefined");
                    }	
                    break;
                case '?':
                    try{
                        System.out.println(f.getCella(line.charAt(2), line.charAt(3)-'0'));
                    }catch(UndefinedCellException e){
                        System.out.println("undefined");
                    }
                    break;
                case 'P':
                    System.out.println(f);
            }
        }
        s.close();
    }
}