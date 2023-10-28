import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		long num;
		String str;
		public Node(long num, String str) {
			this.num = num;
			this.str = str;
		}
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(n==m) {
        	System.out.println(0);
        }
        else {
        	HashSet<Long> s = new HashSet<>();
            Queue<Node> q = new ArrayDeque<>();
            q.add(new Node(n, ""));
            while(!q.isEmpty()) {
            	Node cn = q.poll();
            	
            	if(cn.num==m) {
            		System.out.println(cn.str);
            		return;
            	}
            	
            	if(!s.contains(cn.num*cn.num) && cn.num*cn.num<=m && cn.num>1) {
            		s.add(cn.num*cn.num);
            		q.add(new Node(cn.num*cn.num, cn.str+"*"));
            	}
            	if(!s.contains(cn.num+cn.num) && cn.num+cn.num<=m && cn.num>0) {
            		s.add(cn.num+cn.num);
            		q.add(new Node(cn.num+cn.num, cn.str+"+"));
            	}
            	if(!s.contains(0) && cn.num>0) {
            		s.add((long) 0);
            		q.add(new Node(0, cn.str+"-"));
            	}
            	if(!s.contains(1) && cn.num>1) {
            		s.add((long) 1);
            		q.add(new Node(1, cn.str+"/"));
            	}
            }
            System.out.println(-1);
        }
    }
}