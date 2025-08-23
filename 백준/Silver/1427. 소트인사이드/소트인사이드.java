import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[10];
 
        while(n > 0){
            array[n % 10]++;
            n = n / 10;
        }
 
        for(int i = array.length - 1; i >= 0; i--){
            while(array[i] --> 0){
                System.out.print(i);
            }
        }
 
    }
}