package com.dalgo.bkj10808;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] countOfAlphabets = new int[26];
        int valueOfA = (int)'a';

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        for (char el : S.toCharArray()) {
            int index = el - valueOfA;
            countOfAlphabets[index] += 1;
        }

        for (int el : countOfAlphabets) {
            System.out.print(String.format("%d", el) + " ");
        }
    }
}
