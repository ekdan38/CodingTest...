import java.io.*;
import java.util.*;

/**
 * 14938 서강그라운드
 *
 * 입력:
 *      1. 첫째 줄 지역의 개수 n (1 ~ 100), 수색 범위 m (1 ~ 15), 길의 개수 r (1 ~ 100)
 *      2. 둘째 줄 n개의 숫자가 차례대로 구역에 있는 아이템의 수  t (1 ~ 30)
 *      3. 셋째 줄 부터 r + 2번째 줄 까지 지역 번호 a, b(1 ~ n), 길이 l (1 ~ 15)
 *
 *문제 분석:
 *      1. m 만큼 범위 이동 가능
 *      2. 어느 지역에 떨어질지 모른다. => 플로이드 워셜 사용
 *      3. 얻을 수 있는 아이템의 최대 수 구해라
 *
 *  출력:
 *      1. 얻을 수 있는 최대 아이템 수 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드 수
        int n = Integer.parseInt(st.nextToken());
        // 수색 범위
        int m = Integer.parseInt(st.nextToken());
        // 간선 수
        int l = Integer.parseInt(st.nextToken());

        // 1번 index부터 사용
        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int index = 1;
        while (st.hasMoreTokens()){
            item[index++] = Integer.parseInt(st.nextToken());
        }

        // 인접 행렬 생성, 초기화, index 1번부터 사용
        int [][]dist = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = 101;
            }
        }

//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("=============");


        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 양방향 그래프
            dist[a][b] = weight;
            dist[b][a] = weight;
        }
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("=============");


        // 플로이드 워셜
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
//
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }

        int [] result = new int[n + 1];
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j] <= m){
                    result[i] += item[j];
                }
            }
            if(max < result[i]){
                max = result[i];
            }
        }

//
//        for (int i : result) {
//            System.out.println("i = " + i);
//        }

        System.out.print(max);


        bw.flush();
        br.close();
        bw.close();
    }
}