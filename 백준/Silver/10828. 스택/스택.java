import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 10828 스택
         * 문제 분석: 스택 구현
         * 의사 결정: 스택 클래스 사용해서 풀어보자
         *
         * push X: 정수 X를 스택에 넣는 연산이다.
         * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         * size: 스택에 들어있는 정수의 개수를 출력한다.
         * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
         * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String command = br.readLine();

            //push 이면
            if(command.contains(" ")){
                int num = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                stack.push(num);
            }
            //다른 행위
            else{
                //pop
                if(command.equals("pop")){
                    if(stack.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.pop()).append("\n");
                }

                //size
                if(command.equals("size"))
                    sb.append(stack.size()).append("\n");

                //empty
                if(command.equals("empty")){
                    if(stack.empty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                }

                //top
                if(command.equals("top")){
                    if(stack.isEmpty())
                        sb.append(-1).append("\n");
                    else 
                        sb.append(stack.peek()).append("\n");
                }
            }


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}

