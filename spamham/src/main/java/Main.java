
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author pullis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String, Integer> spams;
        HashMap<String, Integer> hams;
        
        filer f = new filer();
        spams = f.getSpamWords();
        hams = f.getHamWords();
        
        int spamWords = 6245;
        int hamWords = 16207;
        int allWords = spamWords + hamWords;
        
        double odds = 1;
        odds = Math.log(odds);
        
        double spamPrior = 0.5;
        double hamPrior = 0.5;
        
        
        try{
        
            FileReader r = new FileReader("C:\\Users\\pullis\\Documents\\NetBeansProjects\\spamham\\src\\main\\resources\\spamesim.txt");
            BufferedReader br = new BufferedReader(r);
            
            String line = br.readLine();
            String[] parts = line.split(" ");
            
            for(int i = 0; i < parts.length; i++){

                if(spams.containsKey(parts[i]) && hams.containsKey(parts[i])){
                    
                    int spami = spams.get(parts[i]);
                    int hami = hams.get(parts[i]);
                    double wordsInSpami = (double) spami / spamWords;
                    double wordsInHami = (double) hami / hamWords;
                   
                    odds += Math.log(wordsInSpami / wordsInHami);
                }else{
                    
                }
            }
            
            odds = Math.exp(odds);
        }catch(Exception e){
            System.out.println("File reading failed in main");
        }
        
        System.out.println(" ");
    }
}
