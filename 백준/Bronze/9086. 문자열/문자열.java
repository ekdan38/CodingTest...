import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String S = br.readLine();
            bw.write(S.charAt(0) + "" +S.charAt(S.length() - 1) + "\n");
        }


        bw.flush();
        bw.close();
    }
}
