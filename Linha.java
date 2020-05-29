





public class Linha implements Fila {
    private int cm, l;
    private String s;
    
    Linha(int cmp, String str, int linha){
        cm = cmp;
        s = str;
        l = linha;
    }
    
    public int comprimento(){
        return cm;
    }
    
    public int pecas(){
        
        int dama = 0;
        if(l == 0){
            int h = cm-1;
            while(h >= 0){
                if(s.charAt(h) == 'D'){
                    dama++;
                }
                h--;
            }
            
        }else{
            int h = cm*l+(cm-1);
            while(h >= cm*l){
                if(s.charAt(h) == 'D'){
                    dama++;
                }
                h--;
            }
            
        }
        return dama;
        
        
    }
    
    public Peca peca(int pos) throws IndexOutOfBoundsException {
      Tabuleiro t = new Tabuleiro(s);
      
        if( pos >= cm){
            throw new IndexOutOfBoundsException("Posição Inválida");
        }else{
            
                return t.peca(l, pos);
            
            
        }
        
    }    
}
