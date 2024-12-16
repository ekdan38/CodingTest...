import java.io.*;
import java.util.*;

/**
 * 7662 이중 우선순위 큐
 * <p>
 * 입력:
 * 1. 첫째 줄에 테스트 케이스 T
 * 2. 이후 테스트 케이스마다 연산 횟수 K 와 테스트 케이스들
 * 3. I N => q에 N 삽입, D 1 => q에서 최댓값 삭제, D -1 은 최솟값 삭제
 * <p>
 * <p>
 * 문제 분석:
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    // 삽입 해줘야한다.
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else if (command.equals("D")) {
                    // 삭제
                    if (!treeMap.isEmpty()) {
                        int key = (num == 1) ? treeMap.lastKey() : treeMap.firstKey();
                        // 최댓값 또는 최솟값 삭제
                        if (treeMap.get(key) == 1) treeMap.remove(key);
                        else treeMap.put(key, treeMap.get(key) - 1);

                    }
                }
            }

            // 결과 출력
            if (treeMap.isEmpty())  sb.append("EMPTY").append("\n");
            else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");

        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}