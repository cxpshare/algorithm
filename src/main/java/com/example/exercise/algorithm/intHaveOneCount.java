package com.example.exercise.algorithm;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 *
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：5
 *
 * 输出：2
 */
public class intHaveOneCount {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while (n != 0){
            if (n % 2 == 1){
                count += 1;
            }
            n = n / 2;
        }
        System.out.println(count);
    }
}
