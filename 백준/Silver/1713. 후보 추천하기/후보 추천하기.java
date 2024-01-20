import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> dic = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	if(dic.containsKey(num)) {
				dic.put(num, dic.get(num)+1);
			}
        	else {
        		if(arr.size()<n) {
        			arr.add(num);
        			dic.put(num, 1);
        		}
        		else {
        			int min = 10000;
        			int minidx = -1;
        			for(int idx=0; idx<arr.size(); idx++) {
        				if(dic.get(arr.get(idx))<min) {
        					min = dic.get(arr.get(idx));
        					minidx = idx;
        				}
        			}
        			dic.remove(arr.get(minidx));
        			arr.remove(minidx);
        			arr.add(num);
        			dic.put(num, 1);
        		}
        	}
        }
        Collections.sort(arr);
        for (Integer integer : arr) {
			System.out.print(integer+" ");
		}
    }
}