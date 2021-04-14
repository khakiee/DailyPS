package com.dalgo.bkj17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Main {

    static final int MAX_ARR_SIZE = 500001;
    static int n;
    static int k;
    static int[][] visit = new int[2][MAX_ARR_SIZE];

    private static void markSubinPosition() {
        Arrays.fill(visit[0], -1);
        Arrays.fill(visit[1], -1);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(n, 0));
        visit[0][n] = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int next: new int[]{current.n + 1, current.n - 1, current.n * 2}) {
                int timeNow = current.time + 1;
                int oddOrEven = timeNow % 2;

                if (next < 0 || next >= MAX_ARR_SIZE) continue;
                if (visit[oddOrEven][next] != -1) continue;

                queue.offer(new Point(next, timeNow));
                visit[oddOrEven][next] = timeNow;
            }
        }
    }

    private static String getAnswer () {
        int time = 0;

        while (k < MAX_ARR_SIZE) {
            int isOddOrEven = time % 2;

            if (visit[isOddOrEven][k] != -1 && visit[isOddOrEven][k] <= time) {
                return Integer.toString(time);
            }

            time ++;
            k += time;
        }

        return "-1";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        markSubinPosition();
        System.out.println(getAnswer());

    }

    static class Point {
        int n;
        int time;

        public Point (int n, int time) {
            this.n = n;
            this.time = time;
        }
    }
}
