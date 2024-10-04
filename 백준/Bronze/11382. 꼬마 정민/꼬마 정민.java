import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        Long C = Long.parseLong(st.nextToken());
        Long result = A + B + C;


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
