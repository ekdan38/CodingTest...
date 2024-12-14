import java.io.*;
import java.util.*;

/**
 * 18258 큐 2
 *
 * 입력:
 *      1. 첫째 줄에 명령의 수 N (1 ~ 2,000,000)
 *      2. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. (1 ~ 100,000)
 *
 *문제 분석:
 *
 *
 *  출력:

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();


        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // push 라는 의미
            String command = st.nextToken();
            if(command.equals("push")) queue.offer(Integer.parseInt(st.nextToken()));
            else{
                if(command.equals("pop")){
                    if(queue.isEmpty()) result.append(-1).append("\n");
                    else result.append(queue.poll()).append("\n");
                }
                else if (command.equals("size")) result.append(queue.size()).append("\n");

                else if (command.equals("empty")){
                    if (queue.isEmpty()) result.append(1).append("\n");
                    else result.append(0).append("\n");
                }

                else if(command.equals("front")){
                    if (queue.isEmpty()) result.append(-1).append("\n");
                    else result.append(queue.peek()).append("\n");
                }

                else if(command.equals("back")){
                    if (queue.isEmpty()) result.append(-1).append("\n");
                    else result.append(queue.peekLast()).append("\n");
                }
            }
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}