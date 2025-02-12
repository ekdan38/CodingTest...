/**
*      입력 
*      1. 정수 n
*      2. 입력한 정수를 담은 배열 q
*      3. 응답을 담은 배열 ans
*       
*      문제 분석
*       1. 1 ~ n 까지 오름차순인 비밀 코드 존재, 이 코드를 맞춰야 한다.
*       2. m 번의 시도 후, 비밀 코드로 가능한 정수 조합의 개수를 구해야한다.
*       3. 길이 5인 비밀 코드 싹다 만들어서 조건 만족하는지 확인?
*
*       출력
*       1. 이벤트 상품을 받는 직원의 수 return
*/
import java.util.*;

class Solution {
    static int [] visited;
    static int result = 0;
    static int [][] questions;
    static int [] answers;
    
    public int solution(int n, int[][] q, int[] ans) {
        visited = new int[n + 1];
        questions = q;
        answers = ans;
        
        // 길이가 비밀 코드 저장
        dfs(n, 0, 0);  // DFS 탐색 시작
        
        
        
        
        return result;
    }
    // 길이 5인 비밀 코드 생성
    static void dfs(int n, int depth, int last) {
        if (depth == 5) { 
            validate();
            return;
        }

        for (int i = last + 1; i <= n; i++) {  // 중복 없이 선택
            if (visited[i] == 0) {  
                visited[i] = 1;  // 선택
                dfs(n, depth + 1, i);  // 다음 숫자 선택 (재귀 호출)
                visited[i] = 0;  // 선택 해제 (백트래킹)
            }
        }
    }

    static void validate() {
        for (int i = 0; i < questions.length; i++) {  // 모든 질문을 검사
            int cnt = 0;
            for (int j = 0; j < 5; j++) {  // 현재 선택된 숫자 5개 확인
                if (visited[questions[i][j]] == 1) {  // 선택된 숫자가 있다면 증가
                    cnt++;
                }
            }
            if (cnt != answers[i]) {  // 기대값과 다르면 실패
                return;
            }
        }
        result++;  // 모든 질문을 만족하면 정답 개수 증가
    }
}