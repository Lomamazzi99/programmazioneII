import java.util.Vector;

public class sparsePoly{
    private Vector<Integer> coeff = new Vector<>();
    private Vector<Integer> exp = new Vector<>();

    public sparsePoly(){
    }

    public sparsePoly(int c,int e){
        if (e < 0 ){
            throw new IllegalArgumentException("esponente minore di 0");
        }
        coeff.add(c);
        exp.add(e);
    }


    public int maxExp()throws IllegalArgumentException{
        int max = 0;
        if (this.exp.size() == 0){
            throw new IllegalArgumentException("polinomio vuoto-> no max grado");
        }
        
        for (int i = 0; i < this.exp.size();i++){
            if (max < this.exp.get(i) && this.exp.get(i) != 0){
               max = this.exp.get(i);
            }
        }
        return max;
    }


   public int coefficient(int n)throws IllegalArgumentException{
       if (n < 0 || n > this.coeff.size()){
           throw new IllegalArgumentException("coefficiente non valido");
       }
       for (int i = 0; i < this.coeff.size();i++){
           if (this.coeff.get(i) == n){
              return n;
           }
       }
       return -1;
   }

   public int exponent(int n)throws IllegalArgumentException {
    if (this.exp.size() == 0){
        throw new IllegalArgumentException("esponente non valido");
    }
    for (int i = 0; i < this.exp.size();i++){
        if (this.exp.get(i) == n){
           return n;
        }
    }
    return -1;
   }


   public sparsePoly addPoly(sparsePoly p) throws IllegalArgumentException{
       sparsePoly n = new sparsePoly();
       if (p.coeff.size() == 0 || p.exp.size() == 0){
           throw new IllegalArgumentException("poly vuoto");
       }

       int count = 0,somma = 0;
       boolean t = false;
       for(int i = 0; i < this.exp.size();i++){
        int isexp = this.exp.get(i);
        for (int j = 0; j < p.exp.size();j++){
            if (isexp == p.exp.get(j)){
                count++;
                somma = this.coeff.get(i) + p.coeff.get(i);
                t = true;
            }
        }
        if(t == true ){
            n.coeff.add(somma);
            n.exp.add(isexp);
        }else{
            n.exp.add(isexp);
            n.coeff.add(this.coeff.get(i));
        }
        t = false;
       }
       if (count != this.exp.size()){
            for(int i = 0; i < p.exp.size(); i++ ){
                n.exp.add(p.exp.get(i));
                n.coeff.add(p.coeff.get(i));
            }
        }
        assert n.repOk();
       return n;
   }


   public sparsePoly minusPoly(){
    sparsePoly n = new sparsePoly();
    
    for (int i = 0; i < this.coeff.size();i++){
        n.coeff.add(-this.coeff.get(i));
    }

    for (int i = 0; i < this.exp.size();i++){
        n.exp.add(-this.exp.get(i));
    }
    return n;
   }


   public sparsePoly subPoly(sparsePoly p){
       sparsePoly n = new sparsePoly();
       if (p.exp.size() == 0 || p.coeff.size() == 0){
           throw new IllegalArgumentException("poly vuoto");
       }
       n = p.minusPoly();
       return this.addPoly(n);
   }

   public boolean repOk(){
    for(int i = 0;i < this.exp.size();i++){
        if (this.exp.get(i) < 0){
            return false;
        }
    }
    return true;
   }

   public String toString(){
       String s = "{";
       for(int i = 0; i < this.exp.size();i++){
           s += Integer.toString(this.coeff.get(i));
           s += "x^";
           s += Integer.toString(this.exp.get(i));
           if (i != this.exp.size()-1){
                s += "+";
           }
       }

       s += "}";
       return s;
   }
}
