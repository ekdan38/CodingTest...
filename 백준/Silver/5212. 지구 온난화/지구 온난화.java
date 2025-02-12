import java.io.*;
import java.util.*;

/**
 * 5212 지구 온난화
 *
 * 입력:
 *      1. 첫째 줄에 지도의 크기 R과 C (1 ≤ R, C ≤ 10)가 주어진다. 다음 R개 줄에는 현재 지도가 주어진다.
 *
 * 문제 분석:
 *      1. 다도해의 지도는 R * C 크기의 그리드로 나타낼 수 있다.
 *      2. 'X' => 땅, '.' => 바다
 *      3. 50년이 지나면 인접한 세 칸 OR 네 칸에 바다가 있는 땅은 모두 잠긴다.
 *      4. 50년 후의 지도를 그린다
 *      => 땅에 인접한 바다가 3, 4개 이면 해당 위치는 바다로 치환 => 즉 3개 이상이면 바다로 치환
 *      => 치환 스킨 그래프 배열 구해주고, X 기준으로 위치 배열 출력
 *
 * 출력:
 *      1. 50년 후 지도 출력
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R  = Integer.parseInt(st.nextToken());
        int C  = Integer.parseInt(st.nextToken());

        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};
        // 현재 배열
        char [][] map = new char[R][C];
        // 50년 후 배열
        char [][] nMap = new char[R][C];

        // 배열들 초기화, 초기값 세팅
        for(int i = 0; i < R; i++) Arrays.fill(nMap[i], '.');
        for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();

        // 출력 범위
        int minR = R;
        int maxR = -1;
        int minC = C;
        int maxC = -1;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'X'){
                    int cnt = 0;
                    for(int d = 0; d < 4; d++){
                        int x = i + dx[d];
                        int y = j + dy[d];
                        // 경계 검사
                        // 지도의 범위를 벗어나는 칸은 모두 바다이다.
                        if (x == - 1 || x == R || y == -1 || y == C || (map[x][y] == '.')) cnt ++;
                    }
                    // 50 년 후 x 로 바뀌기에 여기서 출력 범위 갱신
                    if(cnt < 3) {
                        nMap[i][j] = 'X';
                        minR = Math.min(minR, i);
                        maxR = Math.max(maxR, i);
                        minC = Math.min(minC, j);
                        maxC = Math.max(maxC, j);
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = minR; i <= maxR; i++){
            for(int j = minC; j <= maxC; j++){
                result.append(nMap[i][j]);
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
