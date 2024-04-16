import java.util.*;
import java.lang.*;

class Solution {
    static class pos implements Comparable<pos>{
        int x, y, number;
        public pos(int x, int y, int number){
            this.x = x;
            this.y = y;
            this.number = number;
        }
        @Override
        public int compareTo(pos o){
            if(this.y!=o.y) return o.y-this.y;
            return this.x-o.x;
        }
        @Override
        public String toString(){
            return this.x+" "+this.y+" "+this.number;
        }
    }
    static class node{
        int number, left, center, right;
        node prev;
        ArrayList<node> nextList = new ArrayList();
        public node(int number, int left, int center, int right, node prev, node next){
            this.number = number;
            this.left = left;
            this.center = center;
            this.right = right;
            this.prev = prev;
            if(next!=null) nextList.add(next);
        }
    }
    static PriorityQueue<pos> pq;
    static ArrayList<ArrayList<pos>> arr;
    static ArrayList<Integer> pre = new ArrayList();
    static ArrayList<Integer> post = new ArrayList();
    static ArrayList<ArrayList<node>> list;
    public int[][] solution(int[][] nodeinfo) {
        pq = new PriorityQueue();
        ArrayList<ArrayList<pos>> tree = new ArrayList<ArrayList<pos>>();
        
        for(int i=0; i<nodeinfo.length; i++){
            pq.add(new pos(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        int level = -1;
        int cnt = -1;
        while(!pq.isEmpty()){
            pos cp = pq.poll();
            if(level!=cp.y) {
                tree.add(new ArrayList<pos>());
                level = cp.y;
                cnt++;
            }
            tree.get(cnt).add(cp);
        }
        // for(int i=arr.size(); i>=0; i--){
        //     if(arr.get(i).size()>0){
        //         tree.add(arr.get(i));
        //         continue;
        //     }
        // }
        
        node start = new node(tree.get(0).get(0).number, 0, tree.get(0).get(0).x, Integer.MAX_VALUE, null, null);
        list = new ArrayList<ArrayList<node>>();
        for(int i=0; i<tree.size(); i++){
            list.add(new ArrayList<node>());
            if(i==0){
                list.get(i).add(start);
                continue;
            }
            int prevIdx = 0;
            node curRange = list.get(i-1).get(prevIdx);
            for(int j=0; j<tree.get(i).size(); j++){
                pos cp = tree.get(i).get(j);
                // System.out.println("------------ "+cp.toString());
                if(cp.x>=curRange.left && cp.x<=curRange.right){
                    if(cp.x<curRange.center){
                        list.get(i).add(new node(cp.number, curRange.left, cp.x, curRange.center, curRange, null));
                        curRange.nextList.add(list.get(i).get(list.get(i).size()-1));
                    }
                    else{
                        list.get(i).add(new node(cp.number, curRange.center, cp.x, curRange.right, curRange, null));
                        curRange.nextList.add(list.get(i).get(list.get(i).size()-1));
                    }
                }
                else{
                    prevIdx++;
                    if(prevIdx>=list.get(i-1).size()) continue;
                    j--;
                    curRange = list.get(i-1).get(prevIdx);
                }
            }
        }
        
        preOrder(start);
        postOrder(start);
        
        int[][] answer = new int[2][pre.size()];
        for(int i=0; i<pre.size(); i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        // System.out.println(pre.toString());
        // System.out.println(post.toString());
        
        return answer;
    }
    
    private static void preOrder(node cn){
        pre.add(cn.number);
        for(int i=0; i<cn.nextList.size(); i++){
            preOrder(cn.nextList.get(i));
        }
    }
    private static void postOrder(node cn){
        for(int i=0; i<cn.nextList.size(); i++){
            postOrder(cn.nextList.get(i));
        }
        post.add(cn.number);
    }
}