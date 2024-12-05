import java.io.*;
import java.util.*;

/**
 * 1244 스위치 켜고 끄기
 * 입력:
 *      1. 첫째 줄 스위치 개수 (1 ~ 100)
 *      2. 둘째 줄 스위치의 상태(켜져있으면 1, 꺼져있으면 0)
 *      3. 셋째 줄 학생 수 (1~ 100)
 *      4. 넷째 줄 학생 수 만큼 성별, 학생이 받은 수 (남자 1, 여자 0, 받은 수 1 ~ N)
 *
 *문제 분석:
 *      1. 남학생은 스위치 번호가 자신이 받은 수의 배수이면, 스위치 상태 바꿈
 *      => 남학생은 스위치 번호가 % 받은 수 == 0 이면 해당 스위치 상태 바꿈
 *
 *      2. 여학생은 자신이 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면 가장많은 스위치를 포함하는 구간 찾아서,
 *      그 구간 스위치 모두 바꿈
 *      => 만약 4 받았으면 (3,5), (2,6), (1,7)비교 같은 범위까지 탐색하고 스위치 바꿔준다.
 *
 *
 * 출력:
 *      1. 스위치 상태 1번 스위치에서 시작 ~ 마지막 스위치까지 할줄에 20개씩 출력, 켜진 스위치 1, 꺼진 스위치 0
 */

public class Main {
    static int switchNum;
    static int[] switchArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 스위치 개수
        switchNum = Integer.parseInt(br.readLine());

        // 최초 스위치 상태 저장 (1번 인덱스부터 사용하자)
        switchArr = new int[switchNum + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= switchNum; i++){
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수
        int StudentNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < StudentNum; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            // 남학생
            if(gender == 1)male(number);
            //여학생
            else if(gender == 2)female(number);

        }

        // 한줄에 20개씩 출력
        StringBuilder result = new StringBuilder();
        for(int i  = 1; i <= switchNum; i++){
            result.append(switchArr[i]).append(" ");
            if(i % 20 == 0) result.append("\n");
        }
        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    // 남학생
    static void male(int number){
        // number의 배수인 스위치 상태 변경
        for(int i = 1; i <= switchNum; i++){
            if(i % number == 0) switchArr[i] = switchArr[i] > 0 ? 0 : 1;
        }
    }

    // 여학생
    static void female(int number){
        // 기준점은 무조건 바꿔줌
        switchArr[number] = switchArr[number] > 0 ? 0 : 1;
        // 기준점 기준으로 양쪽 탐색, 양쪽 다르면 종료
        int leftIndex = number - 1;
        int rightIndex = number + 1;
        while(leftIndex >= 1 && rightIndex <= switchNum){
            if(switchArr[leftIndex] == switchArr[rightIndex]){
                switchArr[leftIndex] = switchArr[leftIndex] > 0 ? 0 : 1;
                switchArr[rightIndex] = switchArr[rightIndex] > 0 ? 0 : 1;
                leftIndex--;
                rightIndex++;
            }
            else break;
        }
    }


}