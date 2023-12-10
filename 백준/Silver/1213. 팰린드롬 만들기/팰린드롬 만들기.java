import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int[] alpha = new int[26];
        
        for(int i=0; i<str.length(); i++) {
        	alpha[str.charAt(i)-'A']++;
        }
        StringBuilder start = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder end = new StringBuilder();
        int cnt = 0;
        for(int i=0; i<26; i++) {
        	if(alpha[i]%2==0) {
        		for(int j=0; j<(alpha[i])/2; j++) {
            		start.append((char)('A'+i));
            		end.append((char)('A'+i));
        		}
        	}
        	else {
        		cnt++;
        		if(cnt>1) break;
        		for(int j=0; j<(alpha[i]-1)/2; j++) {
            		start.append((char)('A'+i));
            		end.append((char)('A'+i));
        		}
        		mid.append((char)('A'+i));
        	}
        }
        if(cnt<=1) {
        	end.reverse();
            StringBuilder answer = start.append(mid).append(end);
            System.out.println(answer);
        }
        else{
        	System.out.println("I'm Sorry Hansoo");
        }
    }
}