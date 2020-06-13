 /**
 * Classe Linha que implementa a interface {@link Fila}
 */  




public class Linha implements Fila {
    private int cm, l;
    private String s;
    
    
    
 /**
 * Construtor da Classe Linha
 * @param cmp Comprimento da Linha
 * @param str Configuração do tabuleiro utilizado em formato de String
 * @param linha O número da linha a que se está a referir
 */   
  
 
    public Linha(int cmp, String str, int linha){
        cm = cmp;
        s = str;
        l = linha;
    }
    
 /**
 * Método utilizado para retornar o comprimento da linha
 * @return Comprimento da linha
 */  
 
    
    
    public int comprimento(){
        return cm;
    }
    
    
 /**
 * <p>Método utilizado para retornar o número de peças que se enconrtram na linha em questão</p>
 * <p> É criado um ciclo para percorrer a linha e incrementar a variável dama sempre que for 
 * encontrado um "D". </p>
 * @return Número de peças na linha 
 */  
    
    public int pecas(){
        
        int dama = 0;
        int h = cm*l+(cm-1);
        while(h >= cm*l){
            if(s.charAt(h) == 'D'){
                dama++;
            }
            h--;
        }
            
        return dama;
        
    }
    
 /**
 * <p>Método utilizado para retornar a peça que se encontra numa determinada posição</p>
 * Caso a variável pos se encontre fora dos limites da linha em questão é dado um throw
 * @param pos A posição na linha a ser verificada
 * @return Rainha ou Nada (tipo de peça que se encontra na posição)
 */  
    
    public Peca peca(int pos) throws IndexOutOfBoundsException {
        Tabuleiro t = new Tabuleiro(s);
      
        if( pos >= cm){
            throw new IndexOutOfBoundsException("Posição Inválida");
        }else{
            
                return t.peca(l, pos);
        }
        
    }    
}
