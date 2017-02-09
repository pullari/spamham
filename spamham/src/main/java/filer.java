
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pullis
 */
public class filer {

    public filer(){
    }
    
    public HashMap<String, Integer> getHamWords() {
    
        HashMap<String, Integer> hams = new HashMap();
        
        try{
            FileReader fr = new FileReader("C:\\Users\\pullis\\Documents\\NetBeansProjects\\spamham\\src\\main\\resources\\hamcount.txt");
            BufferedReader r = new BufferedReader(fr);
            
            String line;
            line = r.readLine();
            
            while(line != null){
            
                boolean numGot = false;
                String[] parts = line.split(" ");
                int nmb = 0;
                
                for(int i = 0; i < parts.length; i++){
                    if((!parts[i].equals(" ") && !parts[i].equals("")) && !numGot){
                        nmb = Integer.parseInt(parts[i]);
                        numGot = true;
                    }else if(!parts[i].equals(" ") && !parts[i].equals("")){
                        hams.put(parts[i], nmb);
                    }
                }
                line = r.readLine();
            }
            
        }catch(IOException | NumberFormatException e){
            System.out.println("File read failed");
        }

        System.out.println(" ");
        return hams;
    }
    
    public HashMap<String, Integer> getSpamWords() {
    
        HashMap<String, Integer> spams = new HashMap();
        
        try{
            FileReader fr = new FileReader("C:\\Users\\pullis\\Documents\\NetBeansProjects\\spamham\\src\\main\\resources\\spamcount.txt");
            BufferedReader r = new BufferedReader(fr);
            
            String line;
            line = r.readLine();
            
            while(line != null){
            
                boolean numGot = false;
                String[] parts = line.split(" ");
                int nmb = 0;
                
                for(int i = 0; i < parts.length; i++){
                    if((!parts[i].equals(" ") && !parts[i].equals("")) && !numGot){
                        nmb = Integer.parseInt(parts[i]);
                        numGot = true;
                    }else if(!parts[i].equals(" ") && !parts[i].equals("")){
                        spams.put(parts[i], nmb);
                    }
                }
                line = r.readLine();
            }
        }catch(IOException | NumberFormatException e){
            System.out.println("File read failed");
        }

        System.out.println(" ");
        return spams;
    }
}
