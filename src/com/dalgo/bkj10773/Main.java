package com.dalgo.bkj10773;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stk = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());

        for (int ii = 0; ii < N; ii++) {
            int money = Integer.parseInt(br.readLine());

            if (money == 0) {
                stk.pop();
                continue;
            }
            stk.push(money);
        }

        int sum = 0;

        while (!stk.empty()) {
            sum += stk.pop();
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
