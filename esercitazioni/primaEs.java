
/*
clausole specificazione
pre requisiti (requires): richieste sotto le quali garantiamo che la funzione abbia un comportamento corretto
post condizioni (effects): descrive gli effetti della procedura date degli input corretti
effetti collaterali (modifies): modifiche sull riferimento all'oggetto (ogni volta che modifichiamo un oggetto anche di sistema (System.out))

proprietà procedure e implementazioni
minimalità: una specifica è più minimalista rispetto ad un altra se utilizza un minor numero di
vincoli rispetto all'altra avendo comunque un comportamento accettabile
->pro: libertà d'implementazione
->contro: una procedura potrebbe essere sottospecificata ottenendo quindi degli effetti indesiderati

implementazione deterministica: l'implementazione di una procedura è deterministica se per gli stessi
input produce sempre lo stesso risultato. Definita anche come:
->procedura totale: il comportamento è specificato per tutti gli input ammissimili.
Il contrario è una procedura parziale che può possedere una maggiore efficienza soprattutto in
contesti di privatezza (solo noi utilizziamo quella funzione) ed è anche più semplice.
Talvolta il controllo dell'input potrebbe richiedere più tempo e risorse dell'esecuzione stessa.
generalità: una procedura è più generale di un'altra perchè può essere utilizzata su un insieme
di input più grande rispetto all'altra
comportamento indeterminato: una procedura è indeterminata se per un certo input le sue specifiche
permettono più di una soluzione accettabile 
semplicità: il comportamento deve essere preciso e ben specificato

Array di tipi primitivi-> passo il riferimento
Tipi primitivi -> passo il valore
*/

import java.util.Scanner;

public class primaEs{
    //dato un numero a base 10 prendere il numero e sommargli il risultato ottenuto
    //scrivendo le sue cifre dall'ultima alla prima
    //i numeri possono essere presi come una variabile di tipo long e avere al massimo 9 cifre dec.
    

    /**
     * Pre requisiti: s non sia un riferimento null
     * Post condizioni: restituisce una stringa reverse di s
     */
    public static String reverse(String s){
        String z = new String();
        for(int i = s.length()-1;i >= 0; i--){
            z += s.toCharArray()[i];
        }
        return z;
    }

     /**
     * Pre requisiti:  s non sia un riferimento null
     *                 s deve rappresentare un numero
     * 
     * post condizioni: restituisce una rappresentazione di s tramite long
     */
    public static long convertToLong(String s){
        return Long.parseLong(s);
    }


    /**
     * Pre requisiti: l deve essere un numero di al massimo 9 cifre decimali
     * Post condizioni: restituisce una string che rappresenta l
     */
    public static String convertToString(long l){
        return String.format("%s", l);
    }

    /**
     * Pre requisiti: s non sia un riferimento null 
     * Post condizioni: restituisce true se la stringa s è palindroma, false altrimenti 
     */
    public static boolean isPalindrome(String s){
        for(int i = 0;i < s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
        
    }

    /**
     * Pre requisiti: l deve essere un numero di al massimo 9 cifre decimali
     * Effetti collaterali: Modifica su System.out
     * Post condizioni: stampa l sia nel caso in cui sia un numero di L
     */
    public static void isL(long l){
        while (!isPalindrome(convertToString(l))) {
            String s = reverse(convertToString(l));
            l = l + convertToLong(s);
        }
        System.out.println(l);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long l = scan.nextLong();
        isL(l);
        scan.close();
    }
}