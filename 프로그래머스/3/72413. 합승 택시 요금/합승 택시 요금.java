import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i], 100000000);
        }
        
        for(int i=0; i<fares.length; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            dist[from][to] = cost;
            dist[to][from] = cost;
        }
        for(int i=1; i<=n; i++){
            dist[i][i] = 0;
        }
        for(int mid=1; mid<=n; mid++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][mid]+dist[mid][j]);
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, dist[s][i]+dist[i][a]+dist[i][b]);
            System.out.println(answer);
        }
        return answer;
    }
}