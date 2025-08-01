import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int minPackage = 1001;
        int minSingle = 1001;
        
        for (int i = 0; i < M; i++) {
            int packagePrice = sc.nextInt();
            int singlePrice = sc.nextInt();
            minPackage = Math.min(minPackage, packagePrice);
            minSingle = Math.min(minSingle, singlePrice);
        }
        
        int result = 0;
        int case1 = N * minSingle;
        int case2 = (N / 6 + 1) * minPackage;
        int case3 = (N / 6) * minPackage + (N % 6) * minSingle;
        
        if (minPackage < minSingle * 6) result = Math.min(case1, Math.min(case2, case3));
        else result = case1;
        System.out.println(result);
    }
}