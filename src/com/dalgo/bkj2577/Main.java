package com.dalgo.bkj2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] usedEl = new int[10];
        int mul = 1;

        // get input
        Scanner sc = new Scanner(System.in);

        for (int ii = 0; ii < 3; ii ++) {
            int k = sc.nextInt();
            mul *= k;
        }

        // then
        for (String el : Integer.toString(mul).split("")) {
            usedEl[Integer.parseInt(el)] += 1;
        }

        for (int el : usedEl) {
            System.out.println(el);
        }
    }
}
