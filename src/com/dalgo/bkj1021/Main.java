package com.dalgo.bkj1021;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        String[] wants = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<Integer> need = new LinkedList<>();

        int answer = 0;

        for (int ii = 0; ii < M; ii ++) {
            need.add(Integer.parseInt(wants[ii]));
        }

        for (int ii = 0; ii < N; ii ++) {
            arr.offer(ii + 1);
        }

        // then

        while (need.size() > 0) {
            if (need.peek() == arr.peek()) {
                need.poll();
                arr.poll();
                continue;
            }

            int rr = 1;
            int ll = arr.size() - 1;

            while(true) {
                if (arr.get(rr).equals(need.peek()) || arr.get(ll).equals(need.peek())) break;
                rr ++;
                ll --;
            }

            answer += rr;

            while (arr.peek() != need.peek()) {
                arr.offer(arr.poll());
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
