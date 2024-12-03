import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표 (사용하지 않음)
            int y = Integer.parseInt(st.nextToken()); // y 좌표 (고도)

            // 스택에서 고도가 감소할 경우, pop하며 직사각형 종료
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                cnt++;
            }

            // 새로운 고도 추가
            if (stack.isEmpty() || stack.peek() < y) {
                if (y > 0) { // 고도 0은 추가하지 않음
                    stack.push(y);
                }
            }
        }

        // 스택에 남아 있는 직사각형을 종료 처리
        while (!stack.isEmpty()) {
            stack.pop();
            cnt++;
        }

        System.out.println(cnt);
    }
}
