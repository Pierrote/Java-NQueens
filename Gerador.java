

import java.lang.*;

import java.util.*;

public class Gerador {
 
   
static List<String> num = new ArrayList<String>();
    
    public static void main(String[] args) {

	if(args[0].equals("random")){
        Scanner s = new Scanner(System.in);
        List<String> save = new ArrayList<>();
        int m = Integer.parseInt(args[1]);
        int q = Integer.parseInt(args[2]);   
        int n = Integer.parseInt(args[3]);
        
        save = random(m, q, n);
        
        int sz = save.size();
        
        
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
        
        else if(args[0].equals("all")){
       
        List<String> save = new ArrayList<>(); 
        
        int m = Integer.parseInt(args[1]);
        save = all(m);
        int i = 0;
        int y = save.size();
        String[] mamen = new String[y];
        
        while( i < y){
                   
                    mamen[i] = save.get(i);
                    
                    mamen[i] = mamen[i].replaceAll("\\s", "");
                    mamen[i] = mamen[i].replaceAll("\\[", "");
                    mamen[i] = mamen[i].replaceAll("\\]", "");
                    mamen[i] = mamen[i].replaceAll(",", "\n");
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
    
    
        
        
     static List<String> all(int m){
        
        int sz = m*m;
        
        
        String[] str = new String[sz];
        int count = 0;
        while(count < sz){
            
             str[count] = "-";    
            count++;
            
            
            }
        count = 0;
        while(count < m){
            
            str[count] = "D";
            count++;
            
        }
        
           String st = Arrays.toString(str);
            st = st.replaceAll("\\s", "");
            st = st.replaceAll("\\[", "");
            st = st.replaceAll("\\]", "");
            st = st.replaceAll(",", "");
         
        
        
        
        
        
        num = Permutation(st);
            
        
        

          return num;         
    }
    

    
    static List<String> Permutation(String str){
        
         
        
        if(str.length() == 0){
            
            List<String> bR = new ArrayList<>();
            bR.add("");
            return bR;
            
        }
        
        char c = str.charAt(0);
        
        String rS = str.substring(1);
        
        List<String> pR = Permutation(rS);
        
        List<String> fds = new ArrayList<>();
       
        for(String s : pR){
            for(int i = 0; i <= s.length(); i++){
                String f = s.substring(0, i) + c + s.substring(i);
                
                
                    int w = -1;
                    
                    for(String v : fds){
                        
                        if(v.equals(f)){
                            w = 0;
                            
                        }                      
                        
                    }
                                               
                    if(w != 0){
                        fds.add(f);
                    
                    }
                }
               
            }
             
            return fds;
            
            
        }
        
        
}      
    
    


