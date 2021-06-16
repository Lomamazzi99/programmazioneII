import java.util.Objects;

public class CittàIndustriale extends Città{

    private final Risorsa risorsa;

    public CittàIndustriale(String nome, Risorsa risorsa){
        super(nome);
        Objects.nonNull(risorsa);
        this.risorsa = risorsa;
    
    }

    @Override
    public void produce(Civiltà c) {
       if(risorsa instanceof RisorsaDerivata){
        if(!c.contains(risorsa)) throw new IllegalArgumentException();
       }

        c.aggiungiRisorsa(risorsa);


    }
    


    
}
