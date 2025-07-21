import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	int max = 1;
    	
    	ArrayList<Integer> res = new ArrayList();
    	
    	for(int i=0; i<=n; i++) {
    		ArrayList<Integer> list = new ArrayList();
    		list.add(n);
    		list.add(i);
    		
    		int prev = n, next = i;
			int tmp = prev - next;
			
    		while(tmp>=0) {
				list.add(tmp);
    			prev = next;
    			next = tmp;
    			tmp = prev - next;
    		}
    		
    		if(list.size() >= max) {
    			max = list.size();
    			res = list;
    		}
    	}
    	
    	res.forEach(item -> {sb.append(item).append(' ');});
    	
    	System.out.println(res.size());
    	System.out.println(sb);
    }
}