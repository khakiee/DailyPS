package com.dalgo.bkj7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            String[] cc = br.readLine().split(" ");
            String[] tt = br.readLine().split(" ");

            Point currentKnight = new Point(Integer.parseInt(cc[0]), Integer.parseInt(cc[1]), 0);
            Point target = new Point(Integer.parseInt(tt[0]), Integer.parseInt(tt[1]), 0);

            Queue<Point> queue = new LinkedList<>();
            queue.offer(currentKnight);
            arr[currentKnight.x][currentKnight.y] = -1;

            while (!queue.isEmpty()) {
                Point curr = queue.poll();

                if (curr.x == target.x && curr.y == target.y) {
                    System.out.println(curr.times);
                }

                for (int dir = 0; dir < 8; dir ++) {
                    Point next = new Point(curr.x + dx[dir], curr.y + dy[dir], curr.times + 1);

                    if (next.x < 0 || next.y < 0 || next.x >= N || next.y >= N) continue;
                    if (arr[next.x][next.y] == -1) continue;

                    queue.offer(next);
                    arr[next.x][next.y] = -1;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int times;

        public Point (int x, int y, int times) {
            this.x = x;
            this.y = y;
            this.times = times;
        }
    }
}
