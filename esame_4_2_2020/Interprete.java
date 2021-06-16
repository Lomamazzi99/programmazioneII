import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Interprete {

    

    private List<String> nomeRotabili;
    private List<Rotabile> rotabili;
    //private Convoglio convoglio;
    

    public Interprete(String rotabili){
        Objects.nonNull(rotabili);
        
        String[] as = rotabili.split(" ");
        nomeRotabili = new ArrayList<>();
        for(int i = 0; i< as.length;i++){
            nomeRotabili.add(as[i]);
        }
        this.rotabili = new ArrayList<>();
    }

    public Convoglio createConvoglio(){
        Convoglio convoglio = new Convoglio(nomeRotabili.get(0),rotabili);
        return convoglio;
    }

    public void insertRotabili(String s){
    //public void insertRotabili(String s){
        String[] as = s.split(" ");
        List<Rotabile> allRotabili = new ArrayList<>();
        switch (as[0]) {
            case "L":
            Locomotore l =  new Locomotore(as[1], Integer.parseInt(as[2]), Integer.parseInt(as[3]));
            if(nomeRotabili.contains(l.getModello())){
                //System.out.println(as[1]);
                allRotabili.add(l);

            }
                break;
            case "V":
                Vagone v = new Vagone(as[1], Integer.parseInt(as[2]));
                for(int i = 3; i < as.length;i+=2){
                    Dotazione d = new Dotazione(as[i],Integer.parseInt(as[i+1]));
                    v.insertDotazione(d);
                }
                if(nomeRotabili.contains(v.getModello())){
                    //System.out.println(as[1]);
                    allRotabili.add(v);
                }
                break;
            default:
                break;
        }
        setRotabili(allRotabili);
    }

    //AUMMENTA PRIMA LA I PIUTTOSTO CHE LA J.... IO BOH
    public void setRotabili(List<Rotabile> al){
        //al.size()
        //System.out.println(nomeRotabili.size());
        for(int i = 1; i < nomeRotabili.size();i++){
            String s = nomeRotabili.get(i);
            System.out.printf("i = %d, NOME = %s\n",i,s);
            
            for(int j = 0; j < al.size();j++){
                Rotabile r = al.get(j);
                System.out.printf("j = %d, MODELLO = %s\n",j,r.getModello());
                
                if(s.compareTo(r.getModello()) == 0){
                    System.out.println("Add");
                    rotabili.add(r);
                    break;
                }
            }
        }
        
    }

    @Override
    public String toString() {
        String s = "";
        s +="\n";
        for(Rotabile r : rotabili){
            s += r.toString();
            s +="\n";
        }
        return s;
    }
    


}
