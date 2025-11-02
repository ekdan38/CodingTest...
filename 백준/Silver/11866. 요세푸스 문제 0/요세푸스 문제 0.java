import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int i = 1; i <= K; i++){
                if(i == K) list.add(queue.poll());
                else queue.offer(queue.poll());
            }
        }

        sb.append("<");
        for(int i = 0; i < list.size(); i++){
            if(i == 0) sb.append(list.get(i));
            else sb.append(", ").append(list.get(i));
        }
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
    }
}