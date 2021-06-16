public class CittàEconomica extends Città{

    public CittàEconomica(String nome) {
        super(nome);
        
    }
    
    @Override
    public void produce(Civiltà c) {
        c.aggiungiDenaro(1000);

    }
    
}
