import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrX = new ArrayList<>();
        List<Integer> arrY = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        if(N == 1)System.out.print(0);
        else{
            for(int i = 0 ; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arrX.add(Integer.parseInt(st.nextToken()));
                arrY.add(Integer.parseInt(st.nextToken()));
            }
            System.out.print((Collections.max(arrX) - Collections.min(arrX)) * (Collections.max(arrY) - Collections.min(arrY)));
        }

    }
}
