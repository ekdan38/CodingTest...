import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1)System.out.print(1);
        else{
            int layer = 1;
            int range = 2;
            while(range <= N){
                range += 6 * layer;
                layer++;
            }
            System.out.print(layer);
        }
    }


}
