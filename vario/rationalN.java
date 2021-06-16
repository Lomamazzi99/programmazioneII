
public class rationalN{
    /**
     * voglio creare dei numeri razionali del tipo num / den
     * in cui il den non può essere minore di 0 ma il num si
     */
  private  int num;
  private  int den;

    //costruttori
    /**
     * in caso il denominatore sia 0 i valori risultano null
     */
    public rationalN(){
    }

    public rationalN(int n,int d){
        if (d < 0){
            throw new IllegalArgumentException("il denominatore non può essere minore di 0\n");
        }
        if (n == 0){
            num = 0;
            den = 0;
        }
        num = n;
        den = d;
    }

   private int findNum(int k){
    if(k < 0){
        return 0;
    }
    if ( num == k){
        return k;
    }
        return 0;
    }

    private int findDen(int k){
        if(k < 0){
            return 0;
        }
        if (den == k){
            return k;
        }
            return 0;
            
        }

        public boolean findNumber(rationalN n){
                if ((findDen(den) != 0) && (findNum(num) != 0)){
                return true;
            }       
            return false;
        }
 

        public rationalN addRational(rationalN p){
            rationalN n = new rationalN();
            if(p.den == this.den){
                n.num = this.num + p.num;
                n.den = p.den;
            }else{
                n.num =p.den * this.num + this.den * p.num;
                n.den = this.den * p.den;
            }

            for(int i = 2; i <= den;i++){
                if(n.den % i == 0 && n.num % i == 0){
                    n.num /= i;
                    n.den /= i;
                }
                if(i > num){
                    return n;
                }
            }

            return n;
        }


        public rationalN mulRationalN(rationalN p){
            rationalN n = new rationalN();
            if(p.den == 0 || this.den == 0){
                return n;
            }
            return n;
        }

        public rationalN negate(){
           return new rationalN(-this.num,this.den);
        }

        public rationalN minus(rationalN p){
            rationalN n = this.negate();
            return n.addRational(p);
        }



        /**
         * rappresentazione dei numeri razionali
         * 
         * @return una stringa nella forma : den / num;
         */
        public String toString(){
            String s = "{";
            if(this.den == 0){
                s += "}";
                return s;
            }
                s += num;
                s += "/";
                s += den;
            s += "}";
            return s;
        }

        public static void main(String[] args) {
            rationalN q = new rationalN(104,27);
            rationalN p = new rationalN(39,81);
            rationalN n = p.addRational(q);
            String s = n.toString();
            System.out.println(s);
        }
}

