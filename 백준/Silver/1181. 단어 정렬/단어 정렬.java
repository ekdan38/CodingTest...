import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1181 단어 정렬
 * 입력:
 *      1. 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
 *      2.  둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. (50 이하)
 *
 * 문제 분석:
 *      1. 알파벳 소문자로 이루어진 N개의 단어를 길이가 짧고 길이가 같으면 사전 순으로 정렬
 *
 * 의사 결정:
 *      1. set으로 중복 제거하고 set을 list로 바꾸면서 Comparator 의 compare 오버라이딩 하자
 * 출력:
 *      1. 정렬된 단어 출력
 */

/**
 * 팀 스터디:
 *
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        TreeSet<Sentence> treeSet = new TreeSet<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            treeSet.add(new Sentence(str, str.length()));
        }

        for (Sentence sentence : treeSet) {
            sb.append(sentence.word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static class Sentence implements Comparable<Sentence>{
        String word;
        int length;

        public Sentence(String word, int length) {
            this.word = word;
            this.length = length;
        }

        @Override
        public int compareTo(Sentence o) {
            if(this.length != o.length){
                return this.length - o.length;
            }
            else{
                return this.word.compareTo(o.word);
            }
        }
    }
}