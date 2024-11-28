import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 9933 민균이의 비밀번호
         * 문제 분석:
         *          N의 범위 2 ~ 100
         *
         * 의사 결정:
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String fileName = br.readLine();
            String reverseFileName = new StringBuilder(fileName).reverse().toString();

            if(set.contains(reverseFileName)){
                int length = fileName.length();
                bw.write(length + " " + fileName.charAt(length / 2));
            }
            else if(fileName.equals(reverseFileName)){
                int length = fileName.length();
                bw.write(length + " " + fileName.charAt(length / 2));
            }
            else{
                set.add(fileName);
            }
        }


        bw.flush();
        bw.close();
    }
}