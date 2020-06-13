
import java.util.*;

/**
 * <p> Classe com duas vertentes que validam os tabuleiros </p>
 * <p> A primeira vertente valida cada tabuleiro individualmente, retorna VALIDA se o tabuleiro for válido e retorna INVALIDA se o tabuleiro for inválido </p>
 * <p> A segunda vertente irá retornar o tabuleiro introduzido caso este seja válido </p>
 */


public class Validador {
    
    
    public static void main(String[] args) {
        
        if(args.length == 0){
                     
            Scanner s = new Scanner(System.in);
                                           
            String setup = null;
                        
            setup = s.nextLine();
                       
            Tabuleiro tab = new Tabuleiro(setup);
            
            int count = 0;
            
            int po = 0;
            
                       
            for(int l = 0; l < tab.m; l++){
                for(int c = 0; c < tab.m; c++){
                    
                    if(setup.charAt(po) == 'D'){
                        
                        if(tab.ameacada(l, c)){
                            
                            System.out.println("INVALIDA");
                            count = 1;
                            break;
                        }
                        
                    }
                    
                    po++;
                }
                
                if(count == 1){
                    break;
                }
                    
                    
            }
            
            if(count == 0 ){
                System.out.println("VALIDA");
                    
            }
            
            
        }else if(args[0].equals("filtro")){
            
            Scanner s = new Scanner(System.in);
                     
            String set = null;
            
            
            while(s.hasNext()){
                set = s.nextLine();
                               
                Tabuleiro tab = new Tabuleiro(set);
                   
                int count = 0;
                    
                int po = 0;
                  
                for(int l = 0; l < tab.m; l++){
                    for(int c = 0; c < tab.m; c++){
                            
                        if(set.charAt(po) == 'D'){
                                
                            if(tab.ameacada(l, c)){
                                count = 1;
                                break;
                            }
                                
                        }
                            
                        po++;
                    }
                        
                    if(count == 1){
                        break;
                    }
                        
                        
                }
                
                if(count == 0 ){
                    System.out.println(set);      
                }
                    
                    
            }   
               
        }
    
    }
}
