import java.io.*;
import java.util.*;

/**
 * 2847 게임을 만든 동준이
 *
 * 입력:
 *      1. 첫째 줄에 레벨의 수 N (1 ~ 100)
 *      2. 이후 N개 줄에는 각 레벨을 클리어하면 얻는 점수. (1 ~ 20,000)
 *
 *문제 분석:
 *      1. 총 N개의 레벨, 클리어할 때마다 점수를 준다.
 *      플레이어 점수 = 레벨을 올리면서 얻은 점수의 합.
 *      레벨을 난이도 순으로 배치, 쉬운 레벨이 어려운 레벨보다 점수를 많이 받는 경우 존재
 *      => 특정 레벨 점수 감소 시키려한다.
 * 출력:
 *      1. 테스트 케이스마다 사전 순으로 정렬된 값 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = N - 2; i >= 0; i--){
            while (arr[i + 1] <= arr[i]){
                arr[i]--;
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}
