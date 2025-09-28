import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 보다 크거나 같으면서 소수, 팰린드롬 만족하는 수 구하기
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[1_000_0000 + 1];
        arr[1] = true;

        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i < arr.length; i++){
            if(!arr[i]){
                primes.add(i);
                for(int j = i + i; j < arr.length; j += i){
                    arr[j] = true;
                }
            }
        }

        for(int p : primes){
            if(p < N) continue;
            String original = String.valueOf(p);
            String reverse = new StringBuilder(original).reverse().toString();

            if(original.equals(reverse)) {
                bw.write(original);
                break;
            }
        }
        bw.flush();
    }
}