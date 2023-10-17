import java.util.*;
import java.io.*;

//영단어 암기는 괴로워
public class Main {
	static class Node implements Comparable<Node> {
		String key;
		int value;
		public Node(String key, int value) {
			this.key = key;
			this.value = value;
		}
		//역순
		@Override
		public int compareTo(Node o) {
			if(this.value != o.value) return o.value-this.value;
			else if(this.key.length()!=o.key.length()) return o.key.length()-this.key.length();
			else return this.key.compareTo(o.key);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> dic = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			if(word.length()<m) continue;
			if(dic.containsKey(word)) {
				dic.put(word, dic.get(word)+1);
			}
			else {
				dic.put(word, 1);
			}
		}
		String[] keys = dic.keySet().toArray(new String[0]);
		Integer[] values = dic.values().toArray(new Integer[0]);
		
		Node[] arr = new Node[dic.size()];
		for(int i=0; i<dic.size(); i++) {
			arr[i] = new Node(keys[i], values[i]);
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(Node item:arr) {
//			sb.append(item.key+" "+item.value+"\n");
			sb.append(item.key+"\n");
		}
		System.out.println(sb);
	}
}