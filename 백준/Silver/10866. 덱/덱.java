import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 10866 덱(deque)
         * 덱 선언하고,
         * push_front X: 정수 X를 덱의 앞에 넣는다.
         * push_back X: 정수 X를 덱의 뒤에 넣는다.
         * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         * size: 덱에 들어있는 정수의 개수를 출력한다.
         * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
         * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         * 처리하면 된다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = "";
            int num = 0;

            // push 이면
            if(st.countTokens() == 2){
                command = st.nextToken();
                num = Integer.parseInt(st.nextToken());
                // push_front
                if(command.equals("push_front")){
                    deque.offerFirst(num);
                }
                // push_back
                else if(command.equals("push_back")){
                    deque.offerLast(num);
                }
            }
            // push가 아니면
            else{
                command = st.nextToken();
                // pop_front, pop_back, front, back 처리
                if (command.contains("pop") || command.contains("front") || command.contains("back")){
                    // 비어 있으면 -1 
                    if(deque.isEmpty()){
                        bw.write(-1  + "\n");
                    }
                    else{
                        if(command.equals("pop_front")){
                            bw.write(deque.removeFirst() + "\n");
                        }
                        else if (command.equals("pop_back")) {
                            bw.write(deque.removeLast() + "\n");
                        }
                        else if(command.equals("front")){
                            bw.write(deque.getFirst() + "\n");
                        }
                        else if (command.equals("back")) {
                            bw.write(deque.getLast() + "\n");
                        }
                    }
                }
                // size
                else if (command.equals("size")) {
                    bw.write(deque.size() + "\n");
                }
                
                //empty
                else if(command.equals("empty")){
                    if (deque.isEmpty()){
                        bw.write(1 + "\n");
                    }
                    else {
                        bw.write(0 + "\n");
                    }
                }

            }
        }
        bw.flush();
        bw.close();
    }
}

