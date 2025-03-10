import java.io.*;
import java.util.*;
/**
 * 2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
 *
 * 입력:
 *      1. 첫째 줄에 정수 N, M 주어진다.
 *      => N 은 아이스크림 종류 수, M 은 섞어 먹으면 안되는 조합의 개수
 *      2. 이후 줄은 섞어 먹으면 안되는 조합의 번호
 *
 * 문제 분석:
 *      1. 1 ~ N 까지 번호 부여, M 개의 조건을 피해서 3가지 N을 선택.
 *      => NC3 경우의 수 구하면서, 현재 선택한 번호 배열에 저장
 *      => 이후 3개 탐색 완료 하면 피해야 하는 조건인지 판별
 * 출력:
 *      1. 조건 피해서 만들 수 있는 방법 출력
 *
 * */

public class Main {
    static int N;
    static int M;
    static int cnt = 0;
    static boolean [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first][second] = true;
            arr[second][first] = true;
        }

        dfs(1, 0, new int[3]);

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int pos, int depth, int[] selected){
        if(depth == 3) {
            // 피해야 하는 조합이 들어 있는지 확인
            if(arr[selected[0]][selected[1]] || arr[selected[1]][selected[2]] || arr[selected[0]][selected[2]]) return;
            else cnt++;
            return;
        }
        for(int i = pos; i <= N; i++){
            // 현재 선택한 숫자 저장
            selected[depth] = i;
            // 경우의 수 탐색
            dfs(i + 1, depth + 1, selected);
        }
    }


}
