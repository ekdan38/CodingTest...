import java.io.*;
import java.util.*;

/**
 * 1697 숨바꼭질
 * 입력:
 *      1. 수빈이 위치 N (0 ~ 100,000), 동생 위치 K(0 ~ 100,000)
 *문제 분석:
 *      1. 수빈이는 걷거나 순간이동 가능 (x -1) or (x + 1) or (2 * x)
 *      2. 수빈이가 동생까지 최단거리 (초)
 *      3. bfs로 풀자

 * 출력:
 *      1. 수빈이가 동생까지 죄단거리 (초) 출력
 */

public class Main {
    static int N, K;
    static int[] dx = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int bfs = bfs(N);

        System.out.println(bfs);


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        //index N부터 시작
        //visited 범위 최대값으로 고정 N이나 K로 주면 안됨
        boolean[] visited = new boolean[100001];
        queue.offer(start);
        visited[start] = true;

        int cnt = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer current = queue.poll();
                if(current == K){
                    return cnt;
                }
                for(int j = 0; j < 3; j++){
                    int next;
                    //걷기 (+1, -1)
                    if(j != 2){
                        next = current + dx[j];
                    }
                    //순간이동 (*2)
                    else{
                        next = current * dx[j];
                    }
                    if(next >= 0 && next <= 100000 && !visited[next]){
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        cnt++;
        }
        return -1;
    }


}