
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
    	StringTokenizer st;
    	int Num = Integer.parseInt(br.readLine());
    	String[] arr = new String[Num];
    	for(int i = 0; i < Num; i++) {
    		arr[i] = br.readLine();
    	}
    	//확인
//    	for(String str:arr)System.out.println(str);

    	Arrays.sort(arr, (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length());

    	bw.write(arr[0]+"\n");
    	for(int i = 1; i < Num; i++) {
    		if(!arr[i].equals(arr[i-1])) {
    			bw.write(arr[i] + "\n");
    		}
    	}
    	bw.flush();
    	bw.close();

    	
    }
}