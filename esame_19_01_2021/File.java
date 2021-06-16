public class File extends Entry{
    private int dimensione;

    public File(String nome,int dimensione) {
        super(nome);
        if(dimensione <= 0) throw new IllegalArgumentException();
        this.dimensione = dimensione;
    }

    public int getDimensione() {
        return dimensione;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if(!(obj instanceof File)) return false;
        File f = (File) obj;
        return f.dimensione == dimensione;
    }

    @Override
    public int hashCode() {
        int result = 31*super.hashCode();
        result += Integer.hashCode(dimensione);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", super.toString(),dimensione);
    }


    
}