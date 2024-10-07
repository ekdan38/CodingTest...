import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = 0;
        int y = 0;
        int z = 0;
        while(((x = Integer.parseInt(st.nextToken())) != 0) && ((y = Integer.parseInt(st.nextToken())) != 0) && ((z = Integer.parseInt(st.nextToken())) != 0)){
            int max = Math.max(Math.max(x, y), z);

            if(x == y && y == z) System.out.println("Equilateral");
            else if(max == x && x >= y + z) System.out.println("Invalid");
            else if(max == y && y >= x + z) System.out.println("Invalid");
            else if(max == z && z >= x + y) System.out.println("Invalid");
            else{
                if((x == y && y != z) || (x == z && z != y) || (z == y && y != x)) System.out.println("Isosceles");
                else if(x != y && y != z) System.out.println("Scalene");
            }
            st = new StringTokenizer(br.readLine());
        }


    }
}
