/**
 * <p> A classe Peca permite associar certas características a posições específicas do tabuleiro </p>
 * Possibilita também a verificação da linha e da coluna em que a peça se encontra e também verificar se a peça se pode 
 * movimentar para uma determinada posição no tabuleiro ou atacar outra peça
 */
public abstract class Peca {
    private Tabuleiro ta;
    private int line;
    private int col;
    /**
     * Variável que permite verificar se uma determinada posição do tabuleuiro contém uma Rainha ou um Nada
     */
    public int vaz;
    
    /**
     * <p> Neste construtor vão ser definidas as caracteristicas de uma Peça </p>
     * @param tab Tabuleiro onde a peça está introduzida
     * @param linha Linha onde a peça se encontra
     * @param coluna Coluna onde a peça se encontra
     */
    
    public Peca(Tabuleiro tab, int linha, int coluna){
        ta = tab;
        line = linha;
        col = coluna;
        
    }
    
    /**
     * Método que define a linha onde a peça se encontra
     * @return Retorna a linha onde a peça se encontra
     */
    
    int linha(){
        
        return line;
        
    }
    
    /**
     * Método que define a coluna onde a peça se encontra
     * @return Retorna a coluna onde a peça se encontra
     */
    
    int coluna(){
        
        return col;
        
    }
    
    /**
     * Método que verifica se a peça que se encontra na combinação linexcol pode ir para a posição da combinação linhaxcoluna
     * @param linha Linha da combinação para a qual se verifica se a peça se pode descolar
     * @param coluna Coluna da combinação para a qual se verifica se a peça se pode descolar
     * @return Retorna true caso a peça possa ir para a posição desejada e retorna false caso contrário
     */
    
    boolean podeIrPara(int linha, int coluna){
        
        Peca r = ta.peca(linha, coluna);
        
        if(linha == line){  
            if(r.vazia()){
                return true;
            }else{
                return false;
            }
            
        }
       
        if(coluna == col){
            if(r.vazia()){
                return true;
            }else{
                return false;
            }
        }
        
        int l = line+1, c = col+1;
       
        while(l<ta.m && c<ta.m){    
                                                // DD direita
            if(linha == l && coluna == c){
                
                if(r.vazia()){
                    return true;
                }else{
                    return false;
                }
                
           }
           l++;
           c++;
        }
       
        l = line +1;
        c = col-1;
       
        while(l<ta.m && c>=0){  
                                                // DD esquerda
            if(linha == l && coluna == c){
                
                if(r.vazia()){
                    return true;
                }else{
                    return false;
                }
                
            }
            l++;
            c--;
        }
       
        l = line-1;
        c = col-1;
       
        while(l>=0 && c>=0){   
                                                // DA esquerda
            if(linha == l && coluna == c){
                
                if(r.vazia()){
                    return true;
                }else{
                    return false;
                }
            }
            l--;
            c--;
        }
       
        l = line-1;
        c = col+1;
       
        while(l>= 0&& c<ta.m){  
                                               // DA direita
            if(linha == l && coluna == c){
                
                if(r.vazia()){
                    return true;
                }else{
                    return false;
                }
            }
            l--;
            c++;
        }
       
       return false;
       
    }
    
    /**
     * Método que verifica se a peça do parâmetro pode ser atacada pela peça que se encontra na combinação linexcol
     * @param vitima Peça a ser atacada
     * @return Retorna true se for possível atacar a peça em questão e false caso contrário
     */
    
    final boolean ataca (Peca vitima){
        
        Peca r = vitima;
        
        if(r.linha() == line){
            if(r.vazia()){
                return false;
            }else{
                return true;
            }  
        }
        
        if(r.coluna() == col){   
            if(r.vazia()){
                return false;
            }else{
                return true;
            }
        }
        
        int l = line+1, c = col+1;
       
        while(l<ta.m && c<ta.m){                 // DD direita
            if(r.linha() == l && r.coluna() == c){  
                if(r.vazia()){
                    return false;
                }else{
                    return true;
                }
            }
            l++;
            c++;
        }
       
        l = line +1;
        c = col-1;
       
        while(l<ta.m && c>=0){                 // DD esquerda
            if(r.linha() == l && r.coluna() == c){
               
                if(r.vazia()){
                    return false;
                }else{
                    return true;
                }
            }
            l++;
            c--;
        }
       
        l = line-1;
        c = col-1;
       
        while(l>=0 && c>=0){                 // DA esquerda
            if(r.linha() == l && r.coluna() == c){
               
                if(r.vazia()){
                    return false;
                }else{
                    return true;
                }
            }
            l--;
            c--;
        }
       
        l = line-1;
        c = col+1;
       
        while(l>= 0&& c<ta.m){                 // DA direita
            if(r.linha() == l && r.coluna() == c){
               
                if(r.vazia()){
                    return false;
                }else{
                    return true;
                }
            }
            l--;
            c++;
        }
       return false;
    }
    
    /**
     * Método que verifica se a posição da combinação linexcol está vazia ou não
     * @return Retorna true se a posição estiver vazia e falsa caso contrário
     */
    
    boolean vazia(){
      
        if(vaz == 0){
            return true;
        }else{
            return false;
        }
    }
    
}
