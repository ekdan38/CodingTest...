import java.util.*;
import java.io.*;

public class Main{
    static int[] checkArr;
    static char[] DnaArr;
    static int[] validateArr;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 43687521
        // 1 ~ n 까지 사용하면서 오름차순으로 push 하면서 위 순열 만들어라

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int num = 1;
        StringBuilder sb = new StringBuilder();
        // idx, n 각각 찾을 값, 오름차순 값
        // 반복문?... idx가 n 이 될때까지 하면된다.
        // idx 를 pop 할때만 ++
        // push 조건은 arr[idx] >= num
        // pop 조건은 empty 아니고, arr[idx] == stack.peek() -> pop 때리고, idx++
        while(idx < n){
            if(arr[idx] >= num){
                stack.push(num);
                num++;
                sb.append("+").append("\n");
            }
            else if(!stack.isEmpty() && arr[idx] == stack.peek()){
                stack.pop();
                idx++;
                sb.append("-").append("\n");
            }
            else{
                bw.write("NO");
                bw.flush();
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}