import java.util.LinkedList;
import java.util.List;

/**
 * Esercitazione 5
 * Implementare un coda di interi in cui non ci sia un limite sulla capienza massima.
 * Per ciascuna classe sviluppata dovranno essere scritte le scelte relative alla rappresentazione
 * dello stato (AF e INVR) e ai metodi (PRE, POST, EC)
 * 
 * Creare una classe UnboundedIntQueue che deve avere un costruttore privo di parametri che consente
 * di creare una coda vuota.
 * Una volta che l'oggetto di questo tipo esiste dovrà essere fornita la possibilità -- tramite 
 * l'implementazione di opportuni metodi -- di inserire enqueue e rimuovere elementi dalla coda
 * Inoltre dovrà essere sovrascritto il metodo toString() in modo che restituisca una stringa idonea
 * a rappresentare lo stato della coda (implementi AF) e il metodo repOk dovrà fornire unìappropriata
 * implementazione dell'INVR
 * 
 */

 /**
  * OVERVIEW:   le istanze di questa classe rappresentano una coda di interi unbounded.
                Gli oggetti di questa classe sono modificabili
                Una coda di interi tipica è [x1,x2,...xk].
                Dato che è una struttura dati di tipo FIFO, a seguito di una enqueue dell'elemento y otterrò [x1,x2,..,xk,y] mentre
                a seguito di una dequeue di un elemento otterrò [x2,...xk]
  */
public class UnboundedIntQueue {
    /**la struttura dati che contiene gli elementi della UnboundedIntQueue this */
    private List<Integer> elements;
    
    /**
     * Post condizioni: inizializza this affinchè rappresenti una coda di interi unbounded
     */
    public UnboundedIntQueue(){
        elements = new LinkedList<>();
    }

     /**
     * Effetti collaterali: potrebbe modificare this 
     * Post condizoni: 
     *                 aggiunge n alla coda
     *                 this = [x1,x2,...,xk] , this_post = [x1,x2,...,xk,n]
     * 
     */
    public void enqueue(int n){
        elements.add(n);
        //assert repOk();
      }
  
      /**
       * 
       * Post condizioni: restituisce true se la coda è vuota, false altrimenti
       */
      public boolean isEmpty(){
        return elements.isEmpty();
      }
  
       /**
       * Effetti collaterali: potrebbe modificare this 
       * Post condizoni: se la coda è vuota solleva un'eccezione di tipo EmptyException,
       *                 altrimenti restituisce l'elemento in testa e lo elimina da this
       *                 this = [x1,x2,...,xk] , this_post = [x2,...,xk,n]
       * 
       */
      public int dequeue(){
        //assert repOk();
        if(isEmpty()) throw new EmptyException("impossibile estrarre elemento dalla coda perchè è vuota");
        
        return elements.remove(0);
      }
  
      /**
       * Post condizoni: implementa la funzione d'astrazione
       */
      @Override
      public String toString(){
        String s = "IntQueue : [";
        if(isEmpty()) s += "]";
        else{
          int i;
          for( i = 0; i < size()-1;i++){
            s += elements.get(i) + ", ";
          }
          s += elements.get(i);
        }
        return s + "]";
      }
  
      /**
       * Post condizioni: resituisce il numero di elementi presenti nella coda
       */
      public int size(){
        //assert repOk();
        
        return elements.size();
      }
  
  
      /**
       *Post condizoni: implementa l'invariante di rappresentazione
       
      
      private boolean repOk(){
       
      }

      @Override
      public boolean equals(Object o){

      }
  
      public static void main(String[] args) {
        
      }*/
}
