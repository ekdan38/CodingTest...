import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 13549 숨바꼭질 3
 *
 * 입력:
 *      1. 첫 번째 줄 수빈이가 있는 위치 N, 동생의 위치 K (둘다 정수)
 *
 * 문제 분석:
 *      1. 수빈이는 N 에 있고, 동생은 k에 있따. 수빈이는 2가지 동작이 가능하다.
 *          1. 걷기 => 1초 후에 X - 1 OR X + 1
 *          2. 순간이동 => 0초 후에 2 * X
 *      2. 수빈이가 동생을 찾는 가장 빠른 시간 구해야한다.
 *      => BFS 사용.
 *      => bfs 돌릴 때 2 * x , x - 1, x + 1 고려 => 시간도 고려.
 *      => 클래스 따로 만들까 말까.. 그냥 하자
 *
 * 출력:
 *      1. 수빈이가 동생을 찾는 가장 빠른 시간 출력
 * */

public class Main {
    static int N, K;
    static int result = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        boolean []visited = new boolean[100000 + 1];
        Queue<Node> queue = new LinkedList<>();
        // 시작은 위치 N, 최종 시간 0
        queue.offer(new Node(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int location = current.location;
            int time = current.time;

            // 종료 선언
            if(location == K) result = Math.min(result, time);

            // 경계, visited 체크
            // 1. 2 * X 이동 => 위치 값 * 2 해주고, 걸린 시간은 그대로 (0초 소요이기 때문)
            if(location * 2 <= 100000 && !visited[location * 2]) {
//                queue.offer(new int[]{location * 2, time});
                queue.offer(new Node(location * 2, time));
                visited[location * 2] = true;
            }
            // 3. X - 1 이동 => 위치 값 - 1 해주고, 걸린 시간은 +1
            if(location - 1 >= 0 && !visited[location - 1]) {
                queue.offer(new Node(location -1, time + 1));
                visited[location - 1] = true;
            }

            // 2. X + 1 이동 => 위치 값 + 1 해주고, 걸린 시간은 +1
            if(location + 1 <= 100000 && !visited[location + 1]) {
                queue.offer(new Node(location + 1, time + 1));
                visited[location + 1] = true;
            }

        }
    }
    static class Node{
        int location;
        int time;

        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }

        public int getTime() {
            return time;
        }
    }
}
