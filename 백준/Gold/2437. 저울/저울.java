import java.io.*;
import java.util.*;

/**
 * 2437 저울
 *
 * 입력:
 *      1. 첫째 줄 저울추의 개수를 나타내는 N (1 ~ 1,000)
 *      2. 둘째 줄 N개의 양의 정수 (1 ~ 1,000,000)
 *
 *문제 분석:
 *      1. 이 추들을 사용해서 측정할 수 없는 정수 무게 중 최소값을 구하자
 *      => 오른차순 정렬, 저울 추의 무게가 지금까지 올린 저울추의 무게의 누적 합보다 크면 측정할 수 없는 최소값
 *  출력:
 *      1. 주어지 추들로 측정할 수 없는 양의 정수 무게 중 최소값 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 1;
        for(int i = 0; i < N; i++){
            if (sum < arr[i])break;
            sum += arr[i];
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}