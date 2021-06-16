import java.util.ArrayList;

public class ListaDellaSpesa{
    public ArrayList<prodotto> lista;
    public ArrayList<Integer> num;

    public ListaDellaSpesa(){
        lista = new ArrayList<>();
        num = new ArrayList<>();
    }

    public void aggiungi(prodotto p, int q){
        //se la lista è vuota
        if (num.size() == 0){
            num.add(q);
            lista.add(0, p);
            return;
        }
        //se nella lista non è contenuto il prodotto
        if (!lista.contains(p)){
            num.add(q);
            lista.add(lista.size(), p);
        }else{
            //se è già contenuto->devono essere parallele
            num.set(lista.indexOf(p), q+num.get(lista.indexOf(p)));
        }
        
        return;
    }

    public int qta(prodotto p){
        for(int i = 0; i < lista.size();i++){
        if (lista.get(i).equals(p)){
            return num.get(i);
        }
       }
    return 0;
    }

    public ArrayList<prodotto> prodotti(){
        return lista;
    }
    

    public String toString(){
        String t,s = "";
        t ="";
        if (lista.size() == 0){
            return s;
        }

        for(int i = 0; i < lista.size();i++){
            s ="prodotto: " + (this.lista.get(i)).toString() +  " quantità :" + String.valueOf(qta(this.lista.get(i)));
            s += "\n";
            t += s;
        }
        return t;
    }
}
