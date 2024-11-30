import java.io.*;
import java.util.*;

/**
 * 1026 보물
 * 입력:
 *      1. 첫 번째 줄에는 N.(1 ~ 50)
 *      2. 두 번째 줄에는 A에 있는 N개의 수 (0 ~ 100)
 *      3. 세 번째 줄에는 B에 있는 N개의 수 (0 ~ 100)
 * 의사 결정:
 *      1. S = A[0] × B[0] + ... + A[N-1] × B[N-1] 이다.
 *      2. A의 수를 재 배열해서 S의 최소값 출력, 단 B는 재배열 xxxxx
 *      3. A를 오름차순으로 정리하고, B를 list에 넣고 최대값 뽑고 지우고 하면서 연산하자
 * 출력:
 *      1. S최소값 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //A담을 배열
        int []A = new int[N];
        //B담을 리스트
        ArrayList<Integer> B = new ArrayList<>(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        //A 오름차순 정렬
        Arrays.sort(A);

        int result = 0;

        //A 의 0번 index부터 B의 최대값 뽑으면서 연산. 연산 후에는 B의 최대값 지워줌
        //이렇게 하면 B 재배열 하지 않고 연산 가능
        for(int i = 0; i < N; i++){
            Integer max = Collections.max(B);
            result += max * A[i];
            B.remove(B.indexOf(max));
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}