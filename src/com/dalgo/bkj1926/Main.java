package com.dalgo.bkj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int ii = 0; ii < n; ii ++) {
            String[] buff = br.readLine().split(" ");

            for (int jj = 0; jj < m; jj ++) {
                arr[ii][jj] = Integer.parseInt(buff[jj]);
                if (arr[ii][jj] == 0) visit[ii][jj] = true;
            }
        }

        // then

        LinkedList<Point> queue = new LinkedList<Point>();
        int maxArea = 0;
        int numOfArea = 0;

        for(int ii = 0; ii < n; ii ++) {
            for (int jj = 0; jj < m; jj ++) {
                if (visit[ii][jj]) continue;

                queue.push(new Point(ii, jj));
                visit[ii][jj] = true;

                numOfArea ++;
                int area = 1;

                while (!queue.isEmpty()) {
                    Point tmp = queue.pop();

                    for (int dir = 0; dir < 4; dir ++) {
                        int nextX = tmp.x + dx[dir];
                        int nextY = tmp.y + dy[dir];

                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                        if (visit[nextX][nextY]) continue;

                        queue.push(new Point(nextX, nextY));
                        visit[nextX][nextY] = true;
                        area ++;
                    }
                }

                maxArea = Math.max(maxArea, area);
            }
        }
        System.out.printf("%d\n%d\n", numOfArea, maxArea);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
