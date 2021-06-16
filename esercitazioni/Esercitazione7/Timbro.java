package Esercitazione7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Timbro implements Figure {

    private final Set<Coordinata> coords;

    public Timbro(int[][] mat){
        if(mat == null) throw new IllegalArgumentException("la matrice non può essere null");
        Set<Coordinata> tmp = new HashSet<>();
        for(int i = 0; i < mat.length;i++){
            for(int j = 0; j < mat[i].length;j++){
                if(mat[i][j] != 0){
                    tmp.add(new Coordinata(i,j));

                }
            }
        }
        //se il set non è modificabile ed è final allora non cambia nel tempo e 
        //l'invariante di rappresentazione è sempre rispettato
        coords = Collections.unmodifiableSet(tmp);
    }
    
    @Override
    public void draw(BitMap bitmap) {
        for(Coordinata coord :coords) bitmap.turnOn(new Coordinata(coord.riga,coord.colonna));

        
    }
    
    
    //offset sia di riga che colonna -> quanto è spostata rispetto all'origine
    public void draw(BitMap bitmap,int r,int c) {
        for(Coordinata coord :coords) bitmap.turnOn(new Coordinata(coord.riga + r,coord.colonna + c));

    }
    
}
