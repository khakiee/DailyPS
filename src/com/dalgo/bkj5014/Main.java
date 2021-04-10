package com.dalgo.bkj5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int numOfFloors;
    static int start;
    static int target;
    static int up;
    static int down;
    static int[] dy;

    private static String solve() {
        int[] visit = new int[1000001];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visit[start] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == target) {
                return Integer.toString(visit[curr] - 1);
            }

            int nextUp = curr + up;
            int nextDown = curr - down;
            if (nextUp == target || nextDown == target) {
                return Integer.toString(visit[curr]);
            }

            if (nextUp <= numOfFloors && nextUp >= 1 && visit[nextUp] == 0) {
                visit[nextUp] = visit[curr] + 1;
                queue.offer(nextUp);
            }

            if (nextDown <= numOfFloors && nextDown >= 1 && visit[nextDown] == 0) {
                visit[nextDown] = visit[curr] + 1;
                queue.offer(nextDown);
            }
        }

        return "use the stairs";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        numOfFloors = Integer.parseInt(input[0]);
        start = Integer.parseInt(input[1]);
        target = Integer.parseInt(input[2]);
        up = Integer.parseInt(input[3]);
        down = Integer.parseInt(input[4]);

        System.out.println(solve());
    }
}

