import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> dic = new HashMap<>();
        for(int i=0; i<n; i++) {
        	String str = st.nextToken();
        	if(dic.get(str)==null) dic.put(str, 1);
        	else {
        		dic.put(str, dic.get(str)+1);
        	}
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
        	Integer str = dic.get(st.nextToken());
        	if(str == null) sb.append("0 ");
        	else sb.append(str+" ");
        }
        System.out.println(sb);
    }
}