import java.io.*;
import java.util.*;

// 숨바꼭질2 12851
public class Main {
	static int min = 100001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = 0;
        int cnt = 0;
        if(n>=m) {
        	time = n-m;
        	cnt = 1;
        }
        else {
        	int[] timeArr = new int[m*2+1];

        	Queue<Integer> q = new ArrayDeque<>();
        	q.add(n);
        	timeArr[n] = 1;
        	while(!q.isEmpty()) {
        		int cn = q.poll();

        		if(min < timeArr[cn]) {
        			break;
        		};
        		if(cn-1>=0) {
        			if(cn-1 == m) {
        				min = timeArr[cn];
        				cnt++;
        			}
        			if(timeArr[cn-1]==0 || timeArr[cn-1] == timeArr[cn]+1) {
        				timeArr[cn-1] = timeArr[cn]+1;
            			q.add(cn-1);
            		}
        		}
        		if(cn+1<timeArr.length) {
        			if(cn+1 == m) {
        				min = timeArr[cn];
        				cnt++;
        			}
        			if(timeArr[cn+1]==0 || timeArr[cn+1] == timeArr[cn]+1) {
        				timeArr[cn+1] = timeArr[cn]+1;
        				q.add(cn+1);
        			}
        		}
        		if(cn*2>0 && cn*2<timeArr.length) {
        			if(cn*2 == m) {
        				min = timeArr[cn];
        				cnt++;
        			}
        			if(timeArr[cn*2]==0 || timeArr[cn*2] == timeArr[cn]+1) {
        				timeArr[cn*2] = timeArr[cn]+1;
        				q.add(cn*2);
        			}
        		}

        	}
        	
        	time = min;
        	
        }
        System.out.println(time);
        System.out.println(cnt);
    }
}