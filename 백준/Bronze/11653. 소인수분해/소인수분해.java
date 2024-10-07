import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int sub = 2;
        while(N > 1){
            if(N % sub == 0){
                N /= sub;
                sb.append(sub).append("\n");
            }
            else{
                sub++;
            }
        }
        System.out.print(sb);
    }
}
