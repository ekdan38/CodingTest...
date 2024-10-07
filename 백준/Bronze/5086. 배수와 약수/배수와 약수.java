import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        // 각 테스트 케이스마다 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를, 배수라면 multiple을, 둘 다 아니라면 neither를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a;
        int b;
        while((a = Integer.parseInt(st.nextToken())) != 0 && (b = Integer.parseInt(st.nextToken())) != 0){
            if(b % a == 0){
                sb.append("factor\n");
            }
            else if(a % b == 0){
                sb.append("multiple\n");
            }
            else{
                sb.append("neither\n");
            }
            st = new StringTokenizer(br.readLine());
        }
        System.out.print(sb);

    }
}
