import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int topItemCnt = n%w;
        int height = topItemCnt>0 ? n/w + 1 : n/w;
        int curX=0, curY=0;
        
        int[][] map = new int[height][w];
        int idx = 1;
        for(int i=0; i<height; i++){
            if(i%2==0){
                for(int j=0; j<w; j++){
                    if(idx>n) break;
                    map[i][j] = idx++;
                    if(map[i][j] == num) {
                        curX = j;
                        curY = i;
                    }
                }
            }
            else if(i%2==1){
                for(int j=0; j<w; j++){
                    if(idx>n) break;
                    map[i][w-j-1] = idx++;
                    if(map[i][w-j-1] == num) {
                        curX = w-j-1;
                        curY = i;
                    }
                }
            }
            
        }
        for(int i=curY; i<height; i++){
            if(map[i][curX] == 0) break;
            answer++;
        }
        
        
        return answer;
    }
}