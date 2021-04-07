package com.dalgo.bkj9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] std = new int[N + 1];
            int[] indegree = new int[N + 1];

            String[] selectList = br.readLine().split(" ");
            for (int ii = 1; ii < N + 1; ii ++) {
                std[ii] = Integer.parseInt(selectList[ii - 1]);
                indegree[std[ii]] ++;
            }

            //then
            LinkedList<Integer> queue = new LinkedList<>();
            int answer = 0;

            for (int ii = 1; ii < N + 1; ii ++) {
                if (indegree[ii] == 0) queue.offer(ii);
            }

            while(!queue.isEmpty()) {
                int current = queue.poll();
                int next = std[current];
                indegree[next] -= 1;
                if (indegree[next] == 0) queue.offer(next);
                answer ++;
            }

            System.out.println(answer);
        }
    }
}
