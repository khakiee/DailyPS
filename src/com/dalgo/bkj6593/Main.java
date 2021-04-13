package com.dalgo.bkj6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int l;
    static int r;
    static int c;
    static char[][][] arr;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static Point start;
    static Point end;

    private static String solve(int[][][] visit) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(start);
        visit[start.z][start.x][start.y] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == end.x && cur.y == end.y && cur.z == end.z) {
                return "Escaped in " + Integer.toString(cur.time) + " minute(s).";
            }

            for (int dir = 0; dir < 6; dir ++) {
                Point next = new Point(cur.z + dz[dir], cur.x + dx[dir], cur.y + dy[dir], cur.time + 1);

                if (next.z < 0 ||next.x < 0 || next.y < 0 || next.z >= l || next.x >= r || next.y >= c) continue;
                if (arr[next.z][next.x][next.y] == '#') continue;
                if (visit[next.z][next.x][next.y] >= 0) continue;

                queue.offer(next);
                visit[next.z][next.x][next.y] = cur.time;
            }
        }
        return "Trapped!";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            String[] testCase = br.readLine().split(" ");

            l = Integer.parseInt(testCase[0]);
            r = Integer.parseInt(testCase[1]);
            c = Integer.parseInt(testCase[2]);

            if (l == 0 && r == 0 && c == 0) return;

            int[][][] visit = new int[l][r][c];
            arr = new char[l][r][c];

            for (int kk = 0; kk < l; kk ++) {
                for (int ii = 0; ii < r; ii++) {
                    char[] line = br.readLine().toCharArray();
                    if (line.length == 0) line = br.readLine().toCharArray();
                    for (int jj = 0; jj < c; jj++) {
                        arr[kk][ii][jj] = line[jj];
                        visit[kk][ii][jj] = -1;
                        if (arr[kk][ii][jj] == 'S') {
                            start = new Point(kk, ii, jj, 0);
                        }
                        if (arr[kk][ii][jj] == 'E') {
                            end = new Point(kk, ii, jj, 0);
                        }
                    }
                }
            }

            System.out.println(solve(visit));
            br.readLine();
        } while (!(l == 0 && r == 0 && c == 0));
    }

    static class Point {
        int x;
        int y;
        int z;
        int time;

        public Point (int z, int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
}
