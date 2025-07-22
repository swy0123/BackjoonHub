import java.util.*;
import java.io.*;
 /*
  * 죽음의 게임
  */
public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}

    	int cnt = 0, idx = 0, tmp;
    	while(cnt++ < n) {
    		tmp = arr[idx];
    		if(tmp == k) break;
    		idx = tmp;
    	}
    	int ret = cnt>n ?  -1 : cnt;
    	System.out.println(ret);
    }
}