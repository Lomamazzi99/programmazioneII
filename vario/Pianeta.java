/**
 * Un pianeta.
 * 
 * Questa classe concreta è utilizzata per implementare un pianeta come sottoclasse di un corpo celeste.
 * Un pianeta può cambiare velocità a seconda della sua vicinanza con un altro corpo celeste e di conseguenza anche la sua 
 * posizione.
 */

public class Pianeta extends CorpoCeleste{

    public Pianeta(String s, Punto p) {
        super(s, p);
    }

    @Override
    public Punto getSpeed() {
        return this.velocità;
    }

    //Nel caso in cui la velocità sia stata aggiornata (e quindi diversa da quella originale),
    //un pianeta cambia di conseguenza anche la sua posizone all'interno dello spazio tridimensionale.
    //Questo cambiamento è dato dalla sommatoria della posizione attuale del pianeta con la sua velocità aggiornata.
    @Override
    public void aggiornaPosizione() {
        Punto zero = new Punto(0,0,0);
        if(this.getSpeed() != zero){
            this.posizione = this.posizione.somma(this.velocità);   
        }

    }



    /**
     * Dato un corpo celeste @param p come input:
     * Questo metodo lancia un'eccezione nel caso in cui p o this siano null,
     * in caso contrario verifico le coordinate dei due punti e suddivido in due casi:
     * 1) se la coordinata x/y/z di p è minore della coordinata x/y/z di this, allora aggiorno la velocità
     * di this incrementandola di 1
     * 2) se la coordinata x/y/z di p è maggiore della coordinata x/y/z di this, allora aggiorno la velocità
     * di this decrementandola di 1
     * 
     * Non aggiorno la velocità di p perchè esso potrebbe essere una stella fissa, 
     * in quel caso la velocità non può cambiare.
     */
    @Override
    public void aggiornaVelocità(CorpoCeleste p) {
        Punto q = new Punto(1,0,0);
        Punto w = new Punto(0,1,0);
        Punto t = new Punto(0,0,1);

        if (p == null || this.posizione == null) throw new IllegalArgumentException("né p né this possono essere null");

        if(this.posizione.x > p.posizione.x){
            this.velocità = this.velocità.somma(q);
        }else if (this.posizione.x < p.posizione.x){
            this.velocità = this.velocità.sottrai(q);
        }

        if(this.posizione.y > p.posizione.y){
            this.velocità = this.velocità.somma(w);
        }else if (this.posizione.y < p.posizione.y){
            this.velocità = this.velocità.sottrai(w);
        }

        if(this.posizione.z > p.posizione.z){
            this.velocità = this.velocità.somma(t);
        }else if (this.posizione.z < p.posizione.z){
            this.velocità = this.velocità.sottrai(t);
        }

    }

    @Override
    public String nome() {
       return this.nome;
    }

    @Override
    public Punto posizione() {
        return this.posizione;
    }

    
}