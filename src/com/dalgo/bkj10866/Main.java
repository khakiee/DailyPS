package com.dalgo.bkj10866;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        while (N-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollFirst() + "\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front":
                    if (deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.peekFirst() + "\n");
                    break;
                default: // back
                    if (deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
