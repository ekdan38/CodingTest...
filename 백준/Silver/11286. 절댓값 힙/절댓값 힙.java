import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // X 가 0이면 절대값이 가장 작은 값 출력 후 제거
        // X 가 0이 아니라면 배열에 넣는 연산
        // 출력은 절댓값 가장 작은값 (절대값 작은게 여러개면 가장 ㅇ작은 수 출력)

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)){
                return Integer.compare(a, b);
            }
            return Integer.compare(Math.abs(a), Math.abs(b));
        });

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while(N --> 0){
            int commend = Integer.parseInt(br.readLine());
            if(commend == 0){
                if(pq.isEmpty()) sb.append("0");
                else sb.append(pq.poll());
                sb.append("\n");
            }
            else{
                pq.offer(commend);
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }
}