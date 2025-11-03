import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Long> pq = new PriorityQueue<>((o1, o2) -> {
            long absO1 = Math.abs(o1);
            long absO2 = Math.abs(o2);
            if(absO1 == absO2){
                return Long.compare(o1, o2);
            }
            return Long.compare(absO1, absO2);
        });

        int N = Integer.parseInt(br.readLine());
        while(N --> 0){
            long x = Long.parseLong(br.readLine());
            if(x == 0){
                if(pq.isEmpty()) sb.append("0");
                else sb.append(pq.poll());
                sb.append("\n");
            }
            else pq.offer(x);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}