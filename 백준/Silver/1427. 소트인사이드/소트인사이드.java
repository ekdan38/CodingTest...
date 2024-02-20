
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
    	String str = br.readLine();
    	int[] arr = new int[str.length()];
    	for(int i = 0; i < str.length(); i++) {
    		arr[i] = str.charAt(i);
    	}
    	Arrays.sort(arr);
    	for(int i = arr.length-1; i >= 0; i--)bw.write(arr[i]);

    	bw.flush();
    	bw.close();
    	
    }
}