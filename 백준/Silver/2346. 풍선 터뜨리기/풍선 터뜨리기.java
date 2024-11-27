import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 2346 풍선 터트리기
         * 문제 분석: N개의 풍선이 원형으로 있고, 풍선 안에는 -N~N이 적혀있는 종이가있다.
         *          최초 1번 풍선을 터트리고
         *          종이가 음수이면 왼쪽, 양수이면 오른쪽으로 숫자만큼 이동하고 해당 풍선을 터트린다.
         *          이미 터진 풍선은 제외한다.
         * 의사 결정:
         *          풍선이 중간에 위치하면 제외(삭제)해줘야 하는데 LinkedList를 사용해서 풀어보자.
         *          => 시간 초과남...
         *          ArrayDeque로 풀어보자
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //ArrayDeque선언
        Deque<Balloon> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //deque에 값 넣어주자
        int [] papers = new int[N];
        for(int i = 0; i < N; i++){
            papers[i] = Integer.parseInt(st.nextToken());
            deque.addLast(new Balloon(i + 1, papers[i]));
        }
        StringBuilder sb = new StringBuilder();

        //첫번째 풍선 터트리고 결과에 추가
        Balloon currentBalloon = deque.removeFirst();
        sb.append(currentBalloon.index).append(" ");

        while(!deque.isEmpty()){
            //다음 터트릴 풍선
            int paperValue = currentBalloon.paper;
            //숫자가 양수일때
            //목표지점 - 1까지 값을 deque의 값을 앞에서 뒤로 옮긴다.
            //목표지점 도달하면 값 꺼내고 삭제
            if(paperValue > 0){
                for(int i = 0; i < paperValue - 1; i++){
                    deque.addLast(deque.pollFirst());
                }
                currentBalloon = deque.pollFirst();
            }
            //숫자가 음수일때
            //목표지점 - 1까지 값을 deque의 값을 뒤에서 앞으로 옮긴다.
            //목표지점 도달하면 값 꺼내고 삭제
            else{
                for(int i = 0; i < Math.abs(paperValue) - 1; i++){
                    deque.addFirst(deque.pollLast());
                }
                currentBalloon = deque.pollLast();
            }
            sb.append(currentBalloon.index).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static class Balloon{
        int index;
        int paper;

        public Balloon(int index, int paper) {
            this.index = index;
            this.paper = paper;
        }
    }
}