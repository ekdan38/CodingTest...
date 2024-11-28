import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 19638 센티와 마법의 뿅망치
         * 문제 분석:
         *          N의 범위 1 ~ 100,000
         *          centiH 범위 1 ~ 2,000,000,000
         *          T 범위 1~ 100,000
         *          giantH 범위 1~2,000,000,000
         *          센티가 자신의 뿅망치의 횟수만큼 가장 큰 거인을 때려 거인의 키가 키/2가 되도록 한다.
         *          뿅망치의 횟수만큼 진행하다가 모든 거인의 키가 센티의 키보다 작아지면 YES, 최소 뿅망치 횟수
         *          뿅망치의 횟수만큼 진행해도 센티보다 키가 크거나 같은 거인이 있다면 NO, 가장 큰 거인의 키
         *
         * 의사 결정:
         *          변수들은 int로 가능하다.
         *          최대힙으로 뿅망치 횟수만큼 거인의 키를 줄여주자.
         *          뿅망치의 횟수만큼 진행하다가 모든 거인의 키가 센티의 키보다 작아지면 YES, 최소 뿅망치 횟수
         *          뿅망치의 횟수만큼 진행해도 센티보다 키가 크거나 같은 거인이 있다면 NO, 가장 큰 거인의 키
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int centiH = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        //최대힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        //최대힙에 거인의 키 넣어주기
        for(int i = 0; i < N; i++){
            maxHeap.offer(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        //망치로 때리던중에 센티보다 작아지면 처리해줄 boolean
        boolean isSmallGiant = false;
        for(int i = 0; i < T; i++){
            //가장 큰 거인이 센티보다 작으면 더이상 진행할 필요가 없다.
            //결과에 넣어주고, boolean을 true로 줘서 망치를 다쓰고 yes일때와 분리
            if(maxHeap.peek() < centiH){
                isSmallGiant = true;
                sb.append("YES").append("\n").append(i);
                break;
            }

            //거인의 키가 1이면 망치 영향 안받는다.
            //가장 큰 거인의 키가 1이라는 뜻으로 더이상 망치로 때릴 필요 없다.
            if(maxHeap.peek() == 1){
                break;
            }
            
            //위의 조건들 충족 안되면 가장큰 거인 키 / 2
            maxHeap.offer(maxHeap.poll()/2);

        }

        //일단 망치는 다썻음
        if(!isSmallGiant){
            //센티보다 크거나 같은 거인 없음
            if(maxHeap.peek() < centiH){
                sb.append("YES").append("\n").append(T);
            }
            //센티보다 거인이 큼
            else{
                sb.append("NO").append("\n").append(maxHeap.peek());
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}