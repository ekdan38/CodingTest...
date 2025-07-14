// 1,2,3,4,5,6,7  k = 3
// 3, 6  12457
//

import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        // 1회전
        for(int i = 1; i <= N; i++){
            cnt++;
            if(cnt % K == 0) list.add(i);
            else queue.offer(i);
        }
        // 2회전 ~
        if(!queue.isEmpty()){
            while(true){
                cnt++;
                if(cnt % K == 0) list.add(queue.poll());
                else queue.offer(queue.poll());

                if(queue.isEmpty()) break;
            }
        }

        if(list.size() == 1) bw.write("<" + list.get(0) + ">");
        else {
            for(int i = 0; i < list.size(); i++){
                if(i == 0) bw.write("<" + list.get(i));
                else if(i == list.size() - 1) bw.write(", " + list.get(i) + ">");
                else bw.write(", " + list.get(i));
            }            
        }
        bw.flush();
    }
}