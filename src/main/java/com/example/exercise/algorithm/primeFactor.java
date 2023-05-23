package com.example.exercise.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 质数因子
 *
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 数据范围：1 ≤ n ≤ 2 × 10^9 + 14
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * 示例1
 * 输入：180

 * 输出：2 2 3 3 5
 */
public class primeFactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        while ( x != 1) {
            for (int i = 2; i <= x; i++) {
                if (x % i == 0) {
                    System.out.print(i + " ");
                    x = x / i;
                    break;
                }
            }
        }
    }
}
