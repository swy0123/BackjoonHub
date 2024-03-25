import java.util.*;
import java.io.*;
/*
 * 2096 내려가기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] tmp1 = new int[3];
        int[] tmp2 = new int[3];
        int[] mindp = new int[3];
        int[] maxdp = new int[3];
        for (int i=0; i<3; i++) {
            tmp1[i] = Integer.parseInt(st.nextToken());
            tmp2[i] = tmp1[i];
            mindp[i] = tmp1[i];
            maxdp[i] = tmp1[i];
        }
        int num;
        int prev, min = Integer.MAX_VALUE, max = 0;
        for (int i=1; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
            	num = Integer.parseInt(st.nextToken());
            	mindp[j] = Integer.MAX_VALUE;
            	maxdp[j] = 0;
                for (int k = -1; k <= 1; k++) {
                    prev = j+k;
                    if (prev >= 0 && prev < 3) {
                    	mindp[j] = Math.min(mindp[j], tmp1[prev] + num);
                    	maxdp[j] = Math.max(maxdp[j], tmp2[prev] + num);
                    }
                }
            }
            tmp1[0] = mindp[0];
            tmp1[1] = mindp[1];
            tmp1[2] = mindp[2];
            tmp2[0] = maxdp[0];
            tmp2[1] = maxdp[1];
            tmp2[2] = maxdp[2];
        }
        for(int i=0; i<3; i++) {
        	max = Math.max(max, maxdp[i]);
        	min = Math.min(min, mindp[i]);
        }
        System.out.println(max + " " + min);
    }
}