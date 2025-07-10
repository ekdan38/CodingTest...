import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str;
        StringBuilder sb = new StringBuilder();
        while(true){
            str = br.readLine();
            if(str.equals("END")) break;
            
            bw.write(sb.append(str).reverse().toString() + "\n");
            sb.setLength(0);
        }
        bw.flush();
    }
}