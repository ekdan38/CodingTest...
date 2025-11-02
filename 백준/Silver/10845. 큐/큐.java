import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        while(N --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                deque.offer(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                if(deque.isEmpty()) sb.append("-1");
                else sb.append(deque.poll());
                sb.append("\n");
            }
            else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(deque.isEmpty()) sb.append("1");
                else sb.append("0");
                sb.append("\n");
            }
            else if(command.equals("front")){
                if(deque.isEmpty()) sb.append("-1");
                else sb.append(deque.peekFirst());
                sb.append("\n");
            }
            else if(command.equals("back")){
                if(deque.isEmpty()) sb.append("-1");
                else sb.append(deque.peekLast());
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}