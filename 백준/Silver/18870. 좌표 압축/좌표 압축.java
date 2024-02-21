
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
    	int Num = Integer.parseInt(br.readLine());
    	int[] arr = new int[Num];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i = 0; i < Num; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int[] sorted = Arrays.copyOf(arr, arr.length);
    	Arrays.sort(sorted);
    	
    	HashMap<Integer, Integer> map = new HashMap<>();

    	int rank = 0;
    	for(int num:sorted) {
    		if(!map.containsKey(num)) {
        		map.put(num, rank);
        		rank++;
    		}
    	}
    	
    	for(int num:arr) {
    		if(map.containsKey(num)) {
    			bw.write(map.get(num)+" ");
    		}
    	}
    	bw.flush();
    	bw.close();

    }
}