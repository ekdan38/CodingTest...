import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Long> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        while(K --> 0){
            Long n = Long.parseLong(br.readLine());
            if(n == 0) stack.pop();
            else stack.push(n);
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        bw.write(String.valueOf(sum));
        bw.flush();

    }
}
