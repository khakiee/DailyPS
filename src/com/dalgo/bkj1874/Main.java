package com.dalgo.bkj1874;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stk = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        for (int ii = 0; ii < N; ii++) {
            num[ii] = Integer.parseInt(br.readLine());
        }

        int cnt = 1;
        int len = 0;

        while (len < N) {
            int nn = num[len];

            if (stk.empty()) {
                sb.append("+\n");
                stk.push(cnt);
                cnt ++;
            } else if (stk.peek() < nn) {
                sb.append("+\n");
                stk.push(cnt);
                cnt ++;
            } else if (stk.peek() == nn) {
                sb.append("-\n");
                len += 1;
                stk.pop();
            } else if (stk.peek() > nn) {
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
