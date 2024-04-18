import java.util.*;
import java.lang.*;

class Solution {
    static class value {
        long go, stay;
        public value(long go, long stay){
            this.go = go;
            this.stay = stay;
        }
        @Override
        public String toString(){
            return this.go+" "+this.stay;
        }
    }
    static class node {
        int idx, sales, go, stay, prev;
        ArrayList<Integer> nexts = new ArrayList();
        public node(int idx, int sales){
            this.idx = idx;
            this.sales = sales;
        }
        @Override
        public String toString(){
            return this.idx+" "+this.sales+" "+this.prev+" "+this.nexts.toString();
        }
    }
    static node[] arr;
    static boolean[] v;
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        arr = new node[sales.length+1];
        
        for(int i=0; i<sales.length; i++){
            arr[i+1] = new node(i+1, sales[i]);
        }
        
        for(int i=0; i<links.length; i++){
            int from = links[i][0];
            int to = links[i][1];
            arr[from].nexts.add(to);
            arr[to].prev = from;
        }
        value cur = postorder(1);
        // System.out.println(cur.toString());
        // for(int i=1; i<arr.length; i++){
        //     System.out.println(arr[i].toString());
        // }
        if(cur.go>cur.stay) answer = (int)cur.stay;
        else answer = (int)cur.go;
        
        return answer;
    }
    
    private static value postorder(int root){
        if(arr[root].nexts.size()==0){
            return new value(arr[root].sales, 0);
        }
        long go = arr[root].sales; //자식들의 stay의 합을 더함
        long stay = 0; //자식 중 go 1개 + 나머지 stay 값 합
        long min = Integer.MAX_VALUE;
        boolean canStay = false;
        
        // System.out.println(arr[root].nexts.toString());
        for(int i=0; i<arr[root].nexts.size(); i++){
            int curIdx = arr[root].nexts.get(i);
            value cur = postorder(curIdx);
            go += cur.stay;
            if(cur.go<cur.stay){
                stay+=cur.go;
                canStay = true;
            }
            else{
                stay += cur.stay;
            }
            min = Math.min(min, cur.go-cur.stay);
        }
        // System.out.println("-------"+stay);
        if(!canStay) stay += min;
        if(go>stay+arr[root].sales){ //갔을때가 안간거+자기자신 보다 안좋으면 감
            go = stay+arr[root].sales;
        }
        // System.out.println(max+" "+go+" "+stay);
        return new value(go, stay);
    };
}