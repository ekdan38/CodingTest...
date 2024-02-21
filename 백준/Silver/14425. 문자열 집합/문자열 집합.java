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
    	st = new StringTokenizer(br.readLine()," ");
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	HashMap<String, Integer>map = new HashMap<>();
    	String[] arr_M = new String[M];
    	for(int i = 0; i < N; i++) {
    		map.put(br.readLine(), 0);
    	}
    	for(int i = 0; i < M; i++) {
    		arr_M[i] = br.readLine();
    	}
    	
    	int cnt = 0;
    	for(String str:arr_M) {
    		if(map.containsKey(str))cnt++;
    	}

    	bw.write(String.valueOf(cnt));
    	bw.flush();
    	bw.close();
    }
}