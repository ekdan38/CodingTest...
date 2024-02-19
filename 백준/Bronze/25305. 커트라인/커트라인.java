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
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine(), " ");
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
    	for(int i = 0; i < N; i++)arr[i] = Integer.parseInt(st.nextToken());
    	
    	Arrays.sort(arr);
    	System.out.print(arr[arr.length - K]);
    	
    }
}