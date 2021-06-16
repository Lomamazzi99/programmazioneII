import java.util.Objects;

public enum Operazione {
    SUM{
        @Override
        public int perform(int[] l){
            Objects.nonNull(l);

            int result = 0;
            if(l.length == 0) throw new IllegalArgumentException();
            for(int i : l){
                result += i;
            }
            return result;
        }
    },
    SUB{
        @Override
        public int perform(int[] l){
            Objects.nonNull(l);

            int result = 0;
            if(l.length == 0) throw new IllegalArgumentException();
            for(int i : l){
                result -= i;
            }
            return result;
        }
    },
    MAX{
        @Override
        public int perform(int[] l){
            Objects.nonNull(l);

            int result = l[0];
            if(l.length == 0) throw new IllegalArgumentException();
            for(int i : l){
                result = Math.max(result, i);
            }
            return result;
        }
    },
    PROD{
        @Override
        public int perform(int[] l){
            Objects.nonNull(l);

            int result = 1;
            if(l.length == 0) throw new IllegalArgumentException();
            for(int i : l){
                result *= i;
            }
            return result;
        }
    };

	abstract int perform(int[] l);
}
