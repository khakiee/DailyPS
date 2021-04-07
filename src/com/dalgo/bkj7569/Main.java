package com.dalgo.bkj7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dz = {1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int H = Integer.parseInt(input[2]);

        int[][][] arr = new int[H][N][M];
        boolean flag = false;

        Queue<Point> queue = new LinkedList<>();

        for (int ii = 0; ii < H; ii ++) {
            for (int jj = 0; jj < N; jj ++) {
                String[] line = br.readLine().split(" ");
                for (int kk = 0; kk < M; kk ++) {
                    int el = Integer.parseInt(line[kk]);
                    if (el == 0) flag = true;
                    arr[ii][jj][kk] = Integer.parseInt(line[kk]);
                    if (arr[ii][jj][kk] == 1) queue.offer(new Point(ii,jj,kk,0));
                }
            }
        }

        // all tomato is well-done
        if (!flag) {
            System.out.println(0);
            return;
        }

        // bfs

        while(!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int ud = 0; ud < 2; ud ++) {
                Point next = new Point(curr.z + dz[ud], curr.x, curr.y, curr.time + 1);
                if (next.z < 0 || next.z >= H) continue;


                int nextEl = arr[next.z][next.x][next.y];
                if (nextEl == -1) continue;
                if (nextEl > 0) continue;

                queue.offer(next);
                arr[next.z][next.x][next.y] = next.time;
            }

            for (int dir = 0; dir < 4; dir ++) {
                Point next = new Point(curr.z, curr.x + dx[dir], curr.y + dy[dir], curr.time + 1);
                if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= M) continue;

                int nextEl = arr[next.z][next.x][next.y];
                if (nextEl == -1) continue;
                if (nextEl > 0) continue;

                queue.offer(next);
                arr[next.z][next.x][next.y] = next.time;
            }
        }

        // check array

        int maxTime = 0;

        for (int ii = 0; ii < H; ii ++) {
            for (int jj = 0; jj < N; jj ++) {
                for (int kk = 0; kk < M; kk ++) {
                    if (arr[ii][jj][kk] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxTime = Math.max(maxTime, arr[ii][jj][kk]);
                }
            }
        }

        System.out.println(maxTime);
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
