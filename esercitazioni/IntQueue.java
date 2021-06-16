/**
 * Esercitazione 4
 * Implementare e prgettare una gerarchia di interi utili a rappresentare code di interi.
 * Le code sono strutture dati che consentono la memorizzazione e l'accesso alle informazioni in 
 * modalità FIFO.
 * In questo caso di dovrà procedere con la creazione di una classe concreta che deve avere costruttore
 * con un solo parametro n che consentià di creare una coda vuota con una capienza massima pari a 
 * n numeri interi.
 * 
 * 
 * Una volta che un oggetto di questo tipo esiste,dovrà essere fornita la possibilità di inserire
 * (enqueue) e rimuovere (dequeue) elementi di una coda.
 * 
 * Inoltre dovrà essere sovrascritto il metodo toString() in modo che restituisca una stringa
 * idonea a rappresentare lo stato della coda (quindi che implmenti la funzione di astrazione)
 * e il metodo repOk che dorvà fornire un'appropriata implementazione dell'invariante di rapp.
 * 
 * Fornire poi una classe di test che legga dal fliusso d'ingresso i seguenti dati:
 * un  numero n seguito da una sequenza non limitata di -1 e +1
 * 
 * Dopo aver istanziato una coda di dimensione n dovranno essere esguite le seguenti operazioni
 * fino alla chiusura del flusso di ingresso o fino al raggiungimento di uno stato valido:
 * 
 * Ogni volta che sarà letto un +1 bisognerà eseguire enqueue(NumEnqueue) dove  NumEnqueue sarà il 
 * numero di +1 letti fino al momento dell'invocazione
 * 
 * Ogni volta che sarà letto un -1 bisognerà eseguire dequeue e stampare il numero estratto dalla coda
 * 
 * Dopo la chiusura del flusso d'ingresso qualora il numero di -1 ecceda quello di +1 oppure
 * se si tenta di inserire più elementi della capienza massima della coda,
 * dovrà essere stampato il contenutp della coda, utilizzando il metodo toString seguito
 * dal numero degli elemtni presenti nella coda
 * 
 */

 /**
  * OVERVIEW:   Le istanze di questa classe rappresentano code di interi di capienza limitata.
  *             Gli oggetti di questa classe sono mutabili.
  *             Una coda tipica è [x1,x2,..., xk] dove k <= alla dimensione massima della coda.
  *             Dato che è una struttura dati FIFO, a seguito di una enqueue dell'elemento y otterrò {x1,x2,..., xk,y }
  *             Mentre a seguito di una dequeue si otterrà [x2,..., xk]
  *             
  */
public class IntQueue {

    /**
     * La struttura dati che contiene gli elementi della IntQueue this.
     */
    final private int[] elements;
    /**Questi sono gli indici della testa e della coda di IntQueue
     * head indica il primo elemento di this (-1 se la coda è vuota)
     * tail indica l'indice della prima posizione disponibile (tail = head implica che la coda è piena)
     */
    private int head,tail;

    /**
     * Funzione di astrazione: AF(elements,testa,coda) 
     *                         =  [elements[i] | head <= i < tail] 
     *                         =  [] se head == -1  e tail = 0
     *                            [elements[head], elements[head + 1],..., elements[elements.size - 1],elements[0],....,elements[tail-1]] se tail < head e se head == tail
     *                            [elements[head], elements[head + 1],...,elements[tail-1]] se head < tail
     *                            
     * Invariante di rappresentazione: (tutti i valori che definiscono una buona coda)
     *                                 la coda non contiene più elementi della sua capienza massima
     *                                 -1 <= head < elements.size - 1
     *                                 0 <= tail < elements.size - 1
     *                                 elements non dev'essere null
     *                                 head == -1 -> tail == 0
     */
    
    /**
     * Pre condizioni: n non deve avere valore negativo
     * Post condizioni: inizializza this affinche rappresenti una coda di interi con capienza massima
     *                  pari a n.
     *                  
     */
    public IntQueue(int n){ 
      elements = new int[n];
      head = -1;
      tail = 0;

      assert repOk();
    }
    /**
     * Effetti collaterali: potrebbe modificare this 
     * Post condizoni: se la coda è piena solleva un'eccezione di tipo FullException,
     *                 altrimenti aggiunge n alla coda
     *                 this = [x1,x2,...,xk] , this_post = [x1,x2,...,xk,n]
     * 
     */
    public void enqueue(int n){
      if(isFull()) throw new FullException("la coda è piena, non è possibile aggiungere un elemento");
      if(isEmpty()) head = 0;
      elements[tail] = n;
      tail = (tail+1) % elements.length;
      assert repOk();
    }

    /**
     * 
     * Post condizioni: restituisce true se la coda è piena, false altrimenti
     */
    public boolean isFull(){
      return head == tail;
    }

    /**
     * 
     * Post condizioni: restituisce true se la coda è vuota, false altrimenti
     */
    public boolean isEmpty(){
      return head == -1;
    }

     /**
     * Effetti collaterali: potrebbe modificare this 
     * Post condizoni: se la coda è vuota solleva un'eccezione di tipo EmptyException,
     *                 altrimenti restituisce l'elemento in testa e lo elimina da this
     *                 this = [x1,x2,...,xk] , this_post = [x2,...,xk,n]
     * 
     */
    public int dequeue(){
      if(isEmpty()) throw new EmptyException("impossibile estrarre elemento dalla coda perchè è vuota");
      int r =  elements[this.head];
      head = (head + 1) % elements.length;
      if(head == tail){ 
        head = -1;
        tail = 0;
      }
      assert repOk();
      return r;
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
          s += elements[(head + i) % elements.length] + ", ";
        }
        s +=  elements[(head + i) % elements.length];
      }
      return s + "]";
    }

    /**
     * Post condizioni: resituisce il numero di elementi presenti nella coda
     */
    public int size(){
      assert repOk();
      if(isEmpty()) return 0;
      if(isFull()) return elements.length;
      return  (tail - head + elements.length) % elements.length;
    }


    /**
     *Post condizoni: implementa l'invariante di rappresentazione
     */
    
    private boolean repOk(){
     return size() < elements.length 
            && elements != null 
            && (-1 <= head && head < elements.length)
            && (0 <= tail && tail < elements.length)
            && (head != 0 || tail == 0);

    }

    public boolean equals(Object o){
      if(!(o instanceof IntQueue)) return false;
      IntQueue iq = (IntQueue) o;

      return iq.head == this.head 
            && iq.tail == this.tail 
            && iq.elements == this.elements;
    }

    public static void main(String[] args) {
      
    }
}
