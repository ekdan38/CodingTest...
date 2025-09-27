import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        // arrM에 존재하는 값들이 arrN에 존재하는지 탐색해야한다. -> -2^31 ~ 2^31 이기에 선형 탐색 불가

        // 정렬
        Arrays.sort(arrN);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M; i++){
            if(binarySearch(arrN, arrM[i])) sb.append("1");
            else sb.append("0");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }
    static boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int midIdx = (start + end) / 2;
            int mid = arr[midIdx];
            if(mid < target){
                start = midIdx + 1;
            }
            else if(mid > target){
                end = midIdx - 1;
            }
            else if(mid == target){
                return true;
            }
        }
        return false;

    }
}
