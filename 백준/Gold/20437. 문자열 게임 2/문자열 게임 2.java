import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String W = br.readLine(); 
            int K = Integer.parseInt(br.readLine()); 

            int[] charCounts = new int[26];
            for (int i = 0; i < W.length(); i++) {
                charCounts[W.charAt(i) - 'a']++; 
            }

            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;

            for (int i = 0; i < W.length(); i++) {
                char currentChar = W.charAt(i);

                if (charCounts[currentChar - 'a'] < K) {
                    continue;
                }

                int count = 0; 
                for (int j = i; j < W.length(); j++) {
                    if (W.charAt(j) == currentChar) {
                        count++;
                    }

                    if (count == K) {
                        int currentLength = j - i + 1;
                        minLength = Math.min(minLength, currentLength);
                        maxLength = Math.max(maxLength, currentLength);
                        break;
                    }
                }
            }

            if (minLength == Integer.MAX_VALUE || maxLength == Integer.MIN_VALUE) {
                bw.write("-1\n"); 
            } else {
                bw.write(minLength + " " + maxLength + "\n");
            }
        }
        bw.flush();
 
    }
}
