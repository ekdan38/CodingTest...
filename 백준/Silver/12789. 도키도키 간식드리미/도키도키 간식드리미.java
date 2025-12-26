import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        int N = Integer.parseInt(br.readLine());

        int index = 1;
        String result = "Nice";		
        String[] arr = br.readLine().split(" ");
        
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            int currentNum = Integer.parseInt(arr[i]);
            if(index != currentNum){
                if(!stack.isEmpty() && index == stack.peek()){
                    index++;
                    i--;
                    stack.pop();
                } 
                else stack.push(currentNum);
            } 
            else index++;
        }

        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(pop == index) index++;
            else {
                result = "Sad";
                break;
            }
        }
        System.out.println(result);
    }
}