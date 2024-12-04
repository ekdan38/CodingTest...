import java.io.*;
import java.util.*;

/**
 * 10610 30
 * 입력:
 *      1. N을 입력받는다. N는 최대 10^5개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.
 *
 *문제 분석:
 *      1. N을 30의 배수가 되는 최대값으로 만든다. 성공하면 해당 값 출력
 *      불가능 하면 -1 출력
 *      2. 무작정 반복문 돌려서 하기에는 시간 제한이 있다. N 범위 생각하면 무조건 시간 제한 초과
 *      3. 30의 배수 규칙... => 각 자리 값 더한 값이 3의 배수, 마지막 자리가 0 이다.
 * 출력:
 *      1. 값 존재하면 출력, 아니면 - 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        char[] arr = str.toCharArray();
        
        // 각 자리 더한게 3의 배수인지 확인 해야됨. 합 구해주자
        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            sum += str.charAt(i) - '0';
        }
        // 오름차순 정렬
        Arrays.sort(arr);

        // 3의 배수인지 확인
        // 오른차순이기에 arr[0]이 0인지 확인
        if(sum % 3 == 0 && arr[0] == '0'){
            for(int i = arr.length - 1; i >= 0; i--){
                sb.append(arr[i]);
            }
        }
        else sb.append(-1);


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}