
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
    	int X = Integer.parseInt(br.readLine());
    	long numberator = 0; // 분자
    	long denominator = 0; // 분모
    	int cnt = 2;
    	int length = 0;
    	if(X == 1) bw.write("1/1");

    	else {  
    		length = X - 1;
    		while(length > cnt) {
    			length -= cnt;
    			cnt++;
    		}
    		numberator = length;
    		denominator = cnt - length + 1;
    		if(cnt%2 == 1) {
                bw.write(denominator + "/" + numberator);

    		}
    		else {
                bw.write(numberator + "/" + denominator);

    		}
    		
    		
    	}

        
//    	for(int i = 0; i < sb.length(); i++) {
//    		System.out.print(sb.charAt(i)+" ");
//    	}
//    	bw.write("\nCnt : " + cnt);
        bw.flush();
        bw.close();
        br.close();
//    	
//    	System.out.print("\n");
//    	System.out.print("sb.length : " + length);
//    	
//    	System.out.print("\n");
//    	System.out.print("numberator : " + numberator);
    	//1 => 1 
    	//2,3 => 2 
    	//4,5,6 => 3
    	//7,8,9,10 => 4
    	//11,12,13,14,15 => 5
    	//16 17 18 19 20 21 => 6
    }
}