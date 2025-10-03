import java.util.*;
import java.io.*;
public class Main{
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 합집합 만들고, 각 케이스마다 진실을 아는 집합과 교집합인지 검사
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parents = new int[N+1];
        for(int i = 0; i <= N; i++){
            parents[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int tNum = Integer.parseInt(st.nextToken());
        
        List<Integer> truePersons = new ArrayList<>();
        while(tNum --> 0){
            truePersons.add(Integer.parseInt(st.nextToken()));
        }
        
        List<List<Integer>> parties = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int persons = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            int firstPerson = Integer.parseInt(st.nextToken());
            party.add(firstPerson);

            for(int j = 1; j < persons; j++){
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                union(firstPerson, person); 
            }
            parties.add(party);
        }
        
        int cnt = 0;
        for(List<Integer> party : parties){
            boolean canLie = true;
            for(int person : party){
                for(int tp : truePersons){
                    if(find(person) == find(tp)){
                        canLie = false;
                        break;
                    }
                }
                if(!canLie) break;
            }
            if(canLie) cnt++;
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        
    }
    static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A != B) parents[B] = A;
    }
    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}