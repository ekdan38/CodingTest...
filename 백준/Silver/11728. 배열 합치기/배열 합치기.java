import java.io.*;
import java.util.*;

/**
 * 11728 배열 합치기
 *
 * 입력:
 *      1. 첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)
 *      2. 둘째 줄에는 배열 A의 내용이, 셋째 줄에는 배열 B의 내용이 주어진다. 배열에 들어있는 수는 절댓값이 109보다 작거나 같은 정수이다.
 * 문제 분석:
 *      1. 간단하게 정렬해서 풀 수 있지만, 투포인터 문제이니 투포인터로 풀어보자.
 * 출력:
 *      1. 첫째 줄에 두 배열을 합친 후 정렬한 결과를 출력한다.
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            int pointerA = 0;
            int pointerB = 0;

            StringBuilder result = new StringBuilder();
            while (pointerA < N && pointerB < M){
                if(A[pointerA] < B[pointerB]) {
                    result.append(A[pointerA]).append(" ");
                    pointerA++;
                }
                else {
                    result.append(B[pointerB]).append(" ");
                    pointerB++;
                }
            }
            // 두 배열 길이가 다르게 되면 값이 남아 있는 경우 발생
            if(pointerA == N){
                for(int i = pointerB; i < M; i++){
                    result.append(B[i]).append(" ");
                }
            }
            if(pointerB == M){
                for(int i = pointerA; i < N; i++){
                    result.append(A[i]).append(" ");
                }
            }

            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }

    }