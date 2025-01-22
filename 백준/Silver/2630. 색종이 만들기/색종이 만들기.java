import java.io.*;
import java.util.*;

/**
 * 2630 색종이 만들기
 *
 * 입력:
 *      1. 첫째 줄 전체 종이의 한변의 길이 N (N은 2, 4, 8, 16, 32, 64, 128 중 하나이다.)
 *      2. 둘째 줄 부터 N * N 색이 주어진다. (0 == white, 1 == blue)
 * 문제 분석:
 *      1. 주어진 N * N 종이를 자른다.
 *      => 종이 전체가 같은 색이 아니면, 가로, 세로 중간 부분 잘라서 4개로 나눈다. (4사분면)
 *      => 자른 종이의 전체가 같은 색이 아니면 이 과정 반복  => 재귀 사용
 *
 *
 * 출력:
 *      1. 하얀색 종이, 파란색 종이 수
 *
 * */

public class Main {
        static int [][] arr;
        static int blueCnt = 0;
        static int whiteCnt = 0;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            divide(0, 0, N);

            bw.write(whiteCnt + "\n" + blueCnt);
            bw.flush();
            br.close();
            bw.close();
        }
        static void divide(int row, int col, int size){
            if(!validateColor(row, col, size)){
                size /= 2;
                divide(row, col + size, size);
                divide(row, col, size);
                divide(row + size, col + size, size);
                divide(row + size, col, size);
            }
        }

    // 전체가 white Or blue => cnt ++;
    static boolean validateColor(int row, int col, int size){
            int sum = 0;
            for (int i = row; i < size + row; i++){
                for(int j = col; j < size + col; j++){
                    sum += arr[i][j];
                }
            }
            if(sum == 0) {
                whiteCnt++;
                return true;
            }
            else if(sum == size * size) {
                blueCnt++;
                return true;
            }
            else return false;
        }

    }
