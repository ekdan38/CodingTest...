import java.io.*;
import java.util.StringTokenizer;

/**
 * 1083 소트
 * 입력:
 *      1. 첫째 줄에 N이 주어진다. (1 ~ 50)
 *      2. 둘째 줄에는 각 원소가 차례대로 주어진다. (1 ~ 1,000,000)
 *      3. 마지막 줄에는 S가 주어진다. (0 ~ 1,000,000)
 *
 * 문제 분석:
 *      1.크기가 N인 배열 A가 있다. 배열에 있는 모든 수는 서로 다르다.
 *      2.배열을 소트할 때, 연속된 두 개의 원소만 교환할 수 있다. 그리고, 교환은 많아봐야 S번 할 수 있다.
 *      => 연속된 두개의 원소만 교환 가능, S번 교환 가능
 *      3.이때, 소트한 결과가 사전순으로 가장 뒷서는 것을 출력한다.
 *      => S번 교환이 가능한데 S범위 내에서 최대값을 앞으로 보내햐 한다.
 *
 * 의사 결정:
 *      1. 두개씩 정렬한다. s만큼
 * 출력:
 *      1. 첫째 줄에 문제의 정답을 출력한다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //저장할 배열
        int []arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());


        //위치 지정
        int searchIdx = 0;
        while(S > 0 && searchIdx < N){
        
            int maxIdx = searchIdx;

            // 현재 idx부터 S범위까지 가장 큰 수 찾기
            for(int i = searchIdx + 1; i < N && i <= searchIdx + S; i++){
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }

            // 최대값 이동 시켜야됨
            for (int i = maxIdx; i > searchIdx && S > 0; i--) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                S--;  // 교환할 때마다 S 감소
            }

            searchIdx++;


        }

        for(int i = 0; i < N; i++){
            sb.append(arr[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}