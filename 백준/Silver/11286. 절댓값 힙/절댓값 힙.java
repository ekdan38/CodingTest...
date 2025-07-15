import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)) return Integer.compare(a,b);
            return Integer.compare(Math.abs(a), Math.abs(b));
        });
        int N = Integer.parseInt(br.readLine());

        while(N -- > 0){
            int command = Integer.parseInt(br.readLine());
            if(command == 0){
                if(pq.isEmpty()) sb.append("0");
                else sb.append(pq.poll());
                sb.append("\n");
            }
            else pq.offer(command);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}