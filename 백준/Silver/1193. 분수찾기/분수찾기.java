import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int group = 1;
        int range = 1;

        // N이 속한 대각선 그룹을 찾는다.
        while (N > range) {
            group++;
            range += group;
        }

        int position = N - (range - group); // 대각선 그룹 내의 위치

        if (group % 2 == 0) {
            // 짝수 그룹: 아래에서 위로
            System.out.print(position + "/" + (group - position + 1));
        } else {
            // 홀수 그룹: 위에서 아래로
            System.out.print((group - position + 1) + "/" + position);
        }
    }
}
