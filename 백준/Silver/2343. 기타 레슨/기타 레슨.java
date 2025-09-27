import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 강의의 순서는 바뀌지 않는다.
        // i ~ j 의 강의는 같은 블루레이에 있어야한다.
        // M개의 블루레이어 모든 영상을 넣어야할때 블루레이의 최소 값을 구해라.
        // 블루레이의 범위를 유추해야한다. -> 최소값은 입력값중 가장 큰 수, 최대값은 모든 값을 더한 수
        // 이 범위를 좁혀가면서 M개의 블루레이를 만들 수 있는지 탐색
        // 블루레이 이진탐색 수행

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = -1;
        int right = 0;

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            left = Math.max(input, left);
            right += input;
        }

        int result = 0;
        // binarySearch
        while(left <= right){
            int cnt = 1;
            int sum = 0;
            int mid = (left + right) / 2;
            for(int i = 0; i < N; i++){
                if(sum + arr[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if(cnt > M){
                left = mid + 1;
            }
            else{
                right = mid - 1;
                result = mid;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
