
import java.lang.*;

 /**
 * Classe DiagonalAscendente que implementa a interface {@link Fila}
 */ 



public class DiagonalAscendente implements Fila {
   
    
    private int line, co, cm;
    private String s;
    
    
 /**
 * Construtor da Classe DiagonalAscendente
 * @param linha Linha da posição no tabuleiro
 * @param coluna Coluna da posição no tabuleiro
 * @param cmp Comprimento do tabuleiro
 * @param str Configuração do tabuleiro utilizado em formato de String
 */ 
    
   
    
    public DiagonalAscendente(int linha, int coluna, int cmp, String str){
        line = linha;
        co = coluna;
        cm = cmp;
        s = str;
       
    }
    
 /**
 * Método utilizado para retornar o comprimento da Diagonal Ascendente
 * @return Comprimento da Diagonal Ascendente
 */ 
    
    public int comprimento(){
        
        if(line == co){
            
            return cm;
            
        }
        
        int count = -1;
        int l = line;
        int c = co;
        while(c < cm && l >= 0){
            
            count++;
            l--;
            c++;
        }
        
        l = line;
        c = co;
        while(c >= 0 && l < cm ){
            
            count++;
            l++;
            c--;
            
        }
        return count;
        
    }
    
 /**
 * Método utilizado para retornar o número de peças que se encontram na diagonal em questão
 * @return Número de peças na diagonal
 */ 
    
    public int pecas(){
        
        int damas = 0;
        
        int l = line;
        int c = co;
        
        while(c >= 0 && l < cm ){
            
            int p = cm*l+c;
                if(s.charAt(p) == 'D'){
                    damas++;
                }
            
            
            l++;
            c--;
            
        }
        
            l = line-1;
            c = co+1;
        
        while(c < cm && l >= 0){
            
            
            
            int p = cm*l+c;
                if(s.charAt(p) == 'D'){
                    damas++;
                }
            
            
            l--;
            c++;
            
        }
        
        return damas;
        
        
        
    }
    
/**
 * Método utilizado para retornar a peça que se encontra numa determinada posição
 * Caso a variável pos se encontre fora dos limites da diagonal em questão é dado um throw
 * @param pos A posição na diagonal a ser verificada
 * @return Rainha ou Nada (tipo de peça que se encontra na posição)
 */ 
    
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        Tabuleiro tab = new Tabuleiro (s);
        DiagonalAscendente da = tab.diagonalAscendente(line, co);
        int a = da.comprimento();
        int p;
        Peca q = null;
        int count = 0;
        int l = line;
        int c = co;
        
        if (pos >= a || pos < 0){
            throw new IndexOutOfBoundsException("Fora dos limites");
        }
        
        
        while(l > 0 && c < a){
            l--;
            c++;
        }
        
        while(count < pos){
            count++;
            l++;
            c--;
        }
        
        
        p = cm*l+c;
        
        if(s.charAt(p) == 'D'){
            
            q = new Rainha(tab, l, c);
            return q;
            
        }else{
            q = new Nada(tab, l, c);
            return q;
        }
        
             
    }
    
}
