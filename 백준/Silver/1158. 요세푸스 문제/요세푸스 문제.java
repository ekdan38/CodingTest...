import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }
        sb.append("<");

        while(!queue.isEmpty()){
            for(int i = 0; i < K; i++){
                if(i < K - 1) queue.offer(queue.poll());
                else {
                    sb.append(queue.poll());
                    if(!queue.isEmpty()) sb.append(", ");
                }
            }
        }

        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
    }
}