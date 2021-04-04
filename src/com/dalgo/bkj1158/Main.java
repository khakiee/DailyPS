package com.dalgo.bkj1158;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int ii = 0; ii < N; ii ++) {
            list.addLast(ii + 1);
        }

        ListIterator<Integer> it = list.listIterator();

        sb.append("<");

        while (!list.isEmpty()) {
            int index = 0;

            for (int ii = 0; ii < K; ii ++) {
                if (!it.hasNext()) {
                    it = list.listIterator();
                    index = it.next();
                } else {
                    index = it.next();
                }
            }
            sb.append(index + ", ");
            it.remove();
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }
}
