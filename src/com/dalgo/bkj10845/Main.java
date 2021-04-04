package com.dalgo.bkj10845;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int ii = 0; ii < N; ii ++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push")) {
                queue.offer(Integer.parseInt(command[1]));
            } else if (command[0].equals("front")) {
                if (!queue.isEmpty()) {
                    bw.write(Integer.toString(queue.peekFirst()) + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if (command[0].equals("back")) {
                if (!queue.isEmpty()) {
                    bw.write(Integer.toString(queue.peekLast()) + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if (command[0].equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (command[0].equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(Integer.toString(queue.poll()) + "\n");
                }
            } else { //size
                bw.write(Integer.toString(queue.size()) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
