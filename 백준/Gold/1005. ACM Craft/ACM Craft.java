import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물 개수
            int K = Integer.parseInt(st.nextToken()); // 건설 규칙 개수

            int[] time = new int[N + 1]; // 각 건물 건설 시간 저장
            List<List<Integer>> graph = new ArrayList<>(); // 그래프 (건설 관계 저장)
            int[] inDegree = new int[N + 1]; // 진입 차수 배열
            int[] dp = new int[N + 1]; // 최소 건설 시간 저장 (DP)

            // 그래프 초기화
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            // 각 건물의 건설 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 건설 규칙 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph.get(X).add(Y); // X -> Y (X를 지어야 Y를 지을 수 있음)
                inDegree[Y]++; // Y의 진입 차수 증가
            }

            int target = Integer.parseInt(br.readLine()); // 목표 건물

            // 위상 정렬을 위한 큐
            Queue<Integer> queue = new LinkedList<>();

            // 진입 차수가 0인 건물(즉, 선행 건물이 없는 건물)부터 시작
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                    dp[i] = time[i]; // 첫 번째 건물의 최소 시간 설정
                }
            }

            // 위상 정렬 수행
            while (!queue.isEmpty()) {
                int cur = queue.poll(); // 현재 건설 중인 건물

                for (int next : graph.get(cur)) {
                    inDegree[next]--; // 다음 건물의 진입 차수 감소
                    dp[next] = Math.max(dp[next], dp[cur] + time[next]); // 최소 건설 시간 업데이트

                    // 진입 차수가 0이 되면 큐에 추가
                    if (inDegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            // 목표 건물의 최소 건설 시간 출력
            bw.write(dp[target] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
