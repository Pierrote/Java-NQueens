
public interface Fila {
    int comprimento();
    int pecas();
    Peca peca(int pos) throws IndexOutOfBoundsException;
    
}
