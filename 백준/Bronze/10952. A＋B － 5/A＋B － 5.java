import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if(A.equals("0") && B.equals("0")) break;

            bw.write(String.valueOf(Integer.parseInt(A) + Integer.parseInt(B)) + "\n");

        }

        bw.flush();
        bw.close();
    }
}
