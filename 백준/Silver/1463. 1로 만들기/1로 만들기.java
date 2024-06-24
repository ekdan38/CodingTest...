import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 x를 입력받는다.
 * 1. x가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. x가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을때, 위와같은 연산 세 개를 적절히 사용해서 1을 만든다. 연산을 사용하는 횟수의 최삿값을 출력하시오.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N + 1];
        memo[0] = -1;
        memo[1] = 0;

        for(int i = 1; i < N + 1; i++){
            if(i % 6 == 0){
                memo[i] = Math.min(memo[i/2], Math.min(memo[i/3], memo[i-1])) + 1;
            }
            else if(i % 2 ==0){
                memo[i] = Math.min(memo[i/2], memo[i-1]) + 1;
            }
            else if(i % 3 ==0){
                memo[i] = Math.min(memo[i/3], memo[i-1]) + 1;
            }
            else{
                memo[i] = memo[i-1] + 1;
            }
        }
        System.out.println(memo[N]);



    }
}