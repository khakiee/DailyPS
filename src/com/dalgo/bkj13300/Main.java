package com.dalgo.bkj13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int numOfStudents = Integer.parseInt(input[0]);
        int maxCapacity = Integer.parseInt(input[1]);

        int[][] countStd = new int[6][2];
        int rooms = 0;

        for (int ii = 0; ii < numOfStudents; ii++) {
            String[] kk = br.readLine().split(" ");
            int sex = Integer.parseInt(kk[0]);
            int grade = Integer.parseInt(kk[1]);

            countStd[grade- 1][sex] += 1;
        }

        for (int ii = 0; ii < 6; ii ++) {
            for (int jj = 0; jj < 2; jj ++) {
                int std = countStd[ii][jj];
                rooms += std / maxCapacity;
                rooms = (std % maxCapacity) > 0 ? rooms + 1 : rooms;
            }
        }

        System.out.println(rooms);

    }
}
