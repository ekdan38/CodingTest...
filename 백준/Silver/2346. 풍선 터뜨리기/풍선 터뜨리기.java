import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        Balloon currentBalloon = deque.pollFirst();
        int num = currentBalloon.num;
        int paper = currentBalloon.paper;
        sb.append(num).append(" ");

        while(!deque.isEmpty()){
            if(deque.size() == 1) num = deque.poll().num;
            
            else if(deque.isEmpty()) break;
            
            else if(paper > 0){
                for(int i = 0; i < paper - 1; i++){
                    deque.offerLast(deque.pollFirst());
                }
                currentBalloon = deque.pollFirst();
                num = currentBalloon.num;
                paper = currentBalloon.paper;
            }
            else if(paper < 0){
                for(int i = 0; i > paper + 1; i--){
                    deque.offerFirst(deque.pollLast());
                }
                currentBalloon = deque.pollLast();
                num = currentBalloon.num;
                paper = currentBalloon.paper;
            }
            sb.append(num).append(" ");

        }
        bw.write(sb.toString());
        bw.flush();
    }
    static class Balloon{
        int num;
        int paper;
        Balloon(int num, int paper){
            this.num = num;
            this.paper = paper;
        }
    }
}