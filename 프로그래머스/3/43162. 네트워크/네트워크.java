class Solution {
    private void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;

        for (int next = 0; next < computers.length; next++) {
            if (computers[node][next] == 1 && !visited[next]) {
                dfs(next, computers, visited);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                count++;
            }
        }

        return count;
    }
}