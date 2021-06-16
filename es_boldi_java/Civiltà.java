import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Civiltà {

    private final String nome;
    private List<Città> città;
    private int tesoro;
    private List<Risorsa> stock;

    public Civiltà(final String nome){
        Objects.nonNull(nome);
        this.nome = nome;
        this.città = new ArrayList<>();
        tesoro = 0;
        this.stock = new ArrayList<>();
    }

	public void aggiungiRisorsa(Risorsa risorsa) {
        stock.add(risorsa);
	}

	public void aggiungiDenaro(int i) {
        tesoro += i;
	}

    public Città fondaCitta(String nome, char tipo){
        Objects.nonNull(nome);
        Città c = null;
        switch (tipo) {
            case 'e':
                c = new CittàEconomica(nome);
                break;
            case 'i':
                c = new CittàIndustriale(nome, Risorsa.risorsaCasuale());
                break;
            default:
                break;
        }
        città.add(c);
        return c;
    }

    public void faiProdurre() throws IllegalArgumentException{
        for(Città c : città){
            try {
                c.produce(this);
            } catch (IllegalArgumentException e) {
                System.out.println("Manca la risorsa originale");
            }
        }
    }

    public boolean contains(Risorsa r){
        return stock.contains(r);
    }

    public boolean atLeastTwo(Risorsa r){
        return stock.indexOf(r) != stock.lastIndexOf(r);
    }

    public boolean vendiRisorseA(Civiltà altra){
        List<Risorsa> nuovoStock = new ArrayList<>();
        boolean commercio = false;
        for(Risorsa r : stock){
            if(atLeastTwo(r) && !altra.contains(r)){
                altra.stock.remove(r);
                altra.aggiungiDenaro(-r.getPrezzo());
                aggiungiDenaro(r.getPrezzo());
            }else{
                nuovoStock.add(r);
            }
        }

        stock = nuovoStock;
        return commercio;
    }

    public String getNome() {
        return nome;
    }

    public int getTesoro() {
        return tesoro;
    }

}
