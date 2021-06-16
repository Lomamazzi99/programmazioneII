import java.util.Objects;

/**
 * Overview:
 * Le istanze di questa classe rappresentano una Cella la quale è definita da una colonna che va da A a Z e da una riga, 
 * il cui valore deve essere positivo.
 * Ogni Cella possiede un Contenuto che può essere una Costante o una Formula.
 * Gli oggetti di questa classe sono immutabili dal momento che è possibile cambiare il contenuto.  
 */
public class Cella implements Comparable<Object>{

    /**La riga che definisce la Cella */
    private final int row;
    /**La colonna che definisce la Cella */
    private final char column;
    /**Il contenuto della Cella */
    private Contenuto contenuto;


    /**
     * Post condizioni: inizializza this affinchè rappresenti una Cella
     */

    public Cella(int row, char column, Contenuto contenuto){
        if(row < 0 ) throw new IllegalArgumentException();
        this.row = row;

        if( Character.toUpperCase(column) < 'A' &&  Character.toUpperCase(column) > 'Z'){
            throw new IllegalArgumentException();
        }
        this.column = Character.toUpperCase(column);
        
        Objects.nonNull(contenuto);
        this.contenuto = contenuto;
    }

    /**
     * Effetti collaterali: potrebbe modificare il contenuto della Cella
     * Post condizioni: aggiorna il contenuto della cella
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui il contenuto sia null
     */
    public void changeContentuto(Contenuto contenuto){
        Objects.nonNull(contenuto);
        this.contenuto = contenuto;
    }
    

    /**
     * post condizioni: restituisce il contenuto della cella
     */
    public int getContenuto(){
        return contenuto.getContenuto();
    }

    /**
     * Post condizioni: restituisce la riga della cella
     */
    public int getRow() {
        return row;
    }

    /**
     * @return restituisce la colonna della cella
     */
    public char getColumn() {
        return column;
    }

    @Override
    public String toString() {
        String s = String.format("%c%d : %d", column,row,getContenuto());
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Cella)) return false;
        Cella c = (Cella) obj;
        
        return  c.column == column &&
                c.row == row;
    }

    @Override
    public int hashCode() {
        int result = 31*Integer.hashCode(row);
        result += Character.hashCode(column);
        return result;
    }
    

    @Override
    public int compareTo(Object arg0) {
        Objects.nonNull(arg0);
        if(!(arg0 instanceof Cella)){
            throw new ClassCastException();
        }
        Cella c = (Cella) arg0;
        if(c.row > row) return -1;
        if(c.row < row) return 1;
        if(c.column > column) return -1;
        if(c.column < column) return 1;

        return 0;
    }


}
