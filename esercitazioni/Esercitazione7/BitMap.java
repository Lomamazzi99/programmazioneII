package Esercitazione7;


/**
 * b
 * h
 * bitmap
 * accendi
 * spegni
 * inverti
 * pulisci
 * render
 */

public class BitMap {

    private int b;
    private int h;
    private boolean[][] bitmap;

    public BitMap(int b,int h){
        if(b <= 0) throw new IllegalArgumentException("b non può essere negativo");
        if(h <= 0) throw new IllegalArgumentException("h non può essere negativo");
        this.b = b;
        this.h = h;
        this.bitmap = new boolean[b][h];
    }

	public void turnOn(Coordinata coordinata) {
        if(coordinata.riga >= h || coordinata.riga <= 0 ||  coordinata.colonna > b || coordinata.colonna <= 0) throw new IllegalArgumentException();
        bitmap[coordinata.riga][coordinata.colonna] = true;
    }
    public void turnOff(Coordinata coordinata) {
        if(coordinata.riga >= h || coordinata.riga <= 0 ||  coordinata.colonna > b || coordinata.colonna <= 0) throw new IllegalArgumentException();
        bitmap[coordinata.riga][coordinata.colonna] = false;
    }
    
    public void invert(Coordinata coordinata){
        bitmap[coordinata.riga][coordinata.colonna] = !bitmap[coordinata.riga][coordinata.colonna];
    }
    public void clean(){
        
        for(int i = 0; i < bitmap.length;i++){
            for(int j = 0; j < bitmap[i].length;j++){
                bitmap[i][j] = false;
            }
        }
    }

    public String render(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < h;i++){
            for(int j = 0; j < b;j++){
                sb.append(bitmap[i][j] ? '*':'.' );
            }
            sb.append("\n");
        }
        return sb.toString();
    }



    
}
