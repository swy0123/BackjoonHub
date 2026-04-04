import java.util.*;

class Solution {
    private static int SIZE = 102; // 모서리만 연결될 경우 대비 좌표 2배
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    private static int[][] board = new int[SIZE][SIZE];
    private static boolean[][] visited = new boolean[SIZE][SIZE];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    board[y][x] = 0;
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    private int bfs(int startX, int startY, int itemX, int itemY) {
        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{startX, startY, 0});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == itemX && y == itemY) {
                return dist / 2; // 좌표를 2배로 늘렸으므로 다시 2로 나눔
            }

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx>=0 && ny>=0 && nx<SIZE && ny<SIZE){
                    if (visited[ny][nx]) continue;
                    if (board[ny][nx] != 1) continue; // 테두리만 이동 가능

                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                };
            }
        }

        return 0;
    }
}