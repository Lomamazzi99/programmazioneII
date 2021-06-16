/**
 * Un locomotore.
 * 
 * Un locomotore viene definito come una sottoclasse concreta della classe rotabile.
 * Questa classe ha il compito di definire un locomotore come come un rotabile avente una 
 * potenza >= 0.
 */
public class Locomotore extends Rotabile{

    private int potenza;

    public Locomotore(String modello, int peso) {
        super(modello, peso);
        this.potenza = 0;
    }

    /**
     * Avente come input una stringa @param s estrapoliamo da essa la potenza che identifica un
     * locomotore, sollevando un'eccezione nel caso in cui s sia null o se la potenza è minore di zero
     */
    public final void setPotenza(String s){
        if (s == null) throw new NullPointerException("s non può essere null");
        String[] potenza = s.split(" ");
        if(Integer.parseInt(potenza[3]) < 0) throw new IllegalArgumentException("potenza non negativa");
        this.potenza = Integer.parseInt(potenza[3]);
    }

    @Override
    public String toString(){
        return String.format("%s %d %d", this.modello,this.peso,this.potenza);
    }

    @Override
    public boolean repOk() {
        if(this.modello == null) return false;
        if(this.peso < 0 ) return false;
        if(this.potenza < 0) return false;
        return true;
    }

    /**
     * Questo metodo restituisce la potenza del locomotore usando una varibile locale "power"
     * in modo da non esporre la rappresentazione.
     * @return power
     */
    public final int getPotenza(){
        int power = this.potenza;
        return power;
        //return potenza
    } 
    
}