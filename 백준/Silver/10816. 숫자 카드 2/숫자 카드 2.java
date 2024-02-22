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

    	int N = Integer.parseInt(br.readLine());
    	HashMap<Integer,Integer> map = new HashMap<>();
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(map.containsKey(num)) {
    			map.put(num, map.get(num) + 1);
    		}
    		else {
    			map.put(num, 1);
    		}
    	}
    	
    	int M = Integer.parseInt(br.readLine());
    	int[] arr = new int[M];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i = 0; i < M; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < M; i++) {
    		if(map.containsKey(arr[i])) {
    			sb.append(map.get(arr[i])+" ");
    		}
    		else {
    			sb.append(0+" ");
    		}
    	}

    	System.out.print(sb.toString());
    	
    	
    }
}