import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[] memo = new int[Math.max(4, n + 1)];
            memo[1] = 1;
            memo[2] = 2;
            memo[3] = 4;
            for(int j = 4; j <= n; j++){
                memo[j] = memo[j - 1] + memo[j - 2] + memo[j - 3];
            }
            sb.append(memo[n] + "\n");

        }
        System.out.println(sb.toString());
    }
}
