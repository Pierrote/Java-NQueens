/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierrote
 */
public class Coluna implements Fila {
    
    private int cm, c, j;
    private String s;
    
    
    Coluna(int cmp, String str, int coluna){
        cm = cmp*cmp;
        s = str;
        c = coluna;
        j = cmp;
    }
    
    public int comprimento(){
        return j;
    }
    
    public int pecas(){
        
        int dama = 0;
        if(c == 0){
            int h = 0;
            while(h < cm){
                if(s.charAt(h) == 'D'){
                    dama++;
                }
                h = h+j;
            }
            
        }else{
            int h = c;
            while(h < cm+c){
                if(s.charAt(h) == 'D'){
                    dama++;
                }
                h = h+j;
            }
            
        }
        return dama;
        
        
    }
    
    public Peca peca(int pos) throws IndexOutOfBoundsException {
      Tabuleiro t = new Tabuleiro(s);
      
        if( pos >= j){
            throw new IndexOutOfBoundsException("Posição Inválida");
        }else{
            
                return t.peca(pos, c);
            
            
        }
        
    }    
}
