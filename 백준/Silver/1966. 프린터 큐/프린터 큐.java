import javax.print.Doc;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 1966 프린터 큐
         * 문제 분석: 프린터 인쇄를 누르면 FIFO방식으로 처리..
         *          1. Queue의 가장 앞에 있는 문서의 중요도를 판단.
         *          2. 나머지 문서들 중에서 가장 앞에 있는 문서보다 중요다가 높으면 Queue의 가장 뒤애 재배치, 아니면 인쇄
         *          어떠한 문서가 몇 번째로 인쇄되는지 찾는문제다.
         *          우선순위 큐 스케쥴링하고 같아 보인다.
         *
         * 의사 결정:
         *          큐를 사용해서 풀어보자
         *          주어진 우선 순위를 Array에 넣고 찾고자 하는 문서를 찾으려면 어떻게 해야할까?..
         *          flag를 달까 했지만 그냥 인덱스, 우선순위를 갖는 객체를 만들어주고
         *          해당 객체를 큐에 넣어서 찾고자 하는 문서가 몇번째인지 확인하자.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        //각 테스트 케이스 수행
        for(int i = 0 ; i < T; i++){
            //Document를 갖는 Queue를 만든다.
            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            //문서의 개수
            int N = Integer.parseInt(st.nextToken());

            //궁금한 문서가 몇번째 문서인가??
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            //우선순위 저장하는 Array
            int[] priorityArr = new int[N];

            //Array에 우선순위 저장하고, Queue에 저장
            for(int j = 0; j < N; j++){
                priorityArr[j] = Integer.parseInt(st.nextToken());
                queue.offer(new Document(j, priorityArr[j]));
            }
            //몇번째로 실행되는지 저장할 변수
            int result = 0;

            //Queue에 값 있으면 계속 진행
            while(!queue.isEmpty()){
                //Queue의 맨 앞 값보다 우선순위가 높은 녀석이 있나 확인
                boolean hasHigherPriority = false;

                Document currentDoc = queue.poll();

                //Queue의 맨 앞 값보다 우선순위가 높은 녀석이 있나 확인
                //있다면 true 하고 break; (쓸모없는 탐색 줄이자)
                for (Document doc : queue) {
                    if(doc.priority > currentDoc.priority){
                        hasHigherPriority = true;
                        break;
                    }
                }

                //현재 document보다 우선순위가 높은 document가 있기에 맨뒤로
                if(hasHigherPriority){
                    queue.offer(currentDoc);
                }
                //현재 dcoument가 가장 높은 우선순위, 즉 출력
                else{
                    //출력 될때만 result++해줘야 한다.
                    result++;
                    //찾고자 하는 문서이면 종료, break;
                    if(currentDoc.index == M){
                        sb.append(result).append("\n");
                        break;
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Document{
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}

