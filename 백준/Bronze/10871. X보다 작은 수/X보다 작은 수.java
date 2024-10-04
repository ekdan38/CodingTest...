import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < arr.length; i++){
            if((arr[i] < X) && i == (arr.length - 1)){
                bw.write(String.valueOf(arr[i]));
            }
            else if(arr[i] < X){
                bw.write(String.valueOf(arr[i]) + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
