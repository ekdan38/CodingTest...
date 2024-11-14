import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 4779 칸토어 집합
         * 각 구간을 3등분하여 가운데 구간을 ' ' 으로 만들고
         * 나머지 좌우 간을 반복적으로 가운데 구간을 ' '을 만들면 된다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while((s = br.readLine()) != null){
            int len = (int) Math.pow(3, Integer.parseInt(s));
            char [] arr = new char[len];
            Arrays.fill(arr, '-');

            search(0, len, arr);
            for(int i = 0; i < len; i++){
                sb.append(arr[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }


    private static void search(int start, int len, char[] arr){
        if(len == 0){
            return;
        }

        len /= 3;
        // 가운데 구간
        for(int i = start + len; i < start + len * 2; i++){
            arr[i] = ' ';
        }

        //좌
        search(start, len, arr);
        //우
        search(start + len * 2, len, arr);
    }

}

