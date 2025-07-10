import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열에서 가장 빈번하게 나타나는 알파벳 출력
        // 배열 하나 만들고, 거기에다가 a~z 입력
        // 배열에서 제일 큰 수 추출
        // 이후 배열 순회하면서, 가장 큰수랑 같은 인덱스 번호 추출 => 카운팅도 해주자 카운티 1이상이면 ? 아니면 인덱스 번호로 char 처리

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int[] arr = new int[26];
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) >= 'a' && str.charAt(j) <= 'z'){
                    arr[str.charAt(j) - 'a']++;
                }
            }
            int max = Arrays.stream(arr).max().getAsInt();
            int cnt = 0;
            int idx = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == max) {
                    cnt++;
                    idx = j;
                }
            }
            if(cnt > 1) sb.append("?").append("\n");
            else sb.append(Character.toString((char) idx + 'a')).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();


    }

}