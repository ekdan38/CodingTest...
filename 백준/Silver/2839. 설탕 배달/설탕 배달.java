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
    	int result = 0;
    	while(true) {
    		if(N % 5 == 0) {
    			result += N / 5;
    			System.out.print(result);
    			break;
    		}
    		else {
    			N -= 3;
    			result++;
    		}
    		if(N < 0) {
    			System.out.print("-1");
    			break;
    		}
    	}

    	}
    }