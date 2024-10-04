import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int cnt = 0;
        for(int index : arr){
            index = Integer.parseInt(st.nextToken());
            if(index == v)cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
