import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            char s = str.charAt(i);
            if(s >= 'a' && s <= 'z') sb.append(s);
            else if(s >= 'A' && s <= 'Z') sb.append(s);
        }

        if(sb.toString().contains(br.readLine())) bw.write("1");
        else bw.write("0");

        bw.flush();
    }
}