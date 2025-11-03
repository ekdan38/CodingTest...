import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();

            if(n > 0){
                String[] arr = input.substring(1, input.length() - 1).split(",");
                for(String s : arr){
                    deque.offer(Integer.parseInt(s));
                }
            }

            boolean isReverse = false;
            boolean isError = false;

            for(int i = 0; i < p.length(); i++){
                char c = p.charAt(i);
                if(c == 'R') isReverse = !isReverse;
                else if(c == 'D'){
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    else{
                        if(isReverse) deque.pollLast();
                        else deque.pollFirst();
                    }
                }
            }
            if(isError) sb.append("error").append("\n");
            else {
                sb.append("[");
                if(isReverse){
                    while(!deque.isEmpty()){
                        sb.append(deque.pollLast());
                        if(deque.size() > 0) sb.append(",");
                    }
                }
                else{
                    while(!deque.isEmpty()){
                        sb.append(deque.pollFirst());
                        if(deque.size() > 0) sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
    }
}