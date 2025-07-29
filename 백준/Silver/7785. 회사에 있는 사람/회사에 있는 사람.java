import java.util.*;
import java.io.*;
 /*
  * 회사에 있는 사람
  */
public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	Set<String> set = new HashSet();
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		String name = st.nextToken();
    		String code = st.nextToken();
    		
    		if(code.equals("enter")) {
    			set.add(name);
    		}
    		else if(code.equals("leave")) {
    			set.remove(name);
    		}
    	}
    	
    	String[] arr = set.toArray(new String[0]);
    	
    	Arrays.sort(arr, (o1, o2)->{
    		return o2.compareTo(o1);
    	});
    	
    	for(int i=0; i<arr.length; i++) {
    		sb.append(arr[i]).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}