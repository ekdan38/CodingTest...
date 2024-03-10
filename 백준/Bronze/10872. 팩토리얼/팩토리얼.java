
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = factorial(N);
        System.out.println(sum);
    }
    static int factorial(int N){
        if(N <= 1) return 1;
        return N * factorial(N - 1);
//
//        else{
//            System.out.println(N + "*" + factorial(N - 1));
//            return N * factorial(N - 1);
//        }
    }
}
