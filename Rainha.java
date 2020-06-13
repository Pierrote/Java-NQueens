/**
 * <p> Subclasse da Classe {@link Peca} </p>
 * Utilizada para criar uma Peça Rainha referente a uma determinada posição do tabuleiro
 */
public class Rainha extends Peca{
/**
 *<p> É criada uma peça Rainha</p>
 * É utilizado o super(tab, linha , coluna) para criar a devida Peça e é colocada a variável vaz = 1 para que no método boolean vazia esta posição esteja associada a uma Rainha
 * @param tab Utiliza o tabuleiro criado previamente para criar a peça
 * @param linha Utiliza a linha referente à posição no tabuleiro para criar a peça
 * @param coluna  Utiliza a coluna referente à posição no tabuleiro para criar a peça
 */    
    
        
    Rainha(Tabuleiro tab, int linha, int coluna){
        
        super(tab, linha, coluna);
        vaz = 1;       
    } 
    
}
