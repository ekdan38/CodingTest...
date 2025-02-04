
import java.io.*;
import java.util.*;

/**
 * 4396 지뢰 찾기
 *
 * 입력:
 *      1. 첫 번째 줄에는 10보다 작거나 같은 양의 정수 n이 입력된다.
 *      2. 다음 n개의 줄은 지뢰의 위치를 나타낸다. (. 지뢰 x, * 지뢰)
 *      3. 다음 n개의 줄에는 길이가 n인 문자열이 입력된다. (x 열린칸, . 열리지 않은 칸)
 * 문제 분석:
 *      1. 지뢰 필드, 사용자가 입력한 필드 주어짐.
 *      2. 사용자가 열은 칸이 . 면 8방향에 지뢰 개수 확인
 *      3. 사용자가 열은 칸이 * 면 모든 지뢰 출력
 *
 * 출력:
 *
 * */

public class Main {
        static int N;
        static boolean isMine = false;
        static char[][] mineField;
        static char[][] userField;
        static char[][] resultField;
        static int[] dx = {-1, -1 ,-1, 0, 0, 1, 1, 1};
        static int[] dy = {-1, 0 ,1, -1, 1, -1, 0, 1};
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            mineField = new char[N][N];
            userField = new char[N][N];
            resultField = new char[N][N];

            for(int i = 0; i < N; i++){
                mineField[i] = br.readLine().toCharArray();
            }

            for(int i = 0; i < N; i++){
                userField[i] = br.readLine().toCharArray();
            }


            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(userField[i][j] == 'x'){
                        // 사용자가 연 칸이 지뢰면
                        if(mineField[i][j] == '*') isMine = true;
                        // 사용자가 연 칸이 지뢰가 아니면 8방향에 지뢰 개수
                        else resultField[i][j] = (char) ('0' + searchMines(i, j));
                    }
                    else resultField[i][j] = '.';
                }
            }
            // 지뢰 밟았으면 지뢰 위치 표시
            if(isMine) findMinesAndFillField();

            StringBuilder result = new StringBuilder();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    result.append(resultField[i][j]);
                }
                result.append("\n");
            }

            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }
        static int searchMines(int x, int y){
            int cnt = 0;
            for(int i = 0; i < 8; i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                // 경계 범위 확인, 지뢰 있는지 확인
                if(mx >= 0 && mx < N && my < N && my >= 0 && mineField[mx][my] == '*') cnt++;
            }
            return cnt;
        }

        static void findMinesAndFillField(){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(mineField[i][j] == '*') resultField[i][j] = '*';
                }
            }
        }
    }
