/*
Static methods are useful if you have only one instance where you're going to use the method, 
and you don't need multiple copies (objects). Non-static methods are used if you're going to use your 
method to create multiple copies.
*/

/*
---Esercizio filtro---
Scrivere una classe (concreta) Punto con i campi interi x, y, z.
Scrivere i metodi somma e sottrai che, dato un altro punto, eseguono la corrispondente operazione 
coordinata per coordinata restituendo un nuovo punto.
Scrivere inoltre il metodo norma che calcola la somma dei valori assoluti delle coordinate del punto, 
restituendola come intero.
La classe deve infine sovrascrivere toString in modo che, dato un punto con coordinate x, y, z, 
restituisca una stringa nel formato (x, y, z).

*/

/**
 * Un Punto.
 * 
 * Questa classe (immutabile) ha lo scopo di rappresentare un Punto definito da 3 parametri pubblici
 * e interi:
 * @param x
 * @param y
 * @param z
 */

 public class Punto{

    //dal momento che la classe è immutabile è plausibile che i suoi attributi siano pubblici
    //la rappresentazione della classe Punto è data da 3 parametri interi x,y,z che rappresentano le
    //coordinate all'interno dello spazio
    public final int x;
    public final int y;
    public final int z;

    //La rappresentazione è valida poichè i parametri possono essere interi sia 
    //positivi che negativi (essendo in uno spazio tridimensionale).
    //L'invariante è sempre assicurato dall'unico costruttore, perciò è sempre valido.
    public Punto(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Punto somma(Punto q){
        return new Punto((q.x + this.x), (q.y + this.y), (q.z + this.z));
    }

    public Punto sottrai(Punto p){
        return new Punto((this.x - p.x), (this.y - p.y), (this.z - p.z));
    }

    public int norma(){
        return (Math.abs(this.x) + Math.abs(this.y) + Math.abs(this.z));
    }

    //per "sovrascrivvere" devo fare @override
    @Override
    public String toString(){
        return String.format("(%d,%d,%d)", this.x,this.y,this.z);
    }
 }