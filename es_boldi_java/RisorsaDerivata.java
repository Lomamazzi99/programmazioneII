import java.util.Objects;

public class RisorsaDerivata extends Risorsa{

    private final Risorsa originale;

    public RisorsaDerivata(String nome, int prezzo,Risorsa originale) {
        super(nome, prezzo);
        Objects.nonNull(originale);
        this.originale = originale;
    }

    public Risorsa getOriginale() {
        return originale;
    }
    
}
