import java.io.*;
import java.util.*;

/**
 * 2179 비슷한 단어
 * 입력:
 *      1. 첫 줄 N (2 ~ 20,000) 이후 N개 줄에 소문자로만 이루어진 문자열 (1 ~ 100)
 *
 * 문제 분석:
 *      가장 긴 공통 접두사를 가지는 두 단어를 찾아 출력해야 한다.
 * 출력:
 *      두 단어를 입력 순서대로 출력한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int maxLen = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        // 모든 단어 쌍을 비교하여 가장 긴 공통 접두사를 찾는다.
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                String s1 = arr[i];
                String s2 = arr[j];
                int commonLen = 0;

                // 공통 접두사의 길이 계산
                for (int k = 0; k < Math.min(s1.length(), s2.length()); k++) {
                    if (s1.charAt(k) == s2.charAt(k)) {
                        commonLen++;
                    } else {
                        break;
                    }
                }

                // 가장 긴 공통 접두사를 갱신
                if (commonLen > maxLen) {
                    maxLen = commonLen;
                    firstIndex = i;
                    secondIndex = j;
                }
            }
        }

        // 결과 출력 (입력 순서 유지)
        if (firstIndex < secondIndex) {
            bw.write(arr[firstIndex] + "\n" + arr[secondIndex] + "\n");
        } else {
            bw.write(arr[secondIndex] + "\n" + arr[firstIndex] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
