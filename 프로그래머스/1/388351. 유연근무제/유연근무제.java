
/**
*      입력 : 
*      1. n 명이 정한 출근 희망 시각을 담은 배열 shedules
*      2. 직원들의 일주일 동안 출근한 시각을 담은 timelogs
*      3. 이벤트 시작한 요일을 의미하는 정수 startday(1 ~ 7)
*       
*      문제 분석
*       1. 직원들이 각자 요일별 출근 희망 시간을 정했다. 
*       2. 희망 출근 시간보다 + 10분 이내에 출근해야된다.(주말 제외)
*       3. 한번이라도 희망 출근 시간 + 10 분 이내에 출근을 안하면 이벤트 탈락
*
*       출력
*       1. 이벤트 상품을 받는 직원의 수 return
*/
import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int N = schedules.length;
        int result = 0;
        
        for(int i = 0; i < N; i++){
            // 출근 시간 데드라인 반영 
            int deadLine = schedules[i] + 10;
            deadLine = (deadLine % 100) >= 60 ? deadLine + 40 : deadLine;   
            
            int cnt = 0;
            for(int j = 0; j < timelogs[i].length; j++){
                // 시작 날짜 고려
                startday = startday % 8 == 0 ? 1 : startday; 
                if(startday != 6 && startday != 7){
                    if(timelogs[i][j] > deadLine) {
                        cnt++;
                    }   
                }
                startday++;
            }
            if(cnt == 0) result++;
        }
        return result;
    }
}