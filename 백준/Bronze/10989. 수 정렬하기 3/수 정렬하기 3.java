
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
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	int[] counting_arr = new int[10001];
    
    	for(int i = 0; i < N; i++) arr[i]= Integer.parseInt(br.readLine());
    	for(int i = 0; i < N; i++) counting_arr[arr[i]]++;
    	
    	for(int i = 0; i < 10001; i++) {
    		if(counting_arr[i] != 0) {
    			for(int j = 0; j < counting_arr[i]; j++)bw.write(i+"\n");
    		}
    	}
    	
    	
    	bw.flush();
    	bw.close();
    	
    }
}