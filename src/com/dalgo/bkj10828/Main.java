package com.dalgo.bkj10828;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack stk = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int ii = 0; ii < N; ii ++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push")) {
                stk.push(Integer.parseInt(command[1]));
            } else if (command[0].equals("pop")) {
                if (stk.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(stk.pop().toString() + "\n");
                }
            } else if (command[0].equals("size")) {
                bw.write(stk.size() + "\n");
            } else if (command[0].equals("empty")) {
                if (stk.empty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else { //top
                if (stk.empty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(stk.peek().toString() + "\n");
                }
            }
            bw.flush();
        }
        bw.close();
    }
}
