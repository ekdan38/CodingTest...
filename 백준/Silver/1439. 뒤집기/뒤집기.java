import java.io.*;
import java.util.*;
public class Main{
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        int one = 0;		
        int zero = 0;		
        char previousNum = input.charAt(0);	
        for(int i = 1; i < input.length(); i++){
            char cur = input.charAt(i);
            if(cur != previousNum){	
                previousNum = cur;	
                if(cur == '0') one++;
                else zero++;
            }
        }
        if(previousNum == '1') one++;
        else zero++;
        bw.write(Math.min(one, zero) + "");
        bw.flush();		
        bw.close();
        br.close();
    }
}