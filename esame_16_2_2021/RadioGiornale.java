import java.util.List;

public class RadioGiornale extends Trasmissione {

    private final int durata;

    //il radiogiornale, che ha una durata assegnata (inferiore all'ora) 
    //e che viene trasmesso sempre alle ore 09:40, 11:40, 19:40, 21:40, 22:40 e 25:40.

    public RadioGiornale(String titolo, List<FasciaBetaoraria> fasce,int durata) {
        super(titolo, fasce);
        if(durata < 0 || durata > 30) throw new IllegalArgumentException();
        this.durata = durata;
        
    }

    @Override
    public String getTitolo() {
        
        return null;
    }

    @Override
    public List<FasciaBetaoraria> getFasce() {
        
        return null;
    }

    //restituisce durata
    public int getDurata() {
        return durata;
    }

    

}
