package com.dalgo.bkj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String list = br.readLine();
        int len = list.length();

        int ii = 0;
        int numOfBar = 0;
        int numOfpieces = 0;

        while (ii < len) {
            if (numOfBar == 0 || list.charAt(ii) == '(') {
                numOfBar += 1;
            } else if (list.charAt(ii) == ')') {
                if (list.charAt(ii - 1) == '(') {
                    numOfBar -= 1;
                    numOfpieces += numOfBar;
                } else {
                    numOfBar -= 1;
                    numOfpieces += 1;
                }
            }

            ii ++;
        }

        System.out.println(numOfpieces);
    }
}
