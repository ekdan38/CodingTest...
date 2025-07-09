import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        
        double M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Double.parseDouble(st.nextToken());
            if (M < arr[i]) M = arr[i];
        }
        
        double sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i] / M * 100;
        }
        
        double result = sum / N; 
        bw.write(String.valueOf(result));
        bw.flush();
    }
}