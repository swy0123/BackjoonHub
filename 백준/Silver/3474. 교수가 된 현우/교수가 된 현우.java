import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	int f = 5;
        	int cnt = 0;
        	while(num>=f) {
        		cnt += num/f;
        		f *= 5;
        	}
        	if(i!=0) sb.append("\n");
        	sb.append(cnt);
        }
        System.out.println(sb);
    }
}