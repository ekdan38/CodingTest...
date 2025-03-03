import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 예제 입력(직접 입력해서 테스트 가능)
        // 7 3
        // 1 2 3 2 4 2 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄: N, X
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        // 둘째 줄: N일 간의 방문자 수
        st = new StringTokenizer(br.readLine());
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            visited[i] = Integer.parseInt(st.nextToken());
        }

        // 1) 초기 윈도우 합(X일)
        long windowSum = 0;
        for (int i = 0; i < X; i++) {
            windowSum += visited[i];
        }

        long maxValue = windowSum; // 최대 합
        int count = 1;             // 최대 합을 가진 구간의 개수

        // 2) 윈도우를 슬라이드(오른쪽 이동)
        for (int start = 1; start <= N - X; start++) {
            windowSum = windowSum - visited[start - 1] + visited[start + X - 1];

            if (windowSum > maxValue) {
                maxValue = windowSum;
                count = 1;
            } else if (windowSum == maxValue) {
                count++;
            }
        }

        // 3) 결과 출력
        if (maxValue == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxValue);
            System.out.println(count);
        }

        br.close();
    }
}
