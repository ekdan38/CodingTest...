import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        String B = new StringBuilder(br.readLine()).reverse().toString();
        int[] result = new int[B.length() + 1];

        int last = 0;
        for(int i = 0; i < B.length(); i++){
            result[i] = A * (B.charAt(i) - '0');
            last += result[i];
        }
        result[B.length()] = A * Integer.parseInt(new StringBuilder(B).reverse().toString());

        for(int i : result){
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
