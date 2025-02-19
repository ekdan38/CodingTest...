/*
*   입력:
*       1. 24시간 기준 1시간 사용자 배열 players
*       2. 서버 증설 해야하는 사용자 기준 수 m
*       3. 증설한 서버의 가동 시간 k
*
*   문제 분석:
*       1. 특정 시간대에 사용자 / m 만큼 서버가 필요함 
*       2. 서버가 부족하면 추가하고 가동 시간은 k
*       3. 서버를 최소로 증설 해야함 
*   
*   출력:
*       1. 최소 서버 증설 횟수 return
*
**/
class Solution {
    public int solution(int[] players, int m, int k) {
        int [] servers = new int[24];
        int result = 0;
        
        for(int i = 0; i < players.length; i++){
            // 필요한 서버 수
            int needServer = players[i] / m;
            if(servers[i] < needServer){
                // 추가로 증설 해야할 서버 수
                int requireServer = needServer - servers[i];
                result += requireServer;
                for(int j = i; j < i + k ; j++) {
                    if(j >= 24) break;
                    servers[j] += requireServer;
                } 
            }
        }
        return result;
    }
}