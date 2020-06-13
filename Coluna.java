 /**
 * Classe Coluna que implementa a interface {@link Fila}
 */  


public class Coluna implements Fila {
    
    private int cm, c, j;
    private String s;
    
 /**
 * Construtor da Classe Coluna
 * @param cmp Comprimento da Coluna
 * @param str Configuração do tabuleiro utilizado em formato de String
 * @param coluna O número da coluna que está a ser utilizada
 */  
    
    public Coluna(int cmp, String str, int coluna){
        cm = cmp*cmp;
        s = str;
        c = coluna;
        j = cmp;
    }
    
 /**
 * Método utilizado para retornar o comprimento da coluna
 * @return Comprimento da coluna
 */ 
    
    
    
    public int comprimento(){
        return j;
    }
    
 /**
 * <p>Método utilizado para retornar o número de peças que se enconrtram na coluna em questão</p>
 * <p>É criado um ciclo para percorrer a coluna e incrementar a variável dama sempre que for encontrado um "D". </p>
 * @return Número de peças na coluna 
 */  
    
    
    public int pecas(){
        
        int dama = 0;
        int h = c;
            while(h < cm+c){
                if(s.charAt(h) == 'D'){
                    dama++;
                }
                h = h+j;
            }
        
        return dama;
    }
    
 /**
 * <p>Método utilizado para retornar a peça que se encontra numa determinada posição</p>
 * Caso a variável pos se encontre fora dos limites da coluna em questão é dado um throw
 * @param pos A posição na coluna a ser verificada
 * @return Rainha ou Nada (tipo de peça que se encontra na posição)
 */  
    
    
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        
        Tabuleiro t = new Tabuleiro(s);
        if( pos >= j){
            throw new IndexOutOfBoundsException("Posição Inválida");
        }else{
            
                return t.peca(pos, c);
        }
    }    
}
