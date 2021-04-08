package com.dalgo.bkj5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int w;
    static int h;
    static char[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] fireTime;
    static int[][] sgTime;

    static Queue<Point> sgQueue;
    static Queue<Point> fireQueue;

    private static String bfs() {
        //fire bfs and save time to arr

        while(!fireQueue.isEmpty()) {
            Point cur = fireQueue.poll();

            for (int dir = 0; dir < 4; dir ++) {
                Point next = new Point(cur.x + dx[dir], cur.y + dy[dir], cur.time + 1);
                if (next.x < 0 || next.y < 0 || next.x >= h || next.y >= w) continue;
                if (fireTime[next.x][next.y] > 0) continue;
                if (fireTime[next.x][next.y] == -1) continue;

                fireQueue.offer(next);
                fireTime[next.x][next.y] = next.time;
            }
        }

        while(!sgQueue.isEmpty()) {
            Point cur = sgQueue.poll();

            if (cur.x == 0 || cur.y == 0 || cur.x + 1 == h || cur.y + 1 == w) {
                return Integer.toString(cur.time);
            }

            for (int dir = 0; dir < 4; dir ++) {
                Point next = new Point(cur.x + dx[dir], cur.y + dy[dir], cur.time + 1);
                if (next.x < 0 || next.y < 0 || next.x >= h || next.y >= w) continue;
                if (sgTime[next.x][next.y] > 0) continue;
                if (sgTime[next.x][next.y] == -1) continue;
                if (fireTime[next.x][next.y] != 0 && fireTime[next.x][next.y] <= next.time) continue;

                sgQueue.offer(next);
                sgTime[next.x][next.y] = next.time;
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {

            String[] input = br.readLine().split(" ");

            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            arr = new char[h][w];
            fireTime = new int[h][w];
            sgTime = new int[h][w];

            sgQueue = new LinkedList<>();
            fireQueue = new LinkedList<>();

            for (int ii = 0; ii < h; ii ++) {
                char[] str = br.readLine().toCharArray();
                for (int jj = 0; jj < w; jj ++) {
                    arr[ii][jj] = str[jj];
                    if (str[jj] == '*') {
                        fireQueue.offer(new Point(ii, jj, 1));
                        fireTime[ii][jj] = 1;
                    }
                    if (str[jj] == '@') {
                        sgQueue.offer(new Point(ii, jj, 1));
                        sgTime[ii][jj] = 1;
                    }
                    if (str[jj] == '#') {
                        fireTime[ii][jj] = -1;
                        sgTime[ii][jj] = -1;
                    }
                }
            }

            String ans = bfs();
            System.out.println(ans);
        }
    }

    static class Point {
        int x;
        int y;
        int time;

        public Point (int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
