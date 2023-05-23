package com.example.exercise.algorithm;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class sodaBottle {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.isEmpty() || s.equals("0")) break;
            int num = Integer.parseInt(s);
            if (num < 2) {
                System.out.println(0);
            } else {
                System.out.println(getNum(num));
            }
        }
    }

    private static int getNum(int n) {
        int result = 0;
        while (n > 2) {
            result += n / 3;
            n = n / 3 + n % 3;
        }
        if (n == 2) {
            return ++result;
        } else {
            return result;
        }
    }
}
