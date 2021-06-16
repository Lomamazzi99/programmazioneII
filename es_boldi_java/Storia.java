public class Storia {

    private Civiltà[] civiltàs;

    public Storia(Civiltà[] civiltàs){
        if(civiltàs.length <= 0) throw new IllegalArgumentException();
        this.civiltàs = civiltàs;
    }

    public Civiltà Commercia(int n){
        int maxDenaro = 0;
        int indexOfRichest = 0;
        for(int i  = 0; i< n;i++){
            for(int j = 0; j < civiltàs.length;j++){
                civiltàs[j].faiProdurre();
                for(int k = 0; k < civiltàs.length;k++){
                    if(k != j) {
                        if(civiltàs[j].vendiRisorseA(civiltàs[k])) break;
                    }
                }
            }
        }

        for(int j = 0; j < civiltàs.length;j++){
            if(maxDenaro <= civiltàs[j].getTesoro()){
                maxDenaro = civiltàs[j].getTesoro();
                indexOfRichest = j;
            }
        }
        return civiltàs[indexOfRichest];
    }

}
