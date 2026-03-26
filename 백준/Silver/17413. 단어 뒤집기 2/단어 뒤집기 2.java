import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	String str = br.readLine();
    	ArrayList<Character> arr = new ArrayList<Character>();
    	
    	
    	boolean isTag = false;
    	
    	for(int i=0; i<str.length(); i++) {
    		if(!arr.isEmpty()) {
    			if(str.charAt(i)=='<' || str.charAt(i)==' ') {
    				Collections.reverse(arr);
    				for (char c : arr) {
    		            sb.append(c);
    		        }
    		        arr.clear();

    				if(str.charAt(i)==' ') {
    					sb.append(' ');
    				}
    			}
    		}
    		
    		if(str.charAt(i)=='<') {
    			isTag = true;
    			sb.append('<');
    		}
    		else if(str.charAt(i)=='>') {
    			isTag = false;
    			sb.append('>');
    		} else {
    			if(isTag) {
        			sb.append(str.charAt(i));
        		} else {
        			if(str.charAt(i)!=' ')
        				arr.add(str.charAt(i));
        		}
    		}
    	}
    	if(!arr.isEmpty()) {
    		Collections.reverse(arr);
			for (char c : arr) {
	            sb.append(c);
	        }
	        arr.clear();
		}
    	System.out.println(sb);
    }
}