import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int row = 0;
        int[][] arr = new int[N][M];
        for(int i = 0; i < N * 2; i++){
            st = new StringTokenizer(br.readLine());
            int col = 0;
            for(int j = 0; j < M; j++){
                arr[row % N][col++] += Integer.parseInt(st.nextToken());
            }
            row++;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j == M - 1){
                    System.out.println(arr[i][j]);
                }
               else{
                   System.out.print(arr[i][j] + " ");
                }
            }
        }

    }


}
