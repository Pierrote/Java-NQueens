
import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierrote
 */
public class Validador {
    
    public static void main(String[] args) {
        
        if(args.length == 0){
            
            /* Scanner s = new Scanner(System.in);
            
            String setup = s.nextLine();
            
            Tabuleiro tab = new Tabuleiro(setup);
            
            System.out.println(tab.ameacada(1, 0));*/
            
       
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
            
            
            String setup = null;
        try {
            setup = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Validador.class.getName()).log(Level.SEVERE, null, ex);
        }
            
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
            
            
            
            
            
        }else if(args[0].equals("Filtro")){
            
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
