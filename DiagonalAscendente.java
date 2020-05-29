/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierrote
 */
public class DiagonalAscendente implements Fila {
    private int line, co, cm;
    private String s;
    
    
     DiagonalAscendente(int linha, int coluna, int cmp, String str){
        line = linha;
        co = coluna;
        cm = cmp;
        s = str;
       
    }
    
    public int comprimento(){
        return cm;
    }
    
    public int pecas(){
        int count = 0;
        int damas = 0;
        
        if(count == 0){
            int l = line;
            int c = co;
            while(l >= 0 && c >= 0){
                int p = cm*l+c;
                if(s.charAt(p) == 'D'){
                    damas++;
                }
                l--;
                c--;
                
            }
            count++;
            
        }
        if(count == 1){
            
            int l = line-1;
            int c = co+1;
            while(l >= 0 && c < cm){
                int p = cm*l+c;
                if(s.charAt(p) == 'D'){
                    damas++;
                }
                l--;
                c++;
                
            }
            
            
            
        }
        
        return damas;
        
        
        
    }
    
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        Peca q = null;
        return q;
    }
    
}
