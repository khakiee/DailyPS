package com.dalgo.bkj2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] visit = new int[200000];
        Queue<Integer> queue = new LinkedList<>();

        int subin = Integer.parseInt(input[0]);
        int bro = Integer.parseInt(input[1]);

        queue.offer(subin);
        visit[subin] = 1;

        while (visit[bro] == 0) {

            int pos = queue.poll();
            int[] nextArr = {pos - 1, pos + 1, pos * 2};

            for (int next: nextArr) {
                if (next < 0 || next >= visit.length) continue;
                if (visit[next] > 0) continue;
                queue.offer(next);
                visit[next] = visit[pos] + 1;
            }
        }

        System.out.printf("%d", visit[bro] - 1);
    }
}
