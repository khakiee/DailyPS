package com.dalgo.bkj5397;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] logList = new String[N];

        for (int ii = 0; ii < N; ii ++) {
            logList[ii] = br.readLine();
        }

        for (String log: logList) {
            LinkedList<String> ll = new LinkedList<String>(Arrays.asList(log.split("")));
            ListIterator<String> it = ll.listIterator();

            LinkedList<String> password = new LinkedList<>();
            ListIterator<String> pwIt = password.listIterator();

            while (it.hasNext()) {
                String command = it.next();
                if (command.equals("<")) {
                    if (pwIt.hasPrevious()) {
                        pwIt.previous();
                    }
                } else if (command.equals(">")) {
                    if (pwIt.hasNext()) pwIt.next();
                } else if (command.equals("-")) {
                    if (pwIt.hasPrevious()) {
                        pwIt.previous();
                        pwIt.remove();
                    }
                } else {
                    pwIt.add(command);
                }
            }

            for (String el: password) {
                bw.write(el);
            }
            bw.write("\n");
            bw.flush();
        }
    }
}
