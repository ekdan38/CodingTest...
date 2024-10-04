import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //  long int는 4 byte;
        // long long int 8

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        if(N / 4 > 0){
            for(int i = 0; i < N / 4; i++){
                sb.append("long ");
            }
            N %= 4;
            if(N > 0)sb.append("long ");
        }
        sb.append("int");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
