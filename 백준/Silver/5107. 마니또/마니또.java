import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		String name;
		int visit;
		public Node(String name, int visit) {
			this.name = name;
			this.visit = visit;
		}
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int test_case = 0;
        while(true) {
        	test_case++;
        	int n = Integer.parseInt(br.readLine());
        	if(n==0) break;
            HashMap<String, String> dic = new HashMap<>();
            HashMap<String, Integer> v = new HashMap<>();
            
            for(int i=0; i<n; i++) {
            	st = new StringTokenizer(br.readLine());
            	String from = st.nextToken();
            	String to = st.nextToken();
        		dic.put(from, to);
        		v.put(from, 0);
            }
            
            String[] arr = dic.keySet().toArray(new String[0]);
            
            int idx = 1;
            int answer = 0;
            for(int i=0; i<arr.length; i++) {
            	if(v.get(arr[i])!=0) continue;
                Queue<Node> q = new ArrayDeque<>();
                q.add(new Node(arr[i], idx));
                v.put(arr[i], idx);
                while(!q.isEmpty()) {
                	Node cn = q.poll();
                	
                	if(v.get(dic.get(cn.name))==0) {
                		v.put(dic.get(cn.name), idx);
                		q.add(new Node(dic.get(cn.name), idx));
                	}
                	else {
                		if(v.get(dic.get(cn.name))==idx) {
                			answer++;
                			break;
                		}
                		else {
                			break;
                		}
                	}
                }
    			idx++;
            }
            System.out.println(test_case+" "+answer);
        }
    }
}