import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * SEMPLICE 10:15 45 Cartoni animati 
 * RADIOGIORNALE 10 Giornale radio 
 * PERIODICA 13:30 40 2 1120 Ricette del giorno 
 * SEMPLICE 28:45 120 Film della sera
 */

/**
 * Dato l'input precedente, un esempio di output è
 * 
 * 09:40 - Giornale radio 10:15 - Cartoni animati 11:40 - Giornale radio 13:30 -
 * Ricette del giorno 19:40 - Giornale radio 21:40 - Giornale radio 22:40 -
 * Giornale radio 25:40 - Giornale radio 27:30 - Ricette del giorno 28:45 - Film
 * della sera che elenca, in ordine temporale, per ciascuna fascia betaoraria
 * legata a una dalle quattro trasmissioni in input, il betaotrario del suo
 * inizio e il titolo della relativa trasmissione.
 */

/**
 * Overview:
 * Le istanze di questa classe rappresentano un interprete per le azioni effettuate dal client
 */
public class Interprete {

    /**La struttura dati che forma il palinsesto */
    private Palinsesto palinsesto;

    /**
     * Post condizioni: inizializza this affinchè rappresenti un palinsesto vuoto
     */
    public Interprete() {
        palinsesto = new Palinsesto();
    }

    /**
     * Funzione d'astrazione: AF(palinsesto) = palinsesto
     * Invariante di rappresentazione: il palinsesto non è null
     *                                 
     */

    /**
     * Effetti collaterali: potrebbe modificare this
     * Post condizioni: aggiunge una trasmissione al palinsesto
     *                  solleva un'eccezione nel caso in cui l'input dato dall'utente sia null
     */
    public void addTrasmissione(String s) {
        Objects.nonNull(s);
        Trasmissione t = getTrasmissione(s);
        //System.out.println(t == null);
        
        palinsesto.insertTrasmissione(t);
        
    }

    /**
     * Post condizioni: preso l'input dell'utente lo decifra restituendo una trasmissione dato quello passato dall'utente
     *                  solleva un'eccezione nel caso in cui l'input dell'utente non abbia il numero necessario di valori per definire una trasmissione
     */
    private Trasmissione getTrasmissione(String s) {
        String[] as = s.split(" ");
        if (as.length <= 1)
            throw new IllegalArgumentException("L'input non è del formato corretto");
        switch (as[0]) {
            case "SEMPLICE":
                //preso l'orario passato dall'utente lo suddivide in ore e minuti
                String[] asb = as[1].split(":");
                int betaore = Integer.parseInt(asb[0]);
                int betaminuti = Integer.parseInt(asb[1]);
                //crea il betaorario definito
                Betaorario betaorarioInizio = new Betaorario(betaore, betaminuti);
                //crea una fascia orario secondo l'orario dato e la durata indicata
                FasciaBetaoraria fb = new FasciaBetaoraria(betaorarioInizio, Integer.parseInt(as[2]));
                //la lista delle fasce
                List<FasciaBetaoraria> listFb = new ArrayList<>();
                //aggiunge la fascia alla lista
                listFb.add(fb);
                //crea la trasmissione
                Trasmissione t = new TrasmissioneSemplice(as[3], listFb);
                
                return t;
            case "PERIODICA":
                String[] asbP = as[1].split(":");
                int betaoreP = Integer.parseInt(asbP[0]);
                int betaminutiP = Integer.parseInt(asbP[1]);
                Betaorario betaorarioInizioP = new Betaorario(betaoreP, betaminutiP);
                FasciaBetaoraria fbP = new FasciaBetaoraria(betaorarioInizioP, Integer.parseInt(as[2]));
                List<FasciaBetaoraria> listFbP = new ArrayList<>();
                listFbP.add(fbP);
                Trasmissione tP = new TrasmissionePeriodica(as[5], listFbP, Integer.parseInt(as[3]),
                        Integer.parseInt(as[4]));
                
                return tP;
            /*case "RADIOGIORNALE":
                String[] asbRG = as[1].split(":");
                int betaoreRG = Integer.parseInt(asbRG[0]);
                int betaminutiRG = Integer.parseInt(asbRG[1]);
                Betaorario betaorarioInizioRG = new Betaorario(betaoreRG, betaminutiRG);
                FasciaBetaoraria fbRG = new FasciaBetaoraria(betaorarioInizioRG, Integer.parseInt(as[2]));
                List<FasciaBetaoraria> listFbRG = new ArrayList<>();
                listFbRG.add(fbRG);
                Trasmissione tRG = new RadioGiornale(as[3], listFbRG, Integer.parseInt(as[2]));
                return tRG;*/
            default:
                break;
        }
        return null;
    }

    public boolean isEmpty(){
        return palinsesto.isEmpty();
    }

    @Override
    public String toString() {
        //Collections.sort(palinsesto);
        return palinsesto.toString();
    }
/**
 * SEMPLICE 10:15 45 Cartoni animati
RADIOGIORNALE 10 Giornale radio
PERIODICA 13:30 40 2 1120 Ricette del giorno
SEMPLICE 28:45 120 Film della sera
 */
    public static void main(String[] args) {
        Interprete i = new Interprete();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            i.addTrasmissione(line);
            //System.out.println(i.isEmpty());
        }
        System.out.println(i.toString());
        scan.close();
    }
}
