import java.io.*;
import java.util.*;

/**
 * 14567 선수과목
 *
 * 입력:
 *      1. 첫 번째 줄에 과목의 수 N(1 ≤ N ≤ 1000)과 선수 조건의 수 M(0 ≤ M ≤ 500000)이 주어진다.
 *      2. 선수과목 조건은 M개의 줄에 걸쳐 한 줄에 정수 A B 형태로 주어진다. A번 과목이 B번 과목의 선수과목이다.
 *      A < B인 입력만 주어진다. (1 ≤ A < B ≤ N)
 * 문제 분석:
 *      1. 조건 1. 한 학기에 들을 수 있는 과목 수에는 제한이 없다.
 *         조건 2. 모든 과목은 매 학기 항상 개설된다.
 * 출력:
 *      1. 1번 과목부터 N번 과목까지 차례대로 최소 몇 학기에 이수할 수 있는지를 한 줄에 공백으로 구분하여 출력한다.
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 진입 차수 배열 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }
            // 진입 차수 배열
            int [] inDegree = new int[N + 1];
            // 과목 이수할 수 있는 최소 학기 저장에 사용할 배열
            int [] 학기 = new int[N + 1];

            // A를 들어야 B를 들을 수 있다.
            // a -> b 로 간선 설정
            // 이후 b에 대한 진입 차수 증가
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                graph.get(A).add(B);
                inDegree[B]++;
            }

            // 위상 정렬 시작
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    학기[i] = 1;
                }
            }
            while(!queue.isEmpty()){
                // 현재 과목
                int current = queue.poll();
                for(int next : graph.get(current)){
                    // B에 대한 진입 차수 감소
                    inDegree[next] --;
                    // 진입 차수 0이 되면 queue 에 추가
                    if(inDegree[next] == 0){
                        queue.offer(next);
                        // 현재 과목 학기 + 1 처리 하면 B에 대한 과목 들을 수 있다.
                        학기[next] = 학기[current] + 1;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                result.append(학기[i]).append(" ");
            }
            
            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }

    }