package com.dalgo.bkj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int ii = 0; ii < n; ii ++) {
            String[] buff = br.readLine().split("");

            for (int jj = 0; jj < m; jj ++) {
                arr[ii][jj] = Integer.parseInt(buff[jj]);
                if (arr[ii][jj] == 0) visit[ii][jj] = true;
            }
        }

        LinkedList<Point> queue = new LinkedList<>();
        queue.push(new Point(0, 0, 1));

        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            if (tmp.x == n - 1 && tmp.y == m - 1) {
                minDist = tmp.dist;
                break;
            }

            for (int dir = 0; dir < 4; dir ++) {
                int nextX = tmp.x + dx[dir];
                int nextY = tmp.y + dy[dir];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (visit[nextX][nextY]) continue;

                queue.offer(new Point(nextX, nextY, tmp.dist + 1));
                visit[nextX][nextY] = true;

            }
        }

        System.out.println(minDist);
    }

    static class Point {
        int x;
        int y;
        int dist;

        public Point (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
