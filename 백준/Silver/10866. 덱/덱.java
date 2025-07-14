import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        while(N -- > 0){
            String command = br.readLine();
            if(command.startsWith("push")){
                String[] splited = command.split(" ");
                command = splited[0];
                int X = Integer.parseInt(splited[1]);

                if(command.equals("push_back")) deque.offerLast(X);
                else deque.offerFirst(X);
            }
            else{
                if(command.equals("pop_front"))
                    bw.write(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");

                else if(command.equals("pop_back"))
                    bw.write(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");

                else if(command.equals("size")) bw.write(deque.size() + "\n");

                else if(command.equals("empty"))
                    bw.write(deque.isEmpty() ? "1\n" : "0\n");

                else if(command.equals("front"))
                    bw.write(deque.isEmpty() ? "-1\n": deque.peekFirst() + "\n");

                else if(command.equals("back"))
                    bw.write(deque.isEmpty() ? "-1\n": deque.peekLast() + "\n");
            }
        }
        bw.flush();
    }
}