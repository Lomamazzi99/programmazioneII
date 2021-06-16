package Esercitazione7;

import java.util.List;
import java.util.Objects;


public class Rettangolo implements Figure{

    private Figure rectangle;

    public Rettangolo(int h,int l,Coordinata start){
        Objects.requireNonNull(start);
        if(l <= 0) throw new IllegalArgumentException("La lunghezza deve essere positiva");
        if(h <= 0) throw new IllegalArgumentException("L'altezza deve essere positiva");

        /**
         * 1,2,3,4 sono i segmenti
         * 
         * 
         * 0 3 3
         * 0   2
         * 0   2
         * 0   2
         * 0   2
         * 1 1 2
         */


        rectangle = new FigureComp(
            List.of(
            new Segmento(true,h-1,start),
            new Segmento(false,l-1,new Coordinata(start.riga + h -1,start.colonna)),
            new Segmento(true,h-1,new Coordinata(start.riga + 1, start.colonna+l-1)),
            new Segmento(false,l-1,new Coordinata(start.riga , start.colonna+1))
            )
        );

    }

    @Override
    public void draw(BitMap bitmap) {
        rectangle.draw(bitmap);
    }
    
}
