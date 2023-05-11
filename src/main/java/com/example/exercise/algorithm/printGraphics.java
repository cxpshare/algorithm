package com.example.exercise.algorithm;

import java.util.Scanner;

public class printGraphics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            printShape(n);
        }
    }

    private static void printShape(int n) {
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Math.abs(mid - i); j++) { // 打印空格
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (mid - Math.abs(mid - i)) + 1; j++) { // 打印星号
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
