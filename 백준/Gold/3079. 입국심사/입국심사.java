import java.io.*;
import java.util.*;

/**
 * 1789 수들의 합
 *
 * 입력:
 *      1. 첫째 줄에 입굽심사대 N (1 ~ 100,000), 인원 M (1 ~ 1,000,000,000)
 *      2. 이후 N개의 줄에 심사대에서 심사 하는데 걸리는 시간 (1 ~ 1,000,000,000)
 *
 *문제 분석:
 *      1. 심사대에서 한사람만 가능. 가장 앞에있는 녀석은 비어있는 심사대가 보이면 이동 가능.
 *      더 빠른 심사대 기다렸다가 심사 가능
 *      => 어떤 심사관이 가장 먼저 심사를 끝내냐가 요점이다.  가장 먼저 심사가 끝나는 심사관에게 보내면 된다.
 *
 *
 *  출력:
 *      1. N 최대값 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 7초 10초 걸리는 심사관한테 6명이 심사를 받을때 단순하게 생각하면 가장 적게 걸리는 경우는 6x7 = 42이고
        // 가장 오래 걸리는 시간은 10 x 7이다. 근데 심사관이 한명이 아니니깐 문제에서 원하는 답은 1 ~ 42초 사이에 있을거다.
        // 근데 최악의 경우에는 10^9 x 10^9 = 10^18이다. 일단 int 범위 벗어난다. => long 사용
        // 그러면 일단 각 심사관 심사 시간을 정렬하자. => 1 ~ (가장 앞에있는 심사관의 심사 시간 x 인원수) 이 범위에 답이 있다.
        // 1 ~ 42 초를 두고 하면 최대 42초의 범위이다.

        // 심사관 마다 걸리는 시간
        long [] times = new long[N];
        for(int i = 0; i < N; i++){
            times[i] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(times);

        // 0번 인덱스 심사관이 걸리는 시간 범위안에 답이 있다.
        long maxTime = times[0] * M;
        long minTime = 1;

        // 이진 탐색
        while(minTime <= maxTime){
            long midTime = (minTime + maxTime) / 2;
            long cnt = 0;

            // 시간내에 검사 가능한 인원수 구하기
            for(int i = 0; i < N; i++){
                cnt += midTime / times[i];
            }

            // M 보다 cnt 가 작으면 탐색시간 늘려야함
            if(cnt < M) minTime = midTime + 1;
            else maxTime = maxTime = midTime - 1;
        }

        
        bw.write(Long.toString(minTime));
        bw.flush();
        br.close();
        bw.close();
    }

}