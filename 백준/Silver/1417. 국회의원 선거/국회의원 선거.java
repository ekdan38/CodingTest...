import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 1417 국회의원 선거
         * 문제 분석:
         *          N의 범위 1 ~ 500
         *          득표수 1 ~ 100
         *          다솜이 보다 다른 후보의 값이 작으면 된다.
         *          다른 후보의 최대값을 찾고 1을 빼앗아 다솜이 에게 1씩 더해주면된다.
         * 의사 결정:
         *          최대힙을 사용해서 다른 후보자들 중에서 최대값을 찾고 - 1해주고,
         *          다솜이에게 +1 해준다. 다솜이가 다른 후보자들 최대값 보다 투표 수가 많아질때까지
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //최대 힙 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int N = Integer.parseInt(br.readLine());

        //다솜이의 투표 수
        int DaSom = Integer.parseInt(br.readLine());

        //다른 후보들의 투표 수를 최대 힙에 넣는다.
        for(int i = 0; i < N - 1; i++){
            maxHeap.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        //다른 후보자들의 최대 투표 수가 다솜이보다 크거나 같을동안 반복
        //다만 다솜이 단독 출마인경우 고려
        while(!maxHeap.isEmpty() && maxHeap.peek() >= DaSom){
            maxHeap.offer(maxHeap.poll() - 1);
            DaSom += 1;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}