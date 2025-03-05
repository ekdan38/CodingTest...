import java.io.*;
import java.util.*;
/**
 * 1182 부분수열의 합
 *
 * 입력:
 *      1. 첫째 줄 정수의 개수 N 과 정수 S
 *      2. 둘째 줄 N개의 정수가 주어진다.
 *
 * 문제 분석:
 *      1. N개의 정수로 이루어진 부분 수열 중에서 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 *      =>
 *
 * 출력:
 *      1. 원소를 다 더한 값이 S 가 되는 경우의 수 출력
 *
 * */

public class Main {
    static int [] arr;
    static int N;
    static int S;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTrack(0, 0, false);

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    // 1 2 3 있으면 1선택, 1선택x => 이렇게 idx 증가하면서 탐색
    static void backTrack(int idx, int sum, boolean hasNum){
        // 끝까지 탐색하면 종료
        if(idx == N) {
            // cnt와 S가 같으면 경우의 수 증가
            // S == 0 정답 되는 경우의 수 없어도 1로 카운팅됨..
            // boolean 변수 추가 or cnt 초기값 -1? 
            if(sum == S && hasNum) cnt++; //
            return;
        }

        // 현재 값 선택 o
        // 3 3
        // 1 2 3 일때  1선택, 2선택, 3선택 안하면 정답
        backTrack(idx + 1, sum + arr[idx], true);

        // 현재 값 선택 x
        backTrack(idx + 1, sum, hasNum);
    }

}
