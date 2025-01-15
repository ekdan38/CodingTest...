import java.io.*;
import java.util.*;

/**
 * 10815 숫자 카드
 *
 * 입력:
 *      1. 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
 *      2. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
 *      => -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 *      => 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
 *      3. 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
 *      4. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어진다. 공백, -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
 * 문제 분석:
 *      1. M 개의 숫자 카드와 N개의 숫자 카드 비교 결과 값 도출
 *      => 각 숫자 비교해서 탐색 해야한다.
 *      => 단순 for문으로 탐색시에 최소 약 2.5초 소요
 *      => 이진 탐색
 *      => N은 정렬하고, M은 배열로 받을 필요도 없다
 *
 * 출력:
 *
 * */

public class Main {
        static int [] arr;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder result = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                result.append(binarySearch(Integer.parseInt(st.nextToken()))).append(" ");
            }

            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }
    static int binarySearch(int target){
            int low = 0;
            int high = arr.length - 1;
            int mid = 0;
            while(low <= high){
                mid = (low + high) / 2;

                if(target == arr[mid]) return 1;
                if(arr[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
            return 0;
    }

    }
