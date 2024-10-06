import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 전공평점 계산 => 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
        /**
         * A+	4.5
         * A0	4.0
         * B+	3.5
         * B0	3.0
         * C+	2.5
         * C0	2.0
         * D+	1.5
         * D0	1.0
         * F	0.0
         * P 는 제외
         * ObjectOrientedProgramming1 3.0 A+
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double totalCredit = 0;
        double sum = 0;
        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P"))totalCredit += credit;
            sum += score(credit, grade);
        }
        double result = sum / totalCredit;
        System.out.println(result);
    }

    private static double score(double credit, String grade) {
        if(grade.equals("A+"))return credit * 4.5;
        if(grade.equals("A0"))return credit * 4.0;
        if(grade.equals("B+"))return credit * 3.5;
        if(grade.equals("B0"))return credit * 3.0;
        if(grade.equals("C+"))return credit * 2.5;
        if(grade.equals("C0"))return credit * 2.0;
        if(grade.equals("D+"))return credit * 1.5;
        if(grade.equals("D0"))return credit;
        return 0;
    }
}
