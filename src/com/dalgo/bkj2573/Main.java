package com.dalgo.bkj2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static int checkChunks() {
        int[][] visit = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        int numOfChunks = 0;

        for (int ii = 0; ii < n; ii ++) {
            for (int kk = 0; kk < m; kk ++) {
                if (arr[ii][kk] == 0) continue;
                if (visit[ii][kk] == 1) continue;
                queue.offer(new Point(ii, kk));
                visit[ii][kk] = 1;
                numOfChunks += 1;

                while (!queue.isEmpty()) {
                    Point curr = queue.poll();

                    for (int dir = 0; dir < 4; dir ++) {
                        Point next = new Point(curr.x + dx[dir], curr.y + dy[dir]);
                        if (next.x < 0 || next.y < 0 || next.x >= n || next.y >= m) continue;
                        if (arr[next.x][next.y] == 0) continue;
                        if (visit[next.x][next.y] == 1) continue;

                        queue.offer(next);
                        visit[next.x][next.y] = 1;
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
        return numOfChunks;
    }

    private static void melt() {
        int[][] tmp = new int[n][m];

        for (int ii = 0; ii < n; ii ++) {
            for (int kk = 0; kk < m; kk ++) {
                if (arr[ii][kk] == 0) continue;

                int numOfIces = 0;

                for (int dir = 0; dir < 4; dir ++) {
                    int nextX = ii + dx[dir];
                    int nextY = kk + dy[dir];
                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                    if (arr[nextX][nextY] == 0) numOfIces += 1;
                }

                tmp[ii][kk] = arr[ii][kk] <= numOfIces ? 0 : arr[ii][kk] - numOfIces;
            }
        }

        arr = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n][m];

        for (int ii = 0; ii < n; ii ++) {
            String[] line = br.readLine().split(" ");
            for (int kk = 0; kk < m; kk ++) {
                arr[ii][kk] = Integer.parseInt(line[kk]);
            }
        }


        int years = 0;

        while (true) {
            // check and count chunks
            int numOfChunks = checkChunks();

            if (numOfChunks == 0) {
                System.out.println("0");
                return;
            }
            if (numOfChunks >= 2) {
                System.out.println(Integer.toString(years));
                return;
            }
            melt();

            years ++;
        }
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
