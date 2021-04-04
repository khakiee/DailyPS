package com.dalgo.bkj2164;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int pp = 1;

        while(pp < N) {
            pp <<= 1;
        }

        if (pp != N) bw.write(Integer.toString((N << 1) - pp));
        else bw.write(Integer.toString(N));

        bw.flush();
        bw.close();
    }
}
