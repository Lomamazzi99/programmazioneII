/**
 * TerzaEs
 * Progettare e implementare una gerarchia di oggetti utili a rappresentare polinomi in una sola
 * variabile a coefficienti interi
 * Si dovrà procedere quindi con la creazione di una classe Poly che deve avere un costruttore
 * privo di parametri che consentirà di creare un polinomio zero e un costruttore 
 * Poly(int c, int n) che istanzierà il monomio c*x^n e solleverà un'eccezione del tipo 
 * NegativeExponentException (non controllata) se n è negativo
 * 
 * Una volta che l'oggetto esiste dovrà essere fornita la possibilità di svolgere operazioni
 * algebriche tra polinomi di somma Poly add(Poly q) , di differenza Poly sub(Poly q)e prodotto
 * Poly mul(Poly q) e di ottenere un polinomio opposto Poly minus()
 * 
 * La classe deve inoltre avere dei metodi che consentano di reperire informazioni riguardo allo stato
 * delle istanze di Poly, in particolare i metodi int degree() e int coeff(int d) deve restituire
 * rispettivamente il grado del polinomio e il coefficiente del termine di grado d
 * 
 * Sovrascivere infine il metodo toString() in modo che restituisca in maniera significativa 
 * lo stato dell'istanza sul quale è invocato
 * 
 * Infine creare una classe di Test
 */

/**
 * OVERVIEW:
 * Le istanze di questa classe rappresentano polinomi in una sola variabile a coefficienti interi.
 * Gli oggetti di questo tipo NON sono mutabili
 * Es: 4x^0 + 3x^1 + 2x^2
 */

public class Poly {
    /**Array contente i coefficienti del polinomio */
    private final int[] coeff;
    /**Grado del polinomio */
    private final int degree;
    
     /**
     * Post condizioni: Inizializza this affinchè rappresenti il polinomio zero
     */
    public Poly(){
        coeff = new int[1];
        degree = 0;
    }

    /**
     * Post condizioni:  Inizializza this affinchè rappresenti il monomio \(c*x^n)\
     *                   solleva un'eccezione di tipo NegativeExponentException se n è negativo
     */
    public Poly(int c, int n){
        if(n < 0) throw new NegativeExponentException("il valore di n non può essere negativo");
        if(c == 0) degree = 0;
        else degree = n;
        coeff = new int[n+1];
        coeff[degree] = c;
        assert repOk();
    }

    /**
     * (non devo fare  modifica this: this_post = this + q perchè restituiamo un NUOVO polinomio) 
     * (NON sono metodi mutazionali, sono scelte di design)
     * Effetti collaterali: 
     * Post condizioni: restituisce un nuovo polinomio dato da this+q
     *                  solleviamo un'eccezione di tipi NullPointerException se q è null
     */
    public Poly add(Poly q){
        if(q == null) throw new NullPointerException("q non può essere null");
        int max = Integer.max(this.degree, q.degree);
        int value = 0;
        if(this.degree == q.degree){
            value = this.coeff[max] + q.coeff[max];
        }else{
            if(max == this.degree){
                value = this.coeff[max];
            }else{
                value = q.coeff[max];
            }
        }

        Poly p = new Poly(value,max);
        for(int i = 0; i < max;i++){
                p.coeff[i] = this.coeff[i] + q.coeff[i];
        }
        
        assert repOk();
        return p;
    }
    /**
     * (non devo fare  modifica this: this_post = this - q perchè restituiamo un NUOVO polinomio) 
     * (NON sono metodi mutazionali)
     * Effetti collaterali: 
     * Post condizioni: restituisce il polinomio this - q
     *                  solleviamo un'eccezione di tipi NullPointerException se q è null
     */
    public Poly sub(Poly q){
        if(q == null) throw new NullPointerException("q non può essere null");
        int max = Integer.max(this.degree, q.degree);
        int value = 0;
        if(this.degree == q.degree){
            value =  this.coeff[max] - q.coeff[max];
        }else{
            if(max == this.degree){
                value = this.coeff[max];
            }else{
                value = q.coeff[max];
            }
        }

        Poly p = new Poly(value,max);
        for(int i = 0; i < max;i++){
                p.coeff[i] = this.coeff[i] - q.coeff[i];
        }
        
        assert repOk();
        return p;
    }

    /**
     * (non devo fare  modifica this: this_post = this * q perchè restituiamo un NUOVO polinomio) 
     * (NON sono metodi mutazionali)
     * Effetti collaterali: 
     * Post condizioni: restituisce il polinomio this * q
     *                  solleviamo un'eccezione di tipi NullPointerException se q è null
     */
    public Poly mult(Poly q){
        if(q == null) throw new NullPointerException("q non può essere null");
        //this.coeff[this.degree] * q.coeff[q.degree]
        Poly p = new Poly(this.coeff[this.degree] * q.coeff[q.degree],this.degree+q.degree );
        
        for(int i = 0; i <= this.degree;i++){
            for(int j = 0; j <= q.degree;j++){
                if(i == this.degree && j == q.degree){return p;}
                if(i != 0 && j != 0){
                    //System.out.println(String.format("c = %d x = %d",this.coeff[i],i));
                    //System.out.println(String.format("c = %d x = %d",q.coeff[j],j));
                    p.coeff[i+j] += this.coeff[i] * q.coeff[j];
                    //System.out.println(p.coeff[i*j]);
                }else{
                    p.coeff[Integer.max(i, j)] += this.coeff[i] * q.coeff[j];
                }  
            }
        }
        assert repOk();
        return p;
    }

    /**
     * (non devo fare  modifica this: this_post = -this perchè restituiamo un NUOVO polinomio) 
     * (NON sono metodi mutazionali)
     * Effetti collaterali: 
     * Post condizioni: restituisce il polinomio -this
     */
    public Poly minus(){
        Poly p = new Poly(-this.coeff[this.degree],this.degree);
        for(int i = 0; i < this.degree;i++){
            p.coeff[i] = -this.coeff[i];
        }
        return p;
    }

    /**
     * Post condizione: restituisce il grado del polinomio this
     */
    public int degree(){
        int degree = this.degree;
        return degree;
    }

    /**
     * Post condizione: restituisce il termine corrispondente alla variabile con grado d
     */
    public int coeff(int d){
        int coeffD = this.coeff(d);
        return coeffD;
    }
    /**
     * Funzione di astrazione: AF(coeff, degree) = 
     *                         = {coeff[i]x^i | 0 <= i <= degree}
     *                         = 
     *                         = 
     * 
     * Invariante di rappresentazione: coeff non deve essere null
     *                                 i valori dei gradienti sono positivi
     *                                 this.coeff[degree] == 0 -> degree == 0
     *                                 
     */

    @Override
    public String toString(){
        String s = new String();
        for(int i = 0; i < this.degree;i++){
            if(this.coeff[i+1] >= 0) s+= "+";
            s += String.format("%dx^%d ",this.coeff[i],i);
        }
        s += String.format("%dx^%d",this.coeff[this.degree],this.degree); 
        return s;
    }

    private boolean repOk(){
        return  coeff != null 
                && degree >= 0
                && (!(coeff[degree] == 0) || degree == 0);
    }

    public static void main(String[] args) {
        Poly p = new Poly(2,5);
        p.coeff[0] = 1;
        Poly q = new Poly(-3,3);
       // q.coeff[0] = 1;
        q.coeff[1] = 2;
        Poly d = p.mult(q);
        //Poly b = d.minus();
        System.out.println(d.toString());
    }

}
