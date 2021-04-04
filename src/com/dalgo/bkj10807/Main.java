package com.dalgo.bkj10807;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[201];
        Scanner sc = new Scanner(System.in);

        // input
        int N = sc.nextInt();

        for (int ii = 0; ii < N; ii ++) {
            int k = sc.nextInt();
            nums[k + 100] += 1;
        }

        int v = sc.nextInt();

        // then
        System.out.println(nums[v + 100]);
    }
}
