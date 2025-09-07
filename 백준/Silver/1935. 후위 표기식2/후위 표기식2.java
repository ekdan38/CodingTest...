import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Double> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        String str = br.readLine();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            if(current >= 'A' && current <= 'Z'){
                stack.push(arr[current - 'A']);
            }
            else{
                double a = stack.pop();
                double b = stack.pop();
                double temp = 0;

                if(current == '*') temp = b * a;
                else if(current == '+') temp = b + a;
                else if(current == '/') temp = b / a;
                else if(current == '-') temp = b - a;
                stack.push(temp);
            }
        }
        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
    }
}