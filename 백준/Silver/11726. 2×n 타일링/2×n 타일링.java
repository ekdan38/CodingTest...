import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n + 2];
        memo[1] = 1;
        memo[2] = 2;

        for(int i = 3; i <= n; i++){
            memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
        }
        System.out.println(memo[n]);


    }
}
