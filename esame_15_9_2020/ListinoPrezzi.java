/**
 * Overview:
 * Le istanze di questa interfaccia rappresentani un listino Prezzi.
 */

public interface ListinoPrezzi {
    
    /**
     * Post condizioni: resituisce il costo totale della quantità di giocattolo che si vuole acquistare
     */
    public int Acquista(int N,Giocattolo g);
    public void setPrezzoGiocattolo(Giocattolo g, int U);
    public int getPrezzoUnitario(Giocattolo g);
}
