import java.util.Scanner;

public class Main {

    // 222-풀링을 수행하는 함수
    public static int[][] pool(int[][] arr, int n) {
        int newSize = n / 2;  // 새 배열의 크기
        int[][] newArr = new int[newSize][newSize];

        // 2x2 영역에서 두 번째로 큰 수를 찾아서 새로운 배열에 저장
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                int[] values = new int[4];
                values[0] = arr[2 * i][2 * j];           // 왼쪽 상단
                values[1] = arr[2 * i][2 * j + 1];       // 오른쪽 상단
                values[2] = arr[2 * i + 1][2 * j];       // 왼쪽 하단
                values[3] = arr[2 * i + 1][2 * j + 1];   // 오른쪽 하단

                // 두 번째로 큰 값 찾기
                java.util.Arrays.sort(values);
                newArr[i][j] = values[2];  // 두 번째로 큰 값
            }
        }

        return newArr;  // 풀링이 완료된 새 배열 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // N 값 입력
        int[][] arr = new int[N][N];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 222-풀링을 반복하여 1x1 배열로 만들기
        while (N > 1) {
            arr = pool(arr, N);  // 풀링 함수 호출
            N /= 2;  // 배열 크기 반으로 줄이기
        }

        // 최종 결과 출력
        System.out.println(arr[0][0]);
    }
}
