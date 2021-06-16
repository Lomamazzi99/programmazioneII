import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * Overview: 
 * Le istanze di questa classe rappresentano un convoglio il quale è formato da un insieme non vuoto
 * di rotabili e da un nome.
 * Il primo di questi rotabili è detto testa.
 * L'ultimo di questi rotabili (nel caso in cui sia diverso da quello in testa) è detto coda
 * Gli oggetti di questa classe sono mutabili.
 */
public class Convoglio {
    /**Il nome del convoglio */
    private final String nome;
    /**La struttura dati contente i rotabili */
    private List<Rotabile> rotabili;
    /**La testa del convoglio */
    private Rotabile testa;
    /**La coda del convoglio */
    private Rotabile coda;
    /**Il peso del convoglio */
    private int peso;
    /**la potenza del convoglio */
    private int potenza;

    public Convoglio(final String nome,List<Rotabile> rotabili ){
        Objects.nonNull(nome);
        Objects.nonNull(rotabili);
        if(rotabili.size() == 0) throw new IllegalArgumentException();
        for(Rotabile r : rotabili){
            Objects.nonNull(r);
        }

        this.rotabili = new ArrayList<>(rotabili);
        this.nome = nome;
        setTesta();
        setCoda();
        setPeso();
        setPotenza();
    }

    /**
     * Effetti collaterali: potrebbe modificare la testa di this
     * Post condizioni: definisce il primo rotabile dell'insieme come la testa del convoglio
     * 
     */
    private void setTesta(){
        this.testa =  this.rotabili.get(0);
    }

    /**
     * Effetti collaterali: potrebbe modificare la coda di this
     * Post condizioni: definisce la coda come il primo rotabile dell'insieme nel caso in cui sia uguale all'ultimo,
     *                  altrimenti lo definisce come questo
     */
    private void setCoda(){
        if(this.rotabili.get(0).equals(testa)) this.coda =  testa;
        else this.coda =  this.rotabili.get(this.rotabili.size()-1);
    }

    /**
     * Effetti collaterali: potrebbe modificare il peso di this
     * Post condizioni: definisce il peso del convoglio come la somma di tutti i suoi rotabili
     */
    private void setPeso(){
        int pesoTot = 0;
        for(Rotabile r : rotabili){
            pesoTot += r.getPeso();
        }
        this.peso = pesoTot;
    }

    private void setPotenza(){
        if(!(testa instanceof Locomotore)) this.potenza=0;

        Locomotore ltesta = (Locomotore) testa;
        int potenza = ltesta.getPotenza();
        if(!(coda instanceof Locomotore)) this.potenza= potenza;

        Locomotore lcoda = (Locomotore) coda;
        potenza += lcoda.getPotenza() / 2;
        this.potenza= potenza;

    }
/*
    public String getNome() {
        return nome;
    }

    public List<Rotabile> getRotabili() {
        return rotabili;
    }

    public Rotabile getCoda() {
        return coda;
    }

    public Rotabile getTesta() {
        return testa;
    }

    public int getPeso() {
        return peso;
    }

    public int getPotenza() {
        return potenza;
    }
*/
    public boolean isIn(Dotazione d){
        Objects.nonNull(d);
        for(Rotabile r : rotabili){
            if(r instanceof Vagone){
                Vagone v = (Vagone) r;
                if(v.contains(d)) return true;
            }
        }
        return false;
    }

    public List<Dotazione> getDotazioni(){
        
        List<Dotazione> listDotazioni = new ArrayList<>();
        for(Rotabile r : rotabili){
            if(r instanceof Vagone){
                Vagone v = (Vagone) r;
                for(Dotazione d : v){
                    if(v.contains(d))
                        listDotazioni.add(d);
                }
            }
        }
        Collections.sort(listDotazioni);
        return listDotazioni;
    }

    public boolean isValido(){
        return peso <= potenza;
    }

    @Override
    public String toString() {
        String s = "Convoglio: ";
        s += ", nome = " + nome;
        s += ", peso = " + peso;
        s += ", potenza = " + potenza;
        s += ", dotazioni : " + getDotazioni().toString();
        if(isValido()) s += ", valido";
        else s+= ", non valido";

        return s;
    }





}
