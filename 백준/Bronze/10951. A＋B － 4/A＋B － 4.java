import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;

        while((str = br.readLine()) != null){
            st = new StringTokenizer(str);
            String A = st.nextToken();
            String B = st.nextToken();

            bw.write(String.valueOf(Integer.parseInt(A) + Integer.parseInt(B)) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
