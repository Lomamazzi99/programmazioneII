import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Dispensa {
    private ArrayList<prodotto> elenco;
    private ArrayList<Integer> presente;
    private ArrayList<Integer> scorta;

    public Dispensa(){
        elenco = new ArrayList<>();
        presente = new ArrayList<>();
        scorta = new ArrayList<>();
    }

    public void scortaMinima(prodotto p,int q){
        //stabilisce che il prodotto p ha quantità minima = q
        scorta.add(q);
    }

    public int qta(prodotto p){
        for(int i = 0; i < elenco.size();i++){
        if (this.elenco.get(i) == p){
            return presente.get(i);
        }
       }
       return 0;
    }


    public void consuma(prodotto p, int q){
        int i;
        if (qta(p) < q){
            throw new NoSuchElementException("consuma\n");
        }else{
            for(i = 0; i < elenco.size();i++){
                if (this.elenco.get(i).equals(p)){
                    //unico modo per sostituire un valore con un altro in una lista
                    this.presente.set(i, q);
                    return;
                }
               }
            }
        }

        /**
         * 
         * @return una lista della spesa
         * tale lista contiene tutti i prodotti la cui quantità in dispensa è minore
         * della quantità minima prevista.
         * La quantità da acquistare è la differenza fra la quantità minima prevista
         * e quella attualemente presente in dispensa
         */

        public ListaDellaSpesa preparaLista(){
            ListaDellaSpesa l = new ListaDellaSpesa();
            //quantità in dispensa è minore della quantità minima prevista.
            for(int i = 0; i < elenco.size();i++){
                if (this.qta(elenco.get(i)) < this.scorta.get(i) ){
                    l.aggiungi((elenco.get(i)),this.scorta.get(i) - qta(elenco.get(i)));
                }
            }
            return l;
        }

        public void riponi(ListaDellaSpesa s){
            for(int i = 0; i < elenco.size();i++){
                if(this.elenco.get(i).equals(s.lista.get(i))){
                    if (this.presente.get(i) == 0){
                        this.presente.add(s.num.get(i));
                    }else{
                        this.presente.set(i, this.presente.get(i) + s.num.get(i));
                    }
                }
            }
        }

        public String toString(){
            String t,s ="";
            t ="";
            if (elenco.size() == 0){
                s = "{}";
            }

            for(int i = 0;i < elenco.size();i++){
                s = this.elenco.get(i) + " presente:" + String.valueOf(this.presente.get(i));
                s += " scorta: " + String.valueOf(this.scorta.get(i)) + "\n";
                t +=s;
            }
            return t;
        }

        public static void main(String[] args) {
            Dispensa s = new Dispensa();
            prodotto p1 = new prodotto("pasta");
            prodotto p2 = new prodotto("pane");
            prodotto p3 = new prodotto("carne");
            s.elenco.add(0, p1);
            s.elenco.add(1, p2);
            s.elenco.add(2, p3);
            s.presente.add(3);
            s.presente.add(2);
            s.presente.add(1);
            s.scorta.add(3);
            s.scorta.add(8);
            s.scorta.add(3);
            ListaDellaSpesa l = new ListaDellaSpesa();
            l.aggiungi(p1, 4);
            l.aggiungi(p2, 1);
            ListaDellaSpesa ll = new ListaDellaSpesa();
            ll = s.preparaLista();
            System.out.print(ll.toString());
        }
    }