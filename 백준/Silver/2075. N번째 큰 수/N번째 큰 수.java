/**
 1. 우선 순위 큐 사용
 2. treeSet 사용
 */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        while(N -- > 0){
            if(N == 0) bw.write(String.valueOf(pq.poll()));
            else pq.poll();
        }
        bw.flush();

    }
}