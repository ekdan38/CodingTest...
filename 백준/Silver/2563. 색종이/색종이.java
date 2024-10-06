import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] arr = new boolean[100][100];

        int T = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y + 10; k++){
                    arr[j][k] = true;
                }
            }
        }

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(arr[i][j])cnt++;
            }
        }
        System.out.print(cnt);

    }


}
