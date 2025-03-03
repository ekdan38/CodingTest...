import java.io.*;
import java.util.*;
/**
 * 21921 블로그
 *
 * 입력:
 *      1. 첫째 줄 블로그를 시작하고 지난 일수 N X 가 공백
 *      => N : 블로그 시작 한 지난 일수, X : X일 동안 들어온 방문자 수, 기간
 *      2. 둘째 줄 블로그 시작 1일 차부터 N일차 까지 하루 방문자 수
 *
 * 문제 분석:
 *      1. 블로그를 만든지 N일이 지남, X 일 동안 가장 많이 들어온 방문자 수, 그 기간 구하자
 *      => 슬라이딩 윈도우 사용
 * 출력:
 *      1. 첫째 줄 X 일 동안 가장 많이 들어온 방문자 수 출력 0명이면 "SAD" 출력
 *      2. 최대 방문자 수가 0명이 아니면 둘째 줄에 기간 출력
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int []visited = new int[N];
        for(int i = 0; i < N; i++) visited[i] = Integer.parseInt(st.nextToken());

        // sliding window
        int totalSum = 0;
        for(int i = 0; i < X; i++) totalSum += visited[i];

        int maxValue = totalSum;
        int maxDays = 1;
        for(int i = 1; i <= N - X; i++){
            totalSum = totalSum - visited[i - 1] + visited[i + X - 1];
            // 현재 값이 더 크면
            if(maxValue < totalSum){
                maxValue = totalSum;
                maxDays = 1;
            }
            // 현재 값이랑 최대값 같으면
            else if (totalSum == maxValue) maxDays++;
        }

        if(maxValue == 0) bw.write("SAD");
        else {
            bw.write(Integer.toString(maxValue));
            bw.write("\n");
            bw.write(Integer.toString(maxDays));
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
