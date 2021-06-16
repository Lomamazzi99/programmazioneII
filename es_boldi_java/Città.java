import java.util.Objects;

public abstract class Città {
    private final String nome;

    public Città(final String nome){
        Objects.nonNull(nome);
        this.nome = nome;
    }

    public abstract void produce(Civiltà c);

    public String getNome() {
        return nome;
    }
}
