package com.dalgo.bkj4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[0]);

        char[][] arr = new char[c][r];
        int[][] fireArr = new int[c][r];

        Queue<Point> jhQueue = new LinkedList<>();
        Queue<Point> firequeue = new LinkedList<>();

        for (int ii = 0; ii < c; ii ++) {
            char[] row = br.readLine().toCharArray();
            for (int jj = 0; jj < r; jj ++) {
                char el = row[jj];
                if (el == '#') {
                    fireArr[ii][jj] = -1;
                }
                if (el == 'J') jhQueue.offer(new Point(ii, jj, 1));
                if (el == 'F') {
                    firequeue.offer(new Point(ii, jj, 1));
                    fireArr[ii][jj] = 1;
                }
                arr[ii][jj] = el;
            }
        }

        // bfs for fire
        while (!firequeue.isEmpty()) {
            Point fire = firequeue.poll();

            // bfs for fire
            for (int dir = 0; dir < 4; dir ++) {
                Point nextFire = new Point(fire.x + dx[dir], fire.y + dy[dir], fire.time + 1);

                if (nextFire.x >= c || nextFire.y >= r || nextFire.x < 0 || nextFire.y < 0) continue;
                if (fireArr[nextFire.x][nextFire.y] == -1 || fireArr[nextFire.x][nextFire.y] > 0) continue;

                firequeue.offer(nextFire);
                fireArr[nextFire.x][nextFire.y] = nextFire.time;
            }
        }

        // bfs for jh
        while (!jhQueue.isEmpty()) {

            Point jh = jhQueue.poll();

            if (jh.x + 1 == c || jh.x == 0 || jh.y + 1 == r || jh.y == 0) {
                System.out.println(jh.time);
                return;
            }

            for (int dir = 0; dir < 4; dir ++) {
                Point nextJh = new Point(jh.x + dx[dir], jh.y + dy[dir], jh.time + 1);

                if (nextJh.x < 0 || nextJh.y < 0 || nextJh.x >= c || nextJh.y >= r) continue;
                if (arr[nextJh.x][nextJh.y] == 'J') continue;
                if (fireArr[nextJh.x][nextJh.y] != 0 && nextJh.time >= fireArr[nextJh.x][nextJh.y]) continue;

                jhQueue.offer(nextJh);
                arr[nextJh.x][nextJh.y] = 'J';
            }
        }

        System.out.println("IMPOSSIBLE");
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
