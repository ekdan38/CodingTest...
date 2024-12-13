import java.io.*;
import java.util.*;

/**
 * 18511 큰 수 구성하기
 *
 * 입력:
 *      1. 첫째 줄에 정수 N (10 ~ 100,000,000), K (1 ~ 3)
 *      2. 둘째 줄에 K의 원소들이 주어진다.
 *
 *문제 분석:
 *      1. N보다 작거나 같은 자연수 중에서, 집합 K의 원소로만 구성된 가장 큰 수 출력
 *      ex) N = 675, K = {1, 5, 7} => 577
 *      dfs 재귀?,,
 *
 *  출력:
 *      1. 원소로 k길이 만큼 만든 값 중에서 N보다 작은 자연수 구하기
 */

public class Main {
    static int [] arr;
    static int K;
    static int N;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1 5 7 => 657 보다 작은데 가장 큰 값
        // => 정렬하고 맨뒤부터 재귀?
        Arrays.sort(arr);
        dfs(0);

        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }

    // 배열에서 선택할 때마다 10의 자리씩 밀어줘야한다. Math.pow()사용? => 실패
    // * 10 해주면서 밀어주자
    static void dfs(int sum){
        if(sum > N)return;
        max = Math.max(sum, max);
        for(int i = arr.length - 1; i >= 0; i--){
            dfs(arr[i] + sum * 10);
        }
    }

}