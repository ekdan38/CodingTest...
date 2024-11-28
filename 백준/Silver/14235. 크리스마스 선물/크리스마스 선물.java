import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 14235 크리스마스 선물
         * 문제 분석:
         *          N의 범위 1 ~ 5,000
         *          a의 범위 1 ~ 100
         *          a가 0이 아니면 a개 만큼 선물을 채우고, 각 a개의 숫자는 선물의 우선 순위
         *          a가 0이면 아이들에게 우선순위가 가장 높은 선물을 준것
         *          아이들에게 준 선물의 우선순위 출력, 줄 선물이 없다면 -1
         *          최대힙 사용하자
         * 의사 결정:
         *          최대힙 사용
         *          a가 0이면 최대힙에서 최대값 제거, 출력
         *          (힙이 비어있으면 -1 출력)
         *          a가 0이 아니면 힙에 값 넣기
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        //최대힙 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //토큰의 개수가 1이면, 즉 입력 값이 0이면
            if(st.countTokens() == 1){
                //힙이 비어 있으면 -1출력 
                if(maxHeap.isEmpty()){
                    sb.append(-1).append("\n");
                }
                //힙이 비어 있지 않으면 최대값 출력, 삭제
                else{
                    sb.append(maxHeap.poll()).append("\n");
                }
            }
            //거점에 들린 거면
            else{
                int a = Integer.parseInt(st.nextToken());
                for(int j = 0; j < a; j++){
                    maxHeap.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}