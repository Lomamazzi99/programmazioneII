import java.util.Objects;

/**
 * Esercitazione 5
 * Implementare una gerarchia di oggetti utili a rappresentare numeri razionali.
 * Una volta che un oggetto è stato creato dovrà essere fornita la possibilità di 
 * svolgere le classiche operazioni algebriche tra numeri razionali.
 * Inoltre il meotdo repOk() dovrà fornire un'appropriata implementazione dell'invariante
 * di rappresentazione e dovranno essere sovrascritti in maniera opportuna i metodi
 * toString(), equals() e hashcode()
 * 
 * Fornire infine una dimostrazione della correttezza dell'implementazione.
 * Si dovrà mostrare tramite che l'invariante di rappresentazione sia preservato, che le operazioni
 * sviluppate siano adeguate e svolgano in maniera corretta ciò per cui sono state definite e 
 * che valga l'invariante di astrazione.
 * Per la verifica di correttezza dobbiamo verificare che  la nostra implementazione faccia riferimento
 * (ossia l'immagine della nostra implementazione mappi un oggetto del tipo che ci eravamo immaginati)
 *                                          
 * Per la verifica dell'invariante di rappresentazione dobbiamo controllare i metodi che creano oggetti e che li modificano
 * 
 */


/**
 * OVERVIEW: le istanze di questa classe rappresentano numeri razionali.
 *           Gli oggetti NON sono MUTABILI (non prevediamo metodi mutazionali).
 *           Un tipico numero razionale è dato dalla forma numeratore / denominatore (numeri interi)
 *           Inoltre il denominatore deve essere diverso da 0
 */
public class Rational {
    //CAMPI
    /**I campi che rappresentano il numeratore e il denominatore di un numero razionale*/
    private int numeratore;
    private int denominatore;

    /**
     * Funzione d'astrazione: AF(numeratore, denominatre) = numeratore / denominatore
     *                        
     * 
     * Invariante di rappresentazione: denominatore > 0
     * 
     * Invariante d'astrazione: denominatore != 0
     */

    // COSTRUTTORI
    /**
     * Post condizioni: Inizializza this affinchè rappresenti il numero razionale
     *                  n/d Solleva un'eccezione nel caso in cui d sia uguale 0 di tipo
     *                  ArithmeticException.
     * 
     * Preservazione RI: se d == 0 è sollevata un'eccezione e quindi this non è istanziato.
     *                   Altrimenti è utilizzato il suo valore assoluto.
     * 
     * Correttezza:  AF(numeratore, denominatre) = numeratore / denominatore 
     *               = (numeratore /cd) / (denominator/cd) , dove cd = gcd(|numeratore|, denominatore) -> c'è il reduce()
     *               = -|numeratore| / |denominatore| se numeratore * denominatore < 0
     *               = |numeratore| / |denominatore| altrimenti
     *              
     * 
     * Preservazione AI: nei casi in cui denominatore > 0 allora è anche != 0
     * 
     */
    public Rational(int n, int d) {
        if (d == 0)
            throw new ArithmeticException("Numero razionale non accettabile. Il denominatore non può essere 0");
        numeratore = n * d > 0 ? Math.abs(n) : -Math.abs(n);
        denominatore = Math.abs(d);
        reduce();
        repOk();
    }

    // METODI

    /**
     * Post condizioni: restituisce un nuovo numero razionale this + r 
     *                  solleva un'eccezione di tipo NullPointerException neò caso in cui r sia null
     * 
     * //per ipotesi tutti gli oggetti che sono arrivati qui rispettano l'invariante di rappresentazione
     * Preservazione RI: this.denominatore > 0 & r.denominator > 0 -> r.numeratore * denominatore > 0
     *                   
     * Correttezza:  numeratore / denominatore + r.numeratore / r.denominatore =
     *               = ((numeratore * r.denominatore) + (r.numeratore * denominatore))/(denominatore * r.denominatore)
     * Preservazione AI:
     */
    public Rational add(Rational r) {
        Objects.requireNonNull(r);
        return new Rational((numeratore * r.denominatore) + (r.numeratore * denominatore)
            ,denominatore * r.denominatore);
    }

    /**
     * Post condizioni: restituisce un nuovo numero razionale this * r 
     *                  solleva un'eccezione di tipo NullPointerException neò caso in cui r sia null
     *  //per ipotesi tutti gli oggetti che sono arrivati qui rispettano l'invariante di rappresentazione
     * Preservazione RI: this.denominatore > 0 & r.denominator > 0 -> r.numeratore * denominatore > 0
     * Correttezza:  numeratore /denominatore * r.numeratore / r.denominatore=
     *               = numeratore * r.numeratore / denominatore*r.denominatore
     * Preservazione AI:
     */
    public Rational mult(Rational r) {
        Objects.requireNonNull(r);
        return new Rational(numeratore * r.numeratore, denominatore*r.denominatore);
    }

    /**
     * Post condizioni: restituisce un nuovo numero razionale this - r 
     *                  solleva un'eccezione di tipo NullPointerException neò caso in cui r sia null
     * 
     * Preservazione RI: r.denominatore > 0 -> r.minus().denominatore > 0
     *                   this.denominatore > 0 & r.minus().denominatore > 0 -> this.add(r.minus()).denominatore > 0
     * 
     * Correttezza:  numeratore / denominatore - r.numeratore / r.denominatore =
     *               = ((numeratore * r.denominatore) - (r.numeratore * denominatore))/(denominatore * r.denominatore)
     */
    public Rational sub(Rational r) {
        Objects.requireNonNull(r);
        return add(r.minus());
    }

    /**
     * Post condizioni: restituisce un nuovo numero razionale this / r 
     *                  solleva un'eccezione di tipo NullPointerException nel caso in cui r sia null
     *                  solleva un'eccezione di tipo ArithmeticException nel caso in cui r == 0
     * 
     * Preservazione RI:    Se r.denominatore è 0 allora viene sollevata un'eccezione e quindi non è restituito un nuovo oggetto
     *                      r.denominatore > 0 & r.reciprocal().denominatore > 0 -> this.mult(r.reciprocal()).denominatore > 0
     * 
     * Correttezza:  numeratore /denominatore / r.numeratore / r.denominatore=
     *               = numeratore / r.numeratore / denominatore / r.denominatore
     *                      
     */
    public Rational div(Rational r) {
        Objects.requireNonNull(r);
        if(denominatore == 0) throw new ArithmeticException();
        return mult(r.reciprocal());
    }


    /**
    *Post condizioni: restituisce il numero razionale -this
     //per ipotesi tutti gli oggetti che sono arrivati qui rispettano l'invariante di rappresentazione
     * Preservazione RI: denominator > 0 
     */
    public Rational minus(){
        return new Rational(-numeratore, denominatore);
    }

    /**
     * Post condizioni: restituisce un nuovo numero razionale 1/this 
     *                  solleva un'eccezione di tipo ArithmeticException nel caso in cui this == 0
     * 
     *  //per ipotesi tutti gli oggetti che sono arrivati qui rispettano l'invariante di rappresentazione
     * Preservazione RI: se numerator == 0 viene sollevata un'eccezione
     *                   altrimenti valido per ipotesi induttiva
     * 
     * Correttezza: 
     */
    public Rational reciprocal() {
        return new Rational(denominatore, numeratore);

    }

    /**
     * Pre condizioni: this.denominatore > 0 
     * Effetti collaterali: potrebbe modificare this se non è gia ridotto ai minimi termini 
     * Post condizioni: modifica this affinchè rappresenti il numero razionale ai minimi termini
     * 
     * Preservazione RI: this.denominatore > 0 -> denominatore >= gcd(|numeratore|, denominatore) > 0
     *                   Pertanto, denominatore / gcd(|numeratore|, denominatore) > 0
     * 
     * Correttezza:  AF(numeratore, denominatre) = numeratore / denominatore 
     *               = (numeratore /cd) / (denominator/cd) , dove cd = gcd(|numeratore|, denominatore) -> c'è il reduce()
     *              
     * Preservazione AI:
     */
    public void reduce() {
        int cd = gcd(Math.abs(numeratore), denominatore);
        numeratore /= cd;
        denominatore /= cd;
    }

    /**
     *Post condizioni: restituisce il massimo comun divisore tra i numeri a e b
                        Solleva un'eccezione nel caso in cui a < 0 e/o b < 0


     */
    public static int gcd(int a, int b){
        if(a < 0 || b < 0) throw new IllegalArgumentException("a e b devono essere maggiori di 0");
        while (b != 0) {
            int tmp = b;
            b = b % a;
            a = tmp;
        }
        return a;
    }

    @Override
    public String toString(){
        if(denominatore == 1) return "" + numeratore;
        return String.format("%d / %d",numeratore, denominatore);
    }

    @Override
    public int hashCode(){
        //se equals è uguale allora anche l'hashcode deve essere uguale
        //utilizziamo gli stessi campi
        int result = Integer.hashCode(numeratore);
        //per ogni campo da tenere in considerazione per hashcode
        //31 perchè primo
        result = 31 * result + Integer.hashCode(denominatore);

        return result;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Rational)) return false; //controlla già se o è null

        Rational r = (Rational) o;
        //se effettuiamo la reduce allora dobbiamo scrivere la correttezza
        //reduce();
        //r.reduce();
        return (numeratore == r.numeratore) && (denominatore == r.denominatore);
    }

    private boolean repOk(){
        return denominatore != 0;
    }



}
