
import java.lang.*;
import java.util.*;
/**
 * <p> Classe com três vertentes que geram tabuleiros </p>
 * <p> A primeira vertente gera n tabuleiros (número escolhido pelo utilizador) aleatórios em que o utilizador escolhe o tamanho do tabuleiro (m*m) e a quantidade de rainhas (q) </p>
 * <p> A segunda vertente gera todos os tabuleiros existentes com tamanho m*m e m rainhas, sendo m escolhido pelo utilizador </p>
 * <p> A terceira vertente gera todos os tabuleiros válidos com tamanho m*m e m rainhas, sendo m escolhido pelo utilizador </p>
 */

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
        
            while(i < sz){
                   
                mamen[i] = save.get(i);
                    
                mamen[i] = mamen[i].replaceAll("\\s", "");
                mamen[i] = mamen[i].replaceAll("\\[", "");
                mamen[i] = mamen[i].replaceAll("\\]", "");
                mamen[i] = mamen[i].replaceAll(",", "");
                System.out.println(mamen[i]);
                i++;
            }
            
        }else if(args[0].equals("all")){
       
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
        
        }else if(args[0].equals("allValid")){
       
            List<String> save = new ArrayList<>(); 
        
            int m = Integer.parseInt(args[1]);
            save = allValid(m);
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
    /**
     * <p> Método que permite o funcionamento da vertente que gera n tabuleiros (número escolhido pelo utilizador) aleatórios em que o
     * utilizador escolhe o tamanho do tabuleiro (m*m) e a quantidade de rainhas (q) </p>
     * @param m Tamanho dos tabuleiros a serem gerados
     * @param q Número de rainhas a colocar em cada tabuleiro
     * @param n Quantidade de tabuleiros a ser gerados
     * @return Retorna uma List com todos os tabuleiros gerados
     */
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
    
    /**
     * <p> Método que permite o funcionamento da vertente que gera todos os tabuleiros existentes com tamanho m*m e m rainhas, sendo m escolhido pelo utilizador </p>
     * @param m Número que define o tamanho dos tabuleiros e a quantidade de rainhas em cada um deles
     * @return Retorna uma List com os tabuleiros gerados
     */

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
    

    /**
     * <p> Método que irá permutar a String do seu parametro e fazer uma List com todos as combinaçoes possiveis dessa mesma String </p>
     * @param str String que contêm o tabuleiro original a ser permutado
     * @return Retorna a List com todos os tabuleiros permutados
     */
    static List<String> Permutation(String str){

        if(str.length() == 0){
            List<String> bR = new ArrayList<>();
            bR.add("");
            return bR; 
        }
        
        char c = str.charAt(0);
        
        String rS = str.substring(1);
        
        List<String> pR = Permutation(rS);
        
        List<String> dK = new ArrayList<>();
       
        for(String s : pR){
            for(int i = 0; i <= s.length(); i++){
                String f = s.substring(0, i) + c + s.substring(i);
                
                int tux = -1;
                for(String v : dK){
                    if(v.equals(f)){
                        tux = 0;
                    }    
                }
                                               
                if(tux != 0){
                    dK.add(f);
                    
                }
            }
               
        }
             
        return dK;    
    }
    /**
     * <p> Método que permite o funcionamento da vertente que gera todos os tabuleiros válidos com tamanho m*m e m rainhas, sendo m escolhido pelo utilizador </p>
     * @param m Número que define o tamanho dos tabuleiros e a quantidade de rainhas em cada um deles
     * @return Retorna uma List com os tabuleiros válidos
     */
    static List<String> allValid(int m){
        
        List<String> vV = new ArrayList<>();
        List<String> aV = new ArrayList<>();
        
        
        vV = all(m);
        int i = 0;
        int y = vV.size();
        String[] mamen = new String[y];
        
        while( i < y){ 
            mamen[i] = vV.get(i);
                    
            mamen[i] = mamen[i].replaceAll("\\s", "");
            mamen[i] = mamen[i].replaceAll("\\[", "");
            mamen[i] = mamen[i].replaceAll("\\]", "");
            mamen[i] = mamen[i].replaceAll(",", "\n");
                    
            String str = mamen[i];
            Tabuleiro tab = new Tabuleiro(str);
                    
            int count = 0;
                    
            int po = 0;
                    
            for(int l = 0; l < tab.m; l++){
                for(int c = 0; c < tab.m; c++){
                            
                    if(str.charAt(po) == 'D'){
                                
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
                aV.add(str);
                        
            }
            
            i++;
        }    
        
        return aV;
    }   
}      
    
    


