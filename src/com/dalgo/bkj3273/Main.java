package com.dalgo.bkj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String[] numsString = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());

        int[] savedNum = new int[2000001];

        for (int ii = 0; ii < size; ii ++) {
            int num = Integer.parseInt(numsString[ii]);
            savedNum[num] += 1;
        }

        int answer = 0;

        for (int ii = 0; ii < savedNum.length; ii ++) {
            if (x - ii <= ii) break;
            if (savedNum[ii] > 0 && savedNum[x - ii] > 0) {
                answer += savedNum[ii] * savedNum[x - ii];
            }
        }

        System.out.println(answer);
    }
}
