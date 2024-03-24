import java.util.*;
import java.io.*;
/*
 * 19590 비드맨
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	sum += num;
        	max = Math.max(max, num);
        }
        
        if(max>=(sum-max)) System.out.println(max-(sum-max));
        else if(sum%2==0) System.out.println(0);
        else if(sum%2==1) System.out.println(1);
    }
}