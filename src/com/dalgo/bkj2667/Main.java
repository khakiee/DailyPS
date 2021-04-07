package com.dalgo.bkj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] visit = new boolean[N][N];

        for(int ii = 0; ii < N; ii ++) {
            String[] line = br.readLine().split("");
            for (int jj = 0; jj < N; jj ++) {
                arr[ii][jj] = Integer.parseInt(line[jj]);
            }
        }

        // then

        Queue<Point> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int ii = 0; ii < N; ii ++) {
            for (int jj = 0; jj < N; jj ++) {
                if (arr[ii][jj] == 0) continue;
                if (visit[ii][jj]) continue;
                queue.offer(new Point(ii, jj));
                visit[ii][jj] = true;

                int areaSize = 0;

                while (!queue.isEmpty()) {
                    Point current = queue.poll();
                    areaSize ++;

                    for (int dir = 0; dir < 4; dir ++) {
                        Point next = new Point(current.x + dx[dir], current.y + dy[dir]);
                        if(next.x < 0 || next.y < 0 || next.x >= N || next.y >= N) continue;
                        if (arr[next.x][next.y] == 0) continue;
                        if (visit[next.x][next.y]) continue;

                        queue.offer(next);
                        visit[next.x][next.y] = true;
                        arr[next.x][next.y] = answer.size() + 1;
                    }

                }
                answer.add(areaSize);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());

        for (int el: answer) {
            System.out.println(el);
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
