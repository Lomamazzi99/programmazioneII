/**
 * Una stella fissa.
 * 
 * Questa classe concreta è utilizzata per implementare Una stella fissa come sottoclasse di un corpo celeste.
 * Una stella fissa non può cambiare velocità né posizione.
 */
public class StellaFissa extends CorpoCeleste{

    public StellaFissa(String s, Punto p) {
        super(s, p);
    }

    @Override
    public String nome() {
        return this.nome;
    }


    //nel caso in cui la velocità della stella non sia zero viene sollevata un'eccezione
    @Override
    public Punto getSpeed() {
        Punto zero = new Punto(0,0,0);
        if(this.velocità != zero)
        throw new IllegalArgumentException("La velocità di una stella non può essere diverso da nulla");

        return this.velocità;
    }


    //poiché la posizione di una stella fissa non può essere modificata, viene mandato un messaggio 
    //ogni volta descrivendo tale proprietà
    @Override
    public void aggiornaPosizione() {
        System.out.println("una stella non può cambiare la sua posizione!");
    }

    //poiché la velocità di una stella fissa non può essere modificata, viene mandato un messaggio 
    //ogni volta descrivendo tale proprietà, indipendentemente da quale sia il corpo celeste e la sua posizione
    //(ciò spiega come mai non vengano fatti controlli sul corpo celeste, esso non è rilevante)
    @Override
    public void aggiornaVelocità(CorpoCeleste p) {
        System.out.println("una stella non può cambiare la sua velocità!");
    }

    @Override
    public Punto posizione() {
        return this.posizione;
    }


   
    
}