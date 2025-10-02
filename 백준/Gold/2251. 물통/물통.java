import java.util.*;
import java.io.*;
public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 물통 A B C 있음
        // 각각 용량 주어짐
        // C에만 물이 가득 차 있고, A B는 비어있음
        // 물은 한쪽이 다 차거나 한쪽이 다 비어질때 까지 옮기기 가능
        // C -> A , C -> B, A -> B, A -> C, B -> C, B -> A 가능
        // A가 비어있을 때 C에 물이 담겨 있을 경우에 물의 양을 구해라(오름차순)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> result = bfs(A, B, C);
        Collections.sort(result);

        for(int n : result){
            bw.write(n + " ");
        }
        bw.flush();

    }
    static List<Integer> bfs(int A, int B, int C){
        List<Integer> result = new ArrayList<>();
        boolean[][][] water = new boolean[A + 1][B + 1][C + 1];
        Queue<Basket> queue = new LinkedList<>();
        queue.offer(new Basket(0, 0, C));
        water[0][0][C] = true;

        while(!queue.isEmpty()){
            Basket currentBasket = queue.poll();
            int cA = currentBasket.A;
            int cB = currentBasket.B;
            int cC = currentBasket.C;
            if(cA == 0) result.add(cC);

            // C -> A
            int tW = Math.min(A - cA, cC);
            int tA = cA + tW;
            int tB = cB;
            int tC = cC - tW;
            check(tA, tB, tC, water, queue);
            // C -> B
            tW = Math.min(B - cB, cC);
            tA = cA;
            tB = cB + tW;
            tC = cC - tW;
            check(tA, tB, tC, water, queue);

            // B -> A
            tW = Math.min(A - cA, cB);
            tA = cA + tW;
            tB = cB - tW;
            tC = cC;
            check(tA, tB, tC, water, queue);

            // B -> C
            tW = Math.min(C - cC, cB);
            tA = cA;
            tB = cB - tW;
            tC = cC + tW;
            check(tA, tB, tC, water, queue);

            // A -> C
            tW = Math.min(C - cC, cA);
            tA = cA - tW;
            tB = cB;
            tC = cC + tW;
            check(tA, tB, tC, water, queue);

            // A -> B
            tW = Math.min(B - cB, cA);
            tA = cA - tW;
            tB = cB + tW;
            tC = cC;
            check(tA, tB, tC, water, queue);
        }
        return result;

    }
    static void check(int A, int B, int C, boolean[][][] water, Queue<Basket> queue){
        if(!water[A][B][C]){
            water[A][B][C] = true;
            queue.offer(new Basket(A, B ,C));
        }

    }
    static class Basket{
        int A;
        int B;
        int C;
        Basket(int A, int B, int C){
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
