/**
 * OVERVIEW: eccezione sollevata nel caso di insieme vuoto
 */
public class EmptyException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EmptyException() {
        super();
    }
    public EmptyException(String message){super(message);}
}
