/**
 * Interface que vai ser implementada nas Classes {@link Linha} , {@link Coluna}, {@link DiagonalAscendente} e {@link DiagonalDescendente}
 * @see Linha
 * @see Coluna
 * @see DiagonalAscendente
 * @see DiagonalDescendente
 * 
 */
public interface Fila {
    
    /**
     * @return Retorna o comprimento da fila
     */
    int comprimento();
    /**
     * @return Retorna o número de peças que se encontram na fila
     */
    int pecas();
    /**
     * @param pos Posição da fila que vai ser verificada
     * @return Retorna o conteúdo da posição da fila
     * @throws IndexOutOfBoundsException Quando a variável pos está fora dos limites do tabuleiro é dado um throw
     */
    Peca peca(int pos) throws IndexOutOfBoundsException;
    
}
