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
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.sort(arr);
    	for(int num:arr)System.out.println(num);
    }
}