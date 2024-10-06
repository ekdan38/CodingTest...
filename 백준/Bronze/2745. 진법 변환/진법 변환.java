import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        double B = Double.parseDouble(st.nextToken());

        Long result = 0L;
        for(int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            int num = 0;
            if(current >= '0' && current <= '9'){
                num = current - '0';
            }
            else{
                num = current - 'A' + 10;
            }

            result += (int) (num * Math.pow(B, str.length() - i - 1));
        }
        System.out.print(result);
    }


}
