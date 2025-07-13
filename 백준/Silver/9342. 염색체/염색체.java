import java.util.*;
import java.io.*;

/**
<문제 분석>
    대문자로만 이루어져 있고, 규칙 검사해야함
    문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다.
    그 다음에는 A가 하나 또는 그 이상 있어야 한다.
    그 다음에는 F가 하나 또는 그 이상 있어야 한다.
    그 다음에는 C가 하나 또는 그 이상 있어야 한다.
    그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다.
    
*/
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String str = br.readLine();
            String pattern = "^[A-F]?A+F+C+[A-F]?$";
            if(str.matches(pattern)) bw.write("Infected!\n");
            else bw.write("Good\n");
        }
        bw.flush();
        
    }
}