import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N];
        for(int i = 0; i < N; i++){
            basket[i] = i + 1;
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int[] newArr = new int[end - start + 1];
            int index = 0;
            for(int j = end; j >= start; j--){
                newArr[index++] = basket[j];
            }
            index = 0;
            for(int k = start; k < end +1; k++){
                basket[k] = newArr[index++];
            }
        }
        for(int i:basket){
            bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
        bw.close();
    }
}
