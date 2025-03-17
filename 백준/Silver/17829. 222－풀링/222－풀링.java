import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 17829 222_폴링
 *
 * 입력:
 *      1. 첫째 줄 N (2 ~ 1024) N은 2의 거듭 제곱 n^k (1 ~ k ~ 10)
 *      2. 다음 N개의 줄마다 각 행의 원소 가 주어진다. n * n
 *
 *
 * 문제 분석:
 *      1. 주어지는 행렬 2x2 로 쪼개면서 두번째 큰 수 찾아서 또 모아서 2x2 반복
 *      => 재귀
 * 출력:
 *      1.
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(Integer.toString(solve(N, arr)));
        bw.flush();
        bw.close();
        br.close();
    }
    static int solve(int size, int [][] arr){
        while(size > 1){
            int newSize = size / 2;
            int [][] halfArr = new int[newSize][newSize];

            for(int i = 0; i < newSize; i++) {
                for(int j = 0; j < newSize; j++){
                    // 2x2 배열 만들고 값 넣는다. 여기서 두번째 큰 값 찾아야 함
                    // => 굳이 2x2 를 만들어야 할까 1차원 배열에서 두번째 값 골라도 된다.
                    int [] twoArr = new int [4];
                    twoArr[0] = arr[2 * i][2 * j];
                    twoArr[1] = arr[2 * i + 1][2 * j];
                    twoArr[2] = arr[2 * i][2 * j + 1];
                    twoArr[3] = arr[2 * i + 1][2 * j + 1];
                    Arrays.sort(twoArr);
                    halfArr[i][j] = twoArr[2];
                }
            }
            arr = halfArr;  // 새 배열을 arr에 할당
            size = newSize;
        }
        return arr[0][0];
    }
}
