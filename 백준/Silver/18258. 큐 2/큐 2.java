import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Deque<Integer> queue = new LinkedList<>();

        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                if(queue.isEmpty()) sb.append("-1");
                else sb.append(queue.poll());
                sb.append("\n");
            }
            else if(command.equals("size")){
                sb.append(queue.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(queue.isEmpty()) sb.append(1);
                else sb.append("0");
                sb.append("\n");
            }
            else if(command.equals("front")){
                if(queue.isEmpty()) sb.append("-1");
                else sb.append(queue.peekFirst());
                sb.append("\n");
            }
            else if(command.equals("back")){
                if(queue.isEmpty()) sb.append("-1");
                else sb.append(queue.peekLast());
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}