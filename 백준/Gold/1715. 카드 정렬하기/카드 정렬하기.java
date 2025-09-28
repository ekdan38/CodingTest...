import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 작은 수 두개 먼저 더해주고 작은수를 꺼내서 다시 더해줘야한다.
        // 우선순위 큐 사용
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(N --> 0){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(pq.size() > 1){
            int mid = pq.poll() + pq.poll();
            result += mid;
            pq.offer(mid);
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}