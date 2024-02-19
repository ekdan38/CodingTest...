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
    	StringTokenizer st;
    	int num =Integer.parseInt(br.readLine());
    	int[][] arr = new int[100][100];
    	int cnt = 0;
    	for(int i = 0; i < num; i++){
    		st = new StringTokenizer(br.readLine()," ");
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		for(int j = x; j < x + 10; j++) {
    			for(int k = y; k < y + 10; k++) {
    				if(arr[j][k] == 1) cnt++;
    				else arr[j][k] = 1;
    			}
    		}

    	}

    	
    	System.out.print(100*num - cnt);
    }
}
//int max = 1;

