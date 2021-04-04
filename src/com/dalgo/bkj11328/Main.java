package com.dalgo.bkj11328;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fail = "Impossible";
        String success = "Possible";

        // get input
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] strList = new String[N];

        for (int ii = 0; ii < N; ii++) {
            strList[ii] = sc.nextLine();
        }

        // then

        for (int ii = 0; ii < N; ii++) {
            String[] lines = strList[ii].split(" ");
            int[] firstEl = new int[26];
            int[] secondEl = new int[26];
            boolean flag = true;

            if (lines[0].length() != lines[1].length()) {
                System.out.println(fail);
                continue;
            }

            for (int kk = 0; kk < lines[0].length(); kk++) {
                int firstIndex = lines[0].charAt(kk) - 'a';
                int secondIndex = lines[1].charAt(kk) - 'a';
                firstEl[firstIndex] += 1;
                secondEl[secondIndex] += 1;
            }

            for (int jj = 0; jj < 26; jj ++) {
                if (firstEl[jj] != secondEl[jj]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(success);
            } else {
                System.out.println(fail);
            }

        }
    }
}
