import java.util.ArrayList;
import java.util.Iterator;

public class Sistema {
    ArrayList<CorpoCeleste> sistema = new ArrayList<>();

    public Iterator<CorpoCeleste> iter(){
        return new gen(this);
    }

    private static class gen implements Iterator<CorpoCeleste>{

        public gen(Sistema sistema) {
            
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public CorpoCeleste next() {
            // TODO Auto-generated method stub
            return null;
        }


    }
}