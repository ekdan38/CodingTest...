import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(i == T - 1) {
                sb.append("Case #" + (i + 1) + ": " + A + " + " + B + " = " + (A + B));
            }
            else{
                sb.append("Case #" + (i + 1) + ": " + A + " + " + B + " = " + (A + B)).append("\n");
            }


        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
