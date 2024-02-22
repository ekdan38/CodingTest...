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
    	st = new StringTokenizer(br.readLine()," ");
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());

    	String[] arr = new String[N];
    	HashMap<String, Integer> map = new HashMap<>();
    	int cnt = 1;
    	for(int i = 0; i < N; i++) {
    		String str = br.readLine();
    		arr[i] = str;
    		map.put(str, cnt);
    		cnt++;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < M; i++) {
    		String str = br.readLine();
    		if(Character.isDigit(str.charAt(0))) {
    			sb.append(arr[Integer.parseInt(str) - 1]+"\n");
    		}
    		else {
    			sb.append(map.get(str)+"\n");
    		}
    	}
    	System.out.print(sb.toString());
    	
    }
}