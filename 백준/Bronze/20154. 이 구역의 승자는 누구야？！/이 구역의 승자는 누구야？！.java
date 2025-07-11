import java.util.*;
import java.io.*;

/**
 * 20154번
 * <문제 분석>
 *     대무자 주어진다. 각 문자의 획수로 문자를 변환
 *     두개씩 더하다가 마지막에
 *     i = 0 ~ 4 이면
 *     cnt 에다가 ++ 하면서
 *     len 이 5면 나머지가 1이다.
 *     len % 2 == 0이면
 */
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int[] arr = new int[]{3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
        int sum = 0;

        for(int i = 0; i < str.length(); i += 2){
            if(i == str.length() - 1) sum += arr[str.charAt(i) - 'A'];
            else sum += (arr[str.charAt(i) - 'A'] + arr[str.charAt(i + 1) - 'A']);

            if(sum > 10) sum %= 10;
        }

        if(sum % 2 == 0) bw.write("You're the winner?");
        else bw.write("I'm a winner!");
        bw.flush();
    }
}