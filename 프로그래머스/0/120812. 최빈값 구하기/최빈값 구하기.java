import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int maxCnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : array){
            int count = map.getOrDefault(num, 0) + 1;
            if(count > maxCnt){
                maxCnt = count;
                answer = num;
            }
            else if(count == maxCnt){
                answer = -1;
            }
            map.put(num, count);
        }
        return answer;
    }
}