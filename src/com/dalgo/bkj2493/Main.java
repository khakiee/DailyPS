package com.dalgo.bkj2493;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N];
        String[] input = br.readLine().split(" ");

        for (int ii = 0; ii < N; ii ++) {
            towers[ii] = Integer.parseInt(input[ii]);
        }

        // then

        ArrayList<Integer> stk = new ArrayList<Integer>();
        stk.add(0);
        sb.append("0 ");

        for (int ii = 1; ii < N; ii ++) {
            int top = stk.size() - 1;

            while (true) {
                if (top == -1) {
                    stk.add(ii);
                    break;
                }

                int tt = towers[stk.get(top)];
                if (tt >= towers[ii]) {
                    sb.append((stk.get(top) + 1) + " ");
                    stk.add(ii);
                    break;
                } else if (tt < towers[ii]) {
                    stk.remove(top);
                }
                top --;
            }
            if (top == -1) sb.append("0 ");
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }
}
