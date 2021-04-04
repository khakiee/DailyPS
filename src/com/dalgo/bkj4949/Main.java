package com.dalgo.bkj4949;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            Stack<String> parentheses = new Stack<String>();
            boolean flag = true;

            String line = br.readLine();

            if (line.equals(".")) break;

            String[] ll = line.split("");

            for (String el: ll) {
                if (el.equals("(") || el.equals("[")) parentheses.push(el);
                if (el.equals(")")) {
                    if (parentheses.isEmpty() || !parentheses.peek().equals("(")) {
                        flag = false;
                        break;
                    } else {
                        parentheses.pop();
                    }
                }
                if (el.equals("]")) {
                    if (parentheses.isEmpty() || !parentheses.peek().equals("[")) {
                        flag = false;
                        break;
                    } else {
                        parentheses.pop();
                    }
                }
            }
            if (!flag) {
                bw.write("no\n");
                continue;
            }

            if (parentheses.isEmpty() && flag) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
