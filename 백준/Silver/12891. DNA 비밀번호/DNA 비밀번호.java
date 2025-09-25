import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] sw = new int[26];
        String DNA = br.readLine();
        for(int i = 0; i < P; i++){
            sw[DNA.charAt(i) - 'A']++;
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = P - 1;
        int result = 0;
        while(end < S){
            if(sw['A' - 'A'] >= A && sw['C' - 'A'] >= C && sw['G' - 'A'] >= G && sw['T' - 'A'] >= T){
                result++;
            }
            sw[DNA.charAt(start) - 'A']--;
            start++;

            end++;
            if(end < S){
                sw[DNA.charAt(end) - 'A']++;
            }

        }
        bw.write(String.valueOf(result));
        bw.flush();

    }
}