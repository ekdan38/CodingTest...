import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[6][6]; // 빙고 판
        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] marked = new int[6][6]; // 체크된 칸 표시
        int[] call = new int[26]; // 사회자가 부르는 숫자
        int index = 1;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                call[index++] = Integer.parseInt(st.nextToken());
            }
        }

        // 숫자를 하나씩 부르며 처리
        for (int n = 1; n <= 25; n++) {
            int num = call[n];

            // 해당 숫자를 찾아 체크
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    if (bingo[i][j] == num) {
                        marked[i][j] = 1; // 체크 표시
                    }
                }
            }

            // 빙고 카운트 계산
            int bingoCount = 0;

            // 가로 빙고 체크
            for (int i = 1; i <= 5; i++) {
                int rowCnt = 0;
                for (int j = 1; j <= 5; j++) {
                    if (marked[i][j] == 1) rowCnt++;
                }
                if (rowCnt == 5) bingoCount++;
            }

            // 세로 빙고 체크
            for (int j = 1; j <= 5; j++) {
                int colCnt = 0;
                for (int i = 1; i <= 5; i++) {
                    if (marked[i][j] == 1) colCnt++;
                }
                if (colCnt == 5) bingoCount++;
            }

            // 대각선 빙고 체크
            int diag1Cnt = 0, diag2Cnt = 0;
            for (int i = 1; i <= 5; i++) {
                if (marked[i][i] == 1) diag1Cnt++;
                if (marked[i][6 - i] == 1) diag2Cnt++;
            }
            if (diag1Cnt == 5) bingoCount++;
            if (diag2Cnt == 5) bingoCount++;

            // 빙고 3개 이상이면 결과 출력 후 종료
            if (bingoCount >= 3) {
                System.out.println(n);
                return;
            }
        }
    }
}
