import java.util.*;
import java.io.*;

public class Main {
	static class node {
		int num, dir;
		public node(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
	}
	static ArrayList<ArrayDeque<Character>> list;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList();
        for(int i=0; i<4; i++) {
        	String str = br.readLine();
        	list.add(new ArrayDeque());
        	for(int j=0; j<8; j++) {
        		list.get(i).add(str.charAt(j));
        	}
        }
        
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	lotate(n, d);
        }
        int ret = 0;

    	for(int i=0; i<4; i++) {
    		Character[] arr = list.get(i).toArray(new Character[0]);
    		if(arr[0]=='1') {
    			ret+=Math.pow(2, i);
    		}
        }
		System.out.println(ret);
    }
    private static void lotate(int num, int dir) {
    	Queue<node> q = new ArrayDeque<>();
    	q.add(new node(num, dir));
    	boolean[] v = new boolean[4];
    	v[num-1] = true;
    	while(!q.isEmpty()) {
    		node cn = q.poll();
    		//인접 값 회전
    		Character[] arr = list.get(cn.num-1).toArray(new Character[0]);
    		if(cn.num>1) {
    			Character[] next = list.get(cn.num-2).toArray(new Character[0]);
    			if(arr[6]!=next[2] && !v[cn.num-2]) {
    				v[cn.num-2] = true;
    				q.add(new node(cn.num-1, -cn.dir));
    			}
    		}
    		if(cn.num<4) {
    			Character[] next = list.get(cn.num).toArray(new Character[0]);
    			if(arr[2]!=next[6] && !v[cn.num]) {
    				v[cn.num] = true;
    				q.add(new node(cn.num+1, -cn.dir));
    			}
    		}
    		
    		//시계방향
    		if(cn.dir == 1) {
    			list.get(cn.num-1).addFirst(list.get(cn.num-1).pollLast());
    		}
    		//시계반대방향
    		else {
    			list.get(cn.num-1).addLast(list.get(cn.num-1).pollFirst());
    		}
    		
    	}
    }
}