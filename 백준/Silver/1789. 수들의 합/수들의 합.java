import java.io.*;
/*
 * 수들의 합
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        long num = 0, sum = 0;
        while(sum<=n) {
        	sum += num;
        	if(sum>n) {
        		num--;
        		break;
        	}
        	num++;
        }
        System.out.println(num);
    }
}