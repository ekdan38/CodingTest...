/*
    문제
        1. 일직선 상의 공간에 N개의 샘터 존재, K채의 짓을 지어야함.(위치는 모두 정수)
        2. 일직선 상의 공간에 N개의 샘터 및 K채의 집들은 모두 다른 위치에 존재
        (어떤한 위치에는 샘터 or 집 or Nothing)
        3. 집을 지을때 가능한 샘터 근처에 지어서 K채의 모드 집에 대한 불행도 합 최소
        (불행도 = 가장 가까운 샘터까지의 거리 -> 집과 샘터가 가까울수록 적다)
    입력
        1. 첫째 줄 N, K  (1 ≤ N, K ≤ 100,000)
        2. 둘째 줄 N개의 샘터 주어진다. (-100,000,000 ≤ 샘터의 위치 ≤ 100,000,000)
    출력
        1. 모드 집에대한 불행도 최소 값
    풀이
        1. 결국 샘터 기준 좌우로 탐색하면서 가까운곳부터 집을 지어야한다. -> BFS탐색

*/
import java.util.*;
import java.io.*;
public class Main{
    static Queue<Node> queue = new LinkedList<>();
    static Set<Integer> visited = new HashSet<>();
    static int N, K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while(N --> 0){
            int input = Integer.parseInt(st.nextToken());
            queue.offer(new Node(input, 0));
            visited.add(input);
        }

        long result = bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static long bfs(){
        int cnt = 0;
        long bad = 0;
        int[] dx = {-1, 1};

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int cidx = current.idx;
            int cd = current.dis;
//            if(cnt == K) return bad;

            for(int i = 0; i < 2; i++){
                int n = cidx + dx[i];

                if(!visited.contains(n)){
                    queue.offer(new Node(n, cd + 1));
                    visited.add(n);
                    cnt++;
                    bad += cd + 1;
                    if(cnt == K) return bad;
                }
            }
        }
        return bad;
    }
    static class Node{
        int idx;
        int dis;
        public Node(int idx, int dis){
            this.idx = idx;
            this.dis = dis;
        }
    }
}