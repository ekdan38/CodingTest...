import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1197 최소 스패닝 트리
 *
 * 입력:
 *      1. 첫 번째 줄 정점의 수 V (1 ~ 10,000) 간선의 수 E (1 ~ 100,000)
 *      2. 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 A, B, C => A,B 가 가중치 C로 연결
 *      (C는 음수 가능 절대값은 1,000,000을 넘지 않는다.)
 *
 * 문제 분석:
 *      1. 그래프가 주어졌을 때 최소 스패닝 트리를 구해야한다.
 *      (최소 스패닝 트리 = 주어진 그래프의 모든 정점을 연결하는 부분 그래프 중에서 그 가중치의 합이 "최소"인 트리)
 *      2. 크루스칼 알고리즘 사용
 *        1. 간선을 가중치 오름차순으로 정렬
 *        2. union-find 사용
 *
 * 출력:
 *      1. 최소 스패닝 트리의 가중치 출력
 *
 * */

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node> edges = new ArrayList<>();
        parent = new int[V + 1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Node(A, B, C));
        }

        // 가중치 기준 오름차순 정렬
        edges.sort(Comparator.comparing(n -> n.weight));

        // parent 초기화
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }
        // 크루스칼 알고리즘
        int totalWeight = 0;
        int edgeCnt = 0;

        for (Node edge : edges) {
            if(union(edge.start, edge.end)){
                totalWeight += edge.weight;
                edgeCnt++;
                // 트리 완성하면 종료
                if(edgeCnt == V - 1) break;
            }
        }

        bw.write(Integer.toString(totalWeight));
        bw.flush();
        br.close();
        bw.close();
    }
    // 부모 찾기
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // 두 집합 합치기
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false; // 이미 같은 집합에 속해 있음
    }


    static class Node {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}