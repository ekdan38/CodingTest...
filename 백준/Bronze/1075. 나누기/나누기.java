import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N /= 100;
        N *= 100;
        int F = Integer.parseInt(br.readLine());
        int result = 0;
        while (N % F != 0) {
            N++;
            result++;
        }
        if (result < 10) {
            System.out.print("0" + result);
        } else {
            System.out.print(result);
        }
    }
}