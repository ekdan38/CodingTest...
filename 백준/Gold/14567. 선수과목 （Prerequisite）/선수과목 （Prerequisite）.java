import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 과목 수 N, 선수 조건 수 M
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // 그래프와 진입 차수 배열 초기화
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];
        int[] semester = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 선수 조건 입력
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            inDegree[b]++;
        }
        
        // 위상 정렬용 큐
        Queue<Integer> queue = new LinkedList<>();
        
        // 진입 차수가 0인 노드 초기화
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                semester[i] = 1; // 첫 학기
            }
        }
        
        // 위상 정렬
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                inDegree[next]--;
                
                if (inDegree[next] == 0) {
                    queue.add(next);
                    semester[next] = semester[current] + 1;
                }
            }
        }
        
        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(semester[i] + " ");
        }
    }
}
