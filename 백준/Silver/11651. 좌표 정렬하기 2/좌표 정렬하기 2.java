
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
    	int[][] arr = new int[Num][2];

    	for(int i = 0; i < Num; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j = 0; j < 2; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	

    	Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]  );
    	for(int i = 0; i < Num; i++) {
    		for(int j = 0; j < 2; j++) {
    			bw.write(arr[i][j]+" ");
    		}
    		bw.newLine();
    	}
    	bw.flush();
    	bw.close();
    	
    }
}