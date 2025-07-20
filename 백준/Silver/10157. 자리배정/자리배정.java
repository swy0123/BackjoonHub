import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int c = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int t = Integer.parseInt(br.readLine());
    	
    	int[][] map = new int[r][c];
    	
    	if(r*c < t) {
        	System.out.println(0);
    		return;
    	}

    	int num = 1;
    	int dir = 0;
    	int[] dy = {1, 0, -1, 0};
    	int[] dx = {0, 1, 0, -1};
    	int[] curPos = {0, 0};
    	
    	int cx, cy;
    	while(t >= num) {
    		cy = curPos[0];
    		cx = curPos[1];
    		if(cy>=0 && cy<r && cx>=0 && cx<c && map[cy][cx]==0) {
    			map[cy][cx] = num;
    			num++;
    		}
    		else{
    			cy = cy-dy[dir];
    			cx = cx-dx[dir];
    			dir = (dir+1)%4;
    		}
    		if(num>t) break;
    		curPos[0] = cy+dy[dir];
    		curPos[1] = cx+dx[dir];

    	}
    	
    	curPos[0]+=1;
    	curPos[1]+=1;
    	System.out.println(curPos[1]+" "+curPos[0]);
    }
}