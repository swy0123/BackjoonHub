import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(friends[i], i);

        int[][] giveMap = new int[n][n];
        int[] score = new int[n];

        for (String g : gifts) {
            String[] parts = g.split(" ");
            String from = parts[0];
            String to = parts[1];

            int a = idx.get(from);
            int b = idx.get(to);

            giveMap[a][b]++;
            score[a]++;
            score[b]--;
        }

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int give = giveMap[i][j];
                int receive = giveMap[j][i];

                if (give > receive) {
                    next[i]++;
                } else if (receive > give) {
                    next[j]++;
                } else {
                    if (score[i] > score[j]) next[i]++;
                    else if (score[j] > score[i]) next[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < next.length; i++) {
            if (next[i] > ans) {
                ans = next[i];
            }
        }
        return ans;
    }
}