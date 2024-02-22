import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine(), " ");
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[] arr_n = new int[N];
    	int[] arr_m = new int[M];
    	
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i = 0; i < N; i++) arr_n[i] = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i = 0; i < M; i++) arr_m[i] = Integer.parseInt(st.nextToken());
    	
    	Arrays.sort(arr_n);
    	int cnt = 0;
    	for(int i = 0; i < M; i++) {
    		int high = N - 1;
    		int low = 0;
    		while(low <= high) {
    			int mid = (low + high) / 2;
    			if(arr_m[i] == arr_n[mid]) {
    				cnt++;
    				break;
    			}
    			else if(arr_m[i] > arr_n[mid]) {
    				low = mid + 1;
    			}
    			else {
    				high = mid - 1;
    			}
    		}
    	}
    	bw.write(String.valueOf((N + M) - (2 * cnt)));
    	bw.flush();
    	bw.close();
 
    	
    }
}