package cn.com.offcn.test.dijkstra;

import java.util.PriorityQueue;

public class Solution {
    final static int INF = 0x3f3f3f3f;
    final static int[][] dis = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    //根据方向和出发点的值确定边的权值(就是指向不对就返回1，指向和方向一致就是1)
    int weight(char u, int dest) {
        switch (u) {
            case '^':
                return dest == 0 ? 0 : 1;
            case 'v':
                return dest == 1 ? 0 : 1;
            case '<':
                return dest == 2 ? 0 : 1;
            case '>':
                return dest == 3 ? 0 : 1;
        }
        return 0;
    }

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int m = matrix.length, n = matrix[0].length();
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dist[i][j] = INF;
            }
        }
        boolean[][] vis = new boolean[m][n];
        //int[3] 0: 从start开始的距离 1: 行 2: 列
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        dist[start[0]][start[1]] = 0;
        q.add(new int[]{0,start[0],start[1]});
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int d = pair[0], x = pair[1], y = pair[2];
            if(vis[x][y]) continue;
            vis[x][y] = true;
            for(int i = 0;i < 4;++i){
                int nx = dis[i][0] + x,ny = dis[i][1] + y;
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    int newDistance = d + weight(matrix[x].charAt(y),i);
                    if(newDistance < dist[nx][ny]){
                        dist[nx][ny] = newDistance;
                        q.add(new int[]{newDistance,nx,ny});
                    }
                }
            }
        }
        return dist[end[0]][end[1]];
    }
}
