import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	ArrayDeque<Integer> q = new ArrayDeque();
    	
    	for(int i=0; i<n; i++) {
    		String[] sarr = br.readLine().split(" ");
    		if(sarr[0].equals("push")) {
    			q.add(Integer.parseInt(sarr[1]));
    		}
    		if(sarr[0].equals("pop")) {
    			if(q.isEmpty()) sb.append("-1\n");
    			else sb.append(q.poll()+"\n");
    		}
    		if(sarr[0].equals("size")) {
    			sb.append(q.size()+"\n");
    		}
    		if(sarr[0].equals("empty")) {
    			sb.append(q.isEmpty()?"1\n":"0\n");
    		}
    		if(sarr[0].equals("front")) {
    			if(q.isEmpty()) sb.append("-1\n");
    			else sb.append(q.peek()+"\n");
    		}
    		if(sarr[0].equals("back")) {
    			if(q.isEmpty()) sb.append("-1\n");
    			else sb.append(q.peekLast()+"\n");
    		}
    	}
    	System.out.println(sb);
    }
}