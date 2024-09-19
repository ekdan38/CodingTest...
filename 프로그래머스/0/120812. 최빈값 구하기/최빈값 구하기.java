class Solution {
    public int solution(int[] array) {
        int[] cntArray = new int[1001]; // 값의 빈도를 저장할 배열 (0~1000 범위)
        
        // 각 숫자의 빈도수를 cntArray에 기록
        for (int i = 0; i < array.length; i++) {
            cntArray[array[i]]++;
        }
        
        // 최빈값을 찾기 위한 변수
        int maxCount = 0;  // 가장 많이 나온 빈도수를 저장
        int mode = -1;     // 최빈값을 저장 (최초 -1로 초기화)
        
        // 최빈값을 찾기
        for (int i = 0; i < cntArray.length; i++) {
            if (cntArray[i] > maxCount) {
                maxCount = cntArray[i]; // 더 큰 빈도수가 발견되면 업데이트
                mode = i;               // 최빈값을 현재 값으로 설정
            }
        }
        
        // 동일한 빈도수를 가진 값이 여러 개 있는지 확인
        int count = 0; // 최빈값이 몇 개인지 확인하기 위한 변수
        for (int i = 0; i < cntArray.length; i++) {
            if (cntArray[i] == maxCount) {
                count++; // 동일한 빈도수를 가진 값이 있으면 증가
            }
        }
        
        // 최빈값이 여러 개일 경우 -1 반환
        if (count > 1) {
            return -1;
        }
        
        // 최빈값 반환
        return mode;
    }
}
