import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int g = gcd(A, B);
            int l = (A * B / g);
            sb.append(l).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
