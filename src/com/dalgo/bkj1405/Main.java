package com.dalgo.bkj1405;

import java.io.*;


public class Main {
    static boolean[][] arr = new boolean[30][30];
    static double result = 0;
    static int N = 0;
    static double[] percentage = new double[4];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);

        for (int ii = 1; ii < 5; ii ++) {
            percentage[ii - 1] = Integer.parseInt(input[ii]) * 0.01;
        }

        dfs(15, 15, 1, 0);
        bw.write(Double.toString(result));
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, double pp, int depth) {
        arr[x][y] = true;

        if (depth == N) {
            result += pp;
            return;
        }

        for (int ii = 0; ii < 4; ii ++) {
            if (!arr[x + dx[ii]][y + dy[ii]]) {
                dfs(x + dx[ii], y + dy[ii], pp * percentage[ii], depth + 1);
                arr[x + dx[ii]][y + dy[ii]] = false;
            }
        }
    }
}
