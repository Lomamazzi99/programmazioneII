import java.util.ArrayList;
import java.util.Collections;

/**
 * Un vagone.
 * 
 * Questa classe ha il compito di implementare un Vagone come sottoclasse concreta di un rotabile.
 * Un vagone oltre ad avere un nome ed un peso possiede anche un insieme immutabile di dotazioni 
 * (che può essere vuoto) già definite.
 * Nel caso in cui all'interno di un vagone vi siano più dotazioni dello stesso tipo, il vagone 
 * conterrà tali dotazioni come un'unica variabile la cui quantità totale sarà data dalla somme delle 
 * quantità delle dotazioni.
 */
public class Vagone extends Rotabile {

    /**
     * Poichè l'insieme finale di un vagone è immutabile è lecito che tale variabile d'instanza sia
     * pubblica.
     */
    public final ArrayList<Dotazione> insieme;

    public Vagone(String modello, int peso) {
        super(modello, peso);
        this.insieme = new ArrayList<>();
    }

    /**
     * Questo metodo prende come input 
     * @param modelli come un insieme di stringhe non vuote che rappresenta i modelli da inserire
     * trovati all'interno dell'insieme di stringhe spl.
     * @param spl anch'esso insieme di stringhe non vuote
     * 
     * Tale metodo ha il compito di inserire le dotazioni trovate all'interno dell'insieme che 
     * deve contenerle, e nel caso in cui una dotazione si ripeta ne aggiorna la quantità finale.
     */
    private void addDotazioni(final ArrayList<String> modelli, final String[] spl) {
        for (int i = 0; i < modelli.size(); i++) {
            int count = 0;
            for (int j = 3; j < spl.length; j++) {
                if (modelli.get(i).equals(spl[j]))
                    count += Integer.parseInt(spl[j + 1]);
            }
            Dotazione d = new Dotazione(modelli.get(i), count);
            insieme.add(d);
        }
    }


    /**
     * Prendendo come input la stringa  @param s (sollevando un'eccezione nel caso in cui
     * sia null), questo metodo ha il compito di identificare le diverse dotazioni presenti
     * all'interno della stringa passata in input.
     * Se non vi sono dotazioni all'interno della stringa il vagone è vuoto.
     * Dopo aver fatto ciò richiama il metodo addDotazioni definito sopra.
     */
    public void getDotazioni(String s) {
        if(s == null) throw new NullPointerException("la stringa non può essere null");
        String[] spl = s.split(" ");
        if (spl[3] == null)
            return;

        ArrayList<String> modelli = new ArrayList<>();
        for (int i = 3; i < spl.length; i++) {
            try {
                @SuppressWarnings("all")
                int indesiderato;
                indesiderato = Integer.parseInt(spl[i]);
            } catch (NumberFormatException e) {
                if (!modelli.contains(spl[i])) {
                    modelli.add(spl[i]);
                }
            }
        }

        addDotazioni(modelli, spl);
    }

    /**
     * Rappresento un vagone come un oggetto formato dal nome, il peso specifico e un insieme di
     * dotazioni (ordinato secondo l'ordine lessicografico delle singole dotazioni)
     */
    public String toString() { 
        Collections.sort(this.insieme);
        return String.format("%s %d %s", this.modello,this.peso,this.insieme);
    }

    @Override
    public boolean repOk() {
        return true;
    }

    
}