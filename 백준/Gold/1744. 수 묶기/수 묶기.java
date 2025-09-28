import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 -> 무조건 더하는게 유리
        // 양수 -> 두개씩 곱하기, 1개 남으면 더하기
        // 음수 -> 두개씩 곱하기, 1개 남으면 0있으면 곱하기, 없으면 더하기
        // 0 -> 음수에 곱해주거나 0 만 남으면 그대로 두기

        int N = Integer.parseInt(br.readLine());
        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();
        int zero = 0;
        int one = 0;

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input > 1) plusList.add(input);
            else if(input < 0) minusList.add(input);
            else if(input == 0) zero++;
            else one++;
        }

        // 양수는 내림차순
        plusList.sort(Collections.reverseOrder());
        // 음수는 오름차순 정렬
        Collections.sort(minusList);

        int result = one;
        // 양수 처리
        for(int i = 0; i < plusList.size(); i += 2){
            if(i == plusList.size() - 1) result += plusList.get(i);
            else{
                int a = plusList.get(i);
                int b = plusList.get(i + 1);
                result += a * b;
            }
        }

        // 음수 처리
        for(int i = 0; i < minusList.size(); i += 2){
            if(i == minusList.size() - 1){
                // 0 존재하면 곱해서 무효 처리
                if(zero > 0) zero--;
                else result += minusList.get(i);
            }
            else{
                int a = minusList.get(i);
                int b = minusList.get(i + 1);
                result += a * b;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}