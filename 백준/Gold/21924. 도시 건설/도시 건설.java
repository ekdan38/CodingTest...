
import java.io.*;
import java.util.*;

/**
 * 21924 도시 건설
 *
 * 입력:
 *      1. 첫째 줄 건물의 개수 N, 도로의 개수 M
 *      2. 둘째 줄 M + 1 까지 건물의 번호 a, b  두 건물 사이 도로를 만들 때 드는 비용 c 가 주어진다.(같은 쌍의 건물을 연결하는 도로는 주어지지 않음)
 *
 * 문제 분석:
 *      1. 모든 건물이 연결 되어야 하지만 최소 비용이 들어야 한다. => MST => 크루스칼
 *
 * 출력:
 *      1. 절약 되는 비용 출력
 *
 * */

public class Main {
    static int N, M;
    static int[] parent;
    static PriorityQueue<Building> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
    static long totalCost = 0;
    static int edgeCnt = 0;
    static long kruskalCost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // parent 배열 초기화
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Building(a, b, cost));
            totalCost += cost;
        }

        kruskal();

        if(edgeCnt != N - 1)bw.write(Integer.toString(-1));
        else bw.write(Long.toString(totalCost - kruskalCost));

        bw.flush();
        br.close();
        bw.close();
    }
    static void kruskal(){
        while(edgeCnt < N - 1 && !pq.isEmpty()){
            Building current = pq.poll();
            if(union(current.a, current.b)){
                edgeCnt ++;
                kruskalCost += current.cost;
            }
        }
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        // 대표 노드 다르면 연결
        if(a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }

    static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static class Building{
        int a;
        int b;
        int cost;

        public Building(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
