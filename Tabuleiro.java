
public class Tabuleiro {
    public int m, n, cmp;
    public String str;
    public Peca q;
    Tabuleiro(String repr){
        
        str = repr.replaceAll(" ", "");
        cmp = repr.length();
        m = (int) Math.sqrt(repr.length());
        
        
        
    }
    
   
    
    
    Peca peca(int linha, int coluna){
        
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
    
    boolean ameacada(int linha, int coluna){
        
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
    
             
    
    Linha linha(int linha){
        
        int line = linha;
        Linha l = new Linha(m, str, line);
        return l;        
        
    }
    
    Coluna coluna(int coluna){
        
        int co = coluna;
        Coluna c = new Coluna(m, str, co);
        return c;
        
    }
    
    DiagonalAscendente diagonalAscendente(int linha, int coluna){
        
        int line = linha;
        int co = coluna;
        
        DiagonalAscendente da = new DiagonalAscendente(line, co, m, str);
        return da;
        
    }  
    
    DiagonalDescendente diagonalDescendente(int linha, int coluna){
        
        
        int line = linha;
        int co = coluna;
        
        DiagonalDescendente dd = new DiagonalDescendente(line, co, m, str);
        return dd;
        
    }
}
