import java.io.*;
import java.lang.*;

import java.util.*;

public class Gerador {
    public static void main(String[] args) {

	if(args[0].equals("random")){
        Scanner s = new Scanner(System.in);
        List<String> save = new ArrayList<>();
        int m = Integer.parseInt(args[1]);
        int q = Integer.parseInt(args[2]);   
        int n = Integer.parseInt(args[3]);
        int saver = n;
        save = random(m, q, n);
        
        int sz = save.size();
        
        int lim = sz/n;
        int i = 0;
        String[] mamen = new String[sz];
        
                while( i < sz){
                   
                    mamen[i] = save.get(i);
                    mamen[i] = mamen[i].replaceAll("\\s", "");
                    mamen[i] = mamen[i].replaceAll("\\[", "");
                    mamen[i] = mamen[i].replaceAll("\\]", "");
                    mamen[i] = mamen[i].replaceAll(",", "");
                    System.out.println(mamen[i]);
                    i++;
                }
        
            
           
            
        
        }
    }
            
        
    static List<String> random(int m, int q, int n ) { 
        
        List<String> nums = new ArrayList<String>();
        int c = m;
        int rainhas = q;
        int cof = n;
        int size = (c*c);
        int man = rainhas;
        if(rainhas <= c){
         while(cof != 0){
           rainhas = man;
        int count = 0;
         String[] str = new String[size];
         
            while(count < size ){
            
             str[count] = "-";    
            count++;
            
            
            }
            
                Random r = new Random();
                while(rainhas != 0){
                int a = r.nextInt(size);
                
                    if(str[a] != "D"){
                    str[a] = "D";
                    rainhas--;
                        }
                        
                    }
                count = 0;
                
                    String arr =  Arrays.toString(str);
                    nums.add(arr);
                    
                  
        
               cof--; 
         }
        }
       
        return nums;
    }     
}
