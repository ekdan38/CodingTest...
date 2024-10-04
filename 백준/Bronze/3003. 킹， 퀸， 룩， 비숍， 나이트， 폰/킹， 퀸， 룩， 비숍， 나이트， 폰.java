import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] required = {1,1,2,2,2,8};
        for(int i = 0 ; i < required.length; i++){
            required[i] -= Integer.parseInt(st.nextToken());
        }

        for(int i : required){
            System.out.print(i + " ");
        }
        bw.flush();
        bw.close();

    }
}
