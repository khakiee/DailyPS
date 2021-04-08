package com.dalgo.bkj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[0]);

        arr = new int[n][m];
        visit = new boolean[n][m][2];

        for (int ii = 0; ii < n; ii ++) {
            String[] ss = br.readLine().split("");
            for (int jj = 0; jj < m; jj ++) {
                arr[ii][jj] = Integer.parseInt(ss[jj]);
            }
        }

        // then

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0));
        visit[0][0][0] = true;
        visit[0][0][1] = true;

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == n - 1 && curr.y == m - 1) {
                answer = Math.min(answer, curr.time);
            }

            for (int dir = 0; dir < 4; dir ++) {
                Point next = new Point(curr.x + dx[dir], curr.y + dy[dir], curr.time + 1, curr.broke);

                if (next.x < 0 || next.y < 0 || next.x >= n || next.y >= m) continue;
                if (arr[next.x][next.y] == 1) {
                    if (next.broke == 0 && !visit[next.x][next.y][1]) {
                        visit[next.x][next.y][1] = true;
                        next.broke += 1;
                        queue.offer(next);
                    }
                } else {
                    if (!visit[next.x][next.y][next.broke]) {
                        visit[next.x][next.y][next.broke] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(Integer.toString(-1));
            return;
        }
        System.out.println(Integer.toString(answer));
    }

    static class Point {
        int x;
        int y;
        int time;
        int broke;

        public Point (int x, int y, int time, int broke) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.broke = broke;
        }
    }
}
