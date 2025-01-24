
import java.io.*;
import java.util.*;

/**
 * 12865 평범한 배낭
 *
 * 입력:
 *      1. 첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
 *      2. 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
 * 문제 분석:
 *      1. N개의 물품이 있는데 이 물품은 각각 무게 W, 가치 V 를 갖는다.
 *      2. 가방은 k만큼의 무게만 넣을 수 있다.
 *      => 가방에 넣을 수 있는 물건의 최대 가치
 *      => dp 테이블 손으로 적어보면서 2차원 배열로 풀어보자.
 *
 *
 * 출력:
 *      1. 하얀색 종이, 파란색 종이 수
 *
 * */

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int [] weight = new int[N + 1];
            int [] value = new int[N + 1];
            // row => 물건, col => K
            int [][] dp = new int[N + 1][K + 1];

            // 값 세팅
            for(int i = 1; i <= N ; i++){
                st = new StringTokenizer(br.readLine());
                weight[i] = Integer.parseInt(st.nextToken());
                value[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= K; j++){
                    // 현재 가방 무게보다 물건의 무게가 더 크면 넣을 수 없다.
                    // dp 테이블 바로 위 값 넣어주기 (이전 물건의 가중치)
                    if(j < weight[i]) dp[i][j] = dp[i - 1][j];
                    // 가방에 물건을 넣을 수 있다.
                    // 다만, 이전 물건의 가중치랑 현재 물건을 넣었을 때의 가중치를 비교해서 가장 큰 값을 정리한다.(무게 제한 때문에)
                    else dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }

            bw.write(Integer.toString(dp[N][K]));
            bw.flush();
            br.close();
            bw.close();
        }

    }
