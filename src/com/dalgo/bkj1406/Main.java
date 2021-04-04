package com.dalgo.bkj1406;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        LinkedList<Character> strList = new LinkedList<Character>();
        int N = Integer.parseInt(br.readLine());

        for (int ii = 0; ii < str.length(); ii ++) {
            strList.add(str.charAt(ii));
        }

        ListIterator it = strList.listIterator(strList.size());

        for (int ii = 0; ii < N; ii ++) {
            String inst = br.readLine();

            if(inst.charAt(0) == 'L') {
                if (it.hasPrevious()) it.previous();
            } else if(inst.charAt(0) == 'D') {
                if (it.hasNext()) it.next();
            } else if(inst.charAt(0) == 'B') {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else {
                it.add(inst.charAt(2));
            }
        }

        for(Character el: strList) {
            bw.write(el);
        }
        bw.flush();
        bw.close();
    }
}
