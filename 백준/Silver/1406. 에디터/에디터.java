import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 1406 에디터
         * 문제 분석: 문자열이 주어지고 명령어에 따라 커서를 조정하고 삭제, 추가
         * 의사 결정: 스택으로 간단하게 풀 수 있다.
         *          커서의 위치가 중요하다 최초의 커서는 문장의 맨 뒤!
         *          스택 2개를 사용해서 커서의 위치를 적용해보자
         *
         * L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
         * D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
         * B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
         *      삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
         * P $	$라는 문자를 커서 왼쪽에 추가함
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();

        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            stackA.push(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String command = br.readLine();

            //P
            if(command.contains(" ")){
                char c = command.charAt(command.length() - 1);
                stackA.push(c);
            }

            else{
                //L
                if(command.equals("L") && !stackA.isEmpty())
                    stackB.push(stackA.pop());

                //D
                else if(command.equals("D") && !stackB.isEmpty())
                    stackA.push(stackB.pop());

                //B
                else if(command.equals("B") && !stackA.isEmpty())
                    stackA.pop();
            }
        }

        for (Character c : stackA) {
            sbA.append(c);
        }
        for (Character c : stackB) {
            sbB.append(c);
        }
        sbB.reverse();

        bw.write(sbA.toString() + sbB.toString());
        bw.flush();
        bw.close();
    }

}

