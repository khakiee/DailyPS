package com.dalgo.bkj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // get input, init arr and visit, insert tomato=1 to queue

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        boolean[][] visit = new boolean[n][m];
        int[][] arr = new int[n][m];

        LinkedList<Point> queue = new LinkedList<>();

        for (int ii = 0; ii < n; ii ++) {
            String[] line = br.readLine().split(" ");
            for (int jj = 0; jj < m; jj ++) {
                int el = Integer.parseInt(line[jj]);
                arr[ii][jj] = el;

                if (arr[ii][jj] == -1) {
                    visit[ii][jj] = true;
                }

                if (arr[ii][jj] == 1) {
                    queue.offer(new Point(ii, jj, 0));
                    visit[ii][jj] = true;
                }
            }
        }
        // bfs

        int maxDays = 0;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int dir = 0; dir < 4; dir ++) {
                int nextX = tmp.x + dx[dir];
                int nextY = tmp.y + dy[dir];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (arr[nextX][nextY] == 1) continue;
                if (visit[nextX][nextY]) continue;

                queue.offer(new Point(nextX, nextY, tmp.dist + 1));
                visit[nextX][nextY] = true;
                arr[nextX][nextY] = 1;
                maxDays = Math.max(maxDays, tmp.dist + 1);
            }
        }
        // test and get result

        for (int ii = 0; ii < n; ii ++) {
            for (int jj = 0; jj < m; jj ++) {
                if (arr[ii][jj] == 0) {
                    maxDays = -1;
                    break;
                }
            }
        }
        System.out.println(maxDays);
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
