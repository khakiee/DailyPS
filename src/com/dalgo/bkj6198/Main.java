package com.dalgo.bkj6198;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stk = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());

        // then
        long cnt = 0;

        for (int ii = 0; ii < N; ii ++) {
            int rr = Integer.parseInt(br.readLine());
            while (!stk.empty() && stk.peek() <= rr) {
                stk.pop();
            }
            cnt += stk.size();
            stk.push(rr);
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }
}
