package com.dalgo.bkj2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] arr = new int[M][N];

        for (int ii = 0; ii < K; ii ++) {
            String[] coord = br.readLine().split(" ");
            int startY = Integer.parseInt(coord[0]);
            int startX = Integer.parseInt(coord[1]);
            int endY = Integer.parseInt(coord[2]);
            int endX = Integer.parseInt(coord[3]);

            for (int kk = startX; kk < endX; kk ++) {
                for (int ll = startY; ll < endY; ll ++) {
                    arr[kk][ll] = 1;
                }
            }
        }

        // then

        Queue<Point> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int kk = 0; kk < M; kk ++) {
            for (int ll = 0; ll < N; ll ++) {
                if (arr[kk][ll] > 0) continue;

                int area = 0;
                queue.offer(new Point(kk, ll));
                arr[kk][ll] = 2;

                while (!queue.isEmpty()) {
                    Point current = queue.poll();
                    area += 1;

                    for (int dir = 0; dir < 4; dir ++) {
                        Point tmp = new Point(current.x + dx[dir], current.y + dy[dir]);

                        if (tmp.x < 0 || tmp.y < 0 || tmp.x >= M || tmp.y >= N) continue;
                        if (arr[tmp.x][tmp.y] > 0) continue;

                        queue.offer(tmp);
                        arr[tmp.x][tmp.y] = 2;
                    }
                }
                answer.add(area);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for (int el: answer) {
            System.out.printf("%d ", el);
        }
        System.out.println();
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
