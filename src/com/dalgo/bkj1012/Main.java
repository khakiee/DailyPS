package com.dalgo.bkj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {
            String[] input = br.readLine().split(" ");

            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            int[][] arr = new int[N][M];
            boolean[][] visit = new boolean[N][M];

            for (int ii = 0; ii < K; ii ++) {
                String[] line = br.readLine().split(" ");
                int col = Integer.parseInt(line[1]);
                int row = Integer.parseInt(line[0]);

                arr[col][row] = 1;
            }

            // then

            LinkedList<Point> queue = new LinkedList<>();

            int area = 0;

            for (int ii = 0; ii < N; ii ++) {
                for (int jj = 0; jj < M; jj ++) {
                    if (arr[ii][jj] == 1 && !visit[ii][jj]) {
                        queue.push(new Point(ii, jj));
                        visit[ii][jj] = true;
                        area += 1;
                    }

                    while(!queue.isEmpty()) {
                        Point curr = queue.poll();

                        for (int dir = 0; dir < 4; dir ++) {
                            Point next = new Point(curr.x + dx[dir], curr.y + dy[dir]);

                            if (next.x < 0 || next.y < 0 || next.x >= N || next.y >= M) continue;
                            if (arr[next.x][next.y] == 0) continue;
                            if (visit[next.x][next.y]) continue;

                            queue.offer(next);
                            visit[next.x][next.y] = true;
                        }
                    }
                }
            }
            System.out.printf("%d\n", area);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
