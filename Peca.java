
public abstract class Peca {
    private Tabuleiro ta;
    private int line;
    private int col;
    public int vaz;
    
    Peca(Tabuleiro tab, int linha, int coluna){
        ta = tab;
        line = linha;
        col = coluna;
        
    }
    
    int linha(){
        
        return line;
        
    }
    
    int coluna(){
        
        return col;
        
    }
    
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
       
        while(l<ta.m && c<ta.m){                 // DD direita
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
       
        while(l<ta.m && c>=0){                 // DD esquerda
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
       
        while(l>=0 && c>=0){                 // DA esquerda
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
       
        while(l>= 0&& c<ta.m){                 // DA direita
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
    
    boolean vazia(){
      
        if(vaz == 0){
            return true;
        }else{
            return false;
        }
    }
    
}
