import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 두 재료의 번호가 M보다 크거나 같으면 된다.
        // 투포인터 탐색
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

//        for(int i = 1; i <= N; i++){
//            System.out.print(" " + arr[i]);
//        }
//        System.out.println();

        int start = 1;
        int end = start + 1;
        int result = 0;

        while(start < arr.length){
            if(end >= arr.length) {
                start++;
                end = start + 1;
            }
            else if(arr[start] + arr[end] == M) {
//                System.out.println(arr[start] + " +  " +  arr[end] + " = "  + (arr[start] + arr[end]));
                result++;
                end++;
            }
            else{
                end++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}