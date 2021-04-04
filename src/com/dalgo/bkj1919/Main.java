package com.dalgo.bkj1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] source = br.readLine().toCharArray();
        char[] compare = br.readLine().toCharArray();

        int[] sourceUsed = new int[26];
        int[] compareUsed = new int[26];

        int diff = 0;

        for (int ii = 0; ii < source.length; ii++) {
            int sourceIdx = source[ii] - 'a';
            sourceUsed[sourceIdx] += 1;
        }

        for (int ii = 0; ii < compare.length; ii++) {
            int compareIdx = compare[ii] - 'a';
            compareUsed[compareIdx] += 1;
        }

        for (int ii = 0; ii < 26; ii ++) {
            diff += Math.abs(sourceUsed[ii] - compareUsed[ii]);
        }

        System.out.println(diff);

    }
}
