import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // targetIdx 보다 deque.size()가 더 작으면...
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            deque.add(i);
        }

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        while(M --> 0){
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = deque.indexOf(target);
            int midSize = deque.size() / 2;

            if(targetIdx <= midSize){
                while(deque.peek() != target){
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            }
            else{
                while(deque.peek() != target){
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        bw.write(String.valueOf(cnt));
        bw.flush();

    }
}
