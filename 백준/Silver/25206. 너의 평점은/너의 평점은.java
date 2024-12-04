import java.io.*;
import java.util.*;

/**
 * 25206 너의 평점은
 * 입력:
 *      1. 20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.
 *
 *문제 분석:
 *      1. 전공 평점 계산..
 *      2. 전공 평점 = 전공 과목별 (학점 x 과목 평점) 의 합을 학점의 총합으로 나눈것
 *      A+ 4.5 A 4.0 ~ D0 1.0 F 0.0
 *      P/F는 P OR F => P이면 제외
 *      3. 학점은 1.0, 2.0, 3.0, 4.0
 * 출력:
 *      1. 치훈이의 전공평점을 출력한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 학점 총합
        double totalCredit = 0;
        double sum = 0;

        for(int i = 0; i < 20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 과목 이름 필요 없음
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            // P제외
            if(!grade.equals("P")){
                // 학점 총합
                totalCredit += credit;
                sum += calculate(credit, grade);
            }
        }
        Double result = sum / totalCredit;

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
    static double calculate(double credit, String grade){
        switch (grade){
            case "A+" : return credit * 4.5;
            case "A0" : return credit * 4.0;
            case "B+" : return credit * 3.5;
            case "B0" : return credit * 3.0;
            case "C+" : return credit * 2.5;
            case "C0" : return credit * 2.0;
            case "D+" : return credit * 1.5;
            case "D0" : return credit * 1.0;
            default : return 0.0;
        }
    }

}