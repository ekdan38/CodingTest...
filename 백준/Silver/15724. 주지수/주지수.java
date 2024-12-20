import java.io.*;
import java.util.*;

/**
 * 15724 주지수
 *
 * 입력:
 *      1. 첫째 줄 N, M (1 ~ 1024)
 *      2. 이후 N개 줄에는 M개의 정수로 단위 구역 내에 살고 있는 사람 수
 *      각 단위 구역에 살고있는 사람 수 100명 이하, 각 단위 구역 별 최소 1명은 거주
 *      3. 진경대왕이 인구 수를 궁금해하는 직사각형 범위의 개수 K (1 ~ 100,000)
 *      4. K 개의 줄에는 직사각형 범위 x1, y1, x2, y2가 주어진다. (x1 ≤ x2, y1 ≤ y2)
 *
 * 문제 분석:
 *      1. 주어진 크기 (N, M)만큼 2차원 배열 생성하고, 값 채운다.
 *      2. 이후 K 만큼 반복하면서 직사각형 범위 내에 몇명이 잇는지 탐색
 *
 * 출력
 *      1. 구역에 몇명이 살고 있나 출력 => 누적합
 * * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][]field = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                field[i][j] =
                        Integer.parseInt(st.nextToken()) + field[i-1][j] + field[i][j - 1] - field[i - 1][j - 1];

            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            sum = field[x2][y2] - field[x1 - 1][y2] - field[x2][y1 - 1] + field[x1 - 1][y1 - 1];

            result.append(sum).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}