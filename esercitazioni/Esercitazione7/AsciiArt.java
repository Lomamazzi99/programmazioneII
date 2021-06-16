package Esercitazione7;

/**
 * Scopo dell'esercizio è progettare una gerarchia di oggetti utile a realizzare un semplice
 * interprete per un semplice linguaggio di manipolazione di immagini monocromatiche rappresentate
 * tramite matrici di caratteri.
 * 
 * Un pixel è un elemento di immagine che può trovarsi di volta in volta in uno dei due
 * possibili stati: acceso / spento
 * 
 * Una bitmap di dimensione b*h (con b,h > 0) è una matrice b*h pixel; chiameremo coordinate dei
 * pixel nella riga r e colonnna c di una bitmap la coppia di indici (r,c) (enumerate da 0)
 * 
 * Una figura è data da un insieme di coordiati, alcuni esempi sono:
 * - segmento verticale di dimensione h con coordinate (r,c) dato dall'insieme 
 * {(r,c), (r+1,c) ,..., (r+h-1,c )}
 * 
 * - segmento verticale di dimensione l con coordinate (r,c) dato dall'insieme 
 * {(r,c), (r,c+1) ,..., (r,c + l -1)}
 * 
 * 
 * -il rettangolo di dimensioni l*h con coordinate (r,c) dato dall'unione dei quattro segmenti:
 * due verticali di dimensione h (r,c) e (r,c+l-1) e due orizzontali 
 * di dimensione l (r,c) e (r+h-1,c) e due orizzontali 
 * 
 * -il timbro della matrice (per uniformità con quanto avviene nelle bitmap , gli indici di riga
 * e colonna delle matrici partono da 0) A = (a_ij) con coordinate (r,c) dato dall'insieme 
 * {r+i,c+j | a_ij != 0}
 * 
 * Data una bitmap e una figura, disegnare la figura nella bitmap significa accendere i pixel della
 * bitmap corrispondenti alle coordinate della figura in particolare il disegno del timbro
 * della matrice A con coordinate (r,c) può essere definito informalemente quanto segue: 
 * 
 * per prima cosa si "sovrappone" la matrice A alla bitmap in modo che l'elemento di riga 0
 * e colonna 0 della matrice si trovi "sopra" il pixel di coordinate (r,c) della bitmap
 * , quindi si accendono i pixel della bitmap che si trovano "sotto" gli elementi non nulli 
 * della matrice.
 * 
 * 
 * 
 */

//interprete
//crea una figura da mettere sulla bitmap e invoca il metodo disegna di una figura
//passandogli come argomento la bitmap  

public class AsciiArt {
       
}
