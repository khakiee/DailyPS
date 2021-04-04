package com.dalgo.bkj5430;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int ii = 0; ii < T; ii ++) {
            StringBuilder sb = new StringBuilder();

            String[] command = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());

            String arrInput = br.readLine();

            if (arrInput.equals("[]")) {
                arrInput = "";
            } else {
                arrInput = arrInput.substring(1, arrInput.length() - 1);
            }
            LinkedList<Integer> ll = new LinkedList<>();

            // then

            boolean reverse = false;

            try {
                if (arrInput.length() != 0) {
                    String[] arr = arrInput.split(",");
                    for (int jj = 0; jj < arr.length; jj ++) {
                        ll.offer(Integer.parseInt(arr[jj]));
                    }
                }

                for (int kk = 0; kk < command.length; kk ++) {
                    if(command[kk].equals("R")) {
                        reverse = !reverse;
                    } else if (command[kk].equals("D")) {
                        if (ll.isEmpty()) {
                            throw new Exception();
                        }
                        if (reverse) ll.pollLast();
                        else ll.poll();
                    }
                }

                sb.append("[");

                while(!ll.isEmpty()) {
                    if (reverse) sb.append(ll.pollLast()+ ",");
                    else sb.append(ll.poll()+ ",");
                }

                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }

                sb.append("]\n");
                bw.write(sb.toString());
            } catch (Exception e) {
                bw.write("error\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
