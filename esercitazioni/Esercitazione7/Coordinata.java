package Esercitazione7;

import java.util.Objects;

public class Coordinata {
    public final int riga;
    public final int colonna;

    public Coordinata(int riga, int colonna){
        this.colonna = colonna;
        this.riga = riga;
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(riga,colonna);    
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Coordinata)) return false;
        Coordinata c = (Coordinata) obj;
        return c.colonna == colonna && c.riga == riga;
    }
}
