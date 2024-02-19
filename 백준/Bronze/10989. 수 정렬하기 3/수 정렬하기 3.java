
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
    	long N = Long.parseLong(br.readLine());
    	int a = (int)N;
    	int[] arr = new int[a];
    	for(int i = 0; i < a; i++)arr[i] = Integer.parseInt(br.readLine());
    	
    	Arrays.sort(arr);
    	for(int num:arr)bw.write(num+"\n");
    	bw.flush();
    	bw.close();
    }
}