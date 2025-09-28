import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 어떤 수가 소수의 N제곱(N ≥ 2) 꼴일 때, 그 수를 거의 소수라고 한다.
        // => 2 3 5 7 있으면 2 4 8 16은 거의 소수, 3 9 27은 거의 소수
        // A와 B사이에 거의 소수가 몇개 있는지 출력
        // ex) 1 10
        // 범위 사이에 소수 판별하고, 해당 소수이용해서 제곱 돌리면서 확인?
        // A, B의 범위가 크기에 Long 사용
        // 소수 판별 범위 -> 루트범위 까지만 제한 (B = 100 일때, 10까지만 소수 판별해야 제곱근 범위)

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int range = (int) Math.sqrt(B);

        boolean[] arr = new boolean[range + 1];
        arr[1] = true;

        List<Integer> primes = new ArrayList<>();

        // 소수 판별
        for(int i = 2; i <= range; i++){
            if(!arr[i]){
                primes.add(i);
                for(int j = i + i; j <= range; j += i){
                    arr[j] = true;
                }
            }
        }

        int cnt = 0;
        for(int prime : primes){
            long temp = (long) prime * prime;
            while(temp <= B){
                if(temp >= A) cnt++;
                if(temp > B / prime) break;
                temp *= prime;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}