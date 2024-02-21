
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine()," ");
    	int[] arr_N = new int[N];
    	for(int i = 0; i < N; i++) {
    		arr_N[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr_N);
    	
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine()," ");
    	int[] arr_M = new int[M];
    	for(int i = 0; i < M; i++) {
    		arr_M[i] = Integer.parseInt(st.nextToken());
    	}

    	int[] result = new int[M];
    	for(int i = 0; i < M; i++) {
    		int low = 0;
    		int high = arr_N.length - 1;
    		
    		while(low <= high) {
        		int mid = (low + high) / 2;
    			if(arr_M[i] == arr_N[mid]) {
    				result[i] = 1;
    				break;
    			}
    			else if(arr_M[i] < arr_N[mid])high = mid - 1;
    			else low = mid + 1;
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int num:result)sb.append(num+" ");
    	System.out.print(sb.toString());
	
    }
}