import java.util.*;
import java.io.*;

/**
 * 20154번
 * <문제 분석>
 *     s,t 주어진다.
 *     s 값 받아주고, t도 받아주고,
 *     s[0] == t[0 ~ N]
 *     s의 idx ++;
 */
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str = br.readLine()) != null){
            String s = str.split(" ")[0];
            String t = str.split(" ")[1];

            int sIdx = 0;
            for(int i = 0; i < t.length(); i++){
                if(s.charAt(sIdx) == t.charAt(i)) sIdx++;
                if(sIdx == s.length()) break;
            }

            if(sIdx == s.length()) bw.write("Yes" + "\n");
            else bw.write("No" + "\n");
        }

        bw.flush();
    }
}