import java.util.*;
import java.io.*;
 /*
  * 아시아 정보올림피아드
  */
public class Main {
	static class Node implements Comparable<Node>{
        int c;
        int n;
        int s;
        public Node(int c, int n, int s){
            this.c = c;
            this.n = n;
            this.s = s;
        }
        @Override
        public int compareTo(Node o) {
            return o.s-this.s;
        }
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        int cc, cn, cs;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cc = Integer.parseInt(st.nextToken());
            cn = Integer.parseInt(st.nextToken());
            cs = Integer.parseInt(st.nextToken());
            arr[i] = new Node(cc, cn, cs);
        }
        Arrays.sort(arr);
        
        Node[] ret = new Node[3];
        ret[0] = arr[0];
        ret[1] = arr[1];
        
        if(ret[0].c == ret[1].c) {
        	for(int i=0; i<n; i++) {
        		if(arr[i].c == ret[0].c) continue;
        		ret[2] = arr[i];
        		break;
        	}
        } else {
        	ret[2] = arr[2];
        }
        
        for(int i=0; i<3; i++){
        	sb.append(ret[i].c+" "+ret[i].n).append('\n');
        }
        System.out.println(sb);
    }
}