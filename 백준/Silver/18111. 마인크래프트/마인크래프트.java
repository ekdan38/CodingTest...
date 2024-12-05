import java.io.*;
import java.util.*;

public class Main {
    static int initialB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로
        int N = Integer.parseInt(st.nextToken());
        // 가로
        int M = Integer.parseInt(st.nextToken());
        // 인벤토리 블록 수
        initialB = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int max = -1;
        int min = 257;

        // 땅의 높이 입력 및 최대, 최소 높이 계산
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                arr[i][j] = height;
                max = Math.max(max, height);
                min = Math.min(min, height);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int optimalHeight = -1;

        // 가능한 모든 높이에 대해 탐색 (min부터 max까지)
        for (int targetHeight = min; targetHeight <= max; targetHeight++) {
            int time = 0;
            int inventory = initialB;

            // 각 위치에 대해 블록 작업 수행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int currentHeight = arr[i][j];

                    if (currentHeight > targetHeight) {
                        // 블록 제거 (블록을 인벤토리에 넣음)
                        int removeBlocks = currentHeight - targetHeight;
                        time += removeBlocks * 2;
                        inventory += removeBlocks;
                    } else if (currentHeight < targetHeight) {
                        // 블록 추가 (인벤토리에서 블록을 꺼내서 놓음)
                        int addBlocks = targetHeight - currentHeight;
                        time += addBlocks;
                        inventory -= addBlocks;
                    }
                }
            }

            // 블록이 부족하면 해당 목표 높이는 만들 수 없음
            if (inventory < 0) {
                continue;
            }

            // 최소 시간과 가장 높은 목표 높이 선택
            if (time < minTime || (time == minTime && targetHeight > optimalHeight)) {
                minTime = time;
                optimalHeight = targetHeight;
            }
        }

        // 결과 출력
        bw.write(minTime + " " + optimalHeight);
        bw.flush();
        br.close();
        bw.close();
    }
}
