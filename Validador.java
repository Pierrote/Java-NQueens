
import java.io.BufferedReader;
import java.io.*;
import java.util.*;


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
                            
                            System.out.println("Inválido");
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
                System.out.println("Válido");
                    
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
