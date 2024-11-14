import java.io.*;
import java.util.*;

public class Main {
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        /**
         * 1072 Z
         *
         * 2차원 배열의 크기가  2^N * 2^N 이고 범위가 1 ≤ N ≤ 15 로 방대하다.
         * 반복문으로 접근해 봤지만 값을 찾기에는 어렵다. (제한 시간 0.5초) 최적화 해야한다.
         *
         * .. 재귀 함수를 통해서 찾아야하는 (r,c)위치를 찾는다.
         * 사분면으로 나누고 배열의 사이즈를 반으로 나누면서
         * 재귀함수를 돌리면 최종적으로 1 x 1 배열이 되었을때 4분면 중 하나의 분면이 (r,c)의 위치 값이다.
         * 그러기 위해선 재귀 함수를 돌릴때마다 해당 분면의 시작 위치의 값을 더해준다. == cnt
         * 시작 위치의 값은 2사분면 의 (0,0)을 기준으로 다음과 같은 규칙이 있다.
         * 또한 r,c 의 값도 연산 해줘야 한다.
         *
         * (size = 2^N * 2^N / 2)
         * 2사 분면 조건 : r < size/2 , c >= size/2
         * 2사 분면 : size * size / 2 + cnt; r = r;  c = c - size / 2;
         *
         * 1사 분면 조건 : r < size/2 , c < size/2
         * 1사 분면 : cnt; r = r; c = c;
         *
         * 3사 분면 조건 : r => size/2, c < size/2
         * 3사 분면 : (size * size / 2) * 2 + cnt; r = r - size /2; c = c;
         *
         * 4사 분면 조건 : r => size/2, c >= size/2
         * 4사 분면 : (size * size / 2) * 3 + cnt; r = r - size /2; c = c - size /2;
         *
         * => 최종적으로 1 x 1 배열이 되었을때 어느 분면에 속해있는지와 누적된 시작 위치의 값을 더해주면 된다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sb.nextToken());
        int r = Integer.parseInt(sb.nextToken());
        int c = Integer.parseInt(sb.nextToken());

        int size = (int) Math.pow(2, N);

        // 재귀함수 돌릴때마다 해당 분면의 시작 위치의 값을 더해준다.

        search(size, r, c);
        System.out.println(cnt);

    }

    private static void search(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        // 2사분면
        if (r < size/2 && c >= size/2) {
            cnt += (int) Math.pow(size, 2) / 4;
            search(size/2, r, c - size/2);
        }
        // 1사분면
        else if (r < size/2 && c < size/2) {
            search(size/2, r, c);
        }
        // 3사분면
        else if (r >= size/2 && c < size/2){
            cnt += ((int) Math.pow(size, 2) / 4) * 2;
            search(size/2, r - size/2, c);
        }
        // 4사분면
        else{
            cnt += ((int) Math.pow(size, 2) / 4) * 3;
            search(size/2, r - size/2, c - size/2);
        }

    }


}

