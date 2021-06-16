import java.util.List;
import java.util.Objects;

public class Compratore {
    List<Bancarella> insiemeBancarelle;

    public Compratore(List<Bancarella> insiemeBancarelle){
        Objects.nonNull(insiemeBancarelle);
        for(Bancarella b : insiemeBancarelle){
            Objects.nonNull(b);
        }
        this.insiemeBancarelle= insiemeBancarelle;
    }

    public Acquisto compra(final int num,final Giocattolo giocattolo){
        Acquisto acq = new Acquisto(giocattolo, num, insiemeBancarelle);
        acq.effettuaAcquisto();
        return acq;
    }
}
