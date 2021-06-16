
import java.util.Arrays;
import java.util.Scanner;

/*
Abbiamo eccezioni non controllate e controllate.
Il compilatore controlla che all'interno del codice vi sia la gestione di tali eccezioni.
Nel caso delle eccezioni controllate il compilatore non permette di compilare nel caso in cui
i vincoli dell'implementazioni non vengano rispettate.
Il compilatore richiede al programmatore di catturare l'eccezione (catch) e nel caso in cui la trovi
possiamo rilanciare l'eccezione a livello più alto. Per non far arrabbiare il compilatore devo
dichiarare l'eccezione nella segnatura del metodo e usiamo poi la throws.
Nel caso di eccezioni non controllate throws è omissibile.
In generale è meglio non dichiararle perchè risulterebbe un lavoro pericoloso e appesantiamo la 
leggibilità del codice.
L'importante è che ci sia nelle specificazioni sia per quelle controllate che quelle non.
Nelle specificazioni definiamo anche la causa dell'errore.

È meglio usare e dichiarare eccezioni *non controllate* quando abbiamo violazione delle precondizioni
e anomalie interne al programma risolvibili con una maggiore
attenzione da parte del programmatore (errori di programmazione quindi).
PRO -> è possibile distinguerle dalla normale esecuzione del codice, defensive programming 
(maggiore robustezza del codice),
CONTRO (abusi)-> modificare il flusso d'esecuzione, 

È meglio usare e dichiarare eccezioni *controllate* quando dobbiamo gestire qualcosa che è esterno 
al programma e da anomalie/malfunzionamenti dalle quali ci si può riprendere.
PRO ->  è possibile distinguerle dalla normale esecuzione del codice, defensive programming
(maggiore robustezza del codice), reminder per il programmatore, aumentano leggibilità del codice. 
CONTRO (abusi)-> modificare il flusso d'esecuzione,rende difficile l'utilizzo 
*/

/*costante di kaprekar
dato un numero di *quattro* cifre -> ordiniamo le cifre in ordine decrescente e sottriamo a questo 
le cifre in ordine crescente e qualsiasi sia l'input otteniamo sempre 6174
*/

public class SecondaEs {
    
    //meglio fare due funzioni di ordinamento invece che una

    /*
     * Effetti collaterali: potrebbe modificare l'ordine degli elementi di a
     * Post condizioni: inverte l'ordine degli elementi di a
     */
    public static void reverse(int[] a){
        if(a == null) throw new NullPointerException("a non deve essere null");
        for(int i = 0;i < a.length/2;i++){
            int x = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = x;
        }
    }


    /**
     *(elimino "a non deve essere riferimento a null" e "e i suoi elementi sono cifre decimali" perchè sollevo eccezione)
     * Post condizioni: converte il numero memorizzato (in cifre) in a in un intero;
     *                  solleva un'eccezione di tipo NullPointerException se a è null;
     *                  solleva un'eccezione di tipo IllegalArgumentException se un elemento di a non è decimale;
     */
    public static int digitsToNum(int[] a){
        if(a == null) throw new NullPointerException("a non può essere null");
        int n = 0;
        for(int i = 0 ; i < a.length;i++){
            if(a[i] < 0 || a[i] > 9) throw new IllegalArgumentException(
                "valori attesi per argomento compresi tra 0 e 9.\nTrovato: "+ a[i]);
            n = n*10 + a[i];
        }
        return n;
    }

    /**
     * Post condizioni: restituisce un array (di cifre) che rappresenta l'intero n
     */
    public static int[] numToDigits(int n, int digits){
        int[] a = new int[digits];
        for(int i = digits -1;i >= 0;i--, n /= 10){
            a[i] = n % 10;
        }
        
        return a;
    }


    /**
     * (elimino "n deve avere almeno due cifre differenti" 
     * e 
     * "l'intero n deve essere di quattro cifre" perchè sollevo eccezione)
     * Effetti collaterali: Modifica su System.out
     * Post condizioni: stampa la sequenza di Kaprekar
     */
    public static void printKaprekar(int n){
        int[] digits = numToDigits(n, 4);
        if(digitsToNum(digits) != n) throw new IllegalArgumentException(
            "n formato da più di 4 cifre decimali");

        int counter = 0;
        for(int i = 0; i < digits.length;i++){
            if (digits[0] == digits[i]){
                counter++;
            }
            if(counter > 3) throw new IllegalArgumentException("il numero n non contiene almeno due cifre differenti");
        }
        System.out.println(n);
        while(n != 6174){
            n = stepKaprekar(n);
            System.out.println(n);
        }
    }


    /**
     *(elimino "n deve avere almeno due cifre differenti" 
     * e 
     * "l'intero n deve essere di quattro cifre" perchè sollevo eccezione)
     * Post condizioni: esegue un passo della "sequenza di Kaprekar"
     */

    public static int stepKaprekar(int n){
        int[] digits = numToDigits(n, 4);
        if(digitsToNum(digits) != n) throw new IllegalArgumentException(
            "n formato da più di 4 cifre decimali");

        int counter = 0;
        for(int i = 0; i < digits.length;i++){
            if (digits[0] == digits[i]){
                counter++;
            }
            if(counter > 3) throw new IllegalArgumentException("il numero n non contiene almeno due cifre differenti");
        }
        
        Arrays.sort(digits);
        n = -digitsToNum(digits);
        reverse(digits);

        return n + digitsToNum(digits);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //digitsToNum(new int[]{0,1,11});
        //stepKaprekar(scan.nextInt());
        printKaprekar(scan.nextInt());
        scan.close();
    }
}
