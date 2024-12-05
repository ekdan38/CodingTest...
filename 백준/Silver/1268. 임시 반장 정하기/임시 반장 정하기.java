import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 1268 임시 반장 정하기
 * 입력:
 *      1. 첫째 줄 학생 수 (3 ~ 1,000)
 *      2. 둘째 줄 부터 학생 수 만큼  1학년 ~ 5학년 소속 반
 *
 *문제 분석:
 *
 * 출력:
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][5];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < N; k++){
                    // 같은 반이었을때, 자기 자신은 제외
                    if(arr[i][j] == arr[k][j] && i != k){
                        set.add(k);
                    }
                }
            }
            result[i] = set.size();
        }

        int max = -1;
        int captain = 0;
        for(int i = 0; i < N; i++){
            if(result[i] > max){
                max = result[i];
                captain = i + 1;
            }
            else if (result[i] == max) {
                if(i + 1 < captain)captain = i + 1;
            }
        }

        bw.write(String.valueOf(captain));
        bw.flush();
        br.close();
        bw.close();
    }

}