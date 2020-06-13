/**
 * <p> Esta classe cria o tabuleiro segundo a configuração da String introduzida pelo Utilizador</p>
 * Possibilita a verificação das peças que se encontram em determinada posição como também se uma determinada posição do tabuleiro se encontra ameaçada.
 */



public class Tabuleiro {
/**
 * Variável que guarda o comprimento das filas(Colunas/Linhas)
 */
    public int m; 
    /**
     * Variável que guarda a quantidade total de posições existentes no tabuleiro
     */
    public int cmp;
    
/**
 * Variável que guarda a configuração do tabuleiro introduzido
 */    
    public String str;
/**
 * Variável utilizada para guardar o conteúdo(Rainha ou Nada) que se encontra em determinada posição linhaXColuna no tabuleiro
 */    
    public Peca q;
    
/**
 * <p> Neste construtor é configurado o tabuleiro para cumprir os requisitos do programa e este é guardado na String str </p>
 * <p> Através do repr.length() é guardado em cmp o comprimento total do Tabuleiro </p>
 * <p> Através do (int) Math.sqrt(repr.length()) é guardado o comprimento das filas(Colunas/Linhas) </p>
 * @param repr String com a configuração do tabuleiro introduzido pelo utilizador
 */
    
    public Tabuleiro(String repr){
        
        str = repr.replaceAll(" ", "");
        cmp = str.length();
        m = (int) Math.sqrt(str.length());
        
        if((m*m) != cmp){
            
            str = "";
            
        }
    }
    
    /**
     * Método que retorna a configuração do tabuleiro em formato de String
     * @return Retorna a váriavel str que contém a configuração correta do tabuleiro
     */
    
    public String toString(){
        
       
        return str;
        
    }
    
    /**
     * <p> Método que retorna a peça(Rainha ou Nada) que se encontra na combinação linhaxcoluna introduzida. </p>
     * <p>É calculado o índice da String em que a peça se encontra e verifica-se se o conteúdo que se encontra no mesmo
     * é um "D" ou se este está vazio.</p>
     * <p> Caso o índice contenham um "D" é criada e retornada uma peça Rainha, caso contrário é criada e retornada uma peça Nada.</p>
     * @param linha Linha da combinação linhaXcoluna que vai indicar a linha em que a peça se encontra
     * @param coluna Coluna da combinação linhaXcoluna que vai indicar a coluna em que a peça se encontra
     * @return Retorna se a peça é Rainha ou Nada
     */
    
      
    public Peca peca(int linha, int coluna){
        int n;
        
        if(linha == 0){
            n = linha+coluna;
        }else{
            n = m*linha+coluna;
        }
        
        Tabuleiro tab = new Tabuleiro(str);
        
        if(str.charAt(n) == 'D'){
            q = new Rainha(tab, linha, coluna);
            
            return q;      
                
        }else{
            q = new Nada(tab, linha, coluna);
            
            return q;
        }
          
    }
    
    /**
     * <p> Este método verifica se a peça que se encontra na combinação linhaXcoluna está ameaçada por outra peça. </p>
     * <p> É verificado se existem outras peças na linha, coluna ,diagonal ascendente e descentende em que se encontra a peça indicada ao se somar o número de peças nas respetivas filas. </p>
     * @param linha Linha da combinação linhaXcoluna que vai indicar a linha em que a peça se encontra
     * @param coluna Coluna da combinação linhaXcoluna que vai indicar a coluna em que a peça se encontra
     * @return Devolve True caso existam outras peças na linha, coluna ou diagonal 
     * ascendente e descentende da peça indicada e retorna False caso não existam outras peças, ou seja, se a primeira está ameaçada por outra peça
     */
    
    public boolean ameacada(int linha, int coluna){
        
        Tabuleiro tab = new Tabuleiro(str);
        
        Peca p = tab.peca(linha, coluna);
        Linha l = tab.linha(linha);
        Coluna c = tab.coluna(coluna);
        DiagonalAscendente da = tab.diagonalAscendente(linha, coluna);
        DiagonalDescendente dd = tab.diagonalDescendente(linha, coluna);
   
        int a;
        
        a = l.pecas() + c.pecas() + da.pecas() + dd.pecas();
        if(p.vazia()){
            
            if(a == 0){
                return false;
            }else{
                return true;
            }
        }
        
        
        if(a == 4){
            return false;
        }else{   
            return true;
        }
    }
    
    /**
     * <p> Método que devolve a linha </p>
     * É criada uma linha com o comprimento das filas do tabuleiro.
     * @param linha Linha indicada pelo utilizador
     * @return Retorna a Linha
     */
    
             
    
    public Linha linha(int linha){
        
        int line = linha;
        Linha l = new Linha(m, str, line);
        return l;        
        
    }
    
    /**
     * <p> Método que devolver a Coluna </p>
     * É criada uma coluna com o comprimento das filas do tabuleiro.
     * @param coluna Coluna indicada pelo utilizador
     * @return Retorna a Coluna
     */
    
    public Coluna coluna(int coluna){
        
        int co = coluna;
        Coluna c = new Coluna(m, str, co);
        return c;
        
    }
    /**
     * <p>Método que irá devolver a Diagonal Ascendente</p>
     * É criada uma diagonal ascendente com o comprimento das filas do tabuleiro.
     * @param linha Linha indicada pelo utilizador
     * @param coluna Coluna indicada pelo utilizador
     * @return Retorna a Diagonal Ascendente
     */
    
    public DiagonalAscendente diagonalAscendente(int linha, int coluna){
        
        int line = linha;
        int co = coluna;
        
        DiagonalAscendente da = new DiagonalAscendente(line, co, m, str);
        return da;
      
    }  
    
    /**
     * <p>Método que irá devolver a Diagonal Descendente</p>
     * É criada uma diagonal descendente com o comprimento das filas do tabuleiro.
     * @param linha Linha indicada pelo utilizador
     * @param coluna Coluna indicada pelo utilizador
     * @return Retorna a Diagonal Descendente
     */
    
    public DiagonalDescendente diagonalDescendente(int linha, int coluna){
        
        
        int line = linha;
        int co = coluna;
        
        DiagonalDescendente dd = new DiagonalDescendente(line, co, m, str);
        return dd;
        
    }
}
