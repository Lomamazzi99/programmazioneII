package Esercitazione7;

import java.util.Objects;

public class Segmento implements Figure{

    private boolean isVertical;
    private int length;
    private Coordinata start;


    public Segmento(boolean isVertical, int length, Coordinata start){
        if(length <= 0) throw new IllegalArgumentException("la lunghezza non può essere negativa");
        this.start = Objects.requireNonNull(start);
        this.isVertical = isVertical;
        this.length = length;
    }

	@Override
	public void draw(BitMap bitmap) {
        int r = start.riga , c = start.colonna;
        if(isVertical){
            for(int i = 0; i < length;i++){
                bitmap.turnOn(new Coordinata(r+i,c));
            }
        }else{
            for(int i = 0; i < length;i++){
                bitmap.turnOn(new Coordinata(r,c+i));
            }
        }
		
    }
    

    
}
