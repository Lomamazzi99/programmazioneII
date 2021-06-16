import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Overview:
 * Le istanze di questa classe rappresentano un foglio di calcolo, il quale è formato da un Insieme di Celle bidimensionale.
 * Le istanze di questa classe sono mutabili.
 */
public class FoglioCalcolo {
    /**La struttura dati che contiene le celle */
    private List<Cella> celle;

    /**
     * Post condizioni: inizializza this affinchè rappresenti un Foglio di calcolo
     */
    public FoglioCalcolo(){
        celle = new ArrayList<Cella>();
    }

    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni: inserisce una cella c all'interno del foglio di calcolo se essa non è presente, altrimenti ne aggiorna il contenuto
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui la cella sia null
     */
    public void insertCella(Cella c){
        Objects.nonNull(c);
        if(celle.contains(c)){
            celle.set(celle.indexOf(c), c);
        }else{
            celle.add(c);
        }        
    }

    public boolean contains(int r, int c){
        for(Cella cella : celle){
            if(cella.getColumn() == c && cella.getRow() == r) return true;
        }
        return false;
    }

    public Iterator<Cella> iterator(){
        return celle.iterator();
    }

    public Cella getCella(int r, int c){
        
        if(!contains(r,c)) throw new UndefinedCellException();
        for(Cella cella : celle){
            if(cella.getColumn() == c && cella.getRow() == r) return cella;
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "{ ";
        for(int i = 0; i < celle.size()-1;i++){
            Cella c = celle.get(i);
            s += c.toString();
            s += ", ";
        }
        s +=  celle.get(celle.size()-1).toString();
        s += " }";
        return s;
    }


}
