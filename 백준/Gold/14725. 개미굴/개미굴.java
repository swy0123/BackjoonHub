import java.util.*;
import java.io.*;

public class Main {
	static class node{
		String cur;
		int cnt;
		ArrayList<node> next;
		public node(String cur, int cnt) {
			this.cur = cur;
			this.cnt = cnt;
			next = new ArrayList<>();
		}
	}
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        node start = new node("start", -1);
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int cnt = Integer.parseInt(st.nextToken());
            node prev = start;
        	for(int j=0; j<cnt; j++) {
        		node curNode = new node(st.nextToken(), prev.cnt+1);
        		boolean flag = false;
        		for (node node : prev.next) {
					if(node.cur.equals(curNode.cur)) {
						prev = node;
						flag = true;
						break;
					}
				}
        		if(!flag) {
        			prev.next.add(curNode);
        			prev = curNode;
        		}
        	}
        }
        
        Stack<node> stack = new Stack();
        if(start.next.isEmpty()) System.out.println("-1");
        else {
        	start.next.sort(new Comparator<node>() {
        		@Override
        		public int compare(node a, node b) {
        			return b.cur.compareTo(a.cur);
        		}
        	});
        }
        for (node node : start.next) stack.add(node);
        
        while(!stack.isEmpty()) {
        	node cn = stack.pop();
        	StringBuilder sb = new StringBuilder();
        	for(int c=0; c<cn.cnt; c++) sb.append("--");
        	sb.append(cn.cur);
        	System.out.println(sb);
        	if(!cn.next.isEmpty()) {
        		cn.next.sort(new Comparator<node>() {
            		@Override
            		public int compare(node a, node b) {
            			return b.cur.compareTo(a.cur);
            		}
            	});
            }
        	for (node node : cn.next) {
        		stack.add(node);
    		}
        }
    }  
}