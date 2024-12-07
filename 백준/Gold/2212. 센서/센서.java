import java.io.*;
import java.util.*;

/**
 * 2212 센서
 *
 * 입력:
 *      1. 첫 줄에 센서의 개수 N (1 ~ 10,000)
 *      1. 둘째 줄에 집중국 의 개수 K (1 ~ 1,000)
 *      3. 셋째 줄에 N 개의 센서의 좌표 (절대값 1,000,000이하 => -1,000,000 ~ 1,000,000)
 *
 *문제 분석:
 *      1. N 개의 센서... 고속 도로에 최대 K개의 집중국 세울 수 있다.
 *      2. N 개의 센서가 적어도 하나의 집중국과 통신 가능해야 한다. 각 집중국의 수신 가능 영역의 길이의합을 최소화해야한다.
 *      입력 값 받고 센서가 평면상의 직선에 나타낸다고 했으니 오름차순 정렬로 위치 정확하게 표시해준다.
 *      이후 각 센서 사이에 차이를 구한다.(센서 사이의 길이)
 *      K개의 집중국을 가질 수 있다는 뜻은 K개로 구간을 나눌 수 있다는 뜻이다.
 *      => 그러면 구한 차이들 중에서 K - 1개를 제거해도 구간을 나눌 수 있다.
 *      => 최솟 값을 구해야 하기때문에 구간 차이 중에서 가장 큰 값은 K - 1만큼 제거해준다.
 *      => 우선순위 큐 사용(최대 힙)
 *출력:
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long [] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for(int i = 0; i < N - 1; i++){
            maxHeap.offer(arr[i + 1] - arr[i]);
        }
        for(int i = 0; i < K -1 ; i++){
            maxHeap.poll();
        }

        long sum = 0;
        while(!maxHeap.isEmpty()){
            long num = maxHeap.poll();
            sum += num;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}
