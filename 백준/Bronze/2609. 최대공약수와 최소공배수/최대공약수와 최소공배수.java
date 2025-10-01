import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int G = gcd(A,B);
        
        System.out.println(G);
        System.out.println(A*B/G);    
    }
    
    public static int gcd (int A, int B){
        if(B==0)
            return A;
        else
            return gcd(B,A%B);   
    }
}