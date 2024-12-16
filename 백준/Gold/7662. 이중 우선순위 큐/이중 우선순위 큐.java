import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine()); // 연산 횟수
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    // 삽입 연산
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else if (command.equals("D")) {
                    // 삭제 연산
                    if (!treeMap.isEmpty()) {
                        int key = (num == 1) ? treeMap.lastKey() : treeMap.firstKey();
                        // 최댓값 또는 최솟값 삭제
                        if (treeMap.get(key) == 1) {
                            treeMap.remove(key);
                        } else {
                            treeMap.put(key, treeMap.get(key) - 1);
                        }
                    }
                }
            }

            // 결과 출력
            if (treeMap.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
