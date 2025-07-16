import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lights = new int[N + 1];

        for(int i = 1; i <= N; i++){
            lights[i] = Integer.parseInt(st.nextToken());
        }

        while(M -- > 0){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(command == 1){
                lights[l] = r;
            }
            else if(command == 2){
                for(int i = l; i <= r; i++){
                    lights[i] = lights[i] == 1 ? 0 : 1;
                }
            }
            else if(command == 3){
                for(int i = l; i <= r; i++){
                    lights[i] = 0;
                }
            }
            else{
                for(int i = l; i <= r; i++){
                    lights[i] = 1;
                }
            }
        }
        for(int i = 1; i <= N; i ++){
            bw.write(lights[i] + " ");
        }
        bw.flush();
    }
}
