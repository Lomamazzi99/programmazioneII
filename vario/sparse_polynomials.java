import java.util.*;

public class sparse_polynomials{

    public static class Sparsepoly{
        //Overview
        
        Vector<Integer> grado = new Vector<Integer>();
        
        Vector<Integer> coefficiente = new Vector<Integer>();
        
        //Costruttori

        public Sparsepoly(){
        }

        public Sparsepoly(int coeff, int grade) throws IllegalArgumentException {
            if(grade<0)
                throw new IllegalArgumentException("Sparsepoly(int, int) costruttore, grado negativo");
            grado.add(grade);
            coefficiente.add(coeff);
        }

        //Metodi

        /**
         * Questo metodo restituisce il grado massimo di un polinomio
         * @return Il grado maggiore del polinomio
         * @throws NullPointerException se il polinomio passato non ha valori
         */

        public int GetMaxGrado() throws NullPointerException{
            if (this.grado.size()==0){
                throw new NullPointerException("Non posso restituire il grado maggiore di un polinomio vuoto");
            }
            assert PolyOk();
            int maxgrado = grado.get(0);
            for(int i = 0; i < grado.size(); i++){
                if(grado.get(i)>maxgrado && this.coefficiente.get(i)!=0){
                    maxgrado = grado.get(i);
                }
            }
            return maxgrado;
        }

        /**
         * Questo metodo restituisce il grado del polinomio all'indice desiderato
         * @param d un intero che contiene l'indice da considerare
         * @return il grado del polinomio al posto d, in un intero
         * @throws IllegalArgumentException se l'indice è minore di 0 o più grande della dimensione del polinomio
         */

        public int GetGrado(int d) throws IllegalArgumentException{
            if(d<0 || d>this.grado.size()){
                throw new IllegalArgumentException("L'insice inserito non è valido!");
            }
            assert PolyOk();
            return this.grado.get(d);
        }

        /**
         * Questo metodo restituisce il coefficiente del polinomio all'indice desiderato
         * @param d un intero che contine il grado da considerare
         * @return il coefficiente del polinomio al grado d, in un intero
         * @throws IllegalArgumentException se l'indice è minore di 0 o più grande della dimensione del polinomio
         */

        public int GetCoeff(int d) throws IllegalArgumentException{
            if(d<0 || d>this.coefficiente.size()){
                throw new IllegalArgumentException("L'insice inserito non è valido!");
            }
            assert PolyOk();
            return this.coefficiente.get(d);
        }

        /**
         * Il metodo scambia i segni al polinomio, viene utilizzato dal metodo SubPoly per fare la sottrazione attraverso la somma
         * Non è garantito che le posizioni dei gradi e dei coefficienti rimangano uguali a quelle del polinomio che utilizza questo metodo
         * @return un polinomio con stessi gradi e coefficienti di quello che invoca il metodo, con i segni scambiati
         */

        private Sparsepoly Minus(){
            Sparsepoly res = new Sparsepoly();
            for(int i = 0 ; i < this.coefficiente.size(); i++ ){
                res.coefficiente.add(-this.coefficiente.get(i));
            }
            for(int i = 0 ; i < this.grado.size(); i++ ){
                res.grado.add(this.grado.get(i));
            }
            return res;
        }

        /**
         * Il metodo sottrae due polinomii e restituisce un polinomio che è frutto di questa operazione
         * @param p un polinomio, non vuoto
         * @return un polinomio che è il risultato di <code>this</code> - <code>p</code>
         * @throws NullPointerException se il polinomio p è vuoto
         */

        public Sparsepoly SubPoly(Sparsepoly p) throws NullPointerException{
            if(p.grado.size()==0 || p.coefficiente.size()==0){
                throw new NullPointerException("Il vettore passato in argomento è vuoto, non posso fare la differenza");
            }
            Sparsepoly polyneg = new Sparsepoly();
            polyneg = p.Minus();
            return this.AddPoly(polyneg);
        }

        /**
         * Il metodo somma due polinomi e restituisce un polinomio che è frutto di questa operazione
         * @param p un polinomio, non vuoto
         * @return un polinomio che è il risultato della somma di <code>this</code> + <code>p</code>
         * @throws NullPointerException se il polinomio p è vuoto
         */

        public Sparsepoly AddPoly(Sparsepoly p) throws NullPointerException{
           	 if(p.grado.size()==0 || p.coefficiente.size()==0){
                throw new NullPointerException("Il vettore passato in argomento è vuoto, non posso sommarlo");
            }
            int gradoattuale, sommacoeff = 0, count = 0;
            boolean flag = false;
            Sparsepoly result = new Sparsepoly();
            for(int i = 0; i < this.grado.size(); i++ ){
                gradoattuale = this.grado.get(i);
                for(int j = 0; j < p.grado.size(); j++){
                    if(gradoattuale == p.grado.get(j)){
                        count++;
                        sommacoeff += this.coefficiente.get(i) + p.coefficiente.get(j);
                        flag = true;
                    }
                }
                if (flag == true){
                    result.coefficiente.add(sommacoeff);
                    result.grado.add(gradoattuale);
                } else {
                    result.grado.add(gradoattuale);
                    result.coefficiente.add(this.coefficiente.get(i));
                }
                flag = false;
            }
            if(count != p.grado.size()){
                for(int i = 0; i < p.grado.size(); i++ ){
                    result.grado.add(p.grado.get(i));
                    result.coefficiente.add(p.coefficiente.get(i));
                }
            }
            assert result.PolyOk();
            return result;
        }

        /**
         * Il metodo moltiplica due polinomio e restituisce il prodotto in un nuovo polinomio
         * @param p un polinomio non vuoto
         * @return un polinomio che è il prodotto dei due precedenti
         * @throws NullPointerException se il polinomio p è vuoto
         */

        public Sparsepoly Mul(Sparsepoly p) throws NullPointerException{
            if(p.grado.size()==0 || p.coefficiente.size()==0){
                throw new NullPointerException("il vettore passato in argomento è vuoto, non posso fare il prodotto");
            }
            int newgrado, newcoeff;
            Sparsepoly res = new Sparsepoly();
            for(int i = 0; i < this.grado.size(); i++){
                for(int j = 0; j < p.grado.size(); j++){
                    newgrado = this.grado.get(i) + p.grado.get(j);
                    newcoeff = this.coefficiente.get(i) * p.coefficiente.get(j);
                    res.grado.add(newgrado);
                    res.coefficiente.add(newcoeff);
                }
            }
            assert res.PolyOk();
            return res;
        }

        /**
         * Il metodo controlla tutto il polinomio e restituisce lo stesso polinomio senza coefficienti uguali a zero
         * @return il polinomio che ha utilizzato il metodo, senza zeri
         */

        public Sparsepoly ClearZero(){
            Sparsepoly res = new Sparsepoly();
            for(int i = 0; i < this.coefficiente.size(); i++ ){
                if(this.coefficiente.get(i)!=0){
                    res.coefficiente.add(this.coefficiente.get(i));
                    res.grado.add(this.grado.get(i));
                }
            }
            return res;
        }

        /**
         * Il metodo visualizza il polinomio che lo utilizza
         */

        public void Stampapolinomio(){
            for(int i=0; i<grado.size(); i++){
                System.out.printf("%d*x^%d ",coefficiente.get(i) ,grado.get(i));
                if(i+1 != grado.size())
                    System.out.printf("+ ");
            }
            System.out.println("\n");
        }

        /**
         * Il metodo è un'implementazine per le assertion
         * @return true se tutti ibradi sono >0, false se esiste un grado che è minore di 0
         */

        public boolean PolyOk(){
            for(int i=0; i < grado.size() ; i++){
                System.out.println(grado.get(i));
                if(grado.get(i)<0){
                    return false;
                }
            }
            return true;
        }

        

    } 

    public static void main(final String[] args) {
        int maxgrado;
        Sparsepoly mypoly = new Sparsepoly(3, 5);
        Sparsepoly mypoly2 = new Sparsepoly(5,3);
        Sparsepoly mypoly3 = new Sparsepoly(5, 6);
        Sparsepoly res = new Sparsepoly();
        res = mypoly.AddPoly(mypoly);
        res = res.AddPoly(mypoly2);
        res.Stampapolinomio();
        /*res = res.Mul(mypoly2);
        res.Stampapolinomio();
        maxgrado = res.GetMaxGrado();
        System.out.println(maxgrado);
        maxgrado = res.GetCoeff(1);
        System.out.println(maxgrado);
        maxgrado = res.GetGrado(1);
        System.out.println(maxgrado);
        res = res.Minus();
        res.Stampapolinomio();
        res = res.SubPoly(mypoly3);
        res.Stampapolinomio();
        res = res.ClearZero();
        res.Stampapolinomio();*/
        
    }
}












/*
//inutile
public void Stampagrado(){
    System.out.println(grado.elementAt(0));
}
//metodo di visualizzazione inutile, però è caruccio <3
public void Stampapolinomio(){
    for(int i=0; i<grado.size(); i++){
        System.out.printf("%d*x^%d \n",coefficiente.get(i) ,grado.get(i));
    }
}

public void CheckWrongGrade(){
    for(int i=0; i < grado.size() ; i++){
        if(grado.get(i)<0){
            System.out.println("errore, è presente nel vettore un elemento minore di 0");
        }
    }
}
*/
