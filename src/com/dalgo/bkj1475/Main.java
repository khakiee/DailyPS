package com.dalgo.bkj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] nums = new int[9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        for (String el: num.split("")) {
            int ii = Integer.parseInt(el);
            if (ii == 9) {
                nums[6] += 1;
                continue;
            }
            nums[ii] += 1;
        }

        int setCount = 0;

        for (int ii = 0; ii < 9; ii++) {
            if (ii == 6) {
                nums[ii] = (nums[ii] % 2) > 0 ? nums[ii] / 2 + 1 : nums[ii] / 2;
            }
            setCount = Math.max(nums[ii], setCount);
        }
        System.out.println(setCount);
    }
}
