import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long g = GCD(A, B);
        while(g --> 0){
            bw.write("1");
        }

        bw.flush();
    }

    static long GCD(long A, long B){
        if(B == 0) return A;
        else return (GCD(B, A % B));
    }
}