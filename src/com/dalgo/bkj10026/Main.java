package com.dalgo.bkj10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        boolean[][] visitNormal = new boolean[N][N];
        boolean[][] visitColorWeakness = new boolean[N][N];

        for (int ii = 0; ii < N; ii ++) {
            char[] line = br.readLine().toCharArray();
            for (int jj = 0; jj < N; jj ++) {
                arr[ii][jj] = line[jj];
            }
        }

        Queue<Point> queue = new LinkedList<>();
        int colorWeakness = 0;
        int normal = 0;

        for (int ii = 0; ii < N; ii ++) {
            for (int jj = 0; jj < N; jj ++) {
                char currentColor = arr[ii][jj];

                // do bfs for normal
                if (!visitNormal[ii][jj]) {
                    queue.offer(new Point(ii, jj));
                    visitNormal[ii][jj] = true;
                    normal ++;

                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();

                        for (int dir = 0; dir < 4; dir ++) {
                            Point next = new Point(cur.x + dx[dir], cur.y + dy[dir]);

                            if (next.x < 0 || next.y < 0 || next.x >= N || next.y >= N) continue;
                            if (arr[next.x][next.y] != currentColor) continue;
                            if (visitNormal[next.x][next.y]) continue;

                            queue.offer(next);
                            visitNormal[next.x][next.y] = true;
                        }
                    }
                }

                // do bfs for colorWeakness
                if (!visitColorWeakness[ii][jj]) {
                    queue.offer(new Point(ii, jj));
                    visitColorWeakness[ii][jj] = true;
                    colorWeakness ++;

                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();

                        for (int dir = 0; dir < 4; dir ++) {
                            Point next = new Point(cur.x + dx[dir], cur.y + dy[dir]);

                            if (next.x < 0 || next.y < 0 || next.x >= N || next.y >= N) continue;
                            if (visitColorWeakness[next.x][next.y]) continue;

                            if (currentColor == 'B' && arr[next.x][next.y] != 'B') continue;
                            if ((currentColor == 'G' || currentColor == 'R') && arr[next.x][next.y] == 'B') continue;

                            queue.offer(next);
                            visitColorWeakness[next.x][next.y] = true;
                        }
                    }
                }

            }
        }

        System.out.println(Integer.toString(normal));
        System.out.println(Integer.toString(colorWeakness));
    }

    static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
