import java.io.*;
import java.util.*;

/**
 * 18352 특정 거리의 도시 찾기
 * 입력:
 *      1. 첫째 줄 N (2 ~ 300,000), M (1 ~ 1,000,000), K (1 ~ 300,000), X (1 ~ N)
 *      2. 둘째 줄 M개의 줄에 걸쳐서 서로 다른 두 개의 자연수 A, B (1 ~ N)
 *문제 분석:
 *
 *
 * 출력:
 *      1. X부터 출발하여 도달 할 수 있는 도시 중에서
 */

public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean [] visited;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        cnt = new int[N];

        graph = new ArrayList<>(N);

        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A - 1).add(B);
        }

        bfs(X);

        boolean isNoCity = false;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == K){
                sb.append(i + 1).append("\n");
                isNoCity = true;
            }
        }

        if(!isNoCity){
            sb.append(-1).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static void bfs(int start){
        // 전역 변수로 선언 안하고 여기서 하는게 좋을 듯 싶다.
        // 굳이 전역 변수 선언할 필요가 없었다.
        Queue<Integer> queue = new LinkedList<>();
        visited[start - 1] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            Integer currentCity = queue.poll() - 1;
            int size = graph.get(currentCity).size();
            for(int i = 0; i < size; i++){
                Integer nextCity = graph.get(currentCity).get(i);
                //우선 방문한 적 없으면 진행
                if(!visited[nextCity - 1]){
                    visited[nextCity - 1] = true;
                    cnt[nextCity - 1] = cnt[currentCity] + 1;
                    queue.add(nextCity);
                }
            }
        }

    }



}
