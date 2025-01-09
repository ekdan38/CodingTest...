import java.io.*;
import java.util.*;

/**
 * 14675 단절점과 단절선
 *
 * 입력:
 *      1. 입력의 첫 줄에는 트리의 정점 개수 N이 주어진다. (2 ≤ N ≤ 100,000), 트리의 정점은 1번부터 n번까지 존재한다.
 *      2. 다음 줄부터 N-1개의 줄에 걸쳐 간선의 정보 a, b가 주어진다. 이는 a정점과 b정점이 연결되어 있다는 뜻이며,
 *      입력으로 주어지는 정보는 트리임이 보장된다. (1 ≤ a, b ≤ N)
 *      3. 다음 줄에는 질의의 개수 q가 주어진다. (1 ≤ q ≤ 100,000) 다음 q줄에는 질의 t k가 주어진다. (1 ≤ t ≤ 2)
 *      4. t가 1일 때는 k번 정점이 단절점인지에 대한 질의, t가 2일 때는 입력에서 주어지는 k번째 간선이 단절선인지에 대한 질의이다. t가 1일 때는 (1 ≤ k ≤ n)이며, t가 2일 때는 (1 ≤ k ≤ n - 1)이다.
 * 문제 분석:
 *      1. 트리 정점 개수 -1 만큼 간선 정보 입력받고, 질의 수 q 만큼 질의 처리
 *      => t == 1, k 번 정점이 단절점인지, t == 2, k 번째 간선이 단절선인지
 *      2. 단절점(cut vertex) : 해당 정점을 제거하였을 때, 그 정점이 포함된 그래프가 2개 이상으로 나뉘는 경우, 이 정점을 단절점이라 한다.
 *         단절선(bridge) : 해당 간선을 제거하였을 때, 그 간선이 포함된 그래프가 2개 이상으로 나뉘는 경우, 이 간선을 단절선이라 한다.
 *
 *      => 양방향 그래프로 만들어 둔다.
 *      단절점을 찾을 때는 해당 노드의 size가 1 이상인지 확인 => 양방향 만족하면 무조건 단절점이다.
 *      단절선은 간선 제거하면 무조건 그래프가 2개로 나뉘어 진다.
 *      정리 : 단절점만 확인해주면 된다.
 * 출력:
 *      1. 각 질의 결과에 따라 "yes" or "no"
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // node
            int N = Integer.parseInt(br.readLine());
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < N - 1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            // 질의 수
            int Q = Integer.parseInt(br.readLine());

            StringBuilder result = new StringBuilder();
            for(int i = 0; i < Q; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                if(t == 1){
                    // 양방향 만족하면 무조건 단절점
                    if(graph.get(k).size() > 1) result.append("yes").append("\n");
                    else result.append("no").append("\n");
                }
                else{
                    // 간선 제거하면 무조건 그래프가 나누어진다.
                    result.append("yes").append("\n");
                }
            }
            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }

    }