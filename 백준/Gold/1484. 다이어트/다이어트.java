import java.io.*;
/*
 * 다이어트
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        
        int cur = 2, prev = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
//        	System.out.println(cur+" "+prev);
        	if(cur*cur - prev*prev > g) prev++;
        	else if(cur*cur - prev*prev < g) cur++;
        	else if(cur*cur - prev*prev == g) {
        		sb.append(cur+"\n");
        		cur++;
        	}
        	if(cur<=prev || cur>100000) {
        		break;
        	}
        }
        if(sb.length()==0) System.out.println(-1);
        else System.out.println(sb);
    }
}