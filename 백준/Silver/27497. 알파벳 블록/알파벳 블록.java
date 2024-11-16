import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 27497 알파벳 블록
         * deque와 stack을 통해 풀면 간단하다.
         * deque에는 button에 따라서 앞, 뒤에 값을 삽입해주고
         * stack에는 button 값을 삽입해주고 3이 입력되면
         * stack에서 pop, deque에서 해당하는 방향에 있는 녀석을 지워준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<String> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 버튼, 알파벳 같이 입력되면(1, 2)
            if(st.countTokens() == 2){
                int button = Integer.parseInt(st.nextToken());
                String str = st.nextToken();

                // 맨 뒤에
                if(button == 1){
                    deque.offerLast(str);
                    stack.push(button);
                }
                // 맨 앞에
                else if(button == 2){
                    deque.offerFirst(str);
                    stack.push(button);
                }
            }
            // 버튼 값만 입력되면(3)
            else{
                if(!stack.isEmpty()){
                    Integer pop = stack.pop();
                    // stack에 값이 1이면
                    if(pop == 1){
                        deque.removeLast();
                    }
                    // stack에 값이 2이면
                    else if(pop == 2){
                        deque.removeFirst();
                    }
                }
            }
        }

        // deque가 비어있다면 0 출력
        if(deque.isEmpty()){
            bw.write("0");
        }
        // deque에 값이 있다면 전체 출력
        else{
            for (String s : deque) {
                bw.write(s);
            }
        }

        bw.flush();
        bw.close();
    }
}

