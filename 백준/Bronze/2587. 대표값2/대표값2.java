import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] arr = new int[5];
    	for(int i = 0; i < 5; i++)arr[i] = Integer.parseInt(br.readLine());
    	
    	Arrays.sort(arr);
    	int sum = 0;
    	for(int i = 0; i < 5; i++) {
    		sum += arr[i];
    	}
    	System.out.print(sum/5+"\n"+arr[2]);
    	
    }
}