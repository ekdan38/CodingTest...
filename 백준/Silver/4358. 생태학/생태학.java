import java.io.*;
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    int count; // 이 단어가 등장한 횟수

    public TrieNode() {
        children = new HashMap<>(); // 동적 할당 (대소문자, 숫자, 특수문자 포함)
        count = 0;
    }
}

class Trie {
    TrieNode root;
    int totalCount; // 전체 단어 개수

    public Trie() {
        root = new TrieNode();
        totalCount = 0;
    }

    // Trie에 문자열 삽입
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.count++; // 단어 등장 횟수 증가
        totalCount++;
    }

    // Trie를 DFS 탐색하여 TreeMap<String, Integer>에 정렬된 데이터를 저장
    public void getSortedWords(TrieNode node, StringBuilder sb, TreeMap<String, Integer> map) {
        if (node.count > 0) {
            map.put(sb.toString(), node.count);
        }
        for (char c : new TreeSet<>(node.children.keySet())) { // 사전순 정렬 보장
            sb.append(c);
            getSortedWords(node.children.get(c), sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        String input;
        
        while ((input = br.readLine()) != null) { // EOF까지 입력 받기
            trie.insert(input);
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        trie.getSortedWords(trie.root, new StringBuilder(), sortedMap);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            double percentage = (entry.getValue() * 100.0) / trie.totalCount;
            result.append(String.format("%s %.4f\n", entry.getKey(), percentage));
        }
        System.out.print(result);
    }
}
