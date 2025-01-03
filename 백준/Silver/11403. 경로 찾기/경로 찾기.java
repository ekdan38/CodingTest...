import java.io.*;
import java.util.StringTokenizer;

/**
 * 11403 경로 찾기
 *
 * 입력:
 *      1. 첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다.
 *      2. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다.
 *
 * 문제 분석:
 *      1. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.
 *      2. 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
 *      3. 인접행렬 형식으로 출력, 정점 i에서 j로 가는 길이가 양수인 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.
 *      => 플로이드 워셜 사용. 다만, 최단거리 구하는 문제는 아니다. 플로이드 워셜에서 조금 변경???
 *      arr[i][k] 랑 arr[k][j] 가 1이면 arr[i][j] 도 1로 처리
 * 출력:
 *      1.
 *
 * */

public class Main {
    static int N;
    static int [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}