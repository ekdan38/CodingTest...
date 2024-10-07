import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        // 세 변 중 가장 큰 변을 찾음
        int max = Math.max(x, Math.max(y, z));
        int sum = x + y + z;

        // 삼각형을 만들 수 없는 경우 최대 변 조정
        if (sum - max <= max) {
            max = sum - max - 1;
        }

        // 최종 삼각형 둘레를 계산하고 출력
        int result = sum - Math.max(x, Math.max(y, z)) + max;
        System.out.println(result);
    }
}
