import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr = new char[5][15];

        int maxLen = 0;
        for(int i = 0; i <= 4; i++){
            String str = br.readLine();
            if (str.length() > maxLen) maxLen = str.length();
            for(int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxLen; i++){
            for(int j = 0; j < 5; j++){
                char c = arr[j][i];
                if(c != '\0') sb.append(c);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}