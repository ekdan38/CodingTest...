
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
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	String[] arr_n = new String[N];
    	String[] arr_m = new String[M];
    	
    	for(int i = 0; i < N; i++)arr_n[i] = br.readLine();
    	for(int i = 0; i < M; i++)arr_m[i] = br.readLine();
    	
    	Arrays.sort(arr_n);
    	int cnt = 0;
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < M; i++) {
        	int low = 0;
        	int high = arr_n.length - 1;
        	while(low <= high) {
        		int mid = (low + high) / 2;
        		int procedure = arr_n[mid].compareTo(arr_m[i]);
        		
        		if(procedure == 0) {
        			sb.append(arr_n[mid]+" ");
        			cnt++;
        			break;
        		}
        		else if(procedure > 0) {
        			high = mid - 1;
        		}
        		else {
        			low = mid + 1;
        		}
        	}
    	}
    	String[] result = sb.toString().split(" ");
    	Arrays.sort(result);
    	sb.delete(0, sb.length());
    	for(String num:result)sb.append(num+"\n");
    	System.out.println(cnt+"\n"+sb.toString());
    		
    	
    	
    	
    	
    }
}