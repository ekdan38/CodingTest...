import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	HashMap<String, String> map = new HashMap<>();
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		String Name = st.nextToken();
    		String State = st.nextToken();
    		if(State.equals("enter"))map.put(Name, State);
    		else if(State.equals("leave"))map.remove(Name);
    	}
    	
    	ArrayList<String> ArrList = new ArrayList<>(map.keySet());
    	Collections.sort(ArrList, Collections.reverseOrder());
    	StringBuilder sb = new StringBuilder();
    	for(String str:ArrList)sb.append(str+"\n");
    	System.out.print(sb.toString());
    }
}