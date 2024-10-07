import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        int x = Integer.parseInt(br.readLine());
        sum += x;
        int y = Integer.parseInt(br.readLine());
        sum += y;
        int z = Integer.parseInt(br.readLine());
        sum += z;

        //세 각의 크기가 모두 60이면, Equilateral
        //세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
        //세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
        if(sum == 180){
            if(x == y && y == z)System.out.print("Equilateral");
            else if((x == y && y !=z) || (x == z && z !=y) || (y == z && y != x))System.out.print("Isosceles");
            else if(x != y && y !=z)System.out.print("Scalene");
        }
        else{
            System.out.print("Error");
        }
    }
}
