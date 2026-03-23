
import java.io.*;
import java.util.*;

public class Main{
	static int H_TIME = 10;
	static int L_TIME = 5;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int h = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	
        	int[][] building = new int[h][l];
        	for(int j=0; j<h; j++) {
        		st = new StringTokenizer(br.readLine());
        		for(int k=0; k<l; k++) {
        			building[j][k] = Integer.parseInt(st.nextToken());
        			max = Math.max(max, building[j][k]);
        		}
        	}

            int[] indexs = new int[h];
            for(int j=0; j<h; j++) {
            	indexs[j] = 0;
            }
            int cnt=0;
            
            for(int tmp=1; tmp<=max; tmp++) {
            	for(int r=0; r<h; r++) {
            		for(int c=0; c<l; c++) {
            			if(building[r][c] == tmp) {
            				int front = Math.min(indexs[r], c); // 1
            				int back = Math.max(indexs[r], c); // 4
            				cnt += Math.min(Math.abs(back-front), Math.abs(front+(l-back)))*5 + r*20;
            				indexs[r] = c;
            			}
            		}
            	}
            }
            System.out.println(cnt);
        }
    }
}