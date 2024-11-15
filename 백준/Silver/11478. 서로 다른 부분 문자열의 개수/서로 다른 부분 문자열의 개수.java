import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 11478 서로 다른 부분 문자열의 개수
         * 문자열 S에서 서로 다른 부분 문자열의 개수를 구해야한다.
         * 경우의 수를 구하여 Set에 넣어 중복을 제거해주면 된다.
         * 이후 set의 size를 출력해주면 된다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        Set<String> strSet = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j < str.length() + 1; j++){
                strSet.add(str.substring(i, j));
            }
        }

        bw.write(String.valueOf(strSet.size()));

        bw.flush();
        bw.close();
    }
}
